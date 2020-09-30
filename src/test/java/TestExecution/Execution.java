package TestExecution;

import Commons.Driver;
import DataProviders.*;
import PageObject.*;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Execution extends Driver {


    @Test public void a_isPopUpWindowPresent() throws IOException {

       // extentTest = reports.createTest("Test case to verify the pop-up");
        HomePage homePage = new HomePage(driver);
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.elementToBeClickable(By.id("inp_RegionSearch_top")));
        driver.findElement(By.id("inp_RegionSearch_top")).sendKeys("Kochi"); //entering the value
        driver.findElement(By.id("inp_RegionSearch_top")).sendKeys(Keys.ENTER); //ENTER keyboard action
        driver.manage().timeouts().implicitlyWait(15000, TimeUnit.MILLISECONDS);


        boolean respondToPopUp = homePage.isPopUpWindowPresent();
        if (respondToPopUp) {
            driver.findElement(By.id("wzrk-cancel")).click();
        } else {
            driver.findElement((By.id("wzrk-confirm"))).click();
        }

    }
            //verify that there is a movie called "Fantasy Island"
        @Test(priority = 1,dataProvider = "MovieName", dataProviderClass = TC1MovieName.class,
               dependsOnMethods = {"a_isPopUpWindowPresent"})

            public void b_TC1PositiveMovieScenario(String movie) throws Exception
            {
            HomePage homePage1 = new HomePage(driver);
            homePage1.enterMovieName(movie);
            }

            //verify that there is no movie called "q"
      @Test(priority = 2,dataProvider = "MovieName2", dataProviderClass = TC2MovieName.class,
              dependsOnMethods = {"a_isPopUpWindowPresent", "b_TC1PositiveMovieScenario"})
            public void c_TC2NegativeMovieScenario(String movie2) throws Exception
            {
            HomePage homePage2 = new HomePage(driver);
            homePage2.enterMovieName(movie2);
            homePage2.clearField();
              }

              //verify Tom Holland is in the Onward cast and Mychael Danna is the musician
     @Test(priority = 3,dataProvider = "MovieName3", dataProviderClass = TC3MovieName.class,
             dependsOnMethods = {"a_isPopUpWindowPresent", "c_TC2NegativeMovieScenario"})

           public void c_TC3VerifyActorInCast(String movie3) throws IOException
            {
            HomePage homePage3 = new HomePage(driver);
            homePage3.enterMovieName(movie3);
            OnwardMovie onwardMovie = new OnwardMovie(driver);
            onwardMovie.verifyActor();
             }

        // verify 'Tom Cruise' is not in the cast and Michael Jackson is not the musician in the web page)*/
     @Test(priority = 4,dataProvider = "MovieName3", dataProviderClass = TC3MovieName.class,
             dependsOnMethods = {"a_isPopUpWindowPresent", "c_TC3VerifyActorInCast"})

            public void d_TC4IsTextPresentInWebpage(String movie4) throws IOException
            {
            HomePage homePage4= new HomePage(driver);
            homePage4.enterMovieName(movie4);
            OnwardMovie onwardMovie = new OnwardMovie(driver);
            String expText = "Tom Cruise";
            String expText1 = "Michael Jackson";
            String pageSource = driver.getPageSource();
            Assert.assertFalse(pageSource.contains(expText)); //assert
            Assert.assertFalse(pageSource.contains(expText1));
            }

        //To check The host session under List My Show
     @Test(priority =5,dependsOnMethods = {"a_isPopUpWindowPresent"})
            public void e_TC5AreTheShowsPresent()
            {
                HomePage homepage5=new HomePage(driver);
                homepage5.clickListYourShow();
                ListYourShow ls = new ListYourShow(driver);
                ls.verifyShows();

            }

    //To check services under List My Show are displayed
      @Test(priority = 6,dependsOnMethods = {"a_isPopUpWindowPresent"})
            public void f_TC6AreTheServicesPresent()
           {
            HomePage homepage6=new HomePage(driver);
            homepage6.clickListYourShow();
            ListYourShow ls1 = new ListYourShow(driver);
            ls1.verifyServices();
            }

    //To check if Insights inside Reports and Business Location are displayed
     @Test(priority = 7,dependsOnMethods = {"a_isPopUpWindowPresent"})
            public void g_TC7_ReportServices()
            {
            HomePage homepage7=new HomePage(driver);
            homepage7.clickListYourShow();
            ListYourShow rs = new ListYourShow(driver);
            rs.clickReports();
            rs.reportBizInsights();
            }

      @Test(priority = 8,dataProvider = "OfferName", dataProviderClass = TC9BankOffer.class,
                        dependsOnMethods = {"a_isPopUpWindowPresent"})
            public void h_TC8_Offers(String offerDisplay) throws InterruptedException {
             HomePage homepage8 = new HomePage(driver);
             homepage8.clickOffers();
             Offers of = new Offers(driver);
             of.verifyDisplayOfOffer(offerDisplay);
             System.out.println("The ICICI Offer is displayed ");
            }

     @Test(priority = 9,dependsOnMethods = {"a_isPopUpWindowPresent"})

            public void i_TC9_OffersNoKotak()
            {
            driver.findElement(By.xpath("//div[@class='inner-nav right-nav']//li[3]//a")).click();
            Offers ofKotak = new Offers(driver);
            String expText = "Kotak Mahindra";
            String pageSource = driver.getPageSource();
            if (pageSource.contains(expText))
            {
             System.out.println("Kotak Mahindra is shown.");
            }
            else {
             System.out.println("Kotak Mahindra is not shown.");
            }
            }
           //Verification of display of rewards
      @Test(priority = 10,dependsOnMethods = {"a_isPopUpWindowPresent"})
            public void j_TC10_OfferRewards() {
            driver.findElement(By.xpath("//div[@class='inner-nav right-nav']//li[3]//a")).click();
            Offers verRewards = new Offers(driver);
            driver.findElement(By.xpath("//div[@class='offer-list-page']//section//ul//li[4]")).click();
            verRewards.verifyRewardPoints();}

            //Verification of presence of Footer
       @Test(priority = 11,dependsOnMethods = {"a_isPopUpWindowPresent"})
            public void k_TC11_Footer()
            {
            HomePage homePage5 = new HomePage(driver);
            Assert.assertTrue(homePage5.footerSections());
           }

           //Display of Languages
     @Test(priority = 12, dependsOnMethods = {"a_isPopUpWindowPresent"})
            public void l_TC12_VerifyLanguageList() throws IOException
             {
              HomePage homePage6 = new HomePage(driver);
              homePage6.verifyLanguageList();
             }

             //Display of City Goa
     @Test(priority = 13,dataProvider = "CityName", dataProviderClass = City_DP.class,
             dependsOnMethods = {"a_isPopUpWindowPresent"})

            public void m_TC13CityEntry(String cityName) throws InterruptedException
            {
             HomePage homepage7 = new HomePage(driver);
             homepage7.cityDisplay(cityName);
            }

            //Verification of sorted Lunch Bags
      @Test(priority = 14,dependsOnMethods = {"a_isPopUpWindowPresent"})
            public void n_TC14FanHoodPage()
            {
            HomePage hp5=new HomePage(driver);
            hp5.clickFanhood();
            Fanhood fanhood1=new Fanhood(driver);
            String URL = driver.getCurrentUrl();
            Assert.assertEquals(URL, "https://fanhood.bookmyshow.com/" );
            LunchBags lunchBags = new LunchBags(driver);
            fanhood1.goToProducts();
            lunchBags.filterByAlphabeticalOrder();
            lunchBags.obtainedOrder();
            lunchBags.sortedList();
            Assert.assertNotSame(lunchBags.sortedList(), lunchBags.obtainedOrder());
            Driver.closebrowser();
            }

            //Verification of filtered Planners
      @Test(priority = 15,dependsOnMethods = {"a_isPopUpWindowPresent"})
            public void p_TC15_FanHoodPageBooks() throws InterruptedException
            {
            HomePage hp6=new HomePage(driver);
            hp6.clickFanhood();
            driver.findElement(By.xpath("//div[@class='inner-nav left-nav']/ul/li[7]")).click();
            Fanhood fanhood2 = new Fanhood(driver);
            String URL = driver.getCurrentUrl();
            System.out.println(URL);
            Assert.assertEquals(URL, "https://fanhood.bookmyshow.com/");
            Planner planner = new Planner(driver);
            fanhood2.goToProductsBooks();
            planner.verifyPriceIsDisplayed();
            planner.clickFilter();
            planner.verifyFilteredDisplay();

      }

    }








