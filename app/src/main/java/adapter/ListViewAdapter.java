package adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.wappi.tenzi.ListViewItem;
import com.wappi.tenzi.MainActivity;
import com.wappi.tenzi.R;
import com.wappi.tenzi.ViewHolder;

/**
 * Created by Isaiah on 10/28/2014.
 */
public class ListViewAdapter extends ArrayAdapter<ListViewItem> {

    public static final int TYPE_VERSE = 0;

    public static final int TYPE_CHORUS = 1;

    private int no = 15;

    private ListViewItem[] objects;

    @Override
    public int getViewTypeCount() {
        return 2;
    }

    @Override
    public int getItemViewType(int position) {
        return objects[position].getType();
    }

    public ListViewAdapter(Context context, int resource, ListViewItem[] objects) {
        super(context, resource, objects);
        this.objects = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder = null;
        ListViewItem listViewItem = objects[position];
        int listViewItemType = getItemViewType(position);

        no = position+1;

        if (convertView == null) {

            if (listViewItemType == TYPE_CHORUS) {
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.chorus, null);
            } else {
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.verse, null);
            }

            TextView textView = (TextView) convertView.findViewById(R.id.words);
             viewHolder = new ViewHolder(textView);

            if(listViewItemType == TYPE_CHORUS){
                //textView.setTypeface(MainActivity.Rosario_Italic);
            }

            if(listViewItemType == TYPE_VERSE){
                TextView v_number = (TextView)convertView.findViewById(R.id.verse_number);
                v_number.setText(no+"");
                //textView.setTypeface(MainActivity.Rosario_Regular);
            }

            convertView.setTag(viewHolder);

        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.getText().setText(listViewItem.getText());

        return convertView;
    }

}