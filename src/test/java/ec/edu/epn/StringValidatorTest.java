package ec.edu.epn;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

public class StringValidatorTest {

    private final StringValidator stringValidator = new StringValidator();

    // Clase utilitaria
    private static class TestData{
        final String text;
        final boolean expectedResult;

        TestData(String text, boolean expectedResult){
            this.text = text;
            this.expectedResult = expectedResult;
        }
    }

    @TestFactory
    Collection<DynamicTest> dymamicPalindromeTest(){

        List<TestData> testDataList = Arrays.asList(
            new TestData("reconocer", true),
            new TestData("oso", true),
            new TestData("Hola", false)
        );

        return testDataList.stream()
            .map(data->DynamicTest.dynamicTest("Verificando Palindromo:" + data.text, 
                () -> {
                    boolean methodResult = stringValidator.isPalindrome(data.text);
                    if(data.expectedResult){
                        assertTrue(methodResult);
                    } else{
                        assertFalse(methodResult);
                    }
                }
            )).collect(Collectors.toList());
        
    }
}
