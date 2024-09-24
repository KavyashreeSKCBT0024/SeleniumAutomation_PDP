package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

    public LoginPage(WebDriver driver)
    {
        super(driver);
    }

    //locators
    @FindBy(xpath = "//input[@id='input-email']")
    WebElement emailAdd;

    @FindBy(xpath = "//input[@id='input-password']")
    WebElement pwd;

    @FindBy(xpath = "//input[@value='Login']")
    WebElement loginBtn;

    //action methods
    public void setEmailId(String email)
    {
        emailAdd.sendKeys(email);
    }
    public void setPwd(String password)
    {
        pwd.sendKeys(password);
    }
    public void clickOnLogin()
    {
        loginBtn.click();
    }
}
