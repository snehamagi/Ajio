package com.locators;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Ajio.Reusable;

public class AjioClothingLocators{
	public static AjioClothingLocators locators=null;

	public AjioClothingLocators(){
		PageFactory.initElements(Reusable.driver,this);
	}
	public static AjioClothingLocators getInstance() {
		if(locators==null) {
			locators=new AjioClothingLocators ();
		}
		return locators;
		}
	
	@FindBy(xpath="//span[text()='KIDS']")
	private WebElement kids;
	
	@FindBy(xpath="//strong[text()='NEW IN: CLOTHING']")
	private WebElement cloth;
	
	@FindBy(xpath="//span[text()='MEN']")
	private WebElement men;
	
	@FindBy(xpath="//strong[text()='CLOTHING']")
	private WebElement cloth1;
	
	@FindBy(xpath="//select[@id='sortBy']")
	private WebElement click;
	
	@FindBy(xpath="//option[text()='Price (lowest first)']")
	private WebElement dropdown;
	
	@FindBy(xpath="//span[@class='price  ']")
	private List<WebElement> prices;

	public WebElement getKids() {
		return kids;
	}

	public WebElement getCloth() {
		return cloth;
	}

	public WebElement getMen() {
		return men;
	}

	public WebElement getCloth1() {
		return cloth1;
	}

	public WebElement getClick() {
		return click;
	}

	public WebElement getDropdown() {
		return dropdown;
	}

	public List<WebElement> getPrices() {
		return prices;
	}

}