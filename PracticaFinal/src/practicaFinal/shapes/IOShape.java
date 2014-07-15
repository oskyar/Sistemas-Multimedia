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
import practicaFinal.PracticaFinal;

/**
 * Interfaz que sirve para complementar a las clases de tipo Shape, contiene los
 * métodos necesarios poder modificar los atributos propios de cada forma
 * obligando a que todas las clases tengan los mismos métodos. Atributos que
 * obliga a crearse en las clases personalizadas (Breve explicación de los
 * atributos que hay y algunos métodos).
 * <ul>
 * <li>Nombre de la clase</li>
 * <li>Punto1</li>
 * <li>Array de puntos auxiliares</li>
 * <li>Control de puntos auxiliares</li>
 * <li>Tipo de Trazo</li>
 * <li>Tipo de Union del trazo</li>
 * <li>Tipo de Final del trazo</li>
 * <li>Grosor del trazo</li>
 * <li>Color del trazo</li>
 * <li>Color del relleno</li>
 * <li>Tipo de relleno</li>
 * <li>Gradiente</li>
 * <li>Colores del Gradiente</li>
 * <li>Método de dibujado de la figura(draw)</li>
 * <li>Marco de selección de la figura(drawFrame)</li>
 * <li>Método "Contenido" (Si el punto está contenido en la figura)</li>
 * <li>Método para mover la figura (setLocation) </li>
 * <li>Método para modificar la figura (updateShape) </li>
 * <li>Método para clonar la figura </li>
 * </ul>
 *
 * @see Color
 * @see Stroke
 * @see GradientPaint
 * @author oskyar
 */
public interface IOShape {

    /**
     * Devuelve el nombre de la figura.
     *
     * @return String nombre de la figura
     */
    public String getName();

    /**
     * Devuelve la coordenada X del primer punto de la figura
     *
     * @return Devueluve coordenada X del punto1
     */
    public double getX();

    /**
     * Devuelve la coordenada Y del primer punto de la figura
     *
     * @return Devuelve coordenada Y del punto2
     */
    public double getY();

    /**
     * ArrayList de puntos auxiliares, no lo implementan toda las clases debido
     * a que no es estrictamente necesario, se usa en las clases con puntos de
     * control.
     *
     * @return Devuelve un Array de puntos.
     */
    public ArrayList<Point2D> getArrayPoints();

    /**
     * En este método se modifica el Array de <code>Point2D.Double</code> pasado
     * por parámetro.
     *
     * @param vPoints Modifica el vector de Puntos auxiliares
     */
    public void setPoint(ArrayList<Point2D> vPoints);

    /**
     * Método que devuelve una posición del array pasado por parámetro.
     *
     * @param index índice para buscar en el ArrayList
     * @return Devuelve un <code>Point2D.Double</code>
     */
    public Point2D getOnePoint(int index);

    /**
     * Método en el que se modifica una posición del ArrayList.
     * {@link Point2D.Double}
     *
     * @param index Indica qué posición del Array se va a modificar
     * @param p Punto que se va a añadir en la posición indicada.
     */
    public void setOnePoint(int index, Point2D p);

    /**
     * Devuelve el número de puntos de control que tiene la figura.
     * {@link Point2D.Double}
     *
     * @return Devuelve un entero con el número de puntos de control de la
     * figura.
     */
    public int getCtrlPoints();

    /**
     * Devuelve el tipo de trazo que tiene la figura. ver {@link Stroke}
     *
     * @return Devuelve un entero con el tipo de Stroke. ver constantes
     * {@link practicaFinal.Lienzo} para ver las variables definidas.
     */
    public int getStrokeType();

    /**
     * Modifica el tipo del trazo. ver {@link Stroke}
     *
     * @param strokeType Entero con el tipo trazo. ver constantes
     * {@link practicaFinal.Lienzo}
     */
    public void setStrokeType(int strokeType);

    /**
     * Devuelve el tipo de unión del trazo que tiene la figura. ver constantes
     * {@link practicaFinal.Lienzo}
     *
     * @return Devuelve un entero con el tipo de Stroke.
     */
    public int getStrokeJoinStyle();

    /**
     * Modifica el tipo de unión del trazo. ver constantes
     * {@link practicaFinal.Lienzo}
     *
     * @param strokeJoin Entero con el tipo trazo.
     */
    public void setStrokeJoinStyle(int strokeJoin);

    /**
     * Devuelve el tipo de final de línea del trazo que tiene la figura. ver
     * constantes {@link practicaFinal.Lienzo}
     *
     * @return Devuelve un entero con el tipo de final de línea del trazo.
     */
    public int getStrokeCapStyle();

