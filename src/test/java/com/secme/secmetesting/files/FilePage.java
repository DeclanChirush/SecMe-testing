/**
 * @Author:  H.G. Malwatta - IT19240848
 * @Decription: This class is used to store constants related to File Page and Home Page
 * @Version: 1.0
 */
package com.secme.secmetesting.files;

import com.codeborne.selenide.SelenideElement;
import org.w3c.dom.html.HTMLInputElement;

import static com.codeborne.selenide.Selenide.$x;

public class FilePage {
    public SelenideElement homeNavigationLoginButton = $x("//*[contains(@class, 'nav-link btn btn-secondary m-1')]");

    //Get input field id for username
    public SelenideElement emailInputField = $x("//input[@id='username']");

    //Get input field id for password
    public SelenideElement passwordInputField = $x("//input[@id='password']");

    //Get login button id
    public SelenideElement loginButton = $x("//button[@type='submit' and @name='action']");

    //Get user authentication success message
    public SelenideElement userAuthenticationSuccessMessage = $x("//*[contains(@class, 'nav-link disabled m-1')]");

    //Navigate to dashboard
    public SelenideElement dashboardNavigationButton = $x("//a[@href='/dashboard']");

    //Navigate to file upload
    public SelenideElement fileUploadNavigationButton = $x("//a[@href='/file']");

    //Upload file
    public SelenideElement fileUploadButton = $x("//input[@type='file']");

    //File upload button
    public SelenideElement fileUploadButtonClick = $x("//*[contains(@class, 'btn btn-success text-center btn btn-primary')]");

    //Get second child div tag of file upload success message
    public SelenideElement fileToastMessageResponse = $x("//*[contains(@class, 'Toastify__toast-body')]/div[2]");

    //Navigate to file view page
    public SelenideElement fileViewNavigationButton = $x("//a[@href='/file-list']");

    //File download button
    public SelenideElement fileDownloadButton = $x("//button[@id='download-file']");

    //File delete button
    public SelenideElement fileDeleteButton = $x("//button[@id='delete-file']");

    //File delete confirmation button
    public SelenideElement fileDeleteConfirmationButton = $x("//button[@id='delete-file-confirmation']");

    //Logout button
    public SelenideElement logoutButton = $x("//*[contains(@class, 'navbar-nav')]//button");
}
