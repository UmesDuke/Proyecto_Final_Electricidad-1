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
import gt.edu.meso.circuito.Resistor;
import gt.edu.meso.divisor.Divisible;
import gt.edu.meso.divisor.Divisor;
import gt.edu.meso.divisor.PanelCorriente;
import gt.edu.meso.divisor.PanelVoltage;

import gt.edu.meso.jui.Window;
import gt.edu.meso.jui.panel.cicuito.CambioNombre;
import gt.edu.meso.jui.panel.cicuito.JPanelCircuito;
import gt.edu.meso.jui.panel.cicuito.PanelParalelo;
import gt.edu.meso.jui.panel.cicuito.PanelSerie;

import gt.edu.meso.util.Notation;
import gt.edu.meso.util.Theme;
import gt.edu.meso.util.Utils;

import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.swing.BorderFactory;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JViewport;
import org.monkey.JmeProperties;

/**
 * @author wil
 */
public class PanelDivisor extends JPanel {
    
    static final BufferedImage IMG_PARALELO = Utils.getImageSuppressExceptions("/Icons/irx.png");
    static final BufferedImage IMG_SERIE    = Utils.getImageSuppressExceptions("/Icons/vrx.png");
    
    private PanelVoltage panelSerie;
    private PanelCorriente panelParalelo;
    
    /**
     * Creates new form PanelCalculadora
     */
    public PanelDivisor() {
        initComponents();
        componentesAdd();
    }
    
    /**
     * Se inicializa los componentes adicionales.
     */
    protected final void componentesAdd() {
        panelSerie = new PanelVoltage();
        panelParalelo = new PanelCorriente();
        
        panelSerie.setFuente(5);        
        view.setViewportView(panelSerie);
        
        int w = (int) (IMG_SERIE.getWidth() * 0.35);
        int h = (int) (IMG_SERIE.getHeight() * 0.35);
        icon.setIcon(new ImageIcon(IMG_SERIE.getScaledInstance(w, h, Image.SCALE_SMOOTH)));
        
        final CambioNombre evt = (String[] names) -> {
            DefaultComboBoxModel<String> mode = new DefaultComboBoxModel<>();

            final Object select = mode.getSelectedItem();
            mode.addElement("<default...?>");

            boolean exist = false;
            if (names != null) {
                for (final String name : names) {
                    if (name == null) 
                        continue;

                    mode.addElement(name);                    
                    if (name.equals(select)) {
                        exist = true;
                    }
                }
            }

            if (select instanceof String 
                    && !((String) select).isEmpty()) {
                if (exist) {
                    mode.setSelectedItem(select);
                    resistor.setModel(mode);
                }
            } else {
                resistor.setSelectedIndex(0);
                resistor.setModel(mode);
            }};
        
        panelParalelo.addCambioNombre(evt);
        panelSerie.addCambioNombre(evt);
        
        // estilos
        setBackground(Theme.getColor("color.dark.panel"));
        
        jButton2.setBackground(Theme.getColor("color.dark.panel"));
        jButton2.setForeground(Theme.getColor("color.dark.fg"));
        jButton2.setBorder(BorderFactory.createLineBorder(Theme.getColor("color.border")));
        
        jButton3.setBackground(Theme.getColor("color.dark.panel"));
        jButton3.setForeground(Theme.getColor("color.dark.fg"));
        jButton3.setBorder(BorderFactory.createLineBorder(Theme.getColor("color.border")));
        
        jButton4.setBackground(Theme.getColor("color.dark.panel"));
        jButton4.setForeground(Theme.getColor("color.dark.fg"));
        jButton4.setBorder(BorderFactory.createLineBorder(Theme.getColor("color.border")));
        
        jPanel2.setBackground(Theme.getColor("color.dark.panel"));
        jPanel2.setBorder(BorderFactory.createLineBorder(Theme.getColor("color.border")));
                
        jPanel4.setBackground(Theme.getColor("color.dark.panel"));
        jLabel1.setForeground(Theme.getColor("color.dark.fg"));
        jLabel2.setForeground(Theme.getColor("color.dark.fg"));
        jLabel3.setForeground(Theme.getColor("color.dark.fg"));
        jLabel5.setForeground(Theme.getColor("color.dark.fg"));
        jLabel6.setForeground(Theme.getColor("color.dark.fg"));
        jLabel7.setForeground(Theme.getColor("color.dark.fg"));
        jLabel12.setForeground(Theme.getColor("color.dark.fg"));
        opcionParalelo.setForeground(Theme.getColor("color.dark.fg"));
        opcionSerie.setForeground(Theme.getColor("color.dark.fg"));
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
        jPanel1 = new javax.swing.JPanel();
        icon = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        value = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        rt = new javax.swing.JTextField();
        resistor = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        fiedlVolt = new javax.swing.JTextField();
        ntVol = new javax.swing.JComboBox<>();
        jPanel4 = new javax.swing.JPanel();
        view = new javax.swing.JScrollPane();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Source Sans Pro Black", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Tipo de divisores:");

