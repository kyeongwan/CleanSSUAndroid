package com.flashgugu.cleanssuandroid.util;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.Response;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by flashgugu on 15. 6. 25.
 */
public class InsertDataRequest extends Request<String> {

    private Map<String, String> mParams;

    public InsertDataRequest(String buyer, String shop, String cost , String cardcompany , String date, Response.Listener<String> successListener, Response.ErrorListener errorListener) {
        super(Method.POST, "http://cleanssu.adnaru.com/awesomeApi/insertdata", errorListener);

        mParams = new HashMap<>();
        mParams.put("admin_group", buyer);
        mParams.put("payment_store", shop);
        mParams.put("cost", cost);
        mParams.put("card_company", cardcompany);
        mParams.put("date_time", date);

    }

    @Override
    protected Map<String, String> getParams() throws AuthFailureError {
        return mParams;
    }

    @Override
    protected Response<String> parseNetworkResponse(NetworkResponse response) {
        return null;
    }

    @Override
    protected void deliverResponse(String response) {

    }
}
