package ec.edu.epn;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CalculatorTest {

    private Calculator calculator = new Calculator();

    // Estandar para nombre de pruebas unitarias: Metodo_caso_resultadoEsperado
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

    @Test
    void divide_TwoPositiveNumbers_ReturnsCorrectQuotient(){
        //Arrange
        int a = 20;
        int b = 4;

        //Act
        double result = calculator.divide(a, b);

        //Assert
        assertEquals(5.0, result);
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
    
}
