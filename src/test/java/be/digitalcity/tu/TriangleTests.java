package be.digitalcity.tu;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TriangleTests {

    private final Triangle triangle = new Triangle(7, 15, 12);

    //region TEST: la somme de deux des trois cotés doit etre majeur ou egale au troisieme coté;
    @Test
    void testAPlusBBiggerThenCSuccess() {

        //ARRANGE


        //ACT

        //ASSERT
        assertTrue(triangle.getSide1() + triangle.getSide2() >= triangle.getSide3());

    }

    @Test
    void testAPlusCBiggerThenBSuccess() {

        //ARRANGE

        //ACT

        //ASSERT
        assertTrue(triangle.getSide1() + triangle.getSide3() >= triangle.getSide2());

    }

    @Test
    void testBPlusCBiggerThenASuccess() {

        //ARRANGE

        //ACT

        //ASSERT
        assertTrue(triangle.getSide2() + triangle.getSide3() >= triangle.getSide1());

    }
    //endregion

    //region TEST: les valeur des chaque cotes n'est pas null;
    @Test
    void testSide1isNotNullSuccess() {

        assertNotNull(triangle.getSide1());

    }

    @Test
    void testSide2isNotNullSuccess() {

        assertNotNull(triangle.getSide2());

    }

    @Test
    void testSide3isNotNullSuccess() {

        assertNotNull(triangle.getSide3());

    }
    //endregion

    //region TEST: aucun des cotes est egale a zero;
    @Test
    void testSide1isNotZeroSuccess(){

        assertNotEquals(0, (int) triangle.getSide1());

    }

    @Test
    void testSide2isNotZeroSuccess(){

        assertNotEquals(0, (int) triangle.getSide1());

    }

    @Test
    void testSide3isNotZeroSuccess(){

        assertNotEquals(0, (int) triangle.getSide1());

    }
    //endregion



}
