public class RectApp{
	public static void main(String[] args){
		Rect r1 = new Rect(1,1, 10,10);
        	r1.drag(2,1);
        	r1.print();
	}
}
class Rect {
    int x, y;
    int w, h;
    int area;
    Rect (int x, int y, int w, int h) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.area=w*h;
    }
    void drag(int dx, int dy){
        this.x=x+dx;
        this.y=y+dy;

    }
    
    void print () {
        System.out.format("Retangulo de tamanho (%d,%d) na posicao (%d,%d) e area igual a (%d).\n",
            this.w, this.h, this.x, this.y,this.area);
    }
}
