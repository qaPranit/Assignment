package com.qa.fitPeo.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.fitPeo.baseTest.BaseTest;

public class HomePageTest extends BaseTest {

	

	@Test(priority = 1)
	public void getSliderValueTest() {
	 String value = hp.getSliderValue();
		Assert.assertEquals(value, "560");

	}
	
	@Test (priority = 2)
	public void reimbursementValueTest() {
		String value = hp.reimbursementValue();
		Assert.assertEquals(value, "$110700");
	}

}
