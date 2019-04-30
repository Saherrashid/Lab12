package edu.illinois.cs.cs125.spring2019.lab12;

import android.content.Context;
import android.os.AsyncTask;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import edu.illinois.cs.cs125.spring2019.lab12.Country;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.JsonObject;


import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.OkHttpClient;
import android.os.Vibrator;


/**
 * Main class for our UI design lab.
 */
public final class MainActivity extends AppCompatActivity {
    /** Default logging tag for messages from the main activity. */
    private static final String TAG = "Lab12:Main";

    /** Request queue for our API requests. */
    private static RequestQueue requestQueue;

    /**
     * Run when this activity comes to the foreground.
     *
     * @param savedInstanceState unused
     */
    //@Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestQueue = Volley.newRequestQueue(this);
        setContentView(R.layout.activity_main);
//        Button searcher = findViewById(R.id.searcher);
//        final TextView textView = findViewById(R.id.searchbox);
//
//        searcher.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(final View view) {
//                AsyncTask asyncTask = new AsyncTask() {
//                    @Override
//                    protected Object doInBackground(final Object[] objects) {
//                        OkHttpClient client = new OkHttpClient();
//                        Request request = new Request.Builder()
//                                .url("https://restcountries-v1.p.rapidapi.com/name/" +)
//                                .build();
//                        Response response = null;
//                        try {
//                            response = client.newCall(request)/execute();
//                            return response.body().string();
//                        }catch (IOException e) {
//                            e.printStackTrace();
//                        }
//
//                        return null;
//                    }
//                    @Override
//                    protected void onPostExecute(final Object o) {
//                        textView.setText(o.toString());
//                    }
//                }.execute();
//            }
        findViewById(R.id.searcher).setOnClickListener(v -> {
            EditText input = findViewById(R.id.searchbox);
            String inputName = input.getText().toString();
            startAPICall(inputName);
            findViewById(R.id.searcher).setVisibility(View.GONE);
            findViewById(R.id.again).setVisibility(View.VISIBLE);
            findViewById(R.id.flag).setVisibility(View.INVISIBLE);
            findViewById(R.id.Back).setVisibility(View.VISIBLE);
            Vibrator a = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
            a.vibrate(500);
        });
        findViewById(R.id.Back).setOnClickListener(v -> {
            findViewById(R.id.searcher).setVisibility(View.VISIBLE);
            findViewById(R.id.again).setVisibility(View.GONE);
            findViewById(R.id.flag).setVisibility(View.VISIBLE);
            findViewById(R.id.Back).setVisibility(View.GONE);
        });


    }
    /**
     * Run when this activity is no longer visible.
     */
    @Override
    protected void onPause() {
        super.onPause();
    }

    /**
     * Make a call to the IP geolocation API.
     *
     * @param inputName IP address to look up
     */

    void startAPICall(final String inputName) {
        try {
            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                    Request.Method.GET,
                    "https://restcountries-v1.p.rapidapi.com/name/" + inputName,
                    null,
                    new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(final JSONObject response) {
                            apiCallDone(response);
                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(final VolleyError error) {
                            Log.e(TAG, error.toString());
                        }
                    });
            jsonObjectRequest.setShouldCache(false);
            requestQueue.add(jsonObjectRequest);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Handle the response from our IP geolocation API.
     *
     * @param response response from our IP geolocation API.
     */
    void apiCallDone(final JSONObject response) {
        try {
            Log.d(TAG, response.toString(2));
            // Example of how to pull a field off the returned JSON object
            Log.i(TAG, response.get("hostname").toString());
        } catch (JSONException ignored) { }
    }
}

