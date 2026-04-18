class Solution {
    public int lastStoneWeight(int[] stones) {
        if (stones.length == 1) return stones[0];
    
        PriorityQueue<Integer> q = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        for (int i : stones) q.offer(i);

        while (!q.isEmpty()) {
            if (q.size() == 1) return q.poll();
            int a = q.poll(), b = q.poll(), c = Math.abs(a-b);
            if (c > 0) q.offer(c);
        }

        return 0;
    }
}
