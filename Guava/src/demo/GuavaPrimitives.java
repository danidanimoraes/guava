package demo;

import java.util.Arrays;

import com.google.common.primitives.Booleans;
import com.google.common.primitives.Bytes;
import com.google.common.primitives.Chars;
import com.google.common.primitives.Doubles;
import com.google.common.primitives.Floats;
import com.google.common.primitives.Ints;
import com.google.common.primitives.Shorts;

public class GuavaPrimitives {

    public static void main(String[] args) {

//        testBytes();
//        testShorts();
//        testInts();
        //Longs
        
//        testFloats();
        //Doubles
        
//        testChars();
        testBooleans();

    }

    private static void testBooleans() {
        System.out.println("booleans as list: " + Booleans.asList(true, true, false));
        System.out.println("how many trues? " + Booleans.countTrue(true, true, false));
    }

    private static void testChars() {
        System.out.println("bytes to represent a char: " + Chars.BYTES);
        System.out.println("49 to char: " + Chars.checkedCast((long)49));
    }

    private static void testFloats() {
        System.out.println("Bytes to represent a float: " + Floats.BYTES);
        System.out.println("Is 3.2 finite? " + Floats.isFinite((float)3.2));
    }

    private static void testInts() {
        System.out.println("Ints.tryParse 23 : " + Ints.tryParse("23"));
        System.out.println("Ints.tryParse 23 with radix=7 : " + Ints.tryParse("11", 3));
        System.out.println("constrain to range 3 between 1-9 : " + Ints.constrainToRange(3, 1, 9));
        System.out.println("constrain to range 3 between 4-6: " + Ints.constrainToRange(3, 4, 6));
    }

    private static void testShorts() {
        System.out.println("min short bytes: " + Short.BYTES);
        System.out.println("largest 2^n represented as short: " + Shorts.MAX_POWER_OF_TWO);
        System.out.println("Aslist: " + Shorts.asList((short)2, (short)3));
        System.out.println("Short value for 123: " + Shorts.checkedCast((long)123));
        System.out.println("Short value for 32767: " + Shorts.checkedCast((long)32767));
        //IllegalArguemntException
//        System.out.println("Short value for 32768: " + Shorts.checkedCast((long)32768));
        System.out.println("Compare 1 and 2 (a - b): " + Shorts.compare((short)1, (short)2));
        //concat, ensureCapacity, indexOf, lastIndexOf, 
        
        /*
         * Returns the short value whose big-endian representation is stored in the first 2 bytes of bytes; equivalent to ByteBuffer.wrap(bytes).getShort().
         */
        System.out.println("Byte array to short: " + Shorts.fromByteArray(new byte[]{(byte)0, (byte)0}));

        /*
         * Returns the short value whose byte representation is the given 2 bytes, in big-endian order; equivalent to Shorts.fromByteArray(new byte[] {b1, b2}).
         */
        System.out.println("Bytes to short: " + Shorts.fromBytes((byte)1, (byte)2));
        System.out.println("Join: " + Shorts.join("-", (short)2, (short)4, (short)4));

    
        /*
         * static Comparator<short[]> lexicographicalComparator()
            Returns a comparator that compares two short arrays lexicographically.
         */
        
        System.out.println("Max and min: " + Shorts.max((short)3, (short)4, (short)5) + " " + Shorts.min((short)3, (short)4, (short)5));

        /*
         * Returns the short nearest in value to value.
         */
        System.out.println("saturated cast 4000 and 90000: " + Shorts.saturatedCast((long) 4000) + " " + Shorts.saturatedCast((long)90000) );
        
        
        /*
         * static Converter<String,Short> stringConverter()
         * Returns a serializable converter object that converts between strings and shorts using Short.decode(java.lang.String) and Short.toString().
         */
        
        System.out.println("toarrya: " + Shorts.toArray(Arrays.asList(1,2,3)));
        //toByteArray
    }

    private static void testBytes() {
        System.out.println("Bytes: " + Byte.BYTES + " Size: " + Byte.SIZE + " Type: " + Byte.TYPE + " Range: " + Byte.MIN_VALUE + " - " + Byte.MAX_VALUE);
        byte[] byteArray = {(byte)1, (byte)2, (byte)3, (byte)4};
        System.out.println("As list: " + Bytes.asList(byteArray));
        System.out.println("byteArray contains 3? " + Bytes.contains(byteArray, (byte)3));
        System.out.println("Index of 3: " + Bytes.indexOf(byteArray, (byte)3));
        System.out.println("Concat 5,6,7 with 8,9, lenght: " + Bytes.concat(new byte[]{(byte)5, (byte)6, (byte)7}, new byte[]{(byte)8, (byte)9}).length);
        byte[] byteArray2 = Bytes.ensureCapacity(byteArray, 1, 7); // min lenght, padding
        System.out.println("Ensure capacity 1,7: ");
        for(int i=0; i<byteArray2.length; i++)
        {
            System.out.print(byteArray2[i]);
        }
        byte[] byteArray3 = Bytes.ensureCapacity(byteArray, 5, 1);
        System.out.println("\nEnsure capacity 5,1: ");
        for(int i=0; i<byteArray3.length; i++){
            System.out.print(byteArray3[i]);
        }
    }
}
