/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicaFinal;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

/**
 *
 * @author oskyar
 */
public class OPoint2D extends Line2D.Double implements IOShape {

    private Color color;
    private boolean fill;
    private Stroke stroke;

    public OPoint2D(Point2D p1, double width, double height) {
        super(p1.getX(), p1.getY(), p1.getX(), p1.getY());
    }

    public OPoint2D(Point2D p1, Point2D p2) {
        super(p1.getX(), p1.getY(), p1.getX(), p1.getY());
    }

    @Override
    public double getBoundsX() {
        return super.getX1();
    }

    @Override
    public void setX(java.lang.Double x) {

    }

    @Override
    public double getBoundsY() {
        return super.getY1();
    }

    @Override
    public void setY(java.lang.Double y) {

    }

    @Override
    public Point2D getPoint() {
        return super.getP1();
    }

    @Override
    public void setPoint(Point2D p) {
        super.setLine(p, p);
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
    public boolean contains(Point2D p) {
        return getP1().distance(p) <= 3.0;
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

}
