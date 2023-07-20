package uk.co.library.pages;


import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import uk.co.library.customlisteners.CustomListeners;
import uk.co.library.utility.Utility;

/**
 * Created by Jay Vaghani
 */
public class HomePage extends Utility {


    // jobTitle
    @CacheLookup
    @FindBy(xpath = "//input[@id='keywords']")
    WebElement jobTitlexp;

    //location
    @CacheLookup
    @FindBy(xpath = "//input[@id='location']")
    WebElement locationxp;

    // distanceDropDown
    @CacheLookup
    @FindBy(xpath = "//select[@id='distance']")
    WebElement distanceDropDownxp;

    // moreSearchOptionsLink
    @CacheLookup
    @FindBy(xpath = "//button[@id='toggle-hp-search']")
    WebElement moreSearchOptionsLinkxp;

    // salaryMin
    @CacheLookup
    @FindBy(xpath = "//input[@id='salarymin']")
    WebElement salaryMin;

    // salaryMax
    @CacheLookup
    @FindBy(xpath = "//input[@id='salarymax']")
    WebElement salaryMax;

    // salaryTypeDropDown
    @CacheLookup
    @FindBy(xpath = "//select[@id='salarytype']")
    WebElement salaryTypeDropDown;

    // jobTypeDropDown
    @CacheLookup
    @FindBy(xpath = "//select[@id='tempperm']")
    WebElement jobTypeDropDown;

    // findJobsBtn
    @CacheLookup
    @FindBy(xpath = "//input[@id='hp-search-btn']")
    WebElement findJobsBtn;

    @CacheLookup
    @FindBy(id = "gdpr-consent-notice")
    WebElement iframe;

    @CacheLookup
    @FindBy(xpath = "//span//div//span[normalize-space()='Accept All']")
    WebElement acceptCookies;

    public void enterJobTitle(String jobTitle) {
        sendTextToElement(jobTitlexp, jobTitle);
        CustomListeners.test.log(Status.PASS, "Enter job Title" + jobTitle);
        Reporter.log("Enter Job Title" + jobTitlexp.toString());
    }
    public void enterLocation(String location){
        sendTextToElement(locationxp, location);
        CustomListeners.test.log(Status.PASS, "Enter Location" + location);
        Reporter.log("Enter Location" + locationxp.toString());
    }

    public void selectDistance(String distance){
        selectByVisibleTextFromDropDown(distanceDropDownxp, distance);
        CustomListeners.test.log(Status.PASS, "Select Distance" + distance);
        Reporter.log("Select Distance" + distanceDropDownxp.toString());
    }
    public void clickOnMoreSearchOptionLink(){
        clickOnElement(moreSearchOptionsLinkxp);
        CustomListeners.test.log(Status.PASS, "Click On Search Option");
        Reporter.log("Click On Search Option" + moreSearchOptionsLinkxp.toString());
    }
    public void enterMinSalary(String minSalary){
        sendTextToElement(salaryMin, minSalary);
        CustomListeners.test.log(Status.PASS, "Enter Min Salary" + minSalary);
        Reporter.log("Enter Min Salary" + salaryMin.toString());
    }
    public void enterMaxSalary(String maxSalary){
        sendTextToElement(salaryMax, maxSalary);
        CustomListeners.test.log(Status.PASS, "Enter Max Salary" + maxSalary);
        Reporter.log("Enter Max Salary" + salaryMax.toString());
    }
    public void selectSalaryType(String sType){
        selectByVisibleTextFromDropDown(salaryTypeDropDown, sType);
        CustomListeners.test.log(Status.PASS, "Selery Type" + sType);
        Reporter.log("Selery Type" + salaryTypeDropDown.toString());
    }
    public void selectJobType(String jobType){
        selectByValueFromDropDown(jobTypeDropDown, jobType);
        CustomListeners.test.log(Status.PASS, "Select Job Type" + jobType);
        Reporter.log("Select Job Type" + jobTypeDropDown.toString());
    }
    public void clickOnFindJobsButton(){
        clickOnElement(findJobsBtn);
        CustomListeners.test.log(Status.PASS, "Click On Find Jobs Button" + findJobsBtn);
        Reporter.log("Click On Find Jobs Button" + findJobsBtn.toString());
    }
    public void setAcceptCookies() {

         driver.switchTo().frame(iframe);
        //switchToIframe(iframe);
        System.out.println("we are switching to iFrame");
        clickOnElement(acceptCookies);//click on Acceptall
        System.out.println("We are done with iFrame");

        driver.switchTo().defaultContent();//switch to default window
    }
}
