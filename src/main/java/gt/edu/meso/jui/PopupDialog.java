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
import java.awt.Dialog;
import java.awt.Frame;
import javax.swing.JDialog;

/**
 * Clase padre encargado de todas las ventanas emergentes de la
 * aplicacion...
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
public abstract class PopupDialog extends JDialog {

    /**
     * Genera un nuevo {@code PopupDialog}-
     * @param owner Padre de la ventana emergente.
     * @param modal {@code true} si se deshabilita los componentes, de lo
     *                  contrario {@code false}.
     */
    public PopupDialog(Frame owner, boolean modal) {
        super(owner, modal);
        setIconImages(Window.ICONS);
    }

    /**
     * Genera un nuevo {@code PopupDialog}-
     * @param owner Padre de la ventana emergente.
     * @param modal {@code true} si se deshabilita los componentes, de lo
     *                  contrario {@code false}.
     */
    public PopupDialog(Dialog owner, boolean modal) {
        super(owner, modal);
        setIconImages(Window.ICONS);
    }
    
    /**
     * Cierra la ventana emergente.
     */
    public void doClose() {
        setVisible(false);
        dispose();
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
