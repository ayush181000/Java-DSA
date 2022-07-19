class Sol {
    public static void main(String[] args) {
        System.out.println(deleteAndEarn(new int[]{3, 4, 2}));
    }

    public static int deleteAndEarn(int[] nums) {
        return helper(0, 0, nums);
    }

    public static int helper(int index, int sum, int[] nums) {
        int n = nums.length;

        int max = sum;
        for (int i = 0; i < n; i++) {
            if (nums[i] != -1) {
                int[] copy = mark(nums[i], nums);
                int f = helper(i, sum + nums[i], copy);
                max = Math.max(max, f);
            }
        }

        return max;
    }

    public static int[] mark(int val, int[] nums) {
        int n = nums.length;
        int[] copy = new int[n];
        for (int i = 0; i < n; i++) {
            if (nums[i] == val || nums[i] == val + 1 || nums[i] == val - 1) {
                copy[i] = -1;
            } else {
                copy[i] = nums[i];
            }
        }

        return copy;
    }
}
