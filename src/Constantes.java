/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Emilio
 */
import java.util.Random;

public interface Constantes {

    //Constantes de Mapa 
    public final int SizeCelda = 32;
    public final int anchoMapa = 32;
    public final int altoMapa = 21;

    //Constantes de Agentes
    public final char CARTERO = 'J';
    public final char CAMINO = 'C';
    public final char PEATONES = 'P';
    public final char CASA = 'M';
    public final char PORTAL = 'X';
    public final char OBSTACULO = 'O';
    public final char PASO = 'Z';
    public final char AUTO = 'T';
    public final char VEREDA = 'V';

    public final int cartero_x = 28;//posicion cartero eje x
    public final int cartero_y = 0;//posicion cartero eje y
    public final int portal_x = 0;//posicion portal eje x
    public final int portal_y = 20;//posicion portal eje y
    

    /*cartero horizontal*/
    default int numeroAleatorio(int minimo, int maximo) {
        Random random = new Random();
        int numero_aleatorio = random.nextInt((maximo - minimo) + 1) + minimo;
        return numero_aleatorio;
    }

    default int randomPeaton() {
        boolean flag = false;
        int y = 0;
        while (flag == false) {
            y = numeroAleatorio(0, altoMapa - 1);
            if ((y % 2 == 0) && (y % 6 != 0)) {
                flag = true;
            }
        }
        return y;
    }

    default int randomAuto() {
        boolean flag = false;
        int y = 0;
        while (flag == false) {
            y = numeroAleatorio(0, anchoMapa - 1);
            if ((y % 3 == 0) && (y % 6 != 0)) {
                flag = true;
            }
        }
        return y;
    }
}
