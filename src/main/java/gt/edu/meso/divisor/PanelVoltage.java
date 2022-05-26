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

import gt.edu.meso.circuito.Serie;
import gt.edu.meso.jui.panel.cicuito.PanelSerie;

/**
 * @author wil
 */
public class PanelVoltage extends PanelSerie {

    private Divisor<Serie> divisor;
    
    public PanelVoltage() {
    }

    @Override
    protected void componentesAdd() {
        super.componentesAdd();
        divisor = new DivisorVoltage(circuitoSerie);
    }

    public Divisor<Serie> getDivisor() {
        return divisor;
    }
    
}
