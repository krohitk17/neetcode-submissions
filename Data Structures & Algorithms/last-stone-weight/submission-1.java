class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for (int i : stones) q.offer(-i);

        while (q.size() > 1) {
            int a = q.poll(), b = q.poll(), c = -(Math.abs(a-b));
            if (c < 0) q.offer(c);
        }
        q.offer(0);
        return -(q.peek());
    }
}
