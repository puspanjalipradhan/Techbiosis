package com.techbiosis;

import com.techbiosis.sortedballs.SortedBalls;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;


public class SortedBallsTest extends TestCase {

	SortedBalls sortedBalls = new SortedBalls();
	
	/**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public SortedBallsTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( SortedBallsTest.class );
    }
    
	public void testAdd(){
		sortedBalls.add(1);
		assertTrue(validateArrayEquality(new int[]{1},sortedBalls.balls()));
		sortedBalls.add(2);
		assertTrue(validateArrayEquality(new int[]{1,2},sortedBalls.balls()));
		sortedBalls.add(65);
		assertTrue(validateArrayEquality(new int[]{1,2,65},sortedBalls.balls()));
		sortedBalls.add(365);
		assertTrue(validateArrayEquality(new int[]{1,2,65,365},sortedBalls.balls()));
	}
	
	public boolean validateArrayEquality(int[] expectedOutput,int[] output){
		for(int i=0;i<expectedOutput.length;i++){
			if(expectedOutput[i]!=output[i]){
				return false;
			}
		}
		return true;
	}
}
