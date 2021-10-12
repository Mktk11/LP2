import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Ellipse2D.Double;

class ElipseApp {
    public static void main (String[] args) {
        PaintFrame frame = new PaintFrame();
        frame.setVisible(true);
    }
}

class PaintFrame extends JFrame {
    Elipse e1;
    Elipse e2;
    Elipse e3;

    PaintFrame () {
        this.addWindowListener (
            new WindowAdapter() {
                public void windowClosing (WindowEvent e) {
                    System.exit(0);
                }
            }
        );
        this.setTitle("Painting Figures");
        this.setSize(350, 350);
        this.e1 = new Elipse(50,50, 100,30,Color.black,Color.red);
        this.e2 = new Elipse(100,100,50,50,Color.gray,Color.yellow);
        this.e3 = new Elipse(200,150,100,100,Color.blue,Color.green);
    }

    public void paint (Graphics g) {
        super.paint(g);
        this.e1.paint(g);
        this.e2.paint(g);
        this.e3.paint(g);
    }

}
class Elipse {
    int x, y;
    int w, h;
    Color preencheCor;
    Color corBorda;

    Elipse (int x, int y, int w, int h,Color corBorda, Color preencheCor) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.corBorda = corBorda;
        this.preencheCor = preencheCor;
    }

    void print () {
        System.out.format("Elipse de tamanho (%d,%d) na posicao (%d,%d).\n",
            this.w, this.h, this.x, this.y);
    }

    void paint (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(this.preencheCor);
        g2d.fillOval(this.x,this.y,this.w,this.h);
        g2d.setColor(this.corBorda);
        g2d.draw(new Ellipse2D.Double(this.x,this.y, this.w,this.h));
        
    }
}
