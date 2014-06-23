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
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
import java.awt.geom.RectangularShape;
import java.util.ArrayList;

/**
 *
 * @author oskyar
 */
public class OEllipse2D extends Ellipse2D.Double implements IOShape {

    private Color color;
    private boolean fill;
    private Stroke stroke;
    
    private final int CTRLPOINTS=0;

    public OEllipse2D(Point2D p1, double width, double height) {
        super(p1.getX(), p1.getY(), width, height);
    }

    public OEllipse2D(Point2D p1, Point2D p2) {
        super(p1.getX(), p1.getY(), Math.abs(p1.getX() - p2.getX()), Math.abs(p1.getY() - p2.getY()));
    }

    public OEllipse2D(OEllipse2D rect) {
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
    public Color getColor() {
        return this.color;
    }

    @Override
    public void setColor(Color c) {
        if (c != null) {
            this.color = c;
        }
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
        if (fill) {
            g2d.fill(this);
        }
        g2d.draw(this);
    }

    @Override
    public void setLocation(Point2D p) {
        RectangularShape r = (RectangularShape) this;
        r.setFrame(p, new Dimension((int) r.getWidth(), (int) r.getHeight()));
    }

    @Override
    public void updateShape(Point2D p1, Point2D p2) {
        setFrameFromDiagonal(p1, p2);
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

}
