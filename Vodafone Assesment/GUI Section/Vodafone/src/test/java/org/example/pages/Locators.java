package org.example.pages;

import org.example.stepDefinitions.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Locators {
    public WebElement language(){
        WebElement language= Hooks.driver.findElement(By.className("lang"));
        return language;
    }
    public WebElement iPhone(){
        return Hooks.driver.findElement(By.xpath("//a[@id=\"shopByBrandCard\"][@href=\"#/shopByBrand/Apple\"]"));
    }
    public List<WebElement> productSelection(){
        List<WebElement> iPhoneSelection = Hooks.driver.findElements(By.cssSelector("div[id=\"home-0\"] li[class=\"productList-item\"]"));
        return iPhoneSelection;
    }
    public WebElement addToBasketBtn(){
        return Hooks.driver.findElement(By.className("addToBasket-btn"));
    }
    public WebElement proceedToCheckout(){
        return Hooks.driver.findElement(By.cssSelector("div[class=\"cart_checkout fontLightEnAr\"] button[class=\"btn btn-red\"]"));
    }
    public WebElement city(){
        return Hooks.driver.findElement(By.cssSelector("div[class=\"col-md-4 col-sm-12 checkout-dropdownCity checkoutDeleiveryOptionsPhase2EditWidth\"]  select[class=\"btn dropdown-toggle checkout-dropdown border-radius_Style checkoutDeliveryFamilyFont\"]"));
    }
    public WebElement district(){
        return Hooks.driver.findElement(By.xpath("//*[@id=\"headingOne\"]/div[2]/select"));
    }
    public WebElement deliverToMyAddress(){
        return Hooks.driver.findElement(By.cssSelector("div[class=\"checkout-DelivaryOptionsRes\"] div[class=\"checkout-DelivaryOptionsInfo checkout-DelivaryToAddress open firstOpen\"]"));
    }
    public WebElement streetName(){
        return Hooks.driver.findElement(By.cssSelector("input[type=\"text\"][placeholder=\"Street Name\"]"));
    }
    public WebElement buildingNumber(){
        return Hooks.driver.findElement(By.cssSelector("input[type=\"text\"][formcontrolname=\"buildingNumber\"]"));
    }
    public WebElement floorNumber(){
        return Hooks.driver.findElement(By.cssSelector("input[type=\"text\"][formcontrolname=\"floorNumber\"]"));
    }
    public WebElement appartmentNumber(){
        return Hooks.driver.findElement(By.cssSelector("input[type=\"text\"][formcontrolname=\"appartmentNumber\"]"));
    }
    public WebElement contBtn(){
        return Hooks.driver.findElement(By.xpath("//button[@type=\"submit\"][@class=\"btn checkout-btn btn-red delievry--btn--checkout\"]"));
    }
    public WebElement contBtn2(){
        return Hooks.driver.findElement(By.id("shippingAddressContinue"));
    }
    public WebElement wrongMsg() {
        return Hooks.driver.findElement(By.cssSelector("form[name=\"personalUserInfo\"] div[class=\"help-block alertComp\"]"));
    }
}