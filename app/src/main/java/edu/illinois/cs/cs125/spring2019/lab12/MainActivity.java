package edu.illinois.cs.cs125.spring2019.lab12;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;



/**
 * Main class for our UI design lab.
 */
public final class MainActivity extends AppCompatActivity {
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
        button = (Button) findViewById(R.id.searcher);
        editText = (EditText) findViewById(R.id.searchbox);
        textView = (TextView) findViewById(R.id.textview);
    }
    public void onClick(final View view) {
        String input = editText.getText().toString();
        Request request = new Request(this, textView, input);
        url = dictionaryEntries(input);
        request.execute(url);
    }

    private String dictionaryEntries(final String input) {
        final String word = input;
        final String wordId = word.toLowerCase();
        return "https://od-api.oxforddictionaries.com:443/api/v2/entries/en/" + wordId;
    }

}
