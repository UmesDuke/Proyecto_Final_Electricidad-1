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

import gt.edu.meso.circuito.Circuito;
import gt.edu.meso.circuito.Paralelo;
import gt.edu.meso.circuito.Resistor;
import gt.edu.meso.circuito.Serie;
import gt.edu.meso.jui.Window;
import gt.edu.meso.jui.panel.cicuito.PanelParalelo;
import gt.edu.meso.jui.panel.cicuito.PanelSerie;
import gt.edu.meso.util.Notation;
import gt.edu.meso.util.Utils;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JViewport;

/**
 * @author wil
 */
public class PanelCircuitos extends JPanel {
    
    static final BufferedImage IMG_PARALELO = Utils.getImageSuppressExceptions("/Icons/form_paralelo_dark.png");
    static final BufferedImage IMG_SERIE    = Utils.getImageSuppressExceptions("/Icons/form_serie_dark.png");
    
    private PanelSerie panelSerie;
    private PanelParalelo panelParalelo;
    
    /**
     * Creates new form PanelCalculadora
     */
    public PanelCircuitos() {
        initComponents();
        componentesAdd();
    }
    
    /**
     * Se inicializa los componentes adicionales.
     */
    protected final void componentesAdd() {
        panelSerie = new PanelSerie();
        panelParalelo = new PanelParalelo();
        
        panelSerie.setFuente(5);
        panelSerie.addCambiosListener((Serie circuito) -> {
            circuito.start();
            aplicarCambios(circuito);
        });
        panelParalelo.addCambiosListener((Paralelo circuito) -> {
            circuito.start();
            aplicarCambios(circuito);
        });
        
        view.setViewportView(panelSerie);
        updateRS();
        
        int w = (int) (IMG_SERIE.getWidth() * 0.35);
        int h = (int) (IMG_SERIE.getHeight() * 0.35);
        icon.setIcon(new ImageIcon(IMG_SERIE.getScaledInstance(w, h, Image.SCALE_SMOOTH)));
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        opcionSerie = new javax.swing.JRadioButton();
        opcionParalelo = new javax.swing.JRadioButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        view = new javax.swing.JScrollPane();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        icon = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        At = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        Pt = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        Rt = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        resistor = new javax.swing.JComboBox<>();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel8 = new javax.swing.JLabel();
        r_amperios = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        r_potencia = new javax.swing.JTextField();
        r_voltios = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        r_ohmios = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        fiedlVolt = new javax.swing.JTextField();
        ntVol = new javax.swing.JComboBox<>();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Source Sans Pro Black", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Tipo de circuito");

