package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.SimpleDateFormat;
import java.util.Date;



public class KinopoiskTest extends AbstractTest{

    @Test
    @Tag("Positive")
    public void top250Test() {
        getDriver().findElement(By.xpath(".//div[starts-with(@class, 'styles_root')]/a[@href='/lists/films/1/']")).click();

        getDriver().findElement(By.xpath(".//span[contains(text(), '250 лучших фильмов')]")).click();
        getDriver().findElement(By.xpath(".//span[contains(text(), 'Все годы')]")).click();

        WebDriverWait ulWait = new WebDriverWait(getDriver(), 30);
        ulWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(".//div[@class='selections-select__dropdown-wrapper']")));
        getDriver().findElement(By.linkText("2021")).click();

        Assertions.assertTrue(getDriver().findElement(By.xpath(".//a[@href = '/film/1309570/']/p[1]")).getText().equals("Человек-паук: Нет пути домой")); //Лучший фильм года
    }

    @Test
    @Tag("Positive")
    public void searchTest() {

        getDriver().findElement(By.xpath(".//input[@placeholder='Фильмы, сериалы, персоны']")).sendKeys("Куда приводят мечты", Keys.ENTER);

        getDriver().findElement(By.xpath(".//a[contains(text(), 'Куда приводят мечты')]")).click();

        Assertions.assertTrue(getDriver().findElement(By.xpath(".//h1/span")).getText().equals("Куда приводят мечты (1998)")); //Сверяем название фильма
    }

    @Test
    @Tag("Dynamic")
    public void lastNewsTest() {
        getDriver().findElement(By.xpath(".//div[starts-with(@class, 'styles_root')]/a[@href='/media/']")).click();
        getDriver().findElement(By.xpath(".//a[@href='/media/news/'][contains(text(), 'Новости')]")).click();
        getDriver().findElement(By.xpath(".//div[@class = 'posts-grid__main-section']/div/div[1]/div/div/a")).click(); //открываем первую новость в списке

        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        Assertions.assertTrue(getDriver().findElement(By.xpath(".//span[@class = 'media-news__published-date']")).getAttribute("content").equals(dateFormat.format(date)));
        //Сравнение даты последней новости с текущим днем. Если последняя новость сегодняшняя тест проходит, если последняя новость вчерашняя - нет. Копирайтеры должны быстрее работать
    }

    @Test
    @Tag("Positive")
    public void boxCheckTest() {
        getDriver().findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.END);


        getDriver().findElement(By.xpath(".//a[text()='Кассовые сборы']")).click();

        getDriver().findElement(By.xpath(".//select[@name='year']")).click();
        getDriver().findElement(By.xpath(".//option[@value='2021']")).click();
        getDriver().findElement(By.xpath(".//a[starts-with(@onclick, 'document.form_box_year.submit')]")).click();

        Assertions.assertTrue(getDriver().findElement(By.xpath(".//h1/span[2]")).getText().equals("2021 год")); //Сверяем год статистики кассовых сборов

    }

    @Test
    @Tag("Negative")
    public void loginTest() throws InterruptedException {
        getDriver().findElement(By.xpath(".//button[text() = 'Войти']")).click();
        getDriver().findElement(By.xpath(".//input[@name = 'login']")).sendKeys("testid", Keys.ENTER);
        getDriver().findElement(By.xpath(".//input[@name = 'passwd']")).sendKeys("passwd", Keys.ENTER);

        Thread.sleep(100); //время на авторизацию
        //Тестируем неверный ввод данных
        Assertions.assertTrue(getDriver().findElement(By.xpath(".//div[@id = 'field:input-passwd:hint']")).getText().equals("Неверный пароль"));
    }

    @Test
    @Tag("Positive")
    public void watchTheaterTrailerTest() {

        getDriver().findElement(By.xpath(".//nav/a[text() = 'Онлайн-кинотеатр']")).click();
        getDriver().findElement(By.xpath(".//button[starts-with(@class, 'HeaderContent__search-button')]")).click();
        getDriver().findElement(By.xpath(".//input[@type = 'search']")).sendKeys("Французский вестник");
        WebDriverWait ulWait = new WebDriverWait(getDriver(), 30);
        ulWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(".//p[text() = 'Французский вестник. Приложение к газете «Либерти. Канзас ивнинг сан»']")));
        getDriver().findElement(By.xpath(".//div[starts-with(@class, 'SuggestList__content')]/div/a")).click();
        getDriver().findElement(By.xpath(".//button[@name = 'Trailer']")).click();

        Assertions.assertTrue(getDriver().findElement(By.xpath(".//h1/span")).getText().equals("Французский вестник. Приложение к газете «Либерти. Канзас ивнинг …")); //Сверяем год статистики кассовых сборов

    }

}
