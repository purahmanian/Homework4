package com.example.purah.homework4;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.errors.ApiException;
import com.google.maps.model.GeocodingResult;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;


public class DisplayMap extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //Log.d("MyApp","I am here \n \n");
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        final String message = intent.getStringExtra("START_LOC");

        final double[] lat = new double[1];
        final double[] lng = new double[1];

        final TextView textView = new TextView(this);
        // ...

        // Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(this);
        String url ="https://maps.googleapis.com/maps/api/geocode/json?address=" + message + "&key=AIzaSyBujFeCViRflzgzZbPJPsC5iE5o-PEL1Oo";

        // Request a string response from the provided URL.
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {


                        try {
                            lat[0] = response.getJSONArray("results").getJSONObject(0).getJSONObject("geometry").getJSONObject("location").getDouble("lat");
                            lng[0] = response.getJSONArray("results").getJSONObject(0).getJSONObject("geometry").getJSONObject("location").getDouble("lng");
                            textView.setText("Response: " + lat[0] + " " + lng[0]);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // TODO: Handle error

                    }
        });

        // Add the request to the RequestQueue.
        queue.add(jsonObjectRequest);
        setContentView(textView);



    }
}
