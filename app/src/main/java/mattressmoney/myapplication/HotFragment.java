package mattressmoney.myapplication;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

/**
 * Created by ben on 6/18/2015.
 * fragment for main menu
 * shows the recent 'hot' stocks
 */
public class HotFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        View V = inflater.inflate(R.layout.fragment_tab, container, false);
        //normally this would just 'return V'

        //this finds the linearlayout in fragment_tab.xml to add items to them
        LinearLayout ll = (LinearLayout) V.findViewById(R.id.ll);

        //makes 15 list items. put all the attributes in fillmaps.
        for(int i = 1; i <= 15; ++i){

            //this shows how to make a new instance of the list_item xml
            View currentItem = getLayoutInflater(savedInstanceState).inflate(R.layout.list_item, null);

            //this shows how to modify attributes of the current instance of the xml
            View background = currentItem.findViewById(R.id.list_item_LL);

            //alternate background color.
            if (i % 2 == 0) {
                background.setBackgroundColor(getResources().getColor(R.color.white));
            }
            else {
                background.setBackgroundColor(getResources().getColor(R.color.grey));
            }

            //this puts the current list_item view in the linearlayout of the current fragment
            ll.addView(currentItem);
        }

        return V;
    }
}
