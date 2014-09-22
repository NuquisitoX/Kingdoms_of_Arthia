/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package CodeWorX.KingdomsofArthia.mainSystem;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import CodeWorX.KingdomsofArthia.environment.MapSystem;

/**
 *
 * @author Joshua
 */

public class MouseMethod implements MouseListener,MouseMotionListener {
	
	public boolean press;
	public int mouseX, mouseY;
	
    public MouseMethod() {
    	press = false;
    	mouseX = mouseY = 0;
    }

	public void mouseClicked(MouseEvent e) {
		
	}
		

	public void mouseEntered(MouseEvent e) {

	}

	public void mouseExited(MouseEvent e) {
		
	}

	public void mousePressed(MouseEvent e) {
		press = true;
		mouseX = (int) e.getX();
		mouseY = (int) e.getY();
		System.out.println("mouseX = "+ mouseX + " & mouseY = " + mouseY);
	}

	public void mouseReleased(MouseEvent e) {
		press = false;
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		
		Main.gp.MapSys.getMap()[e.getY()/16][e.getX()/16] = Main.gp.MapSys.currentTile;
		
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
    
    
    
}
