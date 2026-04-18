class Solution {
    public boolean isPalindrome(String s) {
        int n = s.length();
        for (int l = 0, r = n-1; l < r; l++, r--) {
            while (l < n && !Character.isLetterOrDigit(s.charAt(l))) l++;
            while (r >= 0 && !Character.isLetterOrDigit(s.charAt(r))) r--;
            if (l < n && r >= 0 && Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r))) return false;
        }
        return true;
    }
}
