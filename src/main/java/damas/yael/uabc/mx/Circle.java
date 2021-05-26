package damas.yael.uabc.mx;
import java.awt.geom.*;
/**
 * A circle that can be manipulated and that draws itself on a canvas.
 *
 * @author  Michael Kölling and David J. Barnes
 * @version 2016.02.29
 */
public class Circle {
    protected int diameter; //diametro del circulo
    protected int xPosition; //posicion en el eje x
    protected int yPosition; //posicion en el eje y
    protected String color; //color de la figura
    protected boolean isVisible; //no indica si la figura es visible
    protected Canvas canvas;// nuestro canvas de dibujo

    /**Este constructor es utilizado para dibujar las fichas en tablero */
    public Circle(Canvas canvas, String color, int xPosition, int yPosition) {
        diameter = 60;
        this.canvas = canvas;
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.color = color;
        isVisible = false;
    }

    public String getColor() {
        return color;
    }

    public boolean isVisible()
    {
        return isVisible;
    }

    /*Make this circle visible. If it was already visible, do nothing.*/
    public void makeVisible() {
        isVisible = true;
        draw();
    }

    /*Make this circle invisible. If it was already invisible, do nothing.*/
    public void makeInvisible(){
        erase();
        isVisible = false;
    }

    /*Move the circle horizontally by 'distance' pixels.*/
    public void moveHorizontal(int distance) {
        erase();
        xPosition += distance;
        draw();
    }

    /*Move the circle vertically by 'distance' pixels.*/
    public void moveVertical(int distance) {
        erase();
        yPosition += distance;
        draw();
    }

    /*Draw the circle with current specifications on screen.*/
    public void draw() {
        if(isVisible) {
            canvas.draw(this, color, new Ellipse2D.Double(xPosition, yPosition,
                    diameter, diameter));
            canvas.wait(10);
        }
    }

    /*Erase the circle on screen.*/
    public void erase() {
        if(isVisible) {
            canvas.erase(this);
        }
    }
}