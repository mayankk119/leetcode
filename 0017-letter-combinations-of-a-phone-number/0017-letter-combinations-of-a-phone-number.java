class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();

        if (digits.length() == 0) {
            return ans;
        }

        String[] letters = {
            "", "", "abc", "def", "ghi",
            "jkl", "mno", "pqrs", "tuv", "wxyz"
        };

        backtrack(digits, 0, "", ans, letters);

        return ans;
    }

    private void backtrack(
        String digits,
        int index,
        String current,
        List<String> ans,
        String[] letters
    ) {
        if (index == digits.length()) {
            ans.add(current);
            return;
        }

        int digit = digits.charAt(index) - '0';
        String possible = letters[digit];

        for (char c : possible.toCharArray()) {
            backtrack(
                digits,
                index + 1,
                current + c,
                ans,
                letters
            );
        }
    }
}