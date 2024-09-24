package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.MyAccountPage;
import testBase.BaseClass;

public class Login extends BaseClass {


    @Test(groups = {"Sanity","Master"})
    public void loginToApp()
    {
        logger.info("********* Login testcase Started");
        try {

            HomePage hp = new HomePage(driver);
            hp.myAccountClick();
            logger.info("clicked on myaccount link on the home page..");

            hp.loginClick();
            logger.info("clicked on login link under myaccount..");

            LoginPage lp = new LoginPage(driver);
            lp.setEmailId(prop.getProperty("email"));
            lp.setPwd(prop.getProperty("password"));
            lp.clickOnLogin();
            logger.info("clicked on login button..");

            MyAccountPage myAcc = new MyAccountPage(driver);
            Boolean pageExist = myAcc.isMyAccountPageExists();
            Assert.assertEquals(pageExist, true, "Login failed");
        }
        catch (Exception e)
        {
            Assert.fail();
        }
        logger.info("***********Testcase Ended************");
    }
}
