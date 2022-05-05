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
package gt.edu.meso.jui;

import java.awt.Component;
import java.awt.HeadlessException;
import java.awt.Image;

import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

/**
 * Clase padre de las venatnas que utilize la aplicacion.
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
public abstract class Window extends JFrame {
    
    /** Titulos de las venatnas. */
    public static final String TITLE = "Wizzard 1.0.0";
    
    /** Lista de iconoes para la ventana. */
    public static final ArrayList<Image> ICONS = new ArrayList<>();

    /** Inicializamos los iconos de la aplicaicon.*/
    static {
        try {
            ICONS.add(ImageIO.read(Window.class.getResource("/Icons/icon_01.png")));
            ICONS.add(ImageIO.read(Window.class.getResource("/Icons/icon_02.png")));
            ICONS.add(ImageIO.read(Window.class.getResource("/Icons/icon_03.png")));
        } catch (IOException e) {
            throw new InternalError("Application Icons.", e);
        }
    }
    
    /**
     * Constructor de la clase <code>Window</code>
     * @throws HeadlessException Si da erro al inicializar los graficos.
     */
    public Window() throws HeadlessException {
        super();
        setIconImages(ICONS);
    }
        
    /**
     * Metodo donde se agregaran funcionalidade adicionales
     * a la ventana.
     */
    protected abstract void componentesAdd();
    
    /**
     * Centra la ventana en la pantalla.
     */
    public void center() {
        this.center(null);
    }
    
    /**
     * Centra la ventana encima de un componente grafico.
     * @param c Componen donde se centrara esta ventana.
     */
    public void center(Component c) {
        this.setLocationRelativeTo(c);
    }
    
    /**
     * Establece el tipo de la ventana.
     * @param title Titulo de la ventana.
     */
    @Override
    public void setTitle(String title) {
        if (title == null || title.isEmpty()) {
            super.setTitle(Window.TITLE);
        } else {
            super.setTitle(title + " - " + Window.TITLE);
        }
    }
}
