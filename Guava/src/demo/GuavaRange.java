package demo;

import com.google.common.collect.ContiguousSet;
import com.google.common.collect.DiscreteDomain;
import com.google.common.collect.Range;
import com.google.common.primitives.Ints;

public class GuavaRange {

    public static void main(String[] args) {

        GuavaRange demo = new GuavaRange();

        //create a range [a,b] = { x | a <= x <= b}
        Range<Integer> range1 = Range.closed(0, 9);   
        System.out.print("[0,9] : ");
        demo.printRange(range1);

        System.out.println("5 is present: " + range1.contains(5));
        System.out.println("(1,2,3) is present: " + range1.containsAll(Ints.asList(1, 2, 3)));
        System.out.println("Lower Bound: " + range1.lowerEndpoint());
        System.out.println("Upper Bound: " + range1.upperEndpoint());
        System.out.println("Lower and upper bound type: " + range1.lowerEndpoint() + " type " + range1.lowerBoundType() + ", " + range1.upperEndpoint() + " type " + range1.upperBoundType());

      //create a range (a,b) = { x | a < x < b}
        Range<Integer> range2 = Range.open(0, 9);
        System.out.print("(0,9) : ");
        demo.printRange(range2);
        System.out.println("Lower and upper bound type: " + range2.lowerEndpoint() + " type " + range2.lowerBoundType() + ", " + range2.upperEndpoint() + " type " + range2.upperBoundType());

      //create a range (a,b] = { x | a < x <= b}
        Range<Integer> range3 = Range.openClosed(0, 9);
        System.out.print("(0,9] : ");
        demo.printRange(range3);
        System.out.println("Lower and upper bound type: " + range3.lowerEndpoint() + " type " + range3.lowerBoundType() + ", " + range3.upperEndpoint() + " type " + range3.upperBoundType());

        //create a range [a,b) = { x | a <= x < b}
        Range<Integer> range4 = Range.closedOpen(0, 9);
        System.out.print("[0,9) : ");
        demo.printRange(range4);
        System.out.println("Lower and upper bound type: " + range4.lowerEndpoint() + " type " + range4.lowerBoundType() + ", " + range4.upperEndpoint() + " type " + range4.upperBoundType());

      //create an open ended range (9, infinity
        Range<Integer> range5 = Range.greaterThan(9);
        System.out.println("(9,infinity) : ");
        // Fica pra sempre: demo.printRange(range5);
        System.out.println("Lower Bound: " + range5.lowerEndpoint());
        System.out.println("Upper Bound present: " + range5.hasUpperBound());
        // Exception: System.out.println("Lower and upper bound type: " + range5.lowerEndpoint() + " type " + range5.lowerBoundType() + ", " + range5.upperEndpoint() + " type " + range5.upperBoundType());

        Range<Integer> range6 = Range.closed(3, 5); 
        demo.printRange(range6);

      //check a subrange [3,5] in [0,9]
        System.out.println("[0,9] encloses [3,5]:" + range1.encloses(range6));

        Range<Integer> range7 = Range.closed(9, 20);    
        demo.printRange(range7);

      //check ranges to be connected      
        System.out.println("[0,9] is connected [9,20]:" + range1.isConnected(range7));

        Range<Integer> range8 = Range.closed(5, 15);    

        //intersection
        demo.printRange(range1.intersection(range8));

        //span
        demo.printRange(range1.span(range8));

    }

    private void printRange(Range<Integer> range) {

        System.out.print("[ ");
        
        for(int grade : ContiguousSet.create(range, DiscreteDomain.integers())) {
           System.out.print(grade +" ");
        }
        System.out.println("]");
     }
}
