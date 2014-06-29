/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicaFinal.shapes;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.awt.geom.Point2D;
import java.util.ArrayList;

/**
 *
 * @author oskyar
 */
public interface IOShape {

    public String getName();
    
    public double getX();
    
    public double getY();
    
    public ArrayList<Point2D> getArrayPoints();

    public void setPoint(ArrayList<Point2D> vPoints);

    public Point2D getOnePoint(int index);

    public void setOnePoint(int index, Point2D p);
    
    public int getCtrlPoints();

    public int getStrokeType();
    
    public void setStrokeType(int strokeType);
    
    public int getStrokeJoinStyle();
    
    public void setStrokeJoinStyle(int strokeJoin);
    
    public int getStrokeCapStyle();
    
    public void setStrokeCapStyle(int strokeCap);
    
    public Stroke getStroke();
    
    public void setStrokeWidth(float width);
    
    public float getStrokeWidth();

    public void setStroke(Stroke sk);
    
    public Color getStrokeColor();
    
    public void setStrokeColor(Color color);
    
    public Color getFillColor();
    
    public void setFillColor(Color color);
    
    public int getFillType();

    public void setFillType(int fill);

    public Color getGradientColor();

    public void setGradientColor(Color gradientColor);
    
    public GradientPaint getGradient();

    public void setGradient(GradientPaint gradientColor);

    public void draw(Graphics2D g2d);
    
    public void drawFrame(Graphics2D g2d);

    public boolean contains(Point2D p);

    public void setLocation(Point2D p);

    public void updateShape(Point2D p1, Point2D p2);
    
    public IOShape clone();
    
    public void createGradient(Point2D p1, Point2D p2);

    public void updateGradient(Point2D p1, Point2D p2);

}
