public class Palindrome {
    public static void main(String[] args) {

        /**
         * APPROACH 2
         * 
         * Reverse string and equate the ans
         */

        String p = "abccba";

        int i = 0;
        int j = p.length() - 1;

        while (i < p.length() / 2) {
            if (p.charAt(i) != p.charAt(j)) {
                System.out.println("Not a palindrome");
                return;
            }
            i++;
            j--;
        }

        System.out.println("This string is a Palindrome");
    }
}
