package com.assignmentb428.amv;
/**
 * Created by Julien Liberta on 2015-02-15.
 */
import java.lang.Math;
public class Vector2D {

    public double x;
    public double y;
    /*
     * Constructor with no parameters make a 0 vector
     */
    public Vector2D() {
        x = 0;
        y = 0;
    }
    /*
     * Constructor with a vector as a parameter make a copy of that vector
     */
    public Vector2D(Vector2D v) {
        x = v.x;
        y = v.y;
    }
    /*
     * Constructor with two double
     */
    public Vector2D(double x1, double y1) {
        x = x1;
        y = y1;
    }
    public void setTo(double x1, double y1) {
        x = x1;
        y = y1;
    }
    public void setTo(Vector2D v) {
        x = v.x;
        y = v.y;
    }
    /*
     * add a vector to this vector
     */
    public void add(Vector2D v) {
        x += v.x;
        y += v.y;
    }
    public Vector2D add2(Vector2D v) {
        return new Vector2D(x + v.x,y+v.y);
    }
    /*
     * add a vector from two double to this vector
     */
    public void add(double x1, double y1) {
        x += x1;
        y += y1;
    }
    /*
     * static add for two vectors
     */
    public static Vector2D add(Vector2D v, Vector2D v2) {

        return new Vector2D(v.x + v2.x, v.y + v2.y);
    }
    /*
     * subtract vector to this vector
     */
    public void subtract(Vector2D v) {
        x -= v.x;
        y -= v.y;
    }
    public void subtract(double x1, double y1) {
        x -= x1;
        y -= y1;
    }
    /*
     * static subtract two vectors
     */
    public static Vector2D subtract(Vector2D v, Vector2D v2) {

        return new Vector2D(v.x - v2.x, v.y - v2.y);
    }
    /*
     * divide this vector on a double
     */
    public void divide(double d) {
        x /= d;
        y /= d;
    }
    /*
     * return a new copy of this divided by a double
     */
    public Vector2D divide2(double d) {
        return (new Vector2D(x / d,y /d));

    }
    /*
     * multiply this vector with a double
     */
    public void multiply(double d) {
        x *= d;
        y *= d;
    }
    public Vector2D multiply2(double d) {
        return new Vector2D( x *d,y * d);
    }


    /*
     * returns the dot product of this with a vector v
     */
    public double dotProduct(Vector2D v) {
        double cp = this.x * v.x + this.y * v.y;
        return cp;
    }
    public double dotProduct(double x1, double y1) {
        double cp = this.x * x + this.y * y;
        return cp;
    }
    /*
     * returns the crossproduct of two vectors
     */
    public static double crossProduct(Vector2D v1, Vector2D v2) {
        return (v1.y * v2.x - v1.x * v2.y);
    }
    /*
     * returns the length of this vector
     */
    public double length() {
        return Math.sqrt(x * x + y * y);
    }
    /*
     * makes the length of this vector 1
     */
    public void normalize() {
        double length = length();
        x = x / length;
        y = y / length;
    }
    public Vector2D normalize2() {
        double length = length();
        return new Vector2D( x / length,y / length);
    }
    /*
     * makes this a 0 vector
     */
    public void setToZero() {
        x = 0;
        y = 0;
    }

    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }

    public static Vector2D polarToCartesian(double v1_rho, double v1_theta) {
        Vector2D vector = new Vector2D();
        vector.x = Math.cos(Math.toRadians(v1_theta))*v1_rho;
        vector.y = Math.sin(Math.toRadians(v1_theta))*v1_rho;
        return vector;
    }

    public static Vector2D add3Polar(double v1_rho, double v1_theta, double v2_rho, double v2_theta, double v3_rho, double v3_theta) {

        Vector2D v1 = new Vector2D();
        Vector2D v2 = new Vector2D();
        Vector2D v3 = new  Vector2D();
        Vector2D sum = new Vector2D();

         /* convert to cartesian */
        v1.x = Math.cos(Math.toRadians(v1_theta))*v1_rho;
        v1.y = Math.sin(Math.toRadians(v1_theta))*v1_rho;
        v2.x = Math.cos(Math.toRadians(v2_theta))*v2_rho;
        v2.y = Math.sin(Math.toRadians(v2_theta))*v2_rho;
        v3.x = Math.cos(Math.toRadians(v3_theta))*v3_rho;
        v3.y = Math.sin(Math.toRadians(v3_theta))*v3_rho;
        sum = v1.add2(v2);
        sum = sum.add2(v3);

        return sum;

    }

    public static Vector2D add2Polar(double v1_rho, double v1_theta, double v2_rho, double v2_theta) {

        Vector2D v1 = new Vector2D();
        Vector2D v2 = new Vector2D();
        Vector2D sum = new Vector2D();

         /* convert to cartesian */
        v1.x = Math.cos(Math.toRadians(v1_theta))*v1_rho;
        v1.y = Math.sin(Math.toRadians(v1_theta))*v1_rho;
        v2.x = Math.cos(Math.toRadians(v2_theta))*v2_rho;
        v2.y = Math.sin(Math.toRadians(v2_theta))*v2_rho;

        sum = v1.add2(v2);

        return sum;

    }
}
