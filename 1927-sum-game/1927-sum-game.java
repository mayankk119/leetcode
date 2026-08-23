class Solution {
    public boolean sumGame(String num) {
        int n = num.length();

        int leftSum = 0;
        int rightSum = 0;

        int leftQ = 0;
        int rightQ = 0;

        for (int i = 0; i < n / 2; i++) {
            if (num.charAt(i) == '?') {
                leftQ++;
            } else {
                leftSum += num.charAt(i) - '0';
            }
        }

        for (int i = n / 2; i < n; i++) {
            if (num.charAt(i) == '?') {
                rightQ++;
            } else {
                rightSum += num.charAt(i) - '0';
            }
        }

        int diff = leftSum - rightSum;
        int qDiff = leftQ - rightQ;

        // If the number of ? is equal,
        // Bob wins only when the current sums are equal.
        if (qDiff == 0) {
            return diff != 0;
        }

        // Alice wins if the imbalance cannot be cancelled.
        int value = diff * 2 + qDiff * 9;

        if (value == 0) {
            return false;
        }

        return true;
    }
}