package edu.kvcc.cis298.cis298assignment2;

/**
 * Created by jkoehler5171 on 10/3/2016.
 */
public class Calculation {

    private String mSolutionString;
    private String mFormulaString;
    private double mSolutionDouble;


public Calculation(){

}


    public String getFormulaString() {
        return mFormulaString;
    }

    public void setFormulaString(String formulaString) {
        this.mFormulaString = formulaString;
    }

    public String getSolutionString() {
        return mSolutionString;
    }

    public void setSolutionString(String solutionString) {
        this.mSolutionString = solutionString;
    }

    public void TemperatureCalculation(int inputDecimal, int fromInt, int toInt){

        if(fromInt == toInt){

        mSolutionString = inputDecimal + " = " + inputDecimal;

        mFormulaString = "No Conversion Selected";

    }

    if(fromInt == 1 && toInt ==2  ) {

       mSolutionDouble = inputDecimal * (9 /5) + 32;

        mSolutionString = inputDecimal + " = " + mSolutionDouble;

        mFormulaString = "F = C X (9/5) + 32";


    }

    if(fromInt ==1 && toInt == 3) {

        mSolutionDouble = inputDecimal + 273.15;

        mSolutionString = inputDecimal + " = " + mSolutionDouble;

        mFormulaString = "K = C + 273.15";
    }

    if(fromInt ==1 && toInt == 4) {

        mSolutionDouble = (inputDecimal + 273) * (9/5);

        mSolutionString = inputDecimal + " = " + mSolutionDouble;

        mFormulaString = "R = (C +273) X 9/5";

    }

    if(fromInt ==2 && toInt == 1) {

        mSolutionDouble = (inputDecimal - 32) * (5/9);

        mSolutionString = inputDecimal + " = " + mSolutionDouble;

        mFormulaString = "C = (F - 32) X 5/9"  ;


    }

    if(fromInt ==2 && toInt == 3) {

        mSolutionDouble = (inputDecimal + 459.67) * (5/9);

        mSolutionString = inputDecimal + " = " + mSolutionDouble;

        mFormulaString = "K = (F + 459.67)× 5/9";

    }

    if(fromInt ==2 && toInt == 4) {

        mSolutionDouble = inputDecimal + 459.67;

        mSolutionString = inputDecimal + " = " + mSolutionDouble;

        mFormulaString = "R = F + 459.67";

    }

    if(fromInt ==3 && toInt == 1) {

        mSolutionDouble = inputDecimal - 273.15;

        mSolutionString = inputDecimal + " = " + mSolutionDouble;

        mFormulaString = "C= K - 273.15";

    }

    if(fromInt ==3 && toInt == 2) {

        mSolutionDouble = inputDecimal * (9/5) - 459.67;

        mSolutionString = inputDecimal + " = " + mSolutionDouble;

        mFormulaString = "F = K × 9/5 - 459.67";

    }

    if(fromInt ==3 && toInt == 4) {

        mSolutionDouble = inputDecimal * (9/5);

        mSolutionString = inputDecimal + " = " + mSolutionDouble;

        mFormulaString = "R = K × 9/5";

    }

    if(fromInt ==4 && toInt == 1) {
        mSolutionDouble =(inputDecimal - 491.67) * (5/9);

        mSolutionString = inputDecimal + " = " + mSolutionDouble;

        mFormulaString = "C = (R - 491.67) × 5/9";
    }

    if(fromInt ==4 && toInt == 2) {

        mSolutionDouble = inputDecimal - 459.67 ;

        mSolutionString = inputDecimal + " = " + mSolutionDouble;

        mFormulaString = "F = R - 459.67";
    }

    if(fromInt ==4 && toInt == 3) {

        mSolutionDouble = inputDecimal * (5/9) ;

        mSolutionString = inputDecimal + " = " + mSolutionDouble;

        mFormulaString = "K = R × 5/9";

    }



}


}
