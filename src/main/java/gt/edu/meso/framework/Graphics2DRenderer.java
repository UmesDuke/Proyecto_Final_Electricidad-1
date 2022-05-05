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

import java.awt.Graphics2D;

/**
 * Un <code>Graphics2DRenderer</code> es uan iterfaz encargado de implementar
 * el metodo <code>Graphics2DRenderer.render()</code> donde podemos graficar
 * objetos en 2D con la API de Java.
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
public interface Graphics2DRenderer {
    
    /**
     * Metodo encargado de renderizar.
     *
     * @param renderer Administrador de renderizado.
     * @param g el objeto de gráficos para representar
     * @param elapsedTime el tiempo transcurrido desde la última actualización
     */
    void render(Renderer renderer, Graphics2D g, double elapsedTime);
}
