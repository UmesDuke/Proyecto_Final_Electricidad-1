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
 * @author wil
 */
public class Resistor {
    
    private double ohmios;
    private double corriente;
    private double voltios;
    private double potencia;
        
    private boolean enabled;
    private String name;

    public Resistor() {
        this.enabled = false;
        this.name    = null;
    }

    public Resistor(double ohmios) {
        this.enabled = ohmios != 0;
        this.name    = null;
        this.ohmios  = ohmios;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    @Override
    public String toString() {
        return "Resistor{" + "ohmios=" + ohmios + ", corriente=" + corriente 
                + ", voltios=" + voltios + ", potencia=" + potencia + '}';
    }

    public void setCorriente(double corriente) { this.corriente = corriente; }
    public void setOhmios(double ohmios)       { this.ohmios = ohmios;       }    
    public void setVoltios(double voltios)     { this.voltios = voltios;     }
    public void setPotencia(double potencia)   { this.potencia = potencia;   }
    public void setName(String name)           { this.name = name;           }

    public String getName()      { return name;      }
    public double getCorriente() { return corriente; }
    public double getOhmios()    { return ohmios;    }    
    public double getVoltios()   { return voltios;   }
    public double getPotencia()  { return potencia;  }

    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + (int) (Double.doubleToLongBits(this.ohmios) ^ (Double.doubleToLongBits(this.ohmios) >>> 32));
        hash = 53 * hash + (int) (Double.doubleToLongBits(this.corriente) ^ (Double.doubleToLongBits(this.corriente) >>> 32));
        hash = 53 * hash + (int) (Double.doubleToLongBits(this.voltios) ^ (Double.doubleToLongBits(this.voltios) >>> 32));
        hash = 53 * hash + (int) (Double.doubleToLongBits(this.potencia) ^ (Double.doubleToLongBits(this.potencia) >>> 32));
        return hash;
    }

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
