package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends  BasePage{

    public MyAccountPage(WebDriver driver)
    {
        super(driver);
    }

    //locators
    @FindBy(xpath = "//h2[normalize-space()='My Account']")
    WebElement myAccText;

    @FindBy(xpath = "//a[@class='list-group-item'][normalize-space()='Logout']")
    WebElement clickonLogout;

    //Action method
    public boolean isMyAccountPageExists()
    {
        try
        {
            return (myAccText.isDisplayed());
        }
        catch(Exception e)
        {
            return false;
        }

    }
    public void LogoutBtn()
    {
        clickonLogout.click();
    }
}
