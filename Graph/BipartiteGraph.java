public class Solution {
    int max=100009;
    int[] color=new int[max];
    ArrayList<ArrayList<Integer>> adj;
    public void graph(){
        adj=new ArrayList<ArrayList<Integer>>(max);
        for(int i=0;i<max;i++){
            adj.add(new ArrayList<>());
            color[i]=-1;
        }
    }
    public int solve(int A, int[][] B) {
        graph();
        for(int[] row:B){
            int x=row[0];
            int y=row[1];
            adj.get(x).add(y);
            adj.get(y).add(x);
        }
        if(CheckBipartite(A)){
            return 1;
        }
        return 0;
    }
    public boolean CheckBipartite(int A){
        for(int i=0;i<A;i++){
            if(color[i]==-1){
                if(!bfs(i)){
                    return false;
                }
            }
        }
        return true;
    }
    public boolean bfs(int node){
        Queue<Integer> q=new LinkedList<>();
        q.add(node);
        color[node]=1;
        while(!q.isEmpty()){
            node=q.poll();
            for(Integer child:adj.get(node)){
                if(color[child]==-1){
                    color[child]=1-color[node];
                    q.add(child);
                }
                else if(color[child]==color[node]){
                    return false;
                }
            }
        }
        return true;
    }
}