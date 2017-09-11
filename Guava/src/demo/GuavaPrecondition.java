package demo;

import com.google.common.base.Preconditions;

public class GuavaPrecondition {

    private int[] myArray = {1,2,3,4,5};
    
    public static void main(String[] args) {
        GuavaPrecondition demo = new GuavaPrecondition();

        try {
            demo.sqrt(9);
            // Square root of a negative value
            demo.sqrt(-3);
         }catch(IllegalArgumentException e) {
            System.out.println(e.getMessage());
         }
         
         try {
             demo.sum(2, 3);
            // Sum of a null value
            demo.sum(null,3);
         }catch(NullPointerException e) {
            System.out.println(e.getMessage());
         }
         
         try {
            // Get index out of bonds
            System.out.println(demo.getValue(6));
         }catch(IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
         }
    }

    private double sqrt(double input) throws IllegalArgumentException {
        // Input must be positive, otherwise the error message is shown
        Preconditions.checkArgument(input > 0.0, "Illegal Argument passed: Negative value %s.", input);
        double result = Math.sqrt(input);
        System.out.println("Square root of " + input + ": " + result);
        return result;
     }

    private int sum(Integer a, Integer b){
        a = Preconditions.checkNotNull(a, "Illegal Argument passed: First parameter is Null.");
        b = Preconditions.checkNotNull(b, "Illegal Argument passed: Second parameter is Null.");
        int result =  a + b;
        System.out.println(a + " + " +  b  + " = " + result);
        return result;
     }

    private int getValue(int input){
        Preconditions.checkElementIndex(input, myArray.length, "Illegal Argument passed: Invalid index.");
        int result = myArray[input];
        System.out.println("myArray[" + input + "] = " + result);
        return result;
     }
}
