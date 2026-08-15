class Solution {
    public int longestSubsequence(int[] nums) {
        int xor = 0;
        int zeros = 0;

        for (int x : nums) {
            xor ^= x;

            if (x == 0) {
                zeros++;
            }
        }

        if (xor != 0) {
            return nums.length;
        }

        if (zeros == nums.length) {
            return 0;
        }

        return nums.length - 1;
    }
}