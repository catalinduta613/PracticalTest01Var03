package ro.pub.cs.systems.eim.practicaltest01var03;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class PracticalTest01Var03MainActivity extends AppCompatActivity {

    private EditText firstEditText;
    private EditText secondEditText;
    private EditText resultEditText;
    private Button plusButton;
    private Button minusButton;

    private String resultString;
    private Button navigateToSecondaryActivityButton;

    private ButtonClickListener buttonClickListener = new ButtonClickListener();
    private class ButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            int firstNumber = 0;
            try {
                firstNumber = Integer.valueOf(firstEditText.getText().toString());
            } catch (NumberFormatException numberFormatException) {
                Toast.makeText(getApplicationContext(), "Please insert a number " , Toast.LENGTH_LONG).show();
                return;
            }
            int result = Integer.valueOf(secondEditText.getText().toString());
            switch(view.getId()) {
                case R.id.plus_button:
                    result += firstNumber;
                    if (resultString == null) {
                        resultString = String.valueOf(firstNumber);
                    } else {
                        resultString = resultString + "+" + firstNumber;
                    }
//                    resultString = resultString + "+" + firstNumber;
                    resultEditText.setText(resultString + "=" + result);
                    secondEditText.setText(String.valueOf(result));
                    break;
                case R.id.minus_button:
                    result -= firstNumber;
                    if (resultString == null) {
                        resultString = String.valueOf(firstNumber);
                    } else {
                        resultString = resultString + "-" + firstNumber;
                    }
//                    resultString = resultString + "-" + firstNumber;
                    resultEditText.setText(resultString + "=" + result);
                    secondEditText.setText(String.valueOf(result));
                    break;
            }
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var03_main);
        firstEditText = findViewById(R.id.first_edit_text);
        secondEditText = findViewById(R.id.second_edit_text);
        resultEditText = findViewById(R.id.result_edit_text);
        plusButton = findViewById(R.id.plus_button);
        minusButton = findViewById(R.id.minus_button);
        navigateToSecondaryActivityButton = findViewById(R.id.navigate_to_secondary_activity_button);
        resultEditText.setText("");
        secondEditText.setText(String.valueOf(0));
        plusButton.setOnClickListener(buttonClickListener);
        minusButton.setOnClickListener(buttonClickListener);
    }

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putString(Constants.firstNumber, firstEditText.getText().toString());
        savedInstanceState.putString(Constants.resultString, resultEditText.getText().toString());
        savedInstanceState.putString(Constants.resultNumber, secondEditText.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        String res = "";
        if (savedInstanceState.containsKey(Constants.firstNumber)) {
            firstEditText.setText(savedInstanceState.getString(Constants.firstNumber));
            res = res + savedInstanceState.getString(Constants.firstNumber);
        } else {
            firstEditText.setText(String.valueOf(""));
        }
        if (savedInstanceState.containsKey(Constants.resultNumber)) {
            secondEditText.setText(savedInstanceState.getString(Constants.resultNumber));
            res = res + savedInstanceState.getString(Constants.resultNumber);
        } else {
            secondEditText.setText(String.valueOf(0));
        }
        if (savedInstanceState.containsKey(Constants.resultString)) {
            resultEditText.setText(savedInstanceState.getString(Constants.resultString));
            res = res + savedInstanceState.getString(Constants.resultString);
        } else {
            resultEditText.setText(String.valueOf(""));
        }
        Toast.makeText(this, "values: " + res, Toast.LENGTH_LONG).show();
    }
}