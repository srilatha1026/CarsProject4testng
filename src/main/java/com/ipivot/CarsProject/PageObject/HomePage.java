package com.ipivot.CarsProject.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	//@FindBy(xpath="//a[@class='hero-btn one']")
	@FindBy(id="research_st")
	WebElement Research_Btn;

	@FindBy(id="c4s_st")
	WebElement Cars4sale_Btn;


	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}


	public void clickResearchBtn() {
		Research_Btn.click();
	}
	public void clickCars4SaleBtn() {
		Cars4sale_Btn.click();
	}




}