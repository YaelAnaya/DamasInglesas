package damas.yael.uabc.mx;
//Esta clase modela una ficha, esta ficha
//hereda de la clase padre Circle
public class Ficha extends Circle{

    //Constructor que pasa los parametros de posicion, color y dibjo a
    //la clase padre
    public Ficha(Canvas canvas, String color, int xPosition, int yPosition) {
        super(canvas, color, xPosition, yPosition);
    }
    //Este metodo nos permite mover la ficha de posicion
    public void mover(int yPosition, int xPosition) {
        moveVertical(yPosition);
        moveHorizontal(xPosition);
    }

}
