/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicaFinal;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Stroke;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import practicaFinal.shapes.IOShape;
import practicaFinal.shapes.OCubicCurve2D;
import practicaFinal.shapes.OEllipse2D;
import practicaFinal.shapes.OLine2D;
import practicaFinal.shapes.OPoint2D;
import practicaFinal.shapes.OQuadCurve2D;
import practicaFinal.shapes.ORectangle2D;
import practicaFinal.shapes.ORoundRectangle2D;

/**
 * Componente en el cual se van a mostrar las imágenes y se podrán dibujar
 * formas como puntos, líneas, rectángulos...
 *
 * Éste va incrustado dentro de VentanaInternaImagen que es un componente de
 * tipo JInternalFrame.
 *
 * La mayoría de las funcionalidades son para formas e imágenes.
 *
 * @author oskyar (Óscar Zafra).
 *
 * see {@link javax.swing.JPanel}
 */
public class Lienzo extends javax.swing.JPanel {

    final static int PUNTO = 0;
    final static int LINEA = 1;
    final static int RECTANGULO = 2;
    final static int ELIPSE = 3;
    final static int CURVACONTROL = 4;
    final static int CURVACUBICACONTROL = 5;
    final static int RECTANGULOREDONDEADO = 6;

    final static int TYPE_STROKE_COLOUR = 2;
    final static int TYPE_STROKE_WIDTH = 3;

    final static int STROKE_CONTINUOUS = 0;
    final static int STROKE_DISCONTINUOUS = 1;

    final static int COLOR_STROKE = 0;
    final static int COLOR_FILL = 1;
    final static int COLOR_GRADIENT = 2;

    final static int TYPE_FILL_NONE = 0;
    final static int TYPE_FILL_SOLID = 1;
    final static int TYPE_FILL_GRADIENT = 2;

    final static int STYLE_STROKE_JOIN_BEVEL = 0;
    final static int STYLE_STROKE_JOIN_MITER = 1;
    final static int STYLE_STROKE_JOIN_ROUND = 2;

    final static int STYLE_STROKE_CAP_BUTT = 0;
    final static int STYLE_STROKE_CAP_ROUND = 1;
    final static int STYLE_STROKE_CAP_SQUARE = 2;

    //Variables privadas
    private static Color strokeColor;
    private static Color fillColor;
    private static Color gradientColor;
    private static int forma;
    private static int fillType;
    private static int strokeType;
    private static int strokeStyleJoinType;
    private static int strokeStyleCapType;
    private static float strokeWidth;
    private static Stroke stroke;
    //private static boolean relleno;
    private static boolean editar;
    //Para controlar por qué punto de control vamos
    private static int ctrlCurva = 0;
    private Point2D p;
    private IOShape s;
    private ArrayList<IOShape> vShape;
    private ArrayList<Integer> vShapeSelected;
    private ArrayList<Point2D> vdXY;
    private BufferedImage img;
    private BufferedImage imgDest;
    private int maxPuntosControl;
    private Point2D dGradientXYp1, dGradientXYp2;

    /**
     * Constructor sin parámetros de la clase Lienzo
     *
     * Se inician los componentes necesarios a un valor por defecto.
     */
    public Lienzo() {
        initComponents();
        vShape = new ArrayList();
        vShapeSelected = new ArrayList();
        editar = false;
        vdXY = new ArrayList();
    }

    /**
     * Método principal sobrecargado para poder pintar las figuras con una
     * instancia de Graphics2D
     *
     * @param g Instancia de Graphics.
     */
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        if (imgDest != null) {
            g2d.drawImage(imgDest, 0, 0, this);
        }

        for (IOShape sh : vShape) {
            sh.draw(g2d);
        }

