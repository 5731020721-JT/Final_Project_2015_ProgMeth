package shell;

import java.awt.Graphics2D;

import logic.SpaceObject;

public class Shell extends SpaceObject {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int speed;
	
	
	
	public Shell(int x, int y, int speed) {
		super(x, y);
		this.speed = speed;
	}



	@Override
	public void move() {
		x+=speed;
	}



	@Override
	public void draw(Graphics2D g2d) {
		// TODO Auto-generated method stub
		
	}

}
