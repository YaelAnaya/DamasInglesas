package damas.yael.uabc.mx;
import java.awt.*;
/**
 * A square that can be manipulated and that draws itself on a canvas.
 *
 * @author  Michael Kölling and David J. Barnes
 * @version 2016.02.29
 */
public class Square {
    protected int size; //tamaño del cuadrado
    protected int xPosition; //posicion en el eje x
    protected int yPosition; //posicion en el eje y
    protected String color; //color de la figura
    protected boolean isVisible; //no indica si la figura es visible
    protected Canvas canvas;// nuestro canvas de dibujo

    /*Este constructor se utiliza para dibujar nuestras casilla en el tablero*/
    public Square(Canvas canvas, String color,  int xPosition, int yPosition) {
        size = 60;
        this.canvas = canvas;
        this.color = color;
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        isVisible = false;
    }
    /*Este constructor fue utilizado para dibujar la baje de nuestro tablero*/
    public Square(Canvas canvas) {
        size = 500;
        color = "ch3";
        xPosition = 150;
        yPosition = 150;
        this.canvas = canvas;
        isVisible = false;
    }

    /**
     * Make this square visible. If it was already visible, do nothing.
     */
    public void makeVisible()
    {
        isVisible = true;
        draw();
    }

    /**
     * Draw the square with current specifications on screen.
     */
    private void draw()
    {
        if(isVisible) {
            canvas.draw(this, color,
                    new Rectangle(xPosition, yPosition, size, size));
            canvas.wait(10);
        }
    }
}
