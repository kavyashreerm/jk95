package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


import generic.Base_page;

public class Enter_Time_Track_Page extends Base_page {
		@FindBy(id="logoutLink")
		private WebElement logout;
		@FindBy(xpath="(//div[@class='popup_menu_arrow'])[3]")
		private WebElement help;
		@FindBy(xpath="//a[contains(text(),'About actiTIME')]")
		private WebElement aboutActiTIME;
		@FindBy(className = "//span[@class='productVersion']")
		private WebElement aVersion;
		@FindBy(xpath = "//td[@class='close-button']//img")
		private WebElement close;
		public Enter_Time_Track_Page(WebDriver driver) {
			super(driver);
		}
		public void clickHelp()
		{
			help.click();
		}
		public void clickAboutActitime() {
			aboutActiTIME.click();
		}
		public String getActitimeVersion()
		{
			return aVersion.getText();		
		}
		public void clickClose()
		{
			close.click();
			
		}
		public void clickLogout()
		{
			logout.click();
			
		}
		
		
}
