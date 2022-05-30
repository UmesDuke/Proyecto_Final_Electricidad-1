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
package gt.edu.meso.divisor;

import gt.edu.meso.circuito.Circuito;
import gt.edu.meso.circuito.Resistor;
import java.util.List;
import org.monkey.JmeProperties;

/**
 * @author wil
 * @param <E>
 */
public abstract class Divisor<E extends Circuito> {
    public static final String KEY_NAM = "div.name";
    public static final String KEY_VRX = "div.value";
    public static final String KEY_VNT = "div.notacion";
   
    /** Circuito. */
    protected E circuito;

    /**
     * Constructor predeterminado.
     * @param circuito Circuito.
     */
    public Divisor(E circuito) {
        this.circuito = circuito;
    }

    /**
     * @return Circuito a operacion.
     */
    public E getCircuito() {
        return circuito;
    }
    
    /**
     * Calcula la division de la corrinet o el voltaje del circuito.
     * @param r resistencia a calcular.
     * @return propiedades.
     */
    public abstract JmeProperties getProperties(Resistor r);    
    public JmeProperties getProperties(String name) {
        List<Resistor> rs = circuito.getResistencias();
        for (final Resistor r : rs) {
            if (r == null)
                continue;
            
            if (r.getName().equals(name)) {
                return this.getProperties(r);
            }
        }
        return new JmeProperties();
    }
}
