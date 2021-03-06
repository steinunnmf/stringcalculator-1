package is.ru.stringcalculator;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CalculatorTest {

	public static void main(String args[]) {
      org.junit.runner.JUnitCore.main("is.ru.stringcalculator.CalculatorTest");
    }

	@Test
	public void testEmptyString() {
		assertEquals(0, Calculator.add(""));
	}

	@Test
	public void testOneNumber() {
		assertEquals(1, Calculator.add("1"));
	}

	@Test
	public void testTwoNumbers() {
		assertEquals(3, Calculator.add("1,2"));
	}	

	@Test
    public void testMultipleNumbers(){
    	assertEquals(6, Calculator.add("1,2,3"));
    }
	
	@Test
    public void testNewLine1(){
    	assertEquals(6, Calculator.add("1\n2,3"));
    }

	@Test
    public void testNewLine2(){
    	assertEquals(6, Calculator.add("1\n2\n3"));
    }
	
	@Test
	public void testNewDelimiter1(){
		assertEquals(3, Calculator.add("//;\n1;2"));
	}
	
	@Test
	public void testNewDelimiter2(){
		assertEquals(5, Calculator.add("//#\n1#4"));
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testNegatives1() {
	    Calculator.add("-1,-2,3");
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testNegatives2() {
	    Calculator.add("//;\n-1;-2;3");
	}
	
	@Test
	public void testLargeNumber() {
		assertEquals(2, Calculator.add("1001,2"));
	}

}