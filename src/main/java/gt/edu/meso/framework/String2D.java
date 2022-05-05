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
package gt.edu.meso.framework;

import java.awt.image.BufferedImage;

import java.util.HashMap;
import java.util.Map;

/**
 * Clase encargado de generar los componetes graficos de una caden
 * de texto, para darle informacion sobre las bandas de las resistencias.
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
public final class String2D {
    
    /** Mapa/Diccionario de imagenes claros. */
    private static final Map<Character, BufferedImage> MAP_WHITE;
    
    /** Mapa/Diccionario de imagenes oscuro. */
    private static final Map<Character, BufferedImage> MAP_BLACK;
    
    /** Se inicializa los componets graficos y se registarn en sus
     respectivos mapas/diccionarios-*/
    static {
        // se inicializa el primer mapa.
        MAP_WHITE = new HashMap<>();
        
        // se inicializa el segundo mapa.
        MAP_BLACK = new HashMap<>();
        
        // registramos los diferentes componetes graficos.
        // en el mapa oscuro...
        MAP_BLACK.put('%', Resitor2D.getImageSuppressExceptions("/Icons/%.png"));
        MAP_BLACK.put('1', Resitor2D.getImageSuppressExceptions("/Icons/1.png"));
        MAP_BLACK.put('2', Resitor2D.getImageSuppressExceptions("/Icons/2.png"));
        MAP_BLACK.put('3', Resitor2D.getImageSuppressExceptions("/Icons/3.png"));
        MAP_BLACK.put('4', Resitor2D.getImageSuppressExceptions("/Icons/4.png"));
        MAP_BLACK.put('5', Resitor2D.getImageSuppressExceptions("/Icons/5.png"));
        MAP_BLACK.put('6', Resitor2D.getImageSuppressExceptions("/Icons/6.png"));
        MAP_BLACK.put('7', Resitor2D.getImageSuppressExceptions("/Icons/7.png"));
        MAP_BLACK.put('8', Resitor2D.getImageSuppressExceptions("/Icons/8.png"));
        MAP_BLACK.put('9', Resitor2D.getImageSuppressExceptions("/Icons/9.png"));
        MAP_BLACK.put('0', Resitor2D.getImageSuppressExceptions("/Icons/0.png"));
        MAP_BLACK.put('K', Resitor2D.getImageSuppressExceptions("/Icons/K.png"));
        MAP_BLACK.put('M', Resitor2D.getImageSuppressExceptions("/Icons/M.png"));
        MAP_BLACK.put('G', Resitor2D.getImageSuppressExceptions("/Icons/G.png"));
        MAP_BLACK.put('.', Resitor2D.getImageSuppressExceptions("/Icons/punto1.png"));
        MAP_BLACK.put('$', Resitor2D.getImageSuppressExceptions("/Icons/E_01.png"));
        MAP_BLACK.put('x', Resitor2D.getImageSuppressExceptions("/Icons/x.png"));
        MAP_BLACK.put('#', Resitor2D.getImageSuppressExceptions("/Icons/ohm01.png"));
        
        // registramos los diferentes componetes graficos.
        // en el mapa claro...
        MAP_WHITE.put('%', Resitor2D.getImageSuppressExceptions("/Icons/%%.png"));
        MAP_WHITE.put('1', Resitor2D.getImageSuppressExceptions("/Icons/01.png"));
        MAP_WHITE.put('2', Resitor2D.getImageSuppressExceptions("/Icons/02.png"));
        MAP_WHITE.put('3', Resitor2D.getImageSuppressExceptions("/Icons/03.png"));
        MAP_WHITE.put('4', Resitor2D.getImageSuppressExceptions("/Icons/04.png"));
        MAP_WHITE.put('5', Resitor2D.getImageSuppressExceptions("/Icons/05.png"));
        MAP_WHITE.put('6', Resitor2D.getImageSuppressExceptions("/Icons/06.png"));
        MAP_WHITE.put('7', Resitor2D.getImageSuppressExceptions("/Icons/07.png"));
        MAP_WHITE.put('8', Resitor2D.getImageSuppressExceptions("/Icons/08.png"));
        MAP_WHITE.put('9', Resitor2D.getImageSuppressExceptions("/Icons/09.png"));
        MAP_WHITE.put('0', Resitor2D.getImageSuppressExceptions("/Icons/00.png"));
        MAP_WHITE.put('K', Resitor2D.getImageSuppressExceptions("/Icons/KK.png"));
        MAP_WHITE.put('M', Resitor2D.getImageSuppressExceptions("/Icons/MM.png"));
        MAP_WHITE.put('G', Resitor2D.getImageSuppressExceptions("/Icons/GG.png"));
        MAP_WHITE.put('.', Resitor2D.getImageSuppressExceptions("/Icons/punto01.png"));
        MAP_WHITE.put('$', Resitor2D.getImageSuppressExceptions("/Icons/E_02.png"));
        MAP_WHITE.put('x', Resitor2D.getImageSuppressExceptions("/Icons/xx.png"));
        MAP_WHITE.put('#', Resitor2D.getImageSuppressExceptions("/Icons/ohm02.png"));
    }

    /**
     * Constructor predeterminado.
     */
    private String2D() {
        // TODO: El codigo JAVA...
    }
    
    /**
     * Genera un areglo de imagenes en base al texto.
     * @param text Un cade de texto.
     * @param black {@code true} si queremos imagenes oscuros, de
     *                  lo contrario {@code false}.
     * @return Arreglo de imagenes que se genero en base
     *              al texto que recibimos por parametro.
     */
    public static BufferedImage[] createBuffered(String text, boolean black) {
        BufferedImage[] bufffer = new BufferedImage[text.length()];
        for (int i = 0; i < text.length(); i++) {
            char car = text.charAt(i);
            if (black) {
                if (MAP_BLACK.containsKey(car)) {
                    bufffer[i] = MAP_BLACK.get(car);
                } else {
                    bufffer[i] = null;
                }
            } else {
                if (MAP_WHITE.containsKey(car)) {
                    bufffer[i] = MAP_WHITE.get(car);
                } else {
                    bufffer[i] = null;
                }
            }
        }        
        return bufffer;
    }
}
