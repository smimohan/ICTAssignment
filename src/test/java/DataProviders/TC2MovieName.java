package DataProviders;

import org.testng.annotations.DataProvider;

public class TC2MovieName {
    @DataProvider(name = "MovieName2")
    public static Object[][] dataProviderMovieName() {
        return new Object[][]{
                  {" qq "}
        };
    }
}

