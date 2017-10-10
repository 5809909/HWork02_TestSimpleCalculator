package com.github.a5809909.hwork02_testsimplecalculator;

import org.junit.Before;
import org.junit.Test;


import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.stub;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class CalculatorTestMockito {


    private ICalculator mMockCalculator;
    private ICalculator mSpyCalculator;

    @Before
    public void setup() {
        mMockCalculator = mock(Calculator.class);
        mSpyCalculator = spy(new Calculator());
    }

    @Test
    public void testZerosMock() throws Exception {
        when(mMockCalculator.addition("0", "0")).thenReturn("0.0");
        assertEquals(mMockCalculator.addition("0", "0"), "0.0");
        verify(mMockCalculator).addition("0", "0");
    }

    @Test
    public void testPositiveMock() throws Exception {
        stub(mMockCalculator.subtraction("1", "1")).toReturn("0.0");
        assertEquals(mMockCalculator.subtraction("1", "1"), "0.0");
        verify(mMockCalculator).subtraction("1", "1");
    }

    @Test
    public void testNegativeSpy() throws Exception {
        assertEquals(mSpyCalculator.multiply("-1", "-1"), "1.0");
        verify(mSpyCalculator).multiply("-1", "-1");

    }

    @Test
    public void testSumIsBlankForBlankEquationSpy() throws Exception {
        assertEquals(mSpyCalculator.division("5", "0"), "Cannot DIVIDE!");
        verify(mSpyCalculator).division("5", "0");
    }
}
