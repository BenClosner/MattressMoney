package mattressmoney.myapplication;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SimpleAdapter;

import java.util.HashMap;
import java.util.List;

/**
 * Created by ben on 6/26/2015.
 * this class is only used to add background color alternating to the base simple adapter class
 */
public class StockListAdapter extends SimpleAdapter {

    private int[] colors = new int[] {0xffffffff, 0xffdcdcdc};

    public StockListAdapter(Context context, List<HashMap<String, String>> items, int resource,
                            String[] from, int[] to) {
        super(context, items, resource, from, to);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = super.getView(position, convertView, parent);
        int colorPos = position % colors.length;
        view.setBackgroundColor(colors[colorPos]);
        return view;
    }
}
