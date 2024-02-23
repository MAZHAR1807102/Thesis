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
    static BigInteger modInverse(BigInteger a, BigInteger m)
    {
        BigInteger result = new BigInteger("1");
        BigInteger k3 = new BigInteger("2");
        if (!(__gcd(a, m).intValue()==1))
            System.out.print("Inverse doesn't exist");

        else {

            // If a and m are relatively prime, then
            // modulo inverse is a^(m-2) mode m
            result = power(a, m.subtract(k3), m);
        }
        return  result;
    }
    void modPow(BigInteger p, BigInteger q, BigInteger m)
    {
        modInverse(p, m);
    }
    public static void main(String[] args) {

        long start = System.nanoTime();
        //BigInteger Message = new BigInteger("587635637657537752465726574645845456735674");
        BigInteger Message = new BigInteger("5876356376575377524657265746458454567356746735473478377762348437482742744827432877348375575873478343843389438738947389473748347839473847389743894735");
        //BigInteger Message = new BigInteger("9");

        System.out.println("The original message is: "+Message);

        // BigInteger M = new BigInteger("9");

        BigInteger n = new BigInteger("15");
        BigInteger Path = new BigInteger("3");
        BigInteger G = n.divide(Path);
        int N = G.intValue();
        BigInteger[][] msg_ID = new BigInteger[2][G.intValue()];
        BigInteger one = new BigInteger("1");
        BigInteger msg_ID_sum = new BigInteger("0");

        for (BigInteger i = BigInteger.ZERO; i.compareTo(G) < 0; i = i.add(new BigInteger("1"))){
            msg_ID[0][i.intValue()]=i;
            msg_ID[1][i.intValue()] = Message.divide(G);
            System.out.print(msg_ID[0][i.intValue()]);
            System.out.print("        ");
            System.out.println(msg_ID[1][i.intValue()]);
            msg_ID_sum = msg_ID_sum.add(i);

        }
        System.out.println("Sum of the IDs: " + msg_ID_sum);

        // BigInteger msg_ID_sum = new BigInteger("0");
        int bit_length = 1024;
        Random rand = new SecureRandom();
        BigInteger p = BigInteger.probablePrime(bit_length, rand);
        //BigInteger p = new BigInteger("11");
        System.out.println("P : " + p);
        BigInteger q = BigInteger.probablePrime(bit_length/2, rand);
        //BigInteger q = new BigInteger("7");
        System.out.println("Q : "+q);
        BigInteger m = p.multiply(q);
        System.out.println("m : "+m);
        BigInteger r = BigInteger.probablePrime(bit_length/2, rand);
       // BigInteger r = new BigInteger("2");
        System.out.println("R : "+r);
        //System.out.println("Message : "+msg);
       // System.out.println("Cipher : "+"25");
        //System.out.println("Plaintext : "+"3");
       // BigInteger msg = (M.divide(n));
        System.out.println("Message : "+msg_ID[1][0]);

        // Encryption
        BigInteger cipher = (msg_ID[1][0].add(r.multiply(p.modPow(q,m))));
       // cipher = cipher.mod(m);
        //BigInteger[][] Cipher = new BigInteger[2][G.intValue()];
        BigInteger Cipher1 = msg_ID[1][0];
        System.out.println("Cipher = " +cipher);
        BigInteger Homomorphic_cipher = new BigInteger("0");
        for (BigInteger i = BigInteger.ZERO; i.compareTo(G) < 0; i = i.add(new BigInteger("1"))){
           // System.out.println(i);
            Homomorphic_cipher = Homomorphic_cipher.add(cipher);
           // System.out.println(Homomorphic_cipher);
        }
       // cipher = Homomorphic_cipher;

        System.out.println("Additive Cipher = " +Homomorphic_cipher);
//public BigInteger decrypt(BigInteger p)
        // Decryption at the receiver end
        BigInteger Decrypted;
        Decrypted = Homomorphic_cipher.mod(p);
        System.out.println("message = " + Decrypted);

        if(Message.equals(Decrypted))
        {System.out.println("Message is correct");}
        long duration = (System.nanoTime()-start)/1000000;
        System.out.println("ExecutionTime " + duration + "ms");
    }

}