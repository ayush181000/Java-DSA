public class CountDigit {
    public static void main(String[] args) {
        System.out.println(numberOfDigit(234234234));
    }

    public static int numberOfDigit(int n) {

        if (n == 0) {
            return 0;
        }

        return 1 + numberOfDigit(n / 10);

    }
}
