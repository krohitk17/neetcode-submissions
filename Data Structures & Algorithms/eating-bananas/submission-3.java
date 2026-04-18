class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1, r = Arrays.stream(piles).max().orElse(1);
        while (l < r) {
            int m = (l+r)/2;
            // System.out.println(l + " " + m + " " + r + " " + canFinish(piles, m, h));
            int totalTime = 0;
            for (int i : piles) totalTime += Math.ceil((double) i/m);
            if (totalTime <= h) r = m;
            else l = m + 1;
        }
        return r;
    }
}
