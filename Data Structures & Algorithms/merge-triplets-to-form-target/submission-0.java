class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        int a = -1, b = -1, c = -1;
        for (int i = 0; i < triplets.length; i++) {
            int[] t = triplets[i];
            if (t[0] == target[0] && t[1] <= target[1] && t[2] <= target[2])
                a = i;
            if (t[1] == target[1] && t[0] <= target[0] && t[2] <= target[2])
                b = i;
            if (t[2] == target[2] && t[0] <= target[0] && t[1] <= target[1])
                c = i;
        }
        return a != -1 && b != -1 && c != -1;
    }
}
