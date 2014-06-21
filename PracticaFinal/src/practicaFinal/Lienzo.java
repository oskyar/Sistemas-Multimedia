/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicaFinal;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Stroke;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.function.Consumer;
import practicaFinal.shapes.IOShape;
import practicaFinal.shapes.OEllipse2D;
import practicaFinal.shapes.OLine2D;
import practicaFinal.shapes.OPoint2D;
import practicaFinal.shapes.ORectangle2D;

/**
 *
 * @author Óscar
 */
public class Lienzo extends javax.swing.JPanel {

    final static int PUNTO = 0;
    final static int LINEA = 1;
    final static int RECTANGULO = 2;
    final static int ELIPSE = 3;

    //Variables privadas
    private static Color color;
    private static int forma;
    private static Stroke stroke;
    private static boolean relleno;
    private static boolean editar;
    private Point2D p;
    private IOShape s;
    private final ArrayList<IOShape> vShape;
    private final Point2D dXY;
    private BufferedImage img;
    private BufferedImage imgDest;

    /**
     * Constructor sin parámetros de la clase Lienzo
     *
     * Se inician los componentes necesarios a un valor por defecto.
     */
    public Lienzo() {
        initComponents();
        vShape = new ArrayList();
        editar = false;
        dXY = new Point(0, 0);
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
    }

    private IOShape createShape(Point2D p1, Point2D p2) {
        if (p1 == null || (p2 == null && forma != PUNTO)) {
            return null;
        }

        switch (forma) {
            case PUNTO:
                s = new OPoint2D(p1, p1);
                s.setColor(color);
                s.setFill(relleno);
                s.setStroke(stroke);
                return s;
            case LINEA:
                s = new OLine2D(p1, p1);
                s.setColor(color);
                s.setFill(relleno);
                s.setStroke(stroke);
                return s;
            case RECTANGULO:
                s = new ORectangle2D(p1, p1);
                s.setColor(color);
                s.setFill(relleno);
                s.setStroke(stroke);
                return s;
            case ELIPSE:
                s = new OEllipse2D(p1, p1);
                s.setColor(color);
                s.setFill(relleno);
                s.setStroke(stroke);
                return s;
            default:
                return s = null;
        }
    }

    private IOShape getSelectedShape(Point2D p) {
        //Recorro el vector al revés, porque la primera figura en dibujarse es la última en seleccionarse.
        for(int i=vShape.size()-1; i>=0; i--){
            if(vShape.get(i).contains(p)){
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

        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                formMouseReleased(evt);
            }
        });
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                formMouseDragged(evt);
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
        if (!editar) {
            vShape.add(createShape(p, p));
        } else {
            s = getSelectedShape(evt.getPoint());
            if (s != null) {
                double x = s.getBoundsX();
                double y = s.getBoundsY();
                dXY.setLocation(x - p.getX(), y - p.getY());
            }
        }
    }//GEN-LAST:event_formMousePressed

    private void formMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseReleased
        formMouseDragged(evt);
    }//GEN-LAST:event_formMouseReleased

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        Point pEvt = evt.getPoint();

        if (!editar) {
            s.updateShape(p, evt.getPoint());
        } else {
            if (s != null) {
                s.setLocation(new Point2D.Double(pEvt.getX() + dXY.getX(), pEvt.getY() + dXY.getY()));
            }
        }
        this.repaint();
    }//GEN-LAST:event_formMouseDragged

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

    public static void setColor(Color color) {
        Lienzo.color = color;
    }

    public Color getColor() {
        return color;
    }

    public static int getForma() {
        return Lienzo.forma;
    }

    public static void setForma(int forma) {
        Lienzo.forma = forma;
    }

    public Point2D getP() {
        return p;
    }

    public void setP(Point p) {
        this.p = p;
    }

    public static boolean isRelleno() {
        return Lienzo.relleno;
    }

    public static void setRelleno(boolean relleno) {
        Lienzo.relleno = relleno;
    }

    public boolean isEditar() {
        return editar;
    }

    public static void setEditar(boolean editar) {
        Lienzo.editar = editar;
    }

    public Stroke getStroke() {
        return Lienzo.stroke;
    }

    public static void setStroke(Stroke sk) {
        stroke = sk;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
