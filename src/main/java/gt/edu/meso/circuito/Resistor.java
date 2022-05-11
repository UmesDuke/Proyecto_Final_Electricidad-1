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
package gt.edu.meso.circuito;

/**
 * Clase <code>Resistor</code> se encarga de almacenar los datos
 * de una resistencia:<pre><code>
 * 1. -Valor de ohmios
 * 2. -Corriente
 * 3. -Voltage
 * 4. -Potencia</code></pre>
 * 
 * @author wil
 * @version 1.0.0
 * 
 * @since 1.0.0
 */
public class Resistor {
    
    /** Ohmios de la resistencia. */
    private double ohmios;
    
    /** Corriente. */
    private double corriente;
    
    /** Volate. */
    private double voltios;
    
    /** Potencia.*/
    private double potencia;
        
    /**
     * Si el valor de los ohmios es cero, {@code enabled} tendra como
     * valor {@code false} dado que dividir entre cero da un error, de
     * lo contrario {@code true.}
     */
    private boolean enabled;

    /** Nombre de la resistencia. */
    private String name;

    /**
     * Constructor predeterminado.
     */
    public Resistor() {
        this.enabled = false;
        this.name    = null;
    }

    /**
     * Construye una resistencia junto con su valor de ohmios.
     * @param ohmios valor de la resistencia.
     */
    public Resistor(double ohmios) {
        this.enabled = ohmios != 0;
        this.name    = null;
        this.ohmios  = ohmios;
    }

    // Estado de la resistencia.
    public boolean isEnabled() { return enabled; }
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    // Un mensage imprimible.
    @Override
    public String toString() {
        return "Resistor{" + "ohmios=" + ohmios + ", corriente=" + corriente 
                + ", voltios=" + voltios + ", potencia=" + potencia + '}';
    }

    // Setters de la clase.
    public void setCorriente(double corriente) { this.corriente = corriente; }
    public void setOhmios(double ohmios)       { this.ohmios = ohmios;       }    
    public void setVoltios(double voltios)     { this.voltios = voltios;     }
    public void setPotencia(double potencia)   { this.potencia = potencia;   }
    public void setName(String name)           { this.name = name;           }

    // Getters de la clase.
    public String getName()      { return name;      }
    public double getCorriente() { return corriente; }
    public double getOhmios()    { return ohmios;    }    
    public double getVoltios()   { return voltios;   }
    public double getPotencia()  { return potencia;  }

    // Hash de la clase.
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + (int) (Double.doubleToLongBits(this.ohmios) ^ (Double.doubleToLongBits(this.ohmios) >>> 32));
        hash = 53 * hash + (int) (Double.doubleToLongBits(this.corriente) ^ (Double.doubleToLongBits(this.corriente) >>> 32));
        hash = 53 * hash + (int) (Double.doubleToLongBits(this.voltios) ^ (Double.doubleToLongBits(this.voltios) >>> 32));
        hash = 53 * hash + (int) (Double.doubleToLongBits(this.potencia) ^ (Double.doubleToLongBits(this.potencia) >>> 32));
        return hash;
    }

    // equals de la clase.
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
        final Resistor other = (Resistor) obj;
        if (Double.doubleToLongBits(this.ohmios) != Double.doubleToLongBits(other.ohmios)) {
            return false;
        }
        if (Double.doubleToLongBits(this.corriente) != Double.doubleToLongBits(other.corriente)) {
            return false;
        }
        if (Double.doubleToLongBits(this.voltios) != Double.doubleToLongBits(other.voltios)) {
            return false;
        }
        return Double.doubleToLongBits(this.potencia) == Double.doubleToLongBits(other.potencia);
    }
}
