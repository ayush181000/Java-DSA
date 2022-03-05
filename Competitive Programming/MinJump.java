public class MinJump {

    public static void main(String[] args) {

        int n = 9;
        n = Math.abs(n);

        int ans = 0;

        while (getsum(ans) < n || ((getsum(ans) - n) & 1) > 0)
            ans++;

        System.out.println(ans);

    }

    public static int getsum(int x) {
        return (x * (x + 1)) / 2;
    }

}
