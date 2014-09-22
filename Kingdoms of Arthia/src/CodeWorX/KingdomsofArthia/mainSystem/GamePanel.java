/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package CodeWorX.KingdomsofArthia.mainSystem;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferStrategy;

import CodeWorX.KingdomsofArthia.player.*;
import CodeWorX.KingdomsofArthia.Interfaces.InterfaceSystem;
import CodeWorX.KingdomsofArthia.environment.*;

/**
*
* @author Joshua Jenster, Nordin H
* 
*/
public class GamePanel extends Canvas {
	private static final long serialVersionUID = 1L;
	
	KeyMethod KeyInput = new KeyMethod();
	MouseMethod MouseInput = new MouseMethod();
	static InterfaceSystem interfaceSystem = new InterfaceSystem();
	public MapSystem MapSys = new MapSystem();

	
	Graphics grMap;
	Image iMap;
	public int mapX, mapY;
	int mapWidth = 64;
	int mapHeight = 45;
	public int map[][] = MapSys.getMap();
	int mapIn[][] = new int[64][45];
	public static Player player = new Player(0,0);
	
	boolean staticPainted = false;
	static Graphics gr;
	public static chatBox chatbox;
	boolean firstUp = false;
	public int XplayerOnMap, YplayerOnMap;
	
    public GamePanel() {
    	setPreferredSize(new Dimension(Main.width, Main.height));
    	addKeyListener(KeyInput);
    	addMouseListener(MouseInput);
    	addMouseMotionListener(MouseInput);
    	setFocusable(true);
    }
    public void Render() {
    		BufferStrategy bs = getBufferStrategy();
    		if(bs == null){
    			createBufferStrategy(3);
    			return;
    		}
    		Graphics g = bs.getDrawGraphics();
	    	if(!firstUp){
				updatePlayerCoords();
				UpdateMap();
				firstUp = true;
				UpdateMap();
			}
    		drawBackground(g);
    		//paintMapTest(g);
    		g.drawImage(iMap, mapX, mapY, this);
    		player.draw(g);
    		//chatbox.drawMessages(g);
    		//g.drawString("Press M for MapEditor", 400, 400);
    		interfaceSystem.drawInterfaces(g);
    		
    		g.dispose();
    		bs.show();
    }
    
    public void update(){
   
    	// Player Updater
    	XplayerOnMap = (int) (-mapX + player.returnX() + player.getWidth()/2);
    	YplayerOnMap = (int) (-mapY + player.returnY() + player.getHeight());
    	
    	// Map Updater
    	if(KeyInput.keyW && !player.collision(XplayerOnMap, YplayerOnMap, 1, map)){ mapY += player.returnSpeed(); player.moveUp(); }
    	if(KeyInput.keyA && !player.collision(XplayerOnMap, YplayerOnMap, 2, map)){ mapX += player.returnSpeed(); player.moveLeft(); }
    	if(KeyInput.keyS && !player.collision(XplayerOnMap, YplayerOnMap, 3, map)){ mapY -= player.returnSpeed(); player.moveDown();}
    	if(KeyInput.keyD && !player.collision(XplayerOnMap, YplayerOnMap, 4, map)){ mapX -= player.returnSpeed(); player.moveRight(); }
    	if(KeyInput.keyY){ player.heal--; }
    }
    
    public void UpdateMap(){
    	map = MapSys.getMap();
		iMap = createImage(map[0].length*16, map.length*16);
		grMap = iMap.getGraphics();
		paintMap(grMap);
    }
    
    public int getXplayeronMap() {
    	return (int) (-mapX + player.returnX() + player.getWidth()/2);
    }
    public int getYplayeronMap() {
    	return (int) (-mapY + player.returnY() + player.getHeight());
    }
    public void updatePlayerCoords() {
    	player.setX(Main.width/2 - player.getWidth()/2);
    	player.setY(Main.height/2 - player.getHeight());
    }
    
    public void paintMap(Graphics g) {
    	Image tiles = Toolkit.getDefaultToolkit().getImage("src/CodeWorX/Images/main/tileSet1.png");
    	for(int x = 0; x < map.length; x++) {
    		for(int y = 0; y < map[0].length; y++) {	
    			g.drawImage(tiles, 0+16*y, 0+16*x, 16+16*y, 16+16*x, 0+16*map[x][y], 0, 16+16*map[x][y], 16, this);
    		}
    	}
    }
    
    public void drawBackground(Graphics g){
    	g.setColor(Color.BLACK);
    	g.fillRect(0, 0, Main.gp.getWidth(), Main.gp.getHeight());
    }
    
    public void teleport(){
    	if(player.XplayerOnMap < 30){
    		mapX = -500;
    		mapY = 250;
    	}
    }

}
