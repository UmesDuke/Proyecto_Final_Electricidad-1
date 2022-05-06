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
 * @author wil
 */
public class PanelTree {
static final int DEF = 7;
    
    private final ArrayList<JComponent> components;
    private final JPanel panel;
    
    public PanelTree(JPanel panel) {
        this.components = new ArrayList<>();
        
        panel.setLayout(new GridLayout(DEF, 0));
        this.panel   = panel;        
    }
    
    public void add(JComponent jc) {
        panel.add(jc);
       
        checkLayout();
        components.add(jc);
    }

    private void checkLayout() {
        if ((components.size() + 1) < DEF) {
            panel.setLayout(new GridLayout(DEF, 0));
        } else {
            panel.setLayout(new GridLayout(components.size() + 1, 0));
        }
    }
    
    public ArrayList<JComponent> getComponents() {
        return components;
    }
    
    public synchronized void remove(JComponent jc) {
        panel.remove(jc);
        components.remove(jc);
        checkLayout();
    }
}
