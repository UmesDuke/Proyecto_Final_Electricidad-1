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
package gt.edu.meso.framework;

/**
 * Un <code>Renderer</code> es el encargado de implementra los metods para
 * registrar y eliminar los diferentes renderizadores para la simulacion.
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
public interface Renderer {
    
    /**
     * Registra un nuevo <code>Graphics2DRenderer</code> para renderizarr.
     * @param gr Objeto renderizador.
     */
    void addRenderer(Graphics2DRenderer gr);
    
    /**
     * Elimina un objeto <code>Graphics2DRenderer</code> registrado.
     * @param gr Graphics2DRenderer a eliminarse.
     * @return {@code true} si se elimino con exito, de lo
     *          contrario sera {@code false}.
     */
    boolean removeRenderer(Graphics2DRenderer gr);
    
    /**
     * Elimina un objeto <code>Graphics2DRenderer</code> registrado a
     * travez su indice.
     * @param index Posicion del renderizador 0 - size().
     * @return <code>Graphics2DRenderer</code> que se elimino, de
     *          lo contrario sera <code>NULL</code>.
     */
    Graphics2DRenderer removeRenderer(int index);
}
