package com.secme.secmetesting.files;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;
import static org.testng.Assert.assertEquals;

public class FilePageSecurityTestWorker {

    FilePage filePage = new FilePage();

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
    @Description("Check Admin privileges in private access")
    @Story("Login to the application by Worker")
    @Test(description = "Login to the application")
    public void loginTest() {
        //Click login button in home page navigation bar
        filePage.homeNavigationLoginButton.click();

        //Enter email
        filePage.emailInputField.sendKeys("worker1@secme.com");

        //Enter password
        filePage.passwordInputField.sendKeys("RHN@2022");

        //Click login button
        filePage.loginButton.click();

        //Find user logged name in home page navigation bar
        assertEquals(filePage.userAuthenticationSuccessMessage.getText(), "Worker U1");
    }

    @Severity(SeverityLevel.CRITICAL)
    @Description("Check file upload error message")
    @Story("Test verify the response of the file upload error message")
    @Test(priority = 1, testName = "Should not be able to upload file")
    public void uploadFileErrorTest() {
        //Navigate to dashboard
        filePage.dashboardNavigationButton.click();

        //Navigate to file upload
        filePage.fileUploadNavigationButton.click();

        //File upload button
        filePage.fileUploadButton.sendKeys("C:\\Users\\Hirush\\Desktop\\Test.pdf");

        //Wait for file load
        try {
            Thread.sleep(7000);
            //Upload button click
            filePage.fileUploadButtonClick.click();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //Wait for file upload
        try {
            Thread.sleep(2500);
            //Find success message
            assertEquals(filePage.fileToastMessageResponse.getText(), "You can't upload any file!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @Severity(SeverityLevel.CRITICAL)
    @Description("Check files view error message")
    @Story("Test verify the response of the files view error message")
    @Test(priority = 2, testName = "Should not be able to view files")
    public void viewFilesErrorTest() {
        //Navigate to dashboard
        filePage.dashboardNavigationButton.click();

        //Navigate to file view page
        filePage.fileViewNavigationButton.click();

        //Wait for load view page
        try {
            Thread.sleep(1500);
            //Find error message
            assertEquals(filePage.fileToastMessageResponse.getText(), "You can't view any files!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @AfterClass
    public void logout() {
        try {
            Thread.sleep(1000);
            filePage.logoutButton.click();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