    /**
     * Modifica el tipo de final del trazo. ver constantes
     * {@link practicaFinal.Lienzo}
     *
     * @param strokeCap Entero con el tipo trazo.
     */
    public void setStrokeCapStyle(int strokeCap);

    /**
     * Devuelve el tipo de stroke que tiene la figura
     *
     * @return devuelve una instancia de {@link Stroke} que tiene la figura.
     */
    public Stroke getStroke();

    /**
     * Modifica el ancho del trazo de la figura
     *
     * @param width Número entero que indica el ancho del trazo.
     */
    public void setStrokeWidth(float width);

    /**
     * Devuelve el ancho del trazo de nuestra figura.
     *
     * @return Devuelve un número de tipo float que es el ancho del trazo.
     */
    public float getStrokeWidth();

    /**
     * Modifica el {@link Stroke} de la figura.
     *
     * @param sk Variable de tipo <code>Stroke</code>.
     */
    public void setStroke(Stroke sk);

    /**
     * Devuelve el color del trazo de la figura
     *
     * @return devuelve un <code>Color</code>.
     */
    public Color getStrokeColor();

    /**
     * Modifica el color del trazo de la figura
     *
     * @param color Color que tendrá el trazo.
     */
    public void setStrokeColor(Color color);

    /**
     * Devuelve el color de relleno de la figura.
     *
     * @return Devuelve un <code>Color</code>.
     */
    public Color getFillColor();

    /**
     * Modifica el color del relleno de la figura.
     *
     * @param color Color con el que se va a modificar el relleno de la figura.
     */
    public void setFillColor(Color color);

    /**
     * Devuelve el tipo de relleno de la figura (Ninguno, Liso ó Gradiente).
     * {@link practicaFinal.Lienzo}
     *
     * @return Devuelve un entero con el tipo de relleno.
     */
    public int getFillType();

    /**
     * Modifica el tipo de relleno de la figura
     *
     * @param fill Tipo de relleno, constantes en {@link practicaFinal.Lienzo}
     */
    public void setFillType(int fill);

    /**
     * Devuelve el Color del gradiente, (el segundo color), el primero viene a
     * ser el color de relleno.
     *
     * @return Devuelve un Color, el color del gradiente.
     */
    public Color getGradientColor();

    /**
     * Modifica el color del gradiente de la figura (2º color de la figura).
     *
     * @param gradientColor variable de tipo <code>Color</code>
     */
    public void setGradientColor(Color gradientColor);

    /**
     * Devuelve el gradiente de la figura si existe.
     *
     * @return devuelve un <code>GradientPaint</code>
     */
    public GradientPaint getGradient();

    /**
     * Modifica el gradiente de la figura.
     *
     * @param gradientColor Gradiente con el que se va a modificar la figura.
     */
    public void setGradient(GradientPaint gradientColor);

    /**
     * Método para pintar la figura.
     *
     * @param g2d <code>Graphics2D</code> necesario para poder dibujar la
     * figura.
     */
    public void draw(Graphics2D g2d);

    /**
     * Dibuja el marco de la figura pasándole la instancia de gráficos. ver
     * {@link Graphics2D}
     *
     * @param g2d Componente <code>Graphics2D</code> que pinta las figuras.
     */
    public void drawFrame(Graphics2D g2d);

    /**
     * Comprueba si el punto pasado por parámetro está contenido en la figura.
     *
     * @param p punto de Point2D para comprobar si está contenido.
     * @return Devuelve <code>true</code> si el punto está contenido y
     * <code>false</code> en caso contrario.
     */
    public boolean contains(Point2D p);

    /**
     * Mueve la figura teniendo en cuenta el punto pasado por parámetro.
     *
     * @param p Punto que se tiene en cuenta cuando mueves la figura.
     */
    public void setLocation(Point2D p);

    /**
     * Actualiza la figura pasándole dos puntos, el inicial y el final.
     *
     * @param p1 Punto inicial que se le pasa a la figura
     * @param p2 Punto final que se le pasa a la figura.
     */
    public void updateShape(Point2D p1, Point2D p2);

    /**
     * Clona la figura.
     *
     * @return Figura de tipo <code>IOShape</code> clonada.
     */
    public IOShape clone();

    /**
     * Crea el gradiente de la figura pasándole los dos puntos.
     *
     * @param p1 Punto inicial del gradiente
     * @param p2 Punto final del gradiente.
     */
    public void createGradient(Point2D p1, Point2D p2);

    /**
     * Actualiza el gradiente de la figura (ejemplo: cuando mueves una figura).
     *
     * @param p1 Punto inicial para actualizar el gradiente
     * @param p2 Punto final para actualizar el gradiente.
     */
    public void updateGradient(Point2D p1, Point2D p2);

}
