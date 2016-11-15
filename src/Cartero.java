/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Emilio
 */
import java.awt.event.KeyEvent;
import java.util.TimerTask;
import javax.swing.JOptionPane;

public class Cartero extends TimerTask implements Constantes {

    public Calles calle;
    public Celda cartero;

    public Cartero(Calles calle) {
        this.calle = calle;
        cartero = new Celda(cartero_x, cartero_y, cartero_x, cartero_y, 'J');
        calle.celdas[cartero.x][cartero.y].tipo = 'J';
    }

    public void moverCartero(KeyEvent evento) {

        switch (evento.getKeyCode()) {
            case 38:
                moverCarteroArriba();
                break;
            case 40:
                moverCarteroAbajo();
                break;
            case 37:
                moverCarteroIzquierda();
                break;
            case 39:
                moverCarteroDerecha();
                break;
        }
    }

    private void moverCarteroArriba() {
        if (cartero.y > 0) {
            char op = calle.celdas[cartero.x][cartero.y - 1].tipo;
            switch (op) {

                case ('A'): {
                    if ((cartero.y % 3 == 0) && (cartero.y % 6 != 0)) {
                        calle.celdas[cartero.x][cartero.y].tipo = 'Z';
                    } else {
                        calle.celdas[cartero.x][cartero.y].tipo = 'A';
                    }

                    cartero.y = cartero.y - 1;
                    calle.celdas[cartero.x][cartero.y].tipo = 'J';
                    System.out.println("Mover Arriba: " + cartero.y + " - " + cartero.x);
                    break;

                }
                case ('Z'): {
                    if (vieneAuto(calle, cartero) == false) {
                        calle.celdas[cartero.x][cartero.y].tipo = 'A';
                        cartero.y = cartero.y - 1;
                        calle.celdas[cartero.x][cartero.y].tipo = 'J';
                        System.out.println("Mover Arriba: " + cartero.y + " - " + cartero.x);
                        break;
                    } else {
                        break;
                    }
                }
                case ('X'): {
                    calle.celdas[cartero.x][cartero.y].tipo = 'A';
                    cartero.y = cartero.y - 1;
                    calle.celdas[cartero.x][cartero.y].tipo = 'J';
                    System.out.println("Mover Arriba: " + cartero.y + " - " + cartero.x + " Carteron en Portal ");

                    JOptionPane.showMessageDialog(null, "El cartero llego al portal ");

                    break;
                }
                case ('M'): {
                    System.out.println("Choque! No se puede mover mas hacia Arriba");
                    break;
                }
                case ('P'): {
                    System.out.println("Choque! No se puede mover mas hacia Arriba");
                    break;
                }
                case ('T'): {
                    break;
                }
            }
        }
    }

    private void moverCarteroAbajo() {
        if (cartero.y < altoMapa - 1) {
            char op = calle.celdas[cartero.x][cartero.y + 1].tipo;
            switch (op) {

                case ('C'): {

                    break;
                }
                case ('X'): {
                    calle.celdas[cartero.x][cartero.y].tipo = 'A';
                    cartero.y = cartero.y + 1;
                    calle.celdas[cartero.x][cartero.y].tipo = 'J';
                    System.out.println("Mover Abajo: " + cartero.y + " - " + cartero.x + " Carteron en Portal  ");

                    JOptionPane.showMessageDialog(null, "El cartero llego al portal ");
                    break;
                }
                case ('P'): {
                    System.out.println("Choque! No se puede mover mas hacia Abajo!");
                    break;
                }
                case ('M'): {
                    System.out.println("Choque! No se puede mover mas hacia Abajo!");
                    break;
                }
                case ('A'): {
                    if ((cartero.y % 3 == 0) && (cartero.y % 6 != 0)) {
                        calle.celdas[cartero.x][cartero.y].tipo = 'Z';
                    } else {
                        calle.celdas[cartero.x][cartero.y].tipo = 'A';
                    }
                    cartero.y = cartero.y + 1;
                    calle.celdas[cartero.x][cartero.y].tipo = 'J';
                    System.out.println("Mover Arriba: " + cartero.y + " - " + cartero.x);
                    break;

                }
                case ('Z'): {
                    if (vieneAuto(calle, cartero) == false) {
                        calle.celdas[cartero.x][cartero.y].tipo = 'A';
                        cartero.y = cartero.y + 1;
                        calle.celdas[cartero.x][cartero.y].tipo = 'J';
                        System.out.println("Mover Arriba: " + cartero.y + " - " + cartero.x);
                        break;
                    } else {
                        break;
                    }
                }
                case ('T'): {
                    break;
                }
            }
        }
    }

