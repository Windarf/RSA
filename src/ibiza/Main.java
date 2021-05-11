package ibiza;

import java.math.BigInteger;
import java.util.Scanner;

public class Main {

    private final static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Add meg, hogy hány bites prímszámokat szeretnél generálni!");
        BigInteger max = BigInteger.TWO.pow(scanner.nextInt());

        BigInteger p  = rsa.randomPrime(max);
        BigInteger q = rsa.randomPrime(max);
        if(p.equals(q) || !(euclidean.euclidean(p,q).equals(BigInteger.ONE))){
            q = rsa.randomPrime(max);
        }
        System.out.println("A generált prímek:" + "\n" +
                "p = " + p + "\n"+
                "q = " + q);

        BigInteger n = p.multiply(q);
        System.out.println("Az n értéke = " +n);

        BigInteger phin = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));
        System.out.println("A fi(n) értéke = " + phin);

        BigInteger e = rsa.getE(phin, max);
        e = rsa.testE(e,phin,max);
        System.out.println("Az e értéke = " + e + "\n" +
                           "A publikus kulcs: PK(n = " + n + ", e = " + e + ")" );

        BigInteger d = mod.modInvEuc(e, phin);
        //BigInteger d2 = mod.modInverse(e, phin);
        System.out.println("A titkus kulcs SK(d = " + d + ")");

        System.out.println("Add meg a titkosítani kívánt számot!" );
        BigInteger message = scanner.nextBigInteger();
        BigInteger titkos = mod.modPow(message, e, n);
        System.out.println("A megadott szám: " + message + " titkosítva: " + titkos);

        BigInteger tort1 = mod.modPow(titkos, d, n);
        System.out.println("Visszafejtés hagyományos módon: " + tort1);

        BigInteger tort2 = rsa.decrypt(titkos, p, q, d);
        System.out.println("Visszafejtés a kínai maradéktétel használatával: " + tort2);
    }
}
