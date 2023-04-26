package stream;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FindPriceOfOneElement {

	public static void main(String[] args) throws InterruptedException{
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		// TODO Auto-generated method stub
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("tr th:nth-child(1)")).click();
		List<WebElement> elements= driver.findElements(By.cssSelector("tr td:nth-child(1)"));
		List<String>priceOfElement=elements.stream().filter(s->s.getText().contains("Beans")).
				map(s->getVeggiePrice(s)).collect(Collectors.toList());
		priceOfElement.stream().forEach(s->System.out.println(s));
	}

	private static String getVeggiePrice(WebElement s) {
		String price=s.findElement(By.xpath("following-sibling::td[1]")).getText();
		return price;
	}

}
