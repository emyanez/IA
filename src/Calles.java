/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Emilio
 */
import java.awt.Graphics;
import javax.swing.JComponent;

public class Calles extends JComponent implements Constantes {

    public int anchoCalle, altoCalle;
    /*dimensiones del laberinto  */
    public Celda[][] celdas;
    /* define las casillas n x m */
    public Celda celdaMovimiento;
    /* declarada a celda a mover */
    public Celda celdaMovimiento2;
    public Lienzo lienzoPadre;

    public Calles(Lienzo lienzoPadre) {
        this.lienzoPadre = lienzoPadre;

        celdas = new Celda[anchoMapa][altoMapa];

        for (int i = 0; i < anchoMapa; i++) {
            for (int j = 0; j < altoMapa; j++) {
                celdas[i][j] = new Celda(i + (i * SizeCelda), j + (j * SizeCelda), i, j, 'M');
            }
        }

        for (int i = 0; i < anchoMapa; i++) {
            for (int j = 0; j < altoMapa; j++) {
                if (((j % 2 == 0) && (j % 6 != 0)) || ((i % 2 == 0) && (i % 6 != 0))) {
                    celdas[i][j].tipo = 'A';
                }
                if (((j % 3 == 0) && (j % 6 != 0)) || ((i % 3 == 0) && (i % 6 != 0))) {
                    celdas[i][j].tipo = 'C';
                }
                if (((i % 3 == 0) && (i % 6 != 0)) && ((j % 2 == 0) && (j % 6 != 0))) {
                    celdas[i][j].tipo = 'Z';
                }

                if (((j % 3 == 0) && (j % 6 != 0)) && ((i % 2 == 0) && (i % 6 != 0))) {
                    celdas[i][j].tipo = 'Z';
                }
            }
        }

        /* iniciacion de celdas especiales Jugador y Portal */
        celdas[cartero_x][cartero_y].tipo = 'J';
        celdas[portal_x][portal_y].tipo = 'X';
        celdas[portal_x2][portal_y2].tipo ='X';
        celdas[portal_x3][portal_y3].tipo ='X';
        celdas[portal_x4][portal_y4].tipo ='X';
        celdas[portal_x5][portal_y5].tipo ='X';
        celdas[portal_x6][portal_y6].tipo ='X';
        celdas[portal_x7][portal_y7].tipo ='X';
        celdas[portal_x8][portal_y8].tipo ='X';
        celdas[portal_x9][portal_y9].tipo ='X';
        celdas[portal_x10][portal_y10].tipo ='X';
        celdas[portal_x11][portal_y11].tipo ='X';
        celdas[portal_x12][portal_y12].tipo ='X';
        celdas[portal_x13][portal_y13].tipo ='X';
        celdas[portal_x14][portal_y14].tipo ='X';
        celdas[portal_x15][portal_y15].tipo ='X';
        celdas[portal_x16][portal_y16].tipo ='X';
        celdas[portal_x17][portal_y17].tipo ='X';
        celdas[portal_x18][portal_y18].tipo ='X';
        celdas[portal_x19][portal_y19].tipo ='X';
        celdas[portal_x20][portal_y20].tipo ='X';
        celdas[portal_x21][portal_y21].tipo ='X';
        celdas[portal_x22][portal_y22].tipo ='X';
        celdas[portal_x23][portal_y23].tipo ='X';
        celdas[portal_x24][portal_y24].tipo ='X';
        celdas[portal_x25][portal_y25].tipo ='X';
        celdaMovimiento = new Celda(cartero_x, cartero_y, cartero_x, cartero_y, 'J');

        /*se preparan las dimenciones y se entregan para definir los tamaños de las calles */
        this.anchoCalle = anchoMapa * SizeCelda;
        this.altoCalle = altoMapa * SizeCelda;
        this.setSize(anchoCalle, altoCalle);

    }

    @Override
    public void paintComponent(Graphics g) {
        update(g);
    }

    @Override
    public void update(Graphics g) {
        for (int i = 0; i < anchoMapa; i++) {
            for (int j = 0; j < altoMapa; j++) {
                celdas[i][j].paintComponent(g);
            }
        }
    }
}
