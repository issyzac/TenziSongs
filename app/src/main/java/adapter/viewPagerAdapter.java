package adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

/**
 * Created by Isaiah on 7/26/2014.
 */
public class viewPagerAdapter extends FragmentStatePagerAdapter {

    private List<Fragment> fragments;

    public viewPagerAdapter(FragmentManager fm, List<Fragment> fragments){
        super(fm);
        this.fragments=fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return this.fragments.get(position);
    }


    @Override
    public int getCount() {

        return this.fragments.size();
    }

}
