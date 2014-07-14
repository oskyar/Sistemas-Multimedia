/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicaFinal.shapes;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RectangularShape;
import java.util.ArrayList;

/**
 * Clase que crea un Rectángulo que implementa la interfaz IOShape para que
 * todas las clases personalizadas tengan los mismos atributos/métodos.
 *
 * ver {@link IOShape}, ver {@link Rectangle2D.Double}
 *
 * @author oskyar (Óscar Zafra)
 */
public class ORectangle2D extends Rectangle2D.Double implements IOShape {

    public static final String NAME = "Rectángulo";
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
     * Crea un Rectángulo con las coordenadas x,y, alto y ancho.
     *
     * @param x coordenada X del punto 1
     * @param y coordenada Y del punto 1
     * @param width ancho entre el punto 1 y el punto 2
     * @param height alto entre el punto 1 y el punto 2
     */
    public ORectangle2D(double x, double y, double width, double height) {
        super(x, y, width, height);
    }

    /**
     * Crea un rectángulo con dos puntos.
     *
     * @param p1 Punto 1 del rectángulo (esquina superior izquierda)
     * @param p2 Punto 2 del rectángulo (esquina superior derecha)
     */
    public ORectangle2D(Point2D p1, Point2D p2) {
        super(p1.getX(), p1.getY(), Math.abs(p1.getX() - p2.getX()), Math.abs(p1.getY() - p2.getY()));
    }

    /**
     * Crea un rectángulo mediante otro <code>Rectangle2D</code>
     *
     * @param rect Rectángulo
     */
    public ORectangle2D(Rectangle2D rect) {
        super(rect.getX(), rect.getY(), rect.getWidth(), rect.getHeight());
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
        RectangularShape r = (RectangularShape) this;
        r.setFrame(p, new Dimension((int) r.getWidth(), (int) r.getHeight()));
    }

    @Override
    public void updateShape(Point2D p1, Point2D p2) {
        setFrameFromDiagonal(p1, p2);
        //  p1= new Point2D.Double(this.getX(),this.getY());
        //   p2=new Point2D.Double(p2.getX()+this.getX(),p2.getY()+this.getY());
        if (fillType == 2) {
            //  p1= new Point2D.Double(this.getX()+gradient.getPoint1().getX(),this.getY()+gradient.getPoint1().getY());
            //    p2=new Point2D.Double(this.getX()+gradient.getPoint2().getX(),this.getY()+gradient.getPoint2().getY());
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
        return super.getBounds2D().getX();
    }

    @Override
    public double getY() {
        return super.getBounds2D().getY();
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
                gradient = new GradientPaint((float) super.getX(), (float) super.getY(), fillColor, (float) super.getX() + (float) super.getWidth(), (float) super.getY() + (float) super.getHeight(), gradientColor);
            } else {
                gradient = new GradientPaint((float) super.getX(), (float) super.getY(), fillColor, (float) super.getX() + (float) super.getWidth(), (float) super.getY() + (float) super.getHeight(), fillColor);
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
        if (gradient != null) {
            gradient = new GradientPaint((float) gradient.getPoint1().getX(), (float) gradient.getPoint1().getY(), fillColor, (float) gradient.getPoint2().getX(), (float) gradient.getPoint2().getY(), gradientColor);
        } else {
            gradient = new GradientPaint((float) super.getX(), (float) super.getY(), fillColor, (float) super.getX() + (float) super.getWidth(), (float) super.getY() + (float) super.getHeight(), gradientColor);
        }
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
        ORectangle2D r = new ORectangle2D(this);
        r.setFillType(fillType);
        r.setStrokeType(strokeType);
        if (fillColor != null) {
            r.setFillColor(new Color(fillColor.getRGB()));
        }

        if (strokeColor != null) {
            r.setStrokeColor(new Color(strokeColor.getRGB()));
        }

        if (gradientColor != null) {
            r.setGradientColor(new Color(gradientColor.getRGB()));
        }

        if (gradient != null) {
            r.setGradient(new GradientPaint(gradient.getPoint1(), gradient.getColor1(), gradient.getPoint2(), gradient.getColor2()));
        }
        //r.set(new Point.Double((double)p.getX(),(double)p.getY()));
        // int dash[]= {1.0f};
        //r.setStroke(new BasicStroke(strokeWidth, OUT_TOP, OUT_TOP, strokeWidth, dash, strokeWidth));        
        r.setStrokeWidth(strokeWidth);
        r.setStrokeType(strokeType);
        r.setStrokeCapStyle(strokeCap);
        return r;
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
        frame = new ORectangle2D(this.getX() - 4, this.getY() - 4, this.getWidth() + 8, getHeight() + 8);
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