        for (int index : vShapeSelected) {
            vShape.get(index).drawFrame(g2d);
        }
    }

    private IOShape createShape(Point2D p1, Point2D p2) {
        if (p1 == null || (p2 == null && forma != PUNTO)) {
            return null;
        }

        switch (forma) {
            case PUNTO:
                s = new OPoint2D(p1);
                break;
            case LINEA:
                s = new OLine2D(p1, p1);
                break;
            case RECTANGULO:
                s = new ORectangle2D(p1, p1);
                break;
            case ELIPSE:
                s = new OEllipse2D(p1, p1);
                break;
            case CURVACONTROL:
                s = new OQuadCurve2D(p1, p1, p1);
                break;
            case CURVACUBICACONTROL:
                s = new OCubicCurve2D(p1, p1, p1, p1);
                break;
            case RECTANGULOREDONDEADO:
                s = new ORoundRectangle2D(p1, p1, 30, 30);
                break;
            default:
                s = null;
                return s;
        }
        //Código común para todas las formas...
        s.setStrokeColor(strokeColor);
        switch (fillType) {
            case 1:
                s.setFillColor(fillColor);
                break;
            case 2:
                s.setFillColor(fillColor);
                s.setGradientColor(gradientColor);
                GradientPaint gradient = new GradientPaint(p1, fillColor, p2, gradientColor);
                s.setGradient(gradient);
                break;
        }
        s.setFillType(fillType);
        s.setStrokeType(strokeType);
        //s.setStroke(stroke);
        s.setStrokeWidth(strokeWidth);
        maxPuntosControl = s.getCtrlPoints();
        ctrlCurva = 0;
        return s;
    }

    private IOShape getSelectedShape(Point2D p) {
        //Recorro el vector al revés, porque la primera figura en dibujarse es la última en seleccionarse.
        for (int i = vShape.size() - 1; i >= 0; i--) {
            if (vShape.get(i).contains(p)) {
                return vShape.get(i);
            }
        }
        return null;
    }

    private IOShape getSelectedShapeSelected(Point2D p) {
        //Recorro el vector al revés, porque la primera figura en dibujarse es la última en seleccionarse.
        for (int i = vShapeSelected.size() - 1; i >= 0; i--) {
            if (vShape.get(vShapeSelected.get(i)).contains(p)) {
                return vShape.get(vShapeSelected.get(i));
            }
        }
        return null;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBackground(new java.awt.Color(254, 254, 254));
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                formMouseDragged(evt);
            }
        });
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                formMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        p = evt.getPoint();
        if (!evt.isControlDown() && vShapeSelected.isEmpty()) {
            if (ctrlCurva == 0) {
                vShape.add(createShape(p, p));
            } else {
                if (s != null) {
                    s.setOnePoint(ctrlCurva - 1, p);
                }
            }
        } else if (evt.isControlDown() && evt.isAltDown() && !vShapeSelected.isEmpty()) {
            for (Integer i : vShapeSelected) {
                //En este chorizo lo que hago es, coger todas las figuras seleccionadas y moverlas a la vez proporcionalmente.
                if (vShape.get(i).getFillType() == Lienzo.COLOR_GRADIENT) {
                    vShape.get(i).createGradient(p, p);
                }
            }
        } else {
            s = getSelectedShapeSelected(evt.getPoint());
            //Compruebo que se pincha con el botón izquierdo del ratón
            if (s != null) {
                double x, y;
                x = s.getX();
                y = s.getY();
                if (evt.getButton() == evt.BUTTON1) {
                    if (evt.isControlDown()) {
                        //Si no está seleccionada la forma se selecciona
                        if (!vShapeSelected.contains(vShape.indexOf(s))) {
                            vShapeSelected.add(vShape.indexOf(s));
                            vdXY.add(new Point2D.Double(x - p.getX(), y - p.getY()));
                        } else {
                            vdXY.remove(vShapeSelected.indexOf(vShape.indexOf(s)));
                            vShapeSelected.remove(vShapeSelected.indexOf(vShape.indexOf(s)));
                        }
                    }
                    for (int i = 0; i < vShapeSelected.size(); i++) {
                        x = vShape.get(vShapeSelected.get(i)).getX();
                        y = vShape.get(vShapeSelected.get(i)).getY();
                        //En este chorizo lo que hago es, coger todas las figuras seleccionadas y moverlas a la vez proporcionalmente.
                        vdXY.set(i, new Point2D.Double(x - p.getX(), y - p.getY()));
                        if (vShape.get(vShapeSelected.get(i)).getFillType() == Lienzo.TYPE_FILL_GRADIENT) {
                            dGradientXYp1 = new Point2D.Double(vShape.get(vShapeSelected.get(i)).getGradient().getPoint1().getX() - p.getX(), vShape.get(vShapeSelected.get(i)).getGradient().getPoint1().getY() - p.getY());
                            dGradientXYp2 = new Point2D.Double(vShape.get(vShapeSelected.get(i)).getGradient().getPoint2().getX() - p.getX(), vShape.get(vShapeSelected.get(i)).getGradient().getPoint2().getY() - p.getY());
                        }
                    }
                }
            }
        }
        this.repaint();
    }//GEN-LAST:event_formMousePressed

    private void formMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseReleased
        formMouseDragged(evt);
        //Si la curva de control está activada y se ha pintado la línea pero  el punto de control NO.
        if (maxPuntosControl != 0) {
            if (ctrlCurva++ == maxPuntosControl) {
                ctrlCurva = 0;
            }
        }
        this.repaint();
    }//GEN-LAST:event_formMouseReleased

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        Point pEvt = evt.getPoint();

        if (!evt.isControlDown() && vShapeSelected.isEmpty()) {
            if (ctrlCurva == 0) {
                s.updateShape(p, pEvt);
            } else {
                s.setOnePoint(ctrlCurva - 1, pEvt);
            }
        } else if (evt.isControlDown() && evt.isAltDown() && !vShapeSelected.isEmpty()) {
            for (Integer i : vShapeSelected) {
                if (vShape.get(i).getFillType() == Lienzo.TYPE_FILL_GRADIENT) {
                    vShape.get(i).updateGradient(p, pEvt);
                }
            }
        } else {
            //Si encuentra alguna forma seleccionada
            if (vShapeSelected.indexOf(vShape.indexOf(s)) != -1) {
                if (!evt.isControlDown()) {
                    for (int i = 0; i < vShapeSelected.size(); i++) {
                        IOShape sh = vShape.get(vShapeSelected.get(i));
                        //En este chorizo lo que hago es, coger todas las figuras seleccionadas y moverlas a la vez proporcionalmente.
                        sh.setLocation(new Point2D.Double(pEvt.getX() + vdXY.get(i).getX(), pEvt.getY() + vdXY.get(i).getY()));
                        if (sh.getFillType() == TYPE_FILL_GRADIENT) {
                            Point2D p1 = new Point2D.Double(pEvt.getX() + dGradientXYp1.getX(), pEvt.getY() + dGradientXYp1.getY());
                            Point2D p2 = new Point2D.Double(pEvt.getX() + dGradientXYp2.getX(), pEvt.getY() + dGradientXYp2.getY());
                            sh.updateGradient(p1, p2);
                        }
                    }
                }
            }
        }
        this.repaint();
    }//GEN-LAST:event_formMouseDragged

    /**
     * Se modifica la imagen original del lienzo por la pasada por parámetro
     *
     * @param img Imagen que pasará a ser la original.
     */
    public void setImageOriginal(BufferedImage img) {
        if (img != null) {
            setPreferredSize(new Dimension(img.getWidth(), img.getHeight()));
            this.img = img;
            setImageActual(img);
        }
    }

    /**
     * Devuelve la imagen original del Lienzo.
     *
     * @return devuelve un BufferedImage del lienzo.
     */
    public BufferedImage getImageOriginal() {
        return this.img;
    }

    /**
     * Guarda todas las figuras dibujadas en el lienzo en una imagen ó a la
     * imagen que esté en el lienzo si existe.
     *
     * @param img Imagen para el volcado de formas.
     * @return Devuelve una imagen con las formas ya dibujadas.
     */
    public BufferedImage volcado(BufferedImage img) {
        Graphics2D g = img.createGraphics();
        for (IOShape sh : vShape) {
            sh.draw(g);
        }
        return img;
    }

    /**
     * Modifica la imagen actual del lienzo, la que se está usando.
     *
     * @param imgDest Imagen que se va a modificar.
     */
    void setImageActual(BufferedImage imgDest) {
        setPreferredSize(new Dimension(img.getWidth(), img.getHeight()));
        this.imgDest = imgDest;
    }

    /**
     * Devuelve la Imagen actual del Lienzo, que no tiene porqué ser la misma
     * que la original.
     *
     * @return devuelve una imagen de tipo BufferedImage.
     */
    public BufferedImage getImageActual() {
        return this.imgDest;
    }

    /**
     * Modifica el color de relleno del lienzo.
     *
     * @param color Color con el que se va a modificar el color de relleno.
     */
    public static void setFillColor(Color color) {
        Lienzo.fillColor = color;
    }

    /**
     * Devuelve el colro del relleno del Lienzo.
     *
     * @return devuelve el color de relleno del lienzo.
     */
    public static Color getFillColor() {
        return Lienzo.fillColor;
    }

    /**
     * Devuelve la forma actual para pintar.
     *
     * @return devuelve un entero que hace referencia a la forma para pintar.
     */
    public static int getForma() {
        return Lienzo.forma;
    }

    /**
     * Modifica la forma para dibujar
     *
     * @param forma valor de la forma para dibujar.
     */
    public static void setForma(int forma) {
        Lienzo.ctrlCurva = 0;
        Lienzo.forma = forma;
    }

    /**
     * Devuelve el tipo de Relleno que hay seleccionado en el lienzo
     *
     * @return Devuelve un entero con el tipo de relleno.
     */
    public static int getFillType() {
        return fillType;
    }

    /**
     * Modifica el tipo de relleno
     *
     * @param fillType Tipo de relleno.
     */
    public static void setFillType(int fillType) {
        Lienzo.fillType = fillType;
    }

    /**
     * Devuelve el color del gradiente (viene a ser el segundo color del
     * gradiente).
     *
     * @return devuelve el color del gradiente.
     */
    public static Color getGradientColor() {
        return gradientColor;
    }

    /**
     * Modifica el segundo color del gradiente
     *
     * @param gradientColor Color del gradiente
     */
    public static void setGradientColor(Color gradientColor) {
        Lienzo.gradientColor = gradientColor;
    }

    /**
     * Devuelve el color del trazo de los marcos de las figuras
     *
     * @return Devuelve un color.
     */
    public static Color getStrokeColor() {
        return strokeColor;
    }

    /**
     * Modifica el color de los trazos de las figuras
     *
     * @param strokeColor color del trazo seleccionado.
     */
    public static void setStrokeColor(Color strokeColor) {
        Lienzo.strokeColor = strokeColor;
    }

    /**
     * Devuelve el tipo de trazo que hay seleccionado.
     *
     * @return devuelve un número entero con el tipo de trazo.
     */
    public static int getStrokeType() {
        return strokeType;
    }

    /**
     * Modifica el tipo de trazo con el parámetro pasado.
     *
     * @param strokeType tipo de trazo.
     */
    public static void setStrokeType(int strokeType) {
        Lienzo.strokeType = strokeType;
    }

    /**
     * Devuelve el grosor del trazo.
     *
     * @return Devuelve el grosor del trazo en tipo float.
     */
    public static float getStrokeWidth() {
        return strokeWidth;
    }

    /**
     * Modifica el grosor del trazo
     *
     * @param strokeWidth Grosor del trazo.
     */
    public static void setStrokeWidth(float strokeWidth) {
        Lienzo.strokeWidth = strokeWidth;
    }

    /**
     * Vector que contiene todos las formas dibujadas en ese lienzo.
     *
     * @return Devuelve el vector (ArrayList) de figuras pintadas.
     */
    public ArrayList<IOShape> getvShape() {
        return vShape;
    }

    /**
     * Modifica el vector de figuras.
     *
     * @param vShape Vector de figuras.
     */
    public void setvShape(ArrayList<IOShape> vShape) {
        this.vShape = vShape;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
    /**
     * Vector de enteros de figuras seleccionadas
     *
     * @return devuelve un ArrayList de enteros con los números de las figuras
     * seleccionadas
     */
    public ArrayList<Integer> getvShapeSelected() {
        return vShapeSelected;
    }

    /**
     * Modifica el vector de las figuras seleccionadas.
     *
     * @param vShapeSelected ArrayList de enteros de figuras seleccionadas
     */
    public void setvShapeSelected(ArrayList<Integer> vShapeSelected) {
        this.vShapeSelected = vShapeSelected;
    }

    /**
     * Cambia la propiedad del relleno teniendo en cuenta el relleno y dos
     * colores (Relleno y Gradiente).
     *
     * @param typeFill Tipo de relleno, véase constantes de la clase.
     * @param color1 Color para el relleno.
     * @param color2 Color para el gradiente.
     */
    void changeFillProperty(int typeFill, Color color1, Color color2) {
        if (!vShapeSelected.isEmpty()) {
            for (int index : vShapeSelected) {
                vShape.get(index).setFillType(typeFill);
                vShape.get(index).setFillColor(color1);
                if (typeFill == TYPE_FILL_GRADIENT) {
                    vShape.get(index).setGradientColor(color2);
                }
            }
        }
        repaint();
    }

    /**
     * Devuelve un ArrayList de Point2D que contiene la diferencia entre una
     * forma y dónde pinchas a la hora de mover la figura para que no se mueva
     * el ratón de forma extraña al seleccionar una figura.
     *
     * @return Devuelve un ArrayList de Point2D.
     */
    public ArrayList<Point2D> getVdXY() {
        return vdXY;
    }

    /**
     * Modifica el ArrayList de Point2D.
     *
     * @param vdXY Nuevo ArrayList.
     */
    public void setVdXY(ArrayList<Point2D> vdXY) {
        this.vdXY = vdXY;
    }

    /**
     * Cambia las propiedades del color dependiendo del tipo de Color
     *
     * @param TYPE_COLOR Entero que es el tipo de color.
     * @param color1 Color del trazo/relleno.
     * @param color2 Color del gradiente.
     */
    void changeColorProperty(int TYPE_COLOR, Color color1, Color color2) {
        if (!vShapeSelected.isEmpty()) {
            for (int index : vShapeSelected) {
                switch (TYPE_COLOR) {
                    case COLOR_STROKE:
                        vShape.get(index).setStrokeColor(color1);
                        break;
                    case COLOR_FILL:
                        vShape.get(index).setFillColor(color1);
                        break;
                    case COLOR_GRADIENT:
                        vShape.get(index).setFillColor(color1);
                        vShape.get(index).setGradientColor(color2);
                        break;
                }
            }
        }
        repaint();
    }

    /**
     * Cambia la propiedad del ancho del trazo.
     *
     * @param width Tamaño del ancho del trazo
     */
    void changeWidthStrokeProperty(float width) {
        if (!vShapeSelected.isEmpty()) {
            for (int index : vShapeSelected) {
                vShape.get(index).setStrokeWidth(width);
            }
        }
        repaint();
    }

    /**
     * Cambia el tipo de trazo.
     *
     * @param strokeType Tipo de trazo.
     */
    void changeStrokeTypeProperty(int strokeType) {
        if (!vShapeSelected.isEmpty()) {
            for (int index : vShapeSelected) {
                vShape.get(index).setStrokeType(strokeType);
            }
        }
        repaint();
    }

    /**
     * Cambia el tipo de Unión de la línea de trazo.
     *
     * @param strokeTypeJoin Tipo de Unión en el trazo.
     */
    void changeStrokeStyleJoinProperty(int strokeTypeJoin) {
        if (!vShapeSelected.isEmpty()) {
            for (int index : vShapeSelected) {
                vShape.get(index).setStrokeJoinStyle(strokeTypeJoin);
            }
        }
        repaint();
    }

    /**
     * Cambia el tipo de final de la línea de trazo.
     *
     * @param strokeTypeJoin Tipo de finalización en el trazo.
     */
    void changeStrokeStyleCapProperty(int strokeType) {
        if (!vShapeSelected.isEmpty()) {
            for (int index : vShapeSelected) {
                vShape.get(index).setStrokeCapStyle(strokeType);
            }
        }
        repaint();
    }

    /**
     * Devuelve el tipo de unión de la línea del trazo.
     *
     * @return Devuelve un entero con el tipo de unión.
     */
    public static int getStrokeStyleJoinType() {
        return strokeStyleJoinType;
    }

    /**
     * Modifica el tipo de unión del trazo.
     *
     * @param strokeStyleJoinType Tipo de unión del trazo.
     */
    public static void setStrokeStyleJoinType(int strokeStyleJoinType) {
        Lienzo.strokeStyleJoinType = strokeStyleJoinType;
    }

    /**
     * Devuelve el tipo de final de la línea del trazo.
     *
     * @return Devuelve un entero con el tipo de final.
     */
    public static int getStrokeStyleCapType() {
        return strokeStyleCapType;
    }

    /**
     * Modifica el tipo de final del trazo.
     *
     * @param strokeStyleCapType Tipo de final del trazo.
     */
    public static void setStrokeStyleCapType(int strokeStyleCapType) {
        Lienzo.strokeStyleCapType = strokeStyleCapType;
    }

}
