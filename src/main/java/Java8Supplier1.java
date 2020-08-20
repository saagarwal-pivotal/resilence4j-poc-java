

import io.github.resilience4j.bulkhead.Bulkhead;
import io.github.resilience4j.circuitbreaker.CircuitBreaker;
import io.github.resilience4j.decorators.Decorators;
import io.github.resilience4j.retry.Retry;
import io.vavr.CheckedFunction0;
import io.vavr.control.Try;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

public class Java8Supplier1 {

    private static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static void main(String[] args) throws Throwable {

        CircuitBreakerConfig circuitBreakerConfig = new CircuitBreakerConfig();


        CircuitBreaker circuitBreaker = circuitBreakerConfig.getCircuitBreaker();

        ExecutorService pool = Executors.newFixedThreadPool(25);
        System.out.println("Start State "+circuitBreaker.getState());

        for(int i=0;i<200;i++) {
            Runnable r1 = new DoSomethingThread("task " + i, circuitBreaker);


            // creates a thread pool with MAX_T no. of
            // threads as the fixed pool size(Step 2)


            pool.execute(r1);
        }
        System.out.println("End State "+circuitBreaker.getState());
        pool.awaitTermination(120, TimeUnit.SECONDS);

        System.out.println("End State 2 "+circuitBreaker.getState());

        // pool shutdown ( Step 4)
        pool.shutdown();


    }


}