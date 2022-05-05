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

import com.jme3.export.InputCapsule;
import com.jme3.export.JmeExporter;
import com.jme3.export.JmeImporter;
import com.jme3.export.OutputCapsule;
import com.jme3.export.Savable;

import java.awt.Color;
import java.io.IOException;
import java.util.Objects;

/**
 * Un <code>JColor</code> se encarga de almacenar los datos de un color que
 * se utiliza en las bandas de las resistencias.
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
public final class JColor implements Cloneable, Savable {
    
    /**
     * Banda de color BLACK
     * <pre><code>
     * --Valor          : 0
     * --Multiplicador  : x1
     * --Tolerancia     : No soportado
     * --Codigo RGB     : red=0, gree=0, blue=0
     * --Nombre color   : Negro</code></pre>
     */
    public static final JColor BLACK    = new JColor(0, 1, Double.NaN, 0, 0, 0, "Negro");
    
    /**
     * Banda de color BROWN
     * <pre><code>
     * --Valor          : 1
     * --Multiplicador  : x10
     * --Tolerancia     : 1%
     * --Codigo RGB     : red=81, gree=38, blue=39
     * --Nombre color   : Cafe/Marron</code></pre>
     */
    public static final JColor BROWN    = new JColor(1, 10, 0.01, 81, 38, 39, "Marron");
    
    /**
     * Banda de color RED
     * <pre><code>
     * --Valor          : 2
     * --Multiplicador  : x100
     * --Tolerancia     : 2%
     * --Codigo RGB     : red=204, gree=0, blue=0
     * --Nombre color   : Rojo</code></pre>
     */
    public static final JColor RED      = new JColor(2, 100, 0.02, 204, 0, 0, "Rojo");
    
    /**
     * Banda de color ORANGE 
     * <pre><code>
     * --Valor          : 3
     * --Multiplicador  : x1K
     * --Tolerancia     : No soportado
     * --Codigo RGB     : red=216, gree=115, blue=71
     * --Nombre color   : Naranja</code></pre>
     */
    public static final JColor ORANGE   = new JColor(3, 1000, Double.NaN, 216, 115, 71, "Naranja");
    
    /**
     * Banda de color YELLOW
     * <pre><code>
     * --Valor          : 4
     * --Multiplicador  : x10K
     * --Tolerancia     : No soportado
     * --Codigo RGB     : red=230, gree=201, blue=81
     * --Nombre color   : Amarillo</code></pre>
     */
    public static final JColor YELLOW   = new JColor(4, 10000, Double.NaN, 230, 201, 81, "Amarillo");
    
    /**
     * Banda de color GREEN
     * <pre><code>
     * --Valor          : 5
     * --Multiplicador  : x100K
     * --Tolerancia     : 0.5%
     * --Codigo RGB     : red=82, gree=143, blue=101
     * --Nombre color   : Verde</code></pre>
     */
    public static final JColor GREEN    = new JColor(5, 100000, 0.005, 82, 143, 101, "Verde");
    
    /**
     * Banda de color BLUE
     * <pre><code>
     * --Valor          : 6
     * --Multiplicador  : x1M
     * --Tolerancia     : 0.25%
     * --Codigo RGB     : red=15, gree=81, blue=144
     * --Nombre color   : Azul</code></pre>
     */
    public static final JColor BLUE     = new JColor(6, 1000000, 0.0025, 15, 81, 144, "Azul");
    
    /**
     * Banda de color VIOLET
     * <pre><code>
     * --Valor          : 6
     * --Multiplicador  : x10M
     * --Tolerancia     : 0.1%
     * --Codigo RGB     : red=105, gree=103, blue=206
     * --Nombre color   : Violeta</code></pre>
     */
    public static final JColor VIOLET   = new JColor(6, 10000000, 0.001, 105, 103, 206, "Violeta");
    
    /**
     * Banda de color GRAY
     * <pre><code>
     * --Valor          : 8
     * --Multiplicador  : x100M
     * --Tolerancia     : 0.05%
     * --Codigo RGB     : red=125, gree=125, blue=125
     * --Nombre color   : Gris</code></pre>
     */
    public static final JColor GRAY     = new JColor(8, 100000000, 0.0005, 125, 125, 125, "Gris");
    
    /**
     * Banda de color WHITE
     * <pre><code>
     * --Valor          : 9
     * --Multiplicador  : x1G
     * --Tolerancia     : No soportado
     * --Codigo RGB     : red=255, gree=255, blue=255
     * --Nombre color   : Blanco</code></pre>
     */
    public static final JColor WHITE    = new JColor(9, 1000000000, Double.NaN, 255, 255, 255, "Blanco");
    
    /**
     * Banda de color GOLD
     * <pre><code>
     * --Valor          : No soportado
     * --Multiplicador  : x0.1
     * --Tolerancia     : 5%
     * --Codigo RGB     : red=192, gree=131, blue=39
     * --Nombre color   : Oro</code></pre>
     */
    public static final JColor GOLD     = new JColor(Double.NaN, 0.1, 0.05, 192, 131, 39, "Oro");

    /**
     * Banda de color SILVER
     * <pre><code>
     * --Valor          : No soportado
     * --Multiplicador  : x0.01
     * --Tolerancia     : 10%
     * --Codigo RGB     : red=191, gree=190, blue=191
     * --Nombre color   : Plata</code></pre>
     */
    public static final JColor SILVER   = new JColor(Double.NaN, 0.01, 0.1, 191, 190, 191, "Plata");
    
    /** Color de banda por defecto .*/
    public static final JColor DEFAULT  = new JColor(Double.NaN, Double.NaN, Double.NaN, 192, 192, 192, null);
    
    /**
     * Cada banda de color tiene un valor, que esta
     * entre 0 - 9.
     */
    private double value;
    
    /**
     * Multiplicador que corresponde a este color.
     */
    private double multiplier;
    
    /**
     * La tolerancia de este color, es decir el margen
     * de error de una resietencia.
     */
    private double tolerance;
    
    /**
     * Valor del color RGB: Rojo
     */
    private int r;
    
    /**
     * Valor del color RGB: Verde
     */
    private int g;
    
    /**
     * Valor del color RGB: Azul
     */
    private int b;
    
    /**
     * Nombre del color asignado.
     */
    private String name;
    
    /**
     * Constructor predeterminado.
     */
    private JColor() {
    }

    /**
     * Constructor de la clase <code>JColor</code> con los valores
     * especiales del banda de color.
     * 
     * @param value
     *          Valor de la banda o color.<code>NaN</code> si el color no
     *          puede ser un banda de color.
     * @param multiplier
     *          Multiplicador del color.
     * @param tolerance
     *          Margen de erro de la banda de color.<code>NaN</code> si el color no
     *          puede ser una tolerancia.
     * @param r Valor del color rojo, entre 1 - 255.
     * @param g Valor del color verde, entre 1 - 255.
     * @param b Valor del color azul, entre 1 - 255.
     * @param name Nombre del color.
     */
    private JColor(double value, double multiplier, double tolerance, int r, int g, int b, String name) {
        this.multiplier = multiplier;
        this.tolerance  = tolerance;
        this.value = value;
        this.name  = name;        
        this.r = r;
        this.g = g;
        this.b = b;
    }

    /**
     * Genera un clon de este objeto.
     * @return Clon del objeto.
     */
    @Override
    public JColor clone() {
        try {
            JColor clon = (JColor) 
                            super.clone();
            
            clon.value     = value;
            clon.tolerance = tolerance;
            clon.multiplier= multiplier;
            
            clon.r = r;
            clon.g = g;
            clon.b = b;
            
            clon.name = name;
            return clon;
        } catch (CloneNotSupportedException e) {
            throw new InternalError(e);
        }
    }

    /**
     * Genera un na cade de caracteres con el codigo de color.
     * @return Un string con el codigo de color.
     */
    @Override
    public String toString() {
        return '[' + "r=" + r + ", g=" + g + ", b=" + b + ']';
    }
    
    /**
     * Devuelve el valor del color rojo.
     * @return Valor del color.
     */
    public int getRed() {
        return r;
    }

    /**
     * Devuelve el valor del color verde.
     * @return Valor del color.
     */
    public int getGreen() {
        return g;
    }

    /**
     * Devuelve el valor del color azul.
     * @return Valor del color.
     */
    public int getBlue() {
        return b;
    }

    /**
     * Devuelve el nombre del color.
     * @return Nombre color.
     */
    public String getName() {
        return name;
    }
    
    @Override
    public void write(JmeExporter ex) throws IOException {
        OutputCapsule out = ex.getCapsule(this);
        
        // Valores especiales del color de la resistencia:
        out.write(value,      "color-value",      Double.NaN);        
        out.write(tolerance,  "color-tolerance",  Double.NaN);        
        out.write(value,      "color-value",      Double.NaN);        
        out.write(tolerance,  "color-tolerance",  Double.NaN);
        out.write(multiplier, "color-multiplier", 1);
        out.write(multiplier, "color-multiplier", 1);
        
        // Valor del color RGB:
        out.write(r, "color-r", 0);
        out.write(g, "color-g", 0);
        out.write(b, "color-b", 0);
        
        // Nombre del color:
        out.write(name, "color-name", null);
    }

    @Override
    public void read(JmeImporter im) throws IOException {
        InputCapsule in = im.getCapsule(this);
        
        // Valores especiales del color de la resistencia:
        value      = in.readDouble("color-value",     Double.NaN);        
        tolerance  = in.readDouble("color-tolerance", Double.NaN);
        multiplier = in.readDouble("color-multiplier", 1);
        
        // Valor del color RGB:
        r = in.readInt("color-r", 0);
        g = in.readInt("color-g", 0);
        b = in.readInt("color-b", 0);
        
        // Nombre del color:
        name = in.readString("color-name", null);
    }

    /**
     * Escala el valor de la toleracion a un rango de 0 - 100 porciento.
     * @return Valor en porcentange de la tolerancia.
     */
    public double getScaleTolerance() {
        double tol = this.getTolerance();
        if (Double.isNaN(tol))
            throw new IllegalStateException("Tolerance is NaN.");
        
        return tol * 100.00;
    }
    
    /**
     * Devuelve el valor del margen de erro que puede tener una resitencia.
     * <p>
     * <b>NOTA: Simpre y cuando el color represente un mareng de error, de lo
     * contrario devolvera <code>NaN</code></b>
     * @return Valor de la tolerancia.
     */
    public double getTolerance() {
        //if (Double.isNaN(tolerance)) {
        //    throw new IllegalStateException("Tolerance is NaN.");
        //}        
        return tolerance;
    }
    
    /**
     * Devuelve el valor del color.
     * @return Valor del color entre 1 - 9;
     */
    public double getValue() {
        return value;
    }
    
    /**
     * Determina el prefijo del multiplicador. Solo puede determinar 3(Kilo, Megas y Gigas).
     * @return Prefijo del multiplicador.
     */
    public String getMultiplierPrefix() {
        double K = 1000, M = 1000000, G = 1000000000;
        if (multiplier >= K && multiplier < M) {
            return "K";
        } else if (multiplier >= M && multiplier < G) {
            return "M";
        } else if (multiplier >= G) {
            return "G";
        }
        return "";
    }
    
    /**
     * Devuelve el multiplicador del color.
     * @return multiplicadro del color.
     */
    public double getMultiplier() {
        return multiplier;
    }
    
    /**
     * Metodo encargado de generar un objeto AWT {@link Color}, para que podamos
     * utilizarlo en los componentes {@code Swing} o {@code AWT} de nuestra interfaz
     * grafica de usuario.
     * @return Color AWT.
     */
    public Color getAWTColor() {
        return new Color(r, g, b);
    }

    /**
     * Metodo encargado de generar el hash de nuestro objeto.
     * @return Hash de la calse <code>JColor</code>.
     */
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + (int) (Double.doubleToLongBits(this.value) ^ (Double.doubleToLongBits(this.value) >>> 32));
        hash = 37 * hash + (int) (Double.doubleToLongBits(this.multiplier) ^ (Double.doubleToLongBits(this.multiplier) >>> 32));
        hash = 37 * hash + (int) (Double.doubleToLongBits(this.tolerance) ^ (Double.doubleToLongBits(this.tolerance) >>> 32));
        hash = 37 * hash + this.r;
        hash = 37 * hash + this.g;
        hash = 37 * hash + this.b;
        hash = 37 * hash + Objects.hashCode(this.name);
        return hash;
    }

    /**
     * Metodo encargado de determinar si otro objeto es igual a este a nivel de
     * conteniod o a si mismo.
     * @param obj Objeto a compararse.
     * @return true si son iguales o a si miso, de lo
     *          contrario sera false.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final JColor other = (JColor) obj;
        if (Double.doubleToLongBits(this.value) != Double.doubleToLongBits(other.value)) {
            return false;
        }
        if (Double.doubleToLongBits(this.multiplier) != Double.doubleToLongBits(other.multiplier)) {
            return false;
        }
        if (Double.doubleToLongBits(this.tolerance) != Double.doubleToLongBits(other.tolerance)) {
            return false;
        }
        if (this.r != other.r) {
            return false;
        }
        if (this.g != other.g) {
            return false;
        }
        if (this.b != other.b) {
            return false;
        }
        return Objects.equals(this.name, other.name);
    }
}
