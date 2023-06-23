package Pages;

import Utilities.GWD;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Objects extends Parent {

    public Objects(){
        PageFactory.initElements(GWD.getDriver(),this);
    }

   // @FindBy(xpath="//ms-add-button[contains(@tooltip,'ADD')]//button")
   // public WebElement addButton;

    @FindBy(css = "input[formcontrolname='username']")
    public WebElement username;
    @FindBy(css = "input[formcontrolname='password']")
    public WebElement password;
    @FindBy(css = "span[class='logo-text ng-star-inserted']")
    public WebElement textTechnoStudy;
    @FindBy(css = "button[aria-label='LOGIN']")
    public WebElement loginButton;








    public WebElement getWebElement(String strButton){
        switch (strButton)
        {
            //case "addButton" : return addButton;
            case "username":
                return username;
            case "password":
                return password;
            case "textTechnoStudy":
                return textTechnoStudy;
        }
        return null;
    }

    public void deleteItem(String searchText){
        //sendKeysFunction(searchInput,searchText);
        //clickFunction(searchButton);

       /* wait.until(ExpectedConditions.numberOfElementsToBe(By.xpath("//fuse-progress-bar/*") , 0));

        clickFunction(deleteImageBtn);
        clickFunction(deleteDialogBtn);  */

    }


}
