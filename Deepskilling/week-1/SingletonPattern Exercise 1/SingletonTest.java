
/**
 * Test class to verify that only one instance of Logger is created.
 */
public class SingletonTest {

    public static void main(String[] args) {
        System.out.println("=== Starting Singleton Pattern Verification ===\n");

        // 1. Attempt to get instances from the Logger factory method
        Logger loggerInstance1 = Logger.getInstance();
        Logger loggerInstance2 = Logger.getInstance();

        // 2. Log messages using both references to see if they behave consistently
        loggerInstance1.log("Initializing database connection pool...");
        loggerInstance2.log("User authentication request received for 'Ananya'.");

        // 3. Perform the memory address and equality verification
        System.out.println("\n--- Verification Results ---");
        System.out.println("Instance 1 Memory HashCode: " + System.identityHashCode(loggerInstance1));
        System.out.println("Instance 2 Memory HashCode: " + System.identityHashCode(loggerInstance2));

        // Critical Check: Check if both references point to the exact same object in the heap memory
        boolean isSameInstance = (loggerInstance1 == loggerInstance2);
        System.out.println("Are both instances identical? -> " + isSameInstance);

        if (isSameInstance) {
            System.out.println("\n🎯 SUCCESS: The Singleton Pattern was successfully implemented! Only one Logger instance exists.");
        } else {
            System.out.println("\n❌ FAILURE: Separate Logger instances were found in memory.");
        }
    }
}
