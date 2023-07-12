package factory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;

public class iOSDriverFactory {
    public static AppiumDriver initializeIOSDriver() throws MalformedURLException, URISyntaxException {
        AppiumDriver driver;
        DesiredCapabilities caps = new DesiredCapabilities();
        URI uriServer = new URI("http://localhost:4723/wd/hub");

        caps.setCapability("platformName", "iOS");
        caps.setCapability("automationName", "XCUITest");
        caps.setCapability("platformVersion", "16.0");
        caps.setCapability("maxInstances", "1");
        caps.setCapability("appiumVersion", "1.22.3");
        caps.setCapability("deviceName", "iPhone 14");
        caps.setCapability("bundleId", "com.manaty.mafao");
        //caps.setCapability("app", IOS_APP_PATH);
        return new IOSDriver(uriServer.toURL(), caps);
    }


    public static AppiumDriver initializeIOSRealDevice() throws MalformedURLException, URISyntaxException {
        AppiumDriver driver;
        DesiredCapabilities caps = new DesiredCapabilities();
        URI uriServer = new URI("http://localhost:4723/wd/hub");

        caps.setCapability("platformName", "iOS");
        caps.setCapability("automationName", "XCUITest");
        caps.setCapability("platformVersion", "16.3.1");
        caps.setCapability("deviceName", "iPhone de Sol");
        caps.setCapability("udid","YOUR UDID");
        caps.setCapability("xcodeOrgId","YOUR ACCOUNT");
        caps.setCapability("xcodeSigningId", "iPhone Developer");
        caps.setCapability("useNewWDA",true);
        caps.setCapability("derivedDataPath","your DerivedDataPath");
        caps.setCapability("app", System.getProperty("user.dir") + "/apps/UIKitCatalog-ios.zip");

        return new IOSDriver(uriServer.toURL(), caps);
    }


}