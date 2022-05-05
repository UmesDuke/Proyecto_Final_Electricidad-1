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

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.AbstractButton;

/**
 * Un <code>Group</code> se encarga de administra un grupo de {@code Button}, para
 * darle una animacion de {@code Switch}.
 * @author JAVA
 * @version 1.0.0
 * @since 1.0.0
 */
public final class Group {

    /**
     * Clase einterna encargado de gestionar el evento de los
     * botones de este grupo.
     */
    private class GroupEvent implements ActionListener {
        @Override public void actionPerformed(ActionEvent e) {
            final Object source = e.getSource();
            if (source instanceof AbstractButton) {
                setSelected((AbstractButton) source, true);
            }
        }
    }
    
    /**  La lista de botones que participan en este grupo.  */
    protected ArrayList<AbstractButton> buttons = new ArrayList<>();
    
    /** Evento para los botones del grupo. */
    GroupEvent event = new GroupEvent();

    /** La selección actual.*/
    AbstractButton selection = null;
    
    /** Color de fondo si el boton esta seleccionado. */
    protected Color selected;
    
    /** Color de fondo si el boton no esta seleccionado. */
    protected Color unselected;
    
    /** Color de las letras cunado esta seleccionado. */
    protected Color foregrounSelected;
    
    /** Color de las letras cunado no esta seleccionado. */
    protected Color foregrounUnselected;

    /**
     * Crera un nuevo <code>ButtonGroup</code>.
     */
    public Group() {}

    /**
     * Establece el color de los botones cuando esten seleccionados.
     * @param selected Color AWT.
     */
    public void setColorSelected(Color selected) {
        this.selected = selected;
    }

    /**
     * Establece el color de los botones cuando no esten seleccionados.
     * @param unselected Color AWT.
     */
    public void setColorUnselected(Color unselected) {
        this.unselected = unselected;
    }

    /**
     * Establece el color de los texto cuando esta seleccionado.
     * @param foregrounSelected Color ATW
     */
    public void setForegrounSelected(Color foregrounSelected) {
        this.foregrounSelected = foregrounSelected;
    }

    /**
     * Establece el color de los texto cuando no esta seleccionado.
     * @param foregrounUnselected Color ATW
     */
    public void setForegrounUnselected(Color foregrounUnselected) {
        this.foregrounUnselected = foregrounUnselected;
    }

    /**
     * Agrega el botón al grupo.
     * @param b el botón que se va a agregar
     */
    public void add(AbstractButton b) {
        if(b == null) {
            return;
        }
        buttons.add(b);

        //if (selection == null) {
        //    selection = b;
        //    selection.setBackground(selected);
        //    selection.setForeground(foregrounSelected);
        //} else {
            b.setBackground(unselected);
            b.setForeground(foregrounUnselected);
        //}
        
        // removemos el evento, para asegurarnos de que
        // el evento del grupo se repita mas de una vez.
        b.removeActionListener(event);
        b.addActionListener(event);
    }

    /**
     * Quita el botón del grupo.
     * @param b el botón que se va a quitar
     */
    public void remove(AbstractButton b) {
        if(b == null) {
            return;
        }
        buttons.remove(b);
        if(b == selection) {
            selection = null;
        }
    }

    /**
     * Borra la selección de tal manera que ninguno de los botones 
     * en el <code>ButtonGroup</code> están seleccionados.     *
     * @since 1.6
     */
    public void clearSelection() {
        if (selection != null) {
            AbstractButton oldSelection = selection;
            selection = null;
            oldSelection.setSelected(false);
        }
    }

    /**
     * Devuelve todos los botones en los que participan. 
     * este grupo.
     * @return una <code>Iterator</code> de los botones de este grupo
     */
    public Iterator<AbstractButton> getElements() {
        return buttons.iterator();
    }

    /**
     * Devuelve el botón seleccionado.
     * @return el boton seleccionado.
     */
    public AbstractButton getSelection() {
        return selection;
    }

    /**
     * Establece el valor seleccionado.
     * Solo se puede seleccionar un botón del grupo a la vez.
     * @param m el <code>Button</code>
     * @param b <code>true</code> Si este botón va a ser
     *   seleccionado, de lo contrario <code>false</code>
     */
    public void setSelected(AbstractButton m, boolean b) {
        if (b && m != null && m != selection) {
            AbstractButton oldSelection = selection;
            selection = m;
            if (oldSelection != null) {
                oldSelection.setBackground(unselected);
                oldSelection.setForeground(foregrounUnselected);
                
            }
            m.setBackground(selected);
            m.setForeground(foregrounSelected);
        }
    }

    /**
     * Devuelve si se ha seleccionado un {@code AbstractButton}.
     *
     * @param m una instancia de {@code AbstractButton}
     * @return {@code true} si el botón está seleccionado,
     * de lo contrario, devuelve {@code false}
     */
    public boolean isSelected(AbstractButton m) {
        return (m == selection);
    }

    /**
     * Devuelve el número de botones del grupo.
     * @return la cantidad de botones.
     * @since 1.3
     */
    public int getButtonCount() {
        if (buttons == null) {
            return 0;
        } else {
            return buttons.size();
        }
    }
}
