package logic;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Random;

import org.junit.Before;
import org.junit.Test;

public class CreepControlTest {

	@Before
	public void setUp() throws Exception {
		
		
	}

	@Test
	public void testCreepControl() {
		Random random=null;
		ArrayList<SpaceObject> enemyList =new ArrayList<>(); 
		CreepControl creepControl = new CreepControl(enemyList, random);
		
		
	}

}
