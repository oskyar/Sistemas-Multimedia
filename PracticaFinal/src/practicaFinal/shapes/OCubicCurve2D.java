/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package practicaFinal.shapes;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.awt.geom.CubicCurve2D;
import java.awt.geom.Point2D;
import java.util.ArrayList;

/**
 *
 * @author oskyar
 */
public class OCubicCurve2D extends CubicCurve2D.Double implements IOShape{

    private Color color;
    private boolean fill;
    private ArrayList<Point2D> vPoints;
    private Stroke stroke;
    
    private final int CTRLPOINTS=2;    

    public OCubicCurve2D(Point2D p1, Point2D ctrl1, Point2D ctrl2, Point2D p2){
        super(p1.getX(),p1.getY(),ctrl1.getX(),ctrl1.getY(),ctrl2.getX(),ctrl2.getY(),p2.getX(),p2.getY());
        vPoints = new ArrayList<>();
        vPoints.add(ctrl1);
        vPoints.add(ctrl2);
    }
    
    
    public OCubicCurve2D(OCubicCurve2D qc){
        super(qc.getX1(),qc.getY1(),qc.getCtrlX1(),qc.getCtrlY1(),qc.getCtrlX2(),qc.getCtrlY2(),qc.getX2(),qc.getY2());
        vPoints = new ArrayList<>();
        vPoints.add(new Point2D.Double(qc.getCtrlX1(),qc.getCtrlY1()));
        vPoints.add(new Point2D.Double(qc.getCtrlX2(),qc.getCtrlY2()));
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
    public Color getColor() {
        return this.color;
    }

    @Override
    public void setColor(Color c) {
        if( c !=null) 
            this.color = c;
    }

    @Override
    public boolean getFill() {
        return this.fill;
    }

    @Override
    public void setFill(boolean fill) {
        this.fill = fill;
    }

    @Override
    public void draw(Graphics2D g2d) {
        g2d.setPaint(getColor());
        g2d.setStroke(getStroke());
        if(fill)
            g2d.fill(this);
        g2d.draw(this);
    }

    @Override
    public void setLocation(Point2D p) {
        double dx = p.getX() - this.getX1();
        double dy = p.getY() - this.getY1();
        
        Point2D newP2 = new Point2D.Double(this.getX2() + dx, this.getY2() + dy);
        Point2D newCtrl1 = new Point2D.Double(this.getCtrlX1()+ dx, this.getCtrlY1()+ dy);
        Point2D newCtrl2 = new Point2D.Double(this.getCtrlX2()+ dx, this.getCtrlY2()+ dy);
        vPoints.set(0,newCtrl1);
        vPoints.set(1,newCtrl2);
        this.setCurve(p,newCtrl1,newCtrl2,newP2);
    }

    @Override
    public void updateShape(Point2D p1, Point2D p2) {
        this.setCurve(p1, vPoints.get(0),vPoints.get(1), p2);
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
       
}
