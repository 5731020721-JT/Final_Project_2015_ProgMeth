package logic;

import java.util.ArrayList;
import java.util.Random;

public class CreepControl {
	
	private ArrayList<SpaceObject> creepList;

	private Random random;
	int timeToSpawn = 100;
	
	
	public CreepControl(ArrayList<SpaceObject> creepList, Random random) {
		this.creepList = creepList;
		this.random = random;

	}
	
	
	public void createCreeps(){
		if (timeToSpawn <= 0) {
		Creep creep = new Creep(640, 50,3);
		creep.setY(random.nextInt(380-creep.getShipHeight()));
		creepList.add(creep);
		GameLogic.getInstance().addNewObject(creep);
		timeToSpawn = random.nextInt(100)+100;
		}
		timeToSpawn--;
	}
	
	
	

	public void updateCreeps() {
		if (timeToSpawn <= 0) {
			Creep creep = new Creep(640, 50,new Random().nextInt(3));
			creep.setY(random.nextInt(380-creep.getShipHeight()));
			GameLogic.getInstance().addNewObject(creep);
			if (creepList.isEmpty()) {
				creepList.add(creep);
			} else {
				boolean collids;
				do {
					collids = false;
					creep.setY(random.nextInt(640));
					
					for (SpaceObject sp : creepList) {
						if (creep.collideWith(sp)) {
							collids = true;
							break;
						}
					}
				} while (collids);
			}
			timeToSpawn = random.nextInt(100)+100;
			creepList.add(creep);
		//GameLogic.getInstance().addNewObject(creep);
		}
		timeToSpawn--;
	}
	
	
	
	public void update(){
		for(int i = 0 ; i < creepList.size();i++){
			if(creepList.get(i).getX()<=-70){
			//เพิ่มคะแนน ของผู้เล่น
			creepList.get(i).destroyed = true;
		}
			else{
				creepList.get(i).move();
		}
		}
		
	}
	
	
}
