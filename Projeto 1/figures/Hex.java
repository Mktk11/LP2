package figures;

import java.awt.*;

public class Hex extends Figure{
	public Hex(int x,int y,int w,int h,Color preencheCor,Color corBorda){
		super(x,y,w,h,preencheCor,corBorda);
	}
	public void paint (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        int x1[] = {this.x+w/5,this.x+w*4/5,this.x+w,this.x+w*4/5,this.x+w/5,this.x*(w/w)};
        int y1[] = {this.y*(h/h),this.y*(h/h),this.y+(this.h/2),this.y+h,this.y+h,this.y+(this.h)/2};
        g2d.setColor(this.preencheCor);
        g2d.fillPolygon(x1, y1, 6); 
        g2d.setColor(this.corBorda);
        g2d.drawPolygon(x1, y1, 6);
    }

}
