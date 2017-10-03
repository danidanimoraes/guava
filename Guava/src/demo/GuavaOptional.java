package demo;

import com.google.common.base.Optional;

public class GuavaOptional {

    public static void main(String[] args) {
        GuavaOptional demo = new GuavaOptional();

        try {
            // Sum null value without Guava: NPE
            System.out.println("Without guava");
            Integer a = null;
            Integer b = new Integer(1);
            System.out.println(sum(a, b)); // NPE occurs here
        } catch (NullPointerException npe) {
            System.out.println("Oops, NPE!");
        }
        try {
            // Sum with Guava's Optional: NPE
            System.out.println("With guava, Optional.of(null)");
            Optional<Integer> c = Optional.of(null); // NPE occurs here
            Optional<Integer> d = Optional.of(new Integer(2));
            System.out.println( demo.sumOptional(c, d));
        } catch (NullPointerException npe) {
            System.out.println("Oops, NPE!");
        }

        // Sum using fromNullable
        System.out.println("With Guava, Optional.fromNullable(null)");
        Optional<Integer> e = Optional.of(new Integer(3)); // Doesn't allow null
        Optional<Integer> f = Optional.fromNullable(null); // Allows null value
        System.out.println(demo.sumOptionalNullable(e, f));

    }

    private static Integer sum(Integer a, Integer b) {
        return a + b;
    }

    private Integer sumOptional(Optional<Integer> c, Optional<Integer> d) {
        return c.get() + d.get();
    }

    private Integer sumOptionalNullable(Optional<Integer> c, Optional<Integer> d) {
        // This method only allows only the second value as null
        Integer value1 = c.get();
        Integer value2 = d.or(new Integer(0));
        return value1 + value2;
    }
}
