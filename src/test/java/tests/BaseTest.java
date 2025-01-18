package tests;

import com.microsoft.playwright.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.List;

public class BaseTest {
    protected Playwright playwright;
    protected Browser browser;
    protected BrowserContext context;
    protected Page page;
    protected static final String URL = "http://www.uitestingplayground.com/";


    @BeforeMethod
    public void setup() {
        playwright = Playwright.create();
        page = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false)
                .setArgs(List.of("--start-maximized")))
                .newContext(new Browser.NewContextOptions().setViewportSize(null)).newPage();
        page.navigate(URL);
    }

    @AfterMethod
    public void teardown() {
        page.close();
        playwright.close();
    }
}
