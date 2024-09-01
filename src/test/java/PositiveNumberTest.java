import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import ru.clevertec.StringUtils;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PositiveNumberTest {

    @ParameterizedTest
    @ValueSource(strings = {"1", "3", "5", "65", "43.6"})
    void isPositiveNumberTestWithPositiveResults(String number) {
        assertTrue(StringUtils.isPositiveNumber(number));
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"0", "abc", "-34", "-3.5"})
    void isPositiveNumberTestWithNegativeResults(String number) {
        assertFalse(StringUtils.isPositiveNumber(number));
    }
}