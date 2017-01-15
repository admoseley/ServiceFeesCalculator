package com.adrianmoseley.servicefeescalculator;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class SquareActivity extends AppCompatActivity {
    public double sqAmount;
    public double sqFinal;
    public double sqFees;
    public EditText sqAmountET;
    public TextView sqFinalLargeTxt;
    public TextView sqFeesLargeTxt;
    public Button sqcalculate;
    public Button sqclearbtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_square);
        sqAmountET = (EditText) findViewById(R.id.squareAmountEditText);
        sqFinalLargeTxt = (TextView) findViewById(R.id.squareLargeTxt);
        sqFeesLargeTxt = (TextView) findViewById(R.id.squareFeesLargeTxt);
        sqcalculate = (Button) findViewById(R.id.squarecalculateBtn);
        sqclearbtn = (Button) findViewById(R.id.squareclearbtn);
        sqAmountET.setFocusable(true);
        TextView tv = (TextView) findViewById(R.id.squaredisclaimer);
        tv.setText(Html.fromHtml("<b>Not Affiliated with SQUARE.COM </b>  " +
                " <br /> <a href=\"https://squareup.com/help/us/en/article/5068-square-s-fees-and-pricing\"> Click here to view SQUARE.COM Fees.</a>"));
        tv.setMovementMethod(LinkMovementMethod.getInstance());


        sqFeesLargeTxt.setTextIsSelectable(true);
        sqFinalLargeTxt.setTextIsSelectable(true);

        sqcalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {

                    sqAmount = Double.parseDouble(sqAmountET.getText().toString());


                } catch (NumberFormatException e) {

                    sqAmount = 0.00;

                }

                if (sqAmount == 0.00) {
                    Toast.makeText(getApplicationContext(), "Please enter a value greater than Zero", Toast.LENGTH_LONG).show();
                    sqAmountET.setText("");
                    sqAmountET.setFocusable(true);
                    sqFinalLargeTxt.setText("0.00");
                    sqFeesLargeTxt.setText("0.00");

                } else {
                    sqFinal = (sqAmount + .3) / .971;
                    sqFees = (sqFinal * .029) + .3;
                    sqFinalLargeTxt.setText(String.format("%.2f", sqFinal));
                    sqFeesLargeTxt.setText(String.format("%.2f", sqFees));
                    sqAmountET.setFocusable(true);

                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(sqAmountET.getWindowToken(), 0);
                }
            }
        });

        sqclearbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sqAmountET.setText("");
                sqFinalLargeTxt.setText("0.00");
                sqFeesLargeTxt.setText("0.00");
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(sqAmountET.getWindowToken(), 0);

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_square, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.square_about) {
            Toast.makeText(SquareActivity.this,"Created by Adrian D. Moseley for free use by all. 2017",  Toast.LENGTH_SHORT).show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
