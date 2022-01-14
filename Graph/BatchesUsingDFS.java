public class BatchesUsingDFS {
    static int max = 100009;
    static ArrayList<ArrayList<Integer>> adj;
    static int[] visited = new int[max];

    public void graph() {
        adj = new ArrayList<ArrayList<Integer>>(max);
        for (int i = 0; i < max; i++) {
            adj.add(new ArrayList<>());
            visited[i] = -1;
        }
    }

    public int solve(int A, int[] B, int[][] C, int D) {
        graph();
        //create adjacency List
        for (int[] row : C) {
        //since undirected add in both directions
            adj.get(row[0]).add(row[1]);
            adj.get(row[1]).add(row[0]);
        }
        //bfs
        int ans = 0;
        for (int i = 1; i <= A; i++) {
            if (visited[i] == -1 && bfs(i, B) >= D) {
                ans++;
            }
        }
        return ans;
    }

    public int bfs(int node, int[] B) {
        int ans = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        ans += B[node - 1];
        //mark as visited for that node
        visited[node] = 1;
        while (!q.isEmpty()) {
            node = q.poll();
        //go to its adjacencies
            for (Integer child : adj.get(node)) {
        //if not visited then visit it
                if (visited[child] == -1) {
                    q.add(child);
                    ans += B[child - 1];
                }
        //mark child as visited
                visited[child] = 1;
            }
        }
        return ans;
    }
}