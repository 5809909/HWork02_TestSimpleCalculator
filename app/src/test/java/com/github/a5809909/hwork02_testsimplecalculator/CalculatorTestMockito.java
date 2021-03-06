package com.github.a5809909.hwork02_testsimplecalculator;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;

import java.util.List;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.stub;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class CalculatorTestMockito {


    private ICalculator mMockCalc;
    private ICalculator mSpyCalc;

    @Captor
    ArgumentCaptor<String> argumentCaptor;

    @Before
    public void setup() {
        mMockCalc = mock(Calculator.class);
        mSpyCalc =spy(new Calculator());
    }

    @Test
    public void testAdditionMock() throws Exception {
        when(mMockCalc.addition("1", "2")).thenReturn("3.0");
        assertEquals(mMockCalc.addition("1", "2"), "3.0");
        verify(mMockCalc,atLeastOnce()).addition("1", "2");
    }

    @Test
    public void testSubtractionMock() throws Exception {
        stub(mMockCalc.subtraction("10", "5")).toReturn("5.0");
        assertEquals(mMockCalc.subtraction("10", "5"), "5.0");
        verify(mMockCalc,atLeast(1)).subtraction("10", "5");
    }

    @Test
    public void testMultiplyMock() throws Exception {
        when(mMockCalc.multiply("6","8")).thenReturn("48.0");
        assertEquals(mMockCalc.multiply("6", "8"), "48.0");
        verify(mMockCalc).multiply("6", "8");

    }

    @Test
    public void testDivisionByZero() throws Exception {
        stub(mMockCalc.division("5", "0")).toReturn( "Cannot DIVIDE!");
        assertEquals(mMockCalc.division("5", "0"), "Cannot DIVIDE!");
        verify(mMockCalc).division("5", "0");
    }
    @Test
    public void CalcSpy(){
        when(mSpyCalc.addition("8","2")).thenReturn("10.0");
        mSpyCalc.addition("8","2");
        verify(mSpyCalc).addition("8","2");
        assertEquals("10.0", mSpyCalc.addition("8","2"));
    }
    @Test
    public void CalcSpyWithCaptor(){
        verify(mSpyCalc).addition("5","22");
        verify(mSpyCalc).addition(argumentCaptor.capture(),argumentCaptor.capture());
        List<String> value = argumentCaptor.getAllValues();
        assertEquals(String.valueOf("5"), value.get(0));
        assertEquals(String.valueOf("22"), value.get(1));
    }
    @Test
    public void doReturnn(){
        doReturn(null).when(mMockCalc).addition("5","2");
    }

}
