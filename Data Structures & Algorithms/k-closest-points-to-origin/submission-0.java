class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> 
                Double.compare(distance(a), distance(b)));
        for (int[] point : points) q.offer(point);
        List<int[]> sol = new ArrayList<>();
        for (int i = 0; i < k; i++) sol.add(q.poll());
        return sol.toArray(new int[0][0]);
    }

    double distance(int[] a) {
        return Math.sqrt(Math.pow(a[0], 2) + Math.pow(a[1], 2));
    }
}
