package mattressmoney.myapplication;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class BaseActivity extends ActionBarActivity {

    int opened = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //disable home arrow on actionbar
        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(false);
        actionBar.setDisplayHomeAsUpEnabled(false);

    }

    @Override
    public void onResume(){
        super.onResume();

        View title_and_money = getLayoutInflater().inflate(R.layout.actionbar, null);

        //set the title to 'stocks;
        TextView title_text =(TextView) title_and_money.findViewById(R.id.actionbar_title);
        title_text.setText(getResources().getString(R.string.select_sell));

        //set money to whatever
        TextView money_text =(TextView) title_and_money.findViewById(R.id.actionbar_money);
        money_text.setText("" + opened++ + "$");



        //add the custom view to the action bar
        getSupportActionBar().setCustomView(title_and_money);
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

