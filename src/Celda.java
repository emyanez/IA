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

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JComponent;

public class Celda extends JComponent implements Constantes {

    public int x;
    public int y;

    public int i;
    public int j;

    public boolean rectCelda;
    public char tipo;
    public BufferedImage cartero, casa, camino, peaton, portal, obstaculo, acera, automovil, cebra;

    public Celda(int x, int y, int i, int j, char tipo) {
        this.x = x;
        this.y = y;
        this.i = i;
        this.j = j;
        this.tipo = tipo;
        try {
            automovil = ImageIO.read(new File("src/imagenes/auto.png"));
            obstaculo = ImageIO.read(new File("src/imagenes/obstaculo.png"));
            cartero = ImageIO.read(new File("src/imagenes/cartero.png"));
            casa = ImageIO.read(new File("src/imagenes/casa.png"));
            camino = ImageIO.read(new File("src/imagenes/camino.png"));
            portal = ImageIO.read(new File("src/imagenes/portal.png"));
            peaton = ImageIO.read(new File("src/imagenes/peaton.png"));
            acera = ImageIO.read(new File("src/imagenes/vereda.png"));
            cebra = ImageIO.read(new File("src/imagenes/paso peatonal.png"));
        } catch (IOException e) {
            System.out.println(e.toString());
        }

    }

    /**/
    @Override
    public void update(Graphics g) {
        switch (tipo) {
            case 'T':
                g.drawImage(automovil, x, y, null);
                break;
            case 'O':
                g.drawImage(obstaculo, x, y, null);
                break;
            case 'J':
                g.drawImage(cartero, x, y, null);
                break;
            case 'P':
                g.drawImage(peaton, x, y, this);
                break;
            case 'C':
                g.drawImage(camino, x, y, this);
                break;
            case 'M':
                g.drawImage(casa, x, y, this);
                break;
            case 'X':
                g.drawImage(portal, x, y, this);
                break;
            case 'A':
                g.drawImage(acera, x, y, this);
                break;
            case 'Z':
                g.drawImage(cebra, x, y, this);
                break;
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        update(g);
    }

}