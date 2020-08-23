package com.algo.week3;

public class GreedyAlgo {


    public static int numberOfCoins(long amount) {

        //largest denomination first

        int[] denomination = new int[]{10, 5, 1};

        int coins = 0;
        long change = amount;

        for (int i = 0; i < denomination.length; i++) {
            coins += (int) (change / denomination[i]);
            change = change % denomination[i];
        }
        return coins;
    }


    public static double maximizeLoot(int capacity, int[] value, int[] weight) {

        double totalValue = 0;
        for (int i = 0; i < value.length; i++) {

            if (capacity == 0) {
                return (Math.round(totalValue / 10) / 1000D);
            }

            int index = bestItem(value, weight);
            int bestWeight = Math.min(capacity, weight[index]);
            //precision up to 1e3, so take values up to 1e4 then round.
            totalValue += (double) value[index] * bestWeight * 10000 / weight[index];
            totalValue = Math.round(totalValue);
            weight[index] -= bestWeight;
            capacity -= bestWeight;
        }
        // final answer drop 1s place then round and finally float value of 1e3.
        return (Math.round(totalValue / 10) / 1000D);
    }

    private static int bestItem(int[] value, int[] weight) {

        int index = 0;
        double maxPerUnit = 0;

        for (int i = 0; i < value.length; i++) {
            if (weight[index] == 0)
                index = i;

            if (weight[i] != 0) {

                if ((double) value[i] / weight[i] > maxPerUnit) {
                    maxPerUnit = (double) value[i] / weight[i];
                    maxPerUnit = Math.round(maxPerUnit * 1000) / 1000.0D;
                    index = i;
                }

            }
        }

        return index;
    }


    public static long maximizeRevenue(int[] a, int[] b) {
        long result = 0;
        int index = 0;
        while (index < a.length) {
            int maxA = findMax(index, a);
            int maxB = findMax(index, b);
            result += maxA * maxB;
            index++;
        }

        return result;
    }

    static int findMax(int index, int[] a) {
        int maxA = a[index], indexA = index;

        for (int i = index; i < a.length; i++) {
            if (a[i] > maxA) {
                maxA = a[i];
                indexA = i;
            }
        }
        int temp = a[index];
        a[index] = a[indexA];
        a[indexA] = temp;

        return maxA;
    }


    public static long[] maximumPrize(long n) {
        long tempN = n;
        long integer = 1;

        int index = 0, count = 0;
        long[] solution = new long[(int) n / 2];

        while (tempN >= 0) {

            tempN -= integer;

            if (tempN > integer) {
                solution[index++] = integer;
                count++;
            } else {
                solution[index] = tempN + integer;
                count++;
                break;
            }
            integer++;
        }

        long[] answer = new long[count];
        for (int k = 0; k < count; k++)
            answer[k] = solution[k];

        return answer;
    }


    public static String maximumSalary(long n, long[] a) {


        for (int i = 0; i < a.length; i++) {

            for (int j = i + 1; j < a.length; j++) {

                if (!isGreater(a[i], a[j])) {
                    long temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }

            }
        }


        String s = "";

        for (int i = 0; i < a.length; i++)
            s = s + a[i];

        return s;

    }

    private static boolean isGreater(long a, long b) {

        int countI = 0;
        long valueI = a;

        do {
            valueI /= 10;
            countI++;

        } while (valueI != 0);

        int countJ = 0;
        long valueJ = b;

        do {
            valueJ /= 10;
            countJ++;

        } while (valueJ != 0);

        long tempA = a;

        for (int i = 0; i < countJ; i++)
            tempA *= 10;

        tempA += b;

        long tempB = b;
        for (int i = 0; i < countI; i++)
            tempB *= 10;

        tempB += a;

        return tempA >= tempB;
    }

    public static long[] minimumPoints(GreedyAlgo.Segment[] segments) {
//Greedy choice minimum right value
        sortLineSegments(segments);
        int index, k = 0, i = 0;
        long[] points = new long[segments.length];

        while (i < segments.length) {
            index = minB(i, segments);
            points[k] = segments[index].end;
            for (int j = i; j < segments.length; j++) {
                if (segments[j].start > points[k] || segments[j].end < points[k]) {
                    break;
                } else
                    i++;
            }
            k++;
        }

        long[] optimalPoints = new long[k];

        for (i = 0; i < k; i++) {
            optimalPoints[i] = points[i];
        }
        return optimalPoints;
    }

    private static int minB(int index, GreedyAlgo.Segment[] segments) {
        int minBIndex = index;
        for (int i = index;
             i < segments.length; i++)
            if (segments[i].end < segments[minBIndex].end)
                minBIndex = i;

        return minBIndex;
    }

    private static void sortLineSegments(Segment[] segment) {

        boolean sorted;

        do {
            sorted = true;
            for (int i = 0; i < segment.length - 1; i++) {
                if (segment[i].start > segment[i + 1].start) {
                    long tempA = segment[i].start;
                    long tempB = segment[i].end;
                    segment[i].start = segment[i + 1].start;
                    segment[i].end = segment[i + 1].end;
                    segment[i + 1].start = tempA;
                    segment[i + 1].end = tempB;
                    sorted = false;
                }
            }
        } while (!sorted);


    }


    public static class Segment {
        long start;
        long end;

        public Segment(int start, int end) {
            this.start = start;
            this.end = end;
        }


    }


}


