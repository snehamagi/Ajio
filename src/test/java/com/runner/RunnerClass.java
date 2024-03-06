package com.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
 
@RunWith(Cucumber.class)
@CucumberOptions(
		features=".\\src\\test\\resources",
		glue="com.Ajio",
		tags="@woman or @Mens",
		plugin={"html:target/reports.html","json:target/reports.json"},
		dryRun=false,
	    monochrome=true
		)          
public class RunnerClass {
} 