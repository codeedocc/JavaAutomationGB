package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class App3 {
    public static void main( String[] args )
    {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("--incognito");
        options.addArguments("disable-popup-blocking");

        WebDriver driver = new ChromeDriver(options);

        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        driver.get("https://edition.cnn.com/");

        WebElement world = driver.findElement(By.xpath("//div[@class='Flex-sc-1sqrs56-0 sc-ksYbfQ hLlTdB']/nav/ul/li/a[@href='/world']"));
        world.click();

        WebElement africa = driver.findElement(By.xpath("//div[@class=\"Flex-sc-1sqrs56-0 sc-ksYbfQ hLlTdB\"]/nav/ul/li[@class=\"sc-kAzzGY gSIjYi\"]"));
        africa.click();

        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(world));
        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(africa));

        driver.quit();
    }
}
