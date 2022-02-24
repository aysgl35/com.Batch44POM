package tests.day27;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.HotelMyCampPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C02_DataProviderNegatifLoginTesti {
    @DataProvider
    public static Object[][] wrongUserList(){
        String liste[][]={{"manager11","manager11"},{"manager12","manager12"},{"manager13","manager13"}};
        return liste;
    }
    @Test
    public void yanlisSifreUsernameTesti(){
        Driver.getDriver().get(ConfigReader.getProperty("HMCUrl"));
        HotelMyCampPage hotelMyCampPage=new HotelMyCampPage();
        hotelMyCampPage.ilkLoginLinki.click();
        hotelMyCampPage.usernameBox.sendKeys(ConfigReader.getProperty("HMCWrongUsername"));
        hotelMyCampPage.passwordBox.sendKeys(ConfigReader.getProperty("HMCWrongPassword"));
        hotelMyCampPage.loginButonu.click();
        Assert.assertTrue(hotelMyCampPage.girisYapilamadiYaziElementi.isDisplayed());
        Driver.closeDriver();
    }

}
