package org.gamedev.gamingg;



import java.awt.Graphics;

import javax.swing.ImageIcon;

public class Player extends Sprite {
	
	public Player() {
		w=300;
		h=300;
		y=500;
		x=50;
		image=new ImageIcon(Player.class.getResource("sonic.gif"));
   }
	public void move() {
		x=x+speed;
	}
	public boolean outOfScreen() {
		return x>1500;
	}
}