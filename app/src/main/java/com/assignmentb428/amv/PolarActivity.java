package com.assignmentb428.amv;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.widget.EditText;
import android.widget.TextView;
import java.text.DecimalFormat;
import android.widget.Button;


public class PolarActivity extends ActionBarActivity {

    public double sumx, sumy;
    public Button display;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cartesian);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_cartesian, menu);
        display = (Button) findViewById(R.id.buttonDisplay);
        display.setVisibility(View.INVISIBLE);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_polar, container, false);
            return rootView;
        }
    }

    // Add the input vectors on the click
    public void add(View view) {

        double v1_rho, v1_theta, v2_rho, v2_theta, v3_rho, v3_theta;
        Vector2D sum;

        TextView result = (TextView) findViewById(R.id.textView4);

        EditText inputV1X = (EditText) findViewById(R.id.editText);
        EditText inputV1Y = (EditText) findViewById(R.id.editText2);

        EditText inputV2X = (EditText) findViewById(R.id.editText3);
        EditText inputV2Y = (EditText) findViewById(R.id.editText4);

        EditText inputV3X = (EditText) findViewById(R.id.editText5);
        EditText inputV3Y = (EditText) findViewById(R.id.editText6);

        /* User inputs THREE VECTORS */
        if (!inputV1X.getText().toString().equals("") && !inputV1Y.getText().toString().equals("") && !inputV2X.getText().toString().equals("") && !inputV2Y.getText().toString().equals("") && !inputV3X.getText().toString().equals("") && !inputV3Y.getText().toString().equals("")) {

            v1_rho = Double.parseDouble(inputV1X.getText().toString());
            v1_theta = Double.parseDouble(inputV1Y.getText().toString());

            v2_rho = Double.parseDouble(inputV2X.getText().toString());
            v2_theta = Double.parseDouble(inputV2Y.getText().toString());

            v3_rho = Double.parseDouble(inputV3X.getText().toString());
            v3_theta = Double.parseDouble(inputV3Y.getText().toString());

            sum = Vector2D.add3Polar(v1_rho, v1_theta, v2_rho, v2_theta, v3_rho, v3_theta);

            sumx = sum.getX();
            sumy = sum.getY();

                /* Convert back to polar */
            double radius = Math.sqrt(sum.getX() * sum.getX() + sum.getY() * sum.getY());
            double angleInDegrees = Math.toDegrees(Math.acos(sum.getX() / radius));

                /* only two decimal places displayed */
            DecimalFormat numberFormat = new DecimalFormat("#.00");
            display.setVisibility(View.VISIBLE);
            result.setText("Sum = (" + numberFormat.format(radius) + ", " + numberFormat.format(angleInDegrees) + "°)");
        }

        /* User Inputs TWO VECTORS */
        else if (!inputV1X.getText().toString().equals("") && !inputV1Y.getText().toString().equals("") && !inputV3X.getText().toString().equals("") && !inputV3Y.getText().toString().equals("")) {

            v1_rho = Double.parseDouble(inputV1X.getText().toString());
            v1_theta = Double.parseDouble(inputV1Y.getText().toString());

            v3_rho = Double.parseDouble(inputV3X.getText().toString());
            v3_theta = Double.parseDouble(inputV3Y.getText().toString());

            sum = Vector2D.add2Polar(v1_rho, v1_theta, v3_rho, v3_theta);

            sumx = sum.getX();
            sumy = sum.getY();

                 /* Convert back to polar */
            double radius = Math.sqrt(sum.getX() * sum.getX() + sum.getY() * sum.getY());
            double angleInDegrees = Math.toDegrees(Math.acos(sum.getX() / radius));

                /* only two decimal places displayed */
            DecimalFormat numberFormat = new DecimalFormat("#.00");
            display.setVisibility(View.VISIBLE);
            result.setText("Sum = (" + numberFormat.format(radius) + ", " + numberFormat.format(angleInDegrees) + "°)");

        }
        else if (!inputV2X.getText().toString().equals("") && !inputV2Y.getText().toString().equals("") && !inputV3X.getText().toString().equals("") && !inputV3Y.getText().toString().equals("")) {

            v2_rho = Double.parseDouble(inputV2X.getText().toString());
            v2_theta = Double.parseDouble(inputV2Y.getText().toString());

            v3_rho = Double.parseDouble(inputV3X.getText().toString());
            v3_theta = Double.parseDouble(inputV3Y.getText().toString());

            sum = Vector2D.add2Polar(v2_rho, v2_theta, v3_rho, v3_theta);

            sumx = sum.getX();
            sumy = sum.getY();

                 /* Convert back to polar */
            double radius = Math.sqrt(sum.getX() * sum.getX() + sum.getY() * sum.getY());
            double angleInDegrees = Math.toDegrees(Math.acos(sum.getX() / radius));

                /* only two decimal places displayed */
            DecimalFormat numberFormat = new DecimalFormat("#.00");
            display.setVisibility(View.VISIBLE);
            result.setText("Sum = (" + numberFormat.format(radius) + ", " + numberFormat.format(angleInDegrees) + "°)");


        }
        else if (!inputV1X.getText().toString().equals("") && !inputV1Y.getText().toString().equals("") && !inputV2X.getText().toString().equals("") && !inputV2Y.getText().toString().equals("")) {

            v1_rho = Double.parseDouble(inputV1X.getText().toString());
            v1_theta = Double.parseDouble(inputV1Y.getText().toString());

            v2_rho = Double.parseDouble(inputV2X.getText().toString());
            v2_theta = Double.parseDouble(inputV2Y.getText().toString());

            sum = Vector2D.add2Polar(v1_rho, v1_theta, v2_rho, v2_theta);

            sumx = sum.getX();
            sumy = sum.getY();

                 /* Convert back to polar */
            double radius = Math.sqrt(sum.getX() * sum.getX() + sum.getY() * sum.getY());
            double angleInDegrees = Math.toDegrees(Math.acos(sum.getX() / radius));

                /* only two decimal places displayed */
            DecimalFormat numberFormat = new DecimalFormat("#.00");
            display.setVisibility(View.VISIBLE);
            result.setText("Sum = (" + numberFormat.format(radius) + ", " + numberFormat.format(angleInDegrees) + "°)");

        }
        else {
            result.setText("Input Error");
        }
        display.setVisibility(View.INVISIBLE);
    }

    public void dot(View view) {
        Vector2D v1;
        Vector2D v2;
        Vector2D v3;
        Vector2D dot;

        double v1_rho, v1_theta, v2_rho, v2_theta, v3_rho, v3_theta;

        TextView result = (TextView) findViewById(R.id.textView4);

        EditText inputV1X = (EditText) findViewById(R.id.editText);
        EditText inputV1Y = (EditText) findViewById(R.id.editText2);

        EditText inputV2X = (EditText) findViewById(R.id.editText3);
        EditText inputV2Y = (EditText) findViewById(R.id.editText4);

        EditText inputV3X = (EditText) findViewById(R.id.editText5);
        EditText inputV3Y = (EditText) findViewById(R.id.editText6);

        if (!inputV1X.getText().toString().equals("") && !inputV1Y.getText().toString().equals("") && !inputV3X.getText().toString().equals("") && !inputV3Y.getText().toString().equals("")) {

            v1_rho = Double.parseDouble(inputV1X.getText().toString());
            v1_theta = Double.parseDouble(inputV1Y.getText().toString());

            v3_rho = Double.parseDouble(inputV3X.getText().toString());
            v3_theta = Double.parseDouble(inputV3Y.getText().toString());

            v1 = Vector2D.polarToCartesian(v1_rho, v1_theta);
            v3 = Vector2D.polarToCartesian(v3_rho, v3_theta);

            DecimalFormat numberFormat = new DecimalFormat("#.00");

            result.setText("Dot Product = " + numberFormat.format(v1.dotProduct(v3)));


        }
        else if (!inputV2X.getText().toString().equals("") && !inputV2Y.getText().toString().equals("") && !inputV3X.getText().toString().equals("") && !inputV3Y.getText().toString().equals("")) {

            v2_rho = Double.parseDouble(inputV2X.getText().toString());
            v2_theta = Double.parseDouble(inputV2Y.getText().toString());

            v3_rho = Double.parseDouble(inputV3X.getText().toString());
            v3_theta = Double.parseDouble(inputV3Y.getText().toString());

            v2 = Vector2D.polarToCartesian(v2_rho, v2_theta);
            v3 = Vector2D.polarToCartesian(v3_rho, v3_theta);

            DecimalFormat numberFormat = new DecimalFormat("#.00");
            result.setText("Dot Product = " + numberFormat.format(v2.dotProduct(v3)));

        }
        else if (!inputV1X.getText().toString().equals("") && !inputV1Y.getText().toString().equals("") && !inputV2X.getText().toString().equals("") && !inputV2Y.getText().toString().equals("")) {

            v1_rho = Double.parseDouble(inputV1X.getText().toString());
            v1_theta = Double.parseDouble(inputV1Y.getText().toString());

            v2_rho = Double.parseDouble(inputV2X.getText().toString());
            v2_theta = Double.parseDouble(inputV2Y.getText().toString());

            v1 = Vector2D.polarToCartesian(v1_rho, v1_theta);
            v2 = Vector2D.polarToCartesian(v2_rho, v2_theta);

            DecimalFormat numberFormat = new DecimalFormat("#.00");
            result.setText("Dot Product = " + numberFormat.format(v1.dotProduct(v2)));

        }
        else {
            result.setText("Input Error");
        }

        display.setVisibility(View.INVISIBLE);
    }

    

    /* Cross product of two vector */
    public void cross(View view) {
        Vector2D v1;
        Vector2D v2;
        Vector2D v3;
        double crossProduct;

        double v1_rho, v1_theta, v2_rho, v2_theta, v3_rho, v3_theta;

        TextView result = (TextView) findViewById(R.id.textView4);

        EditText inputV1X = (EditText) findViewById(R.id.editText);
        EditText inputV1Y = (EditText) findViewById(R.id.editText2);

        EditText inputV2X = (EditText) findViewById(R.id.editText3);
        EditText inputV2Y = (EditText) findViewById(R.id.editText4);

        EditText inputV3X = (EditText) findViewById(R.id.editText5);
        EditText inputV3Y = (EditText) findViewById(R.id.editText6);


        if (!inputV1X.getText().toString().equals("") && !inputV1Y.getText().toString().equals("") && !inputV3X.getText().toString().equals("") && !inputV3Y.getText().toString().equals("")) {

            v1_rho = Double.parseDouble(inputV1X.getText().toString());
            v1_theta = Double.parseDouble(inputV1Y.getText().toString());

            v3_rho = Double.parseDouble(inputV3X.getText().toString());
            v3_theta = Double.parseDouble(inputV3Y.getText().toString());

            v1 = Vector2D.polarToCartesian(v1_rho, v1_theta);
            v3 = Vector2D.polarToCartesian(v3_rho, v3_theta);

            crossProduct = Vector2D.crossProduct(v1,v3);

            DecimalFormat numberFormat = new DecimalFormat("#.00");
            result.setText("Cross Product = " + numberFormat.format(crossProduct));

        }
        else if (!inputV2X.getText().toString().equals("") && !inputV2Y.getText().toString().equals("") && !inputV3X.getText().toString().equals("") && !inputV3Y.getText().toString().equals("")) {

            v2_rho = Double.parseDouble(inputV2X.getText().toString());
            v2_theta = Double.parseDouble(inputV2Y.getText().toString());

            v3_rho = Double.parseDouble(inputV3X.getText().toString());
            v3_theta = Double.parseDouble(inputV3Y.getText().toString());

            v2 = Vector2D.polarToCartesian(v2_rho, v2_theta);
            v3 = Vector2D.polarToCartesian(v3_rho, v3_theta);

            crossProduct = Vector2D.crossProduct(v2,v3);

            DecimalFormat numberFormat = new DecimalFormat("#.00");
            result.setText("Cross Product = " + numberFormat.format(crossProduct));


        }
        else if (!inputV1X.getText().toString().equals("") && !inputV1Y.getText().toString().equals("") && !inputV2X.getText().toString().equals("") && !inputV2Y.getText().toString().equals("")) {

            v1_rho = Double.parseDouble(inputV1X.getText().toString());
            v1_theta = Double.parseDouble(inputV1Y.getText().toString());

            v2_rho = Double.parseDouble(inputV2X.getText().toString());
            v2_theta = Double.parseDouble(inputV2Y.getText().toString());

            v1 = Vector2D.polarToCartesian(v1_rho, v1_theta);
            v2 = Vector2D.polarToCartesian(v2_rho, v2_theta);

            crossProduct = Vector2D.crossProduct(v1,v2);

            DecimalFormat numberFormat = new DecimalFormat("#.00");
            result.setText("Cross Product = " + numberFormat.format(crossProduct));

        }
        else {
            result.setText("Input Error");
        }
        display.setVisibility(View.INVISIBLE);
    }

}