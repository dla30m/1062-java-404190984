package painter;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Xplay extends Square{

	private int r;
	public Xplay(int x1, int y1,int r, Color color) {
		super(x1, y1, color);
		this.r=r;
	}
	public void draw(Graphics g) {
		Graphics2D g2D = (Graphics2D) g;
		g.setColor(color);
		System.out.println("R "+r);
		System.out.println("x "+x1);
		System.out.println("y "+y2);
		System.out.println("x1 "+(x1-r/2));
		System.out.println("y1 "+(y1-r/2));
		g2D.drawLine(x1-r/2, y1-r/2, x1+r/2, y1+r/2);
		g2D.drawLine(x1+r/2, y1-r/2, x1-r/2, y1+r/2);
	}

}
