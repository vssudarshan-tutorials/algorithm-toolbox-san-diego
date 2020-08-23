package com.algo.week2;

public class FindGCD {


    public static void main(String[] args) {

        boolean okay = false;
        long a, b;


        do {
            while (!((a = (int) (Math.random() * 2000)) > 0)) ;
            while (!((b = (int) (Math.random() * 2000)) > 0)) ;

            okay = lcm(a, b) == naiveLCM(a, b);

            if (okay)
                System.out.println("okay");
        } while (okay);

//        System.out.println(LCM(6,8));
        //   System.out.println(LCM(28851538,1183019));
    }


    static long naiveGCD(long a, long b) {


        long best = 0;

        for (long i = 1; i <= a + b; i++) {
            if (a % i == 0 && b % i == 0)
                best = i;
        }

        System.out.println("Naive: " + best + " a: " + a + " b: " + b);
        return best;

    }


    static long euclidGCD(long a, long b) {

        if (b == 0) {
      //      System.out.println("Euclid: " + a);
            return a;
        }
        long c = a % b;

        return euclidGCD(b, c);

    }


    static long naiveLCM(long a, long b) {

        for (long i = (int) Math.sqrt(a * b); i <= a * b; i++)
            if (i % a == 0 && i % b == 0) {
                System.out.println("Naive: " + i + " a: " + a + " b: " + b);
                return i;
            }

        return a * b;
    }


    static long lcm(long a, long b) {
        long lcm = (a * b) / euclidGCD(a, b);

        System.out.println("Best: " + lcm + " a: " + a + " b: " + b);
        return lcm;
    }

}