class Solution {
    public boolean checkValidString(String s) {
        int openMin = 0, openMax = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                openMin++;
                openMax++;
            }
            if (c == ')') {
                openMin--;
                openMax--;
            }
            if (c == '*') {
                openMin--;
                openMax++;
            }
            if (openMax < 0) return false;
            if (openMin < 0) openMin = 0;
        }

        return openMin == 0;
    }
}
