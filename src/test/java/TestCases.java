import org.example.Singleton;
import org.example.SteamLoginPage;
import org.example.SteamMainPage;
import org.example.SteamPrivacyPolicy;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestCases {

    SteamMainPage objSteamMainPage;
    SteamLoginPage objSteamLoginPage;
    SteamPrivacyPolicy objSteamPrivacyPolicy;

    @BeforeTest
    public void setWebpage(){
        String url = "https://store.steampowered.com/";
        Singleton.Driver().get(url);
    }

      @Test (priority = 1)
   public void test1(){
       System.out.println("Test 1, scroll and click on privacy policy");
       objSteamMainPage = new SteamMainPage(Singleton.Driver());
       objSteamMainPage.scrollAndPrivacyPolicy();

   }

    @Test(priority = 2)
    public void testPrivacyPolicy(){
        System.out.println("Test 2, Language list displayed, and languages validation");
        objSteamPrivacyPolicy = new SteamPrivacyPolicy(Singleton.Driver());
        objSteamPrivacyPolicy.switchLanguages();
    }

    @Test(priority = 3)
    public void privacyPolicyYear(){
        System.out.println("Test 3, validation year of the Privacy Policy");
        objSteamPrivacyPolicy = new SteamPrivacyPolicy(Singleton.Driver());
        objSteamPrivacyPolicy.policyYear();

    }
    @AfterTest
    public void terminateBrowser(){
        //driver.close();
    }
}
