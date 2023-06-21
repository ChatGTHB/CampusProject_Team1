package StepDefinitions;

import Pages.Objects;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import org.openqa.selenium.WebElement;

import java.util.List;

public class DataTableSteps {

    Objects objects=new Objects();
    @And("Click on the element")
    public void clickOnTheElement(DataTable items) {
       List<String> strButtons=items.asList(String.class);

       for (String strButton: strButtons) {
           WebElement element=objects.getWebElement(strButton);
           objects.clickFunction(element);
       }
    }

    @And("User sending the keys")
    public void userSendingTheKeys(DataTable dt) {
        List< List<String> > items= dt.asLists(String.class);

        for (int i = 0; i < items.size(); i++) {
            WebElement element= objects.getWebElement(items.get(i).get(0));
            objects.sendKeysFunction(element, items.get(i).get(1));
        }
    }


    @And("User delete item")
    public void userDeleteItem(DataTable dt) {
        List<String> strButtons=dt.asList(String.class);

        for (String strDeleteText: strButtons) {
            objects.deleteItem(strDeleteText);
        }
    }


}
