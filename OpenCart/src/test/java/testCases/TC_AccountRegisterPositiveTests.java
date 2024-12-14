package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;


public class TC_AccountRegisterPositiveTests extends BaseClass {
    private static final String SUCCESS_MESSAGE = "Your Account Has Been Created!";

    private void navigateToRegistrationPage() {
        HomePage homePage = new HomePage(driver);
        homePage.clickMyAccount();
        homePage.clickRegistration();
        logger.info("Navigated to Registration page.");
    }

    private void fillRegistrationForm(String fname, String lname, String email, String telephone, String password, String confirmPassword) {
        AccountRegistrationPage regPage = new AccountRegistrationPage(driver);
        regPage.setFirstName(fname);
        regPage.setLastName(lname);
        regPage.setEmail(email);
        regPage.setTelephone(telephone);
        regPage.setPassword(password);
        regPage.setConfirmPassword(confirmPassword);
        regPage.acceptPrivacyPolicy();
        regPage.submitForm();
    }

    @Test(priority = 1)
    public void verifyAccountRegistration() {
        navigateToRegistrationPage();
        String password = randomAlphaNumber();
        fillRegistrationForm(randomString().toUpperCase(), randomString().toUpperCase(), randomString() + "@gmail.com", randomNumber(), password, password);

        AccountRegistrationPage regPage = new AccountRegistrationPage(driver);
        String actualMessage = regPage.getSuccessMessage();
        Assert.assertEquals(actualMessage, SUCCESS_MESSAGE, "Registration success message validation failed.");
        logger.info("Positive registration test passed.");
    }

    @Test(priority = 2)
    public void verifyPasswordAndConfirmPasswordMatchWhenSame() {
        navigateToRegistrationPage();
        String password = randomAlphaNumber();
        fillRegistrationForm(randomString().toUpperCase(), randomString().toUpperCase(), randomString() + "@gmail.com", randomNumber(), password, password);

        AccountRegistrationPage regPage = new AccountRegistrationPage(driver);
        String successMessage = regPage.getSuccessMessage();
        Assert.assertEquals(successMessage, SUCCESS_MESSAGE, "Account creation success message validation failed.");
        logger.info("Password matching test passed.");
    }
}