    private void moverCarteroIzquierda() {
        if (cartero.x > 0) {
            char op = calle.celdas[cartero.x - 1][cartero.y].tipo;
            switch (op) {
                case ('X'): {
                    calle.celdas[cartero.x][cartero.y].tipo = 'A';
                    cartero.x = cartero.x - 1;
                    calle.celdas[cartero.x][cartero.y].tipo = 'J';
                    System.out.println("Mover Izquierda: " + cartero.y + " - " + cartero.x + "El cartero llego al portal ");

                    JOptionPane.showMessageDialog(null, "El cartero llego al portal ");
                    break;
                }
                case ('M'): {
                    System.out.println("Choque! No se puede mover mas a la Izquierda!");
                    break;
                }
                case 'P': {
                    System.out.println("Choque! No se puede mover mas a la Izquierda!");
                    break;
                }
                case ('A'): {
                    if ((cartero.x % 3 == 0) && (cartero.x % 6 != 0)) {
                        calle.celdas[cartero.x][cartero.y].tipo = 'Z';
                    } else {
                        calle.celdas[cartero.x][cartero.y].tipo = 'A';
                    }

                    cartero.x = cartero.x - 1;
                    calle.celdas[cartero.x][cartero.y].tipo = 'J';
                    System.out.println("Mover Izquierda: " + cartero.y + " - " + cartero.x);
                    break;

                }
                case ('Z'): {
                    if (vieneAuto(calle, cartero) == false) {
                        calle.celdas[cartero.x][cartero.y].tipo = 'A';
                        cartero.x = cartero.x - 1;
                        calle.celdas[cartero.x][cartero.y].tipo = 'J';
                        System.out.println("Mover Izquierda: " + cartero.y + " - " + cartero.x);
                        break;
                    } else {
                        break;
                    }
                }
                case ('T'): {
                    break;
                }

            }
        }
    }

    private void moverCarteroDerecha() {
        if ((cartero.x < anchoMapa - 1)) {
            char op = calle.celdas[cartero.x + 1][cartero.y].tipo;
            switch (op) {
                case ('X'): {
                    calle.celdas[cartero.x][cartero.y].tipo = 'A';
                    cartero.x = cartero.x + 1;
                    calle.celdas[cartero.x][cartero.y].tipo = 'J';
                    System.out.println("Mover Derecha: " + cartero.y + " - " + cartero.x + " Carteron en Portal ");
                    JOptionPane.showMessageDialog(null, "El cartero llego al portal ");
                    break;
                }
                case ('M'): {
                    System.out.println("Choque! No se puede mover mas a la Derecha!");
                    break;
                }
                case ('P'): {
                    System.out.println("Choque! No se puede mover mas a la Derecha!");
                    break;
                }
                case ('A'): {
                    if ((cartero.x % 3 == 0) && (cartero.x % 6 != 0)) {
                        calle.celdas[cartero.x][cartero.y].tipo = 'Z';
                    } else {
                        calle.celdas[cartero.x][cartero.y].tipo = 'A';
                    }
                    cartero.x = cartero.x + 1;
                    calle.celdas[cartero.x][cartero.y].tipo = 'J';
                    System.out.println("Mover Derecha: " + cartero.y + " - " + cartero.x);
                    break;
                }
                case ('Z'): {
                    if (vieneAuto(calle, cartero) == false) {
                        calle.celdas[cartero.x][cartero.y].tipo = 'A';
                        cartero.x = cartero.x + 1;
                        calle.celdas[cartero.x][cartero.y].tipo = 'J';
                        System.out.println("Mover Derecha: " + cartero.y + " - " + cartero.x);
                        break;
                    } else {
                        break;
                    }
                }
                case ('T'): {
                    break;
                }
            }
        }
    }

    private boolean vieneAuto(Calles calle , Celda cartero){
    boolean flag=false;
    for(int i=-2; i<2; i++){
        for (int j=-2; j<2;j++){
                if(((cartero.x+i>0)&&(cartero.y+j>0))&&((cartero.x+i<anchoMapa-1)&&(cartero.y+j<altoMapa-1))){
                    if((calle.celdas[cartero.x+i][cartero.y+j].tipo== 'T')){
                        flag=true;
                        break;
                    }
                }
        }
    }    
    return flag;
}

    @Override
    public void run() {
        calle.lienzoPadre.repaint();

    }

}
