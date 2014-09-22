package CodeWorX.KingdomsofArthia.Interfaces;

import java.awt.Color;
import java.awt.Graphics;

import CodeWorX.KingdomsofArthia.mainSystem.KeyMethod;

public class typeInterface {
	int xCoord,yCoord,width,height;
	public typeInterface() {
		xCoord = 1;
		yCoord = 676;
		width = 300;
		height = 25;
	}
	public void setX(int x) {
		xCoord = x;
	}
	public void setY(int y) {
		yCoord = y;
	}
	public void drawInterface(Graphics g) {
		g.setColor(new Color(0,162,232,150));
		g.fillRect(xCoord, yCoord, width, height);
		g.setColor(Color.black);
		g.drawRect(xCoord, yCoord, width, height);
		g.drawString(KeyMethod.message, 5, 695);
		
	}
	public int getY() {
		return yCoord;
	}
}
