package com.adrianmoseley.servicefeescalculator;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
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

public class StripeActivity extends ActionBarActivity {
    public double stripeAmount;
    public double stripeFinal;
    public double stripeFees;
    public EditText stripeAmountET;
    public TextView stripeFinalLargeTxt;
    public TextView stripeFeesLargeTxt;
    public Button stripecalculate;
    public Button stripeclearbtn;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stripe);
        stripeAmountET = (EditText) findViewById(R.id.stripeAmountEditText);
        stripeFinalLargeTxt = (TextView) findViewById(R.id.stripeFinalText);
        stripeFeesLargeTxt = (TextView) findViewById(R.id.stripeFeesLargeTxt);
        stripecalculate = (Button) findViewById(R.id.stripecalculateBtn);
        stripeclearbtn = (Button) findViewById(R.id.stripeclearbtn);
        stripeAmountET.setFocusable(true);
        TextView tv = (TextView) findViewById(R.id.stripedisclaimer);
        tv.setText(Html.fromHtml("<b>Not Affiliated with STRIPE.COM</b>  " +
                " <br /> <a style=\"color:white\" href=\"https://stripe.com/us/pricing\"> Click here to view STRIPE Fees.</a>"));
        tv.setMovementMethod(LinkMovementMethod.getInstance());

        stripecalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {

                    stripeAmount = Double.parseDouble(stripeAmountET.getText().toString());


                } catch (NumberFormatException e) {

                    stripeAmount = 0.00;

                }

                if (stripeAmount == 0.00) {
                    Toast.makeText(getApplicationContext(), "Please enter a value greater than Zero", Toast.LENGTH_LONG).show();
                    stripeAmountET.setText("");
                    stripeAmountET.setFocusable(true);
                    stripeFinalLargeTxt.setText("0.00");
                    stripeFeesLargeTxt.setText("0.00");

                } else {
                    stripeFinal = (stripeAmount + .3) / .971;
                    stripeFees = (stripeFinal * .029) + .3;
                    stripeFinalLargeTxt.setText(String.format("%.2f", stripeFinal));
                    stripeFeesLargeTxt.setText(String.format("%.2f", stripeFees));
                    stripeAmountET.setFocusable(true);

                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(stripeAmountET.getWindowToken(), 0);
                }
            }
        });

        stripeclearbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stripeAmountET.setText("");
                stripeFinalLargeTxt.setText("0.00");
                stripeFeesLargeTxt.setText("0.00");
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(stripeAmountET.getWindowToken(), 0);

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_stripe, menu);
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
}
