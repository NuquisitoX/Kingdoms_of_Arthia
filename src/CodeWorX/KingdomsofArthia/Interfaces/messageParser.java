package CodeWorX.KingdomsofArthia.Interfaces;

import java.awt.Color;

import CodeWorX.KingdomsofArthia.mainSystem.GamePanel;
import CodeWorX.KingdomsofArthia.mainSystem.Main;
import CodeWorX.KingdomsofArthia.player.Player;

public class messageParser {
		static Player player = GamePanel.player;
		static String color;
		private static String cd = "/"; // cheat detection
		private static String outputColor = "BLUE";
		private static String cheatTitle = "Cheat";
	public messageParser() {
		
	}
	public static void parseMessage(String message,String title) {
		switch(title) {
		case "System":
			color = "RED";
			break;
		case "Player":
			color = "GREEN";
			break;
		}
		if(message.length() > 0) {
			InterfaceSystem.addMessage(message, title, color);
		}
		checkCheat(message);
	}
	public static void checkCheat(String message) {
		boolean cheat = false;
		String tok[] = message.split(" ");
		
		if(message.equals(cd + "test")) {
			System.out.println("works");
			InterfaceSystem.addMessage("The cheat test was succesful!", cheatTitle, outputColor);
		}
		else if(message.startsWith(cd + "hp")) {
			player.heal = Integer.parseInt(tok[1]);
		}
		if(message.startsWith(cd)) {
		InterfaceSystem.addMessage("Cheat succesful!", cheatTitle, outputColor);
		}
	}
	
}
