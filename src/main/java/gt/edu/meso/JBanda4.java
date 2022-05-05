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
 * Un <code>JBanda4</code> se encarga de calcular el valores de una
 * resistencia de 4 bandas.
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
public class JBanda4 extends Bandas {
    
    /** Cantidad de bandas. */
    public static final int NO_BANDAS = 4;
    
    /** Color de la primera banda. */
    private JColor banda1 = JColor.DEFAULT;
    
    /** Color de la segunda banda. */
    private JColor banda2 = JColor.DEFAULT;

    /**
     * Constructor predeterminado.
     */
    public JBanda4() {
    }

    // Setters de la clase.
    public void setBanda2(JColor banda2) { this.banda2 = banda2; }
    public void setBanda1(JColor banda1) { this.banda1 = banda1; }

    // Getters de la clase.
    public JColor getBanda1() { return banda1; }
    public JColor getBanda2() { return banda2; }

    // Implementamos los diferentes metodo para
    // calcular el valore de la resistencia.
    @Override public boolean isPrintf() {
        return isVal(banda1, banda2, getMultiplier(), getTolerance());
    }
    @Override public int length() {
        return NO_BANDAS;
    }
    @Override public JColor[] getColors() {
        return new JColor[] {banda1, banda2};
    }
    @Override public double getOhms() {
        if (isPrintf()) {
            return ((banda1.getValue() * 10) + banda2.getValue()) * getMultiplier().getMultiplier();
        }
        return 0;
    }
}
