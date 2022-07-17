import java.util.ArrayList;

public class SubsequenceSum {

    public static void main(String[] args) {
        int arr[] = new int[]{1, 3, 2};
        int sum = 3;
        int n = arr.length;
        ArrayList<Integer> list = new ArrayList<>();

        printSequence(arr, arr.length, 0, 0, sum, list);
    }

    public static void printSequence(int[] arr, int n, int index, int sum, int reqSum, ArrayList<Integer> list) {

        if (n == index) {
            if (sum == reqSum) {
                System.out.println(list.toString());
            }
            return;
        }

        list.add(arr[index]);
        printSequence(arr, n, index + 1, sum + arr[index], reqSum, list);

        list.remove(list.size() - 1);
        printSequence(arr, n, index + 1, sum, reqSum, list);
    }

}
