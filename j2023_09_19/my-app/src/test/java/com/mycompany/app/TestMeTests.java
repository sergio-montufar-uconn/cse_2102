package com.mycompany.app;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import com.mycompany.app.TestMe;

// import c.TestMe;

public class TestMeTests {

	TestMe testMe;

	@Before
	public void setUp() throws Exception {
		testMe  = new TestMe();
    }

	@Test
	public void squareTest() {

		double baseValue = 3.0;
		double expected = baseValue*baseValue;
		testMe.setValue(3.0);
		double actual = testMe.square();
	}

	@Test
	public void additionTest() {
		double baseValue = 3.0;
		double expected = baseValue + baseValue;
		testMe.setValue(3.0);
		double actual = testMe.addition();
	}

	@Test
	public void subtractionTest() {
		double baseValue = 6.0;
		double expected = baseValue - baseValue;
		testMe.setValue(6.0);
		double actual = testMe.subtraction();
	}
	
	@Test
	public void divisionTest() {
		double baseValue = 9.0;
		double expected = baseValue / baseValue;
		testMe.setValue(9.0);
		double actual = testMe.division();

	}
}

