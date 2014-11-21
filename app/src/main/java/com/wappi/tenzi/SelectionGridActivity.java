package com.wappi.tenzi;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.GridView;

import adapter.gridItemAdapter;

/**
 * Created by Isaiah on 11/2/2014.
 */
public class SelectionGridActivity extends Activity {

    GridView gridView;

    public int selectedSong;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setBackgroundDrawable(new ColorDrawable(getResources().getColor(android.R.color.transparent)));
        setContentView(R.layout.selection_grid);

        gridView = (GridView)findViewById(R.id.grid_items);
        gridView.setAdapter(new gridItemAdapter(this, MainActivity.songList));

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                selectedSong = i;
                finish();
            }
        });


    }

    @Override
    public void finish(){
        Intent returnIntent=new Intent();
        returnIntent.putExtra("tag", selectedSong);
        setResult(RESULT_OK,returnIntent);
        super.finish();
    }

}
