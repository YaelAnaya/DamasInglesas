package damas.yael.uabc.mx;
import java.util.Scanner;
/*En esta clase se lleva acabo el juego de 10 turnos predeterminados de
* damas inglesas (Chekers)*/
public class Checkers {
    //método main
    public static void main(String[] args) {

        //Creamos un objeto de scanner para introducir datos
        Scanner scanner = new Scanner(System.in);
        //Creamos los objetos de tableroControl y View
        TableroView tableroView = new TableroView();
        TableroControl tableroControl = new TableroControl();

        /*Creamos el tablero lógico y gráfico*/
        tableroControl.crearTablero();
        tableroView.dibujarTablero();

        String col; //String auxiliar de la columna, que despues convertiremos en char
        int filaOrigen; //fila de origen de la ficha a mover
        char columnaOrigen; //columna de origen de la ficha a mover
        int filaDestino; //fila destino de la ficha a mover
        char columnaDestino; //columna destino de la ficha a mover
        boolean jugadorRojo = true; //indica el turno del jugador (empiezan las rojas == blancas)

        //Contadores para las fichas restantes en tablero
        int fichasRojasRestantes;
        int fichasNegrasRestantes;

        //Iniciamos un juego de 10 turnos
        for(int turno = 0; turno < 10; turno++) {
            //Mostramos titulo del turno
            if(jugadorRojo) System.out.println("\t[Turno de las fichas Rojas]");
            else System.out.println("\t[Turno de las fichas Negras]");

            //Se lee la fila de la ficha a mover
            System.out.print("-> Ingrese fila de origen(1-8): ");
            filaOrigen = scanner.nextInt() - 1;

            //Se lee la columna de la ficha a mover
            System.out.print("-> Ingrese columna de origen(a-h): ");
            col = scanner.next().toLowerCase();
            columnaOrigen = col.toCharArray()[0];//Esta es la columna a mover

            //Se lee la fila de la casilla destino
            System.out.print("-> Ingrese la fila destino(1-8): ");
            filaDestino = scanner.nextInt() - 1;

            //Se lee la columna del destino
            System.out.print("-> Ingrese columna destino(a-h): ");
            col = scanner.next().toLowerCase();
            columnaDestino = col.toCharArray()[0];//Esta es la columna destino
            System.out.println();

            if(jugadorRojo){ //Si el turno es del jugador rojo (primer turno)
                //verificamos que puede mover la ficha
                if(tableroControl.moverFichasRojas(filaOrigen, columnaOrigen, filaDestino, columnaDestino))
                    jugadorRojo = false;//se cambia el turno al siguiente jugador
                else { //si no se puede mover es un movimiento ilegal
                    System.out.println("Movimiento ilegal, intentelo de nuevo\n");
                    turno--; //se retrocede un turno y no cambia de jugador
                }
            } else { //si jugadorRojo = false, es turno de las fichas negras (segundo turno)
                //verificamos que puede mover la ficha
                if(tableroControl.moverFichasNegras(filaOrigen, columnaOrigen, filaDestino, columnaDestino))
                    jugadorRojo = true; //se cambia el turno al siguiente jugador
                else {  //si no se puede mover es un movimiento ilegal
                    System.out.println("Movimiento ilegal, intentelo de nuevo\n");
                    turno--; //se retrocede un turno y no cambia de jugador
                }
            }

        }
        //utilizamos los ints para guardar la cantidad de ficha restantes en l tablero
        fichasNegrasRestantes = tableroControl.contarFichaRestantes("black");
        fichasRojasRestantes = tableroControl.contarFichaRestantes("red");

        //Verificamos, ganador o empate
            if(fichasNegrasRestantes > fichasRojasRestantes) // si hay más fichas negras
                System.out.println("[Las fichas negras ganan]");
            else if(fichasRojasRestantes > fichasNegrasRestantes) // si hay más fichas rojas
                System.out.println("[Las fichas rojas ganan]");
            else //si son iguales
                System.out.println("[Empate]");
    }
}
