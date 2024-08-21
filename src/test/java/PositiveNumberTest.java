import org.junit.jupiter.api.Test;
import ru.clevertec.StringUtils;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PositiveNumberTest {
    @Test
    void isPositiveNumberTest() {
        assertTrue(StringUtils.isPositiveNumber("42"));
        assertTrue(StringUtils.isPositiveNumber("3.14"));
        assertFalse(StringUtils.isPositiveNumber("-1"));
        assertFalse(StringUtils.isPositiveNumber("0"));
        assertFalse(StringUtils.isPositiveNumber("abc"));
        assertFalse(StringUtils.isPositiveNumber(""));
        assertFalse(StringUtils.isPositiveNumber(null));
    }
}