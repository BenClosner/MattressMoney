package mattressmoney.myapplication;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;


public class Leaderboards extends ActionBarActivity {

    int z;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leaderboards);

        //disable home arrow on actionbar
        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(false);
        actionBar.setDisplayHomeAsUpEnabled(false);

        //make some placeholder leaders
        LinearLayout leaderboards_ll = (LinearLayout) findViewById(R.id.leaderboard_ll);
        for (int x = 1; x < 101; x++){
            View currentitem = getLayoutInflater().inflate(R.layout.leaderboard_item, null);
            //alternate background colors
            View bg = currentitem.findViewById(R.id.lb_item_ll);
            if (x % 2 == 0){
                bg.setBackgroundColor(getResources().getColor(R.color.grey));
            } else {
                bg.setBackgroundColor(getResources().getColor(R.color.white));
            }

            TextView rank = (TextView) currentitem.findViewById(R.id.leaderboard_place);
            rank.setText("" + x);

            TextView name = (TextView) currentitem.findViewById(R.id.leaderboard_user);
            name.setText("random user");

            TextView dolla = (TextView) currentitem.findViewById(R.id.leaderboard_usermoney);
            z = 1000000 / x;
            dolla.setText("" + z + "$");

            leaderboards_ll.addView(currentitem);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // this adds the dropdown menu
        getMenuInflater().inflate(R.menu.menu_activity_two, menu);

        //on the dropdown menu, grey out the current page
        MenuItem current_tab = menu.findItem(R.id.menu_leaderboards);
        current_tab.setEnabled(false);

        ActionBar supbar = getSupportActionBar();
        supbar.setDisplayShowCustomEnabled(true);
        supbar.setDisplayShowTitleEnabled(false);


        //hack a custom view into the action bar
        //first open up a view, modify it, and add it with setCustomView
        View title_and_money = getLayoutInflater().inflate(R.layout.actionbar, null);

        //set the title to 'stocks;
        TextView title_text =(TextView) title_and_money.findViewById(R.id.actionbar_title);
        title_text.setText(getResources().getString(R.string.select_leaderboards));

        //set money to whatever
        TextView money_text =(TextView) title_and_money.findViewById(R.id.actionbar_money);
        money_text.setText("100$");

        //add the custom view to the action bar
        supbar.setCustomView(title_and_money);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        switch (item.getItemId()){
            case R.id.menu_profile:
                Intent profileintent = new Intent(this, UserProfile.class);
                profileintent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                startActivity(profileintent);
                break;
            case R.id.menu_stocks:
                Intent stocksintent = new Intent(this, ActivityTwo.class);
                stocksintent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                startActivity(stocksintent);
                break;
            case R.id.menu_lookup:
                Intent lookupintent = new Intent(this, Lookup.class);
                lookupintent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                startActivity(lookupintent);
                break;
            case R.id.menu_sell:
                Intent sellintent = new Intent(this, Sell.class);
                sellintent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                startActivity(sellintent);
                break;
            case R.id.menu_leaderboards:
                Intent lbintent = new Intent(this, Leaderboards.class);
                lbintent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                startActivity(lbintent);
                break;
            case R.id.menu_settings:
                Intent setintent = new Intent(this, Settings.class);
                setintent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                startActivity(setintent);
                break;
            case R.id.menu_logout:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}