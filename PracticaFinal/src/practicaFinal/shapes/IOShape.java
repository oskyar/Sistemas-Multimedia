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
import java.util.ArrayList;

/**
 *
 * @author oskyar
 */
public interface IOShape {

    public double getX();
    
    public double getY();
    
    public ArrayList<Point2D> getArrayPoints();

    public void setPoint(ArrayList<Point2D> vPoints);

    public Point2D getOnePoint(int index);

    public void setOnePoint(int index, Point2D p);
    
    public int getCtrlPoints();

    public Stroke getStroke();

    public void setStroke(Stroke sk);

    public Color getColor();

    public void setColor(Color c);

    public boolean getFill();

    public void setFill(boolean fill);

    public void draw(Graphics2D g2d);

    public boolean contains(Point2D p);

    public void setLocation(Point2D p);

    public void updateShape(Point2D p1, Point2D p2);

}
