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

import gt.edu.meso.jui.JColorListCellRenderer;
import gt.edu.meso.util.JColor;
import gt.edu.meso.util.Notation;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;

/**
 * Un <code>BandaColor2D </code> es el encargado de dibujar una banda
 * de color en el linezo.
 * @author wil
 * @version 1.0.0
 * @since 1.0.0
 */
public class BandaColor2D implements Graphics2DRenderer {
    
    /** Determina si la banda estara habilitado ono. */
    private boolean enabled;
    
    /** Color de la banda. */
    private JColor color;
    
    /** Dimension de la banda, */
    private Rect rect;
    
    /** Dimensione de la informacion de la banda. */
    private Rect rectstr;
    
    /** Tipo de la banda de color.*/
    private final JColorListCellRenderer.TypeComboModel tcm;

    /**
     * Genere un nuevo BandaColor2D.
     * @param tcm Tipo de banda.
     */
    public BandaColor2D(JColorListCellRenderer.TypeComboModel tcm) {
        this.tcm = tcm;
        this.enabled = false;
    }
    
    /**
     * Devuelve las dimensiones de la banda.
     * @return Un {@code Rect} como valor.
     */
    public Rect getRect() {
        return rect;
    }

    /**
     * Establece las dimensiones de la banda.
     * @param rect Un {@code Rect} como valor.
     */
    public void setRect(Rect rect) {
        this.rect = rect;
    }

    /**
     * Devuelve las dimensiona de la informacion.
     * @return Un {@code Rect} como valor.
     */
    public Rect getRectStr() {
        return rectstr;
    }

    /**
     * Establece las dimensiones de la informacion.
     * @param rectstr Un {@code Rect} como valor.
     */
    public void setRectStr(Rect rectstr) {
        this.rectstr = rectstr;
    }

    @Override
    public void render(Renderer renderer, Graphics2D g, double elapsedTime) {
        if (color != null && rect != null && enabled) {
            int x = rect.getX(),
                y = rect.getY();
            
            int width  = rect.getWidth(),
                height = rect.getHeight();
            
            // Antes de graficar un color con trasparencia,
            // configuramos el graficador JAVA.
            g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, 
                               RenderingHints.VALUE_ANTIALIAS_ON);
            
            // Establecemos la trasnparencia entre 0 - 1.
            g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1.0f));            
            final Color awtcolor = color.getAWTColor();
            
            g.setColor(awtcolor);           // color al graficar.
            g.fillRect(x, y, width, height);// dibujar un rectangulo.
            
            // dibujar un borde si se puede.
            drawBorder(g, awtcolor, x, y, width, height, false);
            
            if (rectstr != null) {
                // Establecemos la trasnparencia entre 0 - 1.
                g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.3f));
                
                // Dibujamos una silueta de la banda, donde
                // conectara con la informacion del color establecido.
                g.fillRect(rectstr.getX(), rectstr.getY(), rectstr.getWidth(), rectstr.getHeight());
                drawBorder(g, awtcolor,    rectstr.getX(), rectstr.getY(),     rectstr.getWidth(), rectstr.getHeight(), false);
                
                // Establecemos la trasnparencia entre 0 - 1.
                g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1.0f));
                    
                int x00 = rectstr.getX() - 7;
                int y00 = rectstr.getY() - 25;
                
                int w00 = 30;
                if (tcm == JColorListCellRenderer.TypeComboModel.COLOR_MULTIPLICADOR 
                        || tcm == JColorListCellRenderer.TypeComboModel.COLOR_TOLERANCIA) {
                    w00 = 80;
                    x00 -= 20;
                }
                
                // Grado donde se vizualizara la información.
                g.fillRoundRect(x00, y00, w00, 25, 10, 10);
                drawBorder(g, awtcolor, x00, y00, w00, 25, true);
                
                int offsetX = x00 + 10;
                if (!color.equals(JColor.DEFAULT)) {
                    BufferedImage[] text2d = null;
                    
                    final boolean esblack = awtcolor.equals(Color.WHITE);
                    switch (tcm) {
                        case COLOR_BANDA:
                            double val = color.getValue();
                            text2d = String2D.createBuffered(Integer.toString((int) val), esblack);
                            break;
                        case COLOR_MULTIPLICADOR:
                            final double  mult = color.getMultiplier();
                            final String prefx = color.getMultiplierPrefix();

                            Notation notation;                
                            switch (prefx) {
                                case "K":
                                    notation = new Notation(mult, Notation.Prefix.Kilo);
                                    break;
                                case "M":
                                    notation = new Notation(mult, Notation.Prefix.Mega);
                                    break;
                                case "G":
                                    notation = new Notation(mult, Notation.Prefix.Giga);
                                    break;
                                default:
                                    notation = new Notation(mult);
                                    break;
                            }
                            if (mult >= 1) {
                                int multInt = (int) notation.getUnscaleNumber();
                                text2d = String2D.createBuffered("x" + multInt + color.getMultiplierPrefix(), esblack);
                            } else {
                                text2d = String2D.createBuffered("x" + mult + color.getMultiplierPrefix(), esblack);
                            }
                            
                            
                            break;
                        case COLOR_TOLERANCIA:
                            text2d = String2D.createBuffered("$" + color.getScaleTolerance() + "%", esblack);
                            break;
                        default:
                            throw new AssertionError();
                    }
                    if (text2d != null) {
                        for (BufferedImage bi : text2d) {
                            if (bi == null)
                                continue;
                            
                            int b2dw = (int) (bi.getWidth() * 0.15);
                            int b2dh = (int) (bi.getHeight() * 0.15);
                            
                            g.drawImage(bi, offsetX, y00 + 8, b2dw, b2dh, null);
                            offsetX += (b2dw + 2);
                        }
                    }
                }
            }
        }
    }
    
    /**
     * Metod encargado de graficar un borde a las bandas de colores, si el color
     * de fono es blanca, de se asi se generar un rectangulo si relleno como borde
     * de un color oscuro para resaltar la banda dibujada.
     * @param g Graficador JAVA 2D.
     * @param bgcolor Color del fondo actual.
     * @param x posicion en x.
     * @param y posicion en y.
     * @param w largo.
     * @param h ancho.
     * @param round {@code true} si dibujamos un objeto con esquinas
     *              redondas, de lo contrario {@code false}
     */
    private void drawBorder(Graphics2D g, Color bgcolor, int x, int y, int w, int h, boolean round) {
        if (bgcolor.equals(Color.WHITE)) {
            g.setColor(Color.LIGHT_GRAY);
            
            if (round) {
                g.drawRoundRect(x, y, w, h, 10, 10);
            } else {
                g.drawRect(x, y, w, h);
            }
            g.setColor(bgcolor);
        }
    }

    /**
     * Determina el estado de la banda de color.
     * @return un valor logico.
     */
    public boolean isEnabled() {
        return enabled;
    }

    /**
     * Establece el estado de la banda de color.
     * @param enabled un boolean como valor.
     */
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    /**
     * Devuelve el color actual de la banda.
     * @return Color actual.
     */
    public JColor getColor() {
        return color;
    }

    /**
     * Establece el color que utilizara la banda.
     * @param color Color de la banda.
     */
    public void setColor(JColor color) {
        this.color = color;
    }
}
