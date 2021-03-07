package generic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Base_page {
		WebDriver driver;
		public Base_page(WebDriver driver)
		{
			this.driver=driver;
			PageFactory.initElements(driver, this);
		}
		public void verifyTitle(String title,int time)
		{
			WebDriverWait wait=new WebDriverWait(driver,time);
			try {
				wait.until(ExpectedConditions.titleContains(title));
				System.out.println("valid title");
			}
		catch(Exception e) {
			System.out.println("invalid title");
		}
		}
		public void verifyElement(WebElement element,int time)
		{
			WebDriverWait wait=new WebDriverWait(driver,time);
			try {
				wait.until(ExpectedConditions.visibilityOf(element));
				System.out.println("element visible");
			}
		catch(Exception e) {
			System.out.println("element not visible");
		}
		}
		public void verifyTab(int noOfWindow,int time)
		{
			WebDriverWait wait=new WebDriverWait(driver,time);
			try {
				wait.until(ExpectedConditions.numberOfWindowsToBe(noOfWindow));
				System.out.println("child tab present");
			}
		catch(Exception e) {
			System.out.println("child tab not present");
		}
		}
		public void mouseHover(WebElement element) {
			Actions act = new Actions(driver);
			act.moveToElement(element).perform();
		}
		public void rightClick(WebElement element) {
			Actions act = new Actions(driver);
			act.contextClick(element).perform();
		}
}
