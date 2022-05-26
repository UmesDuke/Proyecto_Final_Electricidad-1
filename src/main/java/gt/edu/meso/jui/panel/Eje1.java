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
package gt.edu.meso.jui.panel;

import gt.edu.meso.Bandas;
import gt.edu.meso.JBanda4;
import gt.edu.meso.JBanda5;

import gt.edu.meso.framework.Resitor2D;
import gt.edu.meso.framework.Simulation;

import gt.edu.meso.util.JColor;
import gt.edu.meso.util.Notation;
import gt.edu.meso.util.Theme;

import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * @author aleja
 * @version 1.0.0
 * @since 1.0.0
 */
public class Eje1 extends JFrame {
    
    /** Simularo 2D JAVA. */
    private Simulation simulation;
    /** Resistencia 2D. */
    private Resitor2D resitor2D;

    int minuto = 1;
    int segundo = 59;
    boolean in = true;
    
    public Eje1() {
        initComponents();
        getContentPane().setName("UIPruebaBanda");
        root.setBackground(Theme.getColor("color.dark.panel"));
        
        jLabel1.setForeground(Theme.getColor("color.dark.fg"));
        jLabel2.setForeground(Theme.getColor("color.dark.fg"));
        jLabel3.setForeground(Theme.getColor("color.dark.fg"));
        jLabel4.setForeground(Theme.getColor("color.dark.fg"));
        
        lab_Minutos.setForeground(Theme.getColor("color.dark.fg"));
        lab_Segundos.setForeground(Theme.getColor("color.dark.fg"));
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        root = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        but_INICIAR = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        lab_Minutos = new javax.swing.JLabel();
        lab_Segundos = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txt_DATO = new javax.swing.JTextField();
        Com_Magnitud = new javax.swing.JComboBox<>();
        but_VERIFICAR = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        root.setBackground(new java.awt.Color(255, 255, 255));

        but_INICIAR.setText("Iniciar");
        but_INICIAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                but_INICIARActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Source Sans Pro Black", 0, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Tiempo ");

        lab_Minutos.setFont(new java.awt.Font("Source Sans Pro Black", 0, 48)); // NOI18N
        lab_Minutos.setForeground(new java.awt.Color(0, 0, 0));
        lab_Minutos.setText("01");

        lab_Segundos.setFont(new java.awt.Font("Source Sans Pro Black", 0, 48)); // NOI18N
        lab_Segundos.setForeground(new java.awt.Color(0, 0, 0));
        lab_Segundos.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lab_Segundos.setText("00");

