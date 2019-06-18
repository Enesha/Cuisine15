package com.example.enesha.cuisine;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ActivityCook extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cook);
        Button Res;
        Button Upload;

        Res = (Button) findViewById(R.id.Res);
        Upload = (Button) findViewById(R.id.Upload);

        Res.setOnClickListener(this);
        Upload.setOnClickListener(this);

        }



    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.Res:
                Intent intentabout = new Intent(this, RecipesActivity.class);
                startActivity(intentabout);
                break;
            case R.id.Upload:
                Intent intentlogin = new Intent(this, Upload.class);
                startActivity(intentlogin);
                break;

            default:
                break;
        }
    }
}
