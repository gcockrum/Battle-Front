package com.example.battlefront;

import java.util.Random;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;

public class GameEngine extends View {

	private int hexHeight = 25;
	private int hexWidth = 30;
	private int w = 800;
	private int h = 430;
	private int mActivePointerId = INVALID_POINTER_ID;
	private static final int INVALID_POINTER_ID = -1;
	private int[] xcord = { 15 - w / 2, 30 - w / 2, 30 - w / 2, 15 - w / 2,
			0 - w / 2, 0 - w / 2 };
	private int[] ycord = { 0 - h / 2, 10 - h / 2, 25 - h / 2, 35 - h / 2,
			25 - h / 2, 10 - h / 2 };
	private float mScaleFactor = 1.0f;
	private float mPosX;
	private float mPosY;
	private float mLastTouchX;
	private float mLastTouchY;
	private Paint grass = new Paint();
	private Paint water = new Paint();
	private Paint hill = new Paint();
	private Paint hexgrid = new Paint();
	private Path hexpath = new Path();
	private Paint terrain = new Paint();
	private ScaleGestureDetector mScaleDetector;
	Character character[] = new Character[5];
	GameTile[][] tile = new GameTile[h / hexHeight][w / hexWidth];
	final AlertDialog alertDialog;

	public GameEngine(Context context) {
		super(context);
		mScaleDetector = new ScaleGestureDetector(context, new ScaleListener());
		alertDialog = new AlertDialog.Builder(context).create();
	}

	// @Override
	public void init() {

		// set up terrain colors
		grass.setARGB(255, 0, 100, 0);
		water.setARGB(255, 0, 0, 100);
		hill.setARGB(255, 150, 113, 23);

		// random number from 1 to 100
		Random rand = new Random();
		int n = rand.nextInt(100) + 1;

		// initialize game board
		// creates each tile object and assigns its location and terrain type
		for (int i = 0; i < tile.length; i++) {
			for (int j = 0; j < tile[i].length; j++) {
				tile[i][j] = new GameTile(xcord, ycord, xcord[5], ycord[5]);
				if (n > 1 && n <= 50) {
					tile[i][j].setTerrain(grass);
					tile[i][j].setMovement(1);
				} else if (n > 50 && n <= 60) {
					tile[i][j].setTerrain(water);
					tile[i][j].setMovement(0);
				} else {
					tile[i][j].setTerrain(hill);
					tile[i][j].setMovement(0.5f);
				}

				for (int k = 0; k < xcord.length; k++)
					// moves x coordinates
					xcord[k] = xcord[k] + hexWidth;
				n = rand.nextInt(100) + 1;
			}
			for (int j = 0; j < ycord.length; j++)
				ycord[j] = ycord[j] + hexHeight;

			if (i % 2 != 0) {
				xcord[0] = 15 - w / 2;
				xcord[1] = 30 - w / 2;
				xcord[2] = 30 - w / 2;
				xcord[3] = 15 - w / 2;
				xcord[4] = 0 - w / 2;
				xcord[5] = 0 - w / 2;
			} else {
				xcord[0] = 30 - w / 2;
				xcord[1] = 45 - w / 2;
				xcord[2] = 45 - w / 2;
				xcord[3] = 30 - w / 2;
				xcord[4] = 15 - w / 2;
				xcord[5] = 15 - w / 2;
			}
		}

		// set the references of other nodes

		// create characters
		character[0] = new Character(tile[8][12].getXloc(),
				tile[8][12].getYloc());
		character[1] = new Character(tile[0][25].getXloc(),
				tile[0][25].getYloc());

	}

	// @Override
	public void start() {
		// TODO Auto-generated method stub

	}

	// @Override
	public void stop() {
		// TODO Auto-generated method stub

	}

	// @Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	public void onDraw(Canvas canvas) {
		canvas.translate(w / 2, h / 2); // translate location (0,0) to the
										// center of the screen
		canvas.save();

		// if the game map is in full view, it has a fixed translation
		if (mScaleFactor <= 1.0) {
			mPosX = 0;
			mPosY = 0;
			canvas.translate(mPosX, mPosY);

			// if canvas has been zoomed in, the game map can be translated
		} else {
			if (mPosY >= 148 * mScaleFactor)
				mPosY = 148 * mScaleFactor;
			if (mPosY <= -148 * mScaleFactor)
				mPosY = -148 * mScaleFactor;
			if (mPosX >= 280 * mScaleFactor)
				mPosX = 280 * mScaleFactor;
			if (mPosX <= -280 * mScaleFactor)
				mPosX = -280 * mScaleFactor;
			if (mPosX <= 280 * mScaleFactor && mPosX >= -280 * mScaleFactor
					&& mPosY <= 148 * mScaleFactor
					&& mPosY >= -148 * mScaleFactor)
				canvas.translate(mPosX, mPosY);
		}

		canvas.scale(mScaleFactor, mScaleFactor, 0, 0); // scales the canvas
														// according to the
														// Scale Factor

