package demo;

import java.math.RoundingMode;

import com.google.common.base.Charsets;
import com.google.common.collect.ComparisonChain;
import com.google.common.math.IntMath;

public class GuavaMath {

    //IntMath, LongMath, BigIntegerMath
    public static void main(String[] args) {
        
        //binomial(n,k)= n!/(k!(n-k)!)
        System.out.println("Binomial(7,4) = " + IntMath.binomial(7, 4));
        //Greatest power of two closer to
        System.out.println("ceiling power of two(9): " + IntMath.ceilingPowerOfTwo(9));
        //Add
        System.out.println("31+9 = " + IntMath.checkedAdd(31, 9));
        System.out.println("-1+3 = " + IntMath.checkedAdd(-1, 3));
        System.out.println("3*9 = " + IntMath.checkedMultiply(3, 9));
        System.out.println("3^3 = " + IntMath.checkedPow(3, 3));
        System.out.println("3-4 = " + IntMath.checkedSubtract(3, 4));
        System.out.println("3-(-4) = " + IntMath.checkedSubtract(3, -4));
        System.out.println("10/2 = " + IntMath.divide(10, 2, RoundingMode.HALF_EVEN));
        System.out.println("10/3 = " + IntMath.divide(10, 3, RoundingMode.HALF_EVEN));
        System.out.println("3! = " + IntMath.factorial(3));
        System.out.println("floor power of two (9): " + IntMath.floorPowerOfTwo(9));
        System.out.println("Greatest common divisor (24,36): " + IntMath.gcd(24, 36));
        System.out.println("Is 9 power of 2? " +  IntMath.isPowerOfTwo(9));
        System.out.println("Is 1024 power of 2? " + IntMath.isPowerOfTwo(1024));
        System.out.println("Is 23 prime? " + IntMath.isPrime(23));
        System.out.println("log10(1000) = " + IntMath.log10(1000, RoundingMode.HALF_EVEN));
        System.out.println("log2(32) = " + IntMath.log2(32, RoundingMode.HALF_EVEN));
        System.out.println("mean(3,5) = " + IntMath.mean(3, 5));
        //Second param is the limit
        System.out.println("mod(10,3) = " + IntMath.mod(10, 3));
        System.out.println("3^3 = " + IntMath.pow(3, 3));
        System.out.println("saturated add(2147483647 + 1) = " + IntMath.saturatedAdd(2147483647 , 1 ));
        System.out.println("sqrt(2) = " + IntMath.sqrt(2, RoundingMode.HALF_EVEN));
        System.out.println("sqrt(81) = " + IntMath.sqrt(81, RoundingMode.HALF_EVEN));
}
