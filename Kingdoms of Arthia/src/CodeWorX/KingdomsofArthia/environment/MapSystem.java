package CodeWorX.KingdomsofArthia.environment;

import java.util.ArrayList;
import java.util.Random;

/**
*
* @author Joshua Jenster, Nordin H
* 
*/


public class MapSystem {
	public static int[][] map;
	boolean mapG;
	boolean createMap = false;
	public static int currentTile = 0,currentMapIn = 0;
	public static ArrayList<Map> Maps = new ArrayList<Map>();
	
	public MapSystem(){
		Maps.add(new Map(javaMaps.map3,200,200)); //default map
	//	Maps.add(new Map(javaMaps.map1)); // map 1
	//	Maps.add(new Map(javaMaps.map2)); // map 2
	//	Maps.add(new Map(javaMaps.map3)); // map 3
		
		if(createMap) {									// visueel gezien, dit zal een blank map outputten van grass
		map = new int[45][63];
		for(int x = 0; x < map.length; x++){
			System.out.print("{");
			for(int y = 0; y < map[x].length; y++){
				map[x][y] = 0;
				System.out.print(map[x][y] + ",");
				
			}
			System.out.print("}," + "\n");
			
		}
		}
		
	}
	public static void loadMap(int id) {
		map = Maps.get(id).getMap();
		System.out.println("Map loaded: " + id);
		currentMapIn = id;
	}
	public static void createMap(int map[][]) {
	//	Maps.add(new Map(map));
		System.out.println("The size of the map array is now: " + Maps.size());
	}
	public int[][] getMap() {
		return Maps.get(currentMapIn).getMap();
	}
	public void outputMap() {									//maakt van de current map een system.out.print die gebruikt kan worden
		for(int x = 0; x < getMap().length; x++){					// in de map[][]
			System.out.print("{");
			for(int y = 0; y < getMap()[x].length; y++){
			//	map1[x][y] = 0;
				System.out.print(getMap()[x][y] + ",");
				
			}
			System.out.print("}," + "\n");
			
		}
	}
	
}