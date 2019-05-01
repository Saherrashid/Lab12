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
        editText = findViewById(R.id.editText);
        textView = findViewById(R.id.textview);
        button = findViewById(R.id.searcher);
    }

            public void onClick(View view) {
                String phrase = editText.getText().toString();
                Request request = new Request(this, textView, phrase);
                url = dictionaryEntries(phrase);
                request.execute(url);
            }

    private String dictionaryEntries(final String input) {
        final String word = input;
        final String wordId = word.toLowerCase();
        return "https://od-api.oxforddictionaries.com:443/api/v2/entries/en-us/" + wordId;
    }

}
