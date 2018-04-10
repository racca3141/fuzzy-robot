//ColorPanel example	

import javax.swing.*;
import java.awt.*;

public class ColorPanel2 extends JPanel{
	private int lifeL = 0;
	private String drawString = "";
	public ColorPanel2(Color whatever){
		setBackground(whatever);
	}

	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.setColor(Color.black);
		if(lifeL >= 1)
			g.drawRect(10,10,10,10); 
		if(lifeL >= 2)
			g.fillRect(20,20,10,10);
		
		if(! drawString.equals("")){
	
			//There is at least one draw command.
			String drawCMD;
			int indexBegin = 0;
			int indexEnd = drawString.indexOf(">");
			int indexBC; //index of the beginning comma;
			int indexEC; //index of the ending comma;
			int x, y, w, h; //draw specs
			String c; //color codes

			while(indexBegin != -1){
				//get the drawCMD
				drawCMD = drawString.substring(indexBegin + 1, indexBegin + 2 + 1);  // -1 for the second parameter

				indexBC = indexBegin + 3;
				indexEC = drawString.indexOf(",", indexBC + 1); // + 1 because you ignore the current ,
				x = Integer.parseInt(drawString.substring(indexBC + 1, indexEC - 1 + 1));

				indexBC = indexEC;
				indexEC = drawString.indexOf(",", indexBC + 1);
				y = Integer.parseInt(drawString.substring(indexBC + 1, indexEC - 1 + 1));

				indexBC = indexEC;
				indexEC = drawString.indexOf(",", indexBC + 1);
				w = Integer.parseInt(drawString.substring(indexBC + 1, indexEC - 1 + 1));

				indexBC = indexEC;
				//indexEC = indexEnd;
				indexEC = drawString.indexOf(",", indexBC + 1);
				h = Integer.parseInt(drawString.substring(indexBC + 1, indexEC - 1 + 1));

				indexBC = indexEC;
				indexEC = indexEnd;
				c = drawString.substring(indexBC + 1, indexEC - 1 + 1);
			
				if(c.equals("bl")) g.setColor(Color.black);
				if(c.equals("w")) g.setColor(Color.white);
				if(c.equals("r")) g.setColor(Color.red);
				if(c.equals("y")) g.setColor(Color.yellow);
				if(c.equals("b")) g.setColor(Color.blue);



				if(drawCMD.equals("DR"))  //drawRect
					g.drawRect(x, y, w, h);
				
				if(drawCMD.equals("FR"))  //fillRect
					g.fillRect(x, y, w, h);
				
				if(drawCMD.equals("DO"))  //drawOval
					g.drawOval(x, y, w, h);
				
				if(drawCMD.equals("FO"))  //fillOval
					g.fillOval(x, y, w, h);


				//Starting at the current indexEnd position, check to see if there are any other <
				indexBegin = drawString.indexOf("<", indexEnd);
				if(indexBegin != -1){
					//find the next indexEnd
					indexEnd = drawString.indexOf(">", indexBegin);				
				}
			}

		}
	}

	public void getData(int life){
		lifeL = life;
		repaint();
	}

	public void addDraw(String cmd, int x, int y, int w, int h, String clr){
		String drawS = "<" + cmd + "," + x + "," + y + "," + w + "," + h + "," + clr + ">";
		System.out.println(drawS);
		drawString = drawString + drawS;
		repaint();


	}
}