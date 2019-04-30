package edu.illinois.cs.cs125.spring2019.lab12;

import android.content.Context;
import android.os.VibrationEffect;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.os.Vibrator;



/**
 * Main class for our UI design lab.
 */
public class MainActivity extends AppCompatActivity {
    /**
     * Default logging tag for messages from the main activity.
     */
    String url;
    EditText editText;
    Button button;
    TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.searcher);
        editText = findViewById(R.id.editText);
        textView = findViewById(R.id.textview);
    }

            public void onClick(View view) {
                String input = editText.getText().toString();
                Request request = new Request(this, textView, input);
                url = dictionaryEntries(input);
                request.execute(url);
            }
            public void onClick(View name) {
                findViewById(R.id.searcher).setOnClickListener(v -> {
                    Vibrator z = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                    z.vibrate(500);
                });
            }


    private String dictionaryEntries(final String input) {
        final String word = input;
        final String wordId = word.toLowerCase();
        return "https://od-api.oxforddictionaries.com:443/api/v2/entries/en-us/" + wordId;
    }

}
