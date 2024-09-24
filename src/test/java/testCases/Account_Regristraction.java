package testCases;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObject.HomePage;
import pageObject.RegisterPage;
import testBase.BaseClass;



public class Account_Regristraction extends BaseClass {


    @Test(groups = {"Regression","Master"})
    public void regristraction() {
        logger.info("******* Starting Account_Registraction Testcase ***********");
        logger.debug("This is a debug log message");
        try {

            HomePage hp = new HomePage(driver);

            logger.info("Clicking on My Account Link");
            hp.myAccountClick();

            logger.info("Clicking on Regristraction Link");
            hp.registerClick();

            RegisterPage rp = new RegisterPage(driver);

            logger.info("Entering all the deatils");
            rp.setFirstName(randomString());
            rp.setLastName(randomString());
            rp.setEmail(randomString() + "@gmail.com");
            rp.setPhoneNum(randomNumber());

            String pwd = randomAlpaNumaric();

            rp.setPassword(pwd);
            rp.setConfirmPwd(pwd);

            logger.info("Clicking on check box");
            rp.checkBox();
            rp.cta_button();

            logger.info("Validating expected message..");

            String confmsg = rp.getConfirmationmsg();
            Assert.assertEquals(confmsg, "Your Account Has Been Created!", "Confirmation message mismatch");

            logger.info("Test passed");
        } catch (Exception e) {
            logger.error("Test failed: " + e.getMessage());
            Assert.fail("Test failed: " + e.getMessage());
        } finally {
            logger.info("***** Finished AccountRegistrationTest *****");
        }
    }

}
