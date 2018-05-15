package painter;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Rect extends Shape{

	public Rect(int x1, int y1, int x2, int y2, boolean filled, Color color) {
		super(x1, y1, x2, y2, filled, color);
	}
	public void draw(Graphics g) {
		Graphics2D g2D = (Graphics2D) g;
		g.setColor(color);
		if(filled){
			g2D.fillRect(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x1-x2), Math.abs(y1-y2));
		}else{
			g2D.drawRect(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x1-x2), Math.abs(y1-y2));
		}
		
	}

}
