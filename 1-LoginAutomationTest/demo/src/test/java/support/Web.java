package support;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Web {
    public static WebDriver createFirefox(){
        WebDriver driver = new FirefoxDriver();
        driver.get("https://homero.app.br/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)).pageLoadTimeout(Duration.ofSeconds(10));
        return driver;    
    }    
}
