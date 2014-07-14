/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicaFinal.shapes;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.util.ArrayList;

/**
 * Línea que implementa la interfaz IOShape para que todas las clases
 * personalizadas tengan los mismos atributos/métodos.
 *
 * ver {@link IOShape}, ver {@link Line2D.Double}
 * 
 * @author oskyar (Óscar Zafra)
 */
public class OLine2D extends Line2D.Double implements IOShape {

    public static final String NAME = "Línea";
    private int fillType;
    private int strokeType;
    private Color fillColor;
    private Color strokeColor;
    private Color gradientColor;
    private GradientPaint gradient;
    private Point2D p;
    private Stroke stroke;
    private float strokeWidth;
    private ORectangle2D frame;
    private int strokeJoin;
    private int strokeCap;

    private final int CTRLPOINTS = 0;

    /**
     * Crea una línea con dos puntos.
     *
     * @param p1 Punto inicial.
     * @param p2 Punto final.
     */
    public OLine2D(Point2D p1, Point2D p2) {
        super(p1.getX(), p1.getY(), p2.getX(), p2.getY());
    }

    @Override
    public Stroke getStroke() {
        return this.stroke;
    }

    @Override
    public void setStroke(Stroke sk) {
        if (sk != null) {
            this.stroke = sk;
        }
    }

    @Override
    public void draw(Graphics2D g2d) {
        if (strokeType == 0) {
            stroke = new BasicStroke(strokeWidth);
        } else if (strokeType == 1) {
            final float dash[] = {1.0f, 0.0f, 20.0f};
            stroke = new BasicStroke(strokeWidth, strokeCap, strokeJoin, 10.0f, dash, 0.0f);
        }
        g2d.setStroke(stroke);
        g2d.setColor(strokeColor);
        g2d.draw(this);

        g2d.setColor(fillColor);
        if (fillType == 1) {
            g2d.fill(this);
        } else if (fillType == 2) {
            g2d.setPaint(gradient);
            g2d.fill(this);
        }
    }

    @Override
    public boolean contains(Point2D p) {
        return this.ptLineDist(p) <= 3.0;
    }

    @Override
    public void setLocation(Point2D p) {
        double dx = p.getX() - this.getX1();
        double dy = p.getY() - this.getY1();
        Point2D newP = new Point2D.Double(this.getX2() + dx, this.getY2() + dy);
        this.setLine(p, newP);
    }

    @Override
    public void updateShape(Point2D p1, Point2D p2) {
        this.setLine(p1, p2);
        if (fillType == 2) {
            gradient = new GradientPaint(p1, fillColor, p2, gradientColor);
        }
    }

    @Override
    public ArrayList<Point2D> getArrayPoints() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setPoint(ArrayList<Point2D> vPoints) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Point2D getOnePoint(int index) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setOnePoint(int index, Point2D p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getCtrlPoints() {
        return this.CTRLPOINTS;
    }

    @Override
    public double getX() {
        return super.getX1();
    }

    @Override
    public double getY() {
        return super.getY1();
    }

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public IOShape clone() {
        return (IOShape) super.clone();
    }

    @Override
    public GradientPaint getGradient() {
        return gradient;
    }

    @Override
    public void setGradient(GradientPaint gradient) {
        this.gradient = gradient;
    }

    @Override
    public void drawFrame(Graphics2D g2d) {
        double x1, x2, y1, y2;
        x1 = Math.min(this.getX1(), this.getX2());
        x2 = Math.max(this.getX1(), this.getX2());
        y1 = Math.min(this.getY1(), this.getY2());
        y2 = Math.max(this.getY1(), this.getY2());

        frame = new ORectangle2D(x1 - 4, y1 - 4, Math.abs(x1 - x2) + 8, Math.abs(y1 - y2) + 8);
        frame.setStrokeWidth(1);
        frame.setStrokeType(1);
        frame.setStrokeColor(Color.RED);
        frame.setFillType(0);
        frame.draw(g2d);
        //return frame;
    }

    @Override
    public void createGradient(Point2D p1, Point2D p2) {
        gradient = new GradientPaint(p1, fillColor, p2, gradientColor);
    }

    @Override
    public void updateGradient(Point2D p1, Point2D p2) {
        gradient = new GradientPaint(p1, fillColor, p2, gradientColor);
    }

    @Override
    public int getStrokeJoinStyle() {
        return strokeJoin;
    }

    @Override
    public void setStrokeJoinStyle(int strokeJoin) {
        this.strokeJoin = strokeJoin;
    }

    @Override
    public int getStrokeCapStyle() {
        return strokeCap;
    }

    @Override
    public void setStrokeCapStyle(int strokeCap) {
        this.strokeCap = strokeCap;
    }

    @Override
    public int getStrokeType() {
        return strokeType;
    }

    @Override
    public void setStrokeType(int strokeType) {
        this.strokeType = strokeType;
    }

    @Override
    public Color getFillColor() {
        return fillColor;
    }

    @Override
    public void setFillColor(Color fillColor) {
        this.fillColor = fillColor;
        System.err.println("ETNRA " + fillType);
        if (fillType == 2) {
            if (gradient != null) {
                gradient = new GradientPaint((float) super.getX1(), (float) super.getY1(), fillColor, (float) super.getX2(), (float) super.getY2(), gradientColor);
            } else {
                gradient = new GradientPaint((float) super.getX1(), (float) super.getY1(), fillColor, (float) super.getX2(), (float) super.getY2(), fillColor);
            }
        }
    }

    @Override
    public Color getStrokeColor() {
        return strokeColor;
    }

    @Override
    public void setStrokeColor(Color strokeColor) {
        this.strokeColor = strokeColor;
    }

    @Override
    public Color getGradientColor() {
        return gradientColor;
    }

    @Override
    public void setGradientColor(Color gradientColor) {
        this.gradientColor = gradientColor;
        gradient = new GradientPaint((float) super.getX1(), (float) super.getY1(), fillColor, (float) super.getX2(), (float) super.getY2(), gradientColor);
    }

    @Override
    public float getStrokeWidth() {
        return strokeWidth;
    }

    @Override
    public void setStrokeWidth(float strokeWidth) {
        this.strokeWidth = strokeWidth;
    }

    @Override
    public int getFillType() {
        return this.fillType;
    }

    @Override
    public void setFillType(int fill) {
        this.fillType = fill;
    }

}
