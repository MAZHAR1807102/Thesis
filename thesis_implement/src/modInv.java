import java.math.BigInteger;

public class modInv {
    // Java program to find modular
// inverse of 'a' under modulo m
// using Fermat's little theorem.
// This program works only if m is prime.

   // BigInteger k2 = new BigInteger("1");
        static BigInteger __gcd(BigInteger a, BigInteger b)
        {

            if (b.intValue()==0) {
                return a;
            }
            else {
                return __gcd(b, a.mod(b));
            }
        }

        // To compute x^y under modulo m
        static BigInteger power(BigInteger x, BigInteger y, BigInteger m)
        {
            BigInteger k = new BigInteger("1");
            if (y.intValue()==0)
                return k;
            BigInteger k1 = new BigInteger("2");
            BigInteger p = power(x, y.divide(k1), m).mod(m);
            p = (p.multiply(p)).mod(m);

            return (y.mod(k1).intValue()==0) ? p : (x.multiply(p).mod(m));
        }

        // Function to find modular
        // inverse of 'a' under modulo m
        // Assumption: m is prime
        static void modInverse(BigInteger a, BigInteger m)
        {
           BigInteger k3 = new BigInteger("2");
            if (!(__gcd(a, m).intValue()==1))
                System.out.print("Inverse doesn't exist");

            else {

                // If a and m are relatively prime, then
                // modulo inverse is a^(m-2) mode m
                System.out.print(
                        "Modular multiplicative inverse is "
                                + power(a, m.subtract(k3), m));
            }
        }

        // Driver code
        public static void main(String[] args)
        {
            BigInteger a =new BigInteger("11") ;
            BigInteger m =new BigInteger("13");
            modInverse(a, m);
        }
    }


