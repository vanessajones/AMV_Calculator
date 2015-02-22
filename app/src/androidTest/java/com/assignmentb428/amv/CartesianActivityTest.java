package com.assignmentb428.amv;

import android.app.Activity;
import android.content.Intent;
import android.test.ActivityInstrumentationTestCase2;
import android.test.UiThreadTest;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class CartesianActivityTest extends ActivityInstrumentationTestCase2<CartesianActivity> {

    private EditText v1x;
    private EditText v1y;

    private EditText v2x;
    private EditText v2y;

    private EditText v3x;
    private EditText v3y;

    Activity activity;

    private Button add;
    private Button cross;
    private Button dot;

    private TextView result;

    public CartesianActivityTest() {
        super(CartesianActivity.class);
    }

    public void setUp() throws Exception {
        super.setUp();

        activity = getActivity();

        // Set up buttons
        add = (Button)activity.findViewById(R.id.button2);
        dot = (Button)activity.findViewById(R.id.button3);
        cross = (Button)activity.findViewById(R.id.button4);

        // Set up input text fields
        v1x = (EditText)activity.findViewById(R.id.editText);
        v1y = (EditText)activity.findViewById(R.id.editText2);

        v2x = (EditText)activity.findViewById(R.id.editText3);
        v2y = (EditText)activity.findViewById(R.id.editText4);

        v3x = (EditText)activity.findViewById(R.id.editText5);
        v3y = (EditText)activity.findViewById(R.id.editText6);

        result = (TextView)activity.findViewById(R.id.textView4);
    }

    public void tearDown() throws Exception {
        activity.finish();
    }

    /**
     * Below are the VALID LOGIC test cases
     */

    // Test to add 2 vectors in cartesian form
    @UiThreadTest
    public void testAdd2() {
        v1x.setText("2");
        v1y.setText("2");

        v2x.setText("3");
        v2y.setText("-3");
        add.performClick();
        assertTrue(result.getText().toString().equals("Sum = (5.0, -1.0)"));
    }

    // Test to add 3 vectors in cartesian form
    @UiThreadTest
    public void testAdd3() {
        v1x.setText("2");
        v1y.setText("2");

        v2x.setText("3");
        v2y.setText("-3");

        v3x.setText("4");
        v3y.setText("5.3");
        add.performClick();
        assertTrue(result.getText().toString().equals("Sum = (9.0, 4.3)"));
    }

    // Test to compute dot product of 2 vectors in cartesian form
    @UiThreadTest
    public void testDot() {
        v1x.setText("2");
        v1y.setText("2");

        v2x.setText("-3");
        v2y.setText("-3");
        dot.performClick();
        assertTrue(result.getText().toString().equals("Dot Product = -12.0"));
    }

    //Test to compute cross product of 2 vectors in cartesian form
    @UiThreadTest
    public void testCross() {
        v1x.setText("2");
        v1y.setText("2");

        v2x.setText("3");
        v2y.setText("-3");
        cross.performClick();
        assertTrue(result.getText().toString().equals("Cross Product = 12.0"));
    }


    // Test invalid domain logic - Addition of 1 vector in cartesian form
    @UiThreadTest
    public void testAdd1() {
        v1x.setText("5");
        v1y.setText("4");

        add.performClick();
        assertTrue(result.getText().toString().equals("ERROR: Must input more than one vector."));
    }

    // Test invalid domain logic - Dot product of 1 vector in cartesian form
    @UiThreadTest
    public void testDot1() {
        v1x.setText("5");
        v1y.setText("4");

        dot.performClick();
        assertTrue(result.getText().toString().equals("ERROR: Must input more than one vector."));
    }

    // Test invalid domain logic - Cross product of 1 vector in cartesian form
    @UiThreadTest
    public void testCross1() {
        v1x.setText("5");
        v1y.setText("4");

        cross.performClick();
        assertTrue(result.getText().toString().equals("ERROR: Must input more than one vector."));
    }

    // Test invalid domain logic - Dot product of 3 vectors in cartesian form
    @UiThreadTest
    public void testDot3() {
        v1x.setText("5");
        v1y.setText("4");

        v2x.setText("5");
        v2y.setText("4");

        v3x.setText("5");
        v3y.setText("4");

        dot.performClick();
        assertTrue(result.getText().toString().equals("ERROR: Must input only two vectors!"));
    }

    // Test invalid domain logic - Cross product of 3 vectors in cartesian form
    @UiThreadTest
    public void testCross3() {
        v1x.setText("5");
        v1y.setText("4");

        v2x.setText("5");
        v2y.setText("4");

        v3x.setText("5");
        v3y.setText("4");

        cross.performClick();
        assertTrue(result.getText().toString().equals("ERROR: Must input only two vectors!"));
    }

    // Test invalid domain logic - All other invalid inputs
    // E.g: Missing one vector coordinate
    @UiThreadTest
    public void testOther() {
        v1x.setText("5");

        // Check addition with missing vector coordinates
        add.performClick();
        assertTrue(result.getText().toString().equals("Input Error"));

        // Check dot product with missing vector coordinates
        dot.performClick();
        assertTrue(result.getText().toString().equals("Input Error"));

        // Check cross product with missing vector coordinates
        cross.performClick();
        assertTrue(result.getText().toString().equals("Input Error"));
    }
}