        buttonGroup1.add(opcionSerie);
        opcionSerie.setForeground(new java.awt.Color(0, 0, 0));
        opcionSerie.setSelected(true);
        opcionSerie.setText("Resistencia en serie");
        opcionSerie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opcionSerieActionPerformed(evt);
            }
        });

        buttonGroup1.add(opcionParalelo);
        opcionParalelo.setForeground(new java.awt.Color(0, 0, 0));
        opcionParalelo.setText("Resistencia en pararela");
        opcionParalelo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opcionParaleloActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Source Sans Pro Black", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Salida");

        view.setBorder(null);
        view.setMaximumSize(new java.awt.Dimension(427, 540));

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setForeground(new java.awt.Color(0, 0, 0));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/b_newtbl.png"))); // NOI18N
        jButton2.setText("Agregar Resistencia");
        jButton2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.setDisabledIcon(null);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(255, 255, 255));
        jButton3.setForeground(new java.awt.Color(0, 0, 0));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/b_drop.png"))); // NOI18N
        jButton3.setText("Eliminar la resistencia");
        jButton3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.setDisabledIcon(null);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(230, 230, 230));

        icon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(icon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(icon, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)), "Resultados"));

        jLabel3.setFont(new java.awt.Font("Source Sans Pro Black", 0, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("1° Sumatorias totales:");

        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/bd_nextpage.png"))); // NOI18N
        jLabel4.setText("Corriente total:");

        At.setEditable(false);
        At.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        At.setText("0");

        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/bd_nextpage.png"))); // NOI18N
        jLabel5.setText("Potencia total:");

        Pt.setEditable(false);
        Pt.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        Pt.setText("0");

        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/bd_nextpage.png"))); // NOI18N
        jLabel6.setText("Resistencia total:");

        Rt.setEditable(false);
        Rt.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        Rt.setText("0");

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)), "Resistencias"));

        jLabel7.setFont(new java.awt.Font("Source Sans Pro Black", 0, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Seleccionar Resistencia:");

        resistor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<default...?>", "R1", "R2", "R3" }));
        resistor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resistorActionPerformed(evt);
            }
        });

        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/b_help.png"))); // NOI18N
        jLabel8.setText("Corriente:");

        r_amperios.setEditable(false);
        r_amperios.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        r_amperios.setText("0");

        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/b_help.png"))); // NOI18N
        jLabel9.setText("Potencia:");

        r_potencia.setEditable(false);
        r_potencia.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        r_potencia.setText("0");

        r_voltios.setEditable(false);
        r_voltios.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        r_voltios.setText("0");

        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/b_help.png"))); // NOI18N
        jLabel10.setText("Voltios:");

        r_ohmios.setEditable(false);
        r_ohmios.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        r_ohmios.setText("0");

        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/b_help.png"))); // NOI18N
        jLabel11.setText("Resistencia:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator2)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(r_amperios))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(r_potencia))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(r_voltios))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(r_ohmios))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(resistor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(resistor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(r_amperios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(r_potencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(r_voltios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(r_ohmios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(At, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Pt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Rt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel3))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(At, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Pt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Rt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel12.setFont(new java.awt.Font("Source Sans Pro Black", 0, 16)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 0));
        jLabel12.setText("Voltage del circuito:");

        fiedlVolt.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        fiedlVolt.setText("5");
        fiedlVolt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                fiedlVoltKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fiedlVoltKeyTyped(evt);
            }
        });

        ntVol.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<default>", "K", "M", "G" }));
        ntVol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ntVolActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(view, javax.swing.GroupLayout.PREFERRED_SIZE, 427, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(fiedlVolt, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ntVol, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 76, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(opcionSerie)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(opcionParalelo))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(opcionSerie)
                    .addComponent(opcionParalelo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel12)
                            .addComponent(fiedlVolt)
                            .addComponent(ntVol)))
                    .addComponent(view, javax.swing.GroupLayout.PREFERRED_SIZE, 540, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(60, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    
    Circuito getLocalCircuito() {
        return opcionSerie.isSelected() ? panelSerie.getCircuito()    : opcionParalelo.isSelected() 
                                        ? panelParalelo.getCircuito() : null;
    }
    
    void updateRS() {
        synchronized (this) {
            final Circuito c = getLocalCircuito();
        
            if (c == null)
                return;

            List<Resistor> rs = c.getResistencias();
            DefaultComboBoxModel<String> mode = (DefaultComboBoxModel<String>)
                                                resistor.getModel();

            final Object select = mode.getSelectedItem();

            mode.removeAllElements();
            mode.addElement("<default...?>");

            boolean exist = false;
            if (rs != null) {
                for (final Resistor r : rs) {
                    if (r == null) 
                        continue;

                    mode.addElement(r.getName());
                    if (r.getName().equals(select)) {
                        exist = true;
                    }
                }
            }

            if (select instanceof String 
                    && !((String) select).isEmpty()) {
                if (exist) {
                    mode.setSelectedItem(select);
                }
            } else {
                resistor.setSelectedIndex(0);
            }
        }
    }
    
    void aplicarCambios(Circuito c) {
        if (c == null)
            return;
        
        Notation at = Notation.determine(c.getAmperajeTotal());
        Notation pt = Notation.determine(c.getPotenciaTotal());
        Notation rt = Notation.determine(c.getResistenciaTotal());
        
        At.setText(Utils.doubleFormat(at.getUnscaleNumber()) + at.getPrefix().getPrefix());
        Pt.setText(Utils.doubleFormat(pt.getUnscaleNumber()) + pt.getPrefix().getPrefix());
        Rt.setText(Utils.doubleFormat(rt.getUnscaleNumber()) + rt.getPrefix().getPrefix());
    }
    
    void updateNTVol() {
        final Object value = ntVol.getSelectedItem();
        if (resistor == null)
            return;
        
        if (value instanceof String 
                && !((String) value).isEmpty()) {
            
            Circuito c = getLocalCircuito();
            double vol = c.getFuente();
            
            Notation notation;
            
            switch (String.valueOf(value)) {
                case "<default>":
                    notation = new Notation(vol,
                                            Notation.Prefix.Default);
                    break;
                case "K":
                    notation = new Notation(vol,
                                            Notation.Prefix.Kilo);
                    break;
                case "M":
                    notation = new Notation(vol,
                                            Notation.Prefix.Mega);
                    break;
                case "G":
                    notation = new Notation(vol,
                                            Notation.Prefix.Giga);
                    break;
                default:
                    throw new RuntimeException(getClass().getName());
            }
            if (notation != null) {
                c.setFuente(notation.getScaleNumber());                
                aplicarCambios(c);
            }
        }
    }
    
    private void opcionSerieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcionSerieActionPerformed
        if (opcionSerie.isSelected()) {
           final JViewport viewport = view.getViewport();
           if (!(viewport.getView() instanceof PanelSerie)) {
               int w = (int) (IMG_SERIE.getWidth() * 0.35);
               int h = (int) (IMG_SERIE.getHeight() * 0.35);
               
               view.setViewportView(panelSerie);
               icon.setIcon(new ImageIcon(IMG_SERIE.getScaledInstance(w, h, Image.SCALE_SMOOTH)));
           }
        }
    }//GEN-LAST:event_opcionSerieActionPerformed

    private void opcionParaleloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcionParaleloActionPerformed
        if (opcionParalelo.isSelected()) {
           final JViewport viewport = view.getViewport();
           if (!(viewport.getView() instanceof PanelParalelo)) {
               int w = (int) (IMG_PARALELO.getWidth() * 0.35);
               int h = (int) (IMG_PARALELO.getHeight() * 0.35);
               
               view.setViewportView(panelParalelo);
               icon.setIcon(new ImageIcon(IMG_PARALELO.getScaledInstance(w, h, Image.SCALE_SMOOTH)));
           }
        }
    }//GEN-LAST:event_opcionParaleloActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (opcionSerie.isSelected()) {
            panelSerie.add();
        } else {
            if (opcionParalelo.isSelected()) {
                panelParalelo.add();
            }
        }
        view.updateUI();
        view.setBorder(null);
        updateRS();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if (opcionSerie.isSelected()) {
            panelSerie.remove();
        } else {
            if (opcionParalelo.isSelected()) {
                panelParalelo.remove();
            }
        }
        view.updateUI();
        view.setBorder(null);
        updateRS();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void resistorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resistorActionPerformed
        final Circuito c = getLocalCircuito();        
        if (c != null) {
            final Object item = resistor.getSelectedItem();
            if (item instanceof String && !((String) item).isEmpty()) {
                for (final Resistor r : c.getResistencias()) {
                    if (r == null)
                        continue;
                    
                    if (r.getName().equals(item)) {
                        if (r.isEnabled()) {
                            Notation ampers = Notation.determine(r.getCorriente());
                            Notation powers = Notation.determine(r.getPotencia());
                            Notation voltis = Notation.determine(r.getVoltios());
                            Notation ohmios = Notation.determine(r.getOhmios());

                            r_amperios.setText(Utils.doubleFormat(ampers.getUnscaleNumber()) + ampers.getPrefix().getPrefix());
                            r_potencia.setText(Utils.doubleFormat(powers.getUnscaleNumber()) + powers.getPrefix().getPrefix());
                            r_voltios.setText(Utils.doubleFormat(voltis.getUnscaleNumber()) + voltis.getPrefix().getPrefix());
                            r_ohmios.setText(Utils.doubleFormat(ohmios.getUnscaleNumber()) + ohmios.getPrefix().getPrefix());
                        } else {                        
                            r_amperios.setText("0");
                            r_potencia.setText("0");
                            r_voltios.setText("0");
                            r_ohmios.setText("0");
                        }
                    }
                }
            }
        }
    }//GEN-LAST:event_resistorActionPerformed

    private void fiedlVoltKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fiedlVoltKeyReleased
        synchronized (this) {
            String ftstr = fiedlVolt.getText();
            if (ftstr == null 
                    || ftstr.isEmpty()) {
                return;
            }
            
            try {
                double ftv = Double.parseDouble(ftstr);
                if (panelParalelo != null) {
                    panelParalelo.setFuente(ftv);
                }
                if (panelSerie != null) {
                    panelSerie.setFuente(ftv);
                }
                updateNTVol();
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "El valor \"" + ftstr + "\" no es valido.", "Error - " + Window.TITLE,
                                                JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_fiedlVoltKeyReleased

    private void ntVolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ntVolActionPerformed
        updateNTVol();
    }//GEN-LAST:event_ntVolActionPerformed

    private void fiedlVoltKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fiedlVoltKeyTyped
        synchronized (this) {
            updateNTVol();
        }
    }//GEN-LAST:event_fiedlVoltKeyTyped

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField At;
    private javax.swing.JTextField Pt;
    private javax.swing.JTextField Rt;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JTextField fiedlVolt;
    private javax.swing.JLabel icon;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JComboBox<String> ntVol;
    private javax.swing.JRadioButton opcionParalelo;
    private javax.swing.JRadioButton opcionSerie;
    private javax.swing.JTextField r_amperios;
    private javax.swing.JTextField r_ohmios;
    private javax.swing.JTextField r_potencia;
    private javax.swing.JTextField r_voltios;
    private javax.swing.JComboBox<String> resistor;
    private javax.swing.JScrollPane view;
    // End of variables declaration//GEN-END:variables
}
