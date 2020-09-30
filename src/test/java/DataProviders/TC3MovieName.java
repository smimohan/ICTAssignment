package DataProviders;

import org.testng.annotations.DataProvider;

public class TC3MovieName {
    @DataProvider(name = "MovieName3")
    public static Object[][] dataProviderMovieName() {
        return new Object[][]{
                 {"Onward"}
        };
    }
}
