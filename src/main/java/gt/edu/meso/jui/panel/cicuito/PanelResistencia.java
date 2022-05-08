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
package gt.edu.meso.jui.panel.cicuito;

import gt.edu.meso.circuito.Circuito;
import gt.edu.meso.circuito.Resistor;
import gt.edu.meso.jui.Window;
import gt.edu.meso.util.Notation;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * @author wil
 */
@SuppressWarnings("unchecked")
public class PanelResistencia extends JPanel {

    private final Resistor resistor;
    private final Circuito circuito;
    private Cambios cambios;
    
    public PanelResistencia(String name, Circuito circuito, boolean isSelected) {
        initComponents();
        if (!isSelected) {
            box.setSelected(false);
            box.setVisible(false);
        }
        this.resistor = new Resistor();
        this.circuito = circuito;
        this.setID(name);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        name = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        in = new javax.swing.JTextField();
        boxNotation = new javax.swing.JComboBox<>();
        box = new javax.swing.JCheckBox();

        setBackground(new java.awt.Color(255, 255, 255));

        name.setFont(new java.awt.Font("Source Sans Pro SemiBold", 0, 17)); // NOI18N
        name.setForeground(new java.awt.Color(0, 0, 0));
        name.setText("R0");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        in.setBackground(new java.awt.Color(255, 255, 255));
        in.setForeground(new java.awt.Color(0, 0, 0));
        in.setText("0");
        in.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 4));
        in.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                inKeyTyped(evt);
            }
        });

        boxNotation.setBackground(new java.awt.Color(255, 255, 255));
        boxNotation.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ohmios", "K Ohmios", "M Ohmios", "G Ohmios" }));
        boxNotation.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3));
        boxNotation.setFocusable(false);
        boxNotation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxNotationActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(in, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(boxNotation, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(in, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
            .addComponent(boxNotation)
        );

        box.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(name, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(box)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(name)
                    .addComponent(box))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents
    
    void setLocalOhmios() {
        synchronized (this) {
            String value = in.getText();
            if (value == null
                    || value.isEmpty()) {
                return;
            }
            
            try {
                value = value.trim();
                double d = Double.parseDouble(value);
                
                resistor.setOhmios(d);
                resistor.setEnabled(d > 0);
                
                updateNotattion();
                if (cambios != null) {
                    cambios.cambio(circuito);
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "El valor \"" + value+ "\" no es valido.", "Error - " + Window.TITLE,
                                                JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    private void inKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_inKeyTyped
        setLocalOhmios();
    }//GEN-LAST:event_inKeyTyped

    private void boxNotationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxNotationActionPerformed
        setLocalOhmios();
    }//GEN-LAST:event_boxNotationActionPerformed

    public void setSelected(boolean selected)  { this.box.setSelected(selected);}
    public void setCambios(Cambios<?> cambios) { this.cambios = cambios; }
    public void setID(String name) { 
        this.resistor.setName(name);
        this.box.setToolTipText("Seleccionar " + name);
        this.name.setText(name);       
    }
        
    public boolean isSelected() { return this.box.isSelected(); }    
    public String getID()       { return this.name.getText();   }
    public Cambios<?> getCambios() { return cambios; }
    public Resistor getResistor()  { return resistor; }
    
    @Override
    public String getName() {
        return getID();
    }
    
    void updateNotattion() {
        final Object value = boxNotation.getSelectedItem();
        if (resistor == null)
            return;
        
        if (value instanceof String 
                && !((String) value).isEmpty()) {
            Notation notation;
            switch (String.valueOf(value)) {
                case "Ohmios":
                    notation = new Notation(resistor.getOhmios(),
                                            Notation.Prefix.Default);
                    break;
                case "K Ohmios":
                    notation = new Notation(resistor.getOhmios(),
                                            Notation.Prefix.Kilo);
                    break;
                case "M Ohmios":
                    notation = new Notation(resistor.getOhmios(),
                                            Notation.Prefix.Mega);
                    break;
                case "G Ohmios":
                    notation = new Notation(resistor.getOhmios(),
                                            Notation.Prefix.Giga);
                    break;
                default:
                    throw new AssertionError(getClass().getName());
            }
            if (notation != null) {
                resistor.setOhmios(notation.getScaleNumber());
            }
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox box;
    private javax.swing.JComboBox<String> boxNotation;
    private javax.swing.JTextField in;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel name;
    // End of variables declaration//GEN-END:variables
}
