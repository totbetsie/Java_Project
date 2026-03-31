import java.time.LocalTime;

public class LoggerUtil {

    public static void log(String message) {
        System.out.println("[" + LocalTime.now() + "] " + message);
    }
}