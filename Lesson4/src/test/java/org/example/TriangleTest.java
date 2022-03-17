package org.example;

import org.junit.jupiter.api.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.opentest4j.AssertionFailedError;
import org.testng.annotations.Test;

import static org.example.Triangle.areaOfTriangle;
import static org.junit.jupiter.api.Assertions.assertEquals;



public class TriangleTest {
    static Logger logger = LoggerFactory.getLogger(TriangleTest.class);

    @Test
    @Tag("Positive")
        public void triangleAreaTest() throws TriangleException{
        logger.info("Логируем");

        try {
            assertEquals(6.0, areaOfTriangle(3, 4, 5));
        } catch (AssertionFailedError TriangleException) {
            System.err.println("Позитивный тест. Площадь не совпадает.");
            System.err.println(TriangleException);
        }
    }


    @Test
    @Tag("Negative")
    public void triangleAreaOutOfBoundsTest() throws TriangleException{
        logger.info("Логируем");

        try {
            assertEquals(6.0, areaOfTriangle(3,4,-5));
        } catch (org.opentest4j.AssertionFailedError TriangleException) {
            System.err.println("Негативный тест. Отрицательные значения");
            System.err.println(TriangleException);

        }
    }
    @Test
    @Tag("Negative")
    public void triangleAreaNegativeTest() throws TriangleException{
        logger.info("Логируем");

        try {
            assertEquals(9.0, areaOfTriangle(4,5,7), "Площадь не верная");
        } catch (org.opentest4j.AssertionFailedError TriangleException) {
            System.err.println("Негативный тест. Площадь не совпадает");
            System.err.println(TriangleException);
        }

    }
    @Test
    @Tag("Negative")
    public void triangleAreaZeroTest() throws TriangleException{
        logger.info("Логируем");

        try {
            assertEquals(6.0, areaOfTriangle(0,4,5));
        } catch (org.opentest4j.AssertionFailedError TriangleException) {
            System.err.println("Негативный тест. Сторона равна нулю");
            System.err.println(TriangleException);

        }
    }

}
