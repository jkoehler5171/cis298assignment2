//Jordan Koehler
//MW 2:30 to 4:45
//October 10th, 2016

package edu.kvcc.cis298.cis298assignment2;

import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.StringBufferInputStream;

public class TemperatureConverter extends AppCompatActivity {

    private static final String FROM_INT = "0" ;
    private static final String TO_INT  = "0";
    private static final String FORMULA_TEXT = "Formula Here";
    private static final String SOLUTION_TEXT = "Solution Here";



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
    protected void onCreate(Bundle savedInstanceState) {  //On creation of the app, checks to see if there is any saved information and if so, sets the data accordingly.
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temperature_converter);


        if (savedInstanceState != null) {

            fromInt = savedInstanceState.getInt(FROM_INT);

            toInt = savedInstanceState.getInt(TO_INT);

            mFormulaTextView = (TextView) findViewById(R.id.formula_text);

            mFormulaTextView.setText(FORMULA_TEXT);

            mSolutionTextView = (TextView) findViewById(R.id.solution_text);

            mSolutionTextView.setText(SOLUTION_TEXT);

       }



        mFromCelsiusRadioButton = (RadioButton) findViewById(R.id.from_celsius_radio); // There's 8 separate Radio Buttons in this App, each one is created like this.

        mFromCelsiusRadioButton.setOnClickListener(new View.OnClickListener() { // Each button also sets a Variable to be used to select the conversion.
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

        mTemperatureInput= (EditText) findViewById(R.id.starting_temp); //This sets up the box in which the Temp to be converted is entered. Set as numbers only in XML

        mConvertButton= (Button) findViewById(R.id.convert_button); //This button calls the calculations needed by passing in the Input, and the information from the two radio buttons.

        mConvertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                inputDecimal = Integer.parseInt(mTemperatureInput.getText().toString());

                Calcs.TemperatureCalculation(inputDecimal, fromInt, toInt);


                UpdateText();

            }
        });



    }

    private void UpdateText(){  // This updates the text for the formula and solution.
        mFormulaTextView = (TextView) findViewById(R.id.formula_text);

        mFormulaTextView.setText(Calcs.getFormulaString());

        mSolutionTextView = (TextView) findViewById(R.id.solution_text);

        mSolutionTextView.setText(Calcs.getSolutionString());




    }

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) { // This saves the selected buttons along with the formula and solution text.
        super.onSaveInstanceState(savedInstanceState);

        savedInstanceState.putInt(FROM_INT, fromInt);

        savedInstanceState.putInt(TO_INT, toInt);

        savedInstanceState.putString(FORMULA_TEXT, mFormulaTextView.getText().toString() );

        savedInstanceState.putString(SOLUTION_TEXT, mSolutionTextView.getText().toString() );

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
