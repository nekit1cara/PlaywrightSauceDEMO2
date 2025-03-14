package org.example.Pages;

import com.microsoft.playwright.Page;
import org.example.Elements.HomePageElements;
import org.junit.Assert;

public class HomePage {

    public Page page;

   public HomePageElements homePageElements;

    public HomePage(Page page) {
        this.page = page;
        this.homePageElements = new HomePageElements();
    }


    public void getProductNameAndVerifyIt() {
       //Assert.assertEquals("Sauce Labs Backpack", page.textContent(productName_1));
        String productDescription1 = homePageElements.getProductName_1();
       Assert.assertEquals("Sauce Labs Backpack", page.textContent(productDescription1));
        System.out.println(page.textContent(productDescription1));
    }


    public void logoutApplication() {
        String appNavigateMenu = homePageElements.getAppNavigateMenu();
        page.locator(appNavigateMenu).waitFor();
        page.locator(appNavigateMenu).click();

        String logoutButton = homePageElements.getLogoutButton();
        page.locator(logoutButton).waitFor();
        page.locator(logoutButton).click();

        String logo = homePageElements.getLogo();
        boolean isLogoVisible = page.locator(logo).isVisible();

        // Логируем успешный выход
        if (isLogoVisible) {
            System.out.println("Logout successful!");
        } else {
            System.err.println("Logout failed! Logo is not visible.");
        }
    }

}
