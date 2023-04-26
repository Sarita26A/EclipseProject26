package SelenniumFramework.PageObjectModel;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import SeleniumFramework.ReusableComponents.ReusableCOmponents;

public class CartPage extends ReusableCOmponents {
	WebDriver driver;
	
	public CartPage(WebDriver driver) 
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
		
	}
	
	@FindBy(css="div[class='cartSection'] h3")
	List<WebElement> cartProducts;
	@FindBy(css="li[class='totalRow'] button")
	WebElement checkoutButton;
	
	
	public boolean productsInCartPage(String productName) 
	{
		 boolean match=cartProducts.stream().anyMatch(cartProd->cartProd.getText().equalsIgnoreCase(productName));
		 return match;
	}
	public CheckOut gotoCheckout() 
	{
		checkoutButton.click();
		return new CheckOut(driver);
	}

}
