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
import gt.edu.meso.circuito.Serie;
import gt.edu.meso.util.PanelTree;
import javax.swing.JPanel;

/**
 * @author wil
 */
public class PanelSerie extends JPanel {
    
    private Circuito circuitoSerie;
    private PanelTree panelTree;
    
    public PanelSerie() {
        initComponents();
        componentesAdd();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new java.awt.GridLayout(3, 0));
    }// </editor-fold>//GEN-END:initComponents

    final void componentesAdd() {
        circuitoSerie = new Serie();
        panelTree = new PanelTree(this);
        
        PanelResistencia p1 = new PanelResistencia("R1", false);
        PanelResistencia p2 = new PanelResistencia("R2", false);
        PanelResistencia p3 = new PanelResistencia("R3", false);
        
        panelTree.add(p1);
        panelTree.add(p2);
        panelTree.add(p3);
        
        circuitoSerie.agregar(p1.getResistor());
        circuitoSerie.agregar(p2.getResistor());
        circuitoSerie.agregar(p3.getResistor());
    }

        
    public void add() {
        PanelResistencia pr = new PanelResistencia(("R" + (circuitoSerie.cantidad() + 1)), true);
        panelTree.add(pr);
        circuitoSerie.agregar(pr.getResistor());
    }
    
    public void setFuente(double fuente) {
        circuitoSerie.setFuente(fuente);
        circuitoSerie.start();
    }

    public double getFuente() {
        return circuitoSerie.getFuente();
    }

    public Circuito getCircuito() {
        if (circuitoSerie != null) {
            circuitoSerie.start();
        }
        return circuitoSerie;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
