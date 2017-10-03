package ddowney.com.rawjsontest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

import ddowney.com.rawjsontest.models.DataModel;
import ddowney.com.rawjsontest.utils.JsonResourceReader;

public class MainActivity extends AppCompatActivity {

    static final String LOG_TAG = "MainActivity";

    private TextView mainText;
    private Button mainButton;

    DataModel games;

    Random random = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        JsonResourceReader reader = new JsonResourceReader(getResources(), R.raw.all_games_min);
        games = reader.constructUsingGson(DataModel.class);

        mainText = (TextView) findViewById(R.id.main_text);
        mainButton = (Button) findViewById(R.id.main_button);

        mainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainText.setText(games.getNameOfGameWithId(random.nextInt(games.getSize())));
            }
        });

    }
}
