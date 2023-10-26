import java.math.BigInteger;
import java.util.Random;

public class ElGamal {
    static BigInteger modInv(BigInteger a, BigInteger p)
    {
        if(a.equals(new BigInteger("0")))
        {
            return new BigInteger("0");
        }
        BigInteger lm = new BigInteger("1"), hm = new BigInteger("0");
        BigInteger low = a.mod(p), high = p;
        while(low.compareTo(new BigInteger("1"))== 1)
        {
            BigInteger ratio = high.divide(low);
            BigInteger nm = hm.subtract(lm).multiply(ratio);
            BigInteger nw = high.subtract(low).multiply(ratio);
            lm.equals(nm); low.equals(nw); hm.equals(lm); high.equals(low);
        }
        return lm.mod(p);
    }
    static BigInteger genKey(BigInteger p, BigInteger g)
    {
        Random rand = new Random();
        //BigInteger len = new BigInteger("1").subtract(p.subtract(new BigInteger("2")));
        BigInteger x = new BigInteger(5, rand);
        BigInteger y = g.modPow(x,p);
        return  x;
    }

    static  BigInteger encryption(BigInteger msg, BigInteger p, BigInteger g, BigInteger y)
    {
        Random rand = new Random();
        //BigInteger len = new BigInteger("1").subtract(p.subtract(new BigInteger("2")));
        BigInteger x = new BigInteger(5, rand);
return x;
    }

}
