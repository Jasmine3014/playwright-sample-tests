package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Login_Page;

public class LoginTest extends BaseTest {

    @Test
    public void uiTest() {
        Login_Page loginPage = new Login_Page(page);
        loginPage.navigateToSampleApp();
        Assert.assertTrue(loginPage.isSampleHeadingDisplayed(),"Sample Heading is not Displayed");
        loginPage.fillUsername();
        loginPage.filPassword();
        loginPage.clickLoginBtn();
        Assert.assertTrue(loginPage.isSucesMsgDisplayed(),"Success Message is not Displayed");
    }
}
