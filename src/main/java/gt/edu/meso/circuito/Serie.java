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
 * Un <code>Paralelo</code> se encarga de gestionar un circuito
 * en serie.
 * 
 * @author santos
 * @version 1.0.0
 * 
 * @since 1.0.0
 */
public class Serie extends Circuito {

    public Serie() {
    }

    public Serie(double fuente) {
        super(fuente);
    }

    @Override
    public double getResistenciaTotal() {
        double res_total = 0;
        for (final Resistor r : this.resistencias) {
            if (r == null || !r.isEnabled())
                continue;
            res_total += r.getOhmios();
        }
        return res_total;
    }

    @Override
    public void start() {
        double inte_total = getAmperajeTotal();
        for (final Resistor r : this.resistencias) {
            if (r == null || !r.isEnabled())
                continue;
            
            double volt = inte_total * r.getOhmios();
            double wat  = inte_total * volt;
            
            r.setCorriente(inte_total);
            r.setVoltios(volt);
            r.setPotencia(wat);
        }
    }
}
