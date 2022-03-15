// package com.ayush;

public class Power {

    public static void main(String[] args) {

        // System.out.println(power(2, 2));
        System.out.println(powerBetter(13, 23));
    }

    public static int power(int base, int exp) {

        if (exp < 0) {
            return -1;
        }

        if (exp == 0) {
            return 1;
        }

        return base * power(base, exp - 1);
    }

    public static int powerBetter(int x, int n) {
        if (x == 0 && n == 0)
            return 1;
        if (x == 0)
            return 0;
        if (n == 0)
            return 1;
        int smallAns = powerBetter(x, n / 2);
        if (n % 2 == 0) {
            return smallAns * smallAns;
        } else {
            return x * smallAns * smallAns;
        }

    }
}
