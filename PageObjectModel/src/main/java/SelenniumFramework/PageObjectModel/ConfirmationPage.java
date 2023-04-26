package SelenniumFramework.PageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConfirmationPage {
	WebDriver driver;

	public ConfirmationPage(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver,this);
		
	}
	@FindBy(xpath="//h1[text()=' Thankyou for the order. ']")
	WebElement confirmationMessageElement;
	
	public String getConfirmationMessage() 
	{
		String confirmationMessage=confirmationMessageElement.getText();
		return confirmationMessage;
	}

}
