package StepDefinitions;


import Pages.Objects;
import Utilities.GWD;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.IOException;

public class TeacherLoginSteps {
    Objects objects=new Objects();

    @Given("Navigate to Campus")
    public void navigateToCampus() {
        GWD.getDriver().get("https://test.mersys.io/");
    }

    @When("Enter username and password and click login button")
    public void enterUsernameAndPasswordAndClickLoginButton() throws IOException {

        String path="src/test/java/ExcelData/Campus_Data.xlsx";

        FileInputStream inputStream=new FileInputStream(path);
        Workbook workbook= WorkbookFactory.create(inputStream);
        Sheet sheet=workbook.getSheetAt(0);

        String userName=String.valueOf(sheet.getRow(1).getCell(0));
        String password= String.valueOf(sheet.getRow(1).getCell(1));

      //  objects.sendKeysFunction(objects.username, userName);
      //  objects.sendKeysFunction(objects.password,password);
      //  objects.clickFunction(objects.loginButton);
    }

    @Then("User should login succesfully")
    public void userShouldLoginSuccesfully() {
      //  objects.verifyContainsTextFunction(objects.txtTechnoStudy,"Techno Study");
    }
}
