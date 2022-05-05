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

import java.awt.Dialog;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.KeyStroke;

/**
 * Clase encargado de generar una pkantilla para generar una ventana
 * emergenre de opciones...
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
public class Popup extends PopupDialog {
    
    /** Un código de estado de devolución: devuelto si se ha presionado el botón Cancelar */
    public static final int RET_CANCEL = 0;
    /** Un código de estado de devolución: devuelto si se ha presionado el botón OK */
    public static final int RET_OK = 1;
    
    /** Estado de la venatan. */
    private int status = RET_CANCEL;

    // Constructor de la clase 'Popup'
    public Popup(Frame owner, boolean modal) {
        super(owner, modal);        
    }

    // Constructor de la clase 'Popup'
    public Popup(Dialog owner, boolean modal) {
        super(owner, modal);        
    }

    /**
     * Inicializa los datos para configurar esta ventana.
     */
    @Override
    protected void componentesAdd() {
        // Cierre el cuadro de diálogo cuando se presione 'Esc'
        String cancelName = "cancel";
        InputMap inputMap = getRootPane().getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), cancelName);
        ActionMap actionMap = getRootPane().getActionMap();
        actionMap.put(cancelName, new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                doClose(RET_CANCEL);
            }
        });
        
        /* Cuando se cierra la venatan, actualizamos el estado
        del cuadro de dialogo.*/
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent evt) {
                closeDialog(evt);
            }
        });
    }
    
    /**
     * Establece un boton por defecto para el cuadro de dialogo.
     * @param defaultButton boton predeterminado.
     */
    protected void setDefaultButton(JButton defaultButton) {
        getRootPane().setDefaultButton(defaultButton);
    }
    
    /** Cierra el cuadro de diálogo */
    private void closeDialog(WindowEvent evt) {                             
        doClose(RET_CANCEL);
    }
    
    /**
     * Cierra el cuadro de diálogo.
     * @param retStatus Estado de la ventana.
     */
    public void doClose(int retStatus) {
        status = retStatus;
        super.doClose();
    }

    /**
     * Devuelve el estado de la ventana.
     * @return Un int como valor.
     */
    public int getStatus() {
        return status;
    }
}
