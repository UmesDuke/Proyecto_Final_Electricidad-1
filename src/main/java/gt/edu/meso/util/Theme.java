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

import com.jme3.export.binary.BinaryImporter;
import java.awt.Color;
import java.io.IOException;
import org.monkey.JmeProperties;

/**
 * Clase encargado de gestionar el temas de la aplicacion.
 * @author wil
 * @version 1.0.0
 * @see 1.0.0
 */
public class Theme {
    
    /** Tipo de temas. */
    public static enum Type {
        //tema oscuro.
        Dark("/Theme/dark_1E.theme"), 
        //tema clasro.
        Linght("/Theme/light_1E.theme");
        
        String path;
        private Type(String path) {
            this.path = path;
        }
    }
    
    /** Tema actual de la apliecacion.*/
    static Theme defTheme;
    
    /**
     * Metodo encargado de cargar el tema segun la configuracón
     * del usuario.
     */
    public static void loadTheme() {
        final JmeProperties jp = Utils.getProperties();
        try {
            Type type = jp.optEnum("App.theme", Type.Linght);
            BinaryImporter importer = BinaryImporter.getInstance();            
            defTheme = new Theme((JmeProperties) importer.load(Theme.class.getResource(type.path)));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    
    //devuelve un color segun la llave,
    public static Color getColor(String key) {
        return new Color(defTheme.user.getInt(key));
    }
    // devuelve el nombre de la apariencia que utilizara
    // la ventana o aplicacion.
    public static String getNameLookAndFeel() {
        return defTheme.user.getString("lookAndFeel");
    }
    
    JmeProperties user;
    private Theme(JmeProperties user) {
        this.user = user;
    }
}
