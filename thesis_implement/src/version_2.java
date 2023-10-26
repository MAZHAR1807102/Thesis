import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Random;
public class version_2 {

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
        int bit_length = 2048;
        Random rand = new SecureRandom();
        BigInteger p = new BigInteger("11");
        System.out.println(p);
       // BigInteger q = BigInteger.probablePrime(bit_length/2, rand);
        BigInteger q = new BigInteger("7");
        System.out.println(q);
        BigInteger m = p.multiply(q);
        System.out.println(m);
        //BigInteger r = BigInteger.probablePrime(bit_length/2, rand);
        BigInteger r = new BigInteger("2");
        System.out.println(r);
        BigInteger msg = new BigInteger("6");

        // Encryption
        BigInteger cipher = (msg.add(r.multiply(m)));
        cipher = cipher.mod(m);
        System.out.println(cipher);

        // Decryption
    }
}
