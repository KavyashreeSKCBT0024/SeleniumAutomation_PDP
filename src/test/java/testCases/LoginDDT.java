package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

/*Data is valid  - login success - test pass  - logout
Data is valid -- login failed - test fail

Data is invalid - login success - test fail  - logout
Data is invalid -- login failed - test pass
*/

public class LoginDDT extends BaseClass {

    @Test(dataProvider ="LoginData",dataProviderClass= DataProviders.class,groups = "DataDriven")
    public void verify_loginDDT(String email,String password,String exp)
    {
        logger.info("**** Starting TC_003_LoginDDT *****");

        try {

            HomePage hp = new HomePage(driver);
            hp.myAccountClick();
            logger.info("clicked on myaccount link on the home page..");

            hp.loginClick();
            logger.info("clicked on login link under myaccount..");

            LoginPage lp = new LoginPage(driver);
            lp.setEmailId(email);
            lp.setPwd(password);
            lp.clickOnLogin();
            logger.info("clicked on login button..");

            MyAccountPage myAcc = new MyAccountPage(driver);
            Boolean pageExist = myAcc.isMyAccountPageExists();

            if(exp.equalsIgnoreCase("valid"))
            {
                if(pageExist==true)
                {
                    myAcc.LogoutBtn();
                    Assert.assertTrue(true);
                }
                else
                {
                    Assert.assertTrue(false);
                }
            }

            if(exp.equalsIgnoreCase("Invalid"))
            {
                if (pageExist==true)
                {
                    myAcc.LogoutBtn();
                    Assert.assertTrue(false);
                }
                else
                {
                    Assert.assertTrue(true);
                }
            }

        }
        catch (Exception e)
        {
            Assert.fail("An exception occurred: " + e.getMessage());
        }

        logger.info("**** Finished TC_003_LoginDDT *****");
    }

}
