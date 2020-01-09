package com.ipivot.CarsProject.PageObject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ResearchPage {

	@FindBy(id="by_make_st")
	WebElement ByMake_Btn;
	
	@FindBy(id="by_cat_st")
	WebElement ByCategory_Btn;
	
//	@FindBy(xpath="//section[@id='byMake']")
//	List<WebElement> Make_List;
//	
//	@FindBy(id="byCategory")
//	List<WebElement> Category_List;
	
	@FindBy(id="acura_st")
	WebElement select_acura;
	
	@FindBy(xpath="//span[@id='suv']")
	WebElement select_SUV ;
	
	
	
public ResearchPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
	
	}

public void clickOnMakeBtn() {
	ByMake_Btn.click();
}

public void clickOnCategoryBtn() {
	ByCategory_Btn.click();
}

public void clickOnAcura() {
	select_acura.click();
	
}


public void clickOnCategoryList() {
	select_SUV.click();
	}
}


