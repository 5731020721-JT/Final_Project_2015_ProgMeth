package logic;

import javax.swing.JPanel;

import render.IRenderable;

public abstract class SpaceObject extends JPanel implements IRenderable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	protected int x;
	protected int y;
	protected int z;
	protected int radius;
	protected boolean visible;


	protected boolean destroyed;
	
	public void setDestroyed(boolean destroyed) {
		this.destroyed = destroyed;
	}

	private int shipHeight;
	private int shipWidth;


	private Player player;
	private Creep creeps;
	
	//constructor
	public SpaceObject(int x,int y){
		this.x = x;
		this.y = y;
		visible = true;
		destroyed = false;
		
		
		
	}


	//Getter & Setter
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}



	public int getShipHeight() {
		return shipHeight;
	}




	public void setShipHeight(int shipHeight) {
		this.shipHeight = shipHeight;
	}




	public int getShipWidth() {
		return shipWidth;
	}




	public void setShipWidth(int shipWidth) {
		this.shipWidth = shipWidth;
	}


	public abstract void move();
	
	protected boolean collideWith(SpaceObject other){
		
		return (other.getY()+other.getShipHeight()>=this.y && other.getY()<=this.y+this.getShipHeight() 
		&& other.x<=this.x+this.getShipWidth() && other.x+other.getShipWidth()>=this.x);
		
	}
	
	@Override
	public boolean isDestroyed(){
		return destroyed;
	
	}
	
	@Override
	public boolean isVisible(){
		return visible;
	}
	
	@Override
	public int getZ(){
		return z;
	}
}
