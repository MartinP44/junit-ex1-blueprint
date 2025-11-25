package ec.edu.epn;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class TaxCalculatorTest {

    private TaxCalculator taxCalculator;

    static Stream<Arguments> taxCalculatorData(){
        Stream<Arguments> ret = 
            Stream.of(
                Arguments.of(100.0, 15.0, 115.0),
                Arguments.of(200.0, 10.0, 220.0),
                Arguments.of(50.0, 20.0, 60.0)
            );
        return ret;
    }

    @BeforeEach
    void setUp() {
        taxCalculator = new TaxCalculator();
    }

    @ParameterizedTest
    @MethodSource("taxCalculatorData")
    void testCalculateTax(double valor, double impuesto, double expected) {
        //Arrange - Act
        double result = taxCalculator.calculateTax(valor, impuesto);

        //Assert
        assertEquals(expected, result, 0.0001);
    }
}