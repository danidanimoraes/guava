package demo;

import java.io.IOException;

import com.google.common.base.Throwables;

public class GuavaThrowables {

    public static void main(String[] args) {

        GuavaThrowables demo = new GuavaThrowables();

        try {
            demo.testThrowables1();
            
         } catch (InvalidInputException e) {
         //get the root cause
         System.out.println("Root cause: " + Throwables.getRootCause(e));
         System.out.println("Causal chain: " + Throwables.getCausalChain(e));
         System.out.println("Get cause as Invalid input exception: " + Throwables.getCauseAs(Throwables.getRootCause(e), Exception.class));
         System.out.println("Stack trace as string: " + Throwables.getStackTraceAsString(e));
         System.out.println("Lazy stack trace: " + Throwables.lazyStackTrace(e));
         System.out.println("is lazy: " + Throwables.lazyStackTraceIsLazy());
    }
    }

    public void testThrowables1() throws InvalidInputException{
        try {
           sqrt(-3.0);            
        } catch (Exception e) {
           //check the type of exception and throw it
           Throwables.propagateIfPossible(e, InvalidInputException.class);      
        } 
     }

         public double sqrt(double input) throws InvalidInputException{
            if(input < 0) throw new InvalidInputException();
            return Math.sqrt(input);
         }

         public void dummyIO() throws IOException {
            throw new IOException();
         }
}

    class InvalidInputException extends Exception {
        
    }
