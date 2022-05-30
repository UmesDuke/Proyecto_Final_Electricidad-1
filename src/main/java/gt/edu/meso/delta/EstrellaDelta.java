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

import org.monkey.JmeArray;

/**
 * @author javier
 */
public class EstrellaDelta extends Transformacion {
    double Ra=0,Rb=0,Rc=0;
    double R1=0, R2=0, R3=0;
    
    @Override public JmeArray cal() {
        R1 = get(0).getOhmios();
        R2 = get(1).getOhmios();
        R3 = get(2).getOhmios();
        
        // -------------  Recistencia RA
	Ra = ( (R1 * R2) + (R2 * R3) + (R3 * R1) ) / R1;
	// -------------  Recistencia RB
	Rb = ( (R1 * R2) + (R2 * R3) + (R3 * R1) ) / R2;
	// -------------  Recistencia RC
	Rc = ( (R1 * R2) + (R2 * R3) + (R3 * R1) ) / R3;
		
	//------------------------------------------------
        return new JmeArray(){{
            this.put(__new__(Ra, Transformacion.JRA));
            this.put(__new__(Rb, Transformacion.JRB));
            this.put(__new__(Rc, Transformacion.JRC));
        }};
    }

}
