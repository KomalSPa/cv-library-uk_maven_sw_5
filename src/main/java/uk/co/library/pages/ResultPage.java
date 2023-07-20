package uk.co.library.pages;

import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;
import uk.co.library.customlisteners.CustomListeners;
import uk.co.library.utility.Utility;

public class ResultPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//h1[@class='search-header__title']")
    WebElement resultText;

    public void verifyTheResults(String expected){
        verifyThatElementIsDisplayed(resultText);
        CustomListeners.test.log(Status.PASS, "Verify The Result" + expected);
        Reporter.log("Verify The Result" + resultText.toString());
    }
}
