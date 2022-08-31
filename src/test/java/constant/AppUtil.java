package constant;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class AppUtil {
public static WebDriver driver;
public static Properties config;
@BeforeSuite
public static void setUp() throws Throwable
{
	config = new Properties();
	config.load(new FileInputStream("E:\\EveningBatch530\\Maven_Project\\PropertyFiles\\Environment.properties"));
	if(config.getProperty("Browser").equalsIgnoreCase("Chrome"))
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(config.getProperty("Url"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			}
	else if(config.getProperty("Browser").equalsIgnoreCase("Firefox"))
	{
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get(config.getProperty("Url"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	else
	{
		System.out.println("Browser value is not matching");
	}
	}
@AfterSuite
public static void tearDown()
{
	driver.close();
	}
}
