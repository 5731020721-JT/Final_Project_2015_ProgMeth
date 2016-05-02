package render;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.imageio.ImageIO;

import logic.GameLogic;

public class RenderManager {

	public static BufferedImage mapSpace;
	public static BufferedImage enemyPicture;
	public static BufferedImage enemyPicture1;
	public static BufferedImage heroPicture;
	public static BufferedImage bulletPicture;
	public static AudioClip explosionSound;
	
	private static final RenderManager Instance = new RenderManager();
	
	static{
		try {
			ClassLoader loader = RenderManager.class.getClassLoader();
			mapSpace = ImageIO.read(loader.getResource("space.png"));
			enemyPicture = ImageIO.read(loader.getResource("enemy.png"));
			enemyPicture1 = ImageIO.read(loader.getResource("enemy1.png"));
			heroPicture = ImageIO.read(loader.getResource("monkey.png"));
			bulletPicture = ImageIO.read(loader.getResource("bullet.png"));
			explosionSound = Applet.newAudioClip((loader.getResource("Explosion.wav")).toURI().toURL());
		} catch (Exception e) {
			mapSpace = null;
			bulletPicture = null;
			heroPicture = null;
			enemyPicture = null;
			explosionSound = null;
		}
	}
	
	
	private List<IRenderable> entities;
	
	public RenderManager(){
		entities = new ArrayList<IRenderable>();
	}

	public void add(IRenderable entity){
		entities.add(entity);
		//Sort our list by Z
		Collections.sort(entities, new Comparator<IRenderable>() {
			@Override
			public int compare(IRenderable o1, IRenderable o2) {
				if(o1.getZ() > o2.getZ()) return 1;
				return -1;
			}
		});
	}
	
	public synchronized void update(){
		for(int i=entities.size()-1; i>=0; i--){
			if(entities.get(i).isDestroyed())
				entities.remove(i);
		}
	}
	
	//Will be called by JComponent object
	public void drawScreen(Graphics2D g2d){
		g2d.setBackground(Color.BLACK);
		g2d.clearRect(0, 0, 640, 380);
		for(IRenderable entity : entities){
			if(entity.isVisible() && !entity.isDestroyed()){
				entity.draw(g2d);
			}
		}
	}

	public static RenderManager getInstance() {
		return Instance;
	}
}
