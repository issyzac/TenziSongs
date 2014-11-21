package com.wappi.tenzi;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ListView;

import com.wappi.tenzi.R;

import adapter.gridViewAdapter;

/**
 *  Created by isaiah on 5/14/14.
 */
public class MainActivity extends Activity{

    public final int REPORT_RESULT = 1;

    ListView contentFrame;

    public static String[] songList;

    public int count;

    public static Typeface Athletic, Fun_Raiser, Roboto_Condensed, Roboto_Black, Roboto_Light, Roboto_BoldCondensedItalic, Roboto_BoldCondensed, Rosario_Regular, Rosario_Bold, Rosario_Italic, Roboto_Regular, Roboto_Medium;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainactivity);

        getActionBar().setDisplayShowTitleEnabled(false);

        /**
         * Type faces used for setting fonts thoughout the app
         */
        Roboto_Light = Typeface.createFromAsset(this.getAssets(), "Roboto-Light.ttf");
        Roboto_Black = Typeface.createFromAsset(this.getAssets(), "Roboto-Black.ttf");
        Roboto_Condensed = Typeface.createFromAsset(this.getAssets(), "Roboto-Condensed.ttf");
        Roboto_BoldCondensedItalic = Typeface.createFromAsset(getAssets(), "Roboto-BoldCondensedItalic.ttf");
        Roboto_BoldCondensed = Typeface.createFromAsset(getAssets(), "Roboto-BoldCondensed.ttf");
        Roboto_Regular = Typeface.createFromAsset(getAssets(), "Roboto-Regular.ttf");
        Roboto_Medium = Typeface.createFromAsset(getAssets(), "Roboto-Medium.ttf");
        Rosario_Regular = Typeface.createFromAsset(getAssets(), "Rosario-Regular.ttf");
        Rosario_Italic = Typeface.createFromAsset(getAssets(), "Rosario-Italic.ttf");
        Rosario_Bold = Typeface.createFromAsset(getAssets(), "Rosario-Bold.ttf");


        contentFrame = (ListView)findViewById(R.id.content_frame);

        songList = getResources().getStringArray(R.array.titoes);

        contentFrame.setAdapter(new gridViewAdapter(this, songList));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.launcher, menu);
        return super.onCreateOptionsMenu(menu);
    }

    /* Called whenever we call invalidateOptionsMenu() */
    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        // Handle your other action bar items...
        if(item.getItemId() == R.id.launcher){
            Intent intent = new Intent(MainActivity.this, SelectionGridActivity.class);
            Bundle translateBundle = ActivityOptions.makeCustomAnimation(this, R.anim.animslideright, R.anim.animslideleft).toBundle();
            MainActivity.this.startActivityForResult(intent, REPORT_RESULT, translateBundle);
            //Toast.makeText(MainActivity.this, "option menu selected", Toast.LENGTH_LONG).show();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REPORT_RESULT) {
            if (resultCode == RESULT_OK) {
                // code for result
                final Bundle bundle = data.getExtras();
                count = bundle.getInt("tag");
                Intent cardDetail = new Intent(MainActivity.this, SongDetails.class);
                cardDetail.putExtra("allValues", songList);
                cardDetail.putExtra("itemPosition", count);
                Bundle translateBundle = ActivityOptions.makeCustomAnimation(MainActivity.this, R.anim.activity_slide_in_left, R.anim.activity_slide_out_left).toBundle();
                MainActivity.this.startActivity(cardDetail, translateBundle);
            }
            if (resultCode == RESULT_CANCELED) {
                // Write your code on no result return
            }
        }
    }

}
