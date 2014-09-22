package CodeWorX.KingdomsofArthia.mainSystem;

import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;
import CodeWorX.KingdomsofArthia.player.*;

/**
*
* @author Joshua Jenster
* 
*/

public class ItemSystem {
	
	public static ArrayList<Item> allItems = new ArrayList<Item>();
	public static ArrayList<Item> wearItems = new ArrayList<Item>();
	
	public ItemSystem() {
		
	}
	public static void addItem(String name, boolean equipment, int type, int stackAmount, int id) {
		allItems.add(new Item(name, equipment, type, stackAmount, id));
	}
	public static void addItem(String name, boolean equipment, String type, int stackAmount, int id) {
		allItems.add(new Item(name, equipment, type, stackAmount, id));
	}
	public static void equip(Item item) {
		if(item.isEquipment()) {
		wearItems.add(item);
		}
	}
	public static Image getImage(int id) {
		return Toolkit.getDefaultToolkit().getImage("src/CodeWorX/Images/items/"+id+".png");
	}
	public static boolean canWear(int id) {
		
		return true;
	}
}	
