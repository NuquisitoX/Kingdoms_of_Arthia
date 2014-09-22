package CodeWorX.KingdomsofArthia.environment;

import java.util.Random;

public class Map {
	int width,height;
	int map[][];
	public Map(int map[][],int width,int height) {
		this.width = width;
		this.height = height;
		if(map == null) 
			generate();
		else
			this.map = map;
	}
	
	public void generate() {
		map = new int[height][width];
		int rand = new Random().nextInt(map.length - 1);
		for(int x = 0; x < map.length; x++){
			for(int y = 0; y < map[x].length; y++){
				map[x][y] = 0;
			}
		}
		createLake(height-2,width-2,2,2,3,100);
		javaMaps.map3 = map;
		//outputMap();
	}
	public int getHeight() {
		return height;
	}
	public int getWidth() {
		return width;
	}
	public void createLake(int mapW, int mapH, int tile, int maxDist, int size, int steps) {

		int startX = new Random().nextInt(mapW-15)+15,startY = new Random().nextInt(mapH-15)+15, currentX=0, currentY=0, offset =2;
		boolean initialize = true;
		
		for(int x = 0; x < steps; x++) {
					int minX = new Random().nextInt(2),minY = new Random().nextInt(2);
					int tX=new Random().nextInt(maxDist)+1,tY=new Random().nextInt(maxDist)+1;
					int newSource //new Random().nextInt(50) = 2;
							=2;
					if(newSource == 1) {
						startX=new Random().nextInt(50)+15;
						startY=new Random().nextInt(50)+15;
					}
					if(minX == 1) {
					startX += tX;
					} else {
						startX -=tX;
					}
					if(minY == 1) {
						startY += tY;
					} else {
						startY -= tY;
					}
			if(startX > 2 && startY > 2 && startX < mapW-2 && startY < mapH-2) {
				for(int i=0;i<=size;i++)
				{
				    for(int j=i-size;j<=size-i;j++)
				    {
				        map[startX+i][startY+j]=tile;
				        map[startX-i][startY+j]=tile;
				    }
				}
			
			} else {
				startX=new Random().nextInt(mapW-15)+15;
				startY=new Random().nextInt(mapH-15)+15;
			}
		}
	}
	public void outputMap() {							//maakt van de current map een system.out.print die gebruikt kan worden
		for(int x = 0; x < getMap().length; x++){					// in de map[][]
			System.out.print("{");
			for(int y = 0; y < getMap()[x].length; y++){
				System.out.print(getMap()[x][y] + ",");
				
			}
			System.out.print("}," + "\n");
			
		}
	}
	public int[][] getMap() {
		return map;
	}
	
}
