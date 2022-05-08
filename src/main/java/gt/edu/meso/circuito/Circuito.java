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

import java.util.ArrayList;

/**
 * @author wil
 */
public abstract class Circuito {
    
    ArrayList<Resistor> resistencias;
    double fuente;

    public Circuito() {
        this.resistencias = new ArrayList<>();
    }

    public Circuito(double fuente) {
        this();
        this.fuente = fuente;
    }

    public void setFuente(double fuente) {
        this.fuente = fuente;
    }
    
    public boolean agregar(Resistor r) {
        return this.resistencias.add(r);
    }
    
    public boolean remover(Resistor r) {
        return this.resistencias.remove(r);
    }
    
    public int cantidad() {
        return resistencias.size();
    }
    
    public abstract double getResistenciaTotal();
    
    public abstract void start();
    
    public double getFuente() {
        return fuente;
    }

    public ArrayList<Resistor> getResistencias() {
        return resistencias;
    }
    
    public double getAmperajeTotal() {
        double rt = getResistenciaTotal();
        if (rt == 0)
            return 0;
            
        return fuente / getResistenciaTotal();
    }
    
    public double getPotenciaTotal() {
        return fuente * getAmperajeTotal();
    }
}
