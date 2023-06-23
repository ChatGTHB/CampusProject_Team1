package StepDefinitions;


import Pages.Objects;
import io.cucumber.java.en.When;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.IOException;

public class StudentLoginSteps {
    Objects objects = new Objects();

    @When("Enter valid student username and password then click login button")
    public void enterValidStudentUsernameAndPasswordThenClickLoginButton() throws IOException {
        String path = "src/test/java/ExcelData/Campus_Data.xlsx";

        FileInputStream inputStream = new FileInputStream(path);
        Workbook workbook = WorkbookFactory.create(inputStream);
        Sheet sheet = workbook.getSheetAt(0);

        String username = String.valueOf(sheet.getRow(2).getCell(0));
        String password = String.valueOf((int) sheet.getRow(2).getCell(1).getNumericCellValue());

        objects.sendKeysFunction(objects.username, username);
        objects.sendKeysFunction(objects.password, password);
        objects.clickFunction(objects.loginButton);
    }
}
