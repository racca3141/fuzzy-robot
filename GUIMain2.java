//GUIMain

import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

public class GUIMain2{
	public static void main(String[] args){
		JFrame GUI = new JFrame();
		GUI.setTitle("Hangman");
		GUI.setSize(500,500);
		GUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container Pane = GUI.getContentPane();

		ColorPanel2 panel = new ColorPanel2(Color.white);

		Pane.add(panel);

		GUI.setVisible(true);

		Scanner reader = new Scanner(System.in);

		//panel.getData(2);  //Change the number to 1 or 2 and see what happens.

		
		//head
		panel.addDraw("DO", 30, 10, 40, 40, "bl");
		System.out.print("6 guesses left.");
		reader.nextLine();
		//neck
		panel.addDraw("FR", 45, 50, 10, 5, "r");
		System.out.print("5 guesses left.");
		reader.nextLine();
		//torso
		panel.addDraw("FR", 30, 55, 40, 50, "y");
		System.out.print("4 guesses left.");
		reader.nextLine();
		//right arm
		panel.addDraw("FR", 20, 55, 8, 50, "b");
		System.out.print("3 guesses left.");
		reader.nextLine();
		//left arm
		panel.addDraw("DR", 72, 55, 8, 50, "b");
		System.out.print("2 guesses left.");
		reader.nextLine();
		//right leg
		panel.addDraw("DR", 30, 107, 15, 45, "y");
		System.out.print("1 guess left.");
		reader.nextLine();
		//left leg
		panel.addDraw("DR", 55, 107, 15, 45, "r");
		System.out.print("You're dead.  Erase?");
		reader.nextLine();

		//erase each or overlap with big white square?  each here.
		panel.addDraw("DO", 30, 10, 40, 40, "w");
		panel.addDraw("FR", 45, 50, 10, 5, "w");
		panel.addDraw("FR", 30, 55, 40, 50, "w");
		panel.addDraw("FR", 20, 55, 8, 50, "w");
		panel.addDraw("DR", 72, 55, 8, 50, "w");
		panel.addDraw("DR", 30, 107, 15, 45, "w");
		panel.addDraw("DR", 55, 107, 15, 45, "w");
		

		
		
	}
}