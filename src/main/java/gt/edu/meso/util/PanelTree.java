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

import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JComponent;
import javax.swing.JPanel;

/**
 * @author wil
 */
public class PanelTree {
static final int DEF = 3;
    
    private final ArrayList<JComponent> components;
    private final Dimension preSize;
    private final JPanel panel;

    int cols    = 0;
    int rows    = DEF;
    int length  = 1;
    
    public PanelTree(JPanel panel) {
        this.components = new ArrayList<>();
        this.preSize = panel.getPreferredSize();
        
        panel.setLayout(new GridLayout(rows, cols));
        this.panel   = panel;        
    }
    
    public void add(JComponent jc) {
        final Dimension d = jc.getPreferredSize();
        
        if ((d.height * length) > preSize.height) {
            rows++;
        }
        
        panel.add(jc);
        panel.setLayout(new GridLayout(components.size() +1, 0));
        
        components.add(jc);
        length++;
    }

    public ArrayList<JComponent> getComponents() {
        return components;
    }
    
    public synchronized void remove(JComponent jc) {
        panel.remove(jc);
        components.remove(jc);
        
        length--;
        rows--;
        
        if (rows < DEF) {
            rows = DEF;
        }
        
        panel.setLayout(new GridLayout(components.size() +1, 0));
    }
}
