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

/**
 *
 * @author oskyar
 */
public interface IOShape {

    public abstract double getBoundsX();

    public abstract void setX(Double x);

    public abstract double getBoundsY();

    public abstract void setY(Double y);

    public abstract Point2D getPoint();

    public abstract void setPoint(Point2D p);

    public abstract Stroke getStroke();

    public abstract void setStroke(Stroke sk);

    public abstract Color getColor();

    public abstract void setColor(Color c);

    public abstract boolean getFill();

    public abstract void setFill(boolean fill);

    public abstract void draw(Graphics2D g2d);

    public abstract boolean contains(Point2D p);

    public abstract void setLocation(Point2D p);

    public abstract void updateShape(Point2D p1, Point2D p2);

    //public abstract double getX();
}
