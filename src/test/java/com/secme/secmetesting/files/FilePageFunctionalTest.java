/**
 * @Author: H.G. Malwatta - IT19240848
 * @Decription: This class is used to test file upload functionality
 * @Version: 1.0
 */

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
import static org.testng.Assert.*;

public class FilePageFunctionalTest {

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
    @Story("Login to the application by Admin")
    @Test(description = "Login to the application")
    public void loginTest() {
        //Click login button in home page navigation bar
        filePage.homeNavigationLoginButton.click();

        //Enter email
        filePage.emailInputField.sendKeys("admin@secme.com");

        //Enter password
        filePage.passwordInputField.sendKeys("RHN@2022");

        //Click login button
        filePage.loginButton.click();

        //Find user logged name in home page navigation bar
        assertEquals(filePage.userAuthenticationSuccessMessage.getText(), "Admin");
    }

    @Severity(SeverityLevel.NORMAL)
    @Description("Check file upload warning message")
    @Story("Test verify the response of the file upload warning message")
    @Test(priority = 1, testName = "Should be able to show warning message when upload null file")
    public void uploadFileWarningTest() {
        //Navigate to dashboard
        filePage.dashboardNavigationButton.click();

        //Navigate to file upload
        filePage.fileUploadNavigationButton.click();

        //File upload button
        filePage.fileUploadButtonClick.click();

        //Wait for file upload
        try {
            Thread.sleep(2000);
            //Find success message
            assertEquals(filePage.fileToastMessageResponse.getText(), "Please select a file to upload!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @Severity(SeverityLevel.NORMAL)
    @Description("Check file loaded information message")
    @Story("Test verify the response of the file loaded information message")
    @Test(priority = 2, testName = "Should be able to show info message after upload file")
    public void fileLoadedTest() {
        //Navigate to dashboard
        filePage.dashboardNavigationButton.click();

        //Navigate to file upload
        filePage.fileUploadNavigationButton.click();

        //File upload button
        filePage.fileUploadButton.sendKeys("C:\\Users\\Hirush\\Desktop\\Test.pdf");

        //Wait for file upload
        try {
            Thread.sleep(2000);
            //Find success message
            assertEquals(filePage.fileToastMessageResponse.getText(), "File Loaded Successfully!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @Severity(SeverityLevel.NORMAL)
    @Description("Check file upload success message")
    @Story("Test verify the response of the file upload success message")
    @Test(priority = 3, testName = "Should be able to upload file")
    public void uploadFileSuccessTest() {
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
    @Severity(SeverityLevel.NORMAL)
    @Description("Check file download success message")
    @Story("Test verify the response of the file download success message")
    @Test(priority = 4, testName = "Should be able to download file")
    public void downloadFile(){
        //Navigate to dashboard
        filePage.dashboardNavigationButton.click();

        //Navigate to file view page
        filePage.fileViewNavigationButton.click();

        //Click download button
        filePage.fileDownloadButton.click();

        //Wait for file download
        try {
            Thread.sleep(1000);
            //Find success message
            assertEquals(filePage.fileToastMessageResponse.getText(), "File Downloaded Successfully!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Severity(SeverityLevel.NORMAL)
    @Description("Check file delete success message")
    @Story("Test verify the response of the file delete success message")
    @Test(priority = 5, testName = "Should be able to delete file")
    public void deleteFile(){
        //Navigate to dashboard
        filePage.dashboardNavigationButton.click();

        //Navigate to file view page
        filePage.fileViewNavigationButton.click();

        //Click delete button
        filePage.fileDeleteButton.click();

        //Click delete confirmation button
        filePage.fileDeleteConfirmationButton.click();

        //Wait for file delete
        try {
            Thread.sleep(1000);
            //Find success message
            assertEquals(filePage.fileToastMessageResponse.getText(), "File Deleted Successfully!");

            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    public void logout() {
        try {
            Thread.sleep(3000);
            filePage.logoutButton.click();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
