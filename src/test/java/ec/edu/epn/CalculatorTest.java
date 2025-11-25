package ec.edu.epn;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    void setUp(){
        calculator = new Calculator();
    }

    @AfterEach
    void tearDown(){
        calculator = null;
    }

    // Estandar para nombre de pruebas unitarias: Metodo_caso_resultadoEsperadoS
    @Test
    void add_TwoPositiveNumbers_ReturnsCorrectSum(){
        //Arrange - Preparacion de datos para la prueba
        int a = 3;
        int b = 4;

        //Act - Ejecucion de la prueba
        int result = calculator.add(a, b);

        //Assert - Verificacion de resultados
        assertEquals(7, result);
    }

    
    @Test
    void subtract_TwoPositiveNumbers_ReturnsCorrectDifference(){
        //Arrange
        int a = 10;
        int b = 4;

        //Act
        int result = calculator.subtract(a, b);

        //Assert
        assertEquals(6, result);
    }

    @Test
    void multiply_TwoPositiveNumbers_ReturnsCorrectProduct(){
        //Arrange
        int a = 5;
        int b = 6;

        //Act
        int result = calculator.multiply(a, b);

        //Assert
        assertEquals(30, result);

    }

    // @Test
    // void divide_TwoPositiveNumbers_ReturnsCorrectQuotient(){
    //     //Arrange
    //     int a = 20;
    //     int b = 4;

    //     //Act
    //     double result = calculator.divide(a, b);

    //     //Assert
    //     assertEquals(5.0, result);
    // }
    @Test
    void divide_PositiveNumbers_ReturnCorrectQuotient(){
        double result = calculator.divide(10,4);
        // Se agrega un delta = 0.0001 para comparacion de numeros decimales, message en caso de fallo
        assertEquals(2.5, result, 0.0001, "10 dividido entre 4 deberia ser 2.5");
    }


    @Test
    void isEven_EvenNumber_ReturnsTrue(){
        //Arrange
        int number = 8;

        //Act
        boolean result = calculator.isEven(number);

        //Assert
        assertTrue(result);
    }


    @Test
    void divide_ByZero_ThrowsException(){
        //Arrange
        int a = 4;
        int b = 0;
        //Act & Assert
        assertThrows(IllegalArgumentException.class, () -> calculator.divide(a, b), "Dividir para cero deberia lanzar una excepcion");
    }

    @Test
    void divide_ByZero_AssertExceptionMessage(){
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class,() -> calculator.divide(5,0));
        assertEquals("The divisor cannot be zero.", illegalArgumentException.getMessage());
    }

    @ParameterizedTest
    @ValueSource(ints = {2, 40, -6, 0})
    void isEven_MultipleNumbers_ShouldReturnTrue(int number){
        assertTrue(calculator.isEven(number));
    }

    @ParameterizedTest
    @CsvSource({
        "3, 5, 8",
        "10, 15, 25",
        "-4, 6, 2",
        "-3, -7, -10"
    })
    void add_MultipleValues_ReturnsCorrectValue(int a, int b, int expected){
        assertEquals(expected, calculator.add(a, b));
    }

    @ParameterizedTest
    @CsvSource({
        "10, 4, 6",
        "20, 5, 15",
        "0, 5, -5",
        "-3, -7, 4"
    })
    void subtract_MultipleValues_ReturnsCorrectDifference(int a, int b, int expected){
        assertEquals(expected, calculator.subtract(a, b));
    }

    @ParameterizedTest
    @CsvSource({
        "2, 3, 6",
        "5, 5, 25",
        "-4, 2, -8",
        "-3, -7, 21"
    })
    void multiply_MultipleValues_ReturnsCorrectProduct(int a, int b, int expected){
        assertEquals(expected, calculator.multiply(a, b));
    }

    @ParameterizedTest
    @CsvSource({
        "10, 4, 2.5",
        "9, 3, 3.0",
        "7, 2, 3.5",
        "5, 2, 2.5"
    })
    void divide_MultipleValues_ReturnsCorrectQuotient(int a, int b, double expected){
        assertEquals(expected, calculator.divide(a, b), 0.0001);
    }
}
