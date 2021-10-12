  
public class PolApp {
    public static void main (String[] args) {
        Pol p1 = new Pol(1,1, 10,10,5);
        p1.print();
    }
}
class Pol {
    int x, y;
    int w, h;
    int s;
    Pol (int x, int y, int w, int h, int s) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.s = s;
    }
    void print () {
        System.out.format("Poligono de tamanho (%d,%d) na posicao (%d,%d) com (%d) lados.\n",
            this.w, this.h, this.x, this.y,this.s);
    }
}
