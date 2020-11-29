package week4;

import java.util.ArrayList;
import java.util.List;

public class DivideAndConquer {


    public static int[] binarySearch(long[] sortedArray, long[] keyList) {

        int[] indexList = new int[keyList.length];

        for (int i = 0; i < keyList.length; i++) {
            int lower = 0;
            int upper = sortedArray.length - 1;
            boolean found = false;
            int mid = -1;

            while (lower <= upper) {
                mid = (lower + upper) / 2;
                if (sortedArray[mid] == keyList[i]) {
                    found = true;
                    break;
                } else if (sortedArray[mid] > keyList[i])
                    upper = mid - 1;
                else if (sortedArray[mid] < keyList[i])
                    lower = mid + 1;
            }

            if (found)
                indexList[i] = mid;
            else
                indexList[i] = -1;
        }
        return indexList;

    }


    public static int naiveMajorityElement(int element, int lower, int upper, int[] array) {

        int mid = (lower + upper) / 2;

        if (lower == upper)
            return array[mid] == element ? 1 : 0;

        int a = naiveMajorityElement(element, lower, mid, array);
        int b = naiveMajorityElement(element, mid + 1, upper, array);

        return a + b;

    }

    public static int naiveMajorityElement2(long[] array) {
        int n = array.length;
        int count;

        for (int j = 0; j < n; j++) {
            count = 0;
            for (int i = 0; i < n; i++)
                if (array[i] == array[j]) {
                    count++;
                    if (count > n / 2)
                        return 1;
                }
        }
        return 0;
    }

    public static long[] majorityElement(int lower, int upper, long[] array) {


//        if (lower > upper)
//            return null;
//        for (int i = lower; i <= upper; i++)
//            if (array[i] == array[lower]) {
//                count++;
//                if (count > n / 2)
//                    return new long[]{array[lower], count};
//            }

//        if(lower + 1 == upper) {
//
//        if(array[lower] != array[upper])
//            return null;
//        else
//           return new long[]{array[lower],2};
//
//        }


        if (lower == upper)
            return new long[]{array[lower], 1};

        int mid = (lower + upper) / 2;

        long[] resultA = majorityElement(lower, mid, array);
        long[] resultB = majorityElement(mid + 1, upper, array);

        int n = upper - lower + 1;

        if (resultA != null && resultB != null) {

            if (resultA[0] == resultB[0])
                return resultA;

            resultA[1] = 0;
            resultB[1] = 0;

            for (int i = lower; i <= upper; i++) {
                if (array[i] == resultA[0])
                    resultA[1]++;
                if (array[i] == resultB[0])
                    resultB[1]++;
            }

            if (resultA[1] > n / 2)
                return resultA;
            else if (resultB[1] > n / 2)
                return resultB;
            else
                return null;
        }

        int count = 0;

        if (resultA != null) {
            for (int i = lower; i <= upper; i++)
                if (resultA[0] == array[i])
                    count++;

            resultA[1] = count;
            if (count > n / 2)
                return resultA;
        }

        count = 0;
        if (resultB != null) {
            for (int i = lower; i <= upper; i++)
                if (resultB[0] == array[i])
                    count++;

            resultB[1] = count;
            if (count > n / 2)
                return resultB;

        }

        return null;
    }


// merge sort Algorithm

/* Problem Statement:

   Given a sequence of numbers (an array) sort the sequence in increasing value of the numbers.
   (in ascending order)

   Algorithm:

   1. Take the sequence and divide it into two halves.
   2. Divide each part(sequence) further into halves of themselves.
   3. Repeat till you reach base case of having only one element (or one number) in the sequence.

   4. Store the single element sequence (singleton Array) and compare with its pair.
   5. Merge the sequence in ascending order (order of increasing value).

   6. Repeat steps 4 and 5 for pair.
   7. Repeat step 5 for every merged array pair repeatedly.

   8. Final merged array is sorted sequence.

 */

    public static int[] mergeSort(int lower, int upper, int[] array) {

        //base case

        if (lower == upper)
            return new int[]{array[lower]};

        // middle term is average of upper bound and lower bound
        int mid = (lower + upper) / 2;

        //first half
        int[] arrayA = mergeSort(lower, mid, array);

        //second half
        int[] arrayB = mergeSort(mid + 1, upper, array);

        return merge(arrayA, arrayB);

    }

