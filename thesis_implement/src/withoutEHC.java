import java.math.BigInteger;
import java.math.BigInteger.*;
import java.security.SecureRandom;
import java.util.Random;


public class withoutEHC {

    // Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in



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

            //BigInteger M = new BigInteger("5876356376575377524657265746458454567356763576375");
            BigInteger M = new BigInteger("2182259874932070736374");
            System.out.println("Main Message from sender  " + M);
            BigInteger n = new BigInteger("6");
            BigInteger Path = new BigInteger("2");
            BigInteger G = n.divide(Path);
            int N = G.intValue();
            BigInteger[][] msg_ID = new BigInteger[2][G.intValue()];
            BigInteger one = new BigInteger("1");
            BigInteger msg_ID_sum = new BigInteger("0");

            for (BigInteger i = BigInteger.ZERO; i.compareTo(G) < 0; i = i.add(new BigInteger("1")))        {
                msg_ID[0][i.intValue()]=i;
                msg_ID[1][i.intValue()] = M.divide(G);
                System.out.print(msg_ID[0][i.intValue()]);
                System.out.print("        ");
                System.out.println(msg_ID[1][i.intValue()]);
                msg_ID_sum = msg_ID_sum.add(i);

            }
            System.out.println("Sum of the IDs: " + msg_ID_sum);

            //  BigInteger msg_ID_sum = new BigInteger("0");
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
            // BigInteger msg = (M.divide(n));
            System.out.println("Message : "+msg_ID[1][0]);

            // Encryption
            BigInteger cipher = (msg_ID[1][0].add(r.multiply(p.modPow(q,m))));
           // System.out.println(cipher);
            // cipher = cipher.mod(m);
            BigInteger[][] Cipher = new BigInteger[2][G.intValue()];
           // BigInteger Cipher1 = msg_ID[1][0];

            //for (BigInteger i = BigInteger.ZERO; i.compareTo(G) < 0; i = i.add(new BigInteger("1")))        {
                cipher = cipher.multiply(G);
              //  System.out.println(cipher);
            //}

            System.out.println("Cipher = " +cipher);

            //  cipher = cipher.multiply(G);
//public BigInteger decrypt(BigInteger p)
            // Decryption at the receiver end
            BigInteger Decrypted;
            Decrypted = cipher.mod(p);
            System.out.println("message = " + Decrypted);
        }

    }

