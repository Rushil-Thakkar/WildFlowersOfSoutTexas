package com.example.rushil.wildflowersofsouthtexas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Details extends AppCompatActivity {

    ImageView imageView;
    TextView tx_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details_layout);
        imageView = (ImageView)findViewById(R.id.Image1);
        tx_name=(TextView)findViewById(R.id.Image1_text);
        //imageView.setImageResource(getIntent().getIntExtra("img_id",00));
        //tx_name.setText("Description :" + getIntent().getStringExtra("name") );
    }
}
