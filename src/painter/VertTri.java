package painter;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;

public class VertTri extends Shape{

	public VertTri(int x1, int y1, int x2, int y2, boolean filled, Color color) {
		super(x1, y1, x2, y2, filled, color);
		// TODO Auto-generated constructor stub
	}
	
//    int[] xValues3 = { 120, 140, 150, 190 };
//    int[] yValues3 = { 40, 70, 80, 60 };
//    Polygon polygon1 = new Polygon( xValues, yValues, 6 );
//    g.fillPolygon( xValues3, yValues3, 4 );
//    poly = new Polygon(
//    		new int[]{tx1, tx3, tx4},
//    		new int[]{ty1, ty3, ty4},
//    		3);
	@Override
	public void draw(Graphics g) {
		Graphics2D g2D = (Graphics2D) g;
		Polygon poly = null;
		g.setColor(color);
		poly = new Polygon(
			new	int[] { x1 , x1 , x2},
			new	int[] { y1 , y2 , y2},
			3);
		if(filled){g2D.fill(poly);}
		else{g2D.draw(poly);}
	}
}
