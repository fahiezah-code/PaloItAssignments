package factory;

import constant.DriverType;

public class DriverManagerFactory {

    public static DriverManager getDriver(DriverType browser) {

        switch (browser) {

            case CHROME:
                return new ChromeDriverManager();
            case FIREFOX:
                return new FirefoxDriverManager();

            default:
                throw new IllegalStateException("Unexpected browser : " + browser);

        }
    }
}
