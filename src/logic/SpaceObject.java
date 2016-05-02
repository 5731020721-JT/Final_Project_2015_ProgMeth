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
	protected boolean visible,destroyed;
	
	private int shipHeight;
	private int shipWidth;
	
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
	/*
	public boolean isCollids(SpaceObject sp){
		return(x < sp.getX()+ sp.getShipWidth()
				&& x + sp.shipWidth > sp.getX()
				&& y < sp.getY() + sp.getShipHeight()
				&& y + shipHeight > sp.getY() );
	}*/
	
	protected boolean collideWith(SpaceObject other){
		return Math.hypot(this.x-other.x, this.y-other.y) <= this.radius+other.radius;
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
