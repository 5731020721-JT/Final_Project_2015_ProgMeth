package shell;

import java.util.ArrayList;

import logic.Player;
import logic.GameLogic;
import logic.SpaceObject;

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
		GameLogic.getInstance().addNewObject(shells);
	}
	
	
	
	public void update(){
		for(int i = 0 ; i < shellList.size();i++){
			if(shellList.get(i).getX() > GameLogic.WIDTH){
				//shellList.get(i).destroyed = true;
			}
			else{
				shellList.get(i).move();
			}
		}
	}
	
	
}
