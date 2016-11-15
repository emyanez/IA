/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Emilio
 */
import java.util.TimerTask;

public class Auto extends TimerTask implements Constantes {

    public Calles calle;
    public Celda automovil;

    public Auto(Calles calle) {
        this.calle = calle;
        automovil = new Celda(27, altoMapa - 1, 0, 0, 'T');
        calle.celdas[automovil.x][automovil.y].tipo = 'T';
    }

    public void moverAutoIzq() {
        if (automovil.x > 0) {
            if (calle.celdas[automovil.x - 1][automovil.y].tipo == 'C'
                    || calle.celdas[automovil.x - 1][automovil.y].tipo == 'Z') {
                if ((automovil.x % 2 == 0) && (automovil.x % 6 != 0)) {
                    calle.celdas[automovil.x][automovil.y].tipo = 'Z';
                } else {
                    calle.celdas[automovil.x][automovil.y].tipo = 'C';
                }
                automovil.x = automovil.x - 1;
                automovil.i = automovil.x;
                automovil.j = automovil.y;
                calle.celdas[automovil.x][automovil.y].tipo = 'T';
            }
        } else {
            if ((automovil.x % 2 == 0) && (automovil.x % 6 != 0)) {
                calle.celdas[automovil.x][automovil.y].tipo = 'Z';
            } else {
                calle.celdas[automovil.x][automovil.y].tipo = 'C';
            }
            automovil.x = anchoMapa - 1;
            automovil.i = automovil.x;
            automovil.j = automovil.y;
            calle.celdas[automovil.x][automovil.y].tipo = 'T';
        }
    }

    public void moverAutoDer() {
        if (automovil.x < anchoMapa - 1) {
            if (calle.celdas[automovil.x + 1][automovil.y].tipo == 'C'
                    || calle.celdas[automovil.x + 1][automovil.y].tipo == 'Z') {
                if ((automovil.x % 2 == 0) && (automovil.x % 6 != 0)) {
                    calle.celdas[automovil.x][automovil.y].tipo = 'Z';
                } else {
                    calle.celdas[automovil.x][automovil.y].tipo = 'C';
                }
                automovil.x = anchoMapa - 1;
                automovil.i = automovil.x;
                automovil.j = automovil.y;
                calle.celdas[automovil.x][automovil.y].tipo = 'T';
            }
        } else {
            if ((automovil.x % 2 == 0) && (automovil.x % 6 != 0)) {
                calle.celdas[automovil.x][automovil.y].tipo = 'Z';
            } else {
                calle.celdas[automovil.x][automovil.y].tipo = 'C';
            }
            automovil.x = 0;
            automovil.i = automovil.x;
            automovil.j = automovil.y;
            calle.celdas[automovil.x][automovil.y].tipo = 'T';
        }
    }

    public void moverAutoUp() {
        if (automovil.y > 0) {
            if (calle.celdas[automovil.x][automovil.y - 1].tipo == 'C'
                    || calle.celdas[automovil.x][automovil.y - 1].tipo == 'Z') {
                if ((automovil.y % 2 == 0) && (automovil.y % 6 != 0)) {
                    calle.celdas[automovil.x][automovil.y].tipo = 'Z';
                } else {
                    calle.celdas[automovil.x][automovil.y].tipo = 'C';
                }
                automovil.y = automovil.y - 1;
                calle.celdas[automovil.x][automovil.y].tipo = 'T';
            }
        } else {
            if ((automovil.y % 3 == 0) && (automovil.y % 6 != 0)) {
                calle.celdas[automovil.x][automovil.y].tipo = 'Z';
            } else {
                calle.celdas[automovil.x][automovil.y].tipo = 'C';
            }
            automovil.y = altoMapa - 1;
            automovil.i = automovil.x;
            automovil.j = automovil.y;
            calle.celdas[automovil.x][automovil.y].tipo = 'T';
        }
    }

//Movimiento de Auto abajo
    public void moverAutoDwn() {
        if (automovil.y != altoMapa - 1) {
            if (calle.celdas[automovil.x][automovil.y + 1].tipo == 'C'
                    || calle.celdas[automovil.x][automovil.y + 1].tipo == 'Z') {
                if ((automovil.y % 2 == 0) && (automovil.y % 6 != 0)) {
                    calle.celdas[automovil.x][automovil.y].tipo = 'Z';
                } else {
                    calle.celdas[automovil.x][automovil.y].tipo = 'C';
                }
                automovil.y = automovil.y + 1;
                calle.celdas[automovil.x][automovil.y].tipo = 'T';
            }
        } else {
            if ((automovil.y % 3 != 0) && (automovil.y % 6 == 0)) {
                calle.celdas[automovil.x][automovil.y].tipo = 'Z';
            } else {
                calle.celdas[automovil.x][automovil.y].tipo = 'C';
            }
            calle.celdas[automovil.x][automovil.y].tipo = 'C';
            automovil.x = randomAuto();
            automovil.y = 0;
            automovil.i = automovil.x;
            automovil.j = automovil.y;
            calle.celdas[automovil.x][automovil.y].tipo = 'T';
        }
    }

    @Override
    public void run() {
        int direccion;
//    if(){
        direccion = numeroAleatorio(1, 4);
//    }
//    else{
//    direccion=numeroAleatorio(3,4);
//    }
        switch (direccion) {
            case 1:
                moverAutoIzq();
                break;
//            case 2:  moverAutoDer(); break;
            case 3:
                moverAutoUp();
                break;
//            case 4:  moverAutoDwn(); break;
        }
        calle.lienzoPadre.repaint();
    }
}