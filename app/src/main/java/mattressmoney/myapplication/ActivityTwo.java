package mattressmoney.myapplication;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.app.Activity;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class ActivityTwo extends BaseActivity implements ActionBar.TabListener {

    public ViewPager viewPager;
    private MyAdapter myAdapter;
    private ActionBar actionBar;
    private String[] tabs = {"Owned", "Hot ", "Popular"};
    public int opened = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_two);

        //set up swipe-tabs views
        viewPager = (ViewPager) findViewById(R.id.pager);
        myAdapter = new MyAdapter(getSupportFragmentManager());
        viewPager.setAdapter(myAdapter);

        //set up action bar
        actionBar = getSupportActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        //implement switching tabs
        ActionBar.TabListener tabListener = new ActionBar.TabListener() {
            @Override
            public void onTabSelected(ActionBar.Tab tab, android.support.v4.app.FragmentTransaction ft) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(ActionBar.Tab tab, android.support.v4.app.FragmentTransaction ft) {}

            @Override
            public void onTabReselected(ActionBar.Tab tab, android.support.v4.app.FragmentTransaction ft) {}
        };

        //make tabs
        for (String tab_name : tabs) {
            actionBar.addTab(
                    actionBar.newTab()
                            .setText(tab_name)
                            .setTabListener(this));
        }

        //makes swiping also switch tabs
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageSelected(int position) {
                actionBar.setSelectedNavigationItem(position);
            }

            @Override
            public void onPageScrolled(int one, float two, int three) {
            }

            @Override
            public void onPageScrollStateChanged(int one) {
            }
        });// end of changeListener
    }//end of onCreate

    @Override
    public void onTabSelected(ActionBar.Tab tab, android.support.v4.app.FragmentTransaction ft) {
        actionBar.setSelectedNavigationItem(tab.getPosition());
        viewPager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, android.support.v4.app.FragmentTransaction ft) {}

    @Override
    public void onTabReselected(ActionBar.Tab tab, android.support.v4.app.FragmentTransaction ft) {}

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_activity_two, menu);

        //on the dropdown menu, grey out the current page
        MenuItem current_tab = menu.findItem(R.id.menu_stocks);
        current_tab.setEnabled(false);



        ActionBar supbar = getSupportActionBar();
        supbar.setDisplayShowCustomEnabled(true);
        supbar.setDisplayShowTitleEnabled(false);


        //hack a custom view into the action bar
        //first open up a view, modify it, and add it with setCustomView
        View title_and_money = getLayoutInflater().inflate(R.layout.actionbar, null);

        //set the title to 'stocks;
        TextView title_text =(TextView) title_and_money.findViewById(R.id.actionbar_title);
        title_text.setText(getResources().getString(R.string.select_stocks));

        //set money to whatever
        TextView money_text =(TextView) title_and_money.findViewById(R.id.actionbar_money);
        money_text.setText("100$");

        //add the custom view to the action bar
        supbar.setCustomView(title_and_money);

        return true;
    }
}
