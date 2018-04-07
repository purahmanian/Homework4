package com.example.purah.homework4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import com.example.purah.homework4.R;

public class MainActivity extends AppCompatActivity {
    private View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void sendLocation(View view){
        Intent intent = new Intent(this, MapsActivity.class);
        EditText startLoc =(EditText) findViewById(R.id.start_loc);
        EditText endLoc =(EditText) findViewById(R.id.end_loc);
        String startString = startLoc.getText().toString();
        intent.putExtra("START_LOC", startString);
        startActivity(intent);
    }

}
