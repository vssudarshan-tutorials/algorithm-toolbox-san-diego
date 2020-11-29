package week2;

import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int n = 331;
        int m;
        boolean ok = false;
        //do {


          //  do {
                n = 1000;//(int) (Math.random() * 1000);
                m = 2; //(int) (Math.random() * 1000);

        week2.Algorithm.fibonacciSumLastDigit(n);
                //  n = scanner.nextInt();
          //  } while (!(n >= 0 && n <= 45 && m >= 2));

            System.out.println("n: " + n + " m: " + m);
            //long a = Algorithm.findModFibonacci(n, m);
           // long b = Algorithm.getFibonacciHugeNaive(n, m);
//            if (a == b) {
//                System.out.println("OK");
//                ok = true;
//            }
//        } while (ok);


//        System.out.println("Result: " + Algorithm.findLastDigitFibonacci(n));

    }


}
