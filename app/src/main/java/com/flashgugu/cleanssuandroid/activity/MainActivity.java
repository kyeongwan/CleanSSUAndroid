package com.flashgugu.cleanssuandroid.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;
import com.flashgugu.cleanssuandroid.R;
import com.flashgugu.cleanssuandroid.util.InsertDataRequest;


public class MainActivity extends AppCompatActivity {
    String mBuyer;
    String mShop;
    String mCost;
    String mCardCompany;
    String mDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {

        final EditText buyerEditText = (EditText)findViewById(R.id.buyer);
        final EditText shopEditText = (EditText)findViewById(R.id.shop);
        final EditText costEditText = (EditText)findViewById(R.id.cost);
        final EditText cardcompanyEditText = (EditText)findViewById(R.id.cardcompany);
        final EditText dateEditText = (EditText)findViewById(R.id.date);
        final Button requestButton = (Button)findViewById(R.id.button1);

        requestButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mBuyer = buyerEditText.getText().toString();
                mShop = shopEditText.getText().toString();
                mCost = costEditText.getText().toString();
                mCardCompany = cardcompanyEditText.getText().toString();
                mDate = dateEditText.getText().toString();

                RequestQueue queue = Volley.newRequestQueue(getApplicationContext());

                Request stringRequest = new InsertDataRequest(mBuyer, mShop, mCost, mCardCompany, mDate, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(getApplicationContext(), response, Toast.LENGTH_SHORT).show();
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                    }
                });

                queue.add(stringRequest);
            }
        });

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

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
