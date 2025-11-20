package pages;

import dto.Student;
import enams.Gender;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class PracticeFormPage extends BasePage {
    public PracticeFormPage(WebDriver driver) {
        setDriver(driver);
        PageFactory.initElements
                (new AjaxElementLocatorFactory(driver,
                        10), this);
    }

    @FindBy(xpath = "//input[@placeholder='First Name']")
    WebElement inputName;
    @FindBy(id = "lastName")
    WebElement inputLastName;
    @FindBy(id = "userEmail")
    WebElement inputEmail;
    @FindBy(id = "userNumber")
    WebElement inputMobile;
    @FindBy(id = "dateOfBirthInput")
    WebElement dateOfBirthField;


    public void typePracticeForm(Student student){
       hideBanner();
       hideFooter();
       inputName.sendKeys(student.getName());
       inputLastName.sendKeys(student.getLastName());
       inputEmail.sendKeys(student.getEmail());
       typeGender(student.getGender());
       inputMobile.sendKeys(student.getMobile());
       typeDateOfBirth(student.getDateOfBirth());
    }

    private void typeGender(Gender gender){
        WebElement btnGender = driver.findElement(By.xpath(gender.getLocator()));
        btnGender.click();
    }
    private void typeDateOfBirth(String dateOfBirth){
        dateOfBirthField.click();
        String operationSystem = System.getProperty("os.name");
        System.out.println(operationSystem);
        if (operationSystem.startsWith("Win"))
            dateOfBirthField.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        else if (operationSystem.startsWith("Mac"))
            dateOfBirthField.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        dateOfBirthField.sendKeys(dateOfBirth);
        dateOfBirthField.sendKeys(Keys.ENTER);
    }
}
