class Solution {
    public boolean canFinish(int n, int[][] preq) {
        int[] indegree = new int[n];
        boolean[][] adj = new boolean[n][n];

        for (int[] pre : preq) {
            indegree[pre[1]]++;
            adj[pre[0]][pre[1]] = true;
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++)
            if (indegree[i] == 0) q.add(i);
        
        int completed = 0;

        while (!q.isEmpty()) {
            int course = q.poll();
            completed++;
            for (int next = 0; next < n; next++) {
                if (adj[course][next]) {
                    indegree[next]--;
                    if (indegree[next] == 0) q.add(next);
                }
            }
        }

        return completed == n;
    }
}
