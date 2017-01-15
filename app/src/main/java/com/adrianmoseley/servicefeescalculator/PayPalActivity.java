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


public class PayPalActivity extends AppCompatActivity {
    public double payPalAmount;
    public double payPalFinal;
    public double payPalFees;
    public EditText payPalAmountET;
    public TextView payPalFinalLargeTxt;
    public TextView payPalFeesLargeTxt;
    public Button calculate;
    public Button clearbtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay_pal);
        payPalAmountET = (EditText) findViewById(R.id.payPalAmountEditText);
        payPalFinalLargeTxt = (TextView) findViewById(R.id.payPalFinalLargeTxt);
        payPalFeesLargeTxt = (TextView) findViewById(R.id.payPalFeesLargeTxt);
        calculate = (Button) findViewById(R.id.calculateBtn);
        clearbtn = (Button) findViewById(R.id.clearbtn);
        payPalAmountET.setFocusable(true);
        TextView tv = (TextView) findViewById(R.id.paypaldisclaimer);
        tv.setText(Html.fromHtml("<b>Not Affiliated with Pay Pal </b>  " +
                " <br /> <a href=\"https://www.paypal.com/us/webapps/mpp/paypal-fees\"> Click here to view Pay Pal Fees.</a>"));
        tv.setMovementMethod(LinkMovementMethod.getInstance());

        payPalFeesLargeTxt.setTextIsSelectable(true);
        payPalFinalLargeTxt.setTextIsSelectable(true);

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {

                    payPalAmount = Double.parseDouble(payPalAmountET.getText().toString());


                } catch (NumberFormatException e) {

                    payPalAmount = 0.00;

                }

                if (payPalAmount == 0.00) {
                    Toast.makeText(getApplicationContext(), "Please enter a value greater than Zero", Toast.LENGTH_LONG).show();
                    payPalAmountET.setText("");
                    payPalAmountET.setFocusable(true);
                    payPalFinalLargeTxt.setText("0.00");
                    payPalFeesLargeTxt.setText("0.00");

                } else {
                    payPalFinal = (payPalAmount + .3) / .971;
                    payPalFees = (payPalFinal * .029) + .3;
                    payPalFinalLargeTxt.setText(String.format("%.2f", payPalFinal));
                    payPalFeesLargeTxt.setText(String.format("%.2f", payPalFees));
                    payPalAmountET.setFocusable(true);

                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(payPalAmountET.getWindowToken(), 0);
                }
            }
        });

        clearbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                payPalAmountET.setText("");
                payPalFinalLargeTxt.setText("0.00");
                payPalFeesLargeTxt.setText("0.00");
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(payPalAmountET.getWindowToken(), 0);

            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_pay_pal, menu);
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
