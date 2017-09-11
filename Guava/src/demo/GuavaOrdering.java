package demo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.google.common.collect.Ordering;

public class GuavaOrdering {

    public static void main(String[] args) {

        List<Integer> numbers = new ArrayList<Integer>();
        
        numbers.add(new Integer(5));
        numbers.add(new Integer(2));
        numbers.add(new Integer(15));
        numbers.add(new Integer(51));
        numbers.add(new Integer(53));
        numbers.add(new Integer(35));
        numbers.add(new Integer(45));
        numbers.add(new Integer(32));
        numbers.add(new Integer(43));
        numbers.add(new Integer(16));

        System.out.println("Input List: ");
        System.out.println(numbers);  

        // Sort using the natural order: ascending
        Ordering<Integer> ordering = Ordering.natural();
        Collections.sort(numbers, ordering);
        System.out.println("Sorted List: ");
        System.out.println(numbers);

        // Checks if the list is sorted according to this ordering
        System.out.println("List is sorted: " + ordering.isOrdered(numbers));

        // Min & max
        System.out.println("Minimum: " + ordering.min(numbers));
        System.out.println("Maximum: " + ordering.max(numbers));

        // Reverse order
        Collections.sort(numbers,ordering.reverse());
        System.out.println("Reverse: " + numbers);

        //Include null value
        numbers.add(null);
        System.out.println("Null added to Sorted List: ");
        System.out.println(numbers);

        // Nulls first
        Collections.sort(numbers,ordering.nullsFirst());
        System.out.println("Null first Sorted List: ");
        System.out.println(numbers);

        // Nulls last
        Collections.sort(numbers,ordering.nullsLast());
        System.out.println("Null first Sorted List: ");
        System.out.println(numbers);

        List<String> time22 = new ArrayList<String>();
        
        time22.add("Dani");
        time22.add("Lucas");
        time22.add("Eric");
        time22.add("Claudine");
        time22.add("Luidson");
        time22.add(null);

        System.out.println("Team 22: ");
        System.out.println(time22);

        Ordering<String> orderingString = Ordering.natural();

        // If there is a null value and you don't use nullsFirst/nullsLast: NPE
        Collections.sort(time22, orderingString.nullsLast());
        System.out.println("Sorted list: ");
        System.out.println(time22);

        Collections.sort(time22, orderingString.nullsFirst().reverse());
        System.out.println("Null first then reverse sorted list: ");
        System.out.println(time22);
    }
}
