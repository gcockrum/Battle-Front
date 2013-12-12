package com.example.battlefront;

//import java.awt.Color;
import android.graphics.Paint;
import android.view.MotionEvent;

public class GameTile {

	// Color terrain;
	Paint terrain = new Paint();
	float movement;

	int[] xTileCord = new int[6];
	int[] yTileCord = new int[6];
	int[] xTileReference = new int[6];
	int[] yTileReference = new int[7];
	int xloc;
	int yloc;

	public GameTile() {
		// TODO Auto-generated constructor stub
	}

	public GameTile(int[] xTileCord, int[] yTileCord, int x, int y) {
		for (int i = 0; i < xTileCord.length; i++)
			this.xTileCord[i] = xTileCord[i];
		for (int i = 0; i < yTileCord.length; i++)
			this.yTileCord[i] = yTileCord[i];
		xloc = x;
		yloc = y;
	}

	public void setTileReference(int xcord[], int[] ycord) {
		for (int i = 0; i < xcord.length; i++)
			xTileReference[i] = xcord[i];
		for (int i = 0; i < ycord.length; i++)
			yTileReference[i] = ycord[i];
	}

	public int[] getxTileReference() {
		return xTileReference;
	}
	
	public int[] getyTileReference() {
		return yTileReference;
	}

	public int[] getxTileCord() {
		return xTileCord;
	}

	public int[] getyTileCord() {
		return yTileCord;
	}

	public void printxTileCord() {
		for (int i = 0; i < xTileCord.length; i++)
			System.out.println(xTileCord[i]);
	}

	public void printyTileCord() {
		for (int i = 0; i < yTileCord.length; i++)
			System.out.println(yTileCord[i]);
	}

	public void setxTileCord(int[] xTileCord) {
		this.xTileCord = xTileCord;
	}

	public void setyTileCord(int[] yTileCord) {
		this.yTileCord = yTileCord;
	}

	public Paint getTerrain() {
		return terrain;
	}

	public void setTerrain(Paint terrain) {
		this.terrain = terrain;
	}

	public float getMovement() {
		return movement;
	}

	public void setMovement(float movement) {
		this.movement = movement;
	}

	public int getXloc() {
		return xloc;
	}

	public int getYloc() {
		return yloc;
	}

	public void setXloc(int xloc) {
		this.xloc = xloc;
	}

	public void setYloc(int yloc) {
		this.yloc = yloc;
	}

}