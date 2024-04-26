package org.gamedev.gaming.sprite;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

import org.gamedev.gamingg.Enemy;
import org.gamedev.gamingg.Player;

public class board extends JPanel {
	BufferedImage backgroundImage;
	Player player;
	Enemy enemies[]=new Enemy[4];
	Timer timer;
	public board() {
		setSize(1500,920);
		loadBackgroundImage();
		player=new Player();
		loadEnemy();
		gameLoop();
		bindEvents();
		setFocusable(true);
		
	}
	private void gameOver(Graphics pen) {
		if(player.outOfScreen()) {
			pen.setFont(new Font("times",Font.BOLD,30));
			pen.setColor(Color.white);
			pen.drawString("game win",1500/2,900/2);
			timer.stop();
			
		}
		for(Enemy enemy: enemies) {
			if(isCollide(enemy)) {
				pen.setFont(new Font("times",Font.BOLD,30));
				pen.setColor(Color.white);
				pen.drawString("game over",1500/2,900/2);
				timer.stop();
			}
		}
	}
	private boolean isCollide(Enemy enemy) {
		int xDistance=Math.abs(player.x - enemy.x);
		int yDistance=Math.abs(player.y - enemy.y);
		int maxH=Math.max(player.h , enemy.h);
		int maxW=Math.max(player.w, enemy.w);
		 return xDistance<=maxW-150 && yDistance<=maxH-150;
	
	}
	private void bindEvents() {
		addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_RIGHT) {
				player.speed=15;
				// TODO Auto-generated method stub
				}
				else if(e.getKeyCode()==KeyEvent.VK_LEFT){
				player.speed=-10;
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
				player.speed=0;
				// TODO Auto-generated method stub
				
			}
			
		});
	
		
	}
	private void loadEnemy() {
		int x= 400;
		int gap=300;
		int speed= 5;
		for(int i=0;i<enemies.length;i++) {
			enemies[i]=new Enemy(x,speed);
			x=x+gap;
			speed=speed+3;
		}
			
	}
	private void gameLoop() {
		timer=new Timer(100,(e)->repaint());
		timer.start();
	}
	private void loadBackgroundImage() {
		try {
			backgroundImage=ImageIO.read(board.class.getResource("gamebg.jpg"));
		} catch (IOException e) {
			System.out.println("background image does not found....");
		    System.exit(1);
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	private void printenemies(Graphics pen) {
		for(Enemy enemy: enemies) {
			enemy.draw(pen);
			enemy.move();
		}
	}
    public void  paintComponent(Graphics pen) {
    super.paintComponent(pen);//clean up
    //all painting logic will be here
    pen.drawImage(backgroundImage,0,0,1500,920,null);
    player.draw(pen);
    player.move();
    printenemies(pen); 
    gameOver(pen);
    }
}