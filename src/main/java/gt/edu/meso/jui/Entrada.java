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
package gt.edu.meso.jui;

import gt.edu.meso.framework.Resitor2D;
import gt.edu.meso.framework.Simulation;
import gt.edu.meso.jui.panel.Eje1;
import gt.edu.meso.jui.panel.PanelCalculadora;
import gt.edu.meso.jui.panel.PanelCircuitos;
import gt.edu.meso.util.Group;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import javax.swing.JViewport;

/**
 * La clase <code>Entrada</code> se encarga de gestionar la pantalla principal,
 * donde el usuario pueda elegir las diferentes opciones quen estan soportadas
 * actualmente.
 * 
 * @author wil
 * @author santos
 * @author javier
 * 
 * @version 1.0.0
 * @since 1.0.0
 */
public class Entrada extends Window {

    /** Simuladro 2D. */
    private Simulation simulation;
    
    /** Resistencia 2D. */
    private Resitor2D resitor2D;
    
    /** Administraro de grupos.*/
    private Group group;
    
    /**
     * Creates new form Entrada
     */
    public Entrada() {
        initComponents();
        componentesAdd();
    }

    // inicializa los componentes adicionales
    @Override// de la clase.
    protected final void componentesAdd() {
        setTitle("Bienvenido");
        center();
        
        // inicializamos nuestro objetos.
        simulation = new Simulation();
        resitor2D  = new Resitor2D();
        group = new Group();
        
        // establecemos los colores del grupo.
        group.setColorUnselected(jPanel2.getBackground());
        group.setColorSelected(new Color(40, 99, 162));
        
        // establecemos el color de los textos.
        group.setForegrounUnselected(new Color(0, 0, 0));
        group.setForegrounSelected(new Color(255, 255, 255));
        
        // agregamos los botones al grupo-
        group.add(jButton1);
        group.add(jButton2);
        
        // agregamos una renderizador al simulador
        // 2D...
        simulation.addRenderer(resitor2D);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel4 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel3.setLayout(null);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icon_01.png"))); // NOI18N
        jPanel3.add(jLabel1);
        jLabel1.setBounds(10, 10, 48, 67);

        jLabel2.setFont(new java.awt.Font("Source Sans Pro", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Wizzard");
        jPanel3.add(jLabel2);
        jLabel2.setBounds(60, 20, 86, 31);

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("v1.0.0");
        jPanel3.add(jLabel3);
        jLabel3.setBounds(60, 45, 86, 19);

        jButton1.setText("    Valores de Resistores.");
        jButton1.setBorder(null);
        jButton1.setBorderPainted(false);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("    Circuitos");
        jButton2.setBorder(null);
        jButton2.setBorderPainted(false);
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setBorder(null);
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jLabel5.setFont(new java.awt.Font("Source Sans Pro SemiBold", 0, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Bienvenido a Wizzard");

        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Universidad Mesoamericana, Primer Semestre Seccion E1");

        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Proyecto final Electricidad 1");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 645, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(110, 110, 110)
                .addComponent(jLabel5)
                .addGap(33, 33, 33)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addContainerGap(287, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(jPanel4);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 502, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Evento: cierre de ventena.
    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        exit();
    }//GEN-LAST:event_formWindowClosing

    // Evento: Fase #1.
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        /* 
         * Para saber si el usuario quiere la calculadora de bandas, o una
         * prueba, para ello generamos una ventana emergente que pregundo
         * los dicho.
         *
         */
        final Fase1 fase1 = new Fase1(this, true);
        fase1.center(this);
        fase1.setVisible(true);
        
        // si el usuario acepto.
        if (fase1.getStatus() == Popup.RET_OK) {
            
            // obtenemos el contenido de la vista atual del
            // 'JScrollPanle' en la interfaz.
            final JViewport viewport  = jScrollPane1.getViewport();
            final Component component = viewport.getView();
               
            
            if (fase1.isCalculadorabandas()) {
                // verificamos que la vista obtenido no es nula, además
                // que dicho vista no es una instancia del contenedor(panel)
                // calculadora, de ser:
                if (component != null && !(component instanceof PanelCalculadora)) {
                    // generamos el panel de la calculadora.
                    PanelCalculadora calculadora = new PanelCalculadora();
                    //establecemos el contexto del simuador al panel.
                    calculadora.setView(simulation.getContext(), resitor2D);
                    // agregamos la nueva vista.
                    jScrollPane1.setViewportView(calculadora);
                    
                    // si el simulador esta corriendo, los
                    // detenemos para reiniciarlo.
                    if (!simulation.isStopped()) {
                        simulation.stop();
                    }
                    
                    simulation.run(); // iniiamos nuevamente el simulador.
                    resitor2D.reset();// restablecemos los valores.
                    
                    // configuramos el tamaño de la pantalla.
                    setSize(new Dimension(1060, 600));
                    calculadora.setFrame(this);
                }
            } else if (fase1.isPruebaBandas()) {
                // dato que la clase donde se encuentra la prueba de bandas, es un
                // JFrames, tebemos que verificar el nombre del componetes actual de
                // la vista para determinar si es o no un contenedro de pruebas, de se asi:
                if (component != null && !("UIPruebaBanda".equals(component.getName()))) {
                    // generamos el contenedor de pruebas para
                    // las bandas de color.
                    Eje1 eje1 = new Eje1();
                    //establcemos el simulador al contenedor.
                    eje1.setSimulation(simulation);
                    //una resistencia 2D.
                    eje1.setResitor2D(resitor2D);
                    
                    // si el simulador esta corriendo, los
                    // detenemos para reiniciarlo.
                    if (!simulation.isStopped()) {
                        simulation.stop();
                    }
                    
                    // Establecemos la vista nueva.
                    jScrollPane1.setViewportView(eje1.getContentPane());
                    setSize(new Dimension(1160, 650));
                }
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    // Evento: Fase #2
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // Obtenemos la vista actual del usuario.
        final JViewport viewport  = jScrollPane1.getViewport();
        final Component component = viewport.getView();
        
        // comprobamos si dicho componete no es una instancia
        // del contenedor de circutor, de se asi:
        if (!(component instanceof PanelCircuitos)) {
            /*
            para no generar problemas con la ejecucion del programa, detenemos
            el simulador(siempre y cuando este en ejecucion).
            */
            if (!simulation.isStopped()) {
                simulation.stop();
            }
            
            // generamos la nueva vista.
            final PanelCircuitos circuitos = new PanelCircuitos();
            // establecemos la vista.
            jScrollPane1.setViewportView(circuitos);
            
            // configuarmos la venatana.
            setSize(new Dimension(1360, 850));
            center(null);
        }
    }//GEN-LAST:event_jButton2ActionPerformed
    
    /**
     * Metodo encargado de cerra la aplicacion, pero primero
     * pregunta si realmente desea salir(si se puede.).
     */
    private void exit() {
        final ConfirmarSalida salida = new ConfirmarSalida(this, true);
        salida.center(this);
        salida.setVisible(true);
        
        if (salida.getStatus() == ConfirmarSalida.RET_OK) {
            simulation.stop();
            System.exit(0);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
