package mattressmoney.myapplication;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;


public class Sell extends BaseActivity {

    public int x = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sell);

        LinearLayout owned_list = (LinearLayout) findViewById(R.id.sell_owned_stocks);

        for (int x = 1; x <=10; x++){
            View current_item = getLayoutInflater().inflate(R.layout.list_item, null);

            View bg = current_item.findViewById(R.id.list_item_LL);
            if (x % 2 == 0){
                bg.setBackgroundColor(getResources().getColor(R.color.grey));
            } else {
                bg.setBackgroundColor(getResources().getColor(R.color.white));
            }

            owned_list.addView(current_item);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // this adds the dropdown menu
        getMenuInflater().inflate(R.menu.menu_activity_two, menu);

        //on the dropdown menu, grey out the current page
        MenuItem current_tab = menu.findItem(R.id.menu_sell);
        current_tab.setEnabled(false);

        ActionBar supbar = getSupportActionBar();
        supbar.setDisplayShowCustomEnabled(true);
        supbar.setDisplayShowTitleEnabled(false);


        //hack a custom view into the action bar
        //first open up a view, modify it, and add it with setCustomView
        View title_and_money = getLayoutInflater().inflate(R.layout.actionbar, null);

        //set the title to 'stocks;
        TextView title_text =(TextView) title_and_money.findViewById(R.id.actionbar_title);
        title_text.setText(getResources().getString(R.string.select_sell));

        //set money to whatever
        TextView money_text =(TextView) title_and_money.findViewById(R.id.actionbar_money);
        money_text.setText("100$");

        //add the custom view to the action bar
        supbar.setCustomView(title_and_money);

        return true;
    }
}
