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
package gt.edu.meso.util;


/**
 * Clase encargado de escalar un numero a una notacion cientifica.
 * @author wil
 * @author santos
 * @version 1.0.0
 * @since 1.0.0
 */
public class Notation {
    
    /**
     * Clase enumerara encargado de gestionar los diferentes
     * preficos de la notacion cinetifica.
     */
    public static enum Prefix {
        
        /**
         * Multiplos de la notacion en Exa.
         */
        Exa("Exa",     'E', 1000000000000000000d),
        
        /**
         * Multiplos de la notacion en Peta.
         */
        Peta("Peta",   'P', 1000000000000000d),
        
        /**
         * Multiplos de la notacion en Tera.
         */
        Tera("Tera",   'T', 1000000000000d),
        
        /**
         * Multiplos de la notacion en Giga.
         */
        Giga("Giga",   'G', 1000000000d),
        
        /**
         * Multiplos de la notacion en mega.
         */
        Mega("Mega",   'M', 1000000d),
        
        /**
         * Multiplos de la notacion en Kilo.
         */
        Kilo("Kilo",   'K', 1000d),
        
        /**
         * Multiplos de la notacion en Hecto.
         */
        Hecto("Hecto", 'H', 100d),
        
        /**
         * Multiplos de la notacion en Deca.
         */
        Deca("Deca",   "Da",10d),
        
        /**
         * Submultiplo de la notacion en Deci.
         */
        Deci("Deci",   'd', 0.1),
        
        /**
         * Submultiplo de la notacion en Centi.
         */
        Centi("Centi", 'c', 0.01),
        
        /**
         * Submultiplo de la notacion en Mili.
         */
        Mili("Mili",   'm', 0.001),
        
        /**
         * Submultiplo de la notacion en Micro.
         */
        Micro("Micro", 'u', 0.000001),
        
        /**
         * Submultiplo de la notacion en Nano.
         */
        Nano("Nano",   'n', 0.000000001),
        
        /**
         * Submultiplo de la notacion en Pico.
         */
        Pico("Pico",   'p', 0.000000000001),
        
        /**
         * Submultiplo de la notacion en Fento.
         */
        Fento("Fento", 'f', 0.000000000000001),
        
        /**
         * Submultiplo de la notacion en Atto.
         */
        Atto("Atto",   'a', 0.000000000000000001),
        
        /**
         * Sin notacion...
         */
        Default("Default", "", 1);
        
        /**
         * Nombre de la notacion.
         */
        private String name;
        
        /**
         * Prefijo o simbolo que identifica la notacion.
         */
        private String prefix;
        
        /**
         * Equivalencia de la notacion.
         */
        private double value;

        /**
         * Constructor de la clase eumerada <code>Prefix</code>
         * @param name Prefijo-
         * @param prefix Simbolo.
         * @param value Equivalente.
         */
        private Prefix(String name, char prefix, double value) {
            this(name, String.valueOf(prefix), value);
        }
        
        /**
         * Constructor de la clase eumerada <code>Prefix</code>
         * @param name Prefijo-
         * @param prefix Simbolo.
         * @param value Equivalente.
         */
        private Prefix(String name, String prefix, double value) {
            this.name = name;
            this.prefix = prefix;
            this.value = value;
        }

        /**
         * Devuelve el prefijo,
         * @return Un cadena.
         */
        public String getName() {
            return name;
        }

        /**
         * Devuleve el simbolo.
         * @return Una cadena.
         */
        public String getPrefix() {
            return prefix;
        }

        /**
         * Devuelve el equivalente.
         * @return Un numero.
         */
        public double getValue() {
            return value;
        }
    }
    
    /**
     * Numero que se convertira en una notacion.
     */
    private double number;
    
    /**
     * Prefijo de la notacion a utilizar.
     */
    private Prefix prefix;

    /**
     * Constructor de la clase <code>Notation</code>.
     * @param number numero a convertir.
     */
    public Notation(double number) {
        this(number, Prefix.Default);
    }

    /**
     * Constructor de la clase <code>Notation</code>.
     * @param number numero a convertir.
     * @param prefix prefijo de la notacion.
     */
    public Notation(double number, Prefix prefix) {
        this.number = number;
        this.prefix = prefix;
    }
    
    /**
     * Convierte el numero a una notacion.
     * @return Numero convertido a una escala de notacion.
     */
    public double getUnscaleNumber() {
        //if (prefix.getValue() < 1) {
        //    return number * prefix.getValue();
        //}
        return number / prefix.getValue();
    }
    
    /**
     * Convierte una notacion a su valor nominal.s
     * @return valor de la notacion
     */
    public double getScaleNumber() {        
        return number * prefix.getValue();
    }

    /**
     * Devuelve el preijo de esta notacion.
     * @return Un objeto enumerado.
     */
    public Prefix getPrefix() {
        return prefix;
    }
    
    /**
     * Determina la anotacion cinetifica de dicho numero.
     * @param resistencia valores de una resistencia.
     * @return Notacion del numero/valor.
     */
    public static Notation determine(double resistencia) {
        //E
        if (resistencia >= Prefix.Exa.getValue()) {
            return new Notation(resistencia, Prefix.Exa);
        }
        //P
        if (resistencia >= Prefix.Peta.getValue() && resistencia < Prefix.Exa.getValue()) {
            return new Notation(resistencia, Prefix.Peta);
        }
        //T
        if (resistencia >= Prefix.Tera.getValue() && resistencia < Prefix.Peta.getValue()) {
            return new Notation(resistencia, Prefix.Tera);
        }
        //G
        if (resistencia >= Prefix.Giga.getValue() && resistencia < Prefix.Tera.getValue()) {
            return new Notation(resistencia, Prefix.Giga);
        }
        //M 
        if (resistencia >= Prefix.Mega.getValue() && resistencia < Prefix.Giga.getValue()) {
            return new Notation(resistencia, Prefix.Mega);
        }
        //K
        if (resistencia >= Prefix.Kilo.getValue() && resistencia < Prefix.Mega.getValue()) {
            return new Notation(resistencia, Prefix.Kilo);
        }
        //Mili
        if (resistencia >= Prefix.Mili.getValue() && resistencia < Prefix.Centi.getValue()) {
            return new Notation(resistencia, Prefix.Mili);
        }
        //Micro
        if (resistencia >= Prefix.Micro.getValue() && resistencia < Prefix.Mili.getValue()) {
            return new Notation(resistencia, Prefix.Micro);
        }
        //Nano
        if (resistencia >= Prefix.Nano.getValue() && resistencia < Prefix.Micro.getValue()) {
            return new Notation(resistencia, Prefix.Nano);
        }
        //Pico
        if (resistencia >= Prefix.Pico.getValue() && resistencia < Prefix.Nano.getValue()) {
            return new Notation(resistencia, Prefix.Pico);
        }
        //Fento
        if (resistencia >= Prefix.Fento.getValue() && resistencia < Prefix.Pico.getValue()) {
            return new Notation(resistencia, Prefix.Fento);
        }        
        // Atto
        if (resistencia >= Prefix.Atto.getValue() && resistencia < Prefix.Fento.getValue()) {
            return new Notation(resistencia, Prefix.Atto);
        }
                
        //sin notación
        return new Notation(resistencia, Prefix.Default);
    }
}
