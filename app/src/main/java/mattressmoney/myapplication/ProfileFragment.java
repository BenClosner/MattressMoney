package mattressmoney.myapplication;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by ben on 6/18/2015.
 * fragment for main menu
 * shows users profile stocks
 * more comments on hot fragment
 */
public class ProfileFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        View V = inflater.inflate(R.layout.fragment_tab, container, false);
        LinearLayout ll = (LinearLayout) V.findViewById(R.id.ll);

        for(int i = 1; i <= 15; ++i){
            View currentItem = getLayoutInflater(savedInstanceState).inflate(R.layout.list_item, null);

            View background = currentItem.findViewById(R.id.list_item_LL);
            if (i % 2 == 1) {
                background.setBackgroundColor(getResources().getColor(R.color.white));
            }
            else {
                background.setBackgroundColor(getResources().getColor(R.color.grey));
            }

            ll.addView(currentItem);
        }

        return V;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }


}