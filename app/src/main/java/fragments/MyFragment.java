package fragments;

/**
 * Created by Isaiah on 3/12/14.
 */

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.wappi.tenzi.ListViewItem;
import com.wappi.tenzi.R;

import adapter.ListViewAdapter;


public class MyFragment extends Fragment {

    public static final String EXTRA_MESSAGE = "EXTRA_MESSAGE";
    public static String[] ALL_VALUES;
    private String[] values;
    private static Context context;
    private static int imagesize;
    public RelativeLayout detail_layout;
    private ListView listView;

    private static String[] mStanzas;
    private static String[] mStanzasDesc;
    private static String title;

    public  static MyFragment newInstance(String message, String[] Stanzas, String[] StanzasDesc, String MyTitle)
    {
        //imagesize = DetailInfo.moreImageValues.length;
        MyFragment f = new MyFragment();
        Bundle bdl = new Bundle(1);
        bdl.putString(EXTRA_MESSAGE, message);
        f.setArguments(bdl);
        mStanzas = Stanzas;
        title = message;
        mStanzasDesc = StanzasDesc;
        return f;
    }

    public void setValues(String[] values) {
        this.values = values;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        String message = getArguments().getString(EXTRA_MESSAGE);

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

        ViewGroup header = (ViewGroup) inflater.inflate(R.layout.song_header, listView,
                false);
        TextView titleText = (TextView)header.findViewById(R.id.song_title);
        titleText.setText(title);

        listView.addHeaderView(header, null, false);
        ListViewAdapter customAdapter = new ListViewAdapter(getActivity(), R.id.words, items);
        listView.setAdapter(customAdapter);

        return v;

    }

}

