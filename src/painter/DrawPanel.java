package painter;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Random;

import javax.swing.JPanel;

public class DrawPanel extends JPanel implements MouseListener , MouseMotionListener{

	final int Max=100;
	private Shape shapes[];
	private Shape currentshape;
	private Board currentttt;
	private int shapeCount,r;
	private int x1,x2,y1,y2,type = 1,xCL,yCL;
	private Color color,color2;
	
	final int RECT = 1;
	final int SQUARE = 2;
	final int OVAL = 3;
	final int CIRCLE = 4;
	final int VERT_TRI = 5;
	final int TICTACTOE = 6;
	final int OPLAY = 7;
	final int XPLAY = 8;
	
//	private int choce ;
	boolean filled;
	Random rand;
	public DrawPanel(){
		super();
		shapes = new Shape[Max];
		rand = new Random();
		addMouseListener(this);
		addMouseMotionListener(this);
	}
	public void randgen(int n) {
		for(int i=0;i<n;i++){
			x1=rand.nextInt(600);
			x2=rand.nextInt(600);
			y1=rand.nextInt(600);
			y2=rand.nextInt(600);
			color = new Color(rand.nextInt(256),rand.nextInt(256),rand.nextInt(256));
			type = rand.nextInt(3)+1;
			filled = rand.nextBoolean();
//			choce = rand.nextInt(4)+1;
			switch(type){
			case RECT:
				shapes[shapeCount++] = new Rect(x1,y1,x2,y2,filled,color);
				break;
			case OVAL:
				shapes[shapeCount++] = new Oval(x1,y1,x2,y2,filled,color);
				break;
			case VERT_TRI:
				shapes[shapeCount++] = new VertTri(x1,y1,x2,y2,filled,color);
			}
		}
		repaint();
	}
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		if(currentshape != null){
			currentshape.draw(g);
		}
		for(int i=0;i<shapeCount;i++){
			System.out.println("shapeCount : "+shapeCount);
			System.out.println("i : "+i);
			System.out.println("shapes[i] : "+shapes[i]);
			shapes[i].draw(g);
		}
		
	}
	public void clear() {
		shapeCount = 0;
		currentttt = null;
		repaint();
	}
//	public void addshape(int type) {
//		filled = rand.nextBoolean();
//		choce = rand.nextInt(4)+1;
//		switch(type){
//		case RECT:
//			shapes[shapeCount++] = new Rect(x1,y1,x2,y2,filled,color);
//			break;
//		case OVAL:
//			shapes[shapeCount++] = new Oval(x1,y1,x2,y2,filled,color);
//			break;
//		case VERT_TRI:
//			shapes[shapeCount++] = new VertTri(x1,y1,x2,y2,filled,color);
//		}
//		repaint();
//	}
	@Override
	public void mouseDragged(MouseEvent arg0) {
		System.out.println("Mouse Dragged");
		x2 = arg0.getX();
		y2 = arg0.getY();
		currentshape = null;
		switch(type){
		case RECT:
			currentshape = new Rect(x1,y1,x2,y2,filled,color);
			break;
		case SQUARE:
			currentshape = new Square(x1,y1,x2,y2,filled,color);
			break;
		case OVAL:
			currentshape = new Oval(x1,y1,x2,y2,filled,color);
			break;
		case CIRCLE:
			currentshape = new Circle(x1,y1,x2,y2,filled,color);
			break;
		case VERT_TRI:
			currentshape = new VertTri(x1,y1,x2,y2,filled,color);
			break;
		case TICTACTOE:
			currentshape = new Board(x1,y1,x2,y2,filled,color);
			break;
		}
		repaint();
	}
	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println("Mouse Clicked");
		xCL = e.getX();
		yCL = e.getY();
		if( currentttt!=null && (type==OPLAY || type == XPLAY)) {
			r = currentttt.getHi();
			System.out.println("R "+r);
			System.out.println("x "+xCL);
			System.out.println("y "+yCL);
			switch(type) {
			case OPLAY:
				shapes[shapeCount++]  = new Oplay(xCL,yCL,r,color);
				break;
			case XPLAY:
				shapes[shapeCount++]  = new Xplay(xCL,yCL,r,color2);
				break;
			}
			repaint();
		}
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
	}
	@Override
	public void mousePressed(MouseEvent e) {
		System.out.println("Mouse Pressed");
		x1 = e.getX();
		y1 = e.getY();
		x2 = x1;
		y2 = y2;
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		System.out.println("Mouse Released");
		x2 = e.getX();
		y2 = e.getY();
//		repaint();
		if(currentshape != null && type !=TICTACTOE) {
			shapes[shapeCount++] = currentshape;
			currentshape = null;
		}
		if(type == TICTACTOE) {
			currentttt = new Board(x1,y1,x2,y2,filled,color);
			shapes[shapeCount++] = currentttt;
		}
//		addshape(type);
		System.out.println("Count : "+shapeCount);
	}
	public void settype(int type) {
		this.type = type;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	public void setColor2(Color color2) {
		this.color2 = color2;
	}
	public void setfilled() {
		this.filled = !filled;
		
	}
}