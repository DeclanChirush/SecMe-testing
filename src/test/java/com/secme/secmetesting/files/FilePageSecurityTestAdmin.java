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

public class FilePageSecurityTestAdmin {

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
    @Story("Login to the application by Manager")
    @Test(priority = 1, description = "Login to the application")
    public void loginTest() {
        //Click login button in home page navigation bar
        filePage.homeNavigationLoginButton.click();

        try {
            Thread.sleep(2000);
            //Enter email
            filePage.emailInputField.sendKeys("admin@secme.com");
            //Enter password
            filePage.passwordInputField.sendKeys("RHN@2022");
            //Click login button
            filePage.loginButton.click();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //Find user logged name in home page navigation bar
        assertEquals(filePage.userAuthenticationSuccessMessage.getText(), "Admin");
    }

    @Severity(SeverityLevel.CRITICAL)
    @Description("Check file upload error message")
    @Story("Test verify the response of the file upload success message")
    @Test(priority = 2, testName = "Should be able to upload file")
    public void uploadFileSuccessTest(){
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
            assertEquals(filePage.fileToastMessageResponse.getText(), "File Uploaded Successfully!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @Severity(SeverityLevel.CRITICAL)
    @Description("Check files list view")
    @Story("Test verify the response of the files list view")
    @Test(priority = 3, testName = "Should be able to view files")
    public void viewFilesSuccessTest(){
        //Navigate to dashboard
        filePage.dashboardNavigationButton.click();

        //Navigate to file view page
        filePage.fileViewNavigationButton.click();

        //Wait for load view page
        try {
            Thread.sleep(1500);
            //Find error message
            assertEquals(filePage.fileDownloadButton.getText(), "Download");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @AfterClass
    public void logout() {
        try {
            Thread.sleep(2000);
            filePage.logoutButton.click();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
