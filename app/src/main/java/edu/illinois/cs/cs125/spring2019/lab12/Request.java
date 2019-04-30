package edu.illinois.cs.cs125.spring2019.lab12;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.TextView;




import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;

/**
 * public class.
 */
public class Request extends AsyncTask<String, Integer, String> {
    /**
     * string.
     */
    public String definition;
    /**
     * context.
     */
    Context context;
    /**
     * text.
     */
    TextView textView;
    /**
     * input.
     */
    String input;


    /**
     * context.
     * @param context fina.
     * @param textView text.
     * @param words word.
     */
    Request(Context context, TextView textView, String words) {
        this.context = context;
        this.textView = textView;
        this.input = words;
    }


    @Override
    protected String doInBackground(final String... params) {

        /**
         * id and key to access info.
         */
        final String app_id = "da25cb5f";
        /**
         * key.
         */
        final String app_key = "7ed61b928ae68e35463b2df1ca48512d";

        try {
            URL url = new URL(params[0]);
            HttpsURLConnection urlConnection = (HttpsURLConnection) url.openConnection();
            urlConnection.setRequestProperty("Accept", "application/json");
            urlConnection.setRequestProperty("app_id", app_id);
            urlConnection.setRequestProperty("app_key", app_key);

            // read the output from the server
            BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            StringBuilder stringBuilder = new StringBuilder();

            String line = null;
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line + "\n");
            }

            return stringBuilder.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return e.toString();
        }
    }

    /**
     * howto do this.
     * @param s inut.
     */
    @Override
    protected void onPostExecute(final String s) {
        super.onPostExecute(s);
        try {
            JSONObject j = new JSONObject(s);
            JSONArray results = j.getJSONArray("results");

            JSONObject entries = results.getJSONObject(0);
            JSONArray array = entries.getJSONArray("lexicalEntries");

            JSONObject def = array.getJSONObject(0);
            JSONArray e = def.getJSONArray("entries");

            JSONObject onb = e.getJSONObject(0);
            JSONArray sense = onb.getJSONArray("senses");

            JSONObject d = sense.getJSONObject(0);
            JSONArray de = d.getJSONArray("definitions");

            definition = de.getString(0);
            if (definition == null) {
                textView.setText("Definition Is Not Available")
                textView.setText(input.toUpperCase() + "-" + definition);
            } else {
                textView.setText(input.toUpperCase() + "-" + definition);
            }

        } catch (JSONException e)  {
            e.printStackTrace();
        }

    }
}
