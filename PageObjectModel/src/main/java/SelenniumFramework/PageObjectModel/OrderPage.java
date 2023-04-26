package SelenniumFramework.PageObjectModel;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import SeleniumFramework.ReusableComponents.ReusableCOmponents;

public class OrderPage extends ReusableCOmponents{
	WebDriver driver;
	public OrderPage(WebDriver driver) 
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(css="tr td:nth-child(3)")
	private List<WebElement> productsNameInOrderPage;
	public boolean orderPageSelectItem(String productName) 
	{
		boolean match=productsNameInOrderPage.stream().anyMatch(cartProd->cartProd.getText().equalsIgnoreCase(productName));
		return match;
	}

}
