package SelenniumFramework.PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import SeleniumFramework.ReusableComponents.ReusableCOmponents;

public class CheckOut extends ReusableCOmponents {
	WebDriver driver;

	public CheckOut(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(css="input[placeholder='Select Country']")
	WebElement country;
	@FindBy(css="a[class*='action__submit']")
	WebElement submit;
	@FindBy(css="section[class*='ta-results'] button:nth-of-type(2)")
	WebElement selectCountry;
	By automativeDropDown=By.cssSelector("section[class*='ta-results'] button");
	
	public void selectCountry(String countryName) 
	{
		Actions a =new Actions(driver);
		 a.sendKeys(country,countryName ).build().perform();
		 waitForElementToAppear(automativeDropDown);
		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("section[class*='ta-results'] button")));
		 selectCountry.click();
		
	}
	public ConfirmationPage submitOrder() 
	{
		 submit.click();
		 return new ConfirmationPage(driver);
	}
	
	
	

}
