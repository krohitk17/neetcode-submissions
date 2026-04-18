class Solution {
    public String longestPalindrome(String s) {
        int start = 0;
        int end = 1;

        for (int i = 0; i < s.length(); i++) {
            int[] sol1 = isPalindrome(s, i, i), sol2 = isPalindrome(s, i, i+1);
            if (sol1[1] - sol1[0] > end - start) {
                start = sol1[0]; end = sol1[1];
            }
            if (sol2[1] - sol2[0] > end - start) {
                start = sol2[0]; end = sol2[1];
            }
        }
        return s.substring(start, end);
    }

    int[] isPalindrome(String s, int l, int r) {
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--; r++;
        }
        return new int[]{l+1, r};
    }
}
