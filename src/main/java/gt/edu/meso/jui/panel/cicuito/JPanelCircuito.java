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
import gt.edu.meso.util.PanelTree;
import javax.swing.JComponent;
import javax.swing.JPanel;

/**
 * @author wil
 */
public abstract class JPanelCircuito extends JPanel {
    
    protected PanelTree tree;
    private Cambios cambios;
    
    public JPanelCircuito() {
        this.tree = new PanelTree(this);
    }
    
    protected void initDefResistencias() {
        final Circuito c = getCircuito();
        if (c == null)
            throw new NullPointerException("Circuito no valido");
        
        PanelResistencia p1 = new PanelResistencia("R1", c, false);
        PanelResistencia p2 = new PanelResistencia("R2", c, false);
        PanelResistencia p3 = new PanelResistencia("R3", c, false);
        
        tree.add(p1);
        tree.add(p2);
        tree.add(p3);
        
        c.agregar(p1.getResistor());
        c.agregar(p2.getResistor());
        c.agregar(p3.getResistor());
    }
    
    public void addCambiosListener(Cambios<? extends Circuito> c) {
        this.cambios = c;
        this.checkEVT();
    }
    
    private void checkEVT() {
        if (cambios == null)
            return;
        
        for (final JComponent jc : tree.getComponents()) {
            if (jc == null)
                continue;
            
            if (jc instanceof PanelResistencia) {
                if (((PanelResistencia) jc).getCambios() != cambios) {
                    ((PanelResistencia) jc).setCambios(cambios);
                }
            }
        }
    }
    
    public void add() {
        PanelResistencia panel = new PanelResistencia("R" + (getCircuito().cantidad() +1), getCircuito(), true);
        panel.setCambios(cambios);
        
        tree.add(panel);        
        getCircuito().agregar(panel.getResistor());
    }
    
    public void remove() {
        for (int i = 0; i < tree.getComponents().size(); i++) {
            final JComponent jc = tree.getComponents().get(i);
            if (jc == null)
                continue;
            
            if (jc instanceof PanelResistencia) {
                if (((PanelResistencia) jc).isSelected()) {
                    tree.remove(jc);
                    tree.remove(jc);
                    getCircuito().remover(((PanelResistencia) jc).getResistor());
                    i--;
                }
            }
        }
        updateName();
    }
    
    protected void updateName() {
        int i = 1;
        for (final JComponent jc : tree.getComponents()) {
            if (jc == null)
                continue;
            
            if (jc instanceof PanelResistencia) {
                ((PanelResistencia) jc).setID("R" + (i++));
            }
        }
    }
    
    public abstract Circuito getCircuito();
    
    public void setFuente(double fuente) {
        final Circuito c = getCircuito();
        if (c != null) {
            c.setFuente(fuente);
        }
    }
    
    public double getFuente() {
        final Circuito c = getCircuito();
        return c == null ? 0 : c.getFuente();
    }
}
