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

import gt.edu.meso.util.JColor;
import gt.edu.meso.util.Notation;
import gt.edu.meso.util.Theme;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import javax.swing.BorderFactory;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;

/**
 * Un <code>JColorListCellRenderer</code> se encarga de renderizar los objetos o
 * articulo de la lista de un {@link javax.swing.JComboBox}..
 * @author wil
 * @version 1.0.0
 * @see 1.0.0
 */
public final class JColorListCellRenderer extends JPanel implements ListCellRenderer<JColor> {
    
    /**
     * Clase enumerada encargado de definir los 3 tipo
     * de bandas de colores que puede tener un {@link javax.swing.JComboBox}.
     */
    public static enum TypeComboModel {
        
        /**
         * Banda de color.
         */
        COLOR_BANDA,
        
        /**
         * Banda multiplicador.
         */
        COLOR_MULTIPLICADOR,
        
        /**
         * Banda tolerancia.
         */
        COLOR_TOLERANCIA;
    }

    /**
     * El tipo de modelo que utiliza el combo.
     */
    private final TypeComboModel model;
    
    /**
     * Crea un nuevo formulario <code>JColorListCellRenderer</code>
     * @param model Tipo del modelo.
     */
    public JColorListCellRenderer(TypeComboModel model) {
        this.model = model;
        initComponents();
        setBorder(BorderFactory.createLineBorder(Theme.getColor("color.def.box"), 3));
    }

    /**
     * Devuelve el tipo de modelo establecido.
     * @return Tipo de modelo.
     */
    public TypeComboModel getModel() {
        return model;
    }

    /**
     * Se llama a este metodo desde el constructor para inicializar el formulario. 
     * ADVERTENCIA: NO modifique este codigo. El contenido de este metodo es siempre 
     * regenerado por el Editor de Formularios.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        name = new javax.swing.JLabel();
        value = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3));
        setForeground(new java.awt.Color(255, 255, 255));

        name.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        name.setText("Name");

        value.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        value.setText("Value");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(name, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(value, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(value, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
            .addComponent(name, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    @Override
    public Component getListCellRendererComponent(JList<? extends JColor> jlist, JColor color, int index, boolean selected, boolean focus) {
        final Color awtColor = color.getAWTColor();
        
        // Si el indice es mayor a -1, entonce procedemos a pintar el
        // panel deacuerdo al color de la banda.
        if (index > -1) {
            if (selected) {
                if (!awtColor.equals(Color.WHITE)) {
                    this.setBackground(awtColor.darker());
                } else {
                    this.setBackground(awtColor);
                }
                jlist.setCursor(new Cursor(Cursor.HAND_CURSOR));
            } else {
                jlist.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                
                this.setBackground(awtColor);
            }
        }
        
        // Para que el texto no se vea opacada con el color de fondo,
        // establecemos un color a los textos.
        if (awtColor.equals(Color.WHITE)) {
            name.setForeground(new Color(0, 0, 0));
            value.setForeground(new Color(0, 0, 0));
        } else {
            name.setForeground(new Color(255, 255, 255));
            value.setForeground(new Color(255, 255, 255));
        }
        
        name.setText(color.getName());
        
        switch (model) {
            case COLOR_BANDA:
                final int val = (int) color.getValue();
                value.setText(Integer.toString(val));
                break;
            case COLOR_MULTIPLICADOR:
                final double  mult = color.getMultiplier();
                final String prefx = color.getMultiplierPrefix();
                
                Notation notation;                
                switch (prefx) {
                    case "K":
                        notation = new Notation(mult, Notation.Prefix.Kilo);
                        break;
                    case "M":
                        notation = new Notation(mult, Notation.Prefix.Mega);
                        break;
                    case "G":
                        notation = new Notation(mult, Notation.Prefix.Giga);
                        break;
                    default:
                        notation = new Notation(mult);
                        break;
                }
                
                if (mult >= 1) {
                    int multInt = (int) notation.getUnscaleNumber();
                    value.setText("x" + multInt + color.getMultiplierPrefix() + " Ohms");
                } else {
                    value.setText("x" + mult + color.getMultiplierPrefix() + " Ohms");
                }
                break;
            case COLOR_TOLERANCIA:
                final double tol = color.getScaleTolerance();
                if (tol >= 1) {
                    int tolInt = (int) tol;
                    value.setText("+/-" + tolInt + '%');
                } else {
                    value.setText("+/-" + tol + '%');
                }
                break;
            default:
                throw new AssertionError();
        }
        return this;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel name;
    private javax.swing.JLabel value;
    // End of variables declaration//GEN-END:variables
}
