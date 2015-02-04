package adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.wappi.tenzi.ListviewObjects;
import com.wappi.tenzi.MainActivity;
import com.wappi.tenzi.R;
import com.wappi.tenzi.SelectionGridActivity;

import java.util.ArrayList;

import customViews.TouchFeedbackEnabledRelativeLayout;

/**
 *  Created by Isaiah on 11/2/2014.
 */
public class gridItemAdapter  extends BaseAdapter {
    private Context context;
    private final ArrayList<ListviewObjects> mobileValues;

    public gridItemAdapter(Context context, ArrayList<ListviewObjects> list) {
        this.context = context;
        this.mobileValues = list;
    }

    public View getView( int position, View convertView, ViewGroup parent) {

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
        numbr.setText(mobileValues.get(position).getObjectPosition()+1+"");

        TextView title = (TextView)gridView.findViewById(R.id.song_hint);
        title.setText(mobileValues.get(position).getTitle());

        return gridView;
    }

    @Override
    public int getCount() {
        int arrayLength = 0;
        arrayLength = mobileValues.size();
        return arrayLength;
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
