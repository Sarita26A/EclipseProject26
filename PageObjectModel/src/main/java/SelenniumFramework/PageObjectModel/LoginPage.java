package SelenniumFramework.PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import SeleniumFramework.ReusableComponents.ReusableCOmponents;

public class LoginPage extends ReusableCOmponents{
	WebDriver driver;
	public LoginPage(WebDriver driver) 
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	//WebElement userName=driver.findElement(By.cssSelector("input[id='userEmail']"));
	@FindBy(css="input[id='userEmail']")
	WebElement userName;
	@FindBy(css="input[id='userPassword']")
	WebElement passWord;
	@FindBy(css="input[id='login']")
	WebElement loginButton;
	@FindBy(css="div[role='alertdialog']")
	WebElement errorMessagePopup;
	
	
	public ProductCatalogue loginToApplication(String username,String password) 
	{
		userName.sendKeys(username);
		passWord.sendKeys(password);
		loginButton.click();
		return new ProductCatalogue(driver);
		 
	
	}
	public void gotoLoginPage() 
	{
		driver.get("https://rahulshettyacademy.com/client");
	}
	
	public String getErrorMessage() 
	{
		waitForWebElementToAppear(errorMessagePopup);
		return errorMessagePopup.getText();
	}
	
	

}
