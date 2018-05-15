package painter;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;

public class Board extends Square{

	private int rank=3;
	private int cell_height;
	private int cell_width;
	private int hi,nx,ny;
	public Board(int x1, int y1, int x2, int y2, boolean filled, Color color) {
		super(x1, y1, x2, y2, filled, color);
		cell();
	}

	void cell() {
		hi = Math.min( Math.abs(x2-x1), Math.abs(y2-y1));
		cell_width = hi/rank;
		cell_height = hi/rank;
	}
	@Override
	public void draw(Graphics g) {
		Graphics2D g2D = (Graphics2D) g;
		Polygon poly = null;
		
		g.setColor(Color.BLACK);
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
		g2D.setPaint(new Color(176,176,85));
//		g.setColor(Color.YELLOW);
		g2D.fillRect(nx,ny, hi, hi);
		g.setColor(Color.BLACK);
		g2D.setStroke(new BasicStroke(5.0f));
		g2D.drawRect(nx,ny, hi, hi);
		for(int i=1;i<rank;i++){
		   	g2D.drawLine(nx+cell_width*i, ny, nx+cell_width*i, ny+hi);
		   	g2D.drawLine(nx, ny+cell_height*i,  nx+hi, ny+cell_height*i);
		}
	}
	public int getHi() {
		return cell_width;
	}

	public void setHi(int hi) {
		this.hi = cell_width;
	}
}
