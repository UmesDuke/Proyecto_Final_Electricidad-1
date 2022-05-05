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

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;

import java.io.IOException;
import java.io.InputStream;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

/**
 * La clase <code>Tipografias</code> se encarga de cargar y registar los diferentes
 * tipos de fuentes que utiliza la aplicacion. Lee la informacion desde un fichero JSON.
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
public final class Tipografias {

    /** Logger de la clase. */
    private static final Logger LOG = Logger.getLogger(Tipografias.class.getName());
    
    /** Carga las funtes. */
    public static void loaderFonts() {
        try {
            //Objeto encargado de administrar las graficas.
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            
            // Localizamos el JSON con la informacion de los diferentes tipos de fubtes.
            JSONObject jsono = new JSONObject(new JSONTokener(Tipografias.class.getResourceAsStream("/font-info.json")));
            // Obtenemos una lista de objeto JSON.
            JSONArray fontInfo = jsono.optJSONArray("font");
            
            if (fontInfo != null) {
                // Iteramos la lista de fuentes a registrar.
                for (int index = 0; index < fontInfo.length(); index++) {
                    // Informacion de la funete.
                    JSONObject font = fontInfo.getJSONObject(index);
                    
                    // Cargamos la funete.
                    Font fnt = loaderFont(font.getString("path"));
                    // registramos la fuente para esta disponible para
                    // toda la aplicacion.
                    ge.registerFont(fnt.deriveFont(15));
                    
                    // Informacion por consola que se a cargado dicha funte, y
                    // que ademas se a registrado.
                    LOG.log(Level.INFO, "FONT FAMILY\n\t[ OK ] :Cargando {0}\n\t[ OK ] :Attributos {1}", new Object[]{fnt.getName(), fnt.toString()});
                    
                }
            }
        } catch (JSONException e) {
            throw new InternalError(e);
        }
    }
    
    /**
     * Metodo encargado de carga una funtes desde el disco.
     * @param fontname ruta o nombre de la fuente.
     * @return Objeto fuente de JAVA.
     */
    public static Font loaderFont(String fontname) {
        try {
            // Obtenemos los bytes del fichero fuente.
            InputStream in = Tipografias.class.getResourceAsStream(fontname);
            // Creamos la fuente.
            return Font.createFont(Font.TRUETYPE_FONT, in);
        } catch (FontFormatException | IOException e) {
            // Un mensage de error.
            System.err.println("throws: " + e.getMessage() + '[' + fontname + ']');
            // funete por defecto.
            return new Font(Font.DIALOG, Font.PLAIN, 14);
        }
    }
}
