package painter;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class PainterPanel extends JPanel implements ActionListener{

	private DrawPanel drawpanel;
	private JPanel buttonPanel;
	private JPanel topPanel;
	private JPanel actionPanel;
	private JButton clear;
	private JButton undo;
	private JButton redo;
	
	private JPanel tttPanel;
	private JButton tictactoe;
	private JButton O_btn;
	private JButton X_btn;
	
	private JPanel shapePanel;
	private JButton randgen;
	private JButton rect;
	private JButton square;
	private JButton oval;
	private JButton circle;
	private JButton vertTri;
	private JButton filledbt;
	private JButton twocolor;
	
	final int RECT = 1;
	final int SQUARE = 2;
	final int OVAL = 3;
	final int CIRCLE = 4;
	final int VERT_TRI = 5;
	final int TICTACTOE = 6;
	final int OPLAY = 7;
	final int XPLAY = 8;
	
	GridBagConstraints gbc = new GridBagConstraints();
	
	private Icon colorIcon, colorIcon2;
	private JButton colorbtn1,colorbtn2;
	private Color color, color2;
	
	public PainterPanel(){
		super();
		this.setLayout(new BorderLayout());
		drawpanel = new DrawPanel();
		add(drawpanel,BorderLayout.CENTER);
		
		actionPanel = new JPanel();
		clear = new JButton("Clear");
		clear.addActionListener(this);
		actionPanel.add(clear);
		
		undo = new JButton("Undo");
		undo.addActionListener(this);
		actionPanel.add(undo);
		
		redo = new JButton("Redo");
		redo.addActionListener(this);
		actionPanel.add(redo);
		add(actionPanel,BorderLayout.NORTH);
		
		topPanel = new JPanel();
		tictactoe = new JButton("Tictactoe");
		tictactoe.addActionListener(this);
		actionPanel.add(tictactoe);
		
		O_btn = new JButton("O_btn");
		O_btn.addActionListener(this);
		actionPanel.add(O_btn);
		
		X_btn = new JButton("X_btn");
		X_btn.addActionListener(this);
		actionPanel.add(X_btn);
		
		filledbt = new JButton("Filledbt");
		filledbt.addActionListener(this);
		actionPanel.add(filledbt);
		
		twocolor = new JButton("twocolor");
		twocolor.addActionListener(this);
		actionPanel.add(twocolor);
		
		shapePanel = new JPanel(new GridBagLayout());
//		shapePanel = new JPanel(new GridLayout(2,6));
//		shapePanel.setLayout(new GridBagLayout());
		
		randgen = new JButton("Randgen");
		setgbc(0,0,1,1);
		randgen.addActionListener(this);
		shapePanel.add(randgen,gbc);
		
		rect = new JButton("Rent");
		setgbc(1,0,1,1);
		rect.addActionListener(this);
		shapePanel.add(rect,gbc);
		
		square = new JButton("Square");
		setgbc(2,0,1,1);
		square.addActionListener(this);
		shapePanel.add(square,gbc);
		
		oval = new JButton("Oval");
		setgbc(0,1,1,1);
		oval.addActionListener(this);
		shapePanel.add(oval,gbc);
		
		circle = new JButton("Circle");
		setgbc(1,1,1,1);
		circle.addActionListener(this);
		shapePanel.add(circle,gbc);
		
		vertTri = new JButton("VertTri");
		setgbc(2,1,1,1);
		vertTri.addActionListener(this);
		shapePanel.add(vertTri,gbc);
		
		buttonPanel = new JPanel();
		
		colorIcon = new ImageIcon(getClass().getResource("color.png"));
		colorbtn1 = new JButton("C1", colorIcon);
		setgbc(3,0,2,1);
		colorbtn1.addActionListener(this);
		shapePanel.add(colorbtn1,gbc);
//		colorIcon2 = new ImageIcon(getClass().getResource("color.png"));
		colorbtn2 = new JButton("C2", colorIcon);
		setgbc(4,0,2,1);
		colorbtn2.addActionListener(this);
		shapePanel.add(colorbtn2,gbc);
		
		buttonPanel.add(shapePanel);
		add(buttonPanel,BorderLayout.SOUTH);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==randgen){
			System.out.println("randgen");
			drawpanel.randgen(10);
		}else if(e.getSource()==colorbtn1){
			System.out.println("color");
			color = JColorChooser.showDialog(this,"Choose a color",color);
			colorbtn1.setBackground(color);
			drawpanel.setColor(color);
		}else if(e.getSource()==colorbtn2){
			System.out.println("color2");
			color2 = JColorChooser.showDialog(this,"Choose a color",color2);
			colorbtn2.setBackground(color2);
			drawpanel.setColor2(color2);
		}else if(e.getSource()==rect){
			System.out.println("rect");
			drawpanel.settype(RECT);
		}else if(e.getSource()==square){
			System.out.println("square");
			drawpanel.settype(SQUARE);
		}else if(e.getSource()==oval){
			System.out.println("oval");
			drawpanel.settype(OVAL);
		}else if(e.getSource()==circle){
			System.out.println("circle");
			drawpanel.settype(CIRCLE);
		}else if(e.getSource()==vertTri){
			System.out.println("vertTri");
			drawpanel.settype(VERT_TRI);
		}else if(e.getSource()==clear){
			System.out.println("clear");
			drawpanel.clear();
		}else if(e.getSource()==tictactoe){
			System.out.println("tictactoe");
			drawpanel.settype(TICTACTOE);
		}else if(e.getSource()==O_btn){
			System.out.println("O_btn");
			drawpanel.settype(OPLAY);
		}else if(e.getSource()==X_btn){
			System.out.println("X_btn");
			drawpanel.settype(XPLAY);
		}else if(e.getSource()==filledbt){
			System.out.println("filledbt");
			drawpanel.setfilled();
		}else if(e.getSource()==twocolor){
			System.out.println("twocolor");
			
		}
	}
	public void setgbc(int x,int y,int height,int width){
		gbc.gridx = x;
		gbc.gridy = y;
		gbc.gridheight = height;
		gbc.gridwidth = width;
		gbc.fill = GridBagConstraints.BOTH;
	}
}
