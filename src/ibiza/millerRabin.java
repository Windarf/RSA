package ibiza;

import java.math.BigInteger;

public class millerRabin {

    private static boolean millerRabinTest(BigInteger n, BigInteger m) {

        BigInteger a = rsa.randomBigInt(BigInteger.TWO, n);
        BigInteger x = mod.modPow(a, m, n);

        if (x.equals(BigInteger.ONE) || x.equals(n.subtract(BigInteger.ONE)))
            return true;

        while (!m.equals(n.subtract(BigInteger.ONE))) {
            x = x.pow(2).mod(n);
            m = m.multiply(BigInteger.TWO);
            if (x.equals(BigInteger.ONE))
                return false;
            if (x.equals(n.subtract(BigInteger.ONE)))
                return true;
        }
        return false;
    }

    public static boolean isPrime(BigInteger n, int k) {
        if (n.compareTo(BigInteger.ONE) <= 0 || n.compareTo(new BigInteger("4")) == 0)
            return false;
        if (n.compareTo(new BigInteger("3")) <= 0)
            return true;

        BigInteger m = n.subtract(BigInteger.ONE);

        while (m.mod(BigInteger.TWO).equals(BigInteger.ZERO))
            m = m.divide(BigInteger.TWO);

        for (int i = 0; i < k; i++) {
            if (!millerRabinTest(n, m))
                return false;
        }

        return true;
    }
}
