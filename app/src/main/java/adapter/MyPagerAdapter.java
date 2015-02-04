package adapter;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.provider.Settings;
import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.wappi.tenzi.ListViewItem;
import com.wappi.tenzi.ListviewObjects;
import com.wappi.tenzi.MainActivity;
import com.wappi.tenzi.R;
import com.wappi.tenzi.SongDetails;

import java.util.List;

/**
 *  Created by isaiah on 10/30/2014.
 */
public class MyPagerAdapter extends PagerAdapter {

    private Context context;
    public ListView listView;
    private  String[] mStanzas;
    private  String[] mStanzasDesc;

    public  MediaPlayer mediaPlayer;

    public ListviewObjects[] songList;


    public MyPagerAdapter(Context mContext,  ListviewObjects[] song){
        context = mContext;
        songList = song;
    }

    @Override
    public int getCount() {
        return songList.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        mStanzas = songList[position].getStanzatag();
        mStanzasDesc = songList[position].getStanza();

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View v = inflater.inflate(R.layout.song, container, false);

        listView = (ListView) v.findViewById(R.id.song_lyrics_list);

        final ListViewItem[] items = new ListViewItem[mStanzas.length];

        for (int i = 0; i < items.length; i++) {
            if (mStanzas[i] == "chorus") {
                items[i] = new ListViewItem(mStanzasDesc[i], ListViewAdapter.TYPE_CHORUS);
            } else {
                items[i] = new ListViewItem(mStanzasDesc[i], ListViewAdapter.TYPE_VERSE);
            }
        }

        ViewGroup header = (ViewGroup) inflater.inflate(R.layout.song_header, listView, false);

        TextView titleText = (TextView)header.findViewById(R.id.song_title);
        TextView namba = (TextView)header.findViewById(R.id.song_number);
        TextView englishTitle = (TextView)header.findViewById(R.id.english_title);
        englishTitle.setTypeface(MainActivity.Rosario_Regular);
        TextView references = (TextView)header.findViewById(R.id.references);
        references.setTypeface(MainActivity.Rosario_Regular);

        titleText.setText(songList[position].getTitle());
        namba.setText(1+songList[position].getObjectPosition()+" ");
        englishTitle.setText(songList[position].getEnglishTitle());
        references.setText(songList[position].getOtherReferences());

        /**
         * adding the actions to playing the audio
         */
        final ImageView playSound = (ImageView)header.findViewById(R.id.play);
        final ImageView playedSound = (ImageView)header.findViewById(R.id.played);

        playedSound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playedSound.setVisibility(View.GONE);
                playSound.setVisibility(View.VISIBLE);
                SongDetails.stopSound();
            }
        });


        playSound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SongDetails.loadSong(context);
                playSound.setVisibility(View.GONE);
                playedSound.setVisibility(View.VISIBLE);

            }
        });

        listView.addHeaderView(header, null, false);
        ListViewAdapter customAdapter = new ListViewAdapter(context, R.id.words, items);
        listView.setAdapter(customAdapter);

        container.addView(v);

        return v;

    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View)object);
    }


}
