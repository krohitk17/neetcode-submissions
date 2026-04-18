class Solution {
    public boolean isHappy(int n) {
        int l = getHappy(n), r = getHappy(l);
        if (l == 1 || r == 1) return true;
        while (l != r) {
            l = getHappy(l);
            r = getHappy(getHappy(r));
            if (l == 1 || r == 1) return true;
        }

        return false;
    }

    int getHappy(int n) {
        int res = 0;
        while (n > 0) {
            int i = n%10;
            res += i*i;
            n /= 10;
        }
        return res;
    }
}
