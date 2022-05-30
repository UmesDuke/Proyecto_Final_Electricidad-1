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
package gt.edu.meso.delta;

import gt.edu.meso.circuito.Resistor;
import gt.edu.meso.util.Notation;
import java.util.HashMap;
import java.util.Map;
import org.monkey.JmeArray;
import org.monkey.JmeProperties;

/**
 * La clase <code>Transformacion</code> se encarga de proporcionar los
 * metodo para tranformar un circuito delta-estrella o estrella delta.
 * 
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
public abstract class Transformacion {
    public static final String JRA = "Ra";
    public static final String JRB = "Rb";
    public static final String JRC = "Rc";    
    public static final String JR1 = "R1";
    public static final String JR2 = "R2";
    public static final String JR3 = "R3";    
    public static final String NOTACION = "${notacion}";
    public static final String NAME     = "${name}";
    
    
    /** Mapa de resistencias.*/
    Map<String, Resistor> resistors
                             = new HashMap<>();

    /**
     * Constructor predeterminado.
     */
    public Transformacion() { }
    public void add(Resistor r, String name) {
        resistors.put(name, r);
    }
    public Resistor get(int num) {
        switch (num) {
            case 0:
                return resistors.containsKey(JR1) ? resistors.get(JR1) : resistors.get(JRA);
            case 1:
                return resistors.containsKey(JR2) ? resistors.get(JR2) : resistors.get(JRB);
            case 2:
                return resistors.containsKey(JR3) ? resistors.get(JR3) : resistors.get(JRC);
            default:
                throw new AssertionError();
        }
    }
    
    
    /**
     * Devuleve las propiedes de la conversiion.
     * @return propiedades.
     */
    public abstract JmeArray cal();
    protected JmeProperties __new__(double val, String name) {
        return new JmeProperties(){{
            this.put(NOTACION, Notation.determine(val));
            this.put(NAME, name);
        }};
    }
}
