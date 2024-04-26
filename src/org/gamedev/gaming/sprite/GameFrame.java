package org.gamedev.gaming.sprite;

import javax.swing.JFrame;

public class GameFrame extends JFrame {
	public GameFrame() { 
		board board= new board();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("game in java");
        setResizable(false);
        setSize(1500,920);
        add(board);
        setVisible(true);
        setLocationRelativeTo(null);
		
	}

	public static void main(String[] args) { 
		// TODO Auto-generated method stub
        GameFrame frame=new GameFrame();
       
        
	}

}