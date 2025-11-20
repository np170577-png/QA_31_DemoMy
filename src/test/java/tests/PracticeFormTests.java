package tests;

import dto.Student;
import enams.Gender;
import manager.AppManager;
import org.testng.annotations.Test;
import pages.FormsPage;
import pages.HomePage;
import pages.PracticeFormPage;

public class PracticeFormTests extends AppManager {

    @Test
    public void studentRegFormPositiveTest() {
        Student student = new Student("Vasya", "Vasilev", "vasia@gmail.com",
                 Gender.MALE,"0123456789", "23 Dec 2005", "Maths, Physics, Chemistry",
                "Sports", "address1", "NCR", "Delhi");
        new HomePage(getDriver()).clickBtnForms();
        new FormsPage(getDriver()).clickBtnPracticeForm();
        new PracticeFormPage(getDriver()).typePracticeForm(student);
    }
}
