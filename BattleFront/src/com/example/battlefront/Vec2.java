package com.example.battlefront;

import java.lang.Math;
import android.util.FloatMath;

public class Vec2 {

	  public float x, y;

	  public Vec2() {
	  }

	  public Vec2(float x, float y) {
	    this.x = x;
	    this.y = y;
	  }

	  public void mult(float scl) {
	    x*=scl;
	    y*=scl;
	  }

	  public void div(float scl) {
	    x/=scl;
	    y/=scl;
	  }

	  public void add(float scl) {
	    x+=scl;
	    y+=scl;
	  }

	  public void sub(float scl) {
	    x-=scl;
	    y-=scl;
	  }

	  public float dot(Vec2 v) {
	    return v.x*x + v.y*y;
	  }


	  public float mag() {
	    return FloatMath.sqrt(x*x + y*y);
	  }

	  public void normalize() {
	    float m = mag();
	    div(m);
	  }
	}