    private static int[] merge(int[] arrayA, int[] arrayB) {

        int a = arrayA.length;
        int b = arrayB.length;
        int i = 0, j = 0, index = 0;
        // new array that will contain all elements of arrayA and arrayB
        // in sorted order
        int[] mergedArray = new int[a + b];

        while (a != 0 && b != 0) {

            if (arrayA[i] > arrayB[j]) {
                mergedArray[index++] = arrayB[j++];
                b--;
            } else {
                mergedArray[index++] = arrayA[i++];
                a--;
            }
        }

        if (a == 0) {
            while (b-- > 0) {
                mergedArray[index] = arrayB[j];
                index++;
                j++;
            }
        } else {
            while (a-- > 0) {
                mergedArray[index] = arrayA[i];
                index++;
                i++;
            }
        }


        return mergedArray;
    }


    public static int numberOfInversions(int[] array) {
        int count = 0;
        int n = array.length - 1;
        for (int i = 0; i <= n; i++)
            for (int j = i + 1; j <= n; j++) {
                System.out.print("-");
                if (array[i] > array[j])
                    count++;
            }
        return count;
    }

    public static class Result {
        int[] array;
        int count;

        public Result(int[] array) {
            this.array = array;
            this.count = 0;
        }

        public Result(int size) {
            this.array = new int[size];
            this.count = 0;
        }
    }

    public static Result numberOfInversions(int lower, int upper, int[] array) {

        if (lower >= upper)
            return new Result(new int[]{array[lower]});

        int mid = (lower + upper) / 2;


        Result resultA = numberOfInversions(lower, mid, array);
        Result resultB = numberOfInversions(mid + 1, upper, array);

        Result result = mergeArray(resultA, resultB);
        result.count += resultA.count + resultB.count;

        return result;

    }

    private static Result mergeArray(Result resultA, Result resultB) {

        int a = resultA.array.length;
        int b = resultB.array.length;
        int i = 0;
        Result resultArray = new Result(a + b);

        for (int j = 0; j < a; j++)
            for (int k = 0; k < b; k++) {
                System.out.print(".");
                if (resultA.array[j] > resultB.array[k])
                    resultArray.count++;
                else
                    break;
            }
        while (a != 0 && b != 0) {
            if (resultA.array[resultA.array.length - a] > resultB.array[resultB.array.length - b]) {
                resultArray.array[i++] = resultB.array[resultB.array.length - b];
                b--;
            } else {
                resultArray.array[i++] = resultA.array[resultA.array.length - a];
                a--;
            }
        }

        if (a == 0) {
            while (b != 0) {
                resultArray.array[i] = resultB.array[resultB.array.length - b];
                i++;
                b--;
            }

        } else {
            while (a != 0) {
                resultArray.array[i] = resultA.array[resultA.array.length - a];
                i++;
                a--;
            }

        }

        return resultArray;
    }

    public static class Sortable {
        long value;
        int pos;
        int type;

