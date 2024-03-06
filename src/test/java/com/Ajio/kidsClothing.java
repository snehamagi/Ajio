package com.Ajio;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.locators.AjioClothingLocators;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class kidsClothing {
	public static Reusable base=Reusable.getInstance();
	public static AjioClothingLocators locators=new AjioClothingLocators();
	
	@Given("Launch the Ajio {string}")
	public void launch_the_ajio(String url) {
	Reusable.gotlink(url);
		}

	
	@Given("Go to kids and click on clothing")
	public void go_to_kids_and_click_on_clothing() {
	  //WebElement kids=base.driver.findElement(By.xpath("//span[text()='KIDS']"));
	  base.goToElement(locators.getKids());
	 // WebElement cloth=base.driver.findElement(By.xpath("//strong[text()='NEW IN: CLOTHING']"));
	  base.button(locators.getCloth());
	}
	@Given("Go to mens and click on clothing")
	public void go_to_mens_and_click_on_clothing() {
		  WebElement men=base.driver.findElement(By.xpath("//span[text()='MEN']"));
		  base.goToElement(men);
		  WebElement cloth1=base.driver.findElement(By.xpath("//strong[text()='CLOTHING']"));
		  base.button(cloth1);
	      
	}

	@When("User click on dropdown and select the lowest price in dropdown")
	public void user_click_on_dropdown_and_select_the_lowest_price_in_dropdown() {
	   //WebElement click=base.driver.findElement(By.xpath("//select[@id='sortBy']"));
	   base.button(locators.getClick());
	   //WebElement dropdown=base.driver.findElement(By.xpath("//option[text()='Price (lowest first)']"));
	   base.button(locators.getDropdown());
	   
	}

	@Then("Validate the price in lowest price")
	public void validate_the_price_in_lowest_price() {
	   // List<WebElement> prices=base.driver.findElements(By.xpath("//span[@class='price  ']"));
	    for(int i=0;i<locators.getPrices().size();i++) {
	    	WebElement price=locators.getPrices().get(i);
	    	String s= base.retrieveText(price);
	    	System.out.println("Lowest Price"+s);
	    }}
	    @Then("Validate all the url")
	    public void validate_all_the_url() throws MalformedURLException, IOException {
	    	WebDriverManager.edgedriver().setup();
			WebDriver driver=new EdgeDriver();
			driver.get("https://www.flipkart.com/");
			driver.manage().window().maximize();
			List<WebElement>links=driver.findElements(By.tagName("link"));
			Iterator<WebElement> iterator=links.iterator();
			while(iterator.hasNext()) {
				WebElement next=iterator.next();
				String href=next.getAttribute("href");
				if(href==null ||href.isEmpty()) {
					System.out.println("Link not Available");
				}
				else if(!href.startsWith("https://www.flipkart.com/")) {
					System.out.println("Link not related to flipkart"+href);
				}
				else {
					HttpURLConnection http=(HttpURLConnection) (new URL(href).openConnection());
					http.setRequestMethod("HEAD");
					http.connect();
					int ResponseCode =http.getResponseCode();
					if(ResponseCode==200) {
						System.out.println("Not is the broken"+href);
							
						}
	         
	    }
		 
				}}}