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

import java.awt.Window;

/**
 * Encargado de activar un evento de cierre de ventanas.
 * @author wil
 * @author javier
 * @author santos
 */
public interface ResetListener {
    
    // evento de cierre de evtenas.
    void closeWindow(Window... windows);
}
