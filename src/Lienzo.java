/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Emilio
 */
import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Timer;

public class Lienzo extends Canvas implements Constantes{
public Cartero cartero;
public Calles calle;
public Peaton peaton,peaton2,peaton3;
public Auto auto, auto2,auto3, auto4;
public Timer timer;

public Lienzo(){
    
    calle =new Calles(this);
    auto=new Auto(calle);
    auto2=new Auto(calle);
    auto3=new Auto(calle);
    auto4=new Auto(calle);
    peaton = new Peaton(calle);
    peaton2 = new Peaton(calle);
    peaton3=new Peaton(calle);
    cartero=new Cartero(calle);
    
    this.setSize(calle.anchoCalle, calle.altoCalle);

    timer = new Timer(); 
    
    
  timer.scheduleAtFixedRate( auto , 0 , 200);
  //Agregar Autos
  timer.scheduleAtFixedRate( auto2 ,0 , 300);
  timer.scheduleAtFixedRate( auto3 ,0 , 400);
  timer.scheduleAtFixedRate(auto4, 0, 500);
  //Agregar Peatones
  timer.scheduleAtFixedRate( peaton , 0 ,800);
  timer.scheduleAtFixedRate(peaton2 , 0 ,800);
  timer.scheduleAtFixedRate(peaton3 , 0 ,800);
  
addMouseListener(new MouseAdapter() {
@Override
    public void mouseClicked(MouseEvent evt) {
        agregarObstaculo(evt);
        repaint();
        }
});

addKeyListener(new java.awt.event.KeyAdapter() {
@Override
    public void keyPressed(KeyEvent e) {
        cartero.moverCartero(e);
        repaint();
        }
});

}

@Override
public void update(Graphics g) {
calle.paintComponent(g);
}

@Override
public void paint(Graphics g) {
update(g);
}
private void agregarObstaculo(MouseEvent evt) {
    int aX=evt.getX();
    int aY=evt.getY();
    if((evt.getModifiers() & InputEvent.BUTTON1_MASK) == InputEvent.BUTTON1_MASK) {
        if(calle.celdas[aX/SizeCelda][aY/SizeCelda].tipo!='J'
           && calle.celdas[aX/SizeCelda][aY/SizeCelda].tipo!='X' 
           && calle.celdas[aX/SizeCelda][aY/SizeCelda].tipo!='T' 
           &&calle.celdas[aX/SizeCelda][aY/SizeCelda].tipo!='M' ){
                            System.out.println("Boton Izquierdo - Poner Obstaculo");
                             calle.celdas[aX/SizeCelda][aY/SizeCelda].tipo='O';
            }
        }
    else {
        System.out.println("Boton Derecho - Poner Peaton");
        calle.celdas[aX/SizeCelda][aY/SizeCelda].tipo='P';
        }       
    }


}
        
    
