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

import com.jme3.export.InputCapsule;
import com.jme3.export.JmeExporter;
import com.jme3.export.JmeImporter;
import com.jme3.export.OutputCapsule;
import com.jme3.export.Savable;
import java.io.IOException;

/**
 * Clase encargado de gestionar las dimensiones de una recta o
 * cuadrado.
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
public final class Rect implements Cloneable, Savable {
    
    /** Posicion en el eje {@code x}.*/
    double x;
    
    /** Posicion en el eje {@code y}.*/
    double y;
    
    /** Largo del objeto. */
    double width;
    
    /** Ancho del objeto. */
    double height;

    /**
     * Genera un nueco <code>Rect</code>.
     */
    public Rect() {
    }

    /**
     * Genera un nuevo <code>Rect</code> e inicialize los datos
     * de su recta(Cuadrado o Rectangulo).
     * @param x posicion en x.
     * @param y posicion en y.
     * @param width largo.
     * @param height ancho-
     */
    public Rect(double x, double y, double width, double height) {
        this.width  = width;
        this.height = height;
        this.x = x;
        this.y = y;        
    }
    
    /**
     * Clona el objeto.
     * @return Clon del objeto.
     */
    @Override
    public Rect clone() {
        try {
            return (Rect) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new InternalError(e);
        }
    }

    // Setters de la clase 'Rect.'
    public Rect setX(double x) { this.x = x; return this; }
    public Rect setY(double y) { this.y = y; return this; }
    public Rect setWidth(double width)   { this.width  = width;  return this; }
    public Rect setHeight(double height) { this.height = height; return this; }

    /**
     * Genera una caden con los datos de esta clase.
     * @return Un string.
     */    
    @Override
    public String toString() {
        return "Rect[" + "x=" + x + ", y=" + y 
                       + ", width=" + width + ", height=" + height + ']';
    }

    // Getters de la clase 'Rect'.
    public int getX() { return (int) x; }
    public int getY() { return (int) y; }
    public int getWidth()  { return (int) width;  }
    public int getHeight() { return (int) height; }

    /**
     * Genera el hash de para esta clase.
     * @return codigo hash perteneciente a este objeto.
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + (int) (Double.doubleToLongBits(this.x) ^ (Double.doubleToLongBits(this.x) >>> 32));
        hash = 43 * hash + (int) (Double.doubleToLongBits(this.y) ^ (Double.doubleToLongBits(this.y) >>> 32));
        hash = 43 * hash + (int) (Double.doubleToLongBits(this.width) ^ (Double.doubleToLongBits(this.width) >>> 32));
        hash = 43 * hash + (int) (Double.doubleToLongBits(this.height) ^ (Double.doubleToLongBits(this.height) >>> 32));
        return hash;
    }

    /**
     * Metodo encargado de comparar este objeto con otro, para asi determinar
     * si son iguales o no.
     * @param obj objeto a compararse.
     * @return {@code true} si son iguales a nicel de contendio o asi misa,
     *          de lo contrario {@code false}.
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
        final Rect other = (Rect) obj;
        if (Double.doubleToLongBits(this.x) != Double.doubleToLongBits(other.x)) {
            return false;
        }
        if (Double.doubleToLongBits(this.y) != Double.doubleToLongBits(other.y)) {
            return false;
        }
        if (Double.doubleToLongBits(this.width) != Double.doubleToLongBits(other.width)) {
            return false;
        }
        return Double.doubleToLongBits(this.height) == Double.doubleToLongBits(other.height);
    }

    @Override
    public void write(JmeExporter ex) throws IOException {
        final OutputCapsule out = ex.getCapsule(this);        
        out.write(x, "x", 0);
        out.write(y, "y", 0);        
        out.write(width,  "width",  0);
        out.write(height, "height", 0);
    }

    @Override
    public void read(JmeImporter im) throws IOException {
        final InputCapsule in = im.getCapsule(this);
        
        x = in.readDouble("x", x);
        y = in.readDouble("y", y);
        
        width  = in.readDouble("width",  width);
        height = in.readDouble("height", height);
    }
}
