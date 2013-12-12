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
	
	public boolean onTouchEvent(MotionEvent event) {
	    float touchX = event.getX();
	    float touchY = event.getY();
	    switch(event.getAction()){
	        case MotionEvent.ACTION_DOWN:
	            System.out.println("Touching down!");
	            //if (touchX > xloc && touchY > yloc)
	            	//System.out.println("WEEEEEEEEEEEEE");
	            break;
	        case MotionEvent.ACTION_UP:
	            System.out.println("Touching up!");
	            break;
	        case MotionEvent.ACTION_MOVE:
	            System.out.println("Sliding your finger around on the screen.");
	            break;
	    }
	    return true;
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
