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

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.text.DecimalFormat;
import javax.imageio.ImageIO;

/**
 * @author wil
 * @author javier
 * @author santos
 */
public class Utils {
    
    /* Funcion auxiliar para leer las imagenes de la ruta de clase. */
    public static BufferedImage getImageSuppressExceptions(String pathOnClasspath) {
        try {
            return ImageIO.read(Utils.class.getResource(pathOnClasspath));
        } catch (IOException e) {
            return null;
        }
    } 
    
    public static String doubleFormat(double val) {
        DecimalFormat format = new DecimalFormat("###.##");
        return format.format(val);
    }
    
    public static String floatFormat(float val) {
        return doubleFormat(((Number) val).doubleValue());
    }
}
