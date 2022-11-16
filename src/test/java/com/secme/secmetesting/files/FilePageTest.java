/**
 * @Author:  H.G. Malwatta - IT19240848
 * @Decription: This class is used to test file upload functionality
 * @Version: 1.0
 */

package com.secme.secmetesting.files;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;
import static org.testng.Assert.*;

public class FilePageTest {

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

    @Test(priority = 1, testName = "Should be able to show warning message when upload null file")
    public void uploadFileWarningTest(){
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
            assertEquals(filePage.fileUploadSuccessMessage.getText(), "Please select a file to upload!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @Test(priority = 2, testName = "Should be able to show info message after upload file")
    public void fileLoadedTest(){
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
            assertEquals(filePage.fileUploadSuccessMessage.getText(), "File Loaded Successfully!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
    @Test(priority = 3, testName = "Should be able to upload file")
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
            assertEquals(filePage.fileUploadSuccessMessage.getText(), "File Uploaded Successfully!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
