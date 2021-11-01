import java.awt.*;
import java.awt.event.*;
import java.awt.Color;
import java.awt.event.MouseEvent;

import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.util.ArrayList;

import java.io.*;

import buttons.Button;
import figures.*;

class ListApp {
    public static void main (String[] args) {
        ListFrame frame = new ListFrame();
        frame.setVisible(true);
        
    }
}

class ListFrame extends JFrame {
	ArrayList<Figure> figs = new ArrayList<Figure>();
    ArrayList<Button> buts = new ArrayList<Button>();
    Button focus_but=null;
    Figure focus = null;
    Point pMouse = null;

    int dx,dy;
    int contcontorno=1;
    int contpreenchimento=0;
    Color cores[] = {Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW, Color.MAGENTA, Color.CYAN, Color.WHITE, Color.BLACK, Color.GRAY, Color.LIGHT_GRAY, Color.DARK_GRAY, Color.PINK, Color.ORANGE};
    Color cores1[] = {Color.YELLOW, Color.MAGENTA, Color.CYAN, Color.WHITE, Color.BLACK, Color.GRAY, Color.LIGHT_GRAY, Color.DARK_GRAY,Color.RED, Color.GREEN, Color.BLUE, Color.PINK, Color.ORANGE};

    ListFrame () {
        try{
            FileInputStream f = new FileInputStream("proj.bin");
            ObjectInputStream o = new ObjectInputStream(f);
            this.figs = (ArrayList<Figure>) o.readObject();
            o.close();
        }
        catch(Exception x){
            System.out.println("Erro!!!");
        }
        this.addWindowListener (
            new WindowAdapter() {
                public void windowClosing (WindowEvent e) {
                    try{
                        FileOutputStream f = new FileOutputStream("proj.bin");
                        ObjectOutputStream o = new ObjectOutputStream(f);
                        o.writeObject(figs);
                        o.flush();
                        o.close();
                    }catch (Exception x){}
                    System.exit(0);
                }
            }
        );
        buts.add(new Button(0,new Rect(20,50,10,10,Color.BLACK,Color.BLACK)));
        buts.add(new Button(1,new Ellipse(40,50,10,10,Color.BLACK,Color.BLACK)));
        buts.add(new Button(2,new Triangle(20,70,10,10,Color.BLACK,Color.BLACK)));
        buts.add(new Button(3,new Hex(40,70,10,10,Color.BLACK,Color.BLACK)));
        buts.add(new Button(4,new Rect(20,90,10,10,Color.YELLOW,Color.BLACK)));
        buts.add(new Button(5,new Rect(40,90,10,10,Color.BLUE,Color.BLACK)));
        buts.add(new Button(6,new Rect(20,110,10,10,Color.RED,Color.BLACK)));
        buts.add(new Button(7,new Rect(40,110,10,10,Color.GREEN,Color.BLACK)));
        buts.add(new Button(8,new Rect(20,130,10,10,Color.PINK,Color.BLACK)));
        buts.add(new Button(9,new Rect(40,130,10,10,Color.GRAY,Color.BLACK)));
        buts.add(new Button(10,new Rect(20,150,10,10,Color.ORANGE,Color.BLACK)));
        buts.add(new Button(11,new Rect(40,150,10,10,Color.BLACK,Color.BLACK)));
        this.addMouseListener(
            new MouseAdapter(){
                public void mousePressed(MouseEvent evt){
                    try{
                        int x = evt.getX();
                        int y = evt.getY();
                        pMouse = getMousePosition();
                        focus = null;
                        if ((15 <= pMouse.x && pMouse.x <= 60) && (35 <= pMouse.y && pMouse.y <= 215)) {
                            focus=null;
                            for(Button but:buts){
                                if(but.clicked(pMouse.x,pMouse.y)){
                                    focus_but=but;
                                }
                                repaint();
                            }
                        }
                        else if(focus_but!=null){
                            int i = focus_but.i;
                            pMouse=getMousePosition();
                            int w = 50;
                            int h = 50;
                            Color corBorda = cores1[contcontorno];
                            Color preencheCor = cores1[contpreenchimento];
                            if (i==0){
                                figs.add(new Rect(x,y, w,h,preencheCor,corBorda));
                            }
                            else if(i==1){
                                figs.add(new Ellipse(x,y,w,h,preencheCor,corBorda));
                            }
                            else if(i==2){
                                figs.add(new Triangle(x,y,w,h,preencheCor,corBorda));
                            }
                            else if(i==3){
                                figs.add(new Hex(x,y,w,h,preencheCor,corBorda));
                            }
                            else if(i==4){
                                for (Figure fig: figs){
                                    if (fig.clicked(pMouse.x,pMouse.y)){
                                        focus=fig;
                                        focus.preencheCor = Color.YELLOW;
                                        focus.corBorda = Color.YELLOW;

                                    }
                                }
                            }
                            else if(i==5){
                                for (Figure fig: figs){
                                    if (fig.clicked(pMouse.x,pMouse.y)){
                                        focus=fig;
                                        focus.preencheCor = Color.BLUE;
                                        focus.corBorda = Color.BLUE;
                                    }
                                }
                            }
                            else if(i==6){
                                for (Figure fig: figs){
                                    if (fig.clicked(pMouse.x,pMouse.y)){
                                        focus=fig;
                                        focus.preencheCor = Color.RED;
                                        focus.corBorda = Color.RED;

                                    }
                                }
                            }
                            else if(i==7){
                                for (Figure fig: figs){
                                    if (fig.clicked(pMouse.x,pMouse.y)){
                                        focus=fig;
                                        focus.preencheCor = Color.GREEN;
                                        focus.corBorda = Color.GREEN;

                                    }
                                }
                            }
                            else if(i==8){
                                for (Figure fig: figs){
                                    if (fig.clicked(pMouse.x,pMouse.y)){
                                        focus=fig;
                                        focus.preencheCor = Color.PINK;
                                        focus.corBorda = Color.PINK;

                                    }
                                }
                            }
                            else if(i==9){
                                for (Figure fig: figs){
                                    if (fig.clicked(pMouse.x,pMouse.y)){
                                        focus=fig;
                                        focus.preencheCor = Color.GRAY;
                                        focus.corBorda = Color.GRAY;

                                    }
                                }
                            }
                            else if(i==10){
                                for (Figure fig: figs){
                                    if (fig.clicked(pMouse.x,pMouse.y)){
                                        focus=fig;
                                        focus.preencheCor = Color.ORANGE;
                                        focus.corBorda = Color.ORANGE;

                                    }
                                }
                            }
                            else if(i==11){
                                for (Figure fig: figs){
                                    if (fig.clicked(pMouse.x,pMouse.y)){
                                        focus=fig;
                                        focus.preencheCor = Color.BLACK;
                                        focus.corBorda = Color.BLACK;

                                    }
                                }
                            }
                            focus_but=null;
                            repaint();
                        }
                        else{
                            for (Figure fig: figs){
                                if (fig.clicked(pMouse.x,pMouse.y)){
                                    focus = fig;
                                    dx = focus.x - pMouse.x;
                                    dy = focus.y - pMouse.y;
                                }
                            }
                            if (focus!=null){
                                figs.remove(focus);
                                figs.add(focus);
                            }
                            repaint();
                        }
                            
                    }catch(Exception x){}
                }
            }
        );
        this.addMouseMotionListener(
            new MouseMotionAdapter() {
                public void mouseDragged(MouseEvent me) {
                    pMouse = getMousePosition();
                    if (focus != null) {
                        figs.remove(focus);
                        figs.add(focus);
                        focus.x = pMouse.x + dx;
                        focus.y = pMouse.y + dy;
                    }
                    repaint();
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
                    Color corBorda = cores1[contcontorno];
                    Color preencheCor = cores1[contpreenchimento]; 
                    Color contorno = cores[contcontorno];
                    Color preenchimento = cores[contpreenchimento];
                        
                    if (evt.getKeyChar() == 'r') {
                        Rect r = new Rect(x,y, w,h,preencheCor,corBorda);
                        figs.add(r);
                    }
                    else if (evt.getKeyChar() == 'e') {
                        figs.add(new Ellipse(x,y,w,h,preencheCor,corBorda));
                    }
                    else if (evt.getKeyChar() == 't'){
                        figs.add(new Triangle(x,y,w,h,preencheCor,corBorda));
                        
                    }
                    else if (evt.getKeyChar() == 'h'){
                        figs.add(new Hex(x,y,w,h,preencheCor,corBorda));
                        
                    }
                    
                    try{
                        if (evt.getKeyCode() == 10){
                            for( Figure fig: figs){
                                if ((focus == null) || (focus!=null)){
                                    focus=fig;
                                    figs.remove(focus);
                                    figs.add(focus);
                                    break;
                                }
                                repaint();
                            

                            }
                            
                        }
                     
                        
                        else if(evt.getKeyCode() == 127){
                            figs.remove(focus);
                            focus=null;

                        }
                        else if(evt.getKeyCode() == 38){
                            focus.y-=10;
                        }
                        else if(evt.getKeyCode() == 37){
                            focus.x-=10;
                        }
                        else if(evt.getKeyCode() == 40){
                            focus.y+=10;
                        }
                        else if(evt.getKeyCode() == 39){
                            focus.x+=10;
                        }
                        else if (evt.getKeyChar()=='a'){
                            focus.w+=5;
                            focus.h+=5;
                        }
                        else if (evt.getKeyChar()=='d'){
                            if(focus.w>=10 && focus.h>=10){
                                focus.w-=5;
                                focus.h-=5;
                            }
                        }
                        else if(evt.getKeyChar()=='m'){
                            if (contcontorno==12){
                                contcontorno=0;
                            }
                            else {
                                contcontorno++;
                            }
                            focus.corBorda=cores1[contcontorno];

                        }
                        else if(evt.getKeyChar()=='k'){
                            if (contpreenchimento==12){
                                contpreenchimento=0;
                            }
                            else {
                                contpreenchimento++;
                            }
                            focus.preencheCor=cores1[contpreenchimento];
                        }
                        else if(evt.getKeyChar()=='c'){
                            if (contcontorno==12){
                                contcontorno=0;
                            }
                            else {
                                contcontorno++;
                            }
                            focus.contorno=cores[contcontorno];

                        }
                        else if (evt.getKeyChar()=='p'){
                            if (contpreenchimento==12){
                                contpreenchimento=0;
                            }
                            else {
                                contpreenchimento++;
                            }
                            focus.preenchimento=cores[contpreenchimento];

                        }
                        repaint();    
                    }catch(Exception e){}
                }
            }
        );

        this.setTitle("Projeto");
        this.setSize(350, 350);
    }
    public void paint (Graphics g){
        super.paint(g);
        for(Figure fig: this.figs){
            if(focus==fig){
                focus.preencherFig(g,fig==focus);
                focus.desenharBorda(g,fig==focus);
            }
            fig.paint(g,fig==focus);
        }
        for(Button but: buts){
            but.paint(g,but==focus_but);
        }
        
        
    
    }

    
}
