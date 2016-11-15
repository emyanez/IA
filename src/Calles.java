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
