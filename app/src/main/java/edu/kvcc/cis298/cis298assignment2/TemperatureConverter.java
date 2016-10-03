package edu.kvcc.cis298.cis298assignment2;

import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import org.w3c.dom.Text;

public class TemperatureConverter extends AppCompatActivity {

    private RadioButton mFromCelsiusRadioButton;
    private RadioButton mFromFahrenheitRadioButton;
    private RadioButton mFromKelvinRadioButton;
    private RadioButton mFromRankinRadioButton;
    private RadioButton mToCelsiusRadioButton;
    private RadioButton mToFahrenheitRadioButton;
    private RadioButton mToKelvinRadioButton;
    private RadioButton mToRankinRadioButton;

    private Button mConvertButton;

    private EditText mTemperatureInput;

    private TextView mSolutionTextView;
    private TextView mFormulaTextView;

    private int fromInt;
    private int toInt;

    private int inputDecimal;


    private Calculation Calcs = new Calculation();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temperature_converter);

        mFromCelsiusRadioButton = (RadioButton) findViewById(R.id.from_celsius_radio);

        mFromCelsiusRadioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fromInt = 1;
            }
        });

        mFromFahrenheitRadioButton = (RadioButton) findViewById(R.id.from_fahrenheit_radio);

        mFromFahrenheitRadioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fromInt = 2;
            }
        });

        mFromKelvinRadioButton= (RadioButton) findViewById(R.id.from_kelvin_radio);

        mFromKelvinRadioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fromInt = 3;
            }
        });


        mFromRankinRadioButton= (RadioButton) findViewById(R.id.from_rankin_radio);

        mFromRankinRadioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fromInt = 4;
            }
        });


        mToCelsiusRadioButton= (RadioButton) findViewById(R.id.to_celsius_radio);

        mToCelsiusRadioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toInt = 1;
            }
        });

        mToFahrenheitRadioButton= (RadioButton) findViewById(R.id.to_fahrenheit_radio);

        mToFahrenheitRadioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toInt = 2;
            }
        });

        mToKelvinRadioButton= (RadioButton) findViewById(R.id.to_kelvin_radio);

        mToKelvinRadioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toInt = 3;
            }

            });

        mToRankinRadioButton= (RadioButton) findViewById(R.id.to_rankin_radio);

        mToRankinRadioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toInt = 4;
            }
        });

        mTemperatureInput= (EditText) findViewById(R.id.starting_temp);

        mConvertButton= (Button) findViewById(R.id.convert_button);

        mConvertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                inputDecimal = Integer.parseInt(mTemperatureInput.getText().toString());

                Calcs.TemperatureCalculation(inputDecimal, fromInt, toInt);

                UpdateText();

            }
        });



    }

    private void UpdateText(){
        mFormulaTextView = (TextView) findViewById(R.id.formula_text);

        mFormulaTextView.setText(Calcs.getFormulaString());

        mSolutionTextView = (TextView) findViewById(R.id.solution_text);

        mSolutionTextView.setText(Calcs.getSolutionString());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_temperature_converter, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
