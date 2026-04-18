class KthLargest {
    PriorityQueue<Integer> queue;
    int k;

    public KthLargest(int k, int[] nums) {
        queue = new PriorityQueue<Integer>();
        this.k = k;
        for (int i : nums) {
            queue.offer(i);
            if (queue.size() > this.k) {
                queue.poll();
            }
        }
    }
    
    public int add(int val) {
        queue.offer(val);
        if (queue.size() > k) {
            queue.poll();
        }
        return queue.peek();
    }
}
