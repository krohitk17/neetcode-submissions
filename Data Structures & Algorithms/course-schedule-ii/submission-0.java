class Solution {
    public int[] findOrder(int n, int[][] preq) {
        int[] indegree = new int[n];
        boolean[][] adj = new boolean[n][n];

        for (int[] pre : preq) {
            indegree[pre[0]]++;
            adj[pre[1]][pre[0]] = true;
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++)
            if (indegree[i] == 0) q.add(i);
        
        List<Integer> completed = new ArrayList<>();

        while (!q.isEmpty()) {
            int course = q.poll();
            completed.add(course);
            for (int next = 0; next < n; next++) {
                if (adj[course][next]) {
                    indegree[next]--;
                    if (indegree[next] == 0) q.add(next);
                }
            }
        }

        if (completed.size() == n)
            return completed.stream().mapToInt(Integer::intValue).toArray();
        return new int[0];
    }
}
