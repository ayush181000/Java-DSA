import java.util.ArrayList;

public class SubsequencesRecursion {

    public static void main(String[] args) {
        int arr[] = new int[]{3, 1, 2};
        int n = arr.length;
        ArrayList<Integer> list = new ArrayList<>();

        printSubsequences(arr, 0, n, list);
    }

    public static void printSubsequences(int[] arr, int index, int n, ArrayList<Integer> list) {
        if (index == n) {
            System.out.println(list.toString());
            return;
        }

        list.add(arr[index]);
        printSubsequences(arr, index + 1, n, list);

        list.remove(list.size() - 1);
        printSubsequences(arr, index + 1, n, list);
    }
}
