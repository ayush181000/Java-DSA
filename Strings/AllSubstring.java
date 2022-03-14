public class AllSubstring {
    public static void main(String[] args) {

        String s = "xyz";

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            String subString = String.valueOf(c);
            System.out.println(subString);

            for (int j = i + 1; j < s.length(); j++) {
                subString = subString + s.charAt(j);
                System.out.println(subString);
            }

        }

    }
}
