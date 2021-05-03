package alexromanov.boottestingexamples.ui;

import alexromanov.boottestingexamples.ui.page.MainPage;
import alexromanov.boottestingexamples.ui.page.ResultPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class WebDriverUiTest {
    private static final String BASE_URL = "http://127.0.0.1";

    @LocalServerPort
    private int port;

    private WebDriver driver;

    @BeforeClass
    public static void beforeAll() {
        WebDriverManager.chromedriver().setup();
    }

    @Before
    public void beforeTest() {
        driver = new ChromeDriver();
        driver.get(BASE_URL + ":" + port);
    }

    @After
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void shouldNotConvertEmptyValue() {
        MainPage mainPage = new MainPage(driver);
        mainPage.fillValue("");
        mainPage.submitValue();
        assertThat(mainPage.getErrorMessage())
                .isEqualTo("Value should not be empty and should be in decimal format");
    }

    @Test
    public void shouldConvertValue() {
        MainPage mainPage = new MainPage(driver);
        assertThat(mainPage.getPageTitle()).as("Page Title is not equal to expected")
                                           .isEqualTo(driver.getTitle());
        ResultPage resultPage = mainPage.convertValue("1600");
        assertThat(resultPage.getConvertedValue()).contains("1 600.00");
    }

    @Test
    public void shouldResetEnteredValue() {
        MainPage mainPage = new MainPage(driver);
        mainPage.fillValue("122");
        mainPage.resetValue();
        assertThat(mainPage.getCurrentEnteredValue())
                .isEqualTo("");
    }
}
