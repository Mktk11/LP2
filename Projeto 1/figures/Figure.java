package figures;
import java.awt.*; 
import java.applet.*; 
import javax.swing.*;
import java.awt.*;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Toolkit;

public abstract class Figure {
    public int x,y,w,h;
    public Color preencheCor;
    public Color corBorda;
    public abstract void paint (Graphics g);

    public Figure(int x,int y,int w,int h,Color preencheCor,Color corBorda){
        this.x=x;
        this.y=y;
        this.w=w;
        this.h=h;
        this.corBorda = corBorda;
        this.preencheCor = preencheCor;
    }
    

    public boolean clicked (int posX, int posY) {
          return (((x <= posX) && (y <= posY)) && ((posX <= (x + w)) && (posY <= (y + h))));
    }
    

    public Color contorno = new Color(255,10,10);
    public Color preenchimento = new Color(255,255,255);

    public void desenharBorda(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(contorno);
        g2d.drawRect(this.x-4,this.y-4,this.w+8,this.h+8);
    }
    public void preencherFig(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(preenchimento);
        g2d.fillRect(this.x-4,this.y-4,this.w+8,this.h+8);
    }
}
