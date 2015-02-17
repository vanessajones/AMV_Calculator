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


public class CartesianActivity extends ActionBarActivity {

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
            View rootView = inflater.inflate(R.layout.fragment_cartesian, container, false);
            return rootView;
        }
    }
    // Add the input vectors on the click
    public void add(View view) {
        Vector2D v1;
        Vector2D v2;
        Vector2D v3;
        Vector2D sum;

        double v1x, v1y, v2x, v2y, v3x, v3y;

        TextView result = (TextView) findViewById(R.id.textView4);

        EditText inputV1X = (EditText) findViewById(R.id.editText);
        EditText inputV1Y = (EditText) findViewById(R.id.editText2);

        EditText inputV2X = (EditText) findViewById(R.id.editText3);
        EditText inputV2Y = (EditText) findViewById(R.id.editText4);

        EditText inputV3X = (EditText) findViewById(R.id.editText5);
        EditText inputV3Y = (EditText) findViewById(R.id.editText6);

        if (!inputV1X.getText().toString().equals("") && !inputV1Y.getText().toString().equals("") && !inputV2X.getText().toString().equals("") && !inputV2Y.getText().toString().equals("") && !inputV3X.getText().toString().equals("") && !inputV3Y.getText().toString().equals("")) {
            try {
                v1x = Double.parseDouble(inputV1X.getText().toString());
                v1y = Double.parseDouble(inputV1Y.getText().toString());

                v2x = Double.parseDouble(inputV2X.getText().toString());
                v2y = Double.parseDouble(inputV2Y.getText().toString());

                v3x = Double.parseDouble(inputV3X.getText().toString());
                v3y = Double.parseDouble(inputV3Y.getText().toString());

                v1 = new Vector2D(v1x, v1y);
                v2 = new Vector2D(v2x, v2y);
                v3 = new Vector2D(v3x, v3y);
                sum = v1.add2(v2);
                sum = sum.add2(v3);

                result.setText("Sum = (" + sum.getX() + ", " + sum.getY() + ")");
            }
            catch (NumberFormatException e) {
                result.setText("Input Error123");
            }
        }
        else if (!inputV1X.getText().toString().equals("") && !inputV1Y.getText().toString().equals("") && !inputV3X.getText().toString().equals("") && !inputV3Y.getText().toString().equals("")) {
            try {
                v1x = Double.parseDouble(inputV1X.getText().toString());
                v1y = Double.parseDouble(inputV1Y.getText().toString());

                v3x = Double.parseDouble(inputV3X.getText().toString());
                v3y = Double.parseDouble(inputV3Y.getText().toString());

                v1 = new Vector2D(v1x, v1y);
                v3 = new Vector2D(v3x, v3y);
                sum = v1.add2(v3);
                result.setText("Sum = (" + sum.getX() + ", " + sum.getY() + ")");
            }
            catch (NumberFormatException e) {
                result.setText("Input Error13");
            }
        }
        else if (!inputV2X.getText().toString().equals("") && !inputV2Y.getText().toString().equals("") && !inputV3X.getText().toString().equals("") && !inputV3Y.getText().toString().equals("")) {
            try {
                v2x = Double.parseDouble(inputV2X.getText().toString());
                v2y = Double.parseDouble(inputV2Y.getText().toString());

                v3x = Double.parseDouble(inputV3X.getText().toString());
                v3y = Double.parseDouble(inputV3Y.getText().toString());

                v2 = new Vector2D(v2x, v2y);
                v3 = new Vector2D(v3x, v3y);
                sum = v2.add2(v3);
                result.setText("Sum = (" + sum.getX() + ", " + sum.getY() + ")");
            }
            catch (NumberFormatException e) {
                result.setText("Input Error23");
            }
        }
        else if (!inputV1X.getText().toString().equals("") && !inputV1Y.getText().toString().equals("") && !inputV2X.getText().toString().equals("") && !inputV2Y.getText().toString().equals("")) {
            try {
                v1x = Double.parseDouble(inputV1X.getText().toString());
                v1y = Double.parseDouble(inputV1Y.getText().toString());

                v2x = Double.parseDouble(inputV2X.getText().toString());
                v2y = Double.parseDouble(inputV2Y.getText().toString());

                v1 = new Vector2D(v1x, v1y);
                v2 = new Vector2D(v2x, v2y);
                sum = v1.add2(v2);
                result.setText("Sum = (" + sum.getX() + ", " + sum.getY() + ")");
            }
            catch (NumberFormatException e){
                result.setText("Input Error12");
            }
        }
        else {
            result.setText("Input Error");
        }
    }

    public void dot(View view) {
        Vector2D v1;
        Vector2D v2;
        Vector2D v3;
        Vector2D dot;

        double v1x, v1y, v2x, v2y, v3x, v3y;

        TextView result = (TextView) findViewById(R.id.textView4);

        EditText inputV1X = (EditText) findViewById(R.id.editText);
        EditText inputV1Y = (EditText) findViewById(R.id.editText2);

        EditText inputV2X = (EditText) findViewById(R.id.editText3);
        EditText inputV2Y = (EditText) findViewById(R.id.editText4);

        EditText inputV3X = (EditText) findViewById(R.id.editText5);
        EditText inputV3Y = (EditText) findViewById(R.id.editText6);

        if (!inputV1X.getText().toString().equals("") && !inputV1Y.getText().toString().equals("") && !inputV2X.getText().toString().equals("") && !inputV2Y.getText().toString().equals("") && !inputV3X.getText().toString().equals("") && !inputV3Y.getText().toString().equals("")) {
            result.setText("Only 2 Vectors!");
        }
        else if (!inputV1X.getText().toString().equals("") && !inputV1Y.getText().toString().equals("") && !inputV3X.getText().toString().equals("") && !inputV3Y.getText().toString().equals("")) {
            try {
                v1x = Double.parseDouble(inputV1X.getText().toString());
                v1y = Double.parseDouble(inputV1Y.getText().toString());

                v3x = Double.parseDouble(inputV3X.getText().toString());
                v3y = Double.parseDouble(inputV3Y.getText().toString());

                v1 = new Vector2D(v1x, v1y);
                v3 = new Vector2D(v3x, v3y);

                result.setText("Dot Product = " + v1.dotProduct(v3));
            }
            catch (NumberFormatException e) {
                result.setText("Input Error13");
            }
        }
        else if (!inputV2X.getText().toString().equals("") && !inputV2Y.getText().toString().equals("") && !inputV3X.getText().toString().equals("") && !inputV3Y.getText().toString().equals("")) {
            try {
                v2x = Double.parseDouble(inputV2X.getText().toString());
                v2y = Double.parseDouble(inputV2Y.getText().toString());

                v3x = Double.parseDouble(inputV3X.getText().toString());
                v3y = Double.parseDouble(inputV3Y.getText().toString());

                v2 = new Vector2D(v2x, v2y);
                v3 = new Vector2D(v3x, v3y);

                result.setText("Dot Product = " + v2.dotProduct(v3));
            }
            catch (NumberFormatException e) {
                result.setText("Input Error23");
            }
        }
        else if (!inputV1X.getText().toString().equals("") && !inputV1Y.getText().toString().equals("") && !inputV2X.getText().toString().equals("") && !inputV2Y.getText().toString().equals("")) {
            try {
                v1x = Double.parseDouble(inputV1X.getText().toString());
                v1y = Double.parseDouble(inputV1Y.getText().toString());

                v2x = Double.parseDouble(inputV2X.getText().toString());
                v2y = Double.parseDouble(inputV2Y.getText().toString());

                v1 = new Vector2D(v1x, v1y);
                v2 = new Vector2D(v2x, v2y);

                result.setText("Dot Product = " + v1.dotProduct(v2));
            }
            catch (NumberFormatException e){
                result.setText("Input Error12");
            }
        }
        else {
            result.setText("Input Error");
        }
    }

    public void cross(View view) {
        Vector2D v1;
        Vector2D v2;
        Vector2D v3;
        Vector2D cross;

        double v1x, v1y, v2x, v2y, v3x, v3y;

        TextView result = (TextView) findViewById(R.id.textView4);

        EditText inputV1X = (EditText) findViewById(R.id.editText);
        EditText inputV1Y = (EditText) findViewById(R.id.editText2);

        EditText inputV2X = (EditText) findViewById(R.id.editText3);
        EditText inputV2Y = (EditText) findViewById(R.id.editText4);

        EditText inputV3X = (EditText) findViewById(R.id.editText5);
        EditText inputV3Y = (EditText) findViewById(R.id.editText6);

        if (!inputV1X.getText().toString().equals("") && !inputV1Y.getText().toString().equals("") && !inputV2X.getText().toString().equals("") && !inputV2Y.getText().toString().equals("") && !inputV3X.getText().toString().equals("") && !inputV3Y.getText().toString().equals("")) {
            result.setText("Only 2 Vectors!");
        }
        else if (!inputV1X.getText().toString().equals("") && !inputV1Y.getText().toString().equals("") && !inputV3X.getText().toString().equals("") && !inputV3Y.getText().toString().equals("")) {
            try {
                v1x = Double.parseDouble(inputV1X.getText().toString());
                v1y = Double.parseDouble(inputV1Y.getText().toString());

                v3x = Double.parseDouble(inputV3X.getText().toString());
                v3y = Double.parseDouble(inputV3Y.getText().toString());

                v1 = new Vector2D(v1x, v1y);
                v3 = new Vector2D(v3x, v3y);
                cross = Vector2D.crossProduct(v1, v3);
                result.setText("Cross Product = (" + cross.getX() + ", " + cross.getY() + ")");
            }
            catch (NumberFormatException e) {
                result.setText("Input Error13");
            }
        }
        else if (!inputV2X.getText().toString().equals("") && !inputV2Y.getText().toString().equals("") && !inputV3X.getText().toString().equals("") && !inputV3Y.getText().toString().equals("")) {
            try {
                v2x = Double.parseDouble(inputV2X.getText().toString());
                v2y = Double.parseDouble(inputV2Y.getText().toString());

                v3x = Double.parseDouble(inputV3X.getText().toString());
                v3y = Double.parseDouble(inputV3Y.getText().toString());

                v2 = new Vector2D(v2x, v2y);
                v3 = new Vector2D(v3x, v3y);
                cross = Vector2D.crossProduct(v2, v3);
                result.setText("Cross Product = (" + cross.getX() + ", " + cross.getY() + ")");
            }
            catch (NumberFormatException e) {
                result.setText("Input Error23");
            }
        }
        else if (!inputV1X.getText().toString().equals("") && !inputV1Y.getText().toString().equals("") && !inputV2X.getText().toString().equals("") && !inputV2Y.getText().toString().equals("")) {
            try {
                v1x = Double.parseDouble(inputV1X.getText().toString());
                v1y = Double.parseDouble(inputV1Y.getText().toString());

                v2x = Double.parseDouble(inputV2X.getText().toString());
                v2y = Double.parseDouble(inputV2Y.getText().toString());

                v1 = new Vector2D(v1x, v1y);
                v2 = new Vector2D(v2x, v2y);
                cross = Vector2D.crossProduct(v1, v2);
                result.setText("Cross Product = (" + cross.getX() + ", " + cross.getY() + ")");
            }
            catch (NumberFormatException e){
                result.setText("Input Error12");
            }
        }
        else {
            result.setText("Input Error");
        }
    }
    public void polar(View view) {
        Intent intent = new Intent(this, PolarActivity.class);
        startActivity(intent);
    }
}