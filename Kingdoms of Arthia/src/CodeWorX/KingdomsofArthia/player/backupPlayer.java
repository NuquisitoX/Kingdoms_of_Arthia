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


public class backupPlayer {
	// collision tiles: 1st one is a list of damaging tiles, 2nd for non damaging. // has to be implemented
	int damageTiles[] = {2};
	int collisionTIles[] = {};
	drawPlayer player = new drawPlayer();
	public int x,y,spawnX,spawnY;
	int height,width;
	public int maxhealth = 200, health = 200 ,speed = 5;
	public double healthbar, mhealth, heal;
	public int direction; // 1 = north 2 = east 3 = south 4 = west
	int gender; // 0 = male 1 = female
	double sizeOffset = 1;
	boolean swim;
	Image charSpriteSet[] = new Image[10];
	Image charBodySprites[] = new Image[4];
	Color col;
	public int XplayerOnMap, YplayerOnMap;
	Font myFont;
	
	public backupPlayer(int x, int y){
		this.x = x;
		this.y = y;
		spawnX = x;
		spawnY = y;
		charBodySprites[1] = Toolkit.getDefaultToolkit().getImage("src/CodeWorX/Images/player/head.png");
		charBodySprites[2] = Toolkit.getDefaultToolkit().getImage("src/CodeWorX/Images/player/body.png");
		charSpriteSet[1] = Toolkit.getDefaultToolkit().getImage("src/CodeWorX/Images/player/playerN.png");
		charSpriteSet[2] = Toolkit.getDefaultToolkit().getImage("src/CodeWorX/Images/player/playerE.png");
		charSpriteSet[3] = Toolkit.getDefaultToolkit().getImage("src/CodeWorX/Images/player/playerS.png");
		charSpriteSet[4] = Toolkit.getDefaultToolkit().getImage("src/CodeWorX/Images/player/playerW.png");
		
		charSpriteSet[5] = Toolkit.getDefaultToolkit().getImage("src/CodeWorX/Images/player/playerNswim.png");
		charSpriteSet[6] = Toolkit.getDefaultToolkit().getImage("src/CodeWorX/Images/player/playerEswim.png");
		charSpriteSet[7] = Toolkit.getDefaultToolkit().getImage("src/CodeWorX/Images/player/playerSswim.png");
		charSpriteSet[8] = Toolkit.getDefaultToolkit().getImage("src/CodeWorX/Imagesplayer//playerWswim.png");
		gender = 0;
		direction = 3;
		health = 200;
		maxhealth = 200;
		heal = mhealth = 200;
		myFont = new Font("Arial", Font.PLAIN, 8);
	}
	public Image getImage(int direction) {
		return charSpriteSet[direction];
	}
	public int getWidth() {
		return charSpriteSet[direction].getWidth(null);
	}
	public int getHeight() {
		return charSpriteSet[direction].getHeight(null);
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
		
		g.drawImage(charSpriteSet[direction], x,y,xSize,ySize,null);
		g.drawString("Player 1, " + x + "," + y, x - 14, y - 10);
		g.setColor(Color.RED);
		healthbar = (heal/mhealth) * 42;
		
		g.fillRect(x - 14, y - 6, (int)healthbar, 10);
		g.setColor(Color.WHITE);
		g.setFont(myFont);
		g.drawString((int)heal + "/" + (int)mhealth, x - 5, y);
		g.setColor(Color.YELLOW);
		g.drawRect(x,y+getHeight()-16,getWidth(),16);
		updatePlayer();
	}
	public void updatePlayer() {
		if(healthbar <= 0) {
			die();
		}
	}
	public void setImage(String s, int direction){
		charSpriteSet[direction] = Toolkit.getDefaultToolkit().getImage(s);
	}
	public void die() {
			Main.gp.updatePlayerCoords();
			heal = mhealth;
			direction = 3;
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
	}
	public void moveLeft(){
		if(swim){
			direction = 8;
			heal++;
		} else {
			direction = 4;
		}
	}
	public void moveDown(){
		if(swim){
			direction = 7;
			heal++;
		} else {
			direction = 3;
		}
	}
	
	public void moveRight(){
		if(swim){
			direction = 6;
			heal++;
		} else {
			direction = 2;
		}
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
			if(returnTopY() - speed < 0){
				coll = true;
				if(returnTopY() > 0 ){
					Main.gp.mapY += (returnTopY() - 0);
				}
			}
			
			// Tile collision detection
			if(map[Math.round((returnTopY() - speed)/16)][Math.round(returnLeftX()/16)] == 2){
				coll = true;
				heal--;
			}
			if(map[Math.round((returnTopY() - speed)/16)][Math.round(returnRightX()/16)] == 2){
				coll = true;
				heal--;
			}
			return coll;
		case 2: // keyA
			// Map boundary collision detection
			if(returnLeftX() - speed < 0){
				coll = true;
				if(returnLeftX() > 0 ){
					Main.gp.mapX += (returnLeftX() - 0);
				}
			}
			
			// Tile collision detection
			if(map[Math.round(returnTopY()/16)][Math.round((returnLeftX() - speed)/16)] == 2){
				coll = true;
				heal--;
			}
			if(map[Math.round(returnBotY()/16)][Math.round((returnLeftX() - speed)/16)] == 2){
				coll = true;
				heal--;
			}
			return coll;
		case 3: // keyS
			// Map boundary collision detection
			if(returnBotY() + speed > map.length*16){
				coll = true;
				if(map.length*16 - returnBotY() > 0 ){
					Main.gp.mapY -= (map.length*16 - returnBotY());
				}
			}
			
			// Tile collision detection
			if(!(returnBotY() + speed >= map.length*16)){
				if(map[Math.round((returnBotY() + speed)/16)][Math.round(returnLeftX()/16)] == 2){
					coll = true;
					heal--;
				}
				if(map[Math.round((returnBotY() + speed)/16)][Math.round(returnRightX()/16)] == 2){
					coll = true;
					heal--;
				}
			}
			return coll;
		case 4: // keyD
			// Map boundary collision detection
			if(returnRightX() + speed > map[0].length*16){
				coll = true;
				if(map[0].length*16 - returnRightX() > 0 ){
					Main.gp.mapX -= (map[0].length*16 - returnRightX());
				}
			}
			
			// Tile collision detection
			if(!(returnRightX() + speed >= map[0].length*16)){
				if(map[Math.round(returnBotY()/16)][Math.round((returnRightX() + speed)/16)] == 2){
					coll = true;
					heal--;
				}
				if(map[Math.round(returnTopY()/16)][Math.round((returnRightX() + speed)/16)] == 2){
					coll = true;
					heal--;
				}
			}
			return coll;		
		}
		return coll = false;
	}
	
	
}
