package UdemyCourse;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsClassDemo {

	public static void main(String[] args) {
		System.setProperty("Webdriver.chrome.setup", "C:\\Users\\abhay\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.amazon.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		Actions a=new Actions(driver); 
		WebElement signInmove =driver.findElement(By.cssSelector("a[id=nav-link-accountList]"));
		a.moveToElement(signInmove).build().perform();
		WebElement searchBox=driver.findElement(By.id("twotabsearchtextbox"));
		a.moveToElement(searchBox).click().keyDown(Keys.SHIFT).sendKeys("hello").doubleClick().
		build().perform();
		a.moveToElement(signInmove).contextClick().build().perform();
		

	}

}
