package SelenniumFramework.TestComponent;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import SelenniumFramework.PageObjectModel.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	public WebDriver driver;
	public LoginPage loginPage;
	public WebDriver initializeDriver() throws IOException 
	
	{
		FileInputStream fis=new FileInputStream("D:\\Training\\EclipseProject\\PageObjectModel\\src\\main\\java\\SelenniumFramework\\Resources\\GlobalData.properties");
		Properties prop=new Properties();
		prop.load(fis);
		String browserName=prop.getProperty("browser");
		if(browserName.equalsIgnoreCase("chrome")) {
		 ChromeOptions options = new ChromeOptions();
		 options.addArguments("--remote-allow-origins=*");
		 WebDriverManager.chromedriver().setup();
		 driver=new ChromeDriver(options);
		 
		}
		else if(browserName.equalsIgnoreCase("firefox")) 
		{
			FirefoxOptions options = new FirefoxOptions();
			options.addArguments("--remote-allow-origins=*");
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver(options);
		}
		else if(browserName.equalsIgnoreCase("Edge")) 
		{
			EdgeOptions options = new EdgeOptions();
			options.addArguments("--remote-allow-origins=*");
			WebDriverManager.edgedriver().setup();
			 driver=new EdgeDriver(options);
		}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		return driver;	 

	}
	@BeforeMethod(alwaysRun=true)
	public LoginPage launchApplication() throws IOException 
	{
		driver=initializeDriver();
		loginPage=new LoginPage(driver);
		loginPage.gotoLoginPage();
		return loginPage;
	}
	@AfterMethod(alwaysRun=true)
	public void tearDown() 
	{
		driver.close();
	}
	 public String getScreenShot(String testCaseName,WebDriver driver) throws IOException 
	 {
		 TakesScreenshot ts =(TakesScreenshot)driver;
		 File source=ts.getScreenshotAs(OutputType.FILE);
		 File destination =new File(System.getProperty("user.dir")+"\\reports"+testCaseName+".png");
		 FileUtils.copyFile(source,destination);
		 return System.getProperty("user.dir")+"\\reports"+testCaseName+".png";
	 }
}
