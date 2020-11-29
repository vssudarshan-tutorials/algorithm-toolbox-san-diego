package week2;

public class Algorithm {


    public static short findLastDigitFibonacci(int n) {

        if (n <= 1)
            return (short) n;

        short lastDigit = 0;
        short oldDigit = 0;
        short newDigit = 1;


        for (int i = 2; i <= n; i++) {
            lastDigit = (short) (oldDigit + newDigit);
            lastDigit = (short) (lastDigit % 10);
            oldDigit = newDigit;
            newDigit = lastDigit;
        }

        System.out.println("Fibonacci number " + n + " Last Digit: " + lastDigit);

        return lastDigit;


    }


    public static long findFibonacci(long n) {

        if (n <= 1)
            return n;

        long sum = 0;
        long oldSum = 0;
        long newSum = 1;


        for (int i = 2; i <= n; i++) {
            sum = oldSum + newSum;
            oldSum = newSum;
            newSum = sum;
        }

        System.out.println("Fibonacci number " + n + " : " + sum);

        return sum;
    }

    public static long findFibonacciNaive(int n) {
        return findFibonacciNaive(n, "n");
    }

    public static long findFibonacciNaive(int n, String message) {

        System.out.println("n is:" + n + " " + message);

        if (n <= 1) {
            System.out.println("Return n: " + n);
            return n;
        } else {

            System.out.println("Now running n - 1");
            long a = findFibonacciNaive(n - 1, "n-1");
            System.out.println("n is: " + n + " " + message);
            System.out.println("Now running n - 2");
            long b = findFibonacciNaive(n - 2, "n-2");
            long result = a + b;
            System.out.println("n is: " + n + " " + message);
            System.out.println("Result: " + result);
            return result;
        }

    }


    public static long getFibonacciHugeNaive(long n, long m) {
        if (n <= 1)
            return n;

        long oldSum = 0;
        long newSum = 1;
        long sum = 0;
        for (int i = 2; i <= n; i++) {
            sum = newSum + oldSum;
            oldSum = newSum;
            newSum = sum;
        }


        System.out.println("Naive: " + sum % m);
        return sum % m;
    }


    public static long pisanoNumber(long mod) {

        long oldSum = 0;
        long newSum = 1;
        long sum;
        for (int i = 2; true; i++) {
            sum = newSum + oldSum;
            sum %= mod;
            oldSum = newSum;
            newSum = sum;
            if (sum % mod == 1 && oldSum % mod == 0) {
                System.out.println(i - 1);
                return i - 1;
            }
        }

    }

    public static long fibonacciSumLastDigit(long n) {

        long pisanoNumber = pisanoNumber(10);
        long limit = n % pisanoNumber;
        //  long multiple = n / pisanoNumber;// == 0 ? 1 : n / pisanoNumber;
        if (limit <= 1) {
            return limit;
        }

        long oldSum = 0;
        long newSum = 1;
        long sum;
        long fibSum = 1;
        for (int i = 2; i <= limit; i++) {
            sum = newSum + oldSum;
            sum %= 10;
            oldSum = newSum;
            newSum = sum;
            fibSum += sum;
            fibSum %= 10;
        }

        // System.out.println("Pisano Number: " + pisanoNumber + " n: " + n + " Fibonacci Number mod: " + sum);
        System.out.println("Fast: " + fibSum);


        return fibSum;

    }


    public static long fibonacciPartialSumLastDigit(long m, long n) {

        long pisanoNumber = pisanoNumber(10);
        long start = m % pisanoNumber;
        long limit = n % pisanoNumber;

        if (limit <= 1) {
            return limit;
        }

        long oldSum = 0;
        long newSum = 1;
        long sum;
        long fibSum = 0;
        if(start <= 1)
            fibSum = 1;

        for (long i = 2; i <= limit; i++) {
            sum = newSum + oldSum;
            sum %= 10;
            oldSum = newSum;
            newSum = sum;
            if (i >= start) {
                fibSum += sum;
                fibSum %= 10;
            }
        }

        // System.out.println("Pisano Number: " + pisanoNumber + " n: " + n + " Fibonacci Number mod: " + sum);
        System.out.println("Fast: " + fibSum);


        return fibSum;

    }


    public static long findModFibonacci(long n, long mod) {

        long pisanoNumber = pisanoNumber(mod);
        n = n % pisanoNumber;  // fib mod n is periodic with period of Pisano Number. 
        if (n <= 1) {
            return n;
        }

        long oldSum = 0;
        long newSum = 1;
        long sum = 0;
        for (int i = 2; i <= n; i++) {
            sum = newSum + oldSum;
            // fib = nq + r => fib - r = nq so fib is modulo congruent with r for n.
            sum %= mod;
            oldSum = newSum;
            newSum = sum;
        }
        System.out.println("Fast: " + sum);


        System.out.println("Pisano Number: " + pisanoNumber + " n: " + n + " Fibonacci Number mod: " + sum);


        return sum;

    }
}
