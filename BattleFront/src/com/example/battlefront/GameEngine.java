package com.example.battlefront;

import android.content.Context;
import android.graphics.Path;
import android.view.View;

public class GameEngine extends View {

	private int hexW = 25;
	private int hexH = 25;
	private Path hexpath = new Path();

	public GameEngine(Context context) {
		super(context);
		// mScaleDetector = new ScaleGestureDetector(context, new
		// ScaleListener());
		// alertDialog = new AlertDialog.Builder(context).create();
	}

	public void init() {
		hexpath.reset();
		hexpath.moveTo(0, 0);
		int x_i;
		int y_i;
		int angle;

		for (int i = 0; i < 6; i++) {
			angle = (int) (2 * Math.PI / 6 * (i + 0.5));
			x_i = (int) (12 + 25 * Math.cos(angle));
			y_i = (int) (12 + 25 * Math.sin(angle));
			if (i == 0)
				hexpath.moveTo(x_i, y_i);
			else
				hexpath.lineTo(x_i, y_i);
		}

	}

	public void onDraw() {
		hexpath.reset();
		hexpath.moveTo(0, 0);
		int x_i;
		int y_i;
		int angle;

		for (int i = 0; i < 6; i++) {
			angle = (int) (2 * Math.PI / 6 * (i + 0.5));
			x_i = (int) (12 + 25 * Math.cos(angle));
			y_i = (int) (12 + 25 * Math.sin(angle));
			if (i == 0)
				hexpath.moveTo(x_i, y_i);
			else
				hexpath.lineTo(x_i, y_i);
		}
	}

}
