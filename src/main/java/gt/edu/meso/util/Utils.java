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

import com.jme3.export.Savable;
import com.jme3.system.JmeSystem;

import java.awt.image.BufferedImage;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.imageio.ImageIO;

import jme3tools.savegame.SaveGame;

import org.apache.commons.math3.util.Precision;
import org.monkey.JmeProperties;

/**
 * @author wil
 * @author javier
 * @author santos
 */
public class Utils {

    /** Logger de la clase <code>Utils</code>. */
    private static final Logger LOG = Logger.getLogger(Utils.class.getName());
    
    /** Nombre del fichero donde se guardadn las configuraciones. */
    static final String FILE_NAME = "gt_edu_meso_electicidad-1E-wizzard.umes.dat";
    
    /** Nombre del directorido de la configuraciones. */
    static final String FILE_HOME = "wizzard-electricidad-1E";  
    
    /** Objeto de propiedades Wizzadr(configuraciones). */
    private static JmeProperties PROPERTIES;
    
    /** carga los datos de la aplicacion. */
    public static void loader() {
        File home = new File(JmeSystem.getStorageFolder(JmeSystem.StorageFolderType.External), FILE_HOME + '/' + FILE_NAME);
        if (home.exists()) {
            Savable obj = SaveGame.loadGame(FILE_HOME, FILE_NAME, JmeSystem.StorageFolderType.External);
            PROPERTIES  = (JmeProperties) obj;
            LOG.log(Level.INFO, "[ OK ] :Load data => ({0})", home.toURI());
            
        } else {
            PROPERTIES = new JmeProperties();
            save();
        }
    }    
    /** guardar los cambios de las configuraciones el dicsco. */
    public static void save() {
        SaveGame.saveGame(FILE_HOME, FILE_NAME, PROPERTIES, JmeSystem.StorageFolderType.External);
        
        File f = new File(JmeSystem.getStorageFolder(JmeSystem.StorageFolderType.External), FILE_HOME + '/' + FILE_NAME);
        LOG.log(Level.INFO, "[ OK ] :Save data => ({0})", f.toURI());
    }
    public static JmeProperties getProperties() {
        return PROPERTIES;
    }
    
    
    /* Funcion auxiliar para leer las imagenes de la ruta de clase. */
    public static BufferedImage getImageSuppressExceptions(String pathOnClasspath) {
        try {
            return ImageIO.read(Utils.class.getResource(pathOnClasspath));
        } catch (IOException e) {
            return null;
        }
    } 
    
    public static String doubleFormat(double val) {
        //DecimalFormat format = new DecimalFormat("0.000");
        //return format.format(val);
        double d = Precision.round(val, 2);
        return Double.toString(d);
    }
    
    public static String floatFormat(float val) {
        //return doubleFormat(((Number) val).doubleValue());
        float f = Precision.round(val, 2);
        return Float.toString(f);
    }
}
