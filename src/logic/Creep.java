package logic;

import java.awt.Graphics2D;

import render.RenderManager;

public class Creep extends SpaceObject{
	
	private int speed;

	public Creep(int x,int y,int speed){
		super(x, y);
		this.speed = speed;
		this.z = -100;
		this.setShipHeight(115);
		this.setShipWidth(60);
		this.radius = 30;
	}
	
	public void onCollision(Player tank){
		tank.hitByMine();
		RenderManager.explosionSound.play();
		this.destroyed = true;
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
