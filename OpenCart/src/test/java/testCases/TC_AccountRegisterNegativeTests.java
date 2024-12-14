package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;


public class TC_AccountRegisterNegativeTests extends BaseClass {
    private static final String FNAME_ALERT = "First Name must be between 1 and 32 characters!";
    private static final String LNAME_ALERT = "Last Name must be between 1 and 32 characters!";
    private static final String EMAIL_ALERT = "E-Mail Address does not appear to be valid!";
    private static final String TEL_ALERT = "Telephone must be between 3 and 32 characters!";
    private static final String PASS_ALERT = "Password must be between 4 and 20 characters!";
    private static final String PASS_MISMATCH_ALERT = "Password confirmation does not match password!";

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

    private void validateAlertMessage(String fieldName, String actualAlert, String expectedAlert) {
        Assert.assertEquals(actualAlert, expectedAlert, fieldName + " alert validation failed.");
        logger.info(fieldName + " alert validation passed.");
    }

    @Test(priority = 1)
    public void verifyAccountRegistrationAllFieldsRequired() {
        navigateToRegistrationPage();
        AccountRegistrationPage regPage = new AccountRegistrationPage(driver);
        regPage.submitForm();
        validateAlertMessage("First Name", regPage.getFirstNameAlert(), FNAME_ALERT);
        validateAlertMessage("Last Name", regPage.getLastNameAlert(), LNAME_ALERT);
        validateAlertMessage("Email", regPage.getEmailAlert(), EMAIL_ALERT);
        validateAlertMessage("Telephone", regPage.getTelephoneAlert(), TEL_ALERT);
        validateAlertMessage("Password", regPage.getPasswordAlert(), PASS_ALERT);
    }

    @Test(priority = 2)
    public void verifyMissingFirstName() {
        navigateToRegistrationPage();
        AccountRegistrationPage regPage = new AccountRegistrationPage(driver);
        regPage.setLastName(randomString().toUpperCase());
        regPage.setEmail(randomString() + "@gmail.com");
        regPage.setTelephone(randomNumber());
        String password = randomAlphaNumber();
        regPage.setPassword(password);
        regPage.setConfirmPassword(password);
        regPage.acceptPrivacyPolicy();
        regPage.submitForm();
        validateAlertMessage("First Name", regPage.getFirstNameAlert(), FNAME_ALERT);
    }

    @Test(priority = 3)
    public void verifyMissingLastName() {
        navigateToRegistrationPage();
        AccountRegistrationPage regPage = new AccountRegistrationPage(driver);
        regPage.setFirstName(randomString().toUpperCase());
        regPage.setEmail(randomString() + "@gmail.com");
        regPage.setTelephone(randomNumber());
        String password = randomAlphaNumber();
        regPage.setPassword(password);
        regPage.setConfirmPassword(password);
        regPage.acceptPrivacyPolicy();
        regPage.submitForm();
        validateAlertMessage("Last Name", regPage.getLastNameAlert(), LNAME_ALERT);
    }

    @Test(priority = 4)
    public void verifyMissingEmail() {
        navigateToRegistrationPage();
        AccountRegistrationPage regPage = new AccountRegistrationPage(driver);
        regPage.setFirstName(randomString().toUpperCase());
        regPage.setLastName(randomString().toUpperCase());
        regPage.setTelephone(randomNumber());
        String password = randomAlphaNumber();
        regPage.setPassword(password);
        regPage.setConfirmPassword(password);
        regPage.acceptPrivacyPolicy();
        regPage.submitForm();
        validateAlertMessage("Email", regPage.getEmailAlert(), EMAIL_ALERT);
    }

    @Test(priority = 5)
    public void verifyMissingTelephone() {
        navigateToRegistrationPage();
        AccountRegistrationPage regPage = new AccountRegistrationPage(driver);
        regPage.setFirstName(randomString().toUpperCase());
        regPage.setLastName(randomString().toUpperCase());
        regPage.setEmail(randomString() + "@gmail.com");
        String password = randomAlphaNumber();
        regPage.setPassword(password);
        regPage.setConfirmPassword(password);
        regPage.acceptPrivacyPolicy();
        regPage.submitForm();
        validateAlertMessage("Telephone", regPage.getTelephoneAlert(), TEL_ALERT);
    }

    @Test(priority = 6)
    public void verifyMissingPassword() {
        navigateToRegistrationPage();
        AccountRegistrationPage regPage = new AccountRegistrationPage(driver);
        regPage.setFirstName(randomString().toUpperCase());
        regPage.setLastName(randomString().toUpperCase());
        regPage.setEmail(randomString() + "@gmail.com");
        regPage.setTelephone(randomNumber());
        regPage.acceptPrivacyPolicy();
        regPage.submitForm();
        validateAlertMessage("Password", regPage.getPasswordAlert(), PASS_ALERT);
    }

    @Test(priority = 7)
    public void verifyPasswordAndConfirmPasswordMatch() {
        navigateToRegistrationPage();
        String password = randomAlphaNumber();
        fillRegistrationForm(randomString().toUpperCase(), randomString().toUpperCase(), randomString() + "@gmail.com", randomNumber(), password, password + "1");
        AccountRegistrationPage regPage = new AccountRegistrationPage(driver);
        String passMismatchAlert = regPage.getPasswordMismatchAlert();
        validateAlertMessage("Password and Confirm Password", passMismatchAlert, PASS_MISMATCH_ALERT);
    }
}
