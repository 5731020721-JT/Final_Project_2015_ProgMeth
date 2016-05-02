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
	
	
	public void addShell(){
		Shell shells = new Shell(2, player.getX()+player.getShipWidth(), 3);
		shells.setY((player.getY()+player.getShipHeight()/2)- shells.getShipHeight()/2);		
		shellList.add(shells);
	}
	
	
	
	public void update(){
		for(int i = 0 ; i < shellList.size();i++){
			if(shellList.get(i).getX() > GameLogic.WIDTH){
				shellList.remove(i);
			}
			else{
				shellList.get(i).move();
			}
		}
	}
	
	
}
