package mattressmoney.myapplication;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by ben on 6/18/2015.
 * this is is used in the main menu activity, it makes the swipe view work good
 */
public class MyAdapter extends FragmentStatePagerAdapter {

    public MyAdapter(FragmentManager fm){
        super(fm);
    }

    @Override
    public Fragment getItem(int index) {
        switch (index) {
            case 0:
                return new ProfileFragment();
            case 1:
                return new HotFragment();
            case 2:
                return new PopularFragment();
        }//end switch

        return null;
    }

    @Override
    public int getCount() {
        return 3;
    }
}
