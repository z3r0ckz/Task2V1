package org.example;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.io.FileReader;
import java.io.IOException;

public class SteamGamePage {

    public SteamGamePage(WebDriver driver){
        PageFactory.initElements(Singleton.Driver(),this);
    }
    //Locators
    By gameTitle = By.id("appHubAppName");
    By gameReleaseDate = By.xpath("//div[@class='date'");
    By gamePlatformsWindows = By.xpath("//div[@class='sysreq_tabs AND contains(text(), 'Windows')'");
  /*  By gamePlatformsMacOS = By.xpath("//div[@class='sysreq_tabs AND contains(text(), 'macOS')'");
    By gamePlatformsLinux = By.xpath("//div[@class='sysreq_tabs AND contains(text(), 'linux')'");
*/
    public void readJson() throws IOException, ParseException {
        JSONParser jsonParser = new JSONParser();
        FileReader fileReader = new FileReader("src/JsonFiles/gameList.json");

        //Read Json file
        Object obj = jsonParser.parse(fileReader);

        JSONObject jsonObject = (JSONObject) obj;
        JSONArray array = (JSONArray) jsonObject.get(1);

        String[] arr = new String[array.size()];
        for (int i = 0; i < array.size(); i++) {
            JSONObject Title = (JSONObject) array.get(i);
            Singleton.Driver().findElement(gameTitle);
            JSONObject Platforms = (JSONObject) array.get(i);
            //Make a Platforms list
            Singleton.Driver().findElements(gamePlatformsWindows);
            JSONObject ReleaseDate = (JSONObject) array.get(i);
            Singleton.Driver().findElement(gameReleaseDate);


            arr[i] = Title + "," + Platforms + ',' + ReleaseDate;
        }
    }

    }











