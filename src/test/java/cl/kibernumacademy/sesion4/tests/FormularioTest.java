package cl.kibernumacademy.sesion4.tests;

import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import cl.kibernumacademy.sesion4.pages.FormularioPage;
import io.github.bonigarcia.wdm.WebDriverManager;

@TestInstance(TestInstance.Lifecycle.PER_CLASS) // Para que @BeforeAll funcione correctamente
@DisplayName("Pruebas del Formulario de DemoQA")
public class FormularioTest {

    private WebDriver driver;
    private FormularioPage formularioPage;
    private final String baseUrl = "https://demoqa.com/automation-practice-form";

    @BeforeAll
    void setupClass() {
        WebDriverManager.chromedriver().setup(); // Descarga el chrome driver a utilizar
    }

    @BeforeEach
    void setupTest() {
        System.out.println(">>> BeforeEach ejecutándose");// debugg
        driver = new ChromeDriver(); // Inicializa el navegador
        driver.manage().window().maximize();// Maximiza la pantalla
        driver.get(baseUrl); // Navega a la URL del formulario
        cerrarBanner();
        formularioPage = new FormularioPage(driver); // Inicializa nuestro Page Object

    }

    @AfterEach
    void tearDown() {
        if (driver != null) {
            driver.quit(); // Cierra el navegador después de cada prueba
        }
    }

    private void cerrarBanner() {
        // Elimina el banner usando JavaScript
        ((JavascriptExecutor) driver)
                .executeScript("document.getElementById('fixedban')?.remove();");
    }

    @Test
    @DisplayName("Validar que el formulario se envía correctamente")
    void testFormularioEnvio() {
        String firstName = "Laura";
        String lastName = "Rodríguez";
        String email = "laura@test.com";
        String mobile = "987654321";
        String gender = "Female";
        String address = "Calle Falsa 123";
        String[] hobbies = { "Reading", "Music" };
        String state = "NCR";
        String city = "Delhi";

        // Completar el formulario con datos de prueba
        formularioPage.setFirstName(firstName);
        formularioPage.setLastName(lastName);
        formularioPage.setEmail(email);
        formularioPage.selectGender(gender);
        formularioPage.setPhoneNumber(mobile);
        formularioPage.selectHobbies(hobbies);
        // Aca van los hobbies
        formularioPage.setAddress(address);
        formularioPage.selectState(state);
        formularioPage.selectCity(city);

        // 3) VALIDAR 3 CAMPOS (nombre, apellido y email)
        Assertions.assertAll("Verificar nombre, apellido y email",
                () -> Assertions.assertEquals(firstName,
                        formularioPage.getFirstNameValue(),
                        "First Name no coincide"),
                () -> Assertions.assertEquals(lastName,
                        formularioPage.getLastNameValue(),
                        "Last Name no coincide"),
                () -> Assertions.assertEquals(email,
                        formularioPage.getEmailValue(),
                        "Email no coincide"));
        System.out.println("Validaciones completadas para: nombre, apellido y email");

    }
}
