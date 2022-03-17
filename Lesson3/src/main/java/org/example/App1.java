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

/**
 * Hello world!
 *
 */
public class App1
{
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

        WebElement webElement = driver.findElement(By.cssSelector("#header-nav-container > div > div.Grid-sc-1kcyc0j-0.sc-gisBJw.fFjBkU > div > div.Flex-sc-1sqrs56-0.sc-ksYbfQ.bqZqZl > button > svg"));
        webElement.click();

        driver.findElement(By.id("header-search-bar")).sendKeys("Russia");
        driver.findElement(By.id("header-search-bar")).submit();

        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(webElement));

        driver.quit();
    }
}
