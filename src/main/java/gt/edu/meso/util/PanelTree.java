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
package gt.edu.meso.util;

import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JComponent;
import javax.swing.JPanel;

/**
 * Clase encargado de gestionar un arbol de componentes graficos.
 * @author wil
 */
public class PanelTree {
static final int DEF = 7; //Cantidad predeterminado de componentes que
                          // puede tener el arbo.

    /** Lista de componentes. */
    private final ArrayList<JComponent> components;
    
    /** Contenedor padre. */
    private final JPanel panel;
    
    public PanelTree(JPanel panel) {
        this.components = new ArrayList<>();
        
        panel.setLayout(new GridLayout(DEF, 0));
        this.panel   = panel;        
    }
    
    // agrega un componente al abo.
    public void add(JComponent jc) {
        panel.add(jc);
       
        checkLayout();
        components.add(jc);
    }

    // verifica el layout del
    // arbol...
    private void checkLayout() {
        if ((components.size() + 1) < DEF) {
            panel.setLayout(new GridLayout(DEF, 0));
        } else {
            panel.setLayout(new GridLayout(components.size() + 1, 0));
        }
    }
    
    // devuelve la lista de componentes.
    public ArrayList<JComponent> getComponents() {
        return components;
    }
    
    // elimina un componete del arbol.
    public synchronized void remove(JComponent jc) {
        panel.remove(jc);
        components.remove(jc);
        checkLayout();
    }
}
