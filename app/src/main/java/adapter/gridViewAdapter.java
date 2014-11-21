package adapter;

import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.wappi.tenzi.R;
import com.wappi.tenzi.SongDetails;

import customViews.TouchFeedbackEnabledRelativeLayout;

/**
 *  Created by Issy on 1/19/14.
 */
public class gridViewAdapter extends BaseAdapter {
    private Context context;
    private final String[] mobileValues;
    private int count = 1;
    private int[] item_number;

    public gridViewAdapter(Context context, String[] list) {
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
            gridView = inflater.inflate(R.layout.list_item, null);

        } else {
            gridView = (View) convertView;
        }

        item_number[position] = count;

        String mobile = mobileValues[position];
        TextView title = (TextView)gridView.findViewById(R.id.item_title);
        title.setText(mobile);

        TextView number = (TextView)gridView.findViewById(R.id.song_number);
        number.setText(count+"");

        TouchFeedbackEnabledRelativeLayout sound = (TouchFeedbackEnabledRelativeLayout)gridView.
                findViewById(R.id.sound);
        sound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        gridView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent cardDetail = new Intent(context, SongDetails.class);
                cardDetail.putExtra("allValues", mobileValues);
                cardDetail.putExtra("itemPosition", position);
                Bundle translateBundle = ActivityOptions.makeCustomAnimation(context, R.anim.activity_slide_in_left, R.anim.activity_slide_out_left).toBundle();
                context.startActivity(cardDetail, translateBundle);
            }
        });

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
