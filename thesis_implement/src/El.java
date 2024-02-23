import java.math.BigInteger;
import java.security.SecureRandom;

public class El{

        private static BigInteger[] publicKey; // {p, g, h}
        private static BigInteger privateKey; // x

        public static void main(String[] args) {
            Long start = System.nanoTime();
            // Generate public and private keys
            generateKeys();

            // Message to be encrypted
            //BigInteger message = new BigInteger("12345678901234567890");
            BigInteger message = new BigInteger("5876356376575377524657265746458454567356746735473478377762348437482742744827432877348375575873478343843389438738947389473748347839473847389743894735");
            // Encrypt the message
            BigInteger[] cipher = encrypt(message);
            System.out.println("Encrypted Message: ");
            System.out.println("c1: " + cipher[0]);
            System.out.println("c2: " + cipher[1]);

            // Decrypt the message
            BigInteger decryptedMessage = decrypt(cipher);
            System.out.println("Decrypted Message: " + decryptedMessage);
            long duration = (System.nanoTime()-start)/100000;
            System.out.println("ExecutionTime " + duration + " ms");
        }

        // Generate public and private keys
        public static void generateKeys() {
            SecureRandom random = new SecureRandom();
            BigInteger p = BigInteger.probablePrime(1024, random); // 128-bit prime
            BigInteger g = new BigInteger("2"); // generator
            privateKey = new BigInteger(p.bitCount() - 2, random).add(BigInteger.ONE); // private key x

            // Compute public key h = g^x mod p
            BigInteger h = g.modPow(privateKey, p);

            publicKey = new BigInteger[]{p, g, h};
        }

        // Encrypt message using ElGamal
        public static BigInteger[] encrypt(BigInteger message) {
            SecureRandom random = new SecureRandom();
            BigInteger p = publicKey[0];
            BigInteger g = publicKey[1];
            BigInteger h = publicKey[2];

            // Select a random value k
            BigInteger k;
            do {
                k = new BigInteger(p.bitCount() - 2, random).add(BigInteger.ONE); // 1 < k < p-1
            } while (k.compareTo(p.subtract(BigInteger.ONE)) >= 0 || k.gcd(p.subtract(BigInteger.ONE)).compareTo(BigInteger.ONE) != 0);

            // Compute c1 = g^k mod p
            BigInteger c1 = g.modPow(k, p);

            // Compute c2 = (h^k * message) mod p
            BigInteger c2 = h.modPow(k, p).multiply(message).mod(p);

            return new BigInteger[]{c1, c2};
        }

        // Decrypt message using ElGamal
        public static BigInteger decrypt(BigInteger[] cipher) {
            BigInteger p = publicKey[0];
            BigInteger privateKey = El.privateKey;

            // Compute (c1^x)^(-1) mod p
            BigInteger c1x = cipher[0].modPow(privateKey, p).modInverse(p);

            // Compute original message = c2 * (c1^x)^(-1) mod p
            BigInteger originalMessage = cipher[1].multiply(c1x).mod(p);

            return originalMessage;

        }

    }

