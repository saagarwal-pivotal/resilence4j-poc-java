import io.vavr.CheckedFunction0;

import java.util.function.Supplier;

public class BusinessClass {


    public double doSomething() throws SolException{

        System.out.println("in do something");
        throw new SolException();
     //   return Math.random();
    }


    public CheckedFunction0<Double> doSomethingWithSupplier() {

        return () -> doSomething();
    }


}
