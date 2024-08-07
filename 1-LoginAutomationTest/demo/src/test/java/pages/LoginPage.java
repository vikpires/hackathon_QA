package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver){
        super(driver);            
    }
    public void clickLogin(String id){
        this.driver.findElement(By.id(id)).click();
    }
    public void enterUsername(String id, String username){
        this.driver.findElement(By.id(id)).sendKeys(username);
    }
    public void enterPassword(String xpath, String password){
        this.driver.findElement(By.xpath(xpath)).sendKeys(password.isEmpty() ? "" : password);
    }
    public void clickLoginButton(String xpath){
        this.driver.findElement(By.xpath(xpath)).click();
    }
    public boolean validateErrorMessage(String errorMessage){
        return driver.getPageSource().contains(errorMessage);
    }  
    public boolean isRightPage(String expectedUrl){
        return driver.getCurrentUrl().equals(expectedUrl);
    }   
}
