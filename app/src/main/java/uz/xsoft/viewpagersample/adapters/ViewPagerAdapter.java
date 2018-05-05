package uz.xsoft.viewpagersample.adapters;


import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import uz.xsoft.viewpagersample.fragments.Fragment1;

public class ViewPagerAdapter extends FragmentPagerAdapter {

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            Fragment1 fragment1 = new Fragment1();
            fragment1.i = 1;
            return fragment1;
        }
        if (position == 1) {
            Fragment1 fragment1 = new Fragment1();
            fragment1.i = 2;
            return fragment1;
        } else {
            Fragment1 fragment1 = new Fragment1();
            fragment1.i = 3;
            return fragment1;
        }
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return "Лента";
        }
        if (position == 1) {
            return "Офлайн";
        } else {
            return "Все фото";
        }
    }
}
//            return "Офлайн";
//            return "Офлайн";
