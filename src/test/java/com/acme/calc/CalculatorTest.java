package com.acme.calc;

import org.junit.Assert;
import org.junit.Test;

public class CalculatorTest {

	private Calculator calculator;

	@Test
	public void additionShouldReturnCorrectResult() {
		calculator = new Calculator();
		// given
		double a = 5.0;
		double b = 6.0;
		// when
		Double result = calculator.add(a, b);
		// then
		Assert.assertTrue(result == 11);
	}

	@Test
	public void subtractionShouldReturnCorrectResult() {
		calculator = new Calculator();
		// given
		double a = 5.0;
		double b = 6.0;
		// when
		Double result = calculator.subtract(a, b);
		// then
		Assert.assertTrue(result == -1);
	}
	
	@Test
	public void multiplcstionShouldReturnCorrectResult(){
		calculator = new Calculator();
		// given
		double a = 5.0;
		double b = 6.0;
		// when
		Double result = calculator.multiply(a, b);
		// then
		Assert.assertTrue(result == 30);
	}
	
	@Test
	public void didvidetionShouldReturnCorrectResult(){
		calculator = new Calculator();
		// given
		double a = 6.0;
		double b = 6.0;
		// when
		Double result = calculator.divide(a, b);
		// then
		Assert.assertTrue(result == 1);
	}
	
	@Test(expected = DivisorCannotBeZeroException.class)
	public void DivisorShouldBeNot0(){
		calculator = new Calculator();
		// given
		double a = 6.0;
		double b = 0.0;
		// when
		Double result = calculator.divide(a, b);

	}

	// TODO division and multiplication test!

}
