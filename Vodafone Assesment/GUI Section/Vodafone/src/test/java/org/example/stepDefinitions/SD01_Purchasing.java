package org.example.stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.Locators;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.asserts.SoftAssert;



public class SD01_Purchasing {
    SoftAssert soft=new SoftAssert();
    Locators locators = new Locators();

    @Given("Go to Vodafone Shop using URL.")
    public void go_to_vodafone_shop_using_url() {

        Hooks.driver.navigate().to("https://eshop.vodafone.com.eg/eshop/homePage/index.jsp#/home");

    }

    @When("Select language as English.")
    public void select_language_as_english() throws InterruptedException {
        locators.language().click();
        Thread.sleep(500);
    }

    @And("Go to Shop By Brand section and select Iphone.")
    public void go_to_shop_by_brand_section_and_select_iphone() {
        JavascriptExecutor js = (JavascriptExecutor) Hooks.driver;
        js.executeScript("window.scrollBy(0,200)", "");
        locators.iPhone().sendKeys(Keys.ENTER);
    }

    @And("Select any of returned iphone mobiles.")
    public void select_any_of_returned_iphone_mobiles() {
        Hooks.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Random random = new Random();
        int count = random.nextInt(locators.productSelection().size());
        locators.productSelection().get(count).click();
    }

    @And("Press add to cart")
    public void press_add_to_cart() throws InterruptedException {
        Thread.sleep(3000);
        locators.addToBasketBtn().click();
    }

    @And("Press proceed to checkout")
    public void press_proceed_to_checkout() throws InterruptedException {
        Thread.sleep(3000);
        locators.proceedToCheckout().click();
    }

    @And("Select Delivery Options as Cairo Ain Shams.")
    public void select_delivery_options_as_cairo_ain_shams() throws InterruptedException {
        Select select = new Select(locators.city());
        select.selectByVisibleText("Cairo");
        select = new Select(locators.district());
        select.selectByVisibleText("Ain Shams");
    }

    @And("Select Deliver to My Address.")
    public void select_deliver_to_my_address() {
        JavascriptExecutor js = (JavascriptExecutor) Hooks.driver;
        js.executeScript("window.scrollBy(0,300)", "");
        Hooks.driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        locators.deliverToMyAddress().click();
    }

    @And("Add address details")
    public void add_address_details() {
        locators.streetName().sendKeys("12 Ain shams egypt");
        locators.buildingNumber().sendKeys("10");
        locators.floorNumber().sendKeys("4");
        locators.appartmentNumber().sendKeys("8");

    }

    @And("Press continue")
    public void press_continue() {
        locators.contBtn().sendKeys(Keys.ENTER);
    }

    @And("Leave Personal info. Tab empty.")
    public void leave_personal_info_tab_empty() throws InterruptedException {
        Thread.sleep(500);
        locators.contBtn2().sendKeys(Keys.ENTER);
    }

    @Then("Assert on error message returned from Full Name field.")
    public void assert_on_error_message_returned_from_full_name_field() {
        locators.wrongMsg().isDisplayed();
        String actual = locators.wrongMsg().getText();
        soft.assertEquals(actual.contains("Please enter a valid name"),true);
    }
}