package com.example.project_coe;


import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;


public class Calculator extends AppCompatActivity {

    TextView work, res;
    String workings = "";
    String formula = "";
    String tempFormula = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        initTextViews();
    }

    public void initTextViews() {
        work = (TextView) findViewById(R.id.workingTextView);
        res = (TextView) findViewById(R.id.resultTextView);
    }

    public void setWork(String givenValue) {
        workings = workings + givenValue;
        work.setText(workings);
    }


    public void resultsOnClick(View view) {
        Double results = null;
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("rhino");
        checkForPowerOf();

        try {
            results = (double) engine.eval(formula);
        } catch (ScriptException e) {
            Toast.makeText(this, "Invalid Input", Toast.LENGTH_SHORT).show();
        }

        if (results != null)
            res.setText(String.valueOf(results.doubleValue()));

    }

    private void checkForPowerOf() {
        ArrayList<Integer> indexOfPowers = new ArrayList<>();
        for (int i = 0; i < workings.length(); i++) {
            if (workings.charAt(i) == '^')
                indexOfPowers.add(i);
        }

        formula = workings;
        tempFormula = workings;
        for (Integer index : indexOfPowers) {
            changeFormula(index);
        }
        formula = tempFormula;
    }

    private void changeFormula(Integer index) {
        String numberLeft = "";
        String numberRight = "";

        for (int i = index + 1; i < workings.length(); i++) {
            if (isNumeric(workings.charAt(i)))
                numberRight = numberRight + workings.charAt(i);
            else
                break;
        }

        for (int i = index - 1; i >= 0; i--) {
            if (isNumeric(workings.charAt(i)))
                numberLeft = numberLeft + workings.charAt(i);
            else
                break;
        }

        String original = numberLeft + "^" + numberRight;
        String changed = "Math.pow(" + numberLeft + "," + numberRight + ")";
        tempFormula = tempFormula.replace(original, changed);
    }

    public boolean isNumeric(char c) {
        if ((c <= '9' && c >= '0') || c == '.')
            return true;

        return false;
    }


    public void clearOnClick(View view) {
        work.setText("");
        workings = "";
        res.setText("");
        leftBracket = true;
    }

    boolean leftBracket = true;

    public void bracketOnClick(View view) {
        if (leftBracket) {
            setWork("(");
            leftBracket = false;
        } else {
            setWork(")");
            leftBracket = true;
        }
    }

    public void expoOnClick(View view)
    {
        setWork("^");
    }

    public void divOnClick(View view)
    {
        setWork("/");
    }

    public void oneOnClick(View view)
    {
        setWork("1");
    }

    public void twoOnClick(View view)
    {
        setWork("2");
    }

    public void threeOnClick(View view)
    {
        setWork("3");
    }

    public void addOnClick(View view)
    {
        setWork("+");
    }

    public void fourOnClick(View view)
    {
        setWork("4");
    }

    public void fiveOnClick(View view)
    {
        setWork("5");
    }

    public void sixOnClick(View view)
    {
        setWork("6");
    }

    public void subOnClick(View view)
    {
        setWork("-");
    }

    public void sevenOnClick(View view) {
        setWork("7");
    }

    public void eightOnClick(View view) {

        setWork("8");
    }

    public void nineOnClick(View view)
    {
        setWork("9");
    }

    public void mulOnClick(View view)
    {
        setWork("*");
    }

    public void decimalOnClick(View view) {

        setWork(".");
    }

    public void zeroOnClick(View view)
    {
        setWork("0");
    }
}



