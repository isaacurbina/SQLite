package com.mobileappsco.training.sqllibraries;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class ScrollingActivity extends AppCompatActivity {

    FloatingActionButton fab;
    ImageView imgV1;
    ImageView imgV2;
    ImageView imgV3;
    ImageView imgV4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "My fab button", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        imgV1 = (ImageView) findViewById(R.id.imgV1);
        imgV2 = (ImageView) findViewById(R.id.imgV2);
        imgV3 = (ImageView) findViewById(R.id.imgV3);
        imgV4 = (ImageView) findViewById(R.id.imgV4);
    }

    @Override
    protected void onResume() {
        super.onResume();

        Glide.with(this)
                .load("http://d3c6l3uum4x5po.cloudfront.net/wp-content/uploads/2015/02/Singapore-city-branch-image1.jpg")
                .into(imgV1);
        Glide.with(this)
                .load("https://www.globalchamber.org/clientuploads/events/hong-kong.jpg")
                .into(imgV2);
        Glide.with(this)
                .load("http://media-cdn.tripadvisor.com/media/photo-s/03/9b/2d/ad/bangkok.jpg")
                .into(imgV3);
        Glide.with(this)
                .load("http://www.all-free-photos.com/images/vietnam/PI46169-hr.jpg")
                .into(imgV4);
    }
}
