package com.ayush;

import java.util.HashSet;
import java.util.Set;

class Solution {

    public static void main(String[] args) {
        // System.out.println(romanToInt("LVIII"));
        System.out.println(removeDuplicates(new int[] { 1, 1, 2 }));

    }

    public static int removeDuplicates(int[] nums) {
        Set<Integer> set = new HashSet();
        for (int i = 0; i < nums.length; i++) {
            if (!set.contains(nums[i]))
                set.add(nums[i]);
        }

        return set.size() + 1;
    }

    public static int romanToInt(String s) {
        int value = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == 'I') {
                value += 1;
            } else if (s.charAt(i) == 'V') {
                value += 5;
                if (i - 1 > 0)
                    if (s.charAt(i - 1) == 'I') {
                        value -= 2;
                    }
            } else if (s.charAt(i) == 'X') {
                value += 10;
                if (i - 1 > 0)
                    if (s.charAt(i - 1) == 'I') {
                        value -= 2;
                    }
            } else if (s.charAt(i) == 'L') {
                value += 50;

                if (i - 1 > 0)
                    if (s.charAt(i - 1) == 'X') {
                        value -= 20;
                    }
            } else if (s.charAt(i) == 'C') {
                value += 100;
                if (i - 1 > 0)
                    if (s.charAt(i - 1) == 'X') {
                        value -= 20;
                    }
            } else if (s.charAt(i) == 'D') {
                value += 500;
                if (i - 1 > 0)
                    if (s.charAt(i - 1) == 'C') {
                        value -= 200;
                    }
            } else if (s.charAt(i) == 'M') {
                value += 1000;
                if (i - 1 > 0)
                    if (s.charAt(i - 1) == 'C') {
                        value -= 200;
                    }
            }
        }
        return value;
    }
}
