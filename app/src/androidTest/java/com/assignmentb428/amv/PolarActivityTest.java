package com.assignmentb428.amv;

import android.app.Activity;
import android.test.ActivityInstrumentationTestCase2;
import android.test.UiThreadTest;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class PolarActivityTest extends ActivityInstrumentationTestCase2<PolarActivity> {

    private EditText v1;
    private EditText theta1;

    private EditText v2;
    private EditText theta2;

    private EditText v3;
    private EditText theta3;

    Activity activity;

    private Button add;
    private Button cross;
    private Button dot;

    private TextView result;

    public PolarActivityTest() {
        super(PolarActivity.class);
    }
    public void setUp() throws Exception {
        super.setUp();
        activity = getActivity();

        // Set up buttons
        add = (Button)activity.findViewById(R.id.button2);
        dot = (Button)activity.findViewById(R.id.button3);
        cross = (Button)activity.findViewById(R.id.button4);

        // Set up input text fields
        v1 = (EditText)activity.findViewById(R.id.editText);
        theta1 = (EditText)activity.findViewById(R.id.editText2);

        v2 = (EditText)activity.findViewById(R.id.editText3);
        theta2 = (EditText)activity.findViewById(R.id.editText4);

        v3 = (EditText)activity.findViewById(R.id.editText5);
        theta3 = (EditText)activity.findViewById(R.id.editText6);

        result = (TextView)activity.findViewById(R.id.textView4);
    }

    public void tearDown() throws Exception {
        activity.finish();
    }

    // Test to add 2 vectors in polar form
    @UiThreadTest
    public void testAdd2_Polar() {
        v1.setText("5");
        theta1.setText("60");

        v2.setText("3");
        theta2.setText("35");

        add.performClick();
        assertTrue(result.getText().toString().equals("Sum = (7.82, 50.67°)"));
    }

    // Test to add 3 vectors in polar form
    @UiThreadTest
    public void testAdd3_Polar() {
        v1.setText("5");
        theta1.setText("60");

        v2.setText("3");
        theta2.setText("35");

        v3.setText("-1.5");
        theta3.setText("270");

        add.performClick();
        assertTrue(result.getText().toString().equals("Sum = (9.03, 56.71°)"));
    }
    // Test to compute dot product of 2 vectors in polar form
    @UiThreadTest
    public void testDot_Polar() {
        v1.setText("5");
        theta1.setText("60");

        v2.setText("3");
        theta2.setText("35");

        dot.performClick();
        assertTrue(result.getText().toString().equals("Dot Product = 13.59"));
    }
    // Test to compute cross product of 2 vectors in polar form
    @UiThreadTest
    public void testCross_Polar() {
        v1.setText("5");
        theta1.setText("60");

        v2.setText("3");
        theta2.setText("35");

        cross.performClick();
        assertTrue(result.getText().toString().equals("Cross Product = 6.34"));
    }

    /**
     * Test invalid domain logic - Addition of 1 vector in polar form
     */
    @UiThreadTest
    public void testAdd1_Polar() {
        v1.setText("5");
        theta1.setText("60");

        add.performClick();
        assertTrue(result.getText().toString().equals("ERROR: Must input more than one vector."));

    }

    /**
     * Test invalid domain logic - Dot product of 1 vector in polar form
     */
    @UiThreadTest
    public void testDot1_Polar() {
        v1.setText("5");
        theta1.setText("60");

        dot.performClick();
        assertTrue(result.getText().toString().equals("ERROR: Must input more than one vector."));
    }

    /**
     * Test invalid domain logic - Cross product of 1 vector in polar form
     */
    @UiThreadTest
    public void testCross1_Polar() {
        v1.setText("5");
        theta1.setText("60");

        cross.performClick();
        assertTrue(result.getText().toString().equals("ERROR: Must input more than one vector."));
    }

    /**
     * Test invalid domain logic - Dot product of 3 vectors in polar form
     */
    @UiThreadTest
    public void testDot3_Polar() {
        v1.setText("5");
        theta1.setText("60");

        v2.setText("5");
        theta2.setText("60");

        v3.setText("5");
        theta3.setText("60");

        dot.performClick();
        assertTrue(result.getText().toString().equals("ERROR: Must input only two vectors!"));
    }
    /**
     * Test invalid domain logic - Cross product of 3 vectors in polar form
     */
    @UiThreadTest
    public void testCross3_Polar() {
        v1.setText("5");
        theta1.setText("60");

        v2.setText("5");
        theta2.setText("60");

        v3.setText("5");
        theta3.setText("60");

        cross.performClick();
        assertTrue(result.getText().toString().equals("ERROR: Must input only two vectors!"));
    }
}