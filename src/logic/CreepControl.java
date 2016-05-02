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
		Creep creep = new Creep(640, 50,3);
		creepList.add(creep);
	}
	
	
	

	public void updateCreeps() {
		if (timeToSpawn <= 0) {
			Creep creep = new Creep(640, 50,3);
			creep.setY(random.nextInt(380 - creep.getShipHeight()));
			
			if (creepList.isEmpty()) {
				creepList.add(creep);
			} else {
				boolean collids;
				do {
					collids = false;
					creep.setY(random.nextInt(640-creep.getShipHeight()));
					
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
		}
		timeToSpawn--;
	}
	
	
	
	public boolean update(){
		for(int i = 0 ; i < creepList.size();i++){
			//if(creepList.get(i).getX()<=0){
			//	return false;
		//	}
		//	else{
				creepList.get(i).move();
		//	}
		}
		return true;
	}
	
	
}
