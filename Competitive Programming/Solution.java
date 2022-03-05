public class Solution {
    public static int maximumSwap(int num) {
        if (num < 10) {
            return num;
        }

        int[] digit = new int[10];
        int counter = 0;

        while (num > 0) {
            digit[counter++] = num % 10;
            num = num / 10;
        }

        int largest = -1;
        int index = -1;
        for (int i = 0; i < counter; i++) {
            if (digit[i] > largest) {
                largest = digit[i];
                index = i;
            }
        }

        digit[index] = digit[counter - 1];
        digit[counter - 1] = largest;

        int ans = 0;

        for (int i = 0; i < counter; i++) {
            ans = ans + digit[i] * (int) Math.pow(10, i);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(maximumSwap(2736));
    }
}