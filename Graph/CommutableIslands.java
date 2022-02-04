public class Solution {
    int max=100009;
    int[] parent=new int[max];
    int[] rank=new int[max];
    ArrayList<Node> adj;
    public void graph(){
        adj=new ArrayList<Node>();
        for(int i=0;i<max;i++){
            parent[i]=i;
            rank[i]=0;
        }
    }
    public int solve(int A, int[][] B) {
        graph();
        PriorityQueue<Node> pq=new PriorityQueue<>(new CustomComparator());
        DisjointSet d=new DisjointSet();
        for(int[] row:B){
            pq.add(new Node(row[0],row[1],row[2]));
        }
        int cost=0;
        while(!pq.isEmpty()){
            Node x=pq.poll();
            if(d.findParent(x.u)!=d.findParent(x.v)){
                cost+=x.getWeight();
                d.union(x.getU(),x.getV());
            }
        }
        return cost;
    }
    class Node{
        int u;
        int v;
        int weight;
        public Node(int u,int v,int weight){
            this.u=u;
            this.v=v;
            this.weight=weight;
        }
        int getU(){
            return u;
        }
        int getV(){
            return v;
        }
        int getWeight(){
            return weight;
        }
    }
    class CustomComparator implements Comparator<Node>{
        public int compare(Node node1,Node node2){
            return node1.getWeight()-node2.getWeight();
        }
    }
    class DisjointSet{
        public int findParent(int u){
            if(parent[u]==u) return u;
            return parent[u]=findParent(parent[u]);
        }
        public void union(int u,int v){
            u=findParent(u);
            v=findParent(v);
            if(u==v) return;
            if(rank[u]<rank[v]){
                parent[u]=v;
            }
            else if(rank[v]<rank[u]){
                parent[v]=u;
            }
            else{
                parent[v]=u;
                rank[u]++;
            }
        }
    }
}
