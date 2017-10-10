package com.github.a5809909.hwork02_testsimplecalculator;

import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.clearText;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class CalculatorActivityTestEspresso {

    @Rule
    public ActivityTestRule<CalculatorActivity> activityTestRule = new ActivityTestRule<>(CalculatorActivity.class);

    @Test
    public void checkCorrectAnswer() {
        onView(withId(R.id.etFirstNumber)).perform(clearText()).perform(typeText("4"));
        onView(withId(R.id.etSecondNumber)).perform(clearText()).perform(typeText("8"));
        onView(withId(R.id.btnAdd)).perform(click());
        onView(withId(R.id.tvResult)).check(matches(withText("12.0")));

        onView(withId(R.id.etFirstNumber)).perform(clearText()).perform(typeText("30"));
        onView(withId(R.id.etSecondNumber)).perform(clearText()).perform(typeText("5"));
        onView(withId(R.id.btnDivide)).perform(click());
        onView(withId(R.id.tvResult)).check(matches(withText("6.0")));

        onView(withId(R.id.etFirstNumber)).perform(clearText()).perform(typeText("7"));
        onView(withId(R.id.etSecondNumber)).perform(clearText()).perform(typeText("5"));
        onView(withId(R.id.btnMultiply)).perform(click());
        onView(withId(R.id.tvResult)).check(matches(withText("35.0")));

        onView(withId(R.id.etFirstNumber)).perform(clearText()).perform(typeText("6"));
        onView(withId(R.id.etSecondNumber)).perform(clearText()).perform(typeText("2"));
        onView(withId(R.id.btnSubtract)).perform(click());
        onView(withId(R.id.tvResult)).check(matches(withText("4.0")));


    }
}