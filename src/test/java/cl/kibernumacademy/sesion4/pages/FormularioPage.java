package cl.kibernumacademy.sesion4.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FormularioPage {

    private WebDriver driver;
    private WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    // Localizador para el campo nombre buscando por su id (es de tipo input)
    private By firstName = By.id("firstName");
    // Localizador para el campo apellido buscando por su id (es de tipo input)
    private By lastName = By.id("lastName");
    // Localizador para el campo email buscando por su id (es de tipo input)
    private By email = By.id("userEmail");
    // Localizador para el campo número telefónico por su id
    private By phoneNumber = By.id("userNumber");
    // Localizador para el campo cumpleaños por su id
    private By dateOfBirth = By.id("dateOfBirthInput");
    // Localizador para el campo dirección por su id
    private By address = By.id("currentAddress");
    // Localizador para el campo state por su id
    private By state = By.id("state");
    // Localizador para el campo city por su id
    private By city = By.id("city");

    public FormularioPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(5));
    }

    public void setFirstName(String name) {
        driver.findElement(firstName).clear();
        driver.findElement(firstName).sendKeys(name);
    }

    public void setLastName(String lName) {
        driver.findElement(lastName).clear();
        driver.findElement(lastName).sendKeys(lName);
    }

    public void setEmail(String emailAddress) {
        driver.findElement(email).clear();
        driver.findElement(email).sendKeys(emailAddress);
    }

    public void setPhoneNumber(String phone) {
        driver.findElement(phoneNumber).clear();
        driver.findElement(phoneNumber).sendKeys(phone);
    }

    public void setAddress(String addr) {
        driver.findElement(address).clear();
        driver.findElement(address).sendKeys(addr);
    }

    public void selectState(String value) {
        // Se abre la lista desplegable
        WebElement stateInput = driver.findElement(By.id("react-select-3-input"));
        stateInput.sendKeys(value);
        stateInput.sendKeys(Keys.ENTER);
    }

    public void selectCity(String value) {
        // Se abre la lista desplegable
        WebElement cityInput = driver.findElement(By.id("react-select-4-input"));
        cityInput.sendKeys(value);
        cityInput.sendKeys(Keys.ENTER);
    }

    public void selectGender(String gender) {
        driver.findElement(By.xpath("//label[text()='" + gender + "']")).click();
    }

    // Pido como parámetro un arreglo para luego recorrerlo y así buscar por el
    // xpath el label correspondiente
    public void selectHobbies(String[] hobbies) {
        for (String hobby : hobbies) {
            By locator = By.xpath("//label[@class='custom-control-label' and text()='" + hobby + "']");
            // Lo que hace es que espera a que al elemento se le haga click
            wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
        }
    }

}
