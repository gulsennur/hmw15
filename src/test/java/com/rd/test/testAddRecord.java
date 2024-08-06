package com.rd.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
public class testAddRecord {
    @Test
    public void testAddRecord() {
        WebDriver driver = new ChromeDriver();

        driver.get("https://demoqa.com/webtables");
        driver.findElement(By.xpath("//button[text()='Add']")).click();

        // Add a new record
        driver.findElement(By.xpath("//input[@id='firstName']")).sendKeys("John");
        driver.findElement(By.xpath("//input[@id='lastName']")).sendKeys("Doe");
        driver.findElement(By.xpath("//input[@id='userEmail']")).sendKeys("johndoe@example.com");
        driver.findElement(By.xpath("//input[@id='age']")).sendKeys("30");
        driver.findElement(By.xpath("//input[@id='salary']")).sendKeys("50000");
        driver.findElement(By.xpath("//input[@id='department']")).sendKeys("IT");
        driver.findElement(By.xpath("//button[text()='Submit']")).click();

        // Edit the record
        driver.findElement(By.xpath("//td[text()='John']//following-sibling::td[1]/span[text()='edit']")).click();
        driver.findElement(By.xpath("//input[@id='firstName']")).clear();
        driver.findElement(By.xpath("//input[@id='firstName']")).sendKeys("Jane");
        driver.findElement(By.xpath("//button[text()='Save']")).click();

        // Verify if record is edited
        String editedFirstName = driver.findElement(By.xpath("//td[text()=' Jane']")).getText();
        Assert.assertEquals(editedFirstName, "Jane");

        driver.quit();
    }
}
