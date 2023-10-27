// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
import java.math.BigInteger;
import java.math.BigInteger.*;
import java.security.SecureRandom;
import java.util.Random;

public class Main {

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
    void modPow(BigInteger p, BigInteger q, BigInteger m)
    {
        modInverse(p, m);
    }
    public static void main(String[] args) {
        int bit_length = 2048;
        Random rand = new SecureRandom();
        BigInteger p = BigInteger.probablePrime(bit_length, rand);
        //BigInteger p = new BigInteger("11");
        System.out.println("P : " + p);
        BigInteger q = BigInteger.probablePrime(bit_length/2, rand);
        //BigInteger q = new BigInteger("7");
        System.out.println("Q : "+q);
        BigInteger m = p.multiply(q);
        System.out.println("M : "+m);
        BigInteger r = BigInteger.probablePrime(bit_length/2, rand);
        //BigInteger r = new BigInteger("2");
        System.out.println("R : "+r);
        //System.out.println("Message : "+msg);
       // System.out.println("Cipher : "+"25");
        //System.out.println("Plaintext : "+"3");
        BigInteger msg = new BigInteger("3");
        System.out.println("Message : "+msg);

        // Encryption
        BigInteger cipher = (msg.add(r.multiply(p.modPow(q,m))));
       // cipher = cipher.mod(m);
        System.out.println("Cipher = " +cipher);
//public BigInteger decrypt(BigInteger p)
        // Decryption
        msg = cipher.mod(p);
        System.out.println("message = " + msg);
    }

}