package PageObject;

import Commons.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Fanhood {

    //For Test Case_14->Products->Bags->LunchBags
    @FindBy(xpath = "//div[@class='container']/ul/li[2]")
    private WebElement products;
    @FindBy(xpath = "//div[@class='mega-menu__inner ']//div[8]//ul//li[2]")
    private WebElement lunchBags;

    //For Test Case_15-Products->Books->Planners

    @FindBy(xpath = "//div[@class='mega-menu__inner ']//div[3]//ul//li[6]")
    private WebElement planners;

    public Fanhood(WebDriver driver) { PageFactory.initElements(driver, this);}

      public void goToProducts()
    {
        products.click();
        lunchBags.click();
    }

    public void goToProductsBooks()
    {
        products.click();
        planners.click();
    }


    }






