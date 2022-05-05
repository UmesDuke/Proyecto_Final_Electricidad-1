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

import com.jme3.util.IntMap;

import gt.edu.meso.Bandas;
import gt.edu.meso.jui.JColorListCellRenderer;
import gt.edu.meso.util.JColor;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * La clase <code>Resitor2D</code> se encarga de procesar, dibujar una
 * resistencia en 2D.
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
public final class Resitor2D implements Graphics2DRenderer {
    
    /** Imagen de una resistencia.*/
    static final BufferedImage RESISTOR = getImageSuppressExceptions("/Icons/resistor.png");
    
    /** Clase enuemerada encargado de determinar el numero de bandas
     que tendra la resistencia el dibujarlo.*/
    public static enum ResBanda {
        
        /** 4 Bandas. */
        CUATRO,
        
        /** 5 Bandas. */
        CINCO;
    }
    
    /** Inidca si se a inicilizado los componentes. */
    private boolean initG2D = false;
    
    /* * Mapda de las bandas de color. */
    private final IntMap<BandaColor2D> intMap;
    
    /** DImesnon de la imagen de resistancia. */
    private final Rect rectImg;
    
    /** Banda que utiliza el resistor. */
    private Bandas bandas;

    /**
     * Constructor predeterminado.
     */
    public Resitor2D() {
        // inicializamos nuestro mapa.
        this.intMap = new IntMap<>();
        
        // Determinamos las dimesiones de la imgen
        // resistencia para poder dibujarlo.
        double w = RESISTOR.getWidth()  * 0.7;
        double h = RESISTOR.getHeight() * 0.7;        
        this.rectImg = new Rect(-(w / 2), -(h / 3), w, h);
        
        // Generamos una banda de color.
        BandaColor2D banda01 = new BandaColor2D(JColorListCellRenderer.TypeComboModel.COLOR_BANDA);
        banda01.setColor(JColor.DEFAULT);
        banda01.setRect(new Rect(rectImg.x + 35, rectImg.y, 15, h));
        banda01.setRectStr(new Rect(rectImg.x + 35, rectImg.y - 50, 15, 50));
        intMap.put(1, banda01);
        
        // Generamos una banda de color.
        BandaColor2D banda02 = new BandaColor2D(JColorListCellRenderer.TypeComboModel.COLOR_BANDA);
        banda02.setColor(JColor.DEFAULT);
        banda02.setRect(new Rect(rectImg.x + 80, rectImg.y + 11, 15, h - 26));
        banda02.setRectStr(new Rect(rectImg.x + 80, (rectImg.y + 11) - 60, 15, 60));
        intMap.put(2, banda02);
        
        // Generamos una banda de color.
        BandaColor2D banda03 = new BandaColor2D(JColorListCellRenderer.TypeComboModel.COLOR_BANDA);
        banda03.setColor(JColor.DEFAULT);
        banda03.setRect(banda02.getRect().clone().setX(rectImg.x + 110));
        banda03.setRectStr(banda02.getRectStr().clone().setX(banda03.getRect().x));
        intMap.put(3, banda03);
        
        // Generamos una banda de color.
        BandaColor2D banda04 = new BandaColor2D(JColorListCellRenderer.TypeComboModel.COLOR_MULTIPLICADOR);
        banda04.setColor(JColor.DEFAULT);
        banda04.setRect(banda03.getRect().clone().setX(rectImg.x + (w / 2) + 20));
        banda04.setRectStr(banda03.getRectStr().clone().setX(banda04.getRect().x));
        intMap.put(4, banda04);
        
        // Generamos una banda de color.
        BandaColor2D banda05 = new BandaColor2D(JColorListCellRenderer.TypeComboModel.COLOR_TOLERANCIA);
        banda05.setColor(JColor.DEFAULT);
        banda05.setRect(new Rect(rectImg.x + (w - 45), rectImg.y, 15, h));
        banda05.setRectStr(new Rect(rectImg.x + (w - 45), rectImg.y - 50, 15, 50));
        intMap.put(5, banda05);
    }
    
    /**
     * Establece las bandas de color.
     * @param bandas Bandas de color.
     */
    public void setBandas(Bandas bandas) {
        this.bandas = bandas;
        final JColor[] colors = bandas.getColors();
        switch (bandas.length()) {
            case 4:
                intMap.get(1).setColor(colors[0]);
                intMap.get(2).setColor(colors[1]);
                break;
            case 5:
                intMap.get(1).setColor(colors[0]);
                intMap.get(2).setColor(colors[1]);
                intMap.get(3).setColor(colors[2]);
                break;
            default:
                throw new IllegalStateException("Cantidad de bandas supera 5.");
        }
        
        // Color de las bandas: tolerancia y multiplicador.
        intMap.get(4).setColor(bandas.getMultiplier());
        intMap.get(5).setColor(bandas.getTolerance());
    }

    /**
     * Devuelve las bandas que utiliza este resistor.
     * @return Bandas del resistor.
     */
    public Bandas getBandas() {
        return bandas;
    }
    
    /** Reinicia el resistor. */
    public void reset() {
        for (final IntMap.Entry<BandaColor2D> g2d : this.intMap) {
            if (g2d == null)
                continue;

            g2d.getValue().setColor(JColor.DEFAULT);
        }
    }

    /**
     * Establece el numero de bandas que se graficaran.
     * @param banda numero de bandas.
     */
    public void setNoBandas(ResBanda banda) {
        if (banda == null)
            throw new NullPointerException("Numero de bandas");
        
        switch (banda) {
            case CINCO:
                for (final IntMap.Entry<BandaColor2D> g2d : this.intMap) {
                    if (g2d == null)
                        continue;

                    g2d.getValue().setEnabled(true);
                }
                break;
            case CUATRO:
                for (final IntMap.Entry<BandaColor2D> g2d : this.intMap) {
                    if (g2d == null)
                        continue;

                    final BandaColor2D value = g2d.getValue();
                    if (g2d.getKey() == 3) {
                        value.setEnabled(false);
                    } else {
                        value.setEnabled(true);
                    }
                }
                break;
            default:
                throw new AssertionError();
        }
    }
    
    @Override
    public void render(Renderer renderer, Graphics2D g, double elapsedTime) {
        // dibujamos nuestra imagen de la resistencia.
        g.drawImage(RESISTOR, rectImg.getX(), rectImg.getY(), 
                              rectImg.getWidth(), rectImg.getHeight(), null);
        
        // Inicializamos los componentes, que en este caso
        // las bandas de colores.
        if (!initG2D) {
            initG2D = true;
            for (final IntMap.Entry<BandaColor2D> g2d : this.intMap) {
                if (g2d == null)
                    continue;

                renderer.addRenderer(g2d.getValue());
            }
        }
    }
        
    /* Funcion auxiliar para leer las imagenes de la ruta de clase. */
    protected static BufferedImage getImageSuppressExceptions(String pathOnClasspath) {
        try {
            return ImageIO.read(Resitor2D.class.getResource(pathOnClasspath));
        } catch (IOException e) {
            return null;
        }
    }    
}