        jLabel1.setFont(new java.awt.Font("Source Sans Pro Black", 0, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText(":");

        txt_DATO.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txt_DATO.setEnabled(false);

        Com_Magnitud.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ohms", "K Ohms", "M Ohms", "G Ohms" }));
        Com_Magnitud.setEnabled(false);

        but_VERIFICAR.setText("VERIFICAR");
        but_VERIFICAR.setEnabled(false);
        but_VERIFICAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                but_VERIFICARActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setOpaque(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 88, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setOpaque(false);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 88, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setOpaque(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 101, Short.MAX_VALUE)
        );

        jLabel3.setFont(new java.awt.Font("Source Sans Pro SemiBold", 0, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("1° Ingrese su respuesta:");

        jLabel4.setFont(new java.awt.Font("Source Sans Pro SemiBold", 0, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("2° Verificar su respuesta:");

        javax.swing.GroupLayout rootLayout = new javax.swing.GroupLayout(root);
        root.setLayout(rootLayout);
        rootLayout.setHorizontalGroup(
            rootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rootLayout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(rootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(rootLayout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 401, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lab_Minutos)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lab_Segundos, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(but_INICIAR, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4)
                    .addComponent(jScrollPane1)
                    .addComponent(jSeparator1)
                    .addComponent(jLabel3)
                    .addGroup(rootLayout.createSequentialGroup()
                        .addComponent(txt_DATO, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Com_Magnitud, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(but_VERIFICAR))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        rootLayout.setVerticalGroup(
            rootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rootLayout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(rootLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(rootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(rootLayout.createSequentialGroup()
                        .addGap(79, 79, 79)
                        .addGroup(rootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(lab_Minutos)
                            .addComponent(lab_Segundos)
                            .addComponent(jLabel1)
                            .addComponent(but_INICIAR, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(rootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_DATO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Com_Magnitud, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(but_VERIFICAR)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        getContentPane().add(root, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void but_INICIARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_but_INICIARActionPerformed
        // -----Boton iniciar------
        in = true;
        txt_DATO.setEnabled(true);
        Com_Magnitud.setEnabled(true);
        but_VERIFICAR.setEnabled(true);
        but_INICIAR.setEnabled(false);
        
        init();
        
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (in == true) {
                    try {
                        Thread.sleep(1000);
                        
                        segundo--;
                        lab_Segundos.setText(Integer.toString(segundo));
                        
                        minuto = 0;
                        lab_Minutos.setText(Integer.toString(minuto));
                        
                        if (segundo == 0) {
                            in = false;
                            JOptionPane.showMessageDialog(Eje1.this.getContentPane(), "El tiempo se acabo");
                            but_INICIAR.setEnabled(true);
                            segundo = 59;
                            minuto = 1;
                        }
                    } catch (HeadlessException | InterruptedException e) {
                    }
                }
                lab_Segundos.setText("00");
                lab_Minutos.setText("01");
                
                simulation.stop();
                jScrollPane1.setViewportView(null);
            }
        });
        thread.start();
    }//GEN-LAST:event_but_INICIARActionPerformed

    private void but_VERIFICARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_but_VERIFICARActionPerformed
        // Boton de verificación
        try {
            String nombre = txt_DATO.getText();
            double valor = Double.parseDouble(nombre.trim());
            
            // detienen el simulador-
            simulation.stop();
            Notation notation;
            // Determinamos la notacion que eligio el usuario para su respuesta.
            switch (String.valueOf(Com_Magnitud.getSelectedItem())) {
                case "K Ohms": // Kilos.
                    notation = new Notation(valor, Notation.Prefix.Kilo);
                    break;
                case "M Ohms": // Megas
                    notation = new Notation(valor, Notation.Prefix.Mega);
                    break;
                case "G Ohms": // Gigas.
                    notation = new Notation(valor, Notation.Prefix.Giga);
                    break;
                case "Ohms": // Ninguna notacion.
                default:
                    notation = new Notation(valor, Notation.Prefix.Default);
                    break;
            }
            
            // obtenemos el valor de la resistencia, para luego comporbar que son
            // iguales a la respuesta del usuario, o no...
            if (resitor2D.getBandas().getOhms() == notation.getScaleNumber()) {
                JOptionPane.showMessageDialog(getContentPane(), "El valor de la recistencia es CORRECTO");

            } else {
                JOptionPane.showMessageDialog(getContentPane(), "El valor de la recistencia es INCORRECTO");
            }

        } catch (HeadlessException | NumberFormatException e) {
            JOptionPane.showMessageDialog(getContentPane(), "!ERROR¡, El valor ingresado no es valido");

        }
        in = false;
        segundo = 59;
        lab_Segundos.setText("00");
        minuto = 1;
        lab_Minutos.setText("01");
        txt_DATO.setEnabled(false);
        Com_Magnitud.setEnabled(false);
        but_VERIFICAR.setEnabled(false);
        but_INICIAR.setEnabled(true);
        txt_DATO.setText("");
        Com_Magnitud.setSelectedIndex(0);

    }//GEN-LAST:event_but_VERIFICARActionPerformed
    
    /** Se encarga de inicra una resistencia con los
     valores aleatorios.*/
    private void init() {
        if (!simulation.isStopped()) {
            simulation.stop();
        }          
                    
        // Obtenemos un areglo de cuantos bandas dispone la resistencia.
        Resitor2D.ResBanda[] bandas = Resitor2D.ResBanda.values();
        // Con 'Math.random()' obtenemos un numero aleatorio.
        Resitor2D.ResBanda rb = bandas[((int) (Math.random() * bandas.length))];
        
        // Determinaomos de cuantos bandas sera nuestra
        // resistencia a mostrar al usuario.
        Bandas bandaResistor;                    
        switch (rb) {
            case CINCO:
                bandaResistor = new JBanda5();                
                // establecemos los 3 color de las bandas.
                ((JBanda5) bandaResistor).setBanda1(randJColor(Bandas.BANDA));
                ((JBanda5) bandaResistor).setBanda2(randJColor(Bandas.BANDA));
                ((JBanda5) bandaResistor).setBanda3(randJColor(Bandas.BANDA));
                break;
            case CUATRO:
                bandaResistor = new JBanda4();
                // establecemos los 2 color de las bandas.
                ((JBanda4) bandaResistor).setBanda1(randJColor(Bandas.BANDA));
                ((JBanda4) bandaResistor).setBanda2(randJColor(Bandas.BANDA));
                break;
            default:
                throw new AssertionError();
        }
                    
        // Color de la banda multiplicador.
        bandaResistor.setMultiplier(randJColor(Bandas.MULTIPLICADOR));
        // Color de la banda tolerancia.
        bandaResistor.setTolerance(randJColor(Bandas.TOLERANCIA));
                    
        // establecemos el numero de bandas de la resistencia.
        resitor2D.setNoBandas(rb);
        // Establecemos las bandas.
        resitor2D.setBandas(bandaResistor);
        
        // Agregamos el contexto(Canvas) del simuladora a un contenedor donde el
        // usuario podra vizualizarlo.
        jScrollPane1.setViewportView(simulation.getContext());     
        // Arrancamos el simulador.
        simulation.run();
    }
    
    /**
     * Metodo encargado de generar un color aleatorio de un areglo.
     * @param array Areglo de colores.
     * @return Color aleatorio.
     */
    private JColor randJColor(JColor[] array) {
        // si el areglo es nula, devolvemo un color por defecto.
        if (array == null) {
            return JColor.DEFAULT;
        }
        
        // Obtenemos un numro aleatorio entre 0 y la longitud de la lista.
        int rand     = (int) (Math.random() * array.length);
        // Obtenemos un color de la lista segun el indice aleatorio dada.
        JColor color = array[rand];
        
        // si el color obtenido es nula, devolvemos el color
        // predeterminado, de lo contrario el color obtenido tras la operacion.
        if (color == null) {
            return JColor.DEFAULT;
        }
        return color;
    }

    /**
     * Establece el simulador que se utilizara.
     * @param simulation simulador JAVA.
     */
    public void setSimulation(Simulation simulation) {
        this.simulation = simulation;
    }

    /**
     * Establece uan resistencia 2D.
     * @param resitor2D grafica de una resistencia.
     */
    public void setResitor2D(Resitor2D resitor2D) {
        this.resitor2D = resitor2D;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> Com_Magnitud;
    private javax.swing.JButton but_INICIAR;
    private javax.swing.JButton but_VERIFICAR;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lab_Minutos;
    private javax.swing.JLabel lab_Segundos;
    private javax.swing.JPanel root;
    private javax.swing.JTextField txt_DATO;
    // End of variables declaration//GEN-END:variables
}
