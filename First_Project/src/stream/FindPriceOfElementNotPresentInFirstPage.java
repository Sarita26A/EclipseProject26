package stream;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FindPriceOfElementNotPresentInFirstPage {
	public static void main(String args[]) 
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		driver.findElement(By.cssSelector("tr th:nth-child(1)")).click();
		List<String>price;
		do {
		List<WebElement> elements= driver.findElements(By.cssSelector("tr td:nth-child(1)"));
		price =elements.stream().filter(s->s.getText().contains("Wheat")).map(s->getPriceOfveggie(s)).collect(Collectors.toList());
		price.forEach(s->System.out.println(s));
		//traverse to next page till item is found
		if(price.size()<1) 
		{
			driver.findElement(By.cssSelector("a[aria-label='Next']")).click();
		}
		}while(price.size()<1);
			
	}

	private static String getPriceOfveggie(WebElement s) {
		String priceOfElement=s.findElement(By.xpath("following-sibling::td[1]")).getText();
		return priceOfElement;
	}

}
