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
 *
 * @author oskyar
 */
public class ORectangle2D extends Rectangle2D.Double implements IOShape{
    public static final String NAME="Rectángulo";
    private int fillType;
    private int strokeType;
    private Color fillColor;
    private Color strokeColor;
    private GradientPaint gradientColor;
    private Point2D p;
    private Stroke stroke;
    private float strokeWidth;
    
    private final int CTRLPOINTS = 0;

    public ORectangle2D(Point2D p1, double width, double height){
        super(p1.getX(),p1.getY(),width,height);
    }
    
    public ORectangle2D(Point2D p1, Point2D p2){
        super(p1.getX(),p1.getY(),Math.abs(p1.getX()-p2.getX()),Math.abs(p1.getY()-p2.getY()));
    }    
    
    public ORectangle2D(ORectangle2D rect){
        super(rect.getX(),rect.getY(),rect.getWidth(),rect.getHeight());
    }

    @Override
    public Stroke getStroke() {
        return this.stroke;
    }

    @Override
    public void setStroke(Stroke sk) {
        if(sk != null)
            this.stroke = sk;
    }

    @Override
    public void draw(Graphics2D g2d) {
        if(strokeType==0){
            stroke = new BasicStroke(strokeWidth);
        }else if(strokeType == 1){
            final float dash[] = {1.0f,0.f,20.0f};
            stroke = new BasicStroke(strokeWidth, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND, 10.0f, dash, 0.0f);
        }
        g2d.setStroke(stroke);
        g2d.setColor(strokeColor);
        g2d.draw(this);
        
        g2d.setColor(fillColor);
        if(fillType==1){
            g2d.fill(this);
        }else if(fillType==2){
            g2d.setPaint(gradientColor);
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
        p1= new Point2D.Double(this.getBounds2D().getX(),this.getBounds2D().getY());
        p2=new Point2D.Double(p2.getX()+this.getBounds2D().getX(),p2.getY()+this.getBounds2D().getY());
        if(fillType==2){
            gradientColor = new GradientPaint(p1, gradientColor.getColor1(), p2, gradientColor.getColor2());
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
    public double getX(){
        return super.getBounds2D().getX();
    }
    
    @Override
    public double getY(){
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
    public GradientPaint getGradientColor() {
        return gradientColor;
    }

    @Override
    public void setGradientColor(GradientPaint gradientColor) {
        this.gradientColor = gradientColor;
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
}