package ibiza;

import java.math.BigInteger;

public class mod {

    public static BigInteger modPow(BigInteger a, BigInteger e, BigInteger m) {
        BigInteger result = BigInteger.ONE;
        BigInteger apow = a;

        while (!e.equals(BigInteger.ZERO)) {
            if (e.testBit(0)) {
                result = result.multiply(apow).mod(m);
            }
            e = e.shiftRight(1);
            apow = apow.multiply(apow).mod(m);
        }

        return result;
    }

    public static BigInteger modInvEuc(BigInteger a, BigInteger m){
        BigInteger result = euclidean.extEuclidean(m, a)[2];

        if (result.signum() != 1){
            result = m.add(result);
        }
        return result;
    }

    public static BigInteger modInverse(BigInteger a, BigInteger m) {
        BigInteger m0 = m;
        BigInteger x = BigInteger.ONE;
        BigInteger y = BigInteger.ZERO;

        if (m.equals(BigInteger.ONE))
            return BigInteger.ZERO;

        while (a.compareTo(BigInteger.ONE) > 0) {
            BigInteger q = a.divide(m);
            BigInteger temp = m;
            m = a.mod(m);
            a = temp;
            temp = y;
            y = x.subtract(q.multiply(y));
            x = temp;
        }

        if (x.compareTo(BigInteger.ZERO) < 0) {
            x = x.add(m0);
        }

        return x;
    }
}