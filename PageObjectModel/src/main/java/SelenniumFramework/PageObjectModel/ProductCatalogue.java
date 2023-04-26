package SelenniumFramework.PageObjectModel;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import SeleniumFramework.ReusableComponents.ReusableCOmponents;

public class ProductCatalogue extends ReusableCOmponents
{
	WebDriver driver;
	public ProductCatalogue(WebDriver driver) 
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);	
	}
	
	@FindBy(css="div[class*='mb-3']")
	List<WebElement> products;
	@FindBy(css=".ng-animating")
	WebElement spinner;
	
	By productsLocator=By.cssSelector("div[class*='mb-3']");
	By addToCartLocator=By.cssSelector("div[class='card-body'] button:last-of-type");
	By toastContainer=By.cssSelector("#toast-container");
	
	public List<WebElement> getProductList() 
	{
		waitForElementToAppear(productsLocator);
		return products;
		
	}
	public WebElement getProductByName(String productName) 
	{
		 WebElement prod=products.stream().filter(product->product.findElement(By.cssSelector("b")).getText().equals("ZARA COAT 3")).findFirst().orElse(null);
		 return prod;
	}
	public void addProductToCart(String productName)
	{
		WebElement prod=getProductByName(productName);
		prod.findElement(addToCartLocator).click();
		waitForElementToAppear(toastContainer);
		waitForElementToDisappear(spinner);
	}
	
}
