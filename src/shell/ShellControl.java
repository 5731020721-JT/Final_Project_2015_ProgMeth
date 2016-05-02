package shell;

import java.util.ArrayList;

import logic.Player;
import logic.GameLogic;
import logic.SpaceObject;
import render.RenderManager;

public class ShellControl {
	
	
	private ArrayList<SpaceObject> shellList;
	
	
	
	private Player player;
	int timeToSpawn = 0;

	public ShellControl(ArrayList<SpaceObject> shellList,Player player) {
		this.shellList = shellList;
		this.player = player;
	}
	
	
	public synchronized void addShell(){
		Shell shells = new Shell(player.getX()+player.getShipWidth(), player.getY()+player.getShipHeight()/2, 3);
		shells.setY((player.getY()+player.getShipHeight()/2)- shells.getShipHeight()/2);		
		shellList.add(shells);
		//GameLogic.getInstance().addNewObject(shells);
		RenderManager.getInstance().add(shells);
	}
	
	
	
	public void update(){
		for(int i = 0 ; i < shellList.size();i++){
			if(shellList.get(i).getX() > 600){
				shellList.get(i).setDestroyed (true);
			}
			else{
				shellList.get(i).move();
			}
		}
	}
	
	
}
