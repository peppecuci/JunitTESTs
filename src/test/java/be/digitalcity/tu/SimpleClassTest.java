package be.digitalcity.tu;


import org.junit.jupiter.api.*;

import javax.management.RuntimeErrorException;

import static org.junit.jupiter.api.Assertions.*;

public class SimpleClassTest {

    @Test
    @DisplayName("TOTO fait des tests")
    void premierTestCalculSucces() {
        //ARRANGE
        int a = 3, b = 4;
        int result;

        //ACT
        result = new Calculation().addiction(a, b);

        //ASSERT
        assertEquals(7, result);
    }
    @Test
    void premierTestCalculFailed() {
        //ARRANGE
        int a = 3, b = 4;
        int result;

        //ACT
        result = a + b;

        //ASSERT
        assertNotEquals(8, result);

    }

    @Test
    void premierTestZeroDivisionThrowException() {
        boolean thrown = false;

        //ARRANGE
        int a = 5;
        int b = 0;
        int result = 0;

        //ACT
        try {
            result = a / b;
        }
        catch (ArithmeticException e) {

            thrown = true;
        }

        //ASSERT
        assertTrue(thrown);
    }

//Marcelo's way
//    @Test
//    void premierTestZeroDivisionThrowExceptionUsingThrows() {
//        boolean thrown = false;
//
//        //ARRANGE
//        int a = 5;
//        int b = 0;
//
//        //ACT
//        assertThrows(ArithmeticException.class, () -> { int result = a/b; });
//
//    }

}
