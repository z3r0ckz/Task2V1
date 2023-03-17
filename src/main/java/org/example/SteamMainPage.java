package org.example;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import static org.testng.AssertJUnit.assertEquals;


public class SteamMainPage {

    By header = By.xpath("//html/head/title");

    @FindBy(linkText = "Privacy Policy")
    WebElement privacyPolicyText;


    public SteamMainPage(WebDriver driver){
        PageFactory.initElements(Singleton.Driver(),this);
    }
    public String getHeader(){
        String getHeaderText;
        getHeaderText = Singleton.Driver().findElement(header).getText();


        return getHeaderText;
    }
    public void scrollAndPrivacyPolicy (){
        //wait the page to load
        //Implicit wait to load the page
        Singleton.Driver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //This will scroll the page till the element is found
        JavascriptExecutor js = (JavascriptExecutor) Singleton.Driver();
            js.executeScript("arguments[0].scrollIntoView();", privacyPolicyText);
        //Open Privacy Policy in a new tab

       // WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(String.valueOf(privacyPolicyText))));


        Actions action = new Actions(Singleton.Driver());
        action.keyDown(Keys.CONTROL).moveToElement((WebElement) privacyPolicyText).click().perform();
        ArrayList <String> tabs = new ArrayList<String>(Singleton.Driver().getWindowHandles());
       try{
           Singleton.Driver().switchTo().window(tabs.get(1));
        }
        catch (NoSuchWindowException e){
            System.out.println("No such windows exception Handle");
        }

        //Get header
        String getHeaderText = getHeader();
        System.out.println(getHeaderText);
        //assertEquals ("Privacy Policy Agreement",getHeaderText);


        }


    }

