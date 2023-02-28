package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

import java.util.List;

public class SmartBearHomePage {

    public SmartBearHomePage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(css = "ul[id=\"ctl00_menu\"]>li")
    public List<WebElement> menuBar;

    @FindBy(id = "ctl00_MainContent_btnCheckAll")
    public WebElement checkAll;



}