		// Creates game tiles by using draw path to create hex tiles
		for (int i = 0; i < tile.length; i++)
			for (int j = 0; j < tile[i].length; j++) {
				hexpath.reset();
				hexpath.moveTo(tile[i][j].getxTileCord()[0],
						tile[i][j].getyTileCord()[0]);
				hexpath.lineTo(tile[i][j].getxTileCord()[1],
						tile[i][j].getyTileCord()[1]);
				hexpath.lineTo(tile[i][j].getxTileCord()[2],
						tile[i][j].getyTileCord()[2]);
				hexpath.lineTo(tile[i][j].getxTileCord()[3],
						tile[i][j].getyTileCord()[3]);
				hexpath.lineTo(tile[i][j].getxTileCord()[4],
						tile[i][j].getyTileCord()[4]);
				hexpath.lineTo(tile[i][j].getxTileCord()[5],
						tile[i][j].getyTileCord()[5]);
				hexpath.lineTo(tile[i][j].getxTileCord()[0],
						tile[i][j].getyTileCord()[0]);

				terrain = tile[i][j].getTerrain(); // gets terrain color

				hexgrid.setStrokeWidth(2); // hexgrid color gets set with a
											// stroke of 2 pixels thick
				hexgrid.setStyle(Paint.Style.STROKE); // hexgred is STROKE only
														// and does not fill the
														// path
				canvas.drawPath(hexpath, terrain); // draws the hex path filling
													// the color with the
													// terrain color
				canvas.drawPath(hexpath, hexgrid); // draws the hex path
													// outlining only the edge
			}

		hexgrid.setStyle(Paint.Style.FILL);

		character[0].display(canvas); // displays the character
		character[1].display(canvas);

		canvas.restore();
	}

	protected void alertbox(String title, String mymessage) {
		String[] array = { "Move", "Attack", "Upgrade", "Cancel" };
		AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
		builder.setTitle("Pick an Option");
		builder.setItems(array, new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				// The 'which' argument contains the index position
				// of the selected item
			}
		}).show();
	}

	@Override
	public boolean onTouchEvent(MotionEvent ev) {
		// Let the ScaleGestureDetector inspect all events.
		mScaleDetector.onTouchEvent(ev);

		final int action = ev.getAction();
		switch (action & MotionEvent.ACTION_MASK) {
		case MotionEvent.ACTION_DOWN: {
			final float x = ((ev.getX() - w / 2) - mPosX) / mScaleFactor;
			final float y = ((ev.getY() - h / 2) - mPosY) / mScaleFactor;
			final float xt = ev.getX();
			final float yt = ev.getY();

			if (x > character[0].getXloc() && y > character[0].getYloc()
					&& x < character[0].getXloc() + 30
					&& y < character[0].getYloc() + 15) {
				alertbox("Test", "Message");
			}

			mLastTouchX = xt;
			mLastTouchY = yt;
			mActivePointerId = ev.getPointerId(0);
			break;
		}

		case MotionEvent.ACTION_MOVE: {
			final int pointerIndex = ev.findPointerIndex(mActivePointerId);
			final float x = ev.getX(pointerIndex);
			final float y = ev.getY(pointerIndex);

			// Only move if the ScaleGestureDetector isn't processing a gesture.
			if (!mScaleDetector.isInProgress()) {
				final float dx = x - mLastTouchX;
				final float dy = y - mLastTouchY;

				mPosX += dx;
				mPosY += dy;

				invalidate();
			}

			mLastTouchX = x;
			mLastTouchY = y;

			break;
		}

		case MotionEvent.ACTION_UP: {
			mActivePointerId = INVALID_POINTER_ID;
			break;
		}

		case MotionEvent.ACTION_CANCEL: {
			mActivePointerId = INVALID_POINTER_ID;
			break;
		}

		case MotionEvent.ACTION_POINTER_UP: {
			final int pointerIndex = (ev.getAction() & MotionEvent.ACTION_POINTER_INDEX_MASK) >> MotionEvent.ACTION_POINTER_INDEX_SHIFT;
			final int pointerId = ev.getPointerId(pointerIndex);
			if (pointerId == mActivePointerId) {
				// This was our active pointer going up. Choose a new
				// active pointer and adjust accordingly.
				final int newPointerIndex = pointerIndex == 0 ? 1 : 0;
				mLastTouchX = ev.getX(newPointerIndex);
				mLastTouchY = ev.getY(newPointerIndex);
				mActivePointerId = ev.getPointerId(newPointerIndex);
			}
			break;
		}
		}

		return true;
	}

	private class ScaleListener extends
			ScaleGestureDetector.SimpleOnScaleGestureListener {
		@Override
		public boolean onScale(ScaleGestureDetector detector) {
			mScaleFactor *= detector.getScaleFactor();

			// Don't let the object get too small or too large.
			mScaleFactor = Math.max(1.0f, Math.min(mScaleFactor, 3.0f));
			invalidate();
			return true;
		}
	}
}
