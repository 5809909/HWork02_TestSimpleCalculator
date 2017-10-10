package com.github.a5809909.hwork02_testsimplecalculator;
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

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21)

    public class CalculatorTestRobolectric {

        private ActivityController<CalculatorActivity> activityController;

        @Before
        public void init(){
            activityController= Robolectric.buildActivity(CalculatorActivity.class);
        }

        @Test
        public void testCalculator() {
            activityController.create();
            activityController.start();
            activityController.resume();


            CalculatorActivity calculatorActivity = activityController.get();

            boolean isEditTextFirstNumberEnable=calculatorActivity.findViewById(R.id.etFirstNumber).isEnabled();
            assertEquals(isEditTextFirstNumberEnable,true);


            boolean isEditTextSecondNumberEnable = calculatorActivity.findViewById(R.id.etSecondNumber).isEnabled();
            assertEquals(isEditTextSecondNumberEnable, true);


            boolean isBtnAddEnabled = calculatorActivity.findViewById(R.id.btnAdd).isEnabled();
            assertEquals(isBtnAddEnabled, true);

            boolean isBtnSubtractEnabled = calculatorActivity.findViewById(R.id.btnSubtract).isEnabled();
            assertEquals(isBtnSubtractEnabled, true);

            boolean isBtnMultiplyEnabled = calculatorActivity.findViewById(R.id.btnMultiply).isEnabled();
            assertEquals(isBtnMultiplyEnabled, true);

            boolean isBtnDivideEnabled = calculatorActivity.findViewById(R.id.btnDivide).isEnabled();
            assertEquals(isBtnDivideEnabled, true);


        }


    }
