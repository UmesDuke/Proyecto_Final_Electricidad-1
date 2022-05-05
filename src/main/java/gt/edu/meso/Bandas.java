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

import gt.edu.meso.util.JColor;

/**
 * La clase <code>Bandas</code> se encarga de tomar el rol de padre/madre de toas
 * las clase que calculen los diferentes valores de los colores de bandas de una
 * resistencia.
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
public abstract class Bandas {
    
    /** Colores disponibles para los valores de bandas. */
    public static final JColor[] BANDA = {
        JColor.BLACK,   JColor.BROWN,
        JColor.RED,     JColor.ORANGE,
        JColor.YELLOW,  JColor.GREEN,
        JColor.BLUE,    JColor.VIOLET,
        JColor.GRAY,    JColor.WHITE
    };
    
    /** Colores para el multiplicador de colores. */
    public static final JColor[] MULTIPLICADOR = {
        JColor.BLACK,   JColor.BROWN,
        JColor.RED,     JColor.ORANGE,
        JColor.YELLOW,  JColor.GREEN,
        JColor.BLUE,    JColor.VIOLET,
        JColor.GRAY,    JColor.WHITE,
        JColor.GOLD,    JColor.SILVER
    };
    
    /** Colores para la tolerancia de colores. */
    public static final JColor[] TOLERANCIA = {
        JColor.BROWN,   JColor.RED,
        JColor.GREEN,   JColor.BLUE,
        JColor.VIOLET,  JColor.GRAY,
        JColor.GOLD,    JColor.SILVER
    };
    
    /** Colore para la tolerancia. */
    protected JColor tolerance  = JColor.DEFAULT;
    
    /** Color para el multiplicador. */
    protected JColor multiplier = JColor.DEFAULT;

    /**
     * Constructor predeterminado.
     */
    public Bandas() {
    }

    /**
     * Establece el color de la tolerancia.
     * @param tolerance Color banda.
     */
    public void setTolerance(JColor tolerance) {
        this.tolerance = tolerance;
    }

    /**
     * Establece el color del multiplicador.
     * @param multiplier Color banda.
     */
    public void setMultiplier(JColor multiplier) {
        this.multiplier = multiplier;
    }
    
    /**
     * Devuelve el numero de bandas que se esta utilizando.
     * <p>
     * Actualmente solo esta soportado d 4 a 5 bandas.
     * @since 1.0.0
     *
     * @return Cantidad de bandas.
     */
    public abstract int length();
    
    /**
     * Devuelve un arreglo de colores.
     * @return Colores para las bandas.
     */
    public abstract JColor[] getColors();

    /**
     * Devuelve el valor calculado de las bandas.
     * @return Valor calculado de la resistencia.
     */
    public abstract double getOhms();
    
    /**
     * Devuelve el colores de la tolerancia.
     * @return Color.
     */
    public JColor getTolerance() {
        return tolerance;
    }

    /**
     * Devuelve el color del multiplicador.
     * @return Color.
     */
    public JColor getMultiplier() {
        return multiplier;
    }
    
    /**
     * Determina si los colores son imprimibles.
     * @return Un valor logico.
     */
    public abstract boolean isPrintf();
    
    /**
     * Verifica si los colores son validos.
     * @param colors areglo de colores.
     * @return Un valor logico.
     */
    protected boolean isVal(JColor... colors) {
        if (colors == null)
            return false;
        
        for (final JColor color : colors) {
            if (color.equals(JColor.DEFAULT)) {
                return false;
            }
        }
        
        return true;
    }
}
