package adapter;

import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.wappi.tenzi.ListViewItem;
import com.wappi.tenzi.ListviewObjects;
import com.wappi.tenzi.MainActivity;
import com.wappi.tenzi.R;
import com.wappi.tenzi.SongDetails;

import org.w3c.dom.Text;

import customViews.TouchFeedbackEnabledRelativeLayout;

/**
 *  Created by Issy on 1/19/14.
 */
public class gridViewAdapter extends ArrayAdapter<ListviewObjects> {

    public static final int TYPE_LIST = 0;

    public static final int TYPE_AD = 1;

    private ListviewObjects[] mobileValues;

    private Context context;

    private int count = 1;

    private int[] item_number;


    @Override
    public int getViewTypeCount() {
        return 2;
    }

    @Override
    public int getItemViewType(int position) {
        return mobileValues[position].getType();
    }

    public gridViewAdapter(Context context, int resource, ListviewObjects[] objects) {
        super(context, resource, objects);
        this.mobileValues = objects;
        this.context = context;
        item_number = new int[objects.length];
    }

    public View getView(final int position, View convertView, ViewGroup parent) {

        count = position+1;

        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View listView;
        ListviewObjects listviewObjects = mobileValues[position];
        int listviewObjectType = getItemViewType(position);

        if (convertView == null) {
            // get layout from mobile.xml
            if (listviewObjectType == TYPE_LIST) {
                listView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, null);
            } else {
                listView = LayoutInflater.from(getContext()).inflate(R.layout.ad, null);
            }

        } else {
            listView = (View) convertView;
        }

        item_number[position] = count;

        if(listviewObjectType == TYPE_LIST){

            String mobile = mobileValues[position].getTitle();

            TextView title = (TextView)listView.findViewById(R.id.item_title);
            title.setText(mobile);

            TextView number = (TextView)listView.findViewById(R.id.song_number);
            number.setText(count+"");

            TextView hint = (TextView)listView.findViewById(R.id.the_hint);
            hint.setTypeface(MainActivity.Rosario_Regular);

            hint.setText(mobileValues[position].doesItHaveAChorus());

            TouchFeedbackEnabledRelativeLayout sound = (TouchFeedbackEnabledRelativeLayout)listView.
                    findViewById(R.id.sound);
            sound.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });

            listView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent cardDetail = new Intent(context, SongDetails.class);
                    cardDetail.putExtra("itemPosition", mobileValues[position].getObjectPosition());
                    //Bundle translateBundle = ActivityOptions.makeCustomAnimation(context, R.anim.activity_slide_in_left, R.anim.activity_slide_out_left).toBundle();
                    context.startActivity(cardDetail);
                }
            });
        }
        else
        {

        }

        return listView;
    }


}
