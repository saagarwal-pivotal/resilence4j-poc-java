import io.github.resilience4j.bulkhead.Bulkhead;
import io.github.resilience4j.circuitbreaker.CircuitBreaker;
import io.github.resilience4j.retry.Retry;

public class DoSomethingThread implements Runnable{

    private String name;

    private CircuitBreaker circuitBreaker;

public DoSomethingThread(String name,CircuitBreaker
                         circuitBreaker){
    this.name=name;
    this.circuitBreaker=circuitBreaker;
}

    public void run() {
        try {
            getDoSomething();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

    }

    private  void getDoSomething() throws Throwable {



/*
        CheckedFunction0<Double> supplier =

        // Decorate your call to backendService.doSomething()
// with a Bulkhead, CircuitBreaker and Retry
// **note: you will need the resilience4j-all dependency for this
        CheckedFunction0<Double> decoratedSupplier = Decorators.ofCheckedSupplier(supplier)
                .withCircuitBreaker(circuitBreaker)
                .withBulkhead(bulkhead)
                .withRetry(retry)
                .decorate();
*/
        // Execute the decorated supplier and recover from any exception
        //    String result = Try.ofSupplier(decoratedSupplier).recover(throwable -> "Hello from Recovery").get();

        // When you don't want to decorate your lambda expression,
// but just execute it and protect the call by a CircuitBreaker.
        // String result = circuitBreaker.executeSupplier(backendService::doSomething);

        double d =  circuitBreaker.executeCheckedSupplier(new BusinessClass().doSomethingWithSupplier());
        System.out.println("double d "+ d);
    }


}
