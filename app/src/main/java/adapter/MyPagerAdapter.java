package adapter;

import android.content.Context;
import android.media.AudioManager;
import android.media.SoundPool;
import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.wappi.tenzi.ListViewItem;
import com.wappi.tenzi.R;
import com.wappi.tenzi.SongDetails;

import java.util.List;

/**
 *  Created by isaiah on 10/30/2014.
 */
public class MyPagerAdapter extends PagerAdapter {

    public String[] mobileValues;
    private Context context;
    public ListView listView;
    private List<String[]> myStanza;
    private List<String[]> myStanzaDesc;
    private  String[] mStanzas;
    private  String[] mStanzasDesc;

    /*
    For sound
     */
    private SoundPool soundPool;
    private int soundID;
    private boolean loaded = false;


    public MyPagerAdapter(Context mContext, String[] values, List<String[]> stanzas , List<String[]> stanzaTags){
        context = mContext;
        mobileValues = values;
        myStanza = stanzaTags;
        myStanzaDesc = stanzas;
    }

    @Override
    public int getCount() {
        return mobileValues.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        mStanzas = myStanza.get(position);
        mStanzasDesc = myStanzaDesc.get(position);

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View v = inflater.inflate(R.layout.song, container, false);

        /**
         * Sound playing codes
         */
        // Load the sound First
        soundPool = new SoundPool(30, AudioManager.STREAM_MUSIC, 0);
        soundPool.setOnLoadCompleteListener(new SoundPool.OnLoadCompleteListener() {
            @Override
            public void onLoadComplete(SoundPool soundPool, int sampleId, int status) {
                SongDetails.loaded = true;
            }
        });
        soundID = soundPool.load(context, R.raw.myhope, 1);


        listView = (ListView) v.findViewById(R.id.song_lyrics_list);

        final ListViewItem[] items = new ListViewItem[mStanzas.length];

        for (int i = 0; i < items.length; i++) {
            if (mStanzas[i] == "chorus") {
                items[i] = new ListViewItem(mStanzasDesc[i], ListViewAdapter.TYPE_CHORUS);
            } else {
                items[i] = new ListViewItem(mStanzasDesc[i], ListViewAdapter.TYPE_VERSE);
            }
        }

        ViewGroup header = (ViewGroup) inflater.inflate(R.layout.song_header, listView,
                false);
        TextView titleText = (TextView)header.findViewById(R.id.song_title);
        TextView namba = (TextView)header.findViewById(R.id.song_number);
        titleText.setText(mobileValues[position]);
        namba.setText((position+1)+". ");


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
                SongDetails.loaded = false;
                soundPool.release();
            }
        });


        playSound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                playSound.setVisibility(View.GONE);
                playedSound.setVisibility(View.VISIBLE);

                AudioManager audioManager = (AudioManager) context.getSystemService(context.AUDIO_SERVICE);

                float actualVolume = (float) audioManager
                        .getStreamVolume(AudioManager.STREAM_MUSIC);

                float maxVolume = (float) audioManager
                        .getStreamMaxVolume(AudioManager.STREAM_MUSIC);

                float volume = actualVolume / maxVolume;
                // Is the sound loaded already?

                if (SongDetails.loaded) {
                    soundPool.play(soundID, volume, volume, 1, 0, 1f);
                    Log.e("Test", "Played sound");
                    soundPool.release();
                }

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
