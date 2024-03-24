package manager;

import org.openqa.selenium.By;

public interface HelperStudent extends HelperBase{
    By fieldFirstName = By.id("firstName");
    By fieldLastName = By.id("lastName");
    By fieldEmail = By.cssSelector("input[placeholder='name@example.com']");

    By fieldMobileNumber = By.id("userNumber");
    By fieldDateOfBirth = By.id("dateOfBirthInput");
    By fieldSubject = By.id("subjectsInput");
    By checkBoxSport = By.id("hobbies-checkbox-1");
    By checkBoxReading = By.id("hobbies-checkbox-2");
    By checkBoxMusic = By.id("hobbies-checkbox-3");

}
