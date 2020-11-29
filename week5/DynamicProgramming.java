import java.util.ArrayList;
import java.util.Collections;

public class DynamicProgramming {


    public static int minimumChange(int money, int[] coins) {

        int[] minNumCoins = new int[money + 1];

        for (int i = 1; i < minNumCoins.length; i++) {
            minNumCoins[i] = Integer.MAX_VALUE;
            for (int j = 0; j < coins.length; j++) {
                if (i >= coins[j]) {
                    int numCoins = minNumCoins[i - coins[j]] + 1;
                    if (numCoins < minNumCoins[i])
                        minNumCoins[i] = numCoins;
                }
            }
        }
        return minNumCoins[money];
    }


    public static ArrayList<Integer> primitiveCalculator(int value) {
        //  int[] operations = new int[]{1, 2, 3};
        int[] z = new int[value + 1];
        int temp;

        for (int i = 2; i < z.length; i++) {
            z[i] = Integer.MAX_VALUE;
            int numOperations = z[i - 1] + 1;
            temp = z[i / 2] + (i % 2) + 1;
            numOperations = Math.min(numOperations, temp);
            if (i >= 3) {
                temp = z[i / 3] + (i % 3) + 1;
                numOperations = Math.min(numOperations, temp);
            }

            if (numOperations < z[i])
                z[i] = numOperations;
        }


        ArrayList<Integer> inter = new ArrayList<>();

        temp = value;
        while (temp != 1) {

            if (temp % 2 != 0 && temp % 3 != 0) {
                inter.add(temp);
                temp--;
            }

            while (temp % 2 == 0) {
                inter.add(temp);
                temp /= 2;
            }

            while (temp % 3 == 0) {
                inter.add(temp);
                temp /= 3;
            }

        }

        inter.add(temp);
        inter.add(z[value]);
        Collections.reverse(inter);
        return inter;
    }


    public static int editDistance(String s1, String s2) {

        int[][] eD = new int[s1.length() + 1][s2.length() + 1];

        int edTemp;
        for (int i = 0; i < eD.length; i++)
            for (int j = 0; j < eD[0].length; j++) {
                if (i == 0)
                    eD[i][j] = j;
                else if (j == 0)
                    eD[i][j] = i;
                else {
                    int ins = eD[i][j - 1] + 1;
                    int del = eD[i - 1][j] + 1;
                    int mis = eD[i - 1][j - 1] + 1;
                    int mat = eD[i - 1][j - 1];
                    edTemp = Math.min(ins, del);
                    if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                        eD[i][j] = Math.min(edTemp, mat);
                    } else
                        eD[i][j] = Math.min(edTemp, mis);
                }
            }
        return eD[s1.length()][s2.length()];
    }

    public static int longestCommonSequence(int[] a, int[] b) {


        int[][] operations = new int[a.length + 1][b.length + 1];
        int tempOpr;

        for (int i = 0; i < operations.length; i++)
            for (int j = 0; j < operations[0].length; j++) {

                if (i == 0) {
                    operations[i][j] = j;
                } else if (j == 0) {
                    operations[i][j] = i;
                } else {

                    int ins = operations[i][j - 1] + 1;
                    int del = operations[i - 1][j] + 1;
                    int mat = operations[i - 1][j - 1];

                    tempOpr = Math.min(ins, del);

                    if (a[i - 1] == b[j - 1])
                        operations[i][j] = Math.min(mat, tempOpr);
                    else
                        operations[i][j] = tempOpr;
                }
            }
        return (a.length + b.length - operations[a.length][b.length]) / 2;
    }

    public static int longestCommonSequence(int[] a, int[] b, int[] c) {


        int[][][] lcs = new int[a.length + 1][b.length + 1][c.length + 1];
        int tempAS;

        for (int i = 0; i < lcs.length; i++)
            for (int j = 0; j < lcs[0].length; j++)
                for (int k = 0; k < lcs[0][0].length; k++) {
                    if (i == 0 || j == 0 || k == 0) {
                        lcs[i][j][k] = 0;

                    } else {

                        int ins = lcs[i][j - 1][k];
                        int del = lcs[i - 1][j][k];
                        int indel = lcs[i][j][k - 1];

                        tempAS = Math.max(ins, del);
                        if (a[i - 1] == b[j - 1] && b[j - 1] == c[k - 1])
                            lcs[i][j][k] = lcs[i - 1][j - 1][k - 1] + 1;
                        else
                            lcs[i][j][k] = Math.max(tempAS,indel);
                    }
                }
        return lcs[a.length][b.length][c.length];
    }


    





}



