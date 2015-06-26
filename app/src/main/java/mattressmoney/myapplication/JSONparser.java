package mattressmoney.myapplication;

import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by ben on 6/25/2015.
 * this is used to edit the json object into a useable form
 *
 *
 */
public class JSONparser {

    public static String phjson =
            "{\"results\":{" +
                "\"Name\": \"Company Full Name\","+
                "\"Tick\": \"(TICKER)\","+
                "\"Price\": \"0000.00\"," +
                "\"Change\": \"+-00.00\"," +
                "\"Change Percent\": \"+-00.00%\"" +
            "}}";

    public static HashMap<String, String> convert(String strJson){
        JSONObject jconvert = null;
        try {
            jconvert = new JSONObject(strJson);
        } catch (JSONException e) {
            Log.d("vvv", "" + e);
        }

        JSONObject results = null;
        try {
            results = jconvert.getJSONObject("results");
        } catch (JSONException e) {
            Log.d("vvv", "" + e);
        }
        return parse(results);
    }

    public static HashMap<String, String> parse(JSONObject jsonObject) {

        HashMap<String, String> data = new HashMap<String, String>();

        String ticker = "";
        String title = "";
        String price = "";
        String change = "";
        String changeper = "";

        try {
            ticker = jsonObject.getString("Tick");
            title = jsonObject.getString("Name");
            price = jsonObject.getString("Price");
            change = jsonObject.getString("Change");
            changeper = jsonObject.getString("Change Percent");

            data.put("Ticker", ticker);
            data.put("Title", title);
            data.put("Price", price);
            data.put("Change", change);
            data.put("Change Percent", changeper);

        } catch (JSONException e){
            Log.d("vvv", "" + e);
        }

        return data;
    }

    public static List<String> getProfile(){
        List<String> profile = new ArrayList<String>();
        for (int x = 0; x < 10; ++x){
            profile.add(phjson);
        }
        return profile;
    }


}
