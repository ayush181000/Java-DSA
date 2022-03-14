public class ReverseWords {

    public static void main(String[] args) {
        String s = " abc def ghi ksald                              s";
        String ans = "";
        int currentWordStart = 0;
        int i = 0;
        for (; i < s.length(); i++) {

            if (s.charAt(i) == ' ') {
                // Reverse current word
                int currentWordEnd = i - 1;
                String reversedWord = "";
                for (int j = currentWordStart; j <= currentWordEnd; j++) {
                    reversedWord = s.charAt(j) + reversedWord;
                }

                // add it to final string
                ans = ans + reversedWord + " ";
                currentWordStart = i + 1;
            }

        }

        int currentWordEnd = i - 1;
        String reversedWord = "";
        for (int j = currentWordStart; j <= currentWordEnd; j++) {
            reversedWord = s.charAt(j) + reversedWord;
        }

        // add it to final string
        ans = ans + reversedWord + " ";
        currentWordStart = i + 1;

        System.out.println(ans);

    }
}
