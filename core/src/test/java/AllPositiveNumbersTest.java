import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.clevertec.Utils;


public class AllPositiveNumbersTest {
        @Test
        void IsAllPositiveNumbersTest() {
            Assertions.assertTrue(Utils.isAllPositiveNumbers("1", "2", "3"));
            Assertions.assertTrue(Utils.isAllPositiveNumbers("1.7", "2.9", "3.8"));
            Assertions.assertFalse(Utils.isAllPositiveNumbers("1", "-2", "3"));
            Assertions.assertFalse(Utils.isAllPositiveNumbers("1.5", "2.3", "0"));
            Assertions.assertFalse(Utils.isAllPositiveNumbers("sd5ws", "2df", "0"));
            Assertions.assertFalse(Utils.isAllPositiveNumbers(""));
            Assertions.assertFalse(Utils.isAllPositiveNumbers("1", "0", "3"));
        }
}
