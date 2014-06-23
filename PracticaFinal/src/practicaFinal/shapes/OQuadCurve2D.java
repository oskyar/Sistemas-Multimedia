/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package practicaFinal.shapes;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.awt.geom.Point2D;
import java.awt.geom.QuadCurve2D;
import java.util.ArrayList;

/**
 *
 * @author oskyar
 */
public class OQuadCurve2D extends QuadCurve2D.Double implements IOShape{

    private Color color;
    private boolean fill;
    private ArrayList<Point2D> vPoints;
    private Stroke stroke;
    
    private final int CTRLPOINTS=1;

    public OQuadCurve2D(Point2D p1, Point2D ctrl, Point2D p2){
        super(p1.getX(),p1.getY(),ctrl.getX(),ctrl.getY(),p2.getX(),p2.getY());
        vPoints = new ArrayList<>();
        vPoints.add(ctrl);
    }
    
    
    public OQuadCurve2D(OQuadCurve2D qc){
        super(qc.getX1(),qc.getY1(),qc.getCtrlX(),qc.getCtrlY(),qc.getX2(),qc.getY2());
        vPoints = new ArrayList<>();
        vPoints.add(new Point2D.Double(qc.getCtrlX(),qc.getCtrlY()));
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
        Point2D newCtrl = new Point2D.Double(this.getCtrlX()+ dx, this.getCtrlY()+ dy);
        vPoints.set(0,newCtrl);
        this.setCurve(p,newCtrl,newP2);
    }

    @Override
    public void updateShape(Point2D p1, Point2D p2) {
        this.setCurve(p1, vPoints.get(0), p2);
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
