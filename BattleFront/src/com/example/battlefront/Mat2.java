package com.example.battlefront;

//2d column matrix
/*
| 0 2 |
| 1 3 |
*/
public class Mat2 {

public static float[] vals = new float[4];

public Mat2() {
}

public Mat2(float m0, float m1, float m2, float m3) {
 vals[0] = m0;
 vals[1] = m1;
 vals[2] = m2;
 vals[3] = m3;
}

public Mat2(float[] vals) {
 this.vals = vals;
}

public static Vec2 mult(Vec2 v, Mat2 m) {
 float x = v.x*m.vals[0] + v.y*m.vals[1];
 float y = v.x*m.vals[2] + v.y*m.vals[3];
 return new Vec2(x, y);
}

public void mult(float scl) {
 vals[0]*=scl;
 vals[1]*=scl;
 vals[2]*=scl;
 vals[3]*=scl;
}

public float determinant() {
 return vals[0]*vals[3] - vals[1]*vals[2];
}

public void identity() {
 vals[0] = 1;
 vals[1] = 0;
 vals[2] = 0;
 vals[3] = 1;
}

public void transpose() {
 float n = vals[1];
 vals[1] = vals[2];
 vals[2] = n;
}

public void inverse() {
 float d = determinant();
 float dr = 1/d;
 Mat2 m = new Mat2(vals[3], -vals[1], -vals[2], vals[0]);
 m.mult(dr);
 set(m);
}

public void set(Mat2 m) {
 vals[0] = m.vals[0];
 vals[1] = m.vals[1];
 vals[2] = m.vals[2];
 vals[3] = m.vals[3];
}

public void printInfo(){
 System.out.println("| " + vals[0]+", " + vals[2]+" |\n" +
                    "| " + vals[1]+", " + vals[3]+" |");
}
}
