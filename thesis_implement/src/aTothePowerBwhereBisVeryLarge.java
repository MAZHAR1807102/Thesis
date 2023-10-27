import java.io.*;
public class aTothePowerBwhereBisVeryLarge {
    // Java program to find
// (a^b)%m for b very large.
        // Function to find power
        static long power(long a,
                          long remainB, long m)
        {
            long res = 1; // Initialize result

            // Update x if it is more
            // than or equal to p
            a = a % m;

            while (remainB > 0)
            {
                // If y is odd, multiply
                // x with the result
                if ((remainB & 1) > 0)
                    res = (res * a) % m;

                // y must be even now
                remainB = remainB >> 1; // y = y/2
                a = (a * a) % m;
            }
            return res;
        }

        // Driver Code
        public static void main (String[] args)
        {
            long a = 3;

// String input as
// b is very large
            String b = "100000000000000000000000000";

            long remainderB = 0;
            long m = 1000000007;

// Reduce the number B to a small
// number using Fermat Little
            for (int i = 0; i < b.length(); i++)
                remainderB = (remainderB * 10 + b.charAt(i) - '0') % (m - 1);
            System.out.println(power(a, remainderB, m));
        }
    }

// This code is contributed by anuj_67.


