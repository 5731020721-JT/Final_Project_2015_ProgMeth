package logic;

import java.awt.Graphics2D;

import render.IRenderable;
import render.RenderManager;

public class Field implements IRenderable{

	private static int[][] field = {
		{0,0,0,0,0,0,0,0,0,0},
		{0,0,0,0,0,0,0,0,0,0},
		{0,0,0,0,0,0,0,0,0,0},
		{0,0,0,0,0,0,0,0,0,0},
		
		{0,0,0,0,0,0,0,0,0,0},
		{0,0,0,0,0,0,0,0,0,0},
		{0,0,0,0,0,0,0,0,0,0},
		{0,0,0,0,0,0,0,0,0,0}
	};

	public int getTerrain(int x,int y){
		if(x < 0 || x >= field[0].length || y < 0 || y >= field.length)
			return -3;
		return field[y][x];
	}
	
	public int getTileIndex(int x,int y){
		int terrain = getTerrain(x, y);
		if(terrain <= 0 && terrain >= -2)
			return -terrain;
		else
			return 0;
	}
	
	@Override
	public int getZ() {
		return -9999;
	}

	@Override
	public void draw(Graphics2D g2d) {
		g2d.drawImage(RenderManager.mapSpace, null, 1, 1);
	}

	@Override
	public boolean isDestroyed() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isVisible() {
		// TODO Auto-generated method stub
		return true;
	}
}
