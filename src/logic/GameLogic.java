package logic;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.Timer;

import logic.CreepControl;
import render.RenderManager;
import shell.ShellControl;
import logic.SpaceObject;
import logic.PressToStart;

public class GameLogic  extends JFrame implements KeyListener  {
	

	private static RenderManager renderableContainer;
	private List<SpaceObject> gameObjectContainer;
	
	private static final GameLogic Instance = new GameLogic();
	
	private Random random;
	private Timer timing ;
	
	private Player hero;
	private Creep creeps;
	
	private ArrayList<SpaceObject> enemyList;
	private ArrayList<SpaceObject> shellList;
	
	private CreepControl creepControl;
	private ShellControl shellControl;
	//private Player player;
	private PressToStart pressToStart;
	
	public GameLogic(){
		//this.renderableContainer = renderableContainer;
		
		this.gameObjectContainer = new ArrayList<SpaceObject>();
		pressToStart = new PressToStart();
		Field field = new Field();
		enemyList=new ArrayList<>();
		 shellList= new ArrayList<>();
		 hero = new Player(10,100);
		 creeps = new Creep(640,100,2);
		random = new Random();
		creepControl = new CreepControl(enemyList, random);
		shellControl = new ShellControl(shellList,hero);
		RenderManager.getInstance().add(field);
		
		enemyList.add(creeps);
		
		addNewObject(hero);
		addNewObject(creeps);
	//	startTimer();
		
		
	}
	
	public PressToStart getPressToStart() {
		return pressToStart;
	}

	public void addNewObject(SpaceObject entity){
		gameObjectContainer.add(entity);
		RenderManager.getInstance().add(entity);
	}
	
	public void logicUpdate(){
		hero.update();
		//this.startTimer();
		if(!creeps.isDestroyed() && hero.collideWith(creeps)){
			creeps.onCollision(hero);
		}
	}
	
	public void startTimer(){
		ActionListener al = new ActionListener(){
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				removeObjectWithColl();
				GameLogic.this.repaint();
				creepControl.update();
				if(isCollidsWithPlayer()){
					timing.stop();
					JOptionPane.showMessageDialog(null, "GAME OVER  :(");
					hero.destroyed = true;
					pressToStart.stop();
				}
				
			//	creepControl.updateCreeps();
				creepControl.createCreeps();
				shellControl.update();
				
				
			
			}
		};
		
		
		timing = new Timer(10,al);
		
		timing.start();
		this.repaint();
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	public synchronized void removeObjectWithColl(){
		for (int i = 0 ; i < enemyList.size();i++){
			for(int j = 0 ; j < shellList.size();j++){
				if(enemyList.get(i).collideWith(shellList.get(j))){
					enemyList.get(i).destroyed = true;
					enemyList.remove(i);
					shellList.get(i).destroyed = true;
					shellList.remove(j);
				}
			}
		}
	}
	
	
	
	public boolean isCollidsWithPlayer(){
		for (int i = 0 ; i < enemyList.size();i++){
				if(enemyList.get(i).collideWith(hero)){
					return true;
				}
			}
		return false;
		
	}

	public static GameLogic getInstance() {
		return Instance;
	}

	public ShellControl getShellControl() {
		return shellControl;
	}
	
	
	
	
}
