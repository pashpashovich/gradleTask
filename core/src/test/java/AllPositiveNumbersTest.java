import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import ru.clevertec.Utils;


class AllPositiveNumbersTest {
    @ParameterizedTest
    @CsvSource({
            "1,2,3",
            "1.7,2.9,3.8",
    })
    void isAllPositiveNumbersTestWithPositiveResults(String first, String second, String third) {
        Assertions.assertTrue(Utils.isAllPositiveNumbers(first, second, third));
    }

    @ParameterizedTest
    @CsvSource({
            "1,-2,3",
            "1.5,2.3,0",
            "sd5ws,2df,0",
            "1,0,3"
    })
    void isAllPositiveNumbersTestWithNegativeResults(String first, String second, String third) {
        Assertions.assertFalse(Utils.isAllPositiveNumbers(first, second, third));
    }
}
