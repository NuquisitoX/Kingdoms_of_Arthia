package CodeWorX.KingdomsofArthia.player;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import CodeWorX.KingdomsofArthia.mainSystem.Main;

/**
*
* @author Joshua Jenster, Nordin H
* 
*/


public class Player {
	// collision tiles: 1st one is a list of damaging tiles, 2nd for non damaging. // has to be implemented
	public static int damageTiles[] = {3};
	public static int collisionTiles[] = {3,4};
	drawPlayer player = new drawPlayer();
	public int x,y,spawnX,spawnY;
	int height,width;
	public static int maxhealth = 200, health = 200 ,speed = 1;
	public double healthbar, mhealth, heal;
	public int direction; // 1 = north 2 = east 3 = south 4 = west
	int gender; // 0 = male 1 = female
	double sizeOffset = 1;
	boolean swim;
	Color col;
	public int XplayerOnMap, YplayerOnMap;
	Font myFont;
	
	public Player(int x, int y){
		this.x = x;
		this.y = y;
		spawnX = x;
		spawnY = y;
		gender = 0;
		direction = 3;
		health = 200;
		maxhealth = 200;
		heal = mhealth = 200;
		myFont = new Font("Arial", Font.PLAIN, 8);
	}
	public int getWidth() {
		return player.getWidth();
	}
	public int getHeight() {
		return player.getHeight();
	}
	public void setSize(double size) {
		sizeOffset = size;
	}
	public double getSize() {
		return sizeOffset;
	}
	public void draw(Graphics g){
		int xSize = (int) (getWidth()*sizeOffset);
		int ySize = (int) (getHeight()*sizeOffset);
		
		player.draw(g, x, y, direction);
		g.drawString("Player 1, " + x + "," + y, x - 14, y - 10);
		
		g.setColor(Color.YELLOW);
		//g.drawRect(x,y+player.getHeight()-16,player.getWidth(),16);
		updatePlayer();
	}
	public void updatePlayer() {
	}
	public void die() {
			Main.gp.updatePlayerCoords();
			heal = mhealth;
			gender = 0;
			health = 200;
	}
	public void moveUp(){
		if(swim){
			direction = 5;
			heal++;
		} else {
			direction = 1;
		}
		player.updateWalkInt();
	}
	public void moveLeft(){
		if(swim){
			direction = 8;
			heal++;
		} else {
			direction = 4;
		}
		player.updateWalkInt();
	}
	public void moveDown(){
		if(swim){
			direction = 7;
			heal++;
		} else {
			direction = 3;
		}
		player.updateWalkInt();
	}
	
	public void moveRight(){
		if(swim){
			direction = 6;
			heal++;
		} else {
			direction = 2;
		}
		player.updateWalkInt();
	}
	public void resetWalkInt() {
		player.resetWalkInt();
	}
	public void swim(boolean swimming){
		swim = swimming;
	}
	
	public int returnX(){
		return x;
	}
	
	public int returnY(){
		return y;
	}
	
	public void setX(int x){
		this.x = x;
	}
	
	public void setY(int y){
		this.y = y;
	}
	
	public int returnSpeed(){
		return speed;
	}
	
	public int returnTopY(){
		int topY = -Main.gp.mapY + returnY() + (getHeight() - 16);
		return topY;
	}
	
	public int returnLeftX(){
		int leftX = -Main.gp.mapX + returnX();
		return leftX;		
	}
	
	public int returnBotY(){
		int botY = -Main.gp.mapY + returnY() + getHeight();
		return botY;
	}
	
	public int returnRightX(){
		int rightX = -Main.gp.mapX + returnX() + getWidth();
		return rightX;	
	}
	
	
	
	public boolean collision(int Xplayer, int Yplayer, int dir, int[][] map){
		boolean coll = false;
		switch(dir){
		case 1: // keyW
			// Map boundary collision detection
			if(returnTopY() - speed <= 0){
				coll = true;
			}
			
			// Tile collision detection
			for(int x = 0; x < collisionTiles.length; x++) { // collisionTiles[x]
			if(map[Math.round((returnTopY() - speed)/16)][Math.round(returnLeftX()/16)] == collisionTiles[x]){
				coll = true;
				 
			}
			if(map[Math.round((returnTopY() - speed)/16)][Math.round(returnRightX()/16)] == collisionTiles[x]){
				coll = true;
				 
			}
			}
			return coll;
		case 2: // keyA
			// Map boundary collision detection
			if(returnLeftX() - speed <= 0){
				coll = true;
			}
			
			for(int x = 0; x < collisionTiles.length; x++) { // collisionTiles[x]
			if(map[Math.round(returnTopY()/16)][Math.round((returnLeftX() - speed)/16)] == collisionTiles[x]){
				coll = true;
				 
			}
			if(map[Math.round(returnBotY()/16)][Math.round((returnLeftX() - speed)/16)] == collisionTiles[x]){
				coll = true;
				 
			}
			}
			return coll;
		case 3: // keyS
			// Map boundary collision detection
			if(returnBotY() + speed >= map.length*16){
				coll = true;
			}
			
			for(int x = 0; x < collisionTiles.length; x++) { // collisionTiles[x]
			if(!(returnBotY() + speed >= map.length*16)){
				if(map[Math.round((returnBotY() + speed)/16)][Math.round(returnLeftX()/16)] == collisionTiles[x]){
					coll = true;
					 
				}
				if(map[Math.round((returnBotY() + speed)/16)][Math.round(returnRightX()/16)] == collisionTiles[x]){
					coll = true;
					
				}
			}
			}
			return coll;
		case 4: // keyD
			// Map boundary collision detection
			if(returnRightX() + speed >= map[0].length*16){
				coll = true;
			}
			
			for(int x = 0; x < collisionTiles.length; x++) { // collisionTiles[x]
			if(!(returnRightX() + speed >= map[0].length*16)){
				if(map[Math.round(returnBotY()/16)][Math.round((returnRightX() + speed)/16)] == collisionTiles[x]){
					coll = true;
				}
			}
			}
			return coll;		
		}
		return coll = false;
	}
	
	
}
