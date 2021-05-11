package ibiza;

import java.math.BigInteger;

public class algorithm_tests {
    public static void main(String[] args) {

        System.out.println("ModPow");
        System.out.println(mod.modPow(new BigInteger("123"), new BigInteger("27473"), new BigInteger("2719513991")).toString());


        System.out.println("Euclidean");
        System.out.println(euclidean.euclidean(new BigInteger("27473"), new BigInteger("2719408032")).toString());


        System.out.println("ModInverse");
        System.out.println(mod.modInvEuc(new BigInteger("27473"), new BigInteger("2719408032")));
        System.out.println(mod.modInverse(new BigInteger("27473"), new BigInteger("2719408032")).toString());


        System.out.println("Miller-Rabin");
        System.out.println(millerRabin.isPrime(new BigInteger("62327"), 7));
        System.out.println(millerRabin.isPrime(new BigInteger("43633"), 2));


        System.out.println("Extended Euclidean");
        BigInteger[] test1 = euclidean.extEuclidean(new BigInteger("27473"), new BigInteger("2719408032"));
        BigInteger[] test2 = euclidean.extEuclidean(new BigInteger("62327"), new BigInteger("43633"));
        System.out.println("Lnko: " + test1[0] + ", x: " + test1[1] + ", y: " + test1[2]); // 7, 4, -7
        System.out.println("Lnko: " + test2[0] + ", x: " + test2[1] + ", y: " + test2[2]); // 1, -1, 10
    }
}
