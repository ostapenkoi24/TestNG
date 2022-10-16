import data.DataProviderr;
import driverConfig.BROWSER;
import driverConfig.BaseClass;
import driverConfig.DriverFactory;
import hillel.ContactForm;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.MainPage;

public class Homework22 extends BaseClass {
    WebDriver driver;
    ContactForm form;
    MainPage mainPage;


    @BeforeClass
    public void create(){
        if (driver == null) {
            driver = DriverFactory.getDriver(BROWSER.CHROME);
        }
        if(form==null){
            form=new ContactForm(driver);
        }
        if(mainPage==null){
            mainPage=new MainPage(driver);
        }
    }


    @AfterClass
    public void stopp() {
        driver.close();
    }



    @Test(description = "open page", priority = 0)
    public void openPage(){
        driver.get("https://ithillel.ua/");
        Assert.assertEquals(driver.getTitle(),"Комп'ютерна школа Hillel у Києві: Курси IT-технологій");

    }
    @Test(description = "click to button consultation",dependsOnMethods = "openPage",priority = 1)
    public void clickFormButton(){
        if(MainPage.element.isEnabled()) {
            mainPage.clickConsultButton();
        }else {
            System.out.println("The button not found");
        }
    }

    @Test( dataProvider = "sendDataToForm", dataProviderClass = DataProviderr.class, priority = 2)
    public void testForm(String name, String mail, String tel, String mass, String course) {
        driver.get("https://ithillel.ua/");
        mainPage.clickConsultButton();
        form.create(name,mail,tel,mass,course, "ldklkkvjdl");
    }
}

