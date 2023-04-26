package SelenniumFramework.PageObjectModel;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import SelenniumFramework.TestComponent.BaseTest;

public class SubmitOrderWithHashMapTest extends BaseTest{
	 @Test(dataProvider="getDataInHashMapForm",groups="Purchase1")
	  public void SubmitOrderwithDataParovider(HashMap<String,String> input) throws InterruptedException, IOException 
	  
		  {	
			 String countryName="India";
			 
			 ProductCatalogue productCatalogue=loginPage.loginToApplication(input.get("email"), input.get("password"));
			 List<WebElement> products=productCatalogue.getProductList();
			 productCatalogue.addProductToCart(input.get("productName"));
			 CartPage cartPage=productCatalogue.gotoCart();
			 Boolean match= cartPage.productsInCartPage(input.get("productName"));
			 Assert.assertTrue(match);
			 CheckOut checkOut=cartPage.gotoCheckout();
			 checkOut.selectCountry(countryName);
			 ConfirmationPage confirmationPage=checkOut.submitOrder();
			 String confirmationMessage=confirmationPage.getConfirmationMessage();
			 System.out.println(confirmationMessage);
			 Assert.assertTrue(confirmationMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
			 
		  }

	 @DataProvider
	  public Object[][] getDataInHashMapForm() 
	  {
		  HashMap<String,String> map=new HashMap<>();
		  map.put("email", "sarita_25a@yahoo.co.in");
		  map.put("password", "Market12345^");
		  map.put("productName", "ZARA COAT 3");
		  HashMap<String,String> map1=new HashMap<>();
		  map1.put("email", "shetty@gmail.com");
		  map1.put("password", "Iamking@000");
		  map1.put("productName", "ADIDAS ORIGINAL");
		  return new Object[][] {{map},{map1}};
		   
	  }
}
