package week1;

public class Algorithm {


    /*Various algorithms to find largest and second largest numbers in an array */

    /* TO-DO
     *  Write code for N + logN -2 comparisons
     *  Write code for 3rd largest
     *  Binary tree/graph implementation
     *
     *
     *
     *
     *  */

    public static long fastAlgo(long n, long[] integerArray) {
        int index = 0;
        long product = 0;
        int i, count = 0;
        for (i = 0; i < n - 1; i++) {
            count++;
            if (integerArray[i] > integerArray[index])  //n-1 comparisons
                index = i;
        }
        int icount = 0;
        for (i = 1; i < n; i++) {
            count++;
            if (i != index)
                if (integerArray[i] * integerArray[index] > product) {   //n-1 comparisons
                    product = integerArray[i] * integerArray[index];
                    icount = i;
                }
        }
        System.out.println("fastAlgo: " + integerArray[icount] + " x " + integerArray[index] + " = " + product);
        System.out.println("Array Length: " + n);
        System.out.println("Comparisons 2N-2: " + count);
        System.out.println("=========================");

        return product;
    }

    public static long naiveAlgo(long n, long[] integerArray) {

        long product = 0;
        int icount = 0, jcount = 0, count = 0;

        for (int i = 0; i < n - 1; i++)
            for (int j = i + 1; j < n; j++) {
                count++; // (n-1) (n-1+1) / 2 comparisons
                if (integerArray[i] * integerArray[j] > product) {
                    product = integerArray[i] * integerArray[j];
                    icount = i;
                    jcount = j;
                }
            }

        System.out.println("naiveAlgo: " + integerArray[jcount] + "(" + jcount + ")" + " x " + integerArray[icount] + "(" + icount + ")" + " = " + product);
        System.out.println("Array Length: " + n);
        System.out.println("Comparisons (N^2-N)by2: " + count);
        System.out.println("=========================");

        return product;
    }


    public static long comparison1_5N(long n, long[] array) {

        //  System.out.println("Array length: "  + n);
        int count = 0;
        int index1 = 0;
        int index2 = (int) (n / 2);

        for (int i = 1; i < n / 2; i++) {   //n/2-1 comparisons
            count++;
            if (array[i] > array[index1])
                index1 = i;
        }

        for (int i = (int) (n / 2) + 1; i < n; i++) {
            count++;
            if (array[i] > array[index2])  //n/2 comparisons
                index2 = i;
        }

        if (array[index1] > array[index2]) {      //1
            for (int i = 0; i < n / 2; i++) {                      //n/2 comparisons
                count++;
                if (array[i] > array[index2] && i != index1)
                    index2 = i;
            }
        } else if (array[index1] < array[index2]) {
            for (int i = (int) (n / 2); i < n; i++) {     //n/2+1
                count++;
                if (array[i] > array[index1] && i != index2)
                    index1 = i;
            }
        }


        //if(array[i -1] > array[index2] && (array[i - 1] <= array[index1]) && (i - 1 != index1))
        //    index2 = i - 1;


        System.out.println("comparison: " + array[index1] + "(" + index1 + ")" + " x " + array[index2] + "(" + index2 + ")" + " = " + array[index1] * array[index2]);
        System.out.println("Array Length: " + n);
        System.out.println("Comparisons 1.5N: " + count);
        System.out.println("=========================");
        return array[index1] * array[index2];
    }


    public static long comparison2N_1(long n, long[] array) {

        long product;
        int largestMax = 0, largestMin = 0, count = 0;

        for (int i = 0; i < n / 2; i++) {
            count += 3;
            if (array[2 * i] > array[2 * i + 1]) { //n/2 comparisons
                swap(array, i);
            }
            if (array[2 * i + 1] > array[largestMax]) { //n/2 comparisons
                largestMax = 2 * i + 1;
            }

            if (array[2 * i] > array[largestMin]) { //n/2 comparisons
                largestMin = 2 * i;
            }
        }

        if (n % 2 != 0) {
            count++;
            if (array[(int) n - 1] > array[largestMax])  //1 comparison
                largestMax = (int) n - 1;
            else if (array[(int) n - 1] > array[largestMin])
                largestMin = (int) n - 1;
        }

        for (int i = 0; i < n / 2; i++) {    //n/2 comparisons
            count++;
            if (array[2 * i + 1] > array[largestMin] && ((2 * i + 1) != largestMax))
                largestMin = 2 * i + 1;
        }

        product = array[largestMax] * array[largestMin];
        System.out.println("comparison2N_1: " + array[largestMax] + "(" + largestMax + ")" + " x " + array[largestMin] + "(" + largestMin + ")" + " = " + product);
        System.out.println("Array Length: " + n);
        System.out.println("Comparisons 2N-1: " + count);
        System.out.println("=========================");
        return product;
    }

    public static void swap(long[] array, int i) {

        long temp = array[2 * i + 1];
        array[2 * i + 1] = array[2 * i];
        array[2 * i] = temp;

    }


    /*      N + logN -2 comparisons tutorial code               */


    public static long findSecondRecursive(long n, long[] A) {
        long[] firstCompared = findMaxTournament(0, (int) n - 1, A); //n-1 comparisons;
        long[] secondCompared = findMaxTournament(1, firstCompared.length -1, firstCompared); //log2(n)-1 comparisons.
        //Total comparisons: n+log2(n)-2;

        System.out.println("comparison: " + firstCompared[0] + "(" + 1 + ")" + " x " + secondCompared[0] + "(" + 1 + ")" + " = " + secondCompared[0] * firstCompared[0]);
        System.out.println("Array Length: " + n);
        return secondCompared[0] * firstCompared[0];
    }

    private static long[] findMaxTournament(int low, int high, long[] A) {
        if (low == high) {
            return new long[]{A[low]};
        }
        long[] compared1 = findMaxTournament(low, (low + high) / 2, A);
        long[] compared2 = findMaxTournament((low + high) / 2 + 1, high, A);
        if (compared1[0] > compared2[0]) {
            long[] newcompared1 = new long[compared1.length + 1];
            System.arraycopy(compared1, 0, newcompared1, 0, compared1.length);
            newcompared1[compared1.length] = compared2[0];
            return newcompared1;
        }
        long[] newcompared2 = new long[compared2.length + 1];
        System.arraycopy(compared2, 0, newcompared2, 0, compared2.length);
        newcompared2[compared2.length] = compared1[0];
        return newcompared2;
    }

  /*  public static long comparisonN_logN_2(long n, long[] array) {

        long[] maxArray = recursiveMax(n, array);

        System.out.println("comparison: " + maxArray[0] + "(" + 0 + ")" + " x " + maxArray[1] + "(" + 1 + ")" + " = " + maxArray[0] * maxArray[1]);
        System.out.println("Array Length: " + n);
        System.out.println("Max Array length: " + maxArray.length);
        //System.out.println("Comparisons 2N-1: " + count);
        System.out.println("=========================");
        return maxArray[0] * maxArray[1];


    }

*/
   /* public static long[] recursiveMax(long n, long[] array) {


        long[] maxArray = new long[(int)n];






        if (n == 0)
            return maxArray;
        else
            maxArray = recursiveMax((int) n / 2, maxArray);

        return maxArray;

    }

*/
}
