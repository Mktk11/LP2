package buttons;
import ivisible.IVisible;
import java.awt.*;
import java.awt.Color;
import java.awt.Graphics2D;
import figures.Figure;

public class Button implements IVisible{
	public int i;
	private Figure fig;
	public Button(int i,Figure fig){
		this.i=i;
		this.fig=fig;
	}
	public boolean clicked(int x , int y){
		return(fig.x-5<=x && x<=fig.x+fig.w+10 && fig.y-5<=y && y<=fig.y+fig.h+10);
	}
	public void paint(Graphics g,boolean focus){
		Graphics2D g2d = (Graphics2D) g;
		if (focus) {
        	g2d.setColor(Color.GRAY);
        } 
        else {
        	g2d.setColor(Color.WHITE);
        }
        g2d.fillRect(fig.x-4, fig.y-4, fig.w+9, fig.h+9);
        g2d.setColor(Color.BLACK);
        g2d.drawRect(fig.x-5, fig.y-5, fig.w+10, fig.h+10);		
        this.fig.paint(g, false);
    }
}
