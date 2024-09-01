import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import ru.clevertec.Utils;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


class AllPositiveNumbersTest {
    @ParameterizedTest
    @CsvSource({
            "1,2,3",
            "1.7,2.9,3.8",
    })
    void isAllPositiveNumbersTestWithPositiveResults(String first, String second, String third) {
        assertTrue(Utils.isAllPositiveNumbers(first, second, third));
    }

    @ParameterizedTest
    @CsvSource({
            "1,-2,3",
            "1.5,2.3,0",
            "sd5ws,2df,0",
            "1,0,3"
    })
    void isAllPositiveNumbersTestWithNegativeResults(String first, String second, String third) {
        assertFalse(Utils.isAllPositiveNumbers(first, second, third));
    }

    @ParameterizedTest
    @NullAndEmptySource
    void isAllPositiveNumbersTestWithNullAndEmptyStrings(String number) {
        assertFalse(Utils.isAllPositiveNumbers(number));
    }
}
