import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.UUID;

public class UiTest extends BaseTest{
    private final String sampleAppBtnSelector = "//a[contains (@href, '/sampleapp')]";
    private final String sampleAppHeadingSelector = "//h3[contains(text(),'Sample App')]";
    private final String userNameSelector = "//input[@type ='text']";
    private final String passwordSelector = "//input[@type ='password']";
    private final String loginBtnSelector = "#login";
    private final String successMsgSelector = "#loginstatus";
    private final String randomText = UUID.randomUUID().toString();
    private final String passwordGiven = "pwd";

    @Test
    public void uiTest() {
        page.click(sampleAppBtnSelector);
        page.waitForSelector(sampleAppHeadingSelector);
        Assert.assertTrue(page.isVisible(sampleAppHeadingSelector),
                "Sample Page is not displayed"
        );
        page.fill(userNameSelector, randomText);
        page.fill(passwordSelector, passwordGiven);
        page.click(loginBtnSelector);
        Assert.assertTrue(page.isVisible(successMsgSelector),
                "Success message is not displayed"
        );
    }

}
