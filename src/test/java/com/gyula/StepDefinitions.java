package com.gyula;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en_scouse.An;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

public class StepDefinitions {

    static WebDriver driver;

    static {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Given("The homepage is opened")
    public void theHomePageIsOpened() {
        driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
        driver.manage().window().maximize();
    }

    @Given("Email address is added")
    public void emailAddressIsAdded() {
        driver.findElement(By.id("email_create")).sendKeys("valami@myemail.hu");
    }

    @And("Registration button is clicked")
    public void registrationButtonIsClicked() {
        driver.findElement(By.id("SubmitCreate")).click();
    }


    @An("The firstnamefield is filled")
    public void theFirstnamefieldIsFilled() {
        driver.findElement(By.id("customer_firstname")).sendKeys("Gyula");
    }

    @And("The lastnamefield is filled")
    public void theLastnamefieldIsFilled() {
        driver.findElement(By.id("customer_lastname")).sendKeys("Szabo");
    }

    @And("The passwordfield is filled")
    public void thePasswordfieldIsFilled() {
        driver.findElement(By.id("passwd")).sendKeys("password");
    }

    @And("Gender added")
    public void genderAdded() {
        driver.findElement(By.id("id_gender1")).click();
    }

    @And("Birthday day added")
    public void birthdayDayAdded() {
        driver.findElement(By.id("days")).sendKeys("14");
    }

    @And("Birthday month added")
    public void birthdayMonthAdded() {
        driver.findElement(By.id("months")).sendKeys("July");
    }

    @And("Birthday year added")
    public void birthdayYearAdded() {
        driver.findElement(By.id("years")).sendKeys("1980");
    }

    @And("Newsletter clicked")
    public void newsletterClicked() {
        driver.findElement(By.id("newsletter")).click();
    }

    @And("Company name added")
    public void companyNameAdded() {
        driver.findElement(By.id("company")).sendKeys("MyCompany");
    }

    @And("Address added")
    public void addressAdded() {
        driver.findElement(By.id("address1")).sendKeys("Mandula utca 1");
    }

    @And("City added")
    public void cityAdded() {
        driver.findElement(By.id("city")).sendKeys("Debrecen");
    }

    @And("State added")
    public void stateAdded() {
        driver.findElement(By.id("id_state")).sendKeys("Hawaii");
    }

    @And("Postal code added")
    public void postalCodeAdded() {
        driver.findElement(By.id("postcode")).sendKeys("54321");
    }

    @And("Register button clicked")
    public void registerButtonClicked() {
        driver.findElement(By.id("submitAccount")).click();
    }

    @Then("A phone number missing error is displayed")
    public void aPhoneNumberMissingErrorIsDisplyed() {
        List<WebElement> elements = driver.findElements(By.xpath("//*[@id=\"center_column\"]/div/ol/li"));
        Assert.assertNotEquals(0, elements.size());
        Assert.assertEquals("You must register at least one phone number.", elements.get(0).getText());
    }

    @Given("The {string} is filled with {string}")
    public void theEmailfieldIsFilledWithValue(String field, String email) {
        driver.findElement(By.id(field)).sendKeys(email);
    }

    @Then("The create account button is clicked")
    public void theCreateAccountButtonIsClicked() {
        driver.findElement(By.id("SubmitCreate")).click();
    }

    @Given("Invalid email address is added")
    public void invalidEmailAddressIsAdded() {
        driver.findElement(By.id("email_create")).sendKeys("eznememail");
    }

    @Then("Invalid email address error displayed")
    public void invalidEmailAddressErrorDisplayed() {
        List<WebElement> elements = driver.findElements(By.xpath("//*[@id=\"create_account_error\"]/ol/li"));
        Assert.assertNotEquals(0, elements.size());
        Assert.assertEquals("Invalid email address.", elements.get(0).getText());

    }

    @Given("Enter valid email")
    public void enterValidEmail() {
        driver.findElement(By.id("email")).sendKeys("validemail@gyula.hu");
    }

    @And("Enter valid password")
    public void enterValidPassword() {
        driver.findElement(By.id("passwd")).sendKeys("jelszo");
    }

    @And("Click on sign in button")
    public void clickOnSignInButton() {
        driver.findElement(By.id("SubmitLogin")).click();
    }

    @And("Click on My Wishlist button")
    public void clickOnMyWishlistButton() {
        driver.findElement(By.xpath("//*[@id=\"center_column\"]/div/div[2]/ul/li/a")).click();
    }

    @And("Add new wishlist name")
    public void addNewWishlistName() {
        driver.findElement(By.id("name")).sendKeys("My new wishlist");
    }

    @And("Save new wishlist")
    public void saveNewWishlist() {
        driver.findElement(By.id("submitWishlist")).click();
    }

    @And("Logout")
    public void logout() {
        driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[2]/a")).click();
    }


    @And("Click on T-shirts")
    public void clickOnTShirts() {
        driver.findElement(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[3]/a")).click();
    }

    @And("Select list view")
    public void addATShirtToCart() {
        driver.findElement(By.xpath("//*[@id=\"list\"]/a")).click();
    }

}
