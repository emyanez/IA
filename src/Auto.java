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
    public Celda auto;

    public Auto(Calles calle) {
        this.calle = calle;
        auto = new Celda(27, altoMapa - 1, 0, 0, 'T');
        calle.celdas[auto.x][auto.y].tipo = 'T';
    }

    //Movimiento de Auto a la izquierda
    public void moverAutoIzq() {
        if (auto.x > 0) {
            if (calle.celdas[auto.x - 1][auto.y].tipo == 'C'
                    || calle.celdas[auto.x - 1][auto.y].tipo == 'Z') {
                if ((auto.x % 2 == 0) && (auto.x % 6 != 0)) {
                    calle.celdas[auto.x][auto.y].tipo = 'Z';
                } else {
                    calle.celdas[auto.x][auto.y].tipo = 'C';
                }
                auto.x = auto.x - 1;
                auto.i = auto.x;
                auto.j = auto.y;
                calle.celdas[auto.x][auto.y].tipo = 'T';
            }
        } else {
            if ((auto.x % 2 == 0) && (auto.x % 6 != 0)) {
                calle.celdas[auto.x][auto.y].tipo = 'Z';
            } else {
                calle.celdas[auto.x][auto.y].tipo = 'C';
            }
            auto.x = anchoMapa - 1;
            auto.i = auto.x;
            auto.j = auto.y;
            calle.celdas[auto.x][auto.y].tipo = 'T';
        }
    }

    //Movimiento de auto Derecha
    public void moverAutoDer() {
        if (auto.x < anchoMapa - 1) {
            if (calle.celdas[auto.x + 1][auto.y].tipo == 'C'
                    || calle.celdas[auto.x + 1][auto.y].tipo == 'Z') {
                if ((auto.x % 2 == 0) && (auto.x % 6 != 0)) {
                    calle.celdas[auto.x][auto.y].tipo = 'Z';
                } else {
                    calle.celdas[auto.x][auto.y].tipo = 'C';
                }
                auto.x = anchoMapa - 1;
                auto.i = auto.x;
                auto.j = auto.y;
                calle.celdas[auto.x][auto.y].tipo = 'T';
            }
        } else {
            if ((auto.x % 2 == 0) && (auto.x % 6 != 0)) {
                calle.celdas[auto.x][auto.y].tipo = 'Z';
            } else {
                calle.celdas[auto.x][auto.y].tipo = 'C';
            }
            auto.x = 0;
            auto.i = auto.x;
            auto.j = auto.y;
            calle.celdas[auto.x][auto.y].tipo = 'T';
        }
    }

    //Movimiento de auto arriba
    public void moverAutoArriba() {
        if (auto.y > 0) {
            if (calle.celdas[auto.x][auto.y - 1].tipo == 'C'
                    || calle.celdas[auto.x][auto.y - 1].tipo == 'Z') {
                if ((auto.y % 2 == 0) && (auto.y % 6 != 0)) {
                    calle.celdas[auto.x][auto.y].tipo = 'Z';
                } else {
                    calle.celdas[auto.x][auto.y].tipo = 'C';
                }
                auto.y = auto.y - 1;
                calle.celdas[auto.x][auto.y].tipo = 'T';
            }
        } else {
            if ((auto.y % 3 == 0) && (auto.y % 6 != 0)) {
                calle.celdas[auto.x][auto.y].tipo = 'Z';
            } else {
                calle.celdas[auto.x][auto.y].tipo = 'C';
            }
            auto.y = altoMapa - 1;
            auto.i = auto.x;
            auto.j = auto.y;
            calle.celdas[auto.x][auto.y].tipo = 'T';
        }
    }

//Movimiento de Auto abajo
    public void moverAutoAbajo() {
        if (auto.y != altoMapa - 1) {
            if (calle.celdas[auto.x][auto.y + 1].tipo == 'C'
                    || calle.celdas[auto.x][auto.y + 1].tipo == 'Z') {
                if ((auto.y % 2 == 0) && (auto.y % 6 != 0)) {
                    calle.celdas[auto.x][auto.y].tipo = 'Z';
                } else {
                    calle.celdas[auto.x][auto.y].tipo = 'C';
                }
                auto.y = auto.y + 1;
                calle.celdas[auto.x][auto.y].tipo = 'T';
            }
        } else {
            if ((auto.y % 3 != 0) && (auto.y % 6 == 0)) {
                calle.celdas[auto.x][auto.y].tipo = 'Z';
            } else {
                calle.celdas[auto.x][auto.y].tipo = 'C';
            }
            calle.celdas[auto.x][auto.y].tipo = 'C';
            auto.x = randomAuto();
            auto.y = 0;
            auto.i = auto.x;
            auto.j = auto.y;
            calle.celdas[auto.x][auto.y].tipo = 'T';
        }
    }

    @Override
    public void run() {
        int direccion;
        direccion = numeroAleatorio(1, 4);
        switch (direccion) {
            case 1:
                moverAutoIzq();
                break;

            case 2:
                moverAutoArriba();
                break;
        }
        calle.lienzoPadre.repaint();
    }
}
