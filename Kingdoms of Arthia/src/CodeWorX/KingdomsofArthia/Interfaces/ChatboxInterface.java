package CodeWorX.KingdomsofArthia.Interfaces;

import java.awt.Graphics;
import java.awt.Rectangle;

import CodeWorX.KingdomsofArthia.mainSystem.chatBox;

public class ChatboxInterface {
	
	public int startX;
	public int startY;
	public int width;
	public int height;
	public String title;
	public boolean active;
	public static boolean typeBoxActive = false;
	public static int tbX = 1,tbY = 670;
	static chatBox chatbox = new chatBox();
	private static Rectangle typeBox = new Rectangle(300,25);
	typeInterface type = new typeInterface();
	public ChatboxInterface() {
		this.startX = 1;
		this.startY = 560;
		this.width = 300;
		this.height = 200;
		this.title = "CHATBOX";
		active = true;
		
		
	}
	public void drawInterface(Graphics g) {
		if(active) {
		g.drawRect(startX, startY, width, height);
		chatbox.drawMessages(g);
		type.drawInterface(g);
		
			if(typeBoxActive) {
				updateType();
			} else {
				updateType();
			}
			
		}
		
	}
	private void updateType() {
		if(typeBoxActive == false) {
		if(type.yCoord <= 700) {
		type.setY(type.getY() +2);
		}
		} else {
			if(type.yCoord > 676) {
				type.setY(type.getY() - 2);
				}
		}
	}
	public static void typeBoxActive(boolean active) {
		typeBoxActive = active;
	}
	public static chatBox getChatBox() {
		return chatbox;
	}
	public int getX() {
		return startX;
	}
	public int getY() {
		return startY;
	}
	public int getWidth() {
		return width;
	}
	public int getHeight() {
		return height;
	}
	public String getTitle() {
		return title;
	}
	public boolean getActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
}
