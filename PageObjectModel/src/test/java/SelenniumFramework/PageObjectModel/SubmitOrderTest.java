package SelenniumFramework.PageObjectModel;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import SelenniumFramework.TestComponent.BaseTest;

public class SubmitOrderTest extends BaseTest{
	String productName="ZARA COAT 3";
	 public void SubmitOrder() throws InterruptedException, IOException 
	  
	  {	
		 String countryName="India";
		 
		 ProductCatalogue productCatalogue=loginPage.loginToApplication("Sarita_25a@yahoo.co.in", "Market12345^");
		 List<WebElement> products=productCatalogue.getProductList();
		 productCatalogue.addProductToCart(productName);
		 CartPage cartPage=productCatalogue.gotoCart();
		 Boolean match= cartPage.productsInCartPage(productName);
		 Assert.assertTrue(match);
		 CheckOut checkOut=cartPage.gotoCheckout();
		 checkOut.selectCountry(countryName);
		 ConfirmationPage confirmationPage=checkOut.submitOrder();
		 String confirmationMessage=confirmationPage.getConfirmationMessage();
		 System.out.println(confirmationMessage);
		 Assert.assertTrue(confirmationMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		 
	  }
    
 /* @Test(dataProvider="getData",groups="Purchase")
  public void SubmitOrderwithDataParovider(String email,String passwd) throws InterruptedException, IOException 
  
	  {	
		 String countryName="India";
		 
		 ProductCatalogue productCatalogue=loginPage.loginToApplication(email, passwd);
		 List<WebElement> products=productCatalogue.getProductList();
		 productCatalogue.addProductToCart(productName);
		 CartPage cartPage=productCatalogue.gotoCart();
		 Boolean match= cartPage.productsInCartPage(productName);
		 Assert.assertTrue(match);
		 CheckOut checkOut=cartPage.gotoCheckout();
		 checkOut.selectCountry(countryName);
		 ConfirmationPage confirmationPage=checkOut.submitOrder();
		 String confirmationMessage=confirmationPage.getConfirmationMessage();
		 System.out.println(confirmationMessage);
		 Assert.assertTrue(confirmationMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		 
	  }*/
//dependsOnMethods={"SubmitOrder"}
  @Test()
  public void orderHistoryTest() 
  {
	  ProductCatalogue productCatalogue=loginPage.loginToApplication("sarita_25a@yahoo.co.in", "Market12345^");
	  OrderPage orderPage=productCatalogue.gotoOrderPage();
	  Assert.assertTrue(orderPage.orderPageSelectItem(productName));
	  
	  
	  
  }
  
 
  
 /* @DataProvider
  public Object[][] getData()
  {
	  return new Object[][] {{"sarita_25a@yahoo.co.in","Market12345^"},{"sarita_25a@yahoo.co.in","Market12345^"}};
  }
  &*/
  
	
}
