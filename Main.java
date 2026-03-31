import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {

        LoggerUtil.log("Запуск приложения");

        ExecutorService executor = Executors.newFixedThreadPool(2);
        AsyncService service = new AsyncService(executor);

        service.loadData()
                .thenApply(service::processData)
                .exceptionally(service::handleError)
                .thenAccept(result -> LoggerUtil.log("Финальный результат: " + result))
                .join(); // ждём завершения

        executor.shutdown();

        LoggerUtil.log("Завершение приложения");
    }
}