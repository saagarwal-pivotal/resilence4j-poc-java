import io.github.resilience4j.bulkhead.Bulkhead;
import io.github.resilience4j.circuitbreaker.CircuitBreaker;
import io.github.resilience4j.retry.Retry;

public class CircuitBreakerConfig {

    private CircuitBreaker circuitBreaker;

    public CircuitBreakerConfig(){
        // Create a CircuitBreaker with default configuration
        circuitBreaker = CircuitBreaker
                .ofDefaults("backendService");

        // Create a Retry with default configuration
// 3 retry attempts and a fixed time interval between retries of 500ms
        Retry retry = Retry
                .ofDefaults("backendService");

        // Create a Bulkhead with default configuration
        Bulkhead bulkhead = Bulkhead
                .ofDefaults("backendService");
    }

    public CircuitBreaker getCircuitBreaker(){
        return circuitBreaker;
    }
}
