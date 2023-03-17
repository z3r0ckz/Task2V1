package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import java.util.ArrayList;
import java.util.List;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class SteamPrivacyPolicy {
   /* @FindBy(id = "language_pulldown")
    WebElement languagePulldownList;

    @FindBy(id = "languages")
    WebElement flags;
*/
   By languagePulldownList = By.id("language_pulldown");
    By flags = By.id("languages");

    By policyYear = By.xpath("//i[contains(text(), '2023')]");

    public SteamPrivacyPolicy(WebDriver driver){
        PageFactory.initElements(Singleton.Driver(), this);
    }
    public void switchLanguages(){
        //Language List is Displayed
        Singleton.Driver().findElement(languagePulldownList).click();
        assertTrue(Singleton.Driver().findElement(languagePulldownList).isDisplayed());
        System.out.println("Validate that the Language list is displayed");

        //Supported Languages
        List<String> languages = new ArrayList<>();
        languages.add("English");
        languages.add("Spanish");
        languages.add("French");
        languages.add("German");
        languages.add("Italian");
        languages.add("Russian");
        languages.add("Japanese");
        languages.add("Portuguese");
        languages.add("Brazilian");

        List <WebElement> flagsDisplayed = Singleton.Driver().findElements(flags);
        for(int i = 0; i<9; i++){
            flagsDisplayed.get(i).isDisplayed();
            assertTrue(Singleton.Driver().findElement(flags).isDisplayed());
            System.out.println("The language " + languages.get(i) + " is available");
        }


    }

    public void policyYear(){
        System.out.println("Test 3, Find the year of the Policy");

            String signedYear = Singleton.Driver().findElement(policyYear).getText();
            assertEquals("2023",signedYear);
        }
    }

