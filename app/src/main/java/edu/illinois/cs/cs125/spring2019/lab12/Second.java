package edu.illinois.cs.cs125.spring2019.lab12;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.android.volley.RequestQueue;
import edu.illinois.cs.cs125.spring2019.lab12.Country;

/**
 * comment.
 */
public class Second extends AppCompatActivity {
    /**
     * name.
     */
    private static final String TAG = "Lab12:Main";

    /**
     * Request queue for our API requests.
     */
    private static RequestQueue requestQueue;

    /**
     * Run when this activity comes to the foreground.
     *
     * @param savedInstanceState unused
     */
    //@Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        findViewById(R.id.Lookup_address).setOnClickListener(v -> {
//            startAPICall("192.17.96.8");
//        });
//
//        // Set up the queue for our API requests
//        requestQueue = Volley.newRequestQueue(this);

        setContentView(R.layout.information);

        //startAPICall("192.17.96.8");
    }

    /**
     * Run when this activity is no longer visible.
     */
    @Override
    protected void onPause() {
        super.onPause();
    }

}
