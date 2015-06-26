package mattressmoney.myapplication;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by ben on 6/18/2015.
 * fragment for main menu
 * shows users profile stocks
 */

public class ProfileFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){

        //normally this would just 'return rootView'
        View rootView = inflater.inflate(R.layout.fragment_tab, container, false);

        //makes 15 list items. put all the attributes in maps.
        List<HashMap<String, String>> maps = new ArrayList<HashMap<String, String>>();
        for(int i = 1; i <= 15; ++i) {
            String current = JSONparser.phjson;
            HashMap<String, String> current_map = JSONparser.convert(current);
            maps.add(current_map);
        }

        //make the other parts to the adapter
        int[] to = {R.id.list_item_ticker, R.id.list_item_fullname, R.id.list_item_current,
                R.id.list_item_changeflat, R.id.list_item_changepercent};
        String[] from = {"Ticker", "Title", "Price", "Change", "Change Percent"};

        //make the adapter itself
        StockListAdapter stockListAdapter = new StockListAdapter(getActivity(), maps, R.layout.list_item, from, to);

        //apply the adapter to the listview
        ListView lv = (ListView) rootView.findViewById(R.id.lv);
        lv.setAdapter(stockListAdapter);

        return rootView;
    }
}