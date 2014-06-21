/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicaFinal.shapes;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

/**
 *
 * @author oskyar
 */
public class OLine2D extends Line2D.Double implements IOShape {

    private Color color;
    private boolean fill;
    private Stroke stroke;

    public OLine2D(Point2D p1, double width, double height) {
        super(p1.getX(), p1.getY(), width, height);
    }

    public OLine2D(Point2D p1, Point2D p2) {
        super(p1.getX(), p1.getY(), p2.getX(), p2.getY());
    }

    public OLine2D(Line2D line) {
        super(line.getP1(), line.getP2());
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
    }

}
