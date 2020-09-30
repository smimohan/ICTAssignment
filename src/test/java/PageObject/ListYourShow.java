package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.sql.SQLOutput;
import java.util.List;

import static org.openqa.selenium.By.className;
import static org.testng.Assert.assertTrue;

public class ListYourShow {

    @FindBy(className = "__txt")
    private List<WebElement> list;

    @FindBy(className = "__text")
    private List<WebElement> insights;

    @FindBy(xpath="//div[@class='super-container']/div[2]/div/div[3]/div[5]")
    private WebElement reportBizInsights;


    public ListYourShow(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void clickReports(){
        reportBizInsights.click();
    }

    public void verifyShows() {

        for (int i = 0; i <= 3; i++) {
            String bizInsights = list.get(i).getText();
            System.out.println(bizInsights);
        }


    }

    public void verifyServices() {

        for (int j = 7; j <= 12; j++) {
            String listOfServices = list.get(j).getText();
            System.out.println(listOfServices);
        }
    }

    public void reportBizInsights() {
        for (int m = 0; m <= 3; m++) {
            String listOfInsights = insights.get(m).getText();
            System.out.println(listOfInsights);


        }

    }
}

