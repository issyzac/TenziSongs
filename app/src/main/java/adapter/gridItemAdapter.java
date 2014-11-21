package adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.wappi.tenzi.MainActivity;
import com.wappi.tenzi.R;

import customViews.TouchFeedbackEnabledRelativeLayout;

/**
 *  Created by Isaiah on 11/2/2014.
 */
public class gridItemAdapter  extends BaseAdapter {
    private Context context;
    private final String[] mobileValues;
    private int count = 1;
    private int[] item_number;

    public gridItemAdapter(Context context, String[] list) {
        this.context = context;
        this.mobileValues = list;
        item_number = new int[list.length];
    }

    public View getView(final int position, View convertView, ViewGroup parent) {

        count = position+1;

        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View gridView;

        if (convertView == null) {
            // get layout from mobile.xml
            gridView = inflater.inflate(R.layout.grid_item, null);

        } else {
            gridView = (View) convertView;
        }

        TextView numbr = (TextView)gridView.findViewById(R.id.grid_number);
        //numbr.setTypeface(MainActivity.Rosario_Regular);
        numbr.setText(position+1+"");

        TextView title = (TextView)gridView.findViewById(R.id.song_hint);
        title.setText(mobileValues[position]);

        return gridView;
    }

    @Override
    public int getCount() {
        return mobileValues.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

}
