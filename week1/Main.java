package week1;

public class Main {

    public static void main(String[] args) {

        //  Scanner scanner = new Scanner(System.in);
        long n;

//        do {
//            n = scanner.nextInt();
//        } while (!(n >= 2 && n <= 2e5));
        long[] integerArray;
        boolean ok;

        do {
            do {
                n = (long) (Math.random() * 10);
                //n = 10;
            } while (n < 2);

              integerArray = new long[(int) n];


              for (int i = 0; i < n; i++)
                integerArray[i] = (long) (Math.random() * 200L);
         //   integerArray = new long[]{196376, 70470, 12368, 97871, 129238, 30222, 26425, 87880, 102584, 198496};

             System.out.println("-------------------------------------------------------------------");
            if (week1.Algorithm.naiveAlgo(n, integerArray) ==
                    Algorithm.findSecondRecursive(n, integerArray)){
                System.out.println("Ok");
                ok = true;
            } else
                ok = false;

//break;
        } while (ok);

        for (int i = 0; i < n; i++)
            System.out.print(integerArray[i] + " ");


        //  naiveAlgo(2, new long[]{36929, 174048});
        //ArrayFindLargest.findLargestProduct(2, new long[]{36929, 174048});
    }


}
