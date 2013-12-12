package com.example.battlefront;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.MotionEvent;

public class Character extends Activity {

	int xloc;
	int yloc;
	Paint paint = new Paint();

	public Character() {
		// TODO Auto-generated constructor stub
	}

	public Character(int xloc, int yloc) {
		this.xloc = xloc;
		this.yloc = yloc;
	}

	void display(Canvas canvas) {
		canvas.drawRect(xloc, yloc, xloc + 30, yloc + 15, paint);
	}

	public void onDraw(Canvas canvas) {
		// setup initial character location
		canvas.drawRect(xloc, yloc, xloc + 30, yloc + 15, paint);
	}

	public int getXloc() {
		return xloc;
	}

	public void setXloc(int xloc) {
		this.xloc = xloc;
	}

	public int getYloc() {
		return yloc;
	}

	public void setYloc(int yloc) {
		this.yloc = yloc;
	}

}
