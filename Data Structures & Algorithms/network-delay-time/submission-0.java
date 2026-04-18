class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> edges = new HashMap<>();
        for (int[] edge : times)
            edges.computeIfAbsent(edge[0], x -> new ArrayList<int[]>())
                    .add(new int[]{edge[1], edge[2]});

        Queue<int[]> q = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        q.offer(new int[]{0, k});
    
        Map<Integer, Integer> shortest = new HashMap<>();

        while (!q.isEmpty()) {
            int[] edge = q.poll();
            if (shortest.containsKey(edge[1])) continue;
            shortest.put(edge[1], edge[0]);

            for (int[] next : edges.getOrDefault(edge[1], new ArrayList<int[]>())) {
                q.offer(new int[]{edge[0] + next[1], next[0]});
            }
        }
        if (shortest.size() < n) return -1;

        int max = -1;
        for (int shortestPath : shortest.values())
            if (max < shortestPath) max = shortestPath;
        return max;
    }
}
