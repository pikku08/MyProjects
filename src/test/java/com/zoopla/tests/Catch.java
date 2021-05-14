package com.zoopla.tests;

import org.testng.annotations.Test;

import junit.framework.Assert;

public class Catch {
	@Test
	public void matchName() {
		
		String actual= "actual";
		String expected= "ActuaL";
		Assert.assertEquals(expected, actual);
//		if (actual.equalsIgnoreCase(expected)) {
//			System.out.println("Matched");
//		}else
//			System.out.println("Not matched");
	}

}
