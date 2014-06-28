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
import java.awt.event.ComponentAdapter;
import java.awt.event.ContainerAdapter;
import java.awt.event.ContainerEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Vector;
import practicaFinal.shapes.IOShape;
import practicaFinal.shapes.OCubicCurve2D;
import practicaFinal.shapes.OEllipse2D;
import practicaFinal.shapes.OLine2D;
import practicaFinal.shapes.OPoint2D;
import practicaFinal.shapes.OQuadCurve2D;
import practicaFinal.shapes.ORectangle2D;
import practicaFinal.shapes.ORoundRectangle2D;

/**
 *
 * @author Óscar
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

    final static int TYPE_FILL_NONE = 0;
    final static int TYPE_FILL_SOLID = 1;
    final static int TYPE_FILL_GRADIENT = 2;

    //Variables privadas
    private static Color strokeColor;
    private static Color fillColor;
    private static Color gradientColor;
    private static int forma;
    private static int fillType;
    private static int strokeType;
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
        vdXY = new ArrayList<>();
    }

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
                s = new OPoint2D(p1, p1);
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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                formMouseDragged(evt);
            }
        });
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
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
        } else {
            s = getSelectedShape(evt.getPoint());
            //Compruebo que se pincha con el botón izquierdo del ratón
            if (s != null) {
                double x, y;
                x = s.getX();
                y = s.getY();
                if (evt.getButton() == 1) {
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
        } else {
            if (vShapeSelected.indexOf(vShape.indexOf(s)) != -1) {
                if (!evt.isControlDown()) {
                    for (int i = 0; i < vShapeSelected.size(); i++) {
                        //En este chorizo lo que hago es, coger todas las figuras seleccionadas y moverlas a la vez proporcionalmente.
                        vShape.get(vShapeSelected.get(i)).setLocation(new Point2D.Double(pEvt.getX() + vdXY.get(i).getX(), pEvt.getY() + vdXY.get(i).getY()));
                    }
                }
            }
        }
        this.repaint();
    }//GEN-LAST:event_formMouseDragged

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        /* p = evt.getPoint();
         if (!editar) {
         if (ctrlCurva == 0) {
         vShape.add(createShape(p, p));
         } else {
         if (s != null) {
         s.setOnePoint(ctrlCurva - 1, p);
         }
         }
         } else {
         s = getSelectedShape(evt.getPoint());
         if (s != null) {
         double x, y;
         x = s.getX();
         y = s.getY();
         //Compruebo que se pincha con el botón izquierdo del ratón
         if (evt.getButton() == 1) {
         //Si no está seleccionada la forma se selecciona
         if(!vShapeSelected.contains(vShape.indexOf(s))){
         if(!keyControl){
         vdXY.clear();
         vShapeSelected.clear();
         }
         vShapeSelected.add(vShape.indexOf(s));
         vdXY.add(new Point2D.Double(x - p.getX(), y - p.getY()));
         }else{
         if(keyControl){
         vdXY.remove(vShapeSelected.indexOf(vShape.indexOf(s)));
         vShapeSelected.remove(vShapeSelected.indexOf(vShape.indexOf(s)));
         }
         }
         } /*else if (evt.getButton() == 2) {
         if (!vShapeSelected.contains(vShape.indexOf(s))) {
         vdXY.add(new Point2D.Double(x - p.getX(), y - p.getY()));
         vShapeSelected.add(vShape.indexOf(s));
         }
         } else if (evt.getButton() == 3) {
         vdXY.add(new Point2D.Double(x - p.getX(), y - p.getY()));
         //Compruebo que S existe en el vector vShape y luego si el valor que devuelve está contenido en vShapeSelected
         if (vShapeSelected.contains(vShape.indexOf(s))) {
         vdXY.remove(vShapeSelected.indexOf(vShape.indexOf(s)));
         vShapeSelected.remove(vShapeSelected.indexOf(vShape.indexOf(s)));
         }
         }*
         }
         }*/
    }//GEN-LAST:event_formMouseClicked

    void setImageOriginal(BufferedImage img) {
        if (img != null) {
            setPreferredSize(new Dimension(img.getWidth(), img.getHeight()));
            this.img = img;
            setImageActual(img);
        }
    }

    public BufferedImage getImageOriginal() {
        return this.img;
    }

    public BufferedImage volcado(BufferedImage img) {
        Graphics2D g = img.createGraphics();
        vShape.stream().forEach((sh) -> {
            sh.draw(g);
        });
        return img;
    }

    void setImageActual(BufferedImage imgDest) {
        setPreferredSize(new Dimension(img.getWidth(), img.getHeight()));
        this.imgDest = imgDest;
    }

    public BufferedImage getImageActual() {
        return this.imgDest;
    }

    public static void setFillColor(Color color) {
        Lienzo.fillColor = color;
    }

    public Color getFillColor() {
        return Lienzo.fillColor;
    }

    public static int getForma() {
        return Lienzo.forma;
    }

    public static void setForma(int forma) {
        Lienzo.ctrlCurva = 0;
        Lienzo.forma = forma;
    }

    public Point2D getP() {
        return p;
    }

    public void setP(Point p) {
        this.p = p;
    }

    public boolean isEditar() {
        return editar;
    }

    public static void setEditar(boolean editar) {
        Lienzo.ctrlCurva = 0;
        Lienzo.editar = editar;
    }

    public Stroke getStroke() {
        return Lienzo.stroke;
    }

    public static void setStroke(Stroke sk) {
        stroke = sk;
    }

    public int getMaxPuntosControl() {
        return this.maxPuntosControl;
    }

    public void setMaxPuntosControl(int num) {
        this.maxPuntosControl = num;
    }

    public static int getCtrlCurva() {
        return Lienzo.ctrlCurva;
    }

    public static void setCtrlCurva(int num) {
        Lienzo.ctrlCurva = num;
    }

    public static int getFillType() {
        return fillType;
    }

    public static void setFillType(int fillType) {
        Lienzo.fillType = fillType;
    }

    public static Color getGradientColor() {
        return gradientColor;
    }

    public static void setGradientColor(Color gradientColor) {
        Lienzo.gradientColor = gradientColor;
    }

    public static Color getStrokeColor() {
        return strokeColor;
    }

    public static void setStrokeColor(Color strokeColor) {
        Lienzo.strokeColor = strokeColor;
    }

    public static int getStrokeType() {
        return strokeType;
    }

    public static void setStrokeType(int strokeType) {
        Lienzo.strokeType = strokeType;
    }

    public static float getStrokeWidth() {
        return strokeWidth;
    }

    public static void setStrokeWidth(float strokeWidth) {
        Lienzo.strokeWidth = strokeWidth;
    }

    public ArrayList<IOShape> getvShape() {
        return vShape;
    }

    public void setvShape(ArrayList<IOShape> vShape) {
        this.vShape = vShape;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
    public ArrayList<Integer> getvShapeSelected() {
        return vShapeSelected;
    }

    public void setvShapeSelected(ArrayList<Integer> vShapeSelected) {
        this.vShapeSelected = vShapeSelected;
    }

    void changeFillProperty(int typeFill, Color color1, Color color2) {
        if (!vShapeSelected.isEmpty()) {
            for (int index : vShapeSelected) {
                vShape.get(index).setFillColor(color1);
                vShape.get(index).setFillType(typeFill);
                if (typeFill == TYPE_FILL_GRADIENT) {
                    System.err.println("Entra");
                    vShape.get(index).setGradientColor(color2);
                }
            }
        }
    }

    public ArrayList<Point2D> getVdXY() {
        return vdXY;
    }

    public void setVdXY(ArrayList<Point2D> vdXY) {
        this.vdXY = vdXY;
    }

}
