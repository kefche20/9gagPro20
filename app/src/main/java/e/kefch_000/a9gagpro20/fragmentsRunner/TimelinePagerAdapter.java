package e.kefch_000.a9gagpro20.fragmentsRunner;


import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import e.kefch_000.a9gagpro20.fragments.Frag2;
import e.kefch_000.a9gagpro20.fragments.Frag3;

public class TimelinePagerAdapter extends FragmentPagerAdapter {

    private Context context;

    public TimelinePagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        this.context = context;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new Frag2();
            case 1:
                return new Frag3();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        // Generate title based on item position
      /*  switch (position) {
            case 0:
                return context.getString(R.string.stories);
            case 1:
                return context.getString(R.string.campaigns);
            default:*/
                return null;
      //  }
    }

}

