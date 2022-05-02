package Zerodha;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Listeners;

import java.io.IOException;
import java.sql.SQLException;

@Listeners(listernerConfig.Listeners.class)
public class launch extends BaseClass {


    public static Logger log = LogManager.getLogger(BaseClass.class.getName());
    String expectedTitle = "Shireburn Indigo - Login";
    String loginTitle = "QATest01 - Payroll Module";
    String title;
    String baseurl = "https://indigo-testing.shireburn.com/Home";
    WebDriver driver = initDriver();
    PageObject element = new PageObject(driver); // Creating Page Object reference

    String tax_profile_title = "QATest01 - Payroll Module";

    public launch() throws SQLException, IOException, ClassNotFoundException {
    }

    @Given("user launches indigo home page")

    public void user_launches_indigo_home_page() throws ClassNotFoundException, IOException, SQLException {

        driver.get(baseurl);
        System.out.println(driver.getTitle());
    }

    @When("user should be able to see the website title")
    public void user_should_be_able_to_see_the_website_title() {

        try {
            WebDriverWait wait = new WebDriverWait(driver, 5); //Explicit wait
            wait.until(ExpectedConditions.titleIs(expectedTitle));
            title = driver.getTitle();
            System.out.println("Actual title from the test is " + "  " + title);
        } catch (Exception e) {
            e.printStackTrace();
            String url = driver.getCurrentUrl();
            if (baseurl != url) {
                driver.get(baseurl);
                title = driver.getTitle();
                System.out.println("Actual title from the test is " + "  " + title);
            } else {
                System.out.println("user is on wrong domain" + "  " + title);
            }


        }
    }


    @When("user enters username as IntQA11 and password as Kh34685552.")
    public void user_enters_username_as_int_qa11_and_password_as_kh34685552() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 10); //Explicit wait

            wait.until(ExpectedConditions.elementToBeClickable(element.username()));

            element.username().sendKeys("IntQA11");
            log.info("username entered");
            element.password().sendKeys("Kh34685552.");
            log.info("password entered");

        } catch (NoSuchElementException e) {
            driver.navigate().refresh();
            element.username().sendKeys("IntQA11");
            log.info("username entered");
            element.password().sendKeys("Kh34685552.");
            log.info("password entered");

        }

    }

    @When("user clicks login")
    public void user_clicks_login() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 10); //Explicit wait
            wait.until(ExpectedConditions.elementToBeClickable(element.login()));
            element.login().click();
            System.out.println("login icon clicked");


        } catch (NoSuchElementException e) {
            driver.navigate().refresh();
            JavascriptExecutor js = (JavascriptExecutor) driver;

            js.executeScript("arguments[0].click();", element.login()); // clicking players icon using java script executor

            System.out.println("login icon clicked");


        }
    }

    @Then("user should be ble to sign in to the indigo application")
    public void user_should_be_ble_to_sign_in_to_the_indigo_application() {

            WebDriverWait wait = new WebDriverWait(driver, 10); //Explicit wait
            wait.until(ExpectedConditions.titleIs(loginTitle));
            title = driver.getTitle();
            System.out.println("Actual title from the test is " + "  " + title);
            System.out.println("user logged in to the application");

    }

    @When("user clicks tax profiles tab")
    public void user_clicks_tax_profiles_tab() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 10); //Explicit wait
            wait.until(ExpectedConditions.elementToBeClickable(element.taxProfile()));
            element.taxProfile().click();
            System.out.println("tax profile icon clicked");


        } catch (NoSuchElementException e) {
            driver.navigate().refresh();
            JavascriptExecutor js = (JavascriptExecutor) driver;

            js.executeScript("arguments[0].click();", element.taxProfile()); // clicking tax profile icon using java script executor

            System.out.println("tax profile icon clicked");


        }
    }
    @Then("user should navigate to tax profiles screen")
    public void user_should_navigate_to_tax_profiles_screen() {

            String ActualTitle = driver.getTitle();
            Assert.assertEquals(tax_profile_title, ActualTitle);

    }
    @When("user clicks insert button")
    public void user_clicks_insert_button() {
        WebDriverWait wait = new WebDriverWait(driver, 10); //Explicit wait
        wait.until(ExpectedConditions.elementToBeClickable(element.inserButton()));
        element.inserButton().click();
        System.out.println("insert button icon clicked");
    }
    @Then("user enters new tax profile name Bilal_test and QA_TEST")
    public void user_enters_new_tax_profile_name_bilal_test_and_qa_test() {
        element.profileName().sendKeys("Bilal_test"+Math.random());
        log.info("tax profile name entered");
        element.descriptionHeader().click();
        element.description().sendKeys("QA_TEST.");
        log.info("description entered");

    }
    @Then("user clicks save button")
    public void user_clicks_save_button() {
        WebDriverWait wait = new WebDriverWait(driver, 10); //Explicit wait
        wait.until(ExpectedConditions.elementToBeClickable(element.save()));
        element.save().click();
        System.out.println("save button icon clicked");
    }
    @When("user clicks usermenu")
    public void user_clicks_usermenu() {
        WebDriverWait wait = new WebDriverWait(driver, 10); //Explicit wait
        wait.until(ExpectedConditions.elementToBeClickable(element.userMenu()));
        element.userMenu().click();
        System.out.println("user menu button icon clicked");
    }
    @And("user clicks logout")
    public void user_clicks_logout() {
        WebDriverWait wait = new WebDriverWait(driver, 10); //Explicit wait
        wait.until(ExpectedConditions.elementToBeClickable(element.logout()));
        element.logout().click();
        System.out.println("logout  button clicked");
    }

}

