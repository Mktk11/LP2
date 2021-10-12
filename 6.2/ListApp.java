import java.awt.*;
import java.awt.event.*;
import java.awt.Color;
import java.awt.event.MouseEvent;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.util.ArrayList;
import java.util.Random;
import figures.*;

class ListApp {
    public static void main (String[] args) {
        ListFrame frame = new ListFrame();
        frame.setVisible(true);
    }
}

class ListFrame extends JFrame {
    ArrayList<Figure> figs = new ArrayList<Figure>();
    Figure focus = null;
    Point pMouse = null;
    Random rand = new Random();
    ListFrame () {
        this.addWindowListener (
            new WindowAdapter() {
                public void windowClosing (WindowEvent e) {
                    System.exit(0);
                }
            }
        );
        this.addMouseListener(
            new MouseAdapter(){
                public void mousePressed(MouseEvent evt){
                    pMouse = getMousePosition();
                    focus = null;
                    for (Figure fig: figs){
                        if (fig.clicked(pMouse.x,pMouse.y)){
                            focus = fig;

                        }
                        if (focus!=null){
                            figs.remove(focus);
                            figs.add(focus);
                        }
                        repaint();
                    }
                }
            }
        );
        this.addKeyListener (
            new KeyAdapter() {
                public void keyPressed (KeyEvent evt) {
                    pMouse = getMousePosition();
                    int x = pMouse.x;
                    int y = pMouse.y;
                    int w = 50;
                    int h = 50;
                    //A tecla r adiciona um retangulo
                    //A tecla e adiciona uma elipse
                    //A tecla t adiciona um triangulo
                    //A tecla "para cima" move a figura com o foco para cima 
                    //A tecla "para baixo" move a figura com o foco para baixo
                    //A tecla "para direita" move a figura com o foco para direita
                    //A tecla "para esquerda" move a figura com o foco para esquerda   
                    if (evt.getKeyChar() == 'r') {
                        Rect r = new Rect(x,y, w,h,Color.red,Color.black);
                        figs.add(r);
                    }
                    if (evt.getKeyChar() == 'e') {
                        figs.add(new Ellipse(x,y,w,h,Color.blue,Color.yellow));
                       
                    }
                    if (evt.getKeyChar() == 't'){
                        figs.add(new Triangle(x,y,w,h,Color.green,Color.black));
                    }
                    if(evt.getKeyCode() == 127){
                        figs.remove(focus);
                    }
                    if(evt.getKeyCode() == 38){
                        focus.y-=10;
                    }
                    if(evt.getKeyCode() == 37){
                        focus.x-=10;
                    }
                    if(evt.getKeyCode() == 40){
                        focus.y+=10;
                    }
                    if(evt.getKeyCode() == 39){
                        focus.x+=10;
                    }
                    repaint();
                    
                }
            }
        );

        this.setTitle("Projeto");
        this.setSize(350, 350);
    }

    public void paint (Graphics g){
        super.paint(g);
        if (focus != null){
            focus.desenharBorda(g);
        }
        for(Figure fig: this.figs){
            fig.paint(g);
        }
        
    }
}
