
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Thread-safe Singleton implementation for a Logging Utility[cite: 144].
 */
public class Logger {

    // 1. Private static instance of itself (volatile ensures visibility across threads)
    private static volatile Logger instance;

    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    // 2. Private constructor to prevent instantiation from other classes
    private Logger() {
        // Prevent reflection attacks from creating a second instance
        if (instance != null) {
            throw new IllegalStateException("Logger instance already created! Use getInstance().");
        }
    }

    // 3. Public static method to get the single instance of the Logger class
    public static Logger getInstance() {
        // First check (no locking overhead if instance already exists)
        if (instance == null) {
            // Synchronize on the class level to block concurrent threads
            synchronized (Logger.class) {
                // Second check (double-checked locking)
                if (instance == null) {
                    instance = new Logger();
                }
            }
        }
        return instance;
    }

    /**
     * Public logging method available to the application.
     */
    public void log(String message) {
        String timestamp = LocalDateTime.now().format(formatter);
        System.out.println("[" + timestamp + "] [INFO] " + message);
    }
}
