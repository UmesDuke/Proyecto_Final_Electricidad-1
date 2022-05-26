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

import gt.edu.meso.circuito.Resistor;
import gt.edu.meso.circuito.Serie;

import gt.edu.meso.util.Notation;

import org.monkey.JmeProperties;

/**
 *
 * @author wil
 */
public class DivisorVoltage extends Divisor<Serie> {
    public static final String KEY_NAM = "div.voltage.name";
    public static final String KEY_VRX = "div.voltage.value";
    public static final String KEY_VNT = "div.volatge.notacion";
    
    public DivisorVoltage(Serie circuito) {
        super(circuito);
    }

    @Override
    public JmeProperties getProperties(Resistor r) {
        if (circuito == null)
            throw new NullPointerException();
        
        circuito.start();
        
        double vrx = (circuito.getFuente() * r.getOhmios()) / circuito.getResistenciaTotal();        
        JmeProperties properties = new JmeProperties();
        
        properties.put(KEY_VRX, vrx);
        properties.put(KEY_NAM, r.getName());
        properties.put(KEY_VNT, Notation.determine(vrx));        
        return properties;
    }
}
