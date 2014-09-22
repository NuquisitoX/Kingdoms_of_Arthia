package CodeWorX.KingdomsofArthia.player;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;

import CodeWorX.KingdomsofArthia.environment.Map;
import CodeWorX.KingdomsofArthia.environment.javaMaps;
import CodeWorX.KingdomsofArthia.mainSystem.Item;
import CodeWorX.KingdomsofArthia.mainSystem.ItemSystem;
import CodeWorX.KingdomsofArthia.npc.NpcSystem;

public class drawPlayer {
	// one player sprite grid = 32 x 32 = 4 tiles
	final int playerW = 32;
	final int playerH = 32;
	final int totalAmountItems = 10;
	int walkint,walkintDelay,walkintDelayOffset;
//	int wearItems[] = new int[totalAmountItems];
	ArrayList<Item> wearItems = ItemSystem.wearItems;
	Image itemImages[] = new Image[totalAmountItems];
	Image playerImg;
	int direction;
	NpcSystem NS = new NpcSystem();
	public drawPlayer() {
		// initializing walking
		walkint = 0;
		walkintDelay = 0;
		walkintDelayOffset = 9;
		playerImg = Toolkit.getDefaultToolkit().getImage("src/CodeWorX/Images/player/Male1.png");
		//ItemSystem.equip(new Item("Test",true,1,1,3));
		System.out.println(javaMaps.map3.length + ","+javaMaps.map3[0].length);
	//	new Map(null);
	}
	
	public void draw(Graphics g,int x, int y, int direction) {
		
		int dir = redoDir(direction);
		g.drawImage(playerImg, x, y, x+playerW, y+playerH, 0+32*walkint, 0+32*dir, 0+32*walkint+32, 0+32*dir+32, null);
		for(int images = 0; images < wearItems.size(); images++) {
			itemImages[wearItems.get(images).getType()] = wearItems.get(images).getImage();
		}
		for(int item = 0; item < wearItems.size(); item++) {
			g.drawImage(itemImages[item], x, y, x+playerW, y+playerH, 0+32*walkint, 0+32*dir, 0+32*walkint+32, 0+32*dir+32, null);
		}
		NS.drawNpcs(g);
	}
	public int redoDir(int dir) {
		switch(dir) {
		case 1:return 3;
		case 2:return 2;
		case 3:return 0;
		case 4:return 1;
			default: return 0;
		}
	}
	public int getWidth() {
		return playerW;
	}
	public int getHeight() {
		return playerH;
	}
	public void updateWalkInt() {
		if(walkintDelay >= walkintDelayOffset) {
			walkintDelay = 0;
		
		if(walkint >= 2)
			walkint = 0;
		else 
			walkint++;
		} else {
			walkintDelay++;
		}
	}
	public void resetWalkInt() {
		walkint = 0;
	}
	
}
