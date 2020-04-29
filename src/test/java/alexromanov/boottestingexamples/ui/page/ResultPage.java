package alexromanov.boottestingexamples.ui.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ResultPage {
    private static final String PAGE_TITLE = "Conversion Result";

    @FindBy(id = "convertedResult")
    private WebElement conversionResult;

    @FindBy(id = "convert")
    private WebElement convertLink;

    private WebDriver driver;

    public ResultPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean getPageTitle() {
        return driver.getCurrentUrl().equals(PAGE_TITLE);
    }

    public String getConvertedValue() {
        return conversionResult.getText();
    }

    public MainPage navigateToConvertValue() {
        convertLink.click();
        return new MainPage(driver);
    }
}
