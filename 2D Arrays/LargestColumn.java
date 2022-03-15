public class LargestColumn {
    public static void main(String[] args) {

        int[][] arr = { { 2, 3, 4 }, { 3, 4, 5 }, { 4, 6, 9 } };
        int maxSum = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = 0; j < arr[i].length; j++) {
                sum += arr[j][i];
            }
            maxSum = Math.max(sum, maxSum);
        }

        System.out.println(maxSum);

    }
}
