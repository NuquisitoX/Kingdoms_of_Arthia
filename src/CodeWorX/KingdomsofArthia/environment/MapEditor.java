package CodeWorX.KingdomsofArthia.environment;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;

import CodeWorX.KingdomsofArthia.mainSystem.*;

public class MapEditor extends JFrame implements MouseListener, MouseMotionListener {

	Image img;
	Graphics dbi;
	
	public MapEditor(){
		setTitle("MapEditor for Kingdoms of Arthia");
		setPreferredSize(new Dimension(1015,729));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
		setVisible(true);
		pack();
		addMouseListener(this);
		addMouseMotionListener(this);
	}
	
	public void paint(Graphics g){
		
		img = createImage(getWidth(), getHeight());
		dbi = img.getGraphics();
		
		Main.gp.paintMap(dbi);
		g.drawImage(img, 0, 0, this);
		repaint();
	}
	
	public void paintComponent(Graphics g){
		Main.gp.paintMap(g);
	}
	
	public void mouseClicked(MouseEvent e){
		int mX = e.getX() / 16;
		int mY = e.getY() / 16;
		if(Main.gp.MapSys.getMap()[mY][mX] != 3) {
		Main.gp.MapSys.getMap()[mY][mX] = Main.gp.MapSys.getMap()[mY][mX] + 1;
		} else {
			Main.gp.MapSys.getMap()[mY][mX] = 0;
		}
		Main.gp.UpdateMap();
	}
	public void mouseEntered(MouseEvent e){}
	public void mouseExited(MouseEvent e){}
	public void mousePressed(MouseEvent e){}
	public void mouseReleased(MouseEvent e){}


	public void mouseDragged(MouseEvent e){
		int mX = e.getX() / 16;
		int mY = e.getY() / 16;
		Main.gp.MapSys.getMap()[mY][mX] = MapSystem.currentTile;
		Main.gp.UpdateMap();
	}
	public void mouseMoved(MouseEvent e){}

}
