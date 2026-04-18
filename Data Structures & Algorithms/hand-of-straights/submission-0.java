class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n = hand.length;
        if (n % groupSize != 0) return false;

        Map<Integer, Integer> freq = new HashMap<>();
        for (int i : hand) freq.put(i, freq.getOrDefault(i, 0)+1);

        for (int i : hand) {
            int start = i;
            while (freq.getOrDefault(start-1, 0) > 0) start--;
            while (start <= i) {
                while (freq.getOrDefault(start, 0) > 0)
                    for (int j = start; j < start + groupSize; j++) {
                        if (freq.getOrDefault(j, 0) == 0) return false;
                        freq.put(j, freq.get(j)-1);
                    }
                start++;
            }
        }

        return true;
    }
}
