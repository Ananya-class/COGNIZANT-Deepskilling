
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class AAALifecycleTest {

    private Calculator calculator;

    @Before
    public void setUp() {
        calculator = new Calculator();
        System.out.println("Setup: Initialized clean Calculator instance.");
    }

    @Test
    public void testAdditionWithAAAPattern() {
        // Arrange
        int numberA = 10;
        int numberB = 20;

        // Act
        int result = calculator.add(numberA, numberB);

        // Assert
        assertEquals(30, result);
        System.out.println("Execution: Test verified successfully via AAA pattern.");
    }

    @After
    public void tearDown() {
        calculator = null;
        System.out.println("Teardown: Cleaned up instance resources.");
    }
}
