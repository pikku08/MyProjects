package com.zoopla.tests;

import org.testng.annotations.Test;

import junit.framework.Assert;

public class Natch {
	
	@Test
	public void matchName() {
		
		String actual= "actual";
		String expected= "actual";
		Assert.assertEquals(expected, actual);
//		if (actual.equals(expected)) {
//			System.out.println("Matched");
//		}else
//			System.out.println("Not matched");
	}

}
