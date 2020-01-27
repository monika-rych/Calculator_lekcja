import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.assertj.core.api.Assertions.*;

public class CalcAppTest {                           // klasa testowa

    private CalcApp calc;                           // testowany obiekt

    @BeforeEach                                     // adnotacja
    public void setUp() {
        calc = new CalcApp();
    }   // metoda zostanie wykonana przed każdym testem

    @Test                                           // adnotacja
    @Tag("numCheck")
    @Tag("errorCheck")
    @Tag("substTests")
    public void testSumTwoPositives() {              // metoda oznaczona jako test
        double expected = 8;
        double actual = calc.addValues(5, 3);

        assertEquals(expected, actual);             // asercja sprawdzająca poprawność działania
    }

    @Test
    @Tag("substTests")
    public void testSubtractionTwoPositivesGiveWrongResult() {
        double expected = 10;
        double actual = calc.subtValue(15, 4);

        assertNotEquals(expected, actual);
    }

    @Test
    @Tag("errorCheck")

    public void testisNotReturningNullValue() {
        assertNotNull(calc.subtValue(15, 5));
    }

    @Test
    @Tag("errorCheck")
    @Tag("substTests")

    public void testIsNotThrowingException() {
        assertDoesNotThrow(() -> {
            calc.subtValue(15, 5);
        });
    }

    @Test
    public void testResultBiggerThenZero() {

        boolean wieksza = calc.subtValue(15, 8) > 0;

        assertTrue(wieksza);
    }

    @ParameterizedTest
    @CsvSource(value = {"20:8:12"}, delimiter = ':')

    public void testSubtractionThreePositives(double v1, double v2, double v3) {
        double expected = v3;
        double actual = calc.subtValue(v1, v2);

        assertEquals(expected, actual);

    }

    @ParameterizedTest
    @CsvSource(value = {"20:8:10"}, delimiter = ':')
    public void testSubtractionThreePositivesGiveWrongResult(double v1, double v2, double v3) {

        double expected = v3;
        double actual = calc.subtValue(v1, v2);

        assertNotEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource(value = {"20:8:28", "-15:16:1", "100:-20:80"}, delimiter = ':')
    public void testAddValues(double v1, double v2, double v3) {

        double expected = v3;
        double actual = calc.addValues(v1, v2);
        assertThat(actual)
                .isEqualTo(expected)
                .isBetween(-200.0, 200.0)
                .isCloseTo(expected,offset(0.1))
                .isNotNaN()
                .isNotNull()
                .isLessThan(100)
                .isGreaterThan(0)
                .isNotInstanceOf(Exception.class)
        .isCloseTo(expected, within(0.1));

    }

    @ParameterizedTest
    @CsvSource(value = {"20:8", "35:-15", "100:-20"}, delimiter = ':')
    public void testIsNotThrowingException2(double v1, double v2) {
        assertDoesNotThrow(() -> {
            calc.addValues(v1, v2);
        });
    }

    @ParameterizedTest
    @CsvSource(value = {"20:8:28", "35:-15:20", "100:-20:-80"}, delimiter = ':')
    public void testIfResultIsAnEvenNumber(double v1, double v2, double v3) {

        double actual = calc.addValues(v1, v2);
        double reminder = actual % 2;
        double expectedReminderForEvenNumber = 0;
        assertEquals(expectedReminderForEvenNumber, Math.abs(reminder));

    }
    @ParameterizedTest
    @CsvSource(value = {"3:2:9", "3:0:1"}, delimiter = ':')
    public void testPowerValue(int v1, int v2, int v3){
        double result = calc.toThePower(v1, v2);
        assertEquals(v3, result);
    }

    @ParameterizedTest
    @CsvSource(value = {"3:-1"}, delimiter = ':')
    public void testPowerValueException(int v1, int v2){
        assertThrows(ArithmeticException.class, ()->{calc.toThePower(v1,v2);});
        }

  @ParameterizedTest
    @CsvSource(value = {"12:3:4"}, delimiter = ':')
    public void testDivValue(double v1, double v2, double v3){
        double result = calc.divValue(v1, v2);
        assertEquals(v3, result);
    }
    @ParameterizedTest
    @CsvSource(value = {"12:0"}, delimiter = ':')
    public void testDivValueException(double v1, double v2){
        assertThrows(ArithmeticException.class, ()->{calc.divValue(v1,v2);});
    }
    @ParameterizedTest
    @CsvSource(value = {"36:6"}, delimiter = ':')
    public void testSquareRoot(double v1, double v2){
        double result = calc.squareRoot(v1);
        assertEquals(v2, result);
    }
    @ParameterizedTest
    @CsvSource(value = {"-36"}, delimiter = ':')
    public void testSquareRootException(double v1){
        assertThrows(ArithmeticException.class, ()->{calc.squareRoot(v1);});
    }

}
