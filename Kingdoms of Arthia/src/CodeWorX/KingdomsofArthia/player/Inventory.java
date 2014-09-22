package CodeWorX.KingdomsofArthia.player;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.Random;

import CodeWorX.KingdomsofArthia.mainSystem.ItemSystem;

/**
*
* @author Joshua Jenster
* 
*/

public class Inventory {
	//inventory coords info
		private int invX, invY;
		private final int slotW = 42, slotH = 42;
		private final int slotXInterval = 3,slotYInterval = 3;
		private final int topXCoord = 4,topYCoord = 4;
	// end of coords
	// general inv info
		private int rows = 4; //rows is horizontal
		private int colums = 7; // colums is vertical
		private final int slots = rows * colums; //amount of items held in the inventory
		private int inventory[] = new int[slots]; //the items will be stored here, and drawn depending on the value in here
	// end of general info
		private boolean inventoryOpen;
		private Image inventImg = Toolkit.getDefaultToolkit().getImage("src/CodeWorX/Images/main/inventory.png");
		Random rand = new Random();
		
	public Inventory() {
		for(int x = 0; x < inventory.length;x++) {
			inventory[x] = rand.nextInt(2); //to eliminate all the 'null' values
		}
		invX = 768; //dummy values
		invY = 64; //dummy values
		inventoryOpen = false;

	}
	
	public void drawInventory(Graphics g) {
		if(inventoryOpen) {
		g.drawImage(inventImg, invX, invY, null);
		int offsetsX[] = new int[slots];
		int offsetsY[] = new int[slots];
		int tempX = 0,tempY = 0;
		for(int y = 0; y < inventory.length; y++) {
			if(inventory[y] != -1) {
			offsetsX[y] = (slotW - ItemSystem.getImage(inventory[y]).getWidth(null))/2;
			offsetsY[y] = (slotH - ItemSystem.getImage(inventory[y]).getHeight(null))/2;
			}
		}
		for(int x = 0; x < inventory.length; x++) {
			if(inventory[x] != -1) {
		g.drawImage(ItemSystem.getImage(inventory[x]),invX+topXCoord+slotXInterval*tempX+slotW*tempX + offsetsX[x],invY+topYCoord+slotYInterval*tempY+slotH*tempY + offsetsY[x],null);
			}
		tempX++;
		if(tempX == 4) {
			tempX = 0;
			tempY++;
		}
		
		}
		}
	}
	public void open() {
		inventoryOpen = true;
	}
	public void close() {
		inventoryOpen = false;
	}
	public int getX() {
		return invX;
	}
	public int getY() {
		return invY;
	}
	public int[] getInvetory() {
		return inventory;
	}
	public int getItemAt(int slot) {
		return inventory[slot];
	}
	public int getSlotAmount() {
		return slots;
	}
	public boolean getOpen() {
		return inventoryOpen;
	}
	
}
