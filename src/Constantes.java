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
    public final int portal_x2 = 0;//posicion portal eje x
    public final int portal_y2 = 2;//posicion portal eje y
    public final int portal_x3 = 8;//posicion portal eje x
    public final int portal_y3 = 0;//posicion portal eje y
    public final int portal_x4 = 10;//posicion portal eje x
    public final int portal_y4 = 0;//posicion portal eje y
    public final int portal_x5 = 16;//posicion portal eje x
    public final int portal_y5 = 0;//posicion portal eje y
    public final int portal_x6 = 22;//posicion portal eje x
    public final int portal_y6 = 0;//posicion portal eje y
    public final int portal_x7 = 30;//posicion portal eje x
    public final int portal_y7 = 2;//posicion portal eje y
    public final int portal_x8 =0;
    public final int portal_y8 =4;
    public final int portal_x9 =10;
    public final int portal_y9 =4;
    public final int portal_x10 =22;
    public final int portal_y10 =4;
    public final int portal_x11 =16;
    public final int portal_y11 =4;
    public final int portal_x12 =30;
    public final int portal_y12 =4;
     public final int portal_x13 =8;
    public final int portal_y13 =4;
    public final int portal_x14 =0;
    public final int portal_y14 =10;
    public final int portal_x15 =12;
    public final int portal_y15 =10;
    public final int portal_x16 =16;
    public final int portal_y16 =10;
    public final int portal_x17 =22;
    public final int portal_y17 =10;
    public final int portal_x18 =30;
    public final int portal_y18 =10;
    public final int portal_x19 =8;
    public final int portal_y19 =10;
    public final int portal_x20 =4;
    public final int portal_y20 =20;
    public final int portal_x21 =8;
    public final int portal_y21 =20;
    public final int portal_x22 =10;
    public final int portal_y22 =20;
    public final int portal_x23 =16;
    public final int portal_y23 =20;
    public final int portal_x24 =22;
    public final int portal_y24 =20;
     public final int portal_x25 =30;
    public final int portal_y25 =20;
   //Variable certamen
   //Variable certamen
    public final int cantidad_c =1;
    
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
