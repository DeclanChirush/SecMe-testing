/**
 * @Author:  IT19180526 - S.A.N.L.D. Chandrasiri
 * @Decription: This class is used to store constants related to Auth Page and Root Page
 * @Version: 1.0
 */

package com.secme.secmetesting.auth;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class AuthPage {

    //Get Home page login button
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

    // Authentication message
    public SelenideElement authenticationMessage = $x("//*[contains(@class, 'pt-5')]//h3");

    // Navigate to Auth dashboard section
    public SelenideElement authNavigationButton = $x("//a[@href='/auth']");

    // Button for public access
    public SelenideElement publicAccessButton = $x("//*[contains(@class, 'pt-5')]//button[1]");

    // Button for private access
    public SelenideElement privateAccessButton = $x("//*[contains(@class, 'pt-5')]//button[2]");

    // Button for scope Admin access
    public SelenideElement scopeAdminAccessButton = $x("//*[contains(@class, 'pt-5')]//button[3]");

    // Button for scope Manager access
    public SelenideElement scopeManagerAccessButton = $x("//*[contains(@class, 'pt-5')]//button[4]");

    // Button for scope Worker access
    public SelenideElement scopeWorkerAccessButton = $x("//*[contains(@class, 'pt-5')]//button[5]");

    // Auth Response message
    public SelenideElement authResponseMessage = $x("//*[contains(@class, 'pt-5')]//h4");

    // Logout button xpath
    public SelenideElement logoutButton = $x("//*[contains(@class, 'navbar-nav')]//button");
}
