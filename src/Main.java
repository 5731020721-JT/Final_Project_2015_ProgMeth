import input.InputUtility;

import java.awt.Dimension;

import javax.swing.JComponent;
import javax.swing.JFrame;

import logic.GameLogic;
import logic.PressToStart;
import render.GameScreen;
import render.RenderManager;


public class Main {

	public static void main(String[] args){
		JFrame frame = new JFrame("SPACE IMPACT");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		RenderManager renderManager = new RenderManager();
		GameLogic logic = new GameLogic(renderManager);
		JComponent gameScreen = new GameScreen(renderManager);
		
		
		frame.add(logic.getPressToStart());
		frame.setVisible(true);
		frame.pack();
		while(true){
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
			}
			
		if(logic.getPressToStart().isRun())	{
		
		
		frame.getContentPane().removeAll();
		frame.getContentPane().add(gameScreen);
	
		
		frame.getContentPane().setVisible(true);
		frame.pack();
		gameScreen.requestFocus();
		break;
			}
		}
		
		
		while(true){
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
			}
			gameScreen.repaint();
			logic.logicUpdate();
			//logic.startTimer();
			InputUtility.updateInputState();
		}
	}
}
