package com.wappi.tenzi;

import android.app.Activity;
import android.app.ActionBar;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import Transformers.DepthPageTransformer;
import adapter.MyPagerAdapter;
import adapter.viewPagerAdapter;

/**
 *  Created by isaiah on 10/28/2014.
 */
public class SongDetails extends Activity {

    public int position;

    private String[] mTitles;

    public ListviewObjects [] values;

    public String value_changer;

    public static ActionBar actionBar;

    viewPagerAdapter pager_adapter;

    MyPagerAdapter myPagerAdapter;

    public String[] titles;

    public static boolean isSoundPlayed = false;


    /*
    For sound
    */
    public static MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.song_details);
        final Bundle bundle=getIntent().getExtras();

        actionBar = getActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(getResources().getColor(android.R.color.transparent)));
        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setIcon(new ColorDrawable(getResources().getColor(android.R.color.transparent)));

        values = MainActivity.items;

        titles = new String[values.length];

        position=bundle.getInt("itemPosition");

        mTitles = getResources().getStringArray(R.array.titoes);

        for(int i =0; i<titles.length; i++){
            titles[i] = values[i].getTitle();
        }

        final ViewPager pager = (ViewPager)findViewById(R.id.pager);
        pager.setPageTransformer(true, new DepthPageTransformer());
        myPagerAdapter = new MyPagerAdapter(this, values);
        pager.setAdapter(myPagerAdapter);
        pager.setCurrentItem(position);
        final int pageMargin = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 4, getResources()
                .getDisplayMetrics());
        pager.setPageMargin(pageMargin);

        pager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i2) {
                if (isSoundPlayed){
                    mediaPlayer.release();
                }
            }

            @Override
            public void onPageSelected(int i) {
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
    }

    public static void loadSong(Context context){

        /**
         * Sound playing codes
         */
        //mediaPlayer = new MediaPlayer();
        mediaPlayer = MediaPlayer.create(context, R.raw.myhope);
        mediaPlayer.setVolume(1f, 0.5f);
        isSoundPlayed = true;
        mediaPlayer.start();

    }

    public static  void stopSound(){
        mediaPlayer.stop();
        mediaPlayer.release();
    }


    @Override
    public void onBackPressed() {
        finish();
    }

    @Override
    public void finish(){
        super.finish();
        if (isSoundPlayed) {
            mediaPlayer.release();
        }
    }

}
