package logic;

import input.InputUtility;
import render.RenderManager;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;

public class Player extends SpaceObject{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final int speed = 4  ;
	
	
	
	private boolean flashing = false;
	private int flashCounter = 0;
	private int flashDurationCounter = 0;
	private static int score=0;
	
	private long delay = 1000 ;
	private long timeLastShot = 0;
	
	public Player(int x, int y){
		super(x,y);
		this.radius = 80;
		this.setShipHeight(110);
		this.setShipWidth(100);
	}
	
	public void forward(){
		if(x<=640-this.getShipWidth())
		this.x += speed-2;
		
	}
	
	public void backward(){
		if(x>0)
		this.x -= speed-2;
	}
	
	public void up(){
		if(y>-10)
		this.y -= speed;
	}
	
	public void down(){
		if(y<=380-this.getShipHeight())
		this.y += speed;
	}
	
	
	public static int getScore() {
		return score;
	}

	public static void setScore(int score) {
		Player.score = score;
	}

	public void isCrash(){
		flashing = true;
		flashCounter = 10;
		flashDurationCounter = 10;
	}
	
	public void update(){
		if(flashing){
			if(flashCounter == 0){
				this.visible = true;
				flashing = false;
			}else{
				if(flashDurationCounter > 0){
					this.visible = flashCounter <= 5;
					flashDurationCounter--;
				}else{
					this.visible = true;
					flashDurationCounter = 10;
					flashCounter--;
				}
			}
		}else{
			this.visible = !InputUtility.getKeyPressed(KeyEvent.VK_SHIFT);
		}
		if(InputUtility.getKeyPressed(KeyEvent.VK_W)){
			up();
			//forward();
		}
		if(InputUtility.getKeyPressed(KeyEvent.VK_A)){
			backward();
		} if(InputUtility.getKeyPressed(KeyEvent.VK_D)){
			forward();
		} if(InputUtility.getKeyPressed(KeyEvent.VK_S)){
			down();
		} if(InputUtility.getKeyPressed(KeyEvent.VK_ENTER)){
			if(System.currentTimeMillis()-timeLastShot >= delay){
				GameLogic.getInstance().getShellControl().addShell();
				timeLastShot = System.currentTimeMillis();
			}
		}
	}
	
	@Override
	public void draw(Graphics2D g2d) {
		AffineTransform tx = AffineTransform.getScaleInstance(-1, 1);
		tx.translate(-RenderManager.heroPicture.getHeight(null),0);
		AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
		BufferedImage img = op.filter(RenderManager.heroPicture, null);
		g2d.drawImage(img, null,x,y);	

	
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub
		
	}

}
