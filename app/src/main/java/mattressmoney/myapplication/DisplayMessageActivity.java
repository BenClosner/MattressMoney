package mattressmoney.myapplication;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class DisplayMessageActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //get the message from the intent
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        /*
        // create unique text view and display just that tv
        TextView textView = new TextView(this);
        textView.setTextSize(40);
        textView.setText(message);
        //set the text view as the activity layout
        setContentView(textView);
        */

        //finds the specific textview already made in the activity_display_message layout
        //the 'setContentView' line MUST COME FIRST. read below for details
        //http://stackoverflow.com/questions/18135040/textview-settext-android-is-causing-crashes-any-idea-why
        setContentView(R.layout.activity_display_message);
        TextView tv = (TextView) findViewById(R.id.trialview);
        tv.setText(message);
    }

    /*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_display_message, menu);
        return true;
    }
    */

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
