package com.github.a5809909.hwork02_testsimplecalculator;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.EditText;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.android.controller.ActivityController;
import org.robolectric.annotation.Config;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertNotNull;

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21)

    public class CalculatorTestRobolectric {

        private ActivityController<CalculatorActivity> activityController;

        private CalculatorActivity calculatorActivity;

        @Before
        public void init(){
            activityController= Robolectric.buildActivity(CalculatorActivity.class);
        }

        @After
        public void destroyActivity(){
            activityController.pause().stop().destroy();
        }


        @Test
        public void testViews() {
            activityController.create();
            activityController.start();
            activityController.resume(); //TODO move Activity lifecycle-methods in init-method

            CalculatorActivity calculatorActivity = activityController.get();

            boolean isEditTextFirstNumberEnable=calculatorActivity.findViewById(R.id.etFirstNumber).isEnabled();
            assertEquals(isEditTextFirstNumberEnable,true);
            boolean isEditTextSecondNumberEnable = calculatorActivity.findViewById(R.id.etSecondNumber).isEnabled();
            assertEquals(isEditTextSecondNumberEnable, true);

            Assert.assertEquals(calculatorActivity.findViewById(R.id.btnAdd).getVisibility(), View.VISIBLE);
            Assert.assertEquals(calculatorActivity.findViewById(R.id.btnSubtract).getVisibility(), View.VISIBLE);
            Assert.assertTrue(calculatorActivity.findViewById(R.id.btnMultiply).getVisibility()==View.VISIBLE);
            Assert.assertFalse(calculatorActivity.findViewById(R.id.btnDivide).getVisibility()!=View.VISIBLE);


            TextView mtvResult = (TextView)calculatorActivity.findViewById(R.id.tvResult);
            EditText metFirstNumber = (EditText) calculatorActivity.findViewById(R.id.etFirstNumber);
            EditText metSecondNumber = (EditText) calculatorActivity.findViewById(R.id.etSecondNumber);
            View mbtnAdd=calculatorActivity.findViewById((R.id.btnAdd));
            metFirstNumber.setText("2");
            metSecondNumber.setText("5");
            mbtnAdd.performClick();


    }

}
