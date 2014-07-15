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
import java.awt.geom.Point2D;
import java.awt.geom.QuadCurve2D;
import java.util.ArrayList;

/**
 * Curva con un punto de control que implementa la interfaz IOShape para que
 * todas las clases personalizadas tengan los mismos atributos/métodos.
 *
 * ver {@link IOShape}, ver {@link QuadCurve2D.Double}
 *
 * @author oskyar (Óscar Zafra)
 */
public class OQuadCurve2D extends QuadCurve2D.Double implements IOShape {

    public static final String NAME = "Curva con 1 pto control";
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
    private ArrayList<Point2D> vPoints;

    private final int CTRLPOINTS = 1;

    /**
     * Constructor que crea una curva con 1 punto de control
     *
     * @param p1 Punto inicial
     * @param ctrl Punto de control
     * @param p2 Punto final
     */
    public OQuadCurve2D(Point2D p1, Point2D ctrl, Point2D p2) {
        super(p1.getX(), p1.getY(), ctrl.getX(), ctrl.getY(), p2.getX(), p2.getY());
        vPoints = new ArrayList();
        vPoints.add(ctrl);
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
    public void setLocation(Point2D p) {
        double dx = p.getX() - this.getX1();
        double dy = p.getY() - this.getY1();

        Point2D newP2 = new Point2D.Double(this.getX2() + dx, this.getY2() + dy);
        Point2D newCtrl = new Point2D.Double(this.getCtrlX() + dx, this.getCtrlY() + dy);
        vPoints.set(0, newCtrl);
        this.setCurve(p, newCtrl, newP2);
    }

    @Override
    public void updateShape(Point2D p1, Point2D p2) {
        this.setCurve(p1, vPoints.get(0), p2);
        if (fillType == 2) {
            gradient = new GradientPaint(p1, fillColor, p2, gradientColor);
        }
    }

    @Override
    public ArrayList<Point2D> getArrayPoints() {
        return this.vPoints;
    }

    @Override
    public void setPoint(ArrayList<Point2D> vPoints) {
        this.vPoints = vPoints;
    }

    @Override
    public Point2D getOnePoint(int index) {
        return this.vPoints.get(index);
    }

    @Override
    public void setOnePoint(int index, Point2D p) {
        this.vPoints.set(index, p);
        this.updateShape(this.getP1(), this.getP2());
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
    public int getFillType() {
        return fillType;
    }

    @Override
    public void setFillType(int fillType) {
        this.fillType = fillType;
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
        if (fillType == 2) {
            if (gradient != null) {
                gradient = new GradientPaint((float) super.getX1(), (float) super.getY1(), fillColor, (float) super.getX1() + (float) super.getX2(), (float) super.getY1() + (float) super.getY2(), gradientColor);
            } else {
                gradient = new GradientPaint((float) super.getX1(), (float) super.getY1(), fillColor, (float) super.getX1() + (float) super.getX2(), (float) super.getY1() + (float) super.getY2(), fillColor);
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
        gradient = new GradientPaint((float) super.getX1(), (float) super.getY1(), fillColor, (float) super.getX1() + (float) super.getX2(), (float) super.getY1() + (float) super.getY2(), gradientColor);
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
        ArrayList<java.lang.Double> pointsX = new ArrayList();
        ArrayList<java.lang.Double> pointsY = new ArrayList();
        pointsX.add(this.getX1());
        pointsX.add(this.getX2());
        pointsX.add(this.getCtrlX());
        pointsY.add(this.getY1());
        pointsY.add(this.getY2());
        pointsY.add(this.getCtrlY());
        double minX, maxX, minY, maxY;
        minX = maxX = pointsX.get(0);
        minY = maxY = pointsY.get(0);
        for (java.lang.Double d : pointsX) {
            if (minX > d) {
                minX = d;
            } else if (maxX <= d) {
                maxX = d;
            }
        }
        for (java.lang.Double d : pointsY) {
            if (minY > d) {
                minY = d;
            } else if (maxY <= d) {
                maxY = d;
            }
        }

        frame = new ORectangle2D(minX - 4, minY - 4, Math.abs(minX - maxX) + 8, Math.abs(minY - maxY) + 8);
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
}
