package tests;

import manager.HelperStudent;
import models.StudentDTO;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class StudentFormTests extends TestBase implements HelperStudent {
    SoftAssert softAssert = new SoftAssert();

    @BeforeClass
    public void goToPracticeForm(){
        hideBanner();
        hideFooter();
        selectPracticeForm();
    }

    @AfterMethod
    public void postCondition(){
        pause(3);
        if(isElementPresent_titleSubmitForm())
            clickCloseForm();
        else{
            wd.navigate().refresh();
            hideBanner();
            hideFooter();
        }
    }

    @Test
    public void studentFormPositiveTest(){
        StudentDTO student = StudentDTO.builder()
                .firstName("Or")
                .lastName("Ory")
                .email("ory@mail.ru")
                .gender("Male")
                .mobile("1234567890")
                .dateOfBirth("16 Aug 2005")
                .subjects("Maths,Physics,Arts")
                .hobbies("Reading,Sports")
                .address("Str Art, app 3")
                .state("NCR")
                .city("Gurgaon")
                .build();
        fillStudentForm(student);
        clickBtnSubmit();
        softAssert.assertTrue(isElementPresent_titleSubmitForm());
        softAssert.assertTrue(isEmailFromFormEqualsTo(student.getEmail()));
        softAssert.assertTrue(isMobileFromFormEqualsTo(student.getMobile()));
        
    }

    @Test
    public void studentFormNegativeTest_WrongLastNameEmpty(){
        StudentDTO student = StudentDTO.builder()
                .firstName("Or")
                .lastName("")
                .email("ory2@mail.ru")
                .gender("Male")
                .mobile("1234567899")
                .dateOfBirth("16 Aug 2005")
                .subjects("Maths,Physics,Arts")
                .hobbies("Reading,Sports")
                .address("Str Art, app 3")
                .state("NCR")
                .city("Gurgaon")
                .build();
        fillStudentForm(student);
        clickBtnSubmit();
        Assert.assertFalse(isElementPresent_titleSubmitForm());
    }
}
