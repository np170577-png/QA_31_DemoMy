package experiments;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class XpathSelectors {
    WebDriver driver = new ChromeDriver();

    @Test
    public void selectorsRadioButtonPage() {
        driver.get("https://demoqa.com/radio-button");
        driver.manage().window().maximize();
        pause(3);
//        WebElement radioButtonYes = driver.findElement(By
//                .cssSelector("label[for='yesRadio']"));
        WebElement radioButtonYes = driver.findElement(By
                .xpath("//label[@for='yesRadio']"));
        radioButtonYes.click();
        pause(3);
        WebElement radioButtonImpressive = driver.findElement(By
                .xpath("//*[@for='impressiveRadio']"));
        radioButtonImpressive.click();
        pause(3);
        WebElement btnTextBox = driver.findElement(By
                .xpath("//span[text()='Text Box']"));
        btnTextBox.click();
        WebElement fieldFullName = driver.findElement(By
                .xpath("//input[@placeholder='Full Name']"));
        fieldFullName.sendKeys("Sveta");
        WebElement fieldEmail = driver.findElement(By
                .xpath("//input[@id='userEmail']"));
        fieldEmail.sendKeys("sveta123@gmail.com");
        WebElement textareaCurAddress = driver.findElement(By
                .xpath("//*[text()='Current Address']" +
                        "/../..//textarea"));
        textareaCurAddress.sendKeys("street 1");
        WebElement textareaPerAddress = driver.findElement(By
                .xpath("//div[@id='permanentAddress-wrapper']//textarea"));
        textareaPerAddress.sendKeys("avenue 1");
        WebElement btnSubmit = driver.findElement(By
                .xpath("//button[text()='Submit']"));
        btnSubmit.click();
        WebElement output = driver.findElement(By.id("output"));
        System.out.println(output.getText());

        pause(3);
        driver.quit();
    }

    public void pause(int time) {
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void hideBanner() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.querySelector('#fixedban').style.display='none'");
    }

    public void hideFooter() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.querySelector('footer').style.display='none'");
    }

}
