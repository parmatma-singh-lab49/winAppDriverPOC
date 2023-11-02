import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.windows.WindowsDriver;

public class winAppDriverTest {

    public static WindowsDriver driver;

    @BeforeTest
    public void setup() throws MalformedURLException {
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("app", "Microsoft.WindowsCalculator_8wekyb3d8bbwe!App");
        // We can provide either the exe location or AMUID of the application(powershell >> get-StartApps)

        // Injecting the capability to the driver and winappdriver server
        driver = new WindowsDriver(new URL("http://127.0.0.1:4723/"), cap);
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void test() {
        System.out.println(driver.getTitle());
        driver.findElementByAccessibilityId("num3Button").click();
        driver.findElementByAccessibilityId("clearButton").click();
        driver.findElementByAccessibilityId("num3Button").click();
        driver.findElementByAccessibilityId("plusButton").click();
        driver.findElementByAccessibilityId("num2Button").click();
        driver.findElementByAccessibilityId("equalButton").click();
        Assert.assertEquals(driver.findElementByAccessibilityId("CalculatorResults").getText(), "Display is 5");
        System.out.println(driver.findElementByAccessibilityId("CalculatorExpression").getText());
        System.out.println(driver.findElementByAccessibilityId("CalculatorResults").getText());
        Assert.assertTrue(driver.findElementByAccessibilityId("CalculatorExpression").isDisplayed());
    }

}
