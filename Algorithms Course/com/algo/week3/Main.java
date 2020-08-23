package com.algo.week3;

public class Main {
    public static void main(String[] args) {
//        int i = 0, coins;
//        do {
//            int m = (int) (Math.random() * 2000);
//            coins = GreedyAlgo.numberOfCoins(m);
//
//            System.out.println("Amount: " + m + " Coins: " + coins);
//        }while (i++ < 20000);

//
//        while ((n = (int) (Math.random() * 11)) < 2) ;
//
//
//        while ((capacity = (int) (Math.random() * 11)) < 2) ;
//        int n = 3;
//        int capacity = 50;
//        int[] values = new int[]{60,100,120};
//        int[] weights = new int[]{20,50,30};
//        int value, weight;
        //  for (int i = 0; i < n; i++) {

//            do {
//                while ((value = (int) (Math.random() * 101)) == 0) ;
//                while ((weight = (int) (Math.random() * 101)) == 0) ;
//            } while (value % weight == 0);
//            values[i] = value;
//            weights[i] = weight;
//        }
//        System.out.println(Double.MAX_VALUE);
//
//        double totalValue = GreedyAlgo.maximizeLoot(capacity, values, weights);
//
//        System.out.println("capacity: " + capacity);
//
//        System.out.println("Total: " + totalValue);
//        System.out.println("\n\nInputs");
//
//        for (int i = 0; i < values.length; i++) {
//            System.out.println("Value: " + values[i] + " Weight: " + weights[i]);
//        }

//        long[] a = new long[]{-2, 3, -5};
//        long[] b = new long[]{1, 4, 1};
//
//        GreedyAlgo.Segment[] segments = {new GreedyAlgo.Segment(4, 7),
//                new GreedyAlgo.Segment(1, 3),
//                new GreedyAlgo.Segment(2, 5),
//                new GreedyAlgo.Segment(5, 6),
//        new GreedyAlgo.Segment(2,2),
//        new GreedyAlgo.Segment(6,7)};
//        //System.out.println(GreedyAlgo.maximizeRevenue(a,b));
//
//
//        long[] result = GreedyAlgo.minimumPoints(segments);
//
//        for (int i = 0; i < result.length; i++)
//            System.out.println("Value: " + result[i]);

//        int n = 3;
//        long[] a = new long[]{23, 39, 92,};
//        System.out.println(GreedyAlgo.maximumSalary(n, a));

        long[] result = GreedyAlgo.maximumPrize(2);
        System.out.println(result.length);
        for (int i = 0; i < result.length; i++)
            System.out.print(result[i] + " ");


    }


}



