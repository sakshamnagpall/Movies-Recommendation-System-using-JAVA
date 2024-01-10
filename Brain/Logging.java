import java.util.logging.*;

public class ExampleLogging {

    // Create a logger
    private static final Logger LOGGER = Logger.getLogger(ExampleLogging.class.getName());

    public static void main(String[] args) {
        // Set the logging level (INFO, WARNING, SEVERE, etc.)
        LOGGER.setLevel(Level.INFO);

        // Create a console handler
        ConsoleHandler consoleHandler = new ConsoleHandler();
        consoleHandler.setLevel(Level.INFO); // Set handler's logging level

        // Add the console handler to the logger
        LOGGER.addHandler(consoleHandler);

        // Simulate an anomaly or error
        try {
            int result = 10 / 0; // This will cause an ArithmeticException
        } catch (ArithmeticException e) {
            // Log the exception and its stack trace
            LOGGER.log(Level.SEVERE, "An arithmetic exception occurred", e);
        }

        // Log an informational message
        LOGGER.info("System behavior: Application started.");

        // Log a warning message
        LOGGER.warning("System behavior: This is a warning message.");

        // You can add more logging statements throughout your code to monitor behavior

        // Always remember to close log handlers when done (not always necessary)
        consoleHandler.close();
    }
}
