public class LargestColumnOrRow {

    public static void main(String[] args) {

        int[][] arr = { { 2, 3, 4 }, { 3, 4, 5 }, { 4, 6, 9 } };
        int maxSum = Integer.MIN_VALUE;
        int index = -1;
        boolean isRow = false;

        // COLUMN
        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = 0; j < arr[i].length; j++) {
                sum += arr[j][i];
            }
            if (maxSum < sum) {
                maxSum = sum;
                index = i;
            }
        }

        // ROW
        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            int j = 0;
            for (; j < arr[i].length; j++) {
                sum += arr[i][j];
            }
            if (maxSum < sum) {
                maxSum = sum;
                index = j;
                isRow = true;
            }
        }

        if (isRow) {
            System.out.println("row");
        } else {
            System.out.println("column");
        }

        System.out.println(maxSum + " " + index);

    }

}
