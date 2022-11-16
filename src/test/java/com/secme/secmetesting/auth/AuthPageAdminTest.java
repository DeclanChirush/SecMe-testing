package com.secme.secmetesting.auth;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;
import static org.testng.Assert.assertEquals;

public class AuthPageAdminTest {

    AuthPage authPage = new AuthPage();

    @BeforeClass
    public static void setUpAll() {
        Configuration.browserSize = "1280x800";
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @BeforeMethod
    public void setUp() {
        open("https://localhost:3000");
    }

    @Severity(SeverityLevel.CRITICAL)
    @Description("Login to the application by Admin")
    @Story("Test verify the logged user's username and authentication validity")
    @Test(description = "Login to the application by Admin")
    public void loginAdminTest() {
        //Click login button in home page navigation bar
        authPage.homeNavigationLoginButton.click();

        //Enter email
        authPage.emailInputField.sendKeys("admin@secme.com");

        //Enter password
        authPage.passwordInputField.sendKeys("RHN@2022");

        //Click login button
        authPage.loginButton.click();

        //Find user logged name in home page navigation bar
        assertEquals(authPage.userAuthenticationSuccessMessage.getText(), "Admin");

        //Check the user is authenticated
        assertEquals(authPage.authenticationMessage.getText(), "User is authenticated!");
    }

    @Severity(SeverityLevel.NORMAL)
    @Description("Check Admin privileges in public access")
    @Story("Test verify the response of the public access button")
    @Test(priority = 1, testName = "Check Admin privileges in public access")
    public void checkAdminPrivilegePublicAccessTest() {
        // Navigate to dashboard
        authPage.dashboardNavigationButton.click();

        // Click on Auth button
        authPage.authNavigationButton.click();

        // Click on public access button
        authPage.publicAccessButton.click();

        try {
            Thread.sleep(3000);
            // Check the public access message
            assertEquals(authPage.authResponseMessage.getText(), "Do not need to be authenticated. (api/auth/public)");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Severity(SeverityLevel.NORMAL)
    @Description("Check Admin privileges in private access")
    @Story("Test verify the response of the private access button")
    @Test(priority = 2, testName = "Check Admin privileges in private access")
    public void checkAdminPrivilegePrivateAccessTest() {
        // Navigate to dashboard
        authPage.dashboardNavigationButton.click();

        // Click on Auth button
        authPage.authNavigationButton.click();

        // Click on private access button
        authPage.privateAccessButton.click();

        try {
            Thread.sleep(3000);
            // Check the private access message
            assertEquals(authPage.authResponseMessage.getText(), "Authenticated. (api/auth/private)");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Severity(SeverityLevel.CRITICAL)
    @Description("Check Admin privileges in Admin access")
    @Story("Test verify the response of the Admin access button")
    @Test(priority = 3, testName = "Check Admin privileges in Admin access")
    public void checkAdminPrivilegeAdminAccessTest() {
        // Navigate to dashboard
        authPage.dashboardNavigationButton.click();

        // Click on Auth button
        authPage.authNavigationButton.click();

        // Click on Admin access button
        authPage.scopeAdminAccessButton.click();

        try {
            Thread.sleep(3000);
            // Check the public access message
            assertEquals(authPage.authResponseMessage.getText(), "Authenticated. Role:Admin");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Severity(SeverityLevel.MINOR)
    @Description("Check Admin privileges in Manager access")
    @Story("Test verify the response of the Manager access button")
    @Test(priority = 4, testName = "Check Admin privileges in Manager access")
    public void checkAdminPrivilegeManagerAccessTest() {
        // Navigate to dashboard
        authPage.dashboardNavigationButton.click();

        // Click on Auth button
        authPage.authNavigationButton.click();

        // Click the Manager access button
        authPage.scopeManagerAccessButton.click();

        try {
            Thread.sleep(3000);
            // Check the public access message
            assertEquals(authPage.authResponseMessage.getText(), "Authenticated. Role:Manager");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Severity(SeverityLevel.MINOR)
    @Description("Check Admin privileges in Worker access")
    @Story("Test verify the response of the Worker access button")
    @Test(priority = 5, testName = "Check Admin privileges in Worker access")
    public void checkAdminPrivilegeWorkerAccessTest() {
        // Navigate to dashboard
        authPage.dashboardNavigationButton.click();

        // Click on Auth button
        authPage.authNavigationButton.click();

        // Click the Worker access button
        authPage.scopeWorkerAccessButton.click();

        try {
            Thread.sleep(3000);
            // Check the public access message
            assertEquals(authPage.authResponseMessage.getText(), "Authenticated. Role:Worker");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
