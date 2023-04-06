package ro.pub.cs.systems.eim.practicaltest01var03;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PracticalTest01Var03SecondaryActivity extends AppCompatActivity {


    private TextView resultTextView;
    private Button correctButton, incorrectButton;

    private ButtonClickListener buttonClickListener = new ButtonClickListener();
    private class ButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.correct_button:
                    Log.d("D", "Correct button pressed");
                    setResult(RESULT_OK, null);
                    break;
                case R.id.incorrect_button:
                    setResult(RESULT_CANCELED, null);
                    break;
            }
            finish();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var03_secondary);

        resultTextView = findViewById(R.id.first_edit_text);
        Intent intent = getIntent();
        if (intent != null && intent.getExtras().containsKey(Constants.resultString)) {
            String result = intent.getExtras().get(Constants.resultString).toString();

            resultTextView.setText(String.valueOf(result));
        }

        correctButton = findViewById(R.id.correct_button);
        correctButton.setOnClickListener(buttonClickListener);
        incorrectButton = findViewById(R.id.incorrect_button);
        incorrectButton.setOnClickListener(buttonClickListener);


    }


}