package com.adrianmoseley.servicefeescalculator;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    public ImageView paypalimg;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        Toast.makeText(MainActivity.this,"Created by Adrian D. Moseley for free use by all. 2017",  Toast.LENGTH_SHORT).show();
        //noinspection SimplifiableIfStatement
    /*    if (id == R.id.action_settings) {
            return true;
        }

        switch (item.getItemId())
        {
            case R.id.main_menu_about:
                Toast.makeText(MainActivity.this,"Created by Adrian D. Moseley for free use by all. 2017",  Toast.LENGTH_SHORT).show();
                return true;
            case R.id.pay_pal_about:
                Toast.makeText(MainActivity.this,"Created by Adrian D. Moseley for free use by all. 2017",  Toast.LENGTH_SHORT).show();
                return true;
            case R.id.square_about:
                Toast.makeText(MainActivity.this,"Created by Adrian D. Moseley for free use by all. 2017",  Toast.LENGTH_SHORT).show();
                return true;
            case R.id.stripe_about:
                Toast.makeText(MainActivity.this,"Created by Adrian D. Moseley for free use by all. 2017",  Toast.LENGTH_SHORT).show();
                return true;
        }
*/
        return super.onOptionsItemSelected(item);
    }

    public void startPayPal(View V) {
        Intent intent = new Intent(this, PayPalActivity.class);
        startActivity(intent);
    }


    public void startSquare(View V) {

        Intent intent = new Intent(this, SquareActivity.class);
        startActivity(intent);

    }

    public void startStripe(View V) {

        Intent intent = new Intent(this, StripeActivity.class);
        startActivity(intent);

    }


}
