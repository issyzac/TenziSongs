package com.wappi.tenzi;

import android.app.ActionBar;
import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;

import java.util.ArrayList;

import adapter.gridItemAdapter;
import customViews.HeaderGridView;

/**
 *  Created by Isaiah on 11/2/2014.
 */

public class SelectionGridActivity extends Activity {

    public HeaderGridView gridView;

    public int selectedSong;

    public ArrayList<ListviewObjects> songList;

    /**
     * Variables for the searching functionality
     */

    public ArrayList<ListviewObjects> mSongs;
    public static ArrayList<ListviewObjects> mSongsFiltered;
    private boolean mSearchOpened;
    private String mSearchQuery;
    public EditText mSearchEt;
    public String queryText = "";
    public  gridItemAdapter adapter;

    /**
     * End of Search field variables
     */

    /**
     * When Activity starts first method to be called
     * @param savedInstanceState
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.selection_grid);

        if(savedInstanceState == null){
            mSongs = getInitialListOfSongs();
            mSongsFiltered = mSongs;
        }

        gridView = (HeaderGridView)findViewById(R.id.grid_items);
        adapter = new gridItemAdapter(SelectionGridActivity.this, mSongsFiltered);
        gridView.setAdapter(adapter);

        ActionBar actionBar = getActionBar();
        actionBar.setDisplayShowCustomEnabled(true);
        actionBar.setCustomView(R.layout.search_bar);

        mSearchEt = (EditText) actionBar.getCustomView().findViewById(R.id.etSearch);
        mSearchEt.setSelected(true);
        mSearchEt.addTextChangedListener(new SearchWatcher());
        mSearchEt.setText(queryText);
        mSearchEt.requestFocus();

        actionBar.setIcon(
                new ColorDrawable(getResources().getColor(android.R.color.transparent)));
        songList = mSongsFiltered;

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                int val = i;
                selectedSong = mSongsFiltered.get(val).getObjectPosition();
                finish();
            }
        });
    }

    public ArrayList<ListviewObjects> getInitialListOfSongs(){
        ArrayList<ListviewObjects> initialSongs = new ArrayList<ListviewObjects>();
        ListviewObjects[] songsInArray = MainActivity.items;
        for(int i=0; i<songsInArray.length; i++){
            initialSongs.add(songsInArray[i]);
        }
        return initialSongs;
    }

    @Override
    public void onBackPressed() {
        selectedSong = -1;
        finish();
    }

    @Override
    public void finish(){

        if(selectedSong == -1){
            Intent addIntent = new Intent(SelectionGridActivity.this, BiggerAdsActivity.class);
            Bundle translateBundle = ActivityOptions.makeCustomAnimation(SelectionGridActivity.this, R.anim.activity_slide_in_left, R.anim.activity_slide_out_left).toBundle();
            SelectionGridActivity.this.startActivity(addIntent, translateBundle);
        }

        Intent returnIntent=new Intent();
        returnIntent.putExtra("tag", selectedSong);
        setResult(RESULT_OK, returnIntent);
        super.finish();

    }

    /**
     * Responsible for handling changes in search edit text.
     */
    private class SearchWatcher implements TextWatcher {

        @Override
        public void beforeTextChanged(CharSequence c, int i, int i2, int i3) {

        }

        @Override
        public void onTextChanged(CharSequence c, int i, int i2, int i3) {
            mSearchQuery = mSearchEt.getText().toString();
            mSongsFiltered = performSearch(mSongs, mSearchQuery);
            adapter = new gridItemAdapter(SelectionGridActivity.this, mSongsFiltered);
            gridView.invalidateViews();
            gridView.setAdapter(adapter);
        }

        @Override
        public void afterTextChanged(Editable editable) {

        }

    }

    private gridItemAdapter getsongAdapter(){
        return (gridItemAdapter)gridView.getAdapter();
    }

    /**
     * Goes through the given list and filters it according to the given query.
     *
     * @param songs list given as search sample
     * @param query to be searched
     * @return new filtered list
     */
    private ArrayList<ListviewObjects> performSearch(ArrayList<ListviewObjects> songs, String query) {

        // First we split the query so that we're able
        // to search word by word (in lower case).
        String[] queryByWords = query.toLowerCase().split("\\s+");

        // Empty list to fill with matches.
        ArrayList<ListviewObjects> songsFiltered = new ArrayList<ListviewObjects>();

        // Go through initial releases and perform search.
        for (ListviewObjects movie : mSongs) {

            // Content to search through (in lower case).
            String content = (
                    movie.getTitle() + " " +
                            movie.getEnglishTitle() + " " +
                            String.valueOf(movie.getObjectPosition())
            ).toLowerCase();

            for (String word : queryByWords) {

                // There is a match only if all of the words are contained.
                int numberOfMatches = queryByWords.length;

                // All query words have to be contained,
                // otherwise the release is filtered out.
                if (content.contains(word)) {
                    numberOfMatches--;
                } else {
                    break;
                }

                // They all match.
                if (numberOfMatches == 0) {
                    songsFiltered.add(movie);
                }

            }

        }

        mSongsFiltered = songsFiltered;

        return mSongsFiltered;
    }

}
