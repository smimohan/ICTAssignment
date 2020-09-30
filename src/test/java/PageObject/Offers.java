package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class Offers {
    @FindBy(xpath = "//div[@class='offer-list-page']//section[2]//aside[1]")
    private WebElement ICICIOffer;
    @FindBy(xpath="//input[@class='__seach-input typeahead tt-input']")
    private WebElement offersSearchBox;


    @FindBy (xpath="//h4[text()='Reward Points Redemption']")
    private WebElement reward1;
    @FindBy (xpath="//h4[text()='PAYBACK POINTS']")
    private WebElement reward2;
    @FindBy (xpath="//h4[text()='SimplyCLICK SBI Card Rewards Offer']")
    private WebElement reward3;

    public Offers(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void verifyDisplayOfOffer(String offer) throws InterruptedException
        {
        offersSearchBox.sendKeys(offer);
        offersSearchBox.sendKeys(Keys.ENTER);
        Assert.assertTrue(ICICIOffer.isDisplayed());
          }


   public void verifyRewardPoints()
   {
       Assert.assertTrue(reward1.isDisplayed(), "Reward Points Redemption is present");
       Assert.assertTrue(reward2.isDisplayed(), "PAYBACK POINTS is present");
       Assert.assertTrue(reward3.isDisplayed(), "SimplyCLICK SBI Card Rewards Offer is present");
   }
}



