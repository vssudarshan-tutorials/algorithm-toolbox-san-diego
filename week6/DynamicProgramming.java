package week6;

public class DynamicProgramming {

    public static int discreteKnapsack(int totalWeight, int[] weights) {

        int[][] values = new int[weights.length + 1][totalWeight + 1];

        for (int i = 0; i < values.length; i++)
            for (int j = 0; j < values[0].length; j++) {
                if (i == 0 || j == 0)
                    values[i][j] = 0;
                else {

                    values[i][j] = values[i - 1][j];

                    if (weights[i - 1] <= j) {
                        int temp = values[i - 1][j - weights[i - 1]] + weights[i - 1];

                        if (values[i][j] < temp)
                            values[i][j] = temp;
                    }
                }
            }
        return values[weights.length][totalWeight];
    }

    public static int evenPartition(int[] values) {
        int sum = 0;
        for (int i = 0; i < values.length; i++)
            sum += values[i];

        if (sum % 3 != 0)
            return 0;

        int partValue = sum / 3;
        int[][] partition = new int[values.length + 1][partValue + 1];
        int[] tracker = new int[values.length + 1];

        for (int i = 0; i < 3; i++)
            if (evenPartition(values, partition, tracker) != partValue)
                return 0;

        return 1;
    }

    private static int evenPartition(int[] values, int[][] partition, int[] tracker) {

        for (int i = 0; i < partition.length; i++) {
            if (tracker[i] != 0)
                continue;
            for (int j = 0; j < partition[0].length; j++) {

                if (i == 0 || j == 0)
                    partition[i][j] = 0;
                else {

                    partition[i][j] = partition[i - 1][j];

                    if (values[i - 1] <= j) {

                        int temp = partition[i - 1][j - values[i - 1]] + values[i - 1];

                        if (partition[i][j] < temp) {
                            partition[i][j] = temp;
                            tracker[i] = 1;
                        }
                    }
                }
            }
        }
        return partition[values.length][partition[0].length - 1];
    }

    enum Operation {
        ADD,
        DIFF,
        MULTI
    }

    private static int operation(int value1, int value2, Operation operation) {

        switch (operation) {
            case ADD:
                return value1 + value2;
            case DIFF:
                return value1 - value2;
            case MULTI:
                return value1 * value2;
            default:
                return 0;
        }
    }

    private static int[] minAndMax(int[][] maxTable, int[][] minTable, int i, int j, Operation[] operation) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;


        for (int k = i; k < j; k++) {
            int a = operation(maxTable[i][k], maxTable[k + 1][j], operation[k]);
            int b = operation(maxTable[i][k], minTable[k + 1][j], operation[k]);
            int c = operation(minTable[i][k], maxTable[k + 1][j], operation[k]);
            int d = operation(minTable[i][k], minTable[k + 1][j], operation[k]);

            min = Math.min(Math.min(Math.min(a, b), Math.min(c, d)), min);
            max = Math.max(Math.max(Math.max(a, b), Math.max(c, d)), max);

        }

        return new int[]{min, max};
    }


    private static void parentheses(int[] values, Operation[] operations, int[][] max, int[][] min) {

        for (int s = 0; s < values.length; s++)
            for (int i = 0; i < values.length - s; i++) {
                int j = i + s;
                if (i == j) {
                    max[i][i] = values[i];
                    min[i][i] = values[i];
                } else {
                    int[] result = minAndMax(max, min, i, j, operations);
                    min[i][j] = result[0];
                    max[i][j] = result[1];
                }
            }
    }

    public static int maximumValue(String expression) {

        int n = expression.length();
        if (n % 2 == 0)
            return 0;

        int[] values = new int[(n / 2) + 1];
        Operation[] operations = new Operation[n / 2];

        for (int i = 0, j = 0, k = 0; i < n; i++) {
            if (i % 2 == 0)
                values[j++] = expression.charAt(i) - 48;
            else
                switch (expression.charAt(i)) {
                    case '+':
                        operations[k++] = Operation.ADD;
                        break;
                    case '-':
                        operations[k++] = Operation.DIFF;
                        break;
                    case '*':
                        operations[k++] = Operation.MULTI;
                }
        }

        int[][] max = new int[values.length][values.length];
        int[][] min = new int[values.length][values.length];

        parentheses(values, operations, max, min);

        return max[0][values.length - 1];
    }

    public static void ex(){
        int i;
        for(i=0;i<1000;i++){
            if(i==50)
                break;
        }
        System.out.println(i);
    }

}
