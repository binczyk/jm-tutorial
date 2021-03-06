package com.acme.calc;

import org.junit.Assert;
import org.junit.Test;

public class CalculatorTest {

	private Calculator calculator = new Calculator();

	@Test
	public void additionShouldReturnCorrectResult() {
<<<<<<< HEAD
		calculator = new Calculator();
		// given
		double a = 5.0;
		double b = 6.0;
		// when
		Double result = calculator.add(a, b);
		// then
=======
		// given
		double firstNumber = 5.0;
		double secondNumber = 6.0;
		// when
		Double result = calculator.add(firstNumber, secondNumber);
		// then
		Assert.assertFalse(result.isNaN());
>>>>>>> upstream/master
		Assert.assertTrue(result == 11);
	}

	private double firstNumber;
	private double secondNumber;
	private Exception thrown;
	@Test
<<<<<<< HEAD
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

=======
	public void divisionShouldThrowExceptionWhenDivisorIsZero() {
		givenNumbersWithZero();
		catchException(() -> calculator.divide(firstNumber,secondNumber));
		assertException(DivisorCannotBeZeroException.class);
	}

	private void catchException(Runnable runnable) {
		try {
			runnable.run();
		} catch (Exception e) {
			thrown = e;
		}
>>>>>>> upstream/master
	}

	private void assertException(Class<DivisorCannotBeZeroException> expectedExceptionClass) {
		Assert.assertNotNull(thrown);
		Assert.assertTrue(expectedExceptionClass.equals(thrown.getClass()));
	}
	private void assertThat(Exception e, Class<?> expectedClass) {
		Assert.assertTrue(e.getClass().equals(expectedClass));
	}
	private void thenCorrectExceptionIsThrons(Exception e) {
		Assert.assertTrue(e.getClass().equals(
				DivisorCannotBeZeroException.class));
	}
	// TODO division and multiplication test!
	private void givenNumbersWithZero() {
		firstNumber = 5.0;
		secondNumber = 0.0;
	}

}
