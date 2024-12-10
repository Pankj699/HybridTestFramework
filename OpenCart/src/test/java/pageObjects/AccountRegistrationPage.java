package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage {

    public AccountRegistrationPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "input-firstname")
    public WebElement fname;

    @FindBy(id = "input-lastname")
    public WebElement lname;

    @FindBy(id = "input-email")
    public WebElement email;

    @FindBy(id = "input-telephone")
    public WebElement telephone;

    @FindBy(id = "input-password")
    public WebElement password;

    @FindBy(id = "input-confirm")
    public WebElement confirmPassword;

    @FindBy(name = "agree")
    public WebElement privacyPolicy;

    @FindBy(xpath = "//input[@value='Continue']")
    public WebElement btnContinue;

    @FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
    public WebElement successMessage;

    @FindBy(xpath = "//div[contains(text(),'First Name must be between 1 and 32 characters!')]")
    public WebElement fNameRequired;

    @FindBy(xpath = "//div[contains(text(),'Last Name must be between 1 and 32 characters!')]")
    public WebElement lNameRequired;

    @FindBy(xpath = "//div[contains(text(),'E-Mail Address does not appear to be valid!')]")
    public WebElement emailRequired;

    @FindBy(xpath = "//div[contains(text(),'Telephone must be between 3 and 32 characters!')]")
    public WebElement telRequired;

    @FindBy(xpath = "//div[contains(text(),'Password must be between 4 and 20 characters!')]")
    public WebElement passRequired;

    @FindBy(xpath = "//div[contains(text(),'Password confirmation does not match password!')]")
    public WebElement passMismatch;

    public void setFirstName(String firstName) {
        fname.sendKeys(firstName);
    }

    public void setLastName(String lastName) {
        lname.sendKeys(lastName);
    }

    public void setEmail(String email) {
        this.email.sendKeys(email);
    }

    public void setTelephone(String telephone) {
        this.telephone.sendKeys(telephone);
    }

    public void setPassword(String password) {
        this.password.sendKeys(password);
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword.sendKeys(confirmPassword);
    }

    public void acceptPrivacyPolicy() {
        privacyPolicy.click();
    }

    public void submitForm() {
        btnContinue.click();
    }

    public String getSuccessMessage() {
        return getElementText(successMessage);
    }

    public String getFirstNameAlert() {
        return getElementText(fNameRequired);
    }

    public String getLastNameAlert() {
        return getElementText(lNameRequired);
    }

    public String getEmailAlert() {
        return getElementText(emailRequired);
    }

    public String getTelephoneAlert() {
        return getElementText(telRequired);
    }

    public String getPasswordAlert() {
        return getElementText(passRequired);
    }

    public String getPasswordMismatchAlert() {
        return getElementText(passMismatch);
    }

    private String getElementText(WebElement element) {
        try {
            return element.getText();
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}
