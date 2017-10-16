package com.github.a5809909.hwork02_testsimplecalculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class CalculatorActivity extends AppCompatActivity implements View.OnClickListener {
    //TODO - rename variables. 
    // Sample : private Button mAddButton;
    // private EditText mFirstValueEditText;
    
    
    private Button btnAdd,btnsub,btndivide,btnmul;
    private TextView tvresult;

    private EditText etfirst,etsecond;
    ICalculator mCalculator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); //TODO add new line after super-method
        setContentView(R.layout.activity_calculator);
        init();
    }

    private void init() {//TODO format code : add spaces
        btnAdd =(Button)findViewById(R.id.btnAdd);
        btnsub = (Button)findViewById(R.id.btnSubtract);
        btndivide = (Button)findViewById(R.id.btnDivide);
        btnmul = (Button)findViewById(R.id.btnMultiply);
        etfirst = (EditText)findViewById(R.id.etFirstNumber);
        etsecond =(EditText)findViewById(R.id.etSecondNumber);
        tvresult = (TextView)findViewById(R.id.tvResult);

        btnAdd.setOnClickListener(this);
        btnsub.setOnClickListener(this);
        btndivide.setOnClickListener(this);
        btnmul.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        String num1 = etfirst.getText().toString();
        String num2 = etsecond.getText().toString();
        String result = "";

        if (num1.equals("")||num2.equals("")) {
            return;
        }//TOD add new line after if-statment
        mCalculator= new Calculator();//TOD add new line before switch
        switch(view.getId()){
            case R.id.btnAdd:
                result=mCalculator.addition(num1,num2);
                break;
            case R.id.btnSubtract:
                result=mCalculator.subtraction(num1,num2);
                break;
            case R.id.btnDivide:
                result=mCalculator.division(num1,num2);
                break;
            case R.id.btnMultiply:
                result=mCalculator.multiply(num1,num2);
                break;
        }//TOD add new line after switch
        tvresult.setText(result);
    }
}
