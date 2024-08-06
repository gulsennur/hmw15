package com.rd.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
public class ClickButtonTest {
    private WebDriver driver;

    @BeforeClass
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");
        driver = new ChromeDriver();
    }

    @Test
    public void testClickButton() {
        driver.get("https://demoqa.com/elements");

        // "Buttons" seçeneğini tıklayın
        WebElement buttonsOption = driver.findElement(By.xpath("//div[text()='Buttons']/.."));
        buttonsOption.click();

        // "Click Me" düğmesini tıklayın
        WebElement clickMeButton = driver.findElement(By.xpath("//button[text()='Click Me']"));
        clickMeButton.click();

        // Görünen mesajın doğru olup olmadığını kontrol edin
        WebElement message = driver.findElement(By.id("dynamicClickMessage"));
        String expectedMessage = "You have done a dynamic click";
        Assert.assertEquals(message.getText() , expectedMessage);
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
