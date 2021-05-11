package ibiza;

import java.math.BigInteger;

public class euclidean {

    public static BigInteger euclidean(BigInteger a, BigInteger b) {
        while (!b.equals(BigInteger.ZERO)) {
            BigInteger r = a.mod(b);
            a = b;
            b = r;
        }
        return a;
    }

    public static BigInteger[] extEuclidean(BigInteger a, BigInteger b) {
        BigInteger x1 = BigInteger.ZERO;
        BigInteger y0 = BigInteger.ZERO;
        BigInteger x0 = BigInteger.ONE;
        BigInteger y1 = BigInteger.ONE;
        BigInteger n = BigInteger.ONE;
        BigInteger x = x1;
        BigInteger y = y1;

        while (!b.equals(BigInteger.ZERO)) {
            BigInteger r = a.mod(b);
            BigInteger q = a.divide(b);
            a = b;
            b = r;
            x = x1;
            y = y1;
            x1 = q.multiply(x1).add(x0);
            y1 = q.multiply(y1).add(y0);
            x0 = x;
            y0 = y;
            n = n.negate();
            x = n.multiply(x0);
            y = n.negate().multiply(y0);
        }

        return new BigInteger[]{a, x, y};
    }
}