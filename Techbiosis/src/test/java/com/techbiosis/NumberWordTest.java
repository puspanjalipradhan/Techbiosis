package com.techbiosis;

import com.techbiosis.numberword.NumberWord;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class NumberWordTest 
    extends TestCase
{
	NumberWord numWord = new NumberWord();
    
	
	/**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public NumberWordTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( NumberWordTest.class );
    }

    
    
    public void testConvertNumberToWord(){
    	String output = numWord.convertNumberToWord(100);
    	assertTrue(output.equals("ONE HUNDRED"));
    	
    	output = numWord.convertNumberToWord(1000);
    	assertTrue(output.equals("ONE THOUSAND"));
    	
    	output = numWord.convertNumberToWord(10000);
    	assertTrue(output.equals("TEN THOUSAND"));
    	
    	output = numWord.convertNumberToWord(100000);
    	assertTrue(output.equals("ONE HUNDRED   THOUSAND"));
    	
    	output = numWord.convertNumberToWord(1000000);
    	assertTrue(output.equals("ONE MILLION"));
    }
}
