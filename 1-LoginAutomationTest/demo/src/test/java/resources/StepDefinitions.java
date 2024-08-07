package resources;
import static org.junit.Assert.assertTrue;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.LoginPage;
import support.Web;

public class StepDefinitions {

    private WebDriver driver;
    private HomePage homePage;
    private LoginPage loginPage;

    @Before
    public void setUp(){
        driver = Web.createFirefox();
    }

    @Given("User is on Homepage")
    public void user_is_on_homepage() {
        this.homePage = new HomePage(driver);
    }
    @When("User clicks on login link")
    public void user_clicks_on_login_link() {
        homePage.clickLogin("btn-0");
    }
    @When("User is redirected to the login page")
    public void user_is_redirected_to_the_login_page(){
        this.loginPage = new LoginPage(driver); 
        assertTrue(loginPage.isRightPage("https://homero.app.br/login"));       
    }
    @When("User enters a valid username on username field")
    public void user_enters_a_valid_username_on_username_field() {
        loginPage.enterUsername("username-input", "test@teste.com");        
    }
    @When("User doesn't fill the password on password field")
    public void user_doesn_t_fill_the_password_on_password_field() {
        loginPage.enterPassword("/html/body/div[1]/main/section/div/section[1]/div/form/div[1]/div[2]/div[1]/input", "");        
    }
    @When("User clicks on the login button")
    public void user_clicks_on_the_login_button() {
        loginPage.clickLoginButton("/html/body/div[1]/main/section/div/section[1]/div/form/div[2]/button");        
    }
    @Then("User should get an error message")
    public void user_should_get_an_error_message() {
        assertTrue(loginPage.validateErrorMessage("Esse campo é obrigatório"));        
    }
    @After
    public void tearDown(){
        driver.quit();
    }
}
