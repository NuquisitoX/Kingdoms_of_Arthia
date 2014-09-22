package CodeWorX.KingdomsofArthia.Interfaces;

import java.awt.Graphics;

import CodeWorX.KingdomsofArthia.player.Inventory;

/**
*
* @author Joshua Jenster
* 
*/

public class InterfaceSystem {
	public static ChatboxInterface chatboxInterface;
	public static Inventory inventory = new Inventory();
	public InterfaceSystem() {
		chatboxInterface = new ChatboxInterface();
	}
	public void drawInterfaces(Graphics g) {
		chatboxInterface.drawInterface(g);
		inventory.drawInventory(g);
	}
	public static void addMessage(String message, String name, String color) {
		chatboxInterface.chatbox.addMessage(message, name, color);
	}
	public static boolean getTypeOpen() {
		return chatboxInterface.typeBoxActive;
	}
	public static void updateTypeOpen(boolean update) {
		chatboxInterface.typeBoxActive(update);
	}
}
