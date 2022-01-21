public class Solution {

    static int max = 3 * 100009;
    static ArrayList<ArrayList<Integer>> adj;
    static int[] visited = new int[max];
    static ArrayList<Integer> ans = new ArrayList();
    static public void graph() {
        adj = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < max; i++) {
            adj.add(new ArrayList<Integer>());
            visited[i] = -1;
        }
    }

    public ArrayList<Integer> solve(int A, ArrayList<ArrayList<Integer>> B) {

        for (ArrayList<Intger> row : B) {
            adj.get(row.get(0)).add(row.get(1));
            adj.get(row.get(1)).add(row.get(0));
        }

        for (int i = 1; i < max; i++) {
            if(visited[i] == -1){
                visited[i] = 1;
                DFS(i, -1);
            }
        }
    }

    public void DFS(int node, int parent){

        for (Integer cn :  adj.get(node)) {
            if(visited[cn] == -1){
                DFS(cn, node);
            }
            /**
             * ArrayList<Integer> children = adj.get(cn);
             *                 int s = children.size();
             *                 if(s ==1 ){
             *                     visited[children.get(0)] = 1;
             *                     ans.add(i);
             *                 }
             *                 else {
             *                     for (int j=1; j<s; j++){
             *                         visited[children.get(j)] = 1;
             *                     }
             *                 }
             */
        }
    }
}
