package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

    //Constructor -- to initilize the driver
    public HomePage(WebDriver driver)
    {
        super(driver);
    }

    //Locators

    @FindBy(xpath="//a[@title='My Account']")
    WebElement myAccount;

    @FindBy(xpath="//a[normalize-space()='Register']")
    WebElement register_Link;

    @FindBy(xpath = "//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Login']")
    WebElement clickOnLogin;



    //Action Methods

    public void myAccountClick()
    {
        myAccount.click();
    }

    public void registerClick()
    {
        register_Link.click();
    }

    public void loginClick()
    {
        clickOnLogin.click();
    }


}
