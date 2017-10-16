package com.github.a5809909.hwork02_testsimplecalculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class CalculatorActivity extends AppCompatActivity implements View.OnClickListener {
    private Button mAddButton, mSubtractButton, mDivideButton, mMultiplyButton;
    private TextView mResultValueTextView;

    private EditText mFirstValueEditText, mSecondValueEditText;
    ICalculator mCalculator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_calculator);
        init();
    }

    private void init() {
        mAddButton = (Button) findViewById(R.id.btnAdd);
        mSubtractButton = (Button) findViewById(R.id.btnSubtract);
        mDivideButton = (Button) findViewById(R.id.btnDivide);
        mMultiplyButton = (Button) findViewById(R.id.btnMultiply);
        mFirstValueEditText = (EditText) findViewById(R.id.etFirstNumber);
        mSecondValueEditText = (EditText) findViewById(R.id.etSecondNumber);
        mResultValueTextView = (TextView) findViewById(R.id.tvResult);

        mAddButton.setOnClickListener(this);
        mSubtractButton.setOnClickListener(this);
        mDivideButton.setOnClickListener(this);
        mMultiplyButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        String firstNumber = mFirstValueEditText.getText().toString();
        String secondNumber = mSecondValueEditText.getText().toString();
        String result = "";

        if (firstNumber.equals("") || secondNumber.equals("")) {
            return;
        }

        mCalculator = new Calculator();

        switch (view.getId()) {
            case R.id.btnAdd:
                result = mCalculator.addition(firstNumber, secondNumber);
                break;
            case R.id.btnSubtract:
                result = mCalculator.subtraction(firstNumber, secondNumber);
                break;
            case R.id.btnDivide:
                result = mCalculator.division(firstNumber, secondNumber);
                break;
            case R.id.btnMultiply:
                result = mCalculator.multiply(firstNumber, secondNumber);
                break;
        }

        mResultValueTextView.setText(result);
    }
}