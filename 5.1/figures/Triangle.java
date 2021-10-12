package figures;

import java.awt.*;

public class Triangle extends Figure {
    private int x1, y1;
    private int x2, y2;
    private int x3, y3;
    Color preencheCor;
    Color corBorda;

    public Triangle(int x1, int y1, int x2, int y2, int x3, int y3,Color corBorda, Color preencheCor) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.x3 = x3;
        this.y3 = y3;
        this.corBorda = corBorda;
        this.preencheCor = preencheCor;
    }

    public void Print() {
        System.out.format("Triangulo de vertices (%d, %d), (%d, %d) e (%d, %d).\n",
            this.x1, this.y1, this.x2, this.y2, this.x3, this.y3);
    }

    public void paint (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        int x[] = {this.x1, this.x2, this.x3};
        int y[] = {this.y1, this.y2, this.y3};
        Polygon TrianglePreencher = new Polygon(x, y, 3);
        g2d.setColor(this.preencheCor);
        g2d.fillPolygon(TrianglePreencher);
        g2d.setColor(this.corBorda);
        g2d.drawLine(this.x1, this.y1, this.x2, this.y2);
        g2d.drawLine(this.x2, this.y2, this.x3, this.y3);
        g2d.drawLine(this.x3, this.y3, this.x1, this.y1);

    }
}
