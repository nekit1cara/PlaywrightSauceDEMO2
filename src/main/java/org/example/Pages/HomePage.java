package org.example.Pages;

import com.microsoft.playwright.Page;
import org.example.Elements.HomePageElements;
import org.example.Exceptions.HomePageException;
import org.junit.Assert;

public class HomePage {

    public Page page;

   public HomePageElements homePageElements;

    public HomePage(Page page) {
        this.page = page;
        this.homePageElements = new HomePageElements();
    }

    public void checkHeaderIsVisible() {

       boolean header = page.locator(homePageElements.getAppNavigateMenu()).isVisible();

            if (header) {
                System.out.println("Header is visible");
            } else {
                throw new HomePageException("Header is not visible");
            }
    }

    public void checkFooterIsVisible() {

        boolean footer = page.locator(homePageElements.getAppFooter()).isVisible();

            if (footer) {
                System.out.println("Footer is visible");
            } else {
                throw new HomePageException("Footer is not visible");
            }
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
                throw new HomePageException("Logout failed! Logo is not visible.");
            }

    }

}
