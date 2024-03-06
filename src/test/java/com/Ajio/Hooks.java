package com.Ajio;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {
	
	@Before
	public void Launcing(Scenario Scenario) {
		Reusable.browserLaunch();
	   	final byte[] sourse=((TakesScreenshot)Reusable.driver).getScreenshotAs(OutputType.BYTES);
	   Scenario.embed(sourse,"image/png");
	}
	@After
	public void closeTheBrowser(Scenario Scenario) {
		final byte[] sourse=((TakesScreenshot)Reusable.driver).getScreenshotAs(OutputType.BYTES);
	    Scenario.embed(sourse,"image/png");
	    //Reusable.browserClose();
	}

}
