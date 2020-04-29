package alexromanov.boottestingexamples.ui.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {
    private final WebDriver driver;
    private static final String PAGE_TITLE = "Convert Money";
    @FindBy(id = "inputValueForConversion")
    private WebElement conversionInput;
    @FindBy(id = "submit")
    private WebElement submitButton;
    @FindBy(id = "reset")
    private WebElement resetButton;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getPageTitle() {
        return PAGE_TITLE;
    }

    public String getErrorMessage() {
        return driver.findElement(By.id("errorMessage")).getText();
    }

    public String getCurrentEnteredValue() {
        return conversionInput.getText();
    }

    public ResultPage convertValue(String value) {
        conversionInput.sendKeys(value);
        submitButton.click();
        return new ResultPage(driver);
    }

    public MainPage fillValue(String value) {
        conversionInput.sendKeys(value);
        return this;
    }

    public MainPage submitValue() {
        submitButton.click();
        return this;
    }

    public MainPage resetValue() {
        resetButton.click();
        return this;
    }
}
