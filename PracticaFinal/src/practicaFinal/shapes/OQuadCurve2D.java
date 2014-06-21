/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package practicaFinal.shapes;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.awt.geom.Point2D;
import java.awt.geom.QuadCurve2D;
import java.awt.geom.RectangularShape;

/**
 *
 * @author oskyar
 */
public class OQuadCurve2D extends QuadCurve2D.Double implements IOShape{

    private Color color;
    private boolean fill;
    private Point2D p;
    private Stroke stroke;

    public OQuadCurve2D(Point2D p1, Point2D ctrl, Point2D p2){
        super(p1.getX(),p1.getY(),ctrl.getX(),ctrl.getY(),p2.getX(),p2.getY());
        p=ctrl;
    }
    
    
    public OQuadCurve2D(OQuadCurve2D qc){
        super(qc.getX1(),qc.getY1(),qc.getCtrlX(),qc.getCtrlY(),qc.getX2(),qc.getY2());
    }   

    @Override
    public double getBoundsX() {
        return getBounds2D().getX();
    }

    @Override
    public void setX(java.lang.Double x) {
        //this.p.setLocation(x, y);
    }

    @Override
    public double getBoundsY() {
        return getBounds2D().getY();
    }

    @Override
    public void setY(java.lang.Double y) {
        
    }

    @Override
    public Point2D getPoint() {
        return p;
    }

    @Override
    public void setPoint(Point2D p) {
        this.p=p;
        this.setCurve(this.getP1(), p, this.getP2());
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
        
    //    r.setFrame(p, new Dimension((int) r.getWidth(), (int) r.getHeight()));
    }

    @Override
    public void updateShape(Point2D p1, Point2D p2) {
        this.setCurve(p1, this.p, p2);
    }
       
}