        public Sortable(long value, int pos, int type) {
            this.value = value;
            this.pos = pos;
            this.type = type;
        }
    }

//    public static class Segment {
//        long x;
//        long y;
//
//        public Segment(long x, long y) {
//            this.x = x;
//            this.y = y;
//        }
//
//    }
//
//    public static class Point {
//        long point;
//        int pos;
//
//        public Point(long point, int pos) {
//            this.point = point;
//            this.pos = pos;
//        }
//
//    }
//
//    public static int[] lotteryWinner(Point[] points, Segment[] segments) {
//        //place the points in between the segments when they share same x or y
//
//        Sortable[] sortable = new Sortable[points.length + (2 * segments.length)];
//
//        int i = 0, j;
//
//        for (j = 0; i < sortable.length; i += 2, j++) {
//            if (j == segments.length)
//                break;
//            sortable[i] = new Sortable(segments[j].x, 0, 1);
//            sortable[i + 1] = new Sortable(segments[j].y, 0, 3);
//
//        }
//
//        j = 0;
//        while (i < sortable.length) {
//            if (j == points.length)
//                break;
//            sortable[i++] = new Sortable(points[j].point, points[j++].pos, 2);
//        }
//
//        sortable = sort(0, sortable.length - 1, sortable);
//        int[] count = new int[points.length];
//
//        i = 0;
//        for (j = 0; j < sortable.length; j++) {
//            switch (sortable[j].type) {
//                case 1:
//                    i++;
//                    break;
//                case 3:
//                    i--;
//                    break;
//                case 2:
//                    count[sortable[j].pos] = i;
//                    break;
//            }
//
//
//        }
//
//
//        return count;
//    }
//
//    private static Sortable[] sort(int lower, int upper, Sortable[] sortable) {
//
//        if (lower == upper)
//            return new Sortable[]{sortable[lower]};
//
//        int mid = (lower + upper) / 2;
//
//        Sortable[] resultA = sort(lower, mid, sortable);
//        Sortable[] resultB = sort(mid + 1, upper, sortable);
//
//        return mergeSortable(resultA, resultB);
//    }
//
//    private static Sortable[] mergeSortable(Sortable[] resultA, Sortable[] resultB) {
//
//        int a = resultA.length;
//        int b = resultB.length;
//        Sortable[] result = new Sortable[a + b];
//        int index = 0;
//        while (a != 0 && b != 0) {
//            if (resultA[resultA.length - a].value > resultB[resultB.length - b].value) {
//                result[index++] = resultB[resultB.length - b];
//                b--;
//            } else if (resultA[resultA.length - a].value == resultB[resultB.length - b].value) {
//                if (resultA[resultA.length - a].type > resultB[resultB.length - b].type) {
//                    result[index++] = resultB[resultB.length - b];
//                    b--;
//                } else {
//                    result[index++] = resultA[resultA.length - a];
//                    a--;
//                }
//            } else {
//                result[index++] = resultA[resultA.length - a];
//                a--;
//            }
//
//        }
//
//        if (a == 0) {
//            while (b != 0) {
//                result[index++] = resultB[resultB.length - b];
//                b--;
//            }
//        } else
//            while (a != 0) {
//                result[index++] = resultA[resultA.length - a];
//                a--;
//            }
//        return result;
//    }
//
//
//    public static void quickSort(int[] array, int lower, int upper) {
//
//         while (lower < upper) {
//        if (lower >= upper)
//            return;
//        int index = randomIndex(lower, upper);
//        //  System.out.println(index);
//        int temp = array[index];
//        array[index] = array[lower];
//        array[lower] = temp;
//
//        int[] m = partition(array, lower, upper);
//
//           if (m[0] - lower < upper - m[1]) {
//        quickSort(array, lower, m[0] - 1);
//             lower = m[1] + 1;
//        } else {
//        quickSort(array, m[1] + 1, upper);
//          upper = m[0] - 1;
//        }
//
//        }
//    }
//
//    private static int randomIndex(int lower, int upper) {
//
//        int index;
//        while (true) {
//            index = (int) (Math.random() * (upper+1));
//            if (index >= lower)
//                return index;
//        }
//    }
//
//    private static Random random = new Random();
//
//    private static int[] partition(int[] array, int lower, int upper) {
//
//        int pivot = array[lower];
//        int temp;
//        int j = lower;
//        int k = 0;
//        for (int i = lower + 1; i <= upper; i++)
//            if (array[i] <= pivot) {
//                j++;
//                temp = array[i];
//                array[i] = array[j];
//                array[j] = temp;
//                if (array[j] == pivot)
//                    k++;
//            }
//        temp = array[lower];
//        array[lower] = array[j];
//        array[j] = temp;
//
//        int l = j - k;
//
//        for (int i = lower; i < l && j-k <j; i++)
//            if (array[i] == pivot) {
//                if (array[j - k] == pivot) {
//                    i--;
//                    k--;
//                    continue;
//                }
//                temp = array[i];
//                array[i] = array[j - k];
//                array[j - k] = temp;
//                k--;
//            }
//
//
//
//
//        return new int[]{l, j};
//    }
//
//
//    public static void randomizedQuickSort(int[] a, int l, int r) {
//        if (l >= r) {
//            return;
//        }
//        int k = random.nextInt(r - l + 1) + l;
//        int t = a[l];
//        a[l] = a[k];
//        a[k] = t;
//        //use partition3
//        int[] m = partition(a, l, r);
//        randomizedQuickSort(a, l, m[0] - 1);
//        randomizedQuickSort(a, m[1] + 1, r);
//    }

