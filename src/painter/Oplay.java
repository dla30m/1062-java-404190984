package painter;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;

public class Oplay extends Circle{

	private int hi,r;
	public Oplay(int x1, int y1,int r, Color color) {
		super(x1, y1, color);
		this.r=r;
		// TODO 自動產生的建構子 Stub
	}
	public void draw(Graphics g) {
		Graphics2D g2D = (Graphics2D) g;
		g.setColor(color);
		System.out.println("R "+r);
		System.out.println("x "+x1);
		System.out.println("y "+y2);
		System.out.println("x1 "+(x1-r/2));
		System.out.println("y1 "+(y1-r/2));
//		hi = Math.min( Math.abs(x2-x1), Math.abs(y2-y1));
		g2D.fillOval((x1-r/2), (y1-r/2), r, r);
	}

}
