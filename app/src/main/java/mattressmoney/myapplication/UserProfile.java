package mattressmoney.myapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;


public class UserProfile extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", MODE_PRIVATE);
        TextView username = (TextView)this.findViewById(R.id.profile_username);
        username.setText(pref.getString("User_name", ""));

        LinearLayout stocks_list = (LinearLayout) findViewById(R.id.profile_stocksowned);

        for (int i = 1; i <= 25; i++){
            View current_item = getLayoutInflater().inflate(R.layout.list_item, null);

            View bg = current_item.findViewById(R.id.list_item_LL);
            if (i % 2 == 0){
                bg.setBackgroundColor(getResources().getColor(R.color.grey));
            } else {
                bg.setBackgroundColor(getResources().getColor(R.color.white));
            }

            stocks_list.addView(current_item);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // this adds the dropdown menu
        getMenuInflater().inflate(R.menu.menu_activity_two, menu);

        //on the dropdown menu, grey out the current page
        MenuItem current_tab = menu.findItem(R.id.menu_profile);
        current_tab.setEnabled(false);

        ActionBar supbar = getSupportActionBar();
        supbar.setDisplayShowCustomEnabled(true);
        supbar.setDisplayShowTitleEnabled(false);

        return true;
    }
    public void onResume() {
        super.onResume();
        //first open up a view, modify it, and add it with setCustomView
        View title_and_money = getLayoutInflater().inflate(R.layout.actionbar, null);

        //set the title to 'sell;
        TextView title_text = (TextView) title_and_money.findViewById(R.id.actionbar_title);
        title_text.setText(getResources().getString(R.string.select_profile));

        //set money to whatever
        TextView money_text = (TextView) title_and_money.findViewById(R.id.actionbar_money);

        SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", MODE_PRIVATE);
        money_text.setText("" + pref.getLong("User_money", 0) + "$");

        //add the custom view to the action bar
        getSupportActionBar().setCustomView(title_and_money);
    }
}
