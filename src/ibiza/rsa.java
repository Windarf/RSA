package ibiza;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class rsa {

    public static BigInteger randomPrime(BigInteger max) {
        BigInteger randP;
        BigInteger min = BigInteger.TWO;

        while (true) {
            randP = rsa.randomBigInt(min, max);
            if (millerRabin.isPrime(randP, 3)) {
                return randP;
            }
        }
    }

    public static BigInteger randomBigInt(BigInteger min, BigInteger max) {

        BigInteger result = new BigInteger(max.bitLength(), new Random());

        if (result.compareTo(min) < 0) {
            result = result.add(min);
        } else {
            result = result.mod(max.subtract(min)).add(min);
        }

        return result;
    }
    public static BigInteger decrypt(BigInteger message, BigInteger p, BigInteger q, BigInteger d) {
        BigInteger reduceC1 = message.mod(p);
        BigInteger reduceC2 = message.mod(q);

        BigInteger reduceD1 = d.mod(p.subtract(BigInteger.ONE));
        BigInteger reduceD2 = d.mod(q.subtract(BigInteger.ONE));

        List<BigInteger> c = new ArrayList<>();
        List<BigInteger> m = new ArrayList<>();

        c.add(mod.modPow(reduceC1, reduceD1, p));
        c.add(mod.modPow(reduceC2, reduceD2, q));

        m.add(p);
        m.add(q);

        return chinese.crt(c, m);
    }

    public static BigInteger getE(BigInteger phin, BigInteger max){
        BigInteger e = rsa.randomBigInt(BigInteger.TWO ,max);
        while(!(e.compareTo(BigInteger.ONE) > 0 && e.compareTo(phin) < 0) && !(euclidean.euclidean(e,phin).equals(BigInteger.ONE))){
            e = rsa.randomBigInt(BigInteger.TWO, max);
        }
        return e;
    }

    public static BigInteger testE(BigInteger e, BigInteger phin, BigInteger max){
        while(!(euclidean.euclidean(e,phin).equals(BigInteger.ONE))){
            e = rsa.getE(phin, max);
        }
        return e;
    }
}
