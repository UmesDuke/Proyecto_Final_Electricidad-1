/*
 * Copyright 2022 wil.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package gt.edu.meso.framework;

import com.jme3.util.SafeArrayList;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferStrategy;

/**
 * Clase encargado de generar un simulador, donde podemos graficar
 * cualquier objeto con la API 2D de Java.
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
public class Simulation implements Renderer {

    /** El factor de conversión de nano a base */
    public static final double NANO_TO_BASE = 1.0e9;

    /** El lienzo al que dibujar */
    protected final Canvas canvas;

    /** Litsa de objeto encargado de renderizar el lienzo.  */
    protected final SafeArrayList<Graphics2DRenderer> renderers;
    
    // stop/pause
    /** True si se sale de la simulación */
    private boolean stopped;

    /** La marca de tiempo para la última iteración */
    private long last;

    /**
     * Genera una nueva simulacion.
     */
    public Simulation() {
        // Generamos nuestro objeto lista de renderizados.
        this.renderers = new SafeArrayList<>(Graphics2DRenderer.class);
        
        // Cree el tamaño de la ventana
        Dimension size = new Dimension(400, 200);

        // Crear un lienzo para pintar
        this.canvas = new Canvas();
        this.canvas.setPreferredSize(size);
        this.canvas.setFocusable(false);
        //this.canvas.setMinimumSize(size);
        //this.canvas.setMaximumSize(size);
    }

    /**
     * Devuelve el lienzo donde se grafica.
     * @return Componente AWT para graficar.
     */
    public Canvas getContext() {
        return canvas;
    }
    
    /**
     * Limpia la lista de renderizados.
     */
    public void clearRenderer() {
        if (renderers != null) {
            renderers.clear();
        }
    }

    @Override
    public void addRenderer(Graphics2DRenderer gr) {
        if (gr == null) {
            throw new NullPointerException("Graphics2DRenderer is Null.");
        }
        this.renderers.add(gr);
    }
    @Override
    public boolean removeRenderer(Graphics2DRenderer gr) {
        if (this.renderers == null) {
            return false;
        }
        return this.renderers.remove(gr);
    }    
    @Override
    public Graphics2DRenderer removeRenderer(int index) {
        if (index < 0 || index >= this.renderers.size()) {
            return null;
        }        
        return this.renderers.remove(index);
    }
    
    /**
     * Arranca el motor grafico 2D de Java.
     */
    public void run() {
        stopped = false;
        start();
    }

    /**
     * Inicie la representación activa de la simulación.
     * <p>
     * Esto debe llamarse después de que se haya mostrado el JFrame.
     */
    private void start() {
        // inicializar la última hora de actualización
        this.last = System.nanoTime();
        // no permita que AWT pinte el lienzo ya que estamos
        this.canvas.setIgnoreRepaint(true);
        // Habilitar el doble almacenamiento en búfer
        //(el JFrame tiene que ser visible antes de que esto se pueda hacer)
        this.canvas.createBufferStrategy(2);
        // ejecutar un hilo separado para hacer renderizado activo
        // porque no queremos hacerlo en la EDT
        Thread thread = new Thread() {
            @Override
            public void run() {
                // realiza un bucle infinito detenido
                // renderizar lo más rápido posible
                while (!isStopped()) {
                    loop();
                    // podría agregar un Thread.yield(); o
                    // Thread.sleep(largo) aquí para dar el
                    // CPU un poco de espacio para respirar
                    try {
                        Thread.sleep(5);
                    } catch (InterruptedException e) { }
                }
            }
        };
        // establecer el subproceso del bucle en un subproceso daemon para que
        // no puede evitar que la JVM salga
        thread.setDaemon(true);
        // inicia el ciclo/hilo
        thread.start();
    }

    /**
     * El método es llamando a los métodos necesarios para actualizar el los gráficos.
     */
    private void loop() {
        // obtener el objeto gráfico para renderizar
        Graphics2D g = (Graphics2D) this.canvas.getBufferStrategy().getDrawGraphics();

        // por defecto, establece (0, 0) para que sea el centro de la pantalla con el eje x positivo
        // apuntando a la derecha y el eje y positivo apuntando hacia arriba
        this.transform(g);

        // restablecer la vista
        this.clear(g);

        // obtener la hora actual
        long time = System.nanoTime();
        // obtener el tiempo transcurrido desde la última iteración
        long diff = time - this.last;
        // establecer la última vez
        this.last = time;
        // convertir de nanosegundos a segundos
        double elapsedTime = (double) diff / NANO_TO_BASE;

        // renderizar cualquier cosa sobre la simulación (renderizará los objetos del Canvas)
        AffineTransform tx = g.getTransform();
        this.render(g, elapsedTime);
        g.setTransform(tx);

        // dispose of the graphics object
        g.dispose();

        // blit/flip el bufer
        BufferStrategy strategy = this.canvas.getBufferStrategy();
        if (!strategy.contentsLost()) {
            strategy.show();
        }

        // Sincroniza la pantalla en algunos sistemas.
        // (en Linux, esto soluciona los problemas de la cola de eventos)
        Toolkit.getDefaultToolkit().sync();
    }

    /**
     * Realiza cualquier transformación en los gráficos.
     * <p>
     * Por defecto, este método pone el origen (0,0) en el centro de la ventana
     * y señala el eje y positivo apuntando hacia arriba.
     *
     * @param g el objeto de gráficos para representar
     */
    protected void transform(Graphics2D g) {
        final int w = this.canvas.getWidth();
        final int h = this.canvas.getHeight();

        // antes de renderizar todo voy a voltear el eje y y mover el
        // origen al centro (en lugar de estar en la esquina superior izquierda)
        AffineTransform yFlip = AffineTransform.getScaleInstance(1, -1);
        AffineTransform move = AffineTransform.getTranslateInstance(w / 2, -h / 2);
        g.transform(yFlip);
        g.transform(move);
    }

    /**
     * Borra el cuadro anterior.
     *
     * @param g el objeto de gráficos para representar
     */
    protected void clear(Graphics2D g) {
        final int w = this.canvas.getWidth();
        final int h = this.canvas.getHeight();

        // eliminamos todo
        g.clearRect(-w / 2, -h / 2, w, h);
        
        // vamos a dibujar sobre todo con un fondo blanco
        g.setColor(Color.WHITE);
        g.fillRect(-w / 2, -h / 2, w, h);
    }

    /**
     * Metodo encargado de renderizar.
     *
     * @param g el objeto de gráficos para representar
     * @param elapsedTime el tiempo transcurrido desde la última actualización
     */
    protected void render(Graphics2D g, double elapsedTime) {
        if (renderers != null) {
            for (final Graphics2DRenderer gdr : this.renderers) {
                if (gdr == null)
                    continue;
                
                gdr.render(this, g, elapsedTime);
            }
        }
    }

    /**
     * Detiene la simulación.
     */
    public synchronized void stop() {
        this.stopped = true;
    }

    /**
     * Devuelve true si la simulación se detiene.
     *
     * @return boolean true si se detiene
     */
    public boolean isStopped() {
        return this.stopped;
    }

    ///**
    // * Pausa la simulación.
    // */
    //public synchronized void resume() {
    //    this.last = System.nanoTime();
    //}
}
