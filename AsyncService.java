import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;

public class AsyncService {

    private final ExecutorService executor;

    public AsyncService(ExecutorService executor) {
        this.executor = executor;
    }

    public CompletableFuture<String> loadData() {
        return CompletableFuture.supplyAsync(() -> {
            LoggerUtil.log("Загрузка данных...");

            sleep(1000);

            // имитация ошибки
            if (Math.random() > 0.5) {
                throw new RuntimeException("Ошибка при получении данных");
            }

            return "data from server";
        }, executor);
    }

    public String processData(String data) {
        LoggerUtil.log("Обработка данных: " + data);
        return data.toUpperCase();
    }

    public String handleError(Throwable error) {
        LoggerUtil.log("Обработка ошибки: " + error.getMessage());
        return "fallback data";
    }

    private void sleep(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}