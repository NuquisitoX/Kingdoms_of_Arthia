/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package CodeWorX.KingdomsofArthia.mainSystem;

import javax.swing.JFrame;

/**
 *
 * @author Joshua Jenster, Nordin N
 * 
 */
public class Main implements Runnable{ 
	
	//Main initialize
	
	public static JFrame GameFrame = new JFrame();
    public static int width = 1000,height = 700;

    public static GamePanel gp = new GamePanel();
    public boolean running = true;
    
    private Thread thread;
    
	//end of Main inittialze
    public static final String version = "v0.0.5";
    
    public synchronized void start(){
    	running = true;
    	thread = new Thread(new Main(), "My Thread");
        thread.start();
    }
    
    public synchronized void stop(){
    	running = false;
    	try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
    }
   
    @Override
	public void run() {
		// TODO Auto-generated method stub
		long lastTime = System.nanoTime();
		long timer = System.currentTimeMillis();
		final double nsUps = 1000000000.0/60.0;
		final double nsFps = 1000000000.0/200.0;
		double deltaUps = 0, deltaFps = 0;
		int frames = 0;
		int updates = 0;
				
		while(running) {
			long now = System.nanoTime();
			deltaUps += (now - lastTime)/ nsUps;
			deltaFps += (now - lastTime)/ nsFps;
			lastTime = now;
			while(deltaUps >= 1){
				gp.update();
				updates++;
				deltaUps--;
			}
			while(deltaFps >= 1){
				gp.Render();
				frames++;
				deltaFps--;
			}			
			
			if(System.currentTimeMillis() - timer > 1000){
				timer += 1000;
				GameFrame.setTitle("Kingdoms of Arthia " + version + " | " + updates + " ups, " + frames + " fps");
				updates = 0;
				frames = 0;
			}
		}	
	}    
    
    public static void main(String[] args) {
    	Main main = new Main();
        GameFrame.setResizable(false);
        GameFrame.setTitle("Kingdoms of Arthia " + version);
        GameFrame.add(gp);
        GameFrame.pack();
        GameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GameFrame.setLocationRelativeTo(null);
        GameFrame.setVisible(true);
        GameFrame.validate();
        
        main.start();
    }
}
