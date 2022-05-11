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
 * en paralelo.
 * 
 * @author javier
 * @version 1.0.0
 * 
 * @since 1.0.0
 */
public class Paralelo extends Circuito {

    public Paralelo() {
    }

    public Paralelo(double fuente) {
        super(fuente);
    }

    @Override
    public double getResistenciaTotal() {
        double Resistencia_Total = 0;
        int ContR = 0;
        while(ContR < cantidad()){
            Resistor r = resistencias.get(ContR);            
            if (r == null || !r.isEnabled() ) {
                ContR++;
                continue;
            }
            Resistencia_Total=Resistencia_Total+(1/r.getOhmios());           
            ContR++;
        }        
        if (Resistencia_Total == 0) {
            return 0;
        }        
        Resistencia_Total=(1/Resistencia_Total);
        return Resistencia_Total;
    }

    @Override
    public void start() {
        double Voltaje_Rn=fuente, Amperaje_Rn=0, Potencia_Rn=0;
        int ContR = 0;
        while (ContR<cantidad()) {
            
            Resistor Resistencias = resistencias.get(ContR);
            if (!Resistencias.isEnabled()) {
                ContR++;
                continue;
            }
            
            Amperaje_Rn=fuente/resistencias.get(ContR).getOhmios();
            Potencia_Rn=fuente*Amperaje_Rn;
            
                Resistencias.setCorriente(Amperaje_Rn);
                Resistencias.setVoltios(Voltaje_Rn);
                Resistencias.setPotencia(Potencia_Rn);            
            ContR++;
        }
    }
}
