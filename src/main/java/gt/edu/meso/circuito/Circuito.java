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
 * La clase <code>Circuito</code> se encarga de porporcionar los metodos
 * comunes para resolver un circuito({@code Paralelo} o {@code Serie}).
 * 
 * @author wil
 * @author santos
 * @author javier
 * 
 * @version 1.0.0
 * @since 1.0.0
 */
public abstract class Circuito {
    
    /** Lista de resistencia. */
    ArrayList<Resistor> resistencias;
    
    /* Valor de la fuente de voltage. */
    double fuente;

    /**
     * Construte un circuito base.
     */
    public Circuito() {
        this.resistencias = new ArrayList<>();
    }

    /**
     * Construya un circuito con una funte personalizado.
     * @param fuente valor de la funete.
     */
    public Circuito(double fuente) {
        this();
        this.fuente = fuente;
    }

    /**
     * Estable cel valor de la funete.
     * @param fuente Un valor real.
     */
    public void setFuente(double fuente) {
        this.fuente = fuente;
    }
    
    /**
     * Agrega una resistencia a la lista.
     * @param r Nueva resistencia.
     * @return Un boleando.
     */
    public boolean agregar(Resistor r) {
        return this.resistencias.add(r);
    }
    
    /**
     * Elimina una resistencia de la lista.
     * @param r Resistencia a eliminarse.
     * @return {@code true} si se a eliminado, de lo
     *          contrario devolvera {@code false}.
     */
    public boolean remover(Resistor r) {
        return this.resistencias.remove(r);
    }
    
    /**
     * @return Cantidad de resistencias actuales.
     */
    public int cantidad() {
        return resistencias.size();
    }
    
    /**
     * Calcula la resistencia total del circuito.
     * @return resistenci total.
     */
    public abstract double getResistenciaTotal();
    
    /**
     * Inicializa las resistencias.
     */
    public abstract void start();
    
    // Gettres de la clase.
    public double getFuente() { return fuente; }
    public ArrayList<Resistor> getResistencias() {
        return resistencias;
    }
    
    /**
     * Metodo encargado de calcular el amperaje(corriente) total.
     * @return corriente total.
     */
    public double getAmperajeTotal() {
        double rt = getResistenciaTotal();
        if (rt == 0)
            return 0;
            
        return fuente / getResistenciaTotal();
    }
    
    /**
     * Metodo encargado de calcular la potencia total.
     * @return potencia total.
     */
    public double getPotenciaTotal() {
        return fuente * getAmperajeTotal();
    }
}
