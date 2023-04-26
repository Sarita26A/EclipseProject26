package SelenniumFramework.SeleniumFrameworkDesign;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FirstTest{
    
  @Test
  public void shouldAnswerWithTrue() throws InterruptedException 
  {
	 ChromeOptions options = new ChromeOptions();
	 options.addArguments("--remote-allow-origins=*");
	 WebDriverManager.chromedriver().setup();
	 WebDriver driver=new ChromeDriver(options);
	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	 driver.get("https://rahulshettyacademy.com/client");
	 driver.manage().window().maximize();
	 driver.findElement(By.cssSelector("input[id='userEmail']")).sendKeys("sarita_25a@yahoo.co.in");
	 driver.findElement(By.cssSelector("input[id='userPassword']")).sendKeys("Market12345^");
	 driver.findElement(By.cssSelector("input[id='login']")).click();
	 WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	 wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class*='mb-3']")));
	 List<WebElement> products=driver.findElements(By.cssSelector("div[class*='mb-3']"));
	 //products.stream().forEach(prod->System.out.println(prod.findElement(By.cssSelector("b")).getText())); 
	 WebElement prod=products.stream().filter(product->product.findElement(By.cssSelector("b")).getText().equals("ZARA COAT 3")).findFirst().orElse(null);
	 prod.findElement(By.cssSelector("div[class='card-body'] button:last-of-type")).click();
	 wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
	 wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
	 driver.findElement(By.cssSelector("button[routerlink*='cart']")).click();
	 
	 List<WebElement> cartProducts= driver.findElements(By.cssSelector("div[class='cartSection'] h3"));
	 boolean match=cartProducts.stream().anyMatch(cartProd->cartProd.getText().equalsIgnoreCase("ZARA COAT 3"));
	 Assert.assertTrue(match);
	 wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li[class='totalRow'] button")));
	 driver.findElement(By.cssSelector("li[class='totalRow'] button")).click();
	 Actions a =new Actions(driver);
	 a.sendKeys(driver.findElement(By.cssSelector("input[placeholder='Select Country']")), "ind").build().perform();
	 wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("section[class*='ta-results'] button")));
	 driver.findElement(By.cssSelector("section[class*='ta-results'] button:nth-of-type(2)")).click();
	 driver.findElement(By.cssSelector("a[class*='action__submit']")).click();
	 String confirmationMessage=driver.findElement(By.xpath("//h1[text()=' Thankyou for the order. ']")).getText();
	 System.out.println(confirmationMessage);
	Assert.assertTrue(confirmationMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
			 
	 
	 
	 
  }
	  
	
	  
    
  
}
