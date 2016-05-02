package render;

import input.InputUtility;
import logic.Player;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JComponent;

public class GameScreen extends JComponent{

	private RenderManager renderManager;
	
	public GameScreen(RenderManager renderManager){
		super();
		setDoubleBuffered(true);
		this.renderManager = renderManager;
		setPreferredSize(new Dimension(640,380));
		setVisible(true);
		
		addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent arg0) {
				// TODO Auto-generated method stub
				InputUtility.setKeyPressed(arg0.getKeyCode(), false);
			}
			
			@Override
			public void keyPressed(KeyEvent arg0) {
				// TODO Auto-generated method stub
				InputUtility.setKeyPressed(arg0.getKeyCode(), true);
			}
		});

		//Accept mouse "click" event
		addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				if(arg0.getButton() == 1){
					InputUtility.mouseLeftRelease();
				}
			}
			
			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				if(arg0.getButton() == 1){
					InputUtility.mouseLeftDown();
				}
			}
			
			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				InputUtility.mouseOnScreen = false;
			}
			
			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				InputUtility.mouseOnScreen = true;
			}
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
			}
		});
		
		
		//Accept mouse "move" event
		addMouseMotionListener(new MouseMotionListener() {
			
			@Override
			public void mouseMoved(MouseEvent arg0) {
				// TODO Auto-generated method stub
				if(InputUtility.mouseOnScreen){
					InputUtility.mouseX = arg0.getX();
					InputUtility.mouseY = arg0.getY();
				}
			}
			
			@Override
			public void mouseDragged(MouseEvent arg0) {
				// TODO Auto-generated method stub
				if(InputUtility.mouseOnScreen){
					InputUtility.mouseX = arg0.getX();
					InputUtility.mouseY = arg0.getY();
				}
			}
		});
	}
	
	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		Graphics2D g2d =(Graphics2D)g;
/*		g2d.setColor(Color.WHITE);
		g2d.setFont(new Font("Tahoma", Font.BOLD, 30));
		g2d.drawString(""+Player.getScore(),20,360 );*/
		renderManager.drawScreen(g2d);
	}
}
