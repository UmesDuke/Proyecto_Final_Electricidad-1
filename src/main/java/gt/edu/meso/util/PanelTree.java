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
import javax.swing.JComponent;
import javax.swing.JPanel;

/**
 * @author wil
 */
public class PanelTree {
    
    private final Dimension preSize;
    private final GridLayout layout;
    private final JPanel panel;

    int cols    = 0;
    int rows    = 3;
    int length  = 1;
    
    public PanelTree(JPanel panel) {
        this.preSize = panel.getPreferredSize();
        this.layout  = new GridLayout(rows, cols);
        
        this.panel   = panel;
        this.panel.setLayout(layout);
    }
    
    public void add(JComponent jc) {
        final Dimension d = jc.getPreferredSize();
        
        if ((d.height * length) > preSize.height) {
            rows++;
        }
        layout.setColumns(cols);
        layout.setRows(rows);
        
        panel.add(jc);        
        length++;
    }
    
    public void remove(JComponent jc) {
        layout.setColumns(cols);
        layout.setRows(rows);
        
        panel.remove(jc);
        length--;
    }
}
