package CodeWorX.KingdomsofArthia.npc;

import java.awt.Graphics;
import java.util.ArrayList;

public class NpcSystem {
	
	ArrayList<Npc> npcList = new ArrayList<Npc>();
	ArrayList<Shop> shopList = new ArrayList<Shop>();
	ArrayList<Boss> bossList = new ArrayList<Boss>();
	public NpcSystem() {
		initialize();
	}
	
	public void initialize() {
		addNpc("NPC",1,1000,1000);
		addNpc("NPC",1,900,900);
		addNpc("NPC",1,800,800);
		addNpc("NPC",1,700,700);
		addNpc("NPC",1,600,600);
		addNpc("NPC",1,500,500);
		addNpc("NPC",1,400,400);
		
	}
	public void addNpc(String type,int id, int x, int y) {
		switch (type) {
		case "NPC": npcList.add(new Npc(id,x,y));break;
		case "SHOP": shopList.add(new Shop());break;
		case "BOSS": bossList.add(new Boss());break;
		}
	}
	
	public void drawNpcs(Graphics g) {
		for(int x = 0; x <npcList.size(); x++) {
			npcList.get(x).drawNpc(g);
		}
	}
	
}
