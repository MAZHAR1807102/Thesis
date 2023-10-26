// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Random;

public class Main {


    static int concat(int a, int b)
    {

        // Convert both the integers to string
        String s1 = Integer.toString(a);
        String s2 = Integer.toString(b);

        // Concatenate both strings
        String s = s1 + s2;

        // Convert the concatenated string
        // to integer
        int c = Integer.parseInt(s);

        // return the formed integer
        return c;
    }

    public static void main(String[] args) {
        int bit_length = 1024;
        Random rand = new SecureRandom();
        BigInteger p = BigInteger.probablePrime(bit_length/2, rand);
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
        System.out.println("Message : "+"3");
        System.out.println("Cipher : "+"25");
        System.out.println("Plaintext : "+"3");
        BigInteger msg = new BigInteger("3");

        // Encryption
        BigInteger cipher = (msg.add(r.multiply(p.pow(q.intValue()))));
        cipher = cipher.mod(m);
        System.out.println(cipher);

        // Decryption
        msg = cipher.mod(p);
        System.out.println(msg);
    }

}