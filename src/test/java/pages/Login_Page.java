package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import io.qameta.allure.Step;


import java.util.UUID;

public class Login_Page {
    Page page;

    private Locator sampleApp;
    private Locator sampleAppHeading;
    private Locator userName;
    private Locator password;
    private Locator loginBtn;
    private Locator successMsg;
    private final String randomText = UUID.randomUUID().toString();
    private final String passwordGiven = "pwd";

    public Login_Page(Page page) {
        this.page = page;
        this.sampleApp = page.locator("//a[contains (@href, '/sampleapp')]");
        this.sampleAppHeading = page.locator("//h3[contains(text(),'Sample App')]");
        this.userName = page.locator("//input[@type ='text']");
        this.password = page.locator("//input[@type ='password']");
        this.loginBtn = page.locator("#login");
        this.successMsg = page.locator("#loginstatus");
    }

    @Step("Clicking Sample app")
    public void navigateToSampleApp() {
        sampleApp.click();
    }

    @Step("The header is displayed")
    public boolean isSampleHeadingDisplayed() {
        sampleAppHeading.waitFor(new Locator.WaitForOptions().setTimeout(2000));
        return sampleAppHeading.isVisible();
    }

    @Step("Enter Usename")
    public void fillUsername() {
        userName.fill(randomText);
    }

    @Step("Enter Password")
    public void filPassword() {
        userName.fill(passwordGiven);
    }

    @Step("Clicking Login Button")
    public void clickLoginBtn() {
        loginBtn.click();
    }

    @Step("Sucess message is displayed")
    public boolean isSucesMsgDisplayed() {
        return successMsg.isVisible();
    }


}
