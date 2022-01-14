public class FirstDFS {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int solve(ArrayList<Integer> A, final int B, final int C) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= A.size(); i++) {
            adj.add(new ArrayList<>());
        }
//form a edge
        for (int i = 1; i < A.size(); i++) {
            adj.get(A.get(i)).add(i + 1);
        }
        Stack<Integer> stack = new Stack<>();
        stack.push(C);
        while (!stack.isEmpty()) {
            int node = stack.pop();
            if (node == B) return 1;
            for (Integer child : adj.get(node)) {
                stack.push(child);
            }
        }
        return 0;
    }
}