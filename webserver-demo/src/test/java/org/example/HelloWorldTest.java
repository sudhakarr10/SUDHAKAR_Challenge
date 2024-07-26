package com.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HelloWorldTest {
    private static WebDriver driver;
    private static String baseUrl;

    @BeforeAll
    public static void setUp() {
        // This will automatically download and setup the appropriate ChromeDriver version

        WebDriverManager.chromedriver().clearDriverCache().setup();
        WebDriverManager.chromedriver().clearResolutionCache().setup();
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");  // Ensure GUI is off
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");

        driver = new ChromeDriver(options);
        baseUrl = "http://localhost:8080";
    }

    @AfterAll
    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testHttpsRedirection() {
        driver.get("http://localhost:8080");
        assertTrue(driver.getCurrentUrl().startsWith(baseUrl), "Failed to redirect to HTTPS");
    }

    @Test
    public void testHelloWorldPage() {
        driver.get(baseUrl);
        String bodyText = driver.findElement(By.tagName("h1")).getText();
        assertEquals("Hello World!", bodyText, "Hello World! text not found");
    }
}