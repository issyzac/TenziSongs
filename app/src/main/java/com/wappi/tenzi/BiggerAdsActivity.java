package com.wappi.tenzi;

import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.ActionProvider;
import android.view.Window;

/**
 * Created by apple on 11/29/14.
 */
public class BiggerAdsActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bigger_ads);

        getActionBar().setDisplayShowTitleEnabled(false);
    }

}
