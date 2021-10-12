package figures;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Ellipse2D.Double;

public class Ellipse extends Figure {
    public Ellipse (int x, int y, int w, int h,Color corBorda, Color preencheCor ) {
        super(x,y,w,h,preencheCor,corBorda);
    }

    public void print () {
        System.out.format("Elipse de tamanho (%d,%d) na posicao (%d,%d).\n",
            this.w, this.h, this.x, this.y);
    }

    public void paint (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(this.preencheCor);
        g2d.fillOval(this.x,this.y, this.w,this.h);
        g2d.setColor(this.corBorda);
        g2d.draw(new Ellipse2D.Double(this.x,this.y, this.w,this.h));
    }
}
