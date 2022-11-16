/**
 * @Author:  IT19180526 - S.A.N.L.D. Chandrasiri
 * @Decription: This class is used to test the Manager user's authentication and functionality
 * @Version: 1.0
 */

package com.secme.secmetesting.auth;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.annotations.*;

import static com.codeborne.selenide.Selenide.open;
import static org.testng.Assert.assertEquals;

public class AuthPageManagerTest {

    // Create an object of AuthPage class
    AuthPage authPage = new AuthPage();

    // Set up browser size and add Allure Selenide listener
    @BeforeClass
    public static void setUpAll() {
        Configuration.browserSize = "1280x800";
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    // Navigate to the root page before each test
    @BeforeMethod
    public void navigateRoot() {
        open("https://localhost:3000");
    }

    // Logout user after tests execution
    @AfterClass
    public void logoutUser() {
        authPage.logoutButton.click();
    }

    @Severity(SeverityLevel.CRITICAL)
    @Description("Login to the application by Manager")
    @Story("Test verify the logged user's username and authentication validity")
    @Test(description = "Login to the application by Manager")
    public void loginManagerTest() {
        //Click login button in home page navigation bar
        authPage.homeNavigationLoginButton.click();

        //Enter email
        authPage.emailInputField.sendKeys("manager1@secme.com");

        //Enter password
        authPage.passwordInputField.sendKeys("RHN@2022");

        //Click login button
        authPage.loginButton.click();

        //Find user logged name in home page navigation bar
        assertEquals(authPage.userAuthenticationSuccessMessage.getText(), "Manager U1");

        //Check the user is authenticated
        assertEquals(authPage.authenticationMessage.getText(), "User is authenticated!");
    }

    @Severity(SeverityLevel.MINOR)
    @Description("Check Manager privileges in public access")
    @Story("Test verify the response of the public access button")
    @Test(priority = 1, description = "Check Manager privileges in public access")
    public void checkManagerPrivilegePublicAccessTest() {
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
    @Description("Check Manager privileges in private access")
    @Story("Test verify the response of the private access button")
    @Test(priority = 2, description = "Check Manager privileges in private access")
    public void checkManagerPrivilegePrivateAccessTest() {
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
    @Description("Check Manager privileges in Admin access")
    @Story("Test verify the response of the Admin access button")
    @Test(priority = 3, description = "Check Manager privileges in Admin access")
    public void checkManagerPrivilegeAdminAccessTest() {
        // Navigate to dashboard
        authPage.dashboardNavigationButton.click();

        // Click on Auth button
        authPage.authNavigationButton.click();

        // Click on Admin access button
        authPage.scopeAdminAccessButton.click();

        try {
            Thread.sleep(3000);
            // Check the public access message
            assertEquals(authPage.authResponseMessage.getText(), "Request failed with status code 403");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Severity(SeverityLevel.CRITICAL)
    @Description("Check Manager privileges in Manager access")
    @Story("Test verify the response of the Manager access button")
    @Test(priority = 4, description = "Check Manager privileges in Manager access")
    public void checkManagerPrivilegeManagerAccessTest() {
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

    @Severity(SeverityLevel.CRITICAL)
    @Description("Check Manager privileges in Worker access")
    @Story("Test verify the response of the Worker access button")
    @Test(priority = 5, description = "Check Manager privileges in Worker access")
    public void checkManagerPrivilegeWorkerAccessTest() {
        // Navigate to dashboard
        authPage.dashboardNavigationButton.click();

        // Click on Auth button
        authPage.authNavigationButton.click();

        // Click the Worker access button
        authPage.scopeWorkerAccessButton.click();

        try {
            Thread.sleep(3000);
            // Check the public access message
            assertEquals(authPage.authResponseMessage.getText(), "Request failed with status code 403");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
