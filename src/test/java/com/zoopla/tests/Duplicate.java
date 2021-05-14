package com.zoopla.tests;

import org.testng.annotations.Test;

import junit.framework.Assert;

public class Duplicate {
	
	@Test
	public void matchName() {
		
		String actual= "actual";
		String expected= "ACTUAL";
		Assert.assertEquals(expected, actual);
//		if (actual.equals(expected)) {
//			System.out.println("Matched");
//		}else
//			System.out.println("Not matched");
	}

}
