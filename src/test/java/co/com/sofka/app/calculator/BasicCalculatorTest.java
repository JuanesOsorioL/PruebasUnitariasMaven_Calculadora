package co.com.sofka.app.calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BasicCalculatorTest {
    private final BasicCalculator basicCalculator = new BasicCalculator();

    /* suma */
    @Test
    @DisplayName("Testing sum: 1+1=2")
    public void sum() {
        // Arrange
        Long number1 = 1L;
        Long number2 = 1L;
        Long expectedValue = 2L;
        // Act
        Long result = basicCalculator.sum(number1, number2);
        // Assert
        assertEquals(expectedValue, result);
    }

    /* suma varios */
    @DisplayName("Testing several sums")
    @ParameterizedTest(name = "{0} + {1} = {2}")
    @CsvSource({
            "0,    1,   1",
            "1,    2,   3",
            "49,  51, 100",
            "1,  100, 101"
    })
    public void severalSums(Long first, Long second, Long expectedResult) {
        assertEquals(expectedResult, basicCalculator.sum(first, second),
                () -> first + " + " + second + " should equal " + expectedResult);
    }

    /* Resta */
    @Test
    @DisplayName("Testing res: 1-1=0")
    public void res() {
        // Arrange
        Long number1 = 1L;
        Long number2 = 1L;
        Long expectedValue = 0L;
        // Act
        Long result = basicCalculator.res(number1, number2);
        // Assert
        assertEquals(expectedValue, result);
    }

    /* resta varios */
    @DisplayName("Testing several res")
    @ParameterizedTest(name = "{0} - {1} = {2}")
    @CsvSource({
            "0,    1,   -1",
            "2,    1,   1",
            "51,  49,  2",
            "110,  100, 10"
    })

    public void severalRes(Long first, Long second, Long expectedResult) {
        assertEquals(expectedResult, basicCalculator.res(first, second),
                () -> first + " - " + second + " should equal " + expectedResult);
    }

    /* multiplicacion */
    @Test
    @DisplayName("Testing mul: 2*5=10")
    public void mul() {
        // Arrange
        Long number1 = 2L;
        Long number2 = 5L;
        Long expectedValue = 10L;
        // Act
        Long result = basicCalculator.mul(number1, number2);
        // Assert
        assertEquals(expectedValue, result);
    }

    /* multiplicacion varios */
    @DisplayName("Testing several mul")
    @ParameterizedTest(name = "{0} * {1} = {2}")
    @CsvSource({
            "10,    10,   100",
            "2,    7,   14",
            "50,  4,  200",
            "110,  100, 11000"
    })

    public void severalMul(Long first, Long second, Long expectedResult) {
        assertEquals(expectedResult, basicCalculator.mul(first, second),
                () -> first + " * " + second + " should equal " + expectedResult);
    }

    /* division */
    @Test
    @DisplayName("Testing div: 4/2=2")
    public void div() {
        // Arrange
        Long number1 = 4L;
        Long number2 = 2L;
        Long expectedValue = 2L;
        // Act
        Long result = basicCalculator.div(number1, number2);
        // Assert
        assertEquals(expectedValue, result);
    }

    /*division por Zero*/
    @Test
    @DisplayName("Testing div: 4/0=Error")
    public void divZero() {
        // Arrange
        Long number1 = 4L;
        Long number2 = 0L;
        // Act
        Exception exception = assertThrows(ArithmeticException.class, () -> basicCalculator.div(number1, number2));
        // Assert
        assertEquals("/ by zero", exception.getMessage());
    }

    /* division varios */
    @DisplayName("Testing several div")
    @ParameterizedTest(name = "{0} / {1} = {2}")
    @CsvSource({
            "8,    4,   2",
            "9,    3,   3",
            "45,  5,    9",
            "84,  6,    14"
    })

    public void severalDiv(Long first, Long second, Long expectedResult) {
        assertEquals(expectedResult, basicCalculator.div(first, second),
                () -> first + " / " + second + " should equal " + expectedResult);
    }
}
