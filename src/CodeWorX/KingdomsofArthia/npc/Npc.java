package CodeWorX.KingdomsofArthia.npc;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import CodeWorX.KingdomsofArthia.environment.javaMaps;
import CodeWorX.KingdomsofArthia.mainSystem.Main;

public class Npc {
	int id,health,type;
	int x,y,direction,walkInt,npcW,npcH;
	int collisionX,collisionY;
	int speed = 5;
	Image npcImage;
	
	public Npc(int id, int x, int y) {
		this.id = id;this.x = x;this.y = y;
		npcW = 32;
		npcH = 32;
		walkInt = 1;
		collisionX = x + npcW/2;
		collisionY = y + npcH/2;
		npcImage = Toolkit.getDefaultToolkit().getImage("src/CodeWorX/Images/npc/"+id+".png");
	}
	
	public void drawNpc(Graphics g) {
		
		int drawX = x - Main.gp.getXplayeronMap();
		int drawY = y - Main.gp.getYplayeronMap();
		g.drawImage(npcImage, drawX, drawY, drawX+npcW, drawY+npcH, 0+32*walkInt, 0+32*direction, 0+32*walkInt+32, 0+32*direction+32, null);
		update();
	}
	public void update() {
		int mapX = javaMaps.mapW*16 ,mapY= javaMaps.mapH*16;
		if(collisionX-speed > 0 && collisionY-speed > 0 && collisionX+speed < mapX && collisionY+speed < mapY) { // check if in map
		//	x += speed;
		}
	}
	
}
