package mattressmoney.myapplication;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by ben on 6/18/2015.
 * same
 */
public class ProfileFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.profilefragment, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onActivityCreated(savedInstanceState);

        TextView tv = (TextView)getActivity().findViewById(R.id.profilefragment);
        //You can add different items in here according to your needs.
        //You will have your own code to do stuff. Like to use a listview or a gridview etc.
        //You will make a separate adapter in a separate class and use that adapter in this onActivityCreated() method.
    }


}