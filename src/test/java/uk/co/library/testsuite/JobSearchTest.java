package uk.co.library.testsuite;


import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import resources.testdata.TestData;
import uk.co.library.customlisteners.CustomListeners;
import uk.co.library.pages.HomePage;
import uk.co.library.pages.ResultPage;
import uk.co.library.testbase.BaseTest;

/**
 * Created by Jay Vaghani
 */
@Listeners(CustomListeners.class)
public class JobSearchTest extends BaseTest {
    HomePage homePage;
    ResultPage resultPage;
    @BeforeMethod
    public void inIt(){
        homePage = new HomePage();
        resultPage = new ResultPage();
    }
    @Test(groups = {"smoke"}, dataProvider = "criteria", dataProviderClass = TestData.class)
    public void verifyJobSearchResultUsingDifferentDataSet(String jobTitle, String location, String distance, String salaryMin, String salaryMax, String salaryType, String jobType,
                                                           String result){
//        homePage.enterJobTitle("Tester");
//        homePage.enterLocation("Harrow on the Hill");
//        homePage.selectDistance("5 miles");
//        homePage.clickOnMoreSearchOptionLink();
//        homePage.enterMinSalary("30000");
//        homePage.enterMaxSalary("500000");
//        homePage.selectSalaryType("Per annum");
//        homePage.selectJobType("Permanent");
//        homePage.clickOnFindJobsButton();
//        resultPage.verifyTheResults("Permanent Tester jobs in Harrow on the Hill");
        //homePage.setAcceptCookies();
        homePage.enterJobTitle(jobTitle);
        homePage.enterLocation(location);
        homePage.selectDistance(distance);
        homePage.clickOnMoreSearchOptionLink();
        homePage.enterMinSalary(salaryMin);
        homePage.enterMaxSalary(salaryMax);
        homePage.selectSalaryType(salaryType);
        homePage.selectJobType(jobType);
        homePage.clickOnFindJobsButton();
        resultPage.verifyTheResults(result);

    }
}
