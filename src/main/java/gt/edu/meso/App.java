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
package gt.edu.meso;

import com.formdev.flatlaf.FlatIntelliJLaf;

import gt.edu.meso.jui.Cargador;
import gt.edu.meso.util.Tipografias;

import java.awt.EventQueue;
import java.awt.Font;

import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.FontUIResource;

/**
 * Clase principla encargado de inicializar la intererfaz grafica del
 * usuario....
 * 
 * @author wil
 * @author Javier
 * @author Santos
 * 
 * @version 1.0.0
 * @since 1.0.0
 */
public class App {
    
    /**
     * Metodo principal <code>main()</code> encargado de gestionar las entradas y
     * salidas del programa JAVA.
     * @param args Argumentos de la linea de comando.
     */
    public static void main(String[] args) {
        /* Establece FlatIntelliJLaf como look and feel.*/
        try {
            UIManager.setLookAndFeel(new FlatIntelliJLaf());
            
            final Font defFont = Tipografias.loaderFont("/Fonts/Cantarell-test/Cantarell.ttf").deriveFont(Font.PLAIN, 15);
            for (Map.Entry<Object, Object> entry : UIManager.getDefaults().entrySet()) {
                Object key = entry.getKey();
                Object value = UIManager.get(key);
                if (value != null && value instanceof FontUIResource) {
                    UIManager.put(key, new FontUIResource(defFont));
                }
            }
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Tipografias.loaderFonts();
        
        //</editor-fold>
        /* Create and display the form */
        EventQueue.invokeLater(() -> {
            new Cargador().setVisible(true);
        });
    }
}
