package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;


public class Singleton {
    private static WebDriver driver;

    public static WebDriver Driver() {

        String url =
                // ("https://store.steampowered.com/privacy_agreement/");
                ("https://store.steampowered.com/");

        if (driver == null) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            options.addArguments("lang=en-GB");
            options.addArguments("--incognito");
            DesiredCapabilities cap = new DesiredCapabilities();
            cap.setCapability(ChromeOptions.CAPABILITY, options);
            options.merge(cap);
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver(options);
            driver.manage().window().maximize();
            driver.get(url);
        }

        return driver;
    }

}

