package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends BasePage{

    //Constructor
    public RegisterPage(WebDriver driver)
    {
        super(driver);
    }

    //Locators
    @FindBy(xpath="//input[@id='input-firstname']")
    WebElement txt_FirstName;

    @FindBy(xpath="//input[@id='input-lastname']")
    WebElement txt_LastName;

    @FindBy(xpath="//input[@id='input-email']")
    WebElement txt_emailId;

    @FindBy(xpath="//input[@id='input-telephone']")
    WebElement txt_TelPhone;

    @FindBy(xpath = "//input[@id='input-password']")
    WebElement txt_password;

    @FindBy(xpath = "//input[@id='input-confirm']")
    WebElement txt_ConfirmPwd;

    @FindBy(xpath = "//input[@name='agree']")
    WebElement checkBox_Policy;

    @FindBy(xpath = "//input[@value='Continue']")
    WebElement btn_Continue;

    @FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
    WebElement msgConfirmation;

    //Action Methods

 public void setFirstName(String fname)
 {
     txt_FirstName.sendKeys(fname);
 }

 public void setLastName(String lname)
 {
        txt_LastName.sendKeys(lname);
 }

 public void setEmail(String email)
 {
        txt_emailId.sendKeys(email);
 }

 public void setPhoneNum(String PhNum)
 {
        txt_TelPhone.sendKeys(PhNum);
 }

 public void setPassword(String pwd)
 {
        txt_password.sendKeys(pwd);
 }

 public void setConfirmPwd(String confirmPwd)
 {
        txt_ConfirmPwd.sendKeys(confirmPwd);
 }

 public void checkBox()
 {
      checkBox_Policy.click();
 }

 public void cta_button()
 {
     btn_Continue.click();
 }

 public String getConfirmationmsg()
 {
     try {
         return (msgConfirmation.getText());
     }catch (Exception e)
     {
          return (e.getMessage());
     }
 }
}