    public static class Point {
        private final int x;
        private final int y;

        Point(Point point) {
            this.x = point.x;
            this.y = point.y;
        }

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }

    enum SortBy {
        X,
        Y
    }

    public static ShortPair closestDistance(Point[] points) {

        if (points.length < 2)
            return new ShortPair();

        Point[] pointsX = new Point[points.length];
        Point[] pointsY = new Point[points.length];

        for (int i = 0; i < points.length; i++) {
            pointsX[i] = new Point(points[i]);
            pointsY[i] = new Point(points[i]);
        }

        pointsX = mergeSortPoints(pointsX, 0, pointsX.length - 1, SortBy.X);
        pointsY = mergeSortPoints(pointsY, 0, pointsY.length - 1, SortBy.Y);
        return closestDistance(pointsX, pointsY);
    }

    private static Point[] mergeSortPoints(Point[] points, int lower, int upper, SortBy sortBy) {

        if (lower == upper)
            return new Point[]{points[lower]};

        int mid = (lower + upper) / 2;

        Point[] pointsA = mergeSortPoints(points, lower, mid, sortBy);
        Point[] pointsB = mergeSortPoints(points, mid + 1, upper, sortBy);

        return merge(pointsA, pointsB, sortBy);

    }

    private static Point[] merge(Point[] pointsA, Point[] pointsB, SortBy sortBy) {

        int a = pointsA.length;
        int b = pointsB.length;
        int i = 0, j = 0, index = 0;
        Point[] points = new Point[a + b];

        while (a != 0 && b != 0) {
            if (sortBy(pointsA[i], pointsB[j], sortBy)) {
                points[index] = pointsA[i++];
                a--;
            } else {
                points[index] = pointsB[j++];
                b--;
            }
            index++;
        }

        if (a == 0) {
            while (b != 0) {
                points[index++] = pointsB[j++];
                b--;
            }
        } else
            while (a != 0) {
                points[index++] = pointsA[i++];
                a--;
            }
        return points;
    }

    private static boolean sortBy(Point point, Point pivot, SortBy sortBy) {
        if (sortBy == SortBy.X)
            return point.x <= pivot.x;
        else if (sortBy == SortBy.Y)
            return point.y <= pivot.y;
        else
            return false;
    }

    public static class ShortPair {
        private Point[] pair;
        private double distance;

        public ShortPair() {
            this.pair = new Point[2];
            this.distance = 0.0;
        }

        public Point[] getPair() {
            return pair;
        }

        public double getDistance() {
            return distance;
        }
    }

    private static ShortPair closestDistance(Point[] pointsX, Point[] pointsY) {

        if (pointsX.length <= 3)
            return calcShortestDistance(pointsX);

        int mid = (pointsX.length / 2);
        Point[] lPointsX = constructSpan(pointsX, 0, mid);
        Point[] rPointsX = constructSpan(pointsX, mid, pointsX.length - 1);
        Point[] lPointsY = constructSpan(pointsY, 0, mid);
        Point[] rPointsY = constructSpan(pointsY, mid, pointsY.length - 1);

        ShortPair[] shortPairs = new ShortPair[3];
        shortPairs[0] = closestDistance(lPointsX, pointsY);
        shortPairs[1] = closestDistance(rPointsX, pointsY);
        ShortPair shortPair;

        if (shortPairs[0].distance < shortPairs[1].distance)
            shortPair = shortPairs[0];
        else
            shortPair = shortPairs[1];

        ArrayList<Point> splitPoints = new ArrayList<>(constructSpan(shortPair.distance, mid, pointsY));

        if (splitPoints.size() > 1) {
            shortPairs[2] = calcShortestDistance(shortPair.distance, splitPoints);
            if (shortPairs[2].distance < shortPair.distance)
                shortPair = shortPairs[2];
        }

        shortPair.distance = (Math.round(shortPair.distance * 1000)) / 1000D;
        return shortPair;
    }

