package painter;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;

public class Square extends Shape {
	public Square(int x1, int y1, int x2, int y2, boolean filled, Color color) {
		super(x1, y1, x2, y2, filled, color);
	}
	public Square(int x1, int y1, Color color) {
		super(x1, y1, color);
	}
	private int hi,nx,ny;
	
	public void draw(Graphics g) {
		Graphics2D g2D = (Graphics2D) g;
		Polygon poly = null;
		g.setColor(color);
		System.out.println("x1 : "+x1+" y1 : "+y1+" x2 : "+x2+" y1 : "+y2+" min : "+Math.min(x2,y2));
		hi = Math.min( Math.abs(x2-x1), Math.abs(y2-y1));
		nx=x1;
		ny=y1;
		if(x1 > x2) {
			nx = x1-hi;
		}
		if(y1 > y2) {
			ny = y1-hi;
		}
		if(filled){
			g2D.fillRect(nx,ny, hi, hi);
//			g.drawArc( x1, y1, hi, hi, 0, 360);
//			g2D.drawRect(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x1-x2), Math.abs(y1-y2));
		}
		else{
			g2D.drawRect(nx,ny, hi, hi);
		}
	}
}
