package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import generic.Base_page;

public class Login_Page extends Base_page {
@FindBy(id="username")
private WebElement unameTxtField;
@FindBy(name="pwd")
private WebElement pwdTextField;
@FindBy(xpath ="//div[.='Login']")
private WebElement login;
@FindBy(className = "errormsg")
private WebElement errMessage;
public Login_Page(WebDriver driver) {
super(driver);
}
public void setUsername(String uname)
{
	unameTxtField.sendKeys(uname);
}
public void setPassword(String pwd)
{
	pwdTextField.sendKeys(pwd);
}
public void clickLogin()
{
	login.click();
}
public void verifyErrorMessage()
{
	verifyElement(errMessage,5);
}
}
