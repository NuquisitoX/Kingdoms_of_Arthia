package CodeWorX.KingdomsofArthia.mainSystem;

import java.awt.Image;
import java.awt.Toolkit;

/**
*
* @author Joshua Jenster
* 
*/

public class Item {
		
		 String name;
		boolean equipment;
		int type,stackAmount,id;
		Image itemImage;
		String itemType;
		final int helm = 0,body = 1,legs = 2,gloves =3,boots =4,shoulders=5,cape=6;
		//item type values: helm = 0,body = 1,legs = 2,gloves =3,boots =4,shoulders=5,cape=6;
		// the items types have to be in order, the highest value = top on draw
	public Item(String name, boolean equipment, int type,int stackAmount,int id) {
		this.name = name;
		this.equipment = equipment;
		this.type = type;
		this.stackAmount = stackAmount;
		this.id = id;
	}
	public Item(String name, boolean equipment, String type,int stackAmount,int id) {
		this.name = name;
		this.equipment = equipment;
		this.itemType = type;
		this.stackAmount = stackAmount;
		this.id = id;
		checkItemType(true);
		setImage();
	}
	public void checkItemType(boolean useString) {
		if(useString) {
			switch (itemType) {
			case"HELM":type=helm;break;
			case"BODY":type=body;break;
			case"LEGS":type=legs;break;
			case"GLOVES":type=gloves;break;
			case"BOOTS":type=boots;break;
			case"SHOULDERS":type=shoulders;break;
			case"CAPE":type=cape;break;
			}
		}
	}
	public void setImage() {
		if(equipment) {
			itemImage = Toolkit.getDefaultToolkit().getImage("src/CodeWorX/Images/items/armor/"+ id +".png");
		} else {
			itemImage = Toolkit.getDefaultToolkit().getImage("src/CodeWorX/Images/items/"+ id +".png");
		}
	}
	public String getName() {
		return name;
	}
	public boolean isEquipment() {
		return equipment;
	}
	public int getType() {
		return type;
	}
	public int getStackAmount() {
		return stackAmount;
	}
	public Image getImage() {
		if(equipment) {
		itemImage =	Toolkit.getDefaultToolkit().getImage("src/CodeWorX/Images/items/armor/"+ id +".png");
		}
			return itemImage;
	}
	
}