    private static List<Point> constructSpan(double dmin, int mid, Point[] points) {

        List<Point> splitPoints = new ArrayList<>();

        for (Point point : points) {
            int x = point.x < 0 ? -point.x : point.x;
            if (x <= dmin + points[mid].x)
                splitPoints.add(point);
        }
        return splitPoints;
    }

    private static Point[] constructSpan(Point[] points, int lower, int upper) {

        Point[] resultPoints = new Point[upper - lower + 1];

        for (int i = lower, j = 0; i <= upper; i++)
            resultPoints[j++] = points[i];

        return resultPoints;
    }

    private static ShortPair calcShortestDistance(Point[] points) {

        ShortPair shortPair = new ShortPair();
        double d;
        boolean first = true;
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                d = Math.sqrt((points[i].x - points[j].x) * (points[i].x - points[j].x) +
                        (points[i].y - points[j].y) * (points[i].y - points[j].y));
                if (first || d < shortPair.distance) {
                    shortPair.pair = new Point[]{points[i], points[j]};
                    shortPair.distance = d;
                    first = false;
                }
            }
        }
        return shortPair;
    }

    private static ShortPair calcShortestDistance(double dmin, ArrayList<Point> splitPoints) {

        ShortPair shortPair = new ShortPair();
        boolean first = true;
        for (int i = 0; i < splitPoints.size(); i++)
            for (int j = i + 1; j <= i + 8 && j < splitPoints.size(); j++) {
                double d = Math.sqrt((splitPoints.get(j).x - splitPoints.get(i).x) *
                        (splitPoints.get(j).x - splitPoints.get(i).x) +
                        (splitPoints.get(j).y - splitPoints.get(i).y) * (splitPoints.get(j).y - splitPoints.get(i).y));
                if (first || d < dmin) {
                    shortPair.pair = new Point[]{splitPoints.get(i), splitPoints.get(j)};
                    shortPair.distance = d;
                    first = false;
                }
            }

        return shortPair;
    }


//    private static final Random random = new Random();
//
//    private static void quickSortPoints(Point[] points, int lower, int upper, SortBy sortBy) {
//
//        while (lower < upper) {
//
//            int index = random.nextInt(upper - lower + 1) + lower;
//
//            Point temp = points[lower];
//            points[lower] = points[index];
//            points[index] = temp;
//
//            int[] m = partition(points, lower, upper, sortBy);
//
//            if (m[0] - lower < upper - m[1]) {
//                quickSortPoints(points, lower, m[0] - 1, sortBy);
//                lower = m[1] + 1;
//            } else {
//                quickSortPoints(points, m[1] + 1, upper, sortBy);
//                upper = m[0] - 1;
//            }
//
//        }
//
//    }
//
//    private static int[] partition(Point[] points, int lower, int upper, SortBy sortBy) {
//
//        Point pivot = points[lower];
//        int m1 = lower;
//        int duplicateCount = 0;
//        Point temp;
//
//        for (int i = lower + 1; i <= upper; i++) {
//            if (sortBy(points[i], pivot, sortBy)) {
//                if (isEqual(points[i], pivot))
//                    duplicateCount++;
//
//                m1++;
//                temp = points[i];
//                points[i] = points[m1];
//                points[m1] = temp;
//            }
//        }
//
//        temp = points[lower];
//        points[lower] = points[m1];
//        points[m1] = temp;
//
//        int m0 = m1 - duplicateCount;
//
//        for (int i = lower; i < m0 && m1 - duplicateCount < m1; i++) {
//
//            if (isEqual(points[i], pivot)) {
//                if (isEqual(points[m1 - duplicateCount], pivot)) {
//                    i--;
//                    duplicateCount--;
//                    continue;
//                }
//
//                temp = points[i];
//                points[i] = points[m1 - duplicateCount];
//                points[m1 - duplicateCount] = temp;
//                duplicateCount--;
//            }
//        }
//
//        return new int[]{m0, m1};
//    }


//    private static boolean isEqual(Point point, Point pivot) {
//        return point.x == pivot.x && point.y == pivot.y;
//    }


}


