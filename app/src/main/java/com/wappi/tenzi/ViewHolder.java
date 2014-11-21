package com.wappi.tenzi;

import android.widget.TextView;

/**
 * Created by Isaiah on 10/29/2014.
 */
public class ViewHolder {
    TextView text;

    public ViewHolder(TextView text) {
        this.text = text;
    }

    public TextView getText() {
        return text;
    }

    public void setText(TextView text) {
        this.text = text;
    }

}