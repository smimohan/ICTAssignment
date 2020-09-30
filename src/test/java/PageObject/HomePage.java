package PageObject;

import Commons.Driver;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

public class HomePage extends Driver {

    @FindBy(xpath = "//div[text()='Get Personalized Updates']")
    private WebElement getPersonalizedMessage;



    @FindBy(xpath ="//div[@class='col app']//h4")  //Footer 1
    private WebElement bookMyShowApp;
    @FindBy(xpath = "//div[@class='col news']//h4") //Footer 2
    private WebElement bookMyShowNews;
    @FindBy(xpath ="//div[@class='col help']//h4" ) //Footer 3
    private WebElement exclusives;
    @FindBy(xpath = "//div[@class='col exclusives']//h4") //Footer 4
    private WebElement help;
    @FindBy (xpath = "//a[@class='nav-link']")
    private WebElement clickLanguage;
    @FindBy(xpath = "//ul[@class='options']//li")
    private List<WebElement> languageList;
    @FindBy(xpath="//a[@class='location nav-link']")
    private WebElement cityList;
    @FindBy(xpath="//input[@id='inp_RegionSearch_top']")
    private WebElement citySearch;
    @FindBy(xpath="//span[@class='__region']")
    private WebElement cityName;
    @FindBy(id = "input-search-box")
    private WebElement movieSearchBox;
    @FindBy(id = "eventTitle")
    private WebElement ismoviepresent;

    @FindBy(xpath ="//div[@class='inner-nav right-nav']//li[3]//a" )
    private WebElement offersLink;

    @FindBy(xpath="//div[@class='inner-nav right-nav']//li[1]//a")
    private WebElement listYourShow;

    @FindBy(xpath ="//div[@class='inner-nav left-nav']/ul/li[7]")
    private WebElement fanhood;

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public boolean isPopUpWindowPresent() {
        try {
            return getPersonalizedMessage.isDisplayed();
        }
        catch (Exception e) {
            return false;
        }
    }

        public void enterMovieName(String movieName)  //For Test case 1,2,3,4
        {
        movieSearchBox.sendKeys(movieName);
        movieSearchBox.sendKeys(Keys.ENTER);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(ismoviepresent));
        Assert.assertTrue(ismoviepresent.isDisplayed());
        }

    public void clearField()
         {
        movieSearchBox.sendKeys(Keys.CONTROL, "a", Keys.BACK_SPACE);
        }

    public void clickFanhood() //For Test case 14&15
    {
        fanhood.click();
    }

    public void clickListYourShow()
    {
        listYourShow.click();
    }

    public boolean footerSections() //For testcase 11
    {
        bookMyShowApp.isDisplayed();
        bookMyShowNews.isDisplayed();
        exclusives.isDisplayed();
        help.isDisplayed();
        return true;
    }

    public void verifyLanguageList() {
        clickLanguage.click();
        int listOfLanguages = languageList.size();
        System.out.println(listOfLanguages);
        for (int i = 0; i <= 6;i++) {
            String LanguageList = languageList.get(i).getText();
            System.out.println(LanguageList);
        }
        }

            public void cityDisplay(String txt_city) throws InterruptedException {
            cityList.click();
            citySearch.sendKeys(txt_city);//locating element by using By reference and sending data
            citySearch.sendKeys(Keys.ENTER);
            WebDriverWait wait = new WebDriverWait(driver, 20); //element synchronization
            wait.until(ExpectedConditions.visibilityOf(cityName));
            String value = cityName.getText();
            System.out.println(value);
            String actualName = value.substring(0, 3);
            System.out.println(actualName);
            String expectedName = "Goa";
            Assert.assertEquals(actualName, expectedName);
            System.out.println("The actual name: " + actualName + " and " + " the expected name " + expectedName + " matches");
            }

            public void clickOffers(){
                offersLink.click();
            }

            }





