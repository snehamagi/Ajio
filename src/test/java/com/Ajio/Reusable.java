package com.Ajio;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Reusable {
	public static Reusable base=null;
	private Reusable() {}
	public static Reusable getInstance() {
		if(base==null) {
			base=new Reusable();
		}
		return base;
	}
	
	public static WebDriver driver;
	public static Actions action;
	public static JavascriptExecutor js;
	
	public static void browserLaunch() {
		WebDriverManager.edgedriver().setup();
		EdgeOptions options=new EdgeOptions();
		options.addArguments("start-maximized");
		driver=new EdgeDriver(options);
		js=(JavascriptExecutor)driver;
		action=new Actions(driver);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS); 
		
	}
	public static void gotlink(String url) {
		driver.get(url);
	}

	public static void browserClose() {
		driver.quit();
	}
	public void pageRefresh() {
		driver.navigate().refresh();
	}
	public String titleName() {
		String title=driver.getTitle();
		return title;
	}
	public void insertText(WebElement element,String Value) {
		element.sendKeys(Value);
	}
	public void button(WebElement element) {
		element.click();
	}
	public boolean displayed(WebElement element) {
		Boolean displayed=element.isDisplayed();
		return displayed;
	}
	public boolean visibilityOfElement(WebElement element) {
		Boolean visible=element.isSelected();
		return visible;
	}
	public String retrieveText(WebElement element) {
		String text=element.getText();
		return text;
	}
	public String attribute(WebElement element,String att) {
		 String attribute=element.getAttribute(att);
		 return attribute;
	}
	public void goToElement(WebElement element) {
		action.moveToElement(element).build().perform();
	}
	public void rigtClick(WebElement element) {
		action.contextClick().build().perform();
	}
	public void twoClick(WebElement element) {
		action.doubleClick().build().perform();
	}
	public void oneElementToAnathor(WebElement source,WebElement target) {
		action.dragAndDrop(source, target).build().perform();
	}
	public void insertText(String Value,WebElement element) {
		action.sendKeys(Value);
	}
	public void button(WebElement element,int x) {
		action.click().build().perform();
	}
	public void screensot(WebElement filename) throws IOException {
		 File sne=new File("C:\\Users\\sneha\\eclipse-workspace\\com.facebook\\target\\screenshots"+filename+".png");
		 TakesScreenshot tk=(TakesScreenshot)driver;
		 File sourse=tk.getScreenshotAs(OutputType.FILE);
		 FileUtils.copyFile(sourse,sne);
	}
	public void scrollUp(WebElement element) {
		js.executeScript("arguments[0].scrollIntoView(false)",element);
		
	}
	public void scrollDown(WebElement element) {
		js.executeScript("arguments[0].scrollIntoView(true)",element);
	}
	public void insertText(WebElement element,String value,String Javascript) {
		js.executeScript("arguments[0].setAttribute('value','"+value+"')",element);
	}
	public void button(WebElement element,String javascript) {
		js.executeScript("argument[0].click",element);
	}
	public void selectValue(WebElement dropdown,String value) {
		Select s=new Select(dropdown);
		s.selectByValue(value); 
	}
	public void deselectValue(WebElement dropdown,String value) {
		Select s=new Select(dropdown);
		s.deselectByValue(value); 
	}
	public void selectVisibleText(WebElement dropdown,String value) {
		Select s=new Select(dropdown);
		s.selectByVisibleText(value); 
	}
	public void deselectVisibleText(WebElement dropdown,String value) {
		Select s=new Select(dropdown);
		s.deselectByVisibleText(value); 
	}
	public Boolean multiple(WebElement dropdown,String value) {
		Select s=new Select(dropdown);
		Boolean multi=s.isMultiple(); 
		return multi;
	}
	public List<WebElement> selectOptions(WebElement dropdown) {
		Select s=new Select(dropdown);
		List<WebElement> options=s.getOptions();
		return options;
	}
	public List<WebElement> selectAllOptions(WebElement dropdown) {
		Select s=new Select(dropdown);
		List<WebElement> option=s.getAllSelectedOptions();
		return option;
	}
	public WebElement selectAllFistOptions(WebElement dropdown) {
		Select s=new Select(dropdown);
		WebElement op=s.getFirstSelectedOption();
		return op;
	}
	public void defaultFrame(WebElement element) {
		driver.switchTo().defaultContent();
	}
	public void previousFrame(WebElement element) {
		driver.switchTo().parentFrame();
	}
	public void nextFrame(WebElement element) {
		driver.switchTo().frame(element);
	}
	public void popupInsertText(String value) {
		Alert alert=driver.switchTo().alert();
		alert.sendKeys(value);
	}
	public Alert popup(String value) {
		Alert alert=driver.switchTo().alert();
		return alert;
	}
	public void alertAccept(Alert alert) {
		 alert.accept();
	} 
	public void alertDismiss(Alert alert) {
		alert.dismiss();
	}
		
			}

