package generic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class generic_test  implements Auto_const {

	FileManager fm=new FileManager();
	public WebDriver driver;
	
	@Parameters({"browser"})
	@BeforeMethod
	public void openApplication(@Optional("chrome")String browser) {
		if(browser.equals("chrome"))
		{
		System.setProperty(chrome_key, chrome_value);
		driver=new ChromeDriver();
		driver.get(fm.getQATUrl());
		}else if(browser.equals("firefox"))
		{
			System.setProperty(gecko_key, gecko_value);
			driver=new FirefoxDriver();
			driver.get(fm.getQATUrl());
			
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(fm.getImplicitlyWait(), TimeUnit.SECONDS);
		
	}

	@AfterMethod
	public void closeAppn() {
		driver.quit();
	}
}