        buttonGroup1.add(opcionSerie);
        opcionSerie.setForeground(new java.awt.Color(0, 0, 0));
        opcionSerie.setSelected(true);
        opcionSerie.setText("Divsor de voltage");
        opcionSerie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opcionSerieActionPerformed(evt);
            }
        });

        buttonGroup1.add(opcionParalelo);
        opcionParalelo.setForeground(new java.awt.Color(0, 0, 0));
        opcionParalelo.setText("Divisor de corriente");
        opcionParalelo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opcionParaleloActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Source Sans Pro Black", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Salida");

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
                .addComponent(icon, javax.swing.GroupLayout.DEFAULT_SIZE, 291, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)), "Resultados", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Cantarell", 0, 15), Theme.getColor("color.border2") // NOI18N
        ));

        jLabel3.setFont(new java.awt.Font("Source Sans Pro Black", 0, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Division:");

        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/bd_nextpage.png"))); // NOI18N
        jLabel5.setText("Vrx/Irx");

        value.setEditable(false);
        value.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        value.setText("0");
        value.setFocusable(false);
        value.setRequestFocusEnabled(false);

        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/bd_nextpage.png"))); // NOI18N
        jLabel6.setText("Resistencia");

        rt.setEditable(false);
        rt.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        rt.setText("0");
        rt.setFocusable(false);
        rt.setRequestFocusEnabled(false);

        resistor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<default...?>", "R1", "R2", "R3" }));
        resistor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resistorActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Source Sans Pro Black", 0, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Seleccionar Resistencia:");

        jLabel12.setFont(new java.awt.Font("Source Sans Pro Black", 0, 16)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 0));
        jLabel12.setText("Fuente:");

        fiedlVolt.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        fiedlVolt.setText("5");

        ntVol.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<default>", "K", "M", "G" }));
        ntVol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ntVolActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(fiedlVolt, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(value, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
                            .addComponent(rt, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
                            .addComponent(ntVol, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(resistor, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(106, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(resistor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(value, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fiedlVolt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ntVol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

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

        jButton4.setBackground(new java.awt.Color(255, 255, 255));
        jButton4.setForeground(new java.awt.Color(0, 0, 0));
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/b_sql.png"))); // NOI18N
        jButton4.setText("Calcular...");
        jButton4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setOpaque(false);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 56, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 5, Short.MAX_VALUE))
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(view, javax.swing.GroupLayout.PREFERRED_SIZE, 424, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(view, javax.swing.GroupLayout.PREFERRED_SIZE, 468, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(opcionSerie)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(opcionParalelo)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents
        
    JPanelCircuito getLocalCircuito() {
        return opcionSerie.isSelected() ? panelSerie   : opcionParalelo.isSelected() 
                                        ? panelParalelo : null;
    }
    
    void setLocalVoltios() {
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
    }
        
    void updateNTVol() {
        final Object value = ntVol.getSelectedItem();
        if (resistor == null)
            return;
        
        if (value instanceof String 
                && !((String) value).isEmpty()) {
            
            Circuito c = getLocalCircuito().getCircuito();
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
    }//GEN-LAST:event_jButton3ActionPerformed

    private void ntVolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ntVolActionPerformed
        updateNTVol();
    }//GEN-LAST:event_ntVolActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        setLocalVoltios();
        final JPanelCircuito circuito = getLocalCircuito();
        if (circuito != null) {
            circuito.start();
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void resistorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resistorActionPerformed
        final JPanelCircuito jpc = getLocalCircuito();
        final Circuito c = jpc.getCircuito();
        if (c != null) {
            final Object item = resistor.getSelectedItem();
            if ("<default...?>".equals(item)) {
                rt.setText("0");
                value.setText("0");
                return;
            }
            
            if (item instanceof String && !((String) item).isEmpty()) {
                for (final Resistor r : c.getResistencias()) {
                    if (r == null || r.getName() == null)
                        continue;

                    if (r.getName().equals(item)) {
                        if (r.isEnabled()) {
                            final JmeProperties jp = ((Divisible) jpc).getDivisor().getProperties(r);
                            
                            Notation notation = jp.getSavable(Divisor.KEY_VNT);
                            Notation b = Notation.determine(r.getOhmios());
                                                        
                            rt.setText(b.getUnscaleNumber() + b.getPrefix().getPrefix());
                            value.setText(Utils.doubleFormat(notation.getScaleNumber())+ notation.getPrefix().getPrefix());
                        } else {
                            rt.setText("0");
                            value.setText("0");
                        }
                    }
                }
            }
        }
    }//GEN-LAST:event_resistorActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JTextField fiedlVolt;
    private javax.swing.JLabel icon;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JComboBox<String> ntVol;
    private javax.swing.JRadioButton opcionParalelo;
    private javax.swing.JRadioButton opcionSerie;
    private javax.swing.JComboBox<String> resistor;
    private javax.swing.JTextField rt;
    private javax.swing.JTextField value;
    private javax.swing.JScrollPane view;
    // End of variables declaration//GEN-END:variables
}
