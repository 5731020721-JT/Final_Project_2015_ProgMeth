package logic;

import java.awt.Graphics2D;

import render.RenderManager;

public class Creep extends SpaceObject{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int speed;

	public Creep(int x,int y,int speed){
		super(x, y);
		this.speed = speed;
		this.z = -100;
		this.setShipHeight(100);
		this.setShipWidth(10);
	}
	
	public void onCollision(Player player){
		player.isCrash();
		RenderManager.explosionSound.play();
		//this.destroyed = true;
	}
	
	@Override
	public void draw(Graphics2D g2d) {
		g2d.drawImage(RenderManager.enemyPicture1, null, x, y);	
	}
	

	@Override
	public void move(){
		x -= speed;
	}

}
