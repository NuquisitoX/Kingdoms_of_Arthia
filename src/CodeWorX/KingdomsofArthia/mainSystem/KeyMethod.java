/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package CodeWorX.KingdomsofArthia.mainSystem;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import CodeWorX.KingdomsofArthia.Interfaces.ChatboxInterface;
import CodeWorX.KingdomsofArthia.Interfaces.InterfaceSystem;
import CodeWorX.KingdomsofArthia.Interfaces.messageParser;
import CodeWorX.KingdomsofArthia.environment.*;
import CodeWorX.KingdomsofArthia.player.Player;

/**
*
* @author Joshua Jenster, Nordin H
* 
*/

public class KeyMethod implements KeyListener {
	
	public boolean keyW, keyA, keyS, keyD, keyY, SHIFT,CAPS;
	private String shiftString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ)!@#$%^&*(<>?:\"|_+~";
	private String normalString = "abcdefghijklmnopqrstuvwxyz0123456789,./;'\\-=`";
	int test = 0;
	Player p = Main.gp.player;
	MapEditor MapEditor;
	public static String message = "";
	
    public KeyMethod() {
        keyW = keyA = keyS = keyD = keyY = false;
    }
 
    public void keyPressed(KeyEvent e){
    	switch(e.getKeyCode()){ // when chatbox is open or closed, no difference
    	case KeyEvent.VK_SHIFT: SHIFT = true; break;
    	}
    	if(InterfaceSystem.getTypeOpen()) {
    		if(KeyEvent.VK_ENTER == e.getKeyCode()) {
    			
    			InterfaceSystem.updateTypeOpen(false);
    			messageParser.parseMessage(message, "Player");
    			message = "";
    			
    		}else {
    			String key = KeyEvent.getKeyText(e.getKeyCode());
    			if(SHIFT) {
    			if(shiftString.contains(key)) {
    				message += key;
    			}
    			} else {
    				if(normalString.contains(key.toLowerCase())) {
        				message += key.toLowerCase();
        			}
    			}
    			switch(e.getKeyCode()){
    			case KeyEvent.VK_SPACE: message += " "; break;
    			case KeyEvent.VK_SLASH: message += "/"; break;
    			case KeyEvent.VK_EXCLAMATION_MARK: message+="!";break;
    			case KeyEvent.VK_SEMICOLON:message +=";";break;
    			case KeyEvent.VK_BACK_SPACE:if(message.length()>0) message = message.substring(0, message.length()-1);;break;
    			}
    		
    		}
    		
    		
    	} else { // else normal // this is when chatbox = closed
        switch(e.getKeyCode()){
	        case KeyEvent.VK_W: keyW = true; break;
	        case KeyEvent.VK_A: keyA = true; break;
	        case KeyEvent.VK_S: keyS = true; break;
	        case KeyEvent.VK_D: keyD = true; break;
	        case KeyEvent.VK_M: MapEditor = new MapEditor(); break;
	        case KeyEvent.VK_Q: Main.gp.MapSys.outputMap(); break;
	        case KeyEvent.VK_E: if(MapSystem.currentTile != 3){MapSystem.currentTile++;}else{MapSystem.currentTile = 0;}; break;
	        case KeyEvent.VK_Z: MapSystem.loadMap(new Random().nextInt(MapSystem.Maps.size())); break;
	        case KeyEvent.VK_T: ChatboxInterface.typeBoxActive(!ChatboxInterface.typeBoxActive); test++; break;
	        case KeyEvent.VK_Y: keyY = true; break;
	        case KeyEvent.VK_K: Main.gp.UpdateMap(); break;
	        case KeyEvent.VK_UP: Player.speed = 10; break;
	        case KeyEvent.VK_DOWN: Player.speed = 1; break;
	        
        }
        }
    }
    public void keyReleased(KeyEvent e) {
    	switch(e.getKeyCode()){
	        case KeyEvent.VK_W: keyW = false; p.resetWalkInt(); break;
	        case KeyEvent.VK_A: keyA = false; p.resetWalkInt(); break;
	        case KeyEvent.VK_S: keyS = false; p.resetWalkInt(); break;
	        case KeyEvent.VK_D: keyD = false; p.resetWalkInt(); break;
	        case KeyEvent.VK_Y: keyY = false; break;
	        case KeyEvent.VK_SHIFT: SHIFT = false; break;
    	}
    }
    public void keyTyped(KeyEvent e) {
        
    }
    
}
