package com.assignmentb428.amv;

import android.app.Application;
import android.test.ApplicationTestCase;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class ApplicationTest extends ApplicationTestCase<Application> {
    public ApplicationTest() {
        super(Application.class);
    }

    public void testAdd() {
        Vector2D v1 = new Vector2D(1.0, 1.0);
        Vector2D v2 = new Vector2D(3.0, -5.0);
        Vector2D sum = v1.add2(v2);
        assertEquals(true, (sum.getX() == 4.0 && sum.getY() == -4.0));
    }

    public void testDot() {
        Vector2D v1 = new Vector2D(1.0, 1.0);
        Vector2D v2 = new Vector2D(3.0, -5.0);

        assertEquals(-2.0, v1.dotProduct(v2));
    }

    public void testCross() {
        Vector2D v1 = new Vector2D(1.0, 1.0);
        Vector2D v2 = new Vector2D(3.0, -5.0);

        assertEquals(8.0, Vector2D.crossProduct(v1, v2));
    }
}