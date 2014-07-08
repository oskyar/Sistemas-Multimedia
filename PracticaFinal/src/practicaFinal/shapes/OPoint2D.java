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
import static practicaFinal.shapes.ORectangle2D.NAME;

/**
 *
 * @author oskyar
 */
public class OPoint2D extends Line2D.Double implements IOShape {

    public static final String NAME="Punto";
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
    
    private final int CTRLPOINTS=0;

    public OPoint2D(Point2D p1) {
        super(p1.getX(), p1.getY(), p1.getX(), p1.getY());
    }

    public OPoint2D(double x, double y) {
        super(x,y,x,y);
    }

    public OPoint2D(Point2D p1, Point2D p2) {
        super(p1.getX(), p1.getY(), p1.getX(), p1.getY());
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
       if(strokeType==0){
            stroke = new BasicStroke(strokeWidth);
        }else if(strokeType == 1){
            final float dash[] = {10.0f};
            stroke = new BasicStroke(strokeWidth, strokeCap, strokeJoin, 5.0f, dash, 0.0f);
        }
        g2d.setStroke(stroke);
        g2d.setColor(strokeColor);
        g2d.draw(this);
        
        g2d.setColor(fillColor);
        if(fillType==1){
            g2d.fill(this);
        }else if(fillType==2){
            g2d.setPaint(gradient);
            g2d.fill(this);
        }
    }

    @Override
    public boolean contains(Point2D p) {
        Point2D aux = new Point2D.Double(getP1().getX(), getP1().getY());
        return aux.distance(p) <= 9.0 +strokeWidth/2;
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
        //Nada que añadir al punto
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
        /*if(fillType==2){
            if(gradient != null){
                //gradient = new GradientPaint((float)super.getX(),(float)super.getY(), fillColor, (float)super.getX()+(float)super.getWidth(),(float)super.getY()+(float)super.getHeight(), gradientColor);
            }else{
                gradient = new GradientPaint((float)super.getX(),(float)super.getY(), fillColor, (float)super.getX()+(float)super.getWidth(),(float)super.getY()+(float)super.getHeight(), fillColor);
            }
        }*/
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
       /* this.gradientColor = gradientColor;
        gradient = new GradientPaint((float)super.getX(),(float)super.getY(), fillColor, (float)super.getX()+(float)super.getWidth(),(float)super.getY()+(float)super.getHeight(), gradientColor);
               */
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
        //Para que no aparezca justo por el borde sino que se vea un poquito de margen (por eso el -2) y tengo en cuenta
        //El tamaño del trazo hay que tenerlo en cuenta también.
        frame = new ORectangle2D( (this.getX()-2-strokeWidth/2), (this.getY()-2-strokeWidth/2),  strokeWidth+6,strokeWidth+6);
        frame.setStrokeWidth(2);
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