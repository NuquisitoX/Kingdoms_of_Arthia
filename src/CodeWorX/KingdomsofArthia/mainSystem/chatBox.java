
package CodeWorX.KingdomsofArthia.mainSystem;

import java.awt.*;
import java.util.*;

/**
*
* @author Joshua Jenster, Brett
* 
*/

public class chatBox {

    public static ArrayList<String> messages;
    static int offset = 0;
	private static int startX = 5;
	private static int startY = 575;
    private static int messagesAtOnce = 8;
    private static int maxLength = 900;

    public chatBox()
    {
        messages  = new ArrayList<String>();
    }

    public void tick()
    {
        long currentTime = System.currentTimeMillis();

        for (int i=0; i < messages.size(); i++)
        {
            String tok[] = messages.get(i).split(":");
            long time = Long.parseLong(tok[0]);

            if (currentTime - time > maxLength * 1000)
            {
                removeMessage(i);
            }
        }
    }

    public static void addMessage(String newMessage, String name,String color)
    {
    	
        messages.add(System.currentTimeMillis() +":"+color+":["+name+"]: " + newMessage);

        if (messages.size() > messagesAtOnce)
            offset++;
    }

    private void removeMessage(int index)
    {
        messages.remove(index);

        if (messages.size() > messagesAtOnce)
            offset--;
    }
    
    
    public static void incOff() {
    	offset++;
    	if(offset + messagesAtOnce > messages.size()) {
    		offset--;
    	}
    }
    public static void decOff() {
    	offset--;
    	if(offset < 0) {
    		offset++;
    	}
    }
    

    public static void drawMessages(Graphics g)
    {
        g.setFont(new Font("Arial", Font.PLAIN, 12));

    	if (messages.size() > messagesAtOnce)        {
    		
            for (int i=0; i < messagesAtOnce; i++)
            {
            	String tok[] = messages.get(i+offset).split(":");
            	if(tok[1].equals("GREEN"))  {
            		g.setColor(Color.green);
            	}
            	if(tok[1].equals("YELLOW"))  {
            		g.setColor(Color.yellow);
            	}
            	if(tok[1].equals("RED"))  {
            		g.setColor(Color.red);
            	}
            	if(tok[1].equals("BLUE"))  {
            		g.setColor(Color.blue);
            	}
            	if(tok[1].equals("CYAN"))  {
            		g.setColor(Color.cyan);
            	}
            	if(tok[1].equals("ORANGE"))  {
            		g.setColor(Color.orange);
            	}
            	if(tok[1].equals("PURPLE"))  {
            		g.setColor(Color.magenta);
            	}
            	g.drawString(messages.get(i + offset).substring(messages.get(i + offset).indexOf(tok[2])), startX, startY + (i * 13));
            }
        } else
            
        {
            for (int i=0; i < messages.size(); i++)
            {
            	String tok[] = messages.get(i).split(":");
            	if(tok[1].equals("GREEN"))  {
            		g.setColor(Color.green);
            	}
            	if(tok[1].equals("YELLOW"))  {
            		g.setColor(Color.yellow);
            	}
            	if(tok[1].equals("RED"))  {
            		g.setColor(Color.red);
            	}
            	if(tok[1].equals("BLUE"))  {
            		g.setColor(Color.blue);
            	}
            	if(tok[1].equals("ORANGE"))  {
            		g.setColor(Color.orange);
            	}
            	if(tok[1].equals("PURPLE"))  {
            		g.setColor(Color.magenta);
            	}
            	g.drawString(messages.get(i).substring(messages.get(i).indexOf(tok[2])), startX, startY + (i * 13));
            }
        }
          
    }
}

