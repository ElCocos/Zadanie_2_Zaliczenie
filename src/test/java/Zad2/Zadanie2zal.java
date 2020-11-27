package Zad2;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class Zadanie2zal {

    private WebDriver driver;


    @Given("open browser and login")
    public void setUp() {
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://prod-kurs.coderslab.pl/index.php");

        WebElement signIn = driver.findElement(By.xpath("//*[@id=\"_desktop_user_info\"]/div/a"));
        signIn.click();


        WebElement inputEmail = driver.findElement(By.name("email"));
        inputEmail.clear();
        inputEmail.sendKeys("cv@v.pl");


        WebElement inputPassword = driver.findElement(By.name("password"));
        inputPassword.clear();
        inputPassword.sendKeys("12345678");
        inputPassword.submit();

        //  WebElement clickSingIn = driver.findElement(By.xpath("//*[@id=\"content\"]/div[2]/a/span"));
        //  clickSingIn.click();
    }

    @When("select Hummingbird Printed Sweater")
    public void selectSweater() {

        WebElement serchItem = driver.findElement(By.name("s"));
        serchItem.sendKeys("Hummingbird Printed Sweater");
        serchItem.submit();
        WebElement selectedProduct = driver.findElement(By.xpath("//*[@id=\"js-product-list\"]//article//*[@class='product-description']//a[text()[contains(.,'Hummingbird printed sweater')]]"));
        selectedProduct.click();

    }

    @And("select size and take 5 to cart")
    public void selectSize() {

        WebElement size = driver.findElement(By.id("group_1"));

        size.sendKeys("L");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement quantity = driver.findElement(By.id("quantity_wanted"));
        quantity.clear();
        quantity.sendKeys("5");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement addToCart = driver.findElement(By.cssSelector(".btn.btn-primary.add-to-cart"));
        addToCart.click();
    }
    @And("go to checkout")
    public void goToCheckout() {

        WebElement proceedToCheckout = driver.findElement(By.cssSelector("#blockcart-modal > div > div > div.modal-body > div > div.col-md-7 > div > div > a"));
        proceedToCheckout.click();

        WebElement goCheckout = driver.findElement(By.cssSelector("#main > div > div.cart-grid-right.col-xs-12.col-lg-4 > div.card.cart-summary > div.checkout.cart-detailed-actions.card-block > div > a"));
        goCheckout.click();
    }

    @And ("confirm address")
    public void confirmAddress() {

        WebElement addressConfirm = driver.findElement(By.name("confirm-addresses"));
        addressConfirm.click();

        }

    @And ("select pick up in store")
    public void pickUp() {


        WebElement paymentConfirm = driver.findElement(By.name("confirmDeliveryOption"));
        paymentConfirm.click();

    }

    @Then("pay method")
    public void payMetod() {


        WebElement paymentChoise = driver.findElement(By.id("payment-option-1"));
        paymentChoise.click();

        WebElement birdClic = driver.findElement(By.id("conditions_to_approve[terms-and-conditions]"));
        birdClic.click();

        WebElement buttonAprove = driver.findElement(By.cssSelector(".btn.btn-primary.center-block"));
        buttonAprove.click();
    }



    @And("take screen shot")
    public void screenProof()  {

        TakesScreenshot scrShot = ((TakesScreenshot)driver);
        File srcFile = scrShot.getScreenshotAs(OutputType.FILE);
        File destFile = new File("src/main/resources/screenshots/foto.png");

    }
    }



