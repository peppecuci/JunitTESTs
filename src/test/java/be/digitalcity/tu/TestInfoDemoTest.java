package be.digitalcity.tu;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.TestInfo;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

public class TestInfoDemoTest {

    private Logger logger = Logger.getLogger(TestInfoDemoTest.class.getName());

    static List<Integer> integers = Arrays.asList(1,2,3,4,5,6,7,8,9);
    @BeforeEach
    void beforeEachTest(TestInfo testInfo, RepetitionInfo repetitionInfo) {
        logger.info(String.format("Repetition %d / %d pour %s",
                repetitionInfo.getCurrentRepetition(),
                repetitionInfo.getTotalRepetitions(),
                testInfo.getTestMethod().get().getName()));
    }

    @RepeatedTest(value = 10)
    void repeatTest() {
    }

}
