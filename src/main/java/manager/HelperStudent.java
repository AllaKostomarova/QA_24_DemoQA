package manager;

import models.StudentDTO;
import org.openqa.selenium.*;

public interface HelperStudent extends HelperBase{
    By fieldFirstName = By.id("firstName");
    By fieldLastName = By.id("lastName");
    By fieldEmail = By.cssSelector("input[placeholder='name@example.com']");
    By fieldMobileNumber = By.id("userNumber");
    By fieldDateOfBirth = By.id("dateOfBirthInput");
    By fieldSubject = By.id("subjectsInput");
    By checkBoxSport = By.xpath("//label[@for='hobbies-checkbox-1']");
    // By.id("hobbies-checkbox-1");
    By checkBoxReading =By.xpath("//label[@for='hobbies-checkbox-2']");
    //By.id("hobbies-checkbox-2");
    By checkBoxMusic = By.xpath("//label[@for='hobbies-checkbox-3']");
    //By.id("hobbies-checkbox-3");
    By fieldCurrentAddress = By.id("currentAddress");
    By radioBtnMale = By.xpath("//label[@for='gender-radio-1']");
    By radioBtnFemale = By.xpath("//label[@for='gender-radio-2']");
    By radioBtnOther = By.xpath("//label[@for='gender-radio-3']");
    By dropDownListSelectState = By.id("react-select-3-input");
    By dropDownListSelectCity = By.id("react-select-4-input");

    //---------------------
    By btnForms = By.xpath("//div[@class='category-cards']/div[2]");
    By btnPracticeForm = By.xpath("//span[text()='Practice Form']");
    By btnSubmit = By.id("submit");

    //------------------------
    By titleSubmitForm = By.id("example-modal-sizes-title-lg");

    //------------------------
    By studentEmail = By.xpath("//tbody/tr[2]/td[2]");
    By studentMobile = By.xpath("//tbody/tr[4]/td[2]");
    By btnClose = By.id("closeLargeModal");

    default void selectPracticeForm(){
        clickBase(btnForms);
        hideFooter();
        clickBase(btnPracticeForm);
    }

    default void fillStudentForm(StudentDTO student){
        typeBase(fieldFirstName, student.getFirstName());
        typeBase(fieldLastName, student.getLastName());
        typeBase(fieldEmail, student.getEmail());
        selectGender(student.getGender());
        typeBase(fieldMobileNumber, student.getMobile());
        typeBDayKeys(student.getDateOfBirth());
        addSubjects(student.getSubjects());
        selectHobby(student.getHobbies());
        typeBase(fieldCurrentAddress, student.getAddress());
        typeState(student.getState());
        typeCity(student.getCity());
    }

    default void clickBtnSubmit(){
        clickBase(btnSubmit);
    }

    default void typeCity(String city){
        WebElement selectState = wd.findElement(dropDownListSelectCity);
        selectState.sendKeys(city);
    }

    default void typeState (String state){
        WebElement selectState = wd.findElement(dropDownListSelectState);
//        selectState.click();// --> only  type
        selectState.sendKeys(state);
        selectState.sendKeys(Keys.ENTER);
    }

    default void selectHobby(String hobbies){
        //Sports -- Reading -- Music
        String[] splitArray = hobbies.split(",");
        for (String str: splitArray) {
            switch (str) {
                case "Sports":
                    clickBase(checkBoxSport);
                    break;
                case "Reading":
                    clickBase(checkBoxReading);
                    break;
                case "Music":
                    clickBase(checkBoxMusic);
                    break;
            }
        }

    }

    default void addSubjects(String subjects){
        //subjects("Maths,Physics,Arts")
        String[] splitArray = subjects.split(",");
        WebElement fieldSubj = wd.findElement(fieldSubject);
        fieldSubj.click();
        for (String sub: splitArray) {
            fieldSubj.sendKeys(sub);
            fieldSubj.sendKeys(Keys.ENTER);
        }
    }

    default void typeBDayKeys(String dateOfBirth){
        WebElement fieldBDay = wd.findElement(fieldDateOfBirth);
        fieldBDay.click();
        String operationSystem = System.getProperty("os.name");
        if(operationSystem.startsWith("Win")){
            fieldBDay.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        } else if (operationSystem.startsWith("Mac")) {
            fieldBDay.sendKeys(Keys.chord(Keys.COMMAND, "a"));
        }
        fieldBDay.sendKeys(dateOfBirth);
        fieldBDay.sendKeys(Keys.ENTER);
    }

    default void selectGender(String gender){
        switch (gender){
            case "Male":
                clickBase(radioBtnMale);
                break;
            case "Female":
                clickBase(radioBtnFemale);
                break;
            case  "Other":
                clickBase(radioBtnOther);
        }
    }

    default boolean isElementPresent_titleSubmitForm(){
        return isElementPresent(titleSubmitForm);
    }

    default boolean isEmailFromFormEqualsTo(String email){
        return isElementEqualsTo(studentEmail, email);
    }

    default boolean isMobileFromFormEqualsTo(String phone){
        return isElementEqualsTo(studentMobile, phone);
    }

    default void clickCloseForm(){
        clickBase(btnClose);
    }



}
