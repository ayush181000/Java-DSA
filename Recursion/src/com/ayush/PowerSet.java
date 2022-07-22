public class PowerSet {
    public static void main(String[] args) {

        String s = new String("abc");
        powerSet(s);
    }

    public static void powerSet(String s) {
        int n = s.length();
        for (int num = 0; num < (1 << n); num++) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                if ((num & (1 << i)) != 0) {
                    sb.append(s.charAt(i));
                }
            }
            System.out.println(sb.toString());
        }
    }
}
