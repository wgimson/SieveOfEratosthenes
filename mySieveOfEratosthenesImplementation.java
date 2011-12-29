// Sieve of Eratosthenes implementation - finds all prime numbers less than 
// a user specified integer - also tallies total number of primes from 0 to
// user specified integer
// import java.util for Scanner class
import java.util.*;

public class mySieveOfEratosthenesImplementation {
    public static void main(String[] args) {
        
        // eratosthenes limit is the user provided number to calculate all 
        // primes up to - implemented as long type to provide for values up to
        // 9,223,372,036,854,775,807 - primeCount will be incremented at the 
        // end of the algorithm for each prime found and output
        long eratosthenesLimit = 0, startTime, endTime;
        int primeCount = 0;

        // get the integer n  to which the user wants to find all prime numbers
        // less than - the length of our sole data structure will be n+1
        System.out.println("\nPlease enter an integer to find all "
                + "primes less than: ");
        Scanner inputScanner = new Scanner(System.in);
        if (inputScanner.hasNextLong()) {
            eratosthenesLimit = inputScanner.nextLong();
        }
        
        // the only data structure we reequire is an array of booleans
        // where indexes represent every number from 0 to n - primes will hold 
        // the value true, and composites will contain the value false - all 
        // indices are initialized to true
        boolean[] primesArray = new boolean[(int)eratosthenesLimit+1];
        for (int i = 0; i < primesArray.length; i++) {
            primesArray[i] = true;
        }
        
        // we will set primesArray[0] and primesArray[1] to False, because 
        // neither 0 nor 1 are prime, and set p, our 'pointer' to current prime 
        // numbers, to 2, the first prime number
        primesArray[0] = primesArray[1] = false;
        int p = 2;
        
        // this loop will continue until the variable j, representing the prime
        // currently under consideration, equals the last index in primesArray
        startTime = System.currentTimeMillis();
        doLoop:
            do {
                // increment i by the value of the prime and mark those indices 
                // as false, for composite - equivalent to marking every number
                // for which p is a factor as composite
                for (int i = p+p; i <= eratosthenesLimit; i+=p) {
                    primesArray[i] = false;
                }

                // find first index marked true for prime and set to p - if j 
                // makes it to the end of primeArray, algorithm is finished and
                // only primes will be left with true values
                for (int j = p+1; j < primesArray.length; j++) {
                    if (primesArray[j] == true) {
                        p = j;
                        break;
                    }

                    if (j >= primesArray.length - 2) {
                        break doLoop;
                    }
                }
            } while (true);

        endTime = System.currentTimeMillis();
        
        // print output
        System.out.println("\nPrimes from 0 to " + eratosthenesLimit);
        System.out.println("----------------------");
        for (int i = 0; i < primesArray.length; i++) {
            if (primesArray[i] == true) {
                System.out.printf("\n%8d",i);
                primeCount++;
            }
        }
        System.out.println("\n\nThe total number of primes from 0 to " +
                eratosthenesLimit + " is: " + primeCount);
        System.out.println("\nThe total time needed to calculate primes from" +
                " 0 to " + eratosthenesLimit + " is: " + (endTime - startTime)
                + " milliseconds");
    }
}

