package mattressmoney.myapplication;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

public class BaseActivity extends ActionBarActivity {

    int x = 500;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //disable home arrow on actionbar
        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(false);
        actionBar.setDisplayHomeAsUpEnabled(false);

    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        // this method automatically hides soft keyboards when other places on the screen are touched
        View v = getCurrentFocus();
        boolean ret = super.dispatchTouchEvent(event);

        if (v instanceof EditText) {
            View w = getCurrentFocus();
            int scrcoords[] = new int[2];
            w.getLocationOnScreen(scrcoords);
            float x = event.getRawX() + w.getLeft() - scrcoords[0];
            float y = event.getRawY() + w.getTop() - scrcoords[1];

            Log.d("Activity", "Touch event " + event.getRawX() + "," + event.getRawY() + " " + x + "," + y + " rect " + w.getLeft() + "," + w.getTop() + "," + w.getRight() + "," + w.getBottom() + " coords " + scrcoords[0] + "," + scrcoords[1]);
            if (event.getAction() == MotionEvent.ACTION_UP && (x < w.getLeft() || x >= w.getRight() || y < w.getTop() || y > w.getBottom()) ) {

                InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(getWindow().getCurrentFocus().getWindowToken(), 0);
            }
        }
        return ret;
    }

    @Override
    public void onResume(){
        super.onResume();
        /*
        SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", MODE_PRIVATE);
        View v = getActionBarView();
        Log.d("vvv", "" + v);

        Log.d("vvv", "here");
        TextView title = (TextView)v.findViewById(R.id.actionbar_money);
        Log.d("vvv", "here3");
        title.setText("" + pref.getLong("User_money", 0) + "$$");
        Log.d("vvv", "here4");

        View ab = getActionBarView();
        //TextView user_money = (TextView) ab.findViewById(R.id.actionbar_money);

        View title_and_money = getLayoutInflater().inflate(R.layout.actionbar, null);

        //set money to whatever
        TextView money_text =(TextView) title_and_money.findViewById(R.id.actionbar_money);
        money_text.setText("" + pref.getLong("User_money", 0) + "$");

        //add the custom view to the action bar
        getSupportActionBar().setCustomView(title_and_money);
        getSupportActionBar().setTitle("titleee");
        */

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

