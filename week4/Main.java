package week4;

public class Main {

    public static void main(String[] args) {

       // int[] array = {10, 2, 5, 3, 7, 13, 1, 6};
//        array = new int[]{9, 8, 7, 3, 2, 1};
//         array = new int[]{9, 9, 3, 9, 2, 9, 2, 3, 9};
//        array = new int[]{2,3,9,2,9};
//
//        int n = array.length - 1;
//        System.out.println("Initial Array");
//        for (int i = 0; i <= n; i++)
//            System.out.print(array[i] + " ");
//
//        System.out.println("\n=======================================================");
//
//        int count = DivideAndConquer.numberOfInversions(array);
//
//        int[] resultArray = DivideAndConquer.mergeSort(0, n, array);
//
//        System.out.println("Sorted Array");
//        for (int i = 0; i <= n; i++)
//            System.out.print(resultArray[i] + " ");

//        DivideAndConquer.Result result = DivideAndConquer.numberOfInversions(0,n,array);
//        System.out.println(result.count);
//        System.out.println(count);
//        System.out.println("Sorted Array");
//        for (int i = 0; i <= n; i++)
//            System.out.print(result.array[i] + " ");


//        long[] sortedArray = new long[]{1, 5, 8, 12, 13};
//        long[] keyList = new long[]{8, 1, 23, 1, 11};
//
//        int[] results =DivideAndConquer.binarySearch(sortedArray, keyList);
//
//        for(Integer result: results)
//            System.out.print(result + " ");

//        long[] array = {1,5,1,5,1};
//        int n = array.length;
//
//       long[] result = DivideAndConquer.majorityElement(0, n - 1, array);
//        if (result == null)
//            System.out.println(0);
//        else
//            for (int i = 0; i < result.length; i++)
//                System.out.println(result[i] + " ");


        //boolean isMajority = false;


        //        for (int i = 0; i < n; i++) //O(n3)
//            if (DivideAndConquer.naiveMajorityElement(array[i], 0, n - 1, array) > n / 2) {
//                isMajority = true;
//                break;
//            }


//        if (isMajority)
//            System.out.println(1);
//        else
//            System.out.println(0);
//        Scanner s = new Scanner(System.in);
//        DivideAndConquer.Segment[] segments = new DivideAndConquer.Segment[]{
//                new DivideAndConquer.Segment(2, 3),
//                new DivideAndConquer.Segment(0, 5),
//                new DivideAndConquer.Segment(7, 10),
//                new DivideAndConquer.Segment(6, 6),
//                new DivideAndConquer.Segment(1, 1),
//                new DivideAndConquer.Segment(6, 7),
//                new DivideAndConquer.Segment(6, 7),
//                new DivideAndConquer.Segment(5, 6),
//                new DivideAndConquer.Segment(2, 7),
//                new DivideAndConquer.Segment(3,6),
//                new DivideAndConquer.Segment(6,8),
//                new DivideAndConquer.Segment(6,7),
//              //  new DivideAndConquer.Segment(6,2),
//                new DivideAndConquer.Segment(2,6),
//                new DivideAndConquer.Segment(6,7),
//                new DivideAndConquer.Segment(6,7),
//                new DivideAndConquer.Segment(6,6)
//        };
//
//        DivideAndConquer.Point[] points = new DivideAndConquer.Point[]{new DivideAndConquer.Point(1, 0),
//                new DivideAndConquer.Point(6, 1),
//                new DivideAndConquer.Point(11, 2),
//                new DivideAndConquer.Point(6, 3)};

//        DivideAndConquer.Segment[] segments = new DivideAndConquer.Segment[]{
//                new DivideAndConquer.Segment(-10, 10)
//        };
//        DivideAndConquer.Point[] points = new DivideAndConquer.Point[]{new DivideAndConquer.Point(-100, 0),
//                new DivideAndConquer.Point(-100, 1),
//                new DivideAndConquer.Point(0, 2)};

//        int[] count = DivideAndConquer.lotteryWinner(points, segments);
//
//        for (int i = 0; i < count.length; i++)
//            System.out.print(count[i] + " ");

//        DivideAndConquer.randomizedQuickSort(array, 0, array.length - 1);
//
//        for (int i = 0; i < array.length; i++)
//            System.out.print(array[i] + " ");

        DivideAndConquer.Point[] points = new DivideAndConquer.Point[]{
//                   new DivideAndConquer.Point(1,0),
//                new DivideAndConquer.Point(3, 4),
//                new DivideAndConquer.Point(7, 9),
//                new DivideAndConquer.Point(1, 100),
//                new DivideAndConquer.Point(4, 8),
//                new DivideAndConquer.Point(-7, 7),
//                new DivideAndConquer.Point(0, 2),
//                new DivideAndConquer.Point(5, -6),
//                new DivideAndConquer.Point(-3, -4),
                // new DivideAndConquer.Point(7, 2)
        };

        DivideAndConquer.ShortPair shortPair = DivideAndConquer.closestDistance(points);

        if (shortPair.getPair()[0] != null) {
            for (int i = 0; i < shortPair.getPair().length; i++) {
                System.out.println("x= " + shortPair.getPair()[i].getX() + " " +
                        "y= " + shortPair.getPair()[i].getY());
            }
        }
        System.out.println("shortest distance = " + shortPair.getDistance());
    }
}
