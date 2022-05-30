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
 * @author santos
 */
public class DeltaEstrella extends Transformacion {
    @Override public JmeArray cal() {
        double ra = get(0).getOhmios(),
               rb = get(1).getOhmios(),
               rc = get(2).getOhmios();
        return cal0(ra, rb, rc);
    }
    private JmeArray cal0(double ra, double rb, double rc) {
        double r1, r2, r3;
	double den=ra+rb+rc;
	r1=(ra*rc)/den;
	r2=(rc*rb)/den;
	r3=(ra*rb)/den;
        
        return new JmeArray(){{
            this.put(__new__(r1, JR1));
            this.put(__new__(r2, JR2));
            this.put(__new__(r3, JR3));
        }};
    }
}
