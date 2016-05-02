package logic;

import java.awt.Color;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

import input.InputUtility;
import logic.Player;
import render.GameScreen;
import render.RenderManager;
import shell.ShellControl;
import logic.GameLogic;;


public class PressToStart extends JPanel implements Runnable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static int WIDTH = 800;
	public static int HEIGHT = 600;
	private Thread th;
	private boolean isRun;
	private long delay = 40 ;
	private long timeLastShot = 0;
	private JPanel currentScene;
	
    public PressToStart() {
		setPreferredSize(new Dimension(WIDTH,HEIGHT));
		th = new Thread(this);
		setFocusable(true);
		addKeyListener(new KeyListener(){

			private Player player;
			private ShellControl shellControl;

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				int key = e.getKeyCode();
				if(key==KeyEvent.VK_SPACE){
					startGame();
				}
				
				
				
				switch (e.getKeyChar()) {
				case '6':
					player.forward();
					break;
				case '8':
					player.up();
					break;
				case '5':
					player.down();
					break;
				case '4':
					player.backward();
					break;
				case 'k':
					if(System.currentTimeMillis()-timeLastShot >= delay){
					shellControl.addShell();
					timeLastShot = System.currentTimeMillis();
					}
					break;		

				default:
					break;
				}
				
				
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
	}
	
	public boolean isRun() {
		return isRun;
	}

	public void startGame(){
		isRun=true;
		th.start();
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(isRun){
			repaint();//«“¥°√“øø‘§„À¡Ë
			
		}
	}
	


	//ª√–¡«≈º¡°√“øø‘§
	@Override
	public void paint(Graphics g) {
		g.clearRect(0, 0, WIDTH, HEIGHT);
		g.setColor(Color.BLACK);
		if(!isRun){
			g.setColor(Color.red);
			g.setFont(new Font("Tohoma",Font.BOLD,40));
			g.drawString("SPACE IMPACT", WIDTH/2-144, HEIGHT/2);
			g.setColor(Color.black);
			g.setFont(new Font("Tohoma",Font.BOLD,15));
			g.drawString("Please Press Spacebar to Start Game", WIDTH/2-130, HEIGHT/2+25);
		}
		else{
			//new GameLogic(null);
			
			
		}
	}
	public void stop() {
		// TODO Auto-generated method stub
		isRun=false;
		try {
			th.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
