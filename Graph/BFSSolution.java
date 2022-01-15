public class BFSSolution {

    static int max = 100009;
    static ArrayList<ArrayList<Integer>> adj;
    static int [] visited = new int[2*max];

    public void graph(){
        adj = new ArrayList<ArrayList<Integer>>(2*max);
        for(int i=0; i<2*max; i++){
            adj.add(new ArrayList());
            visited[i] = -1;
        }
    }
    public int solve(int A, ArrayList<ArrayList<Integer>> B, int C, int D) {
        graph();
        int tempNode = A+1;
        for(ArrayList<Integer> row : B){
            if(row.get(2) == 2){
                adj.get(row.get(0)).add(tempNode);
                adj.get(tempNode).add(row.get(1));
                adj.get(row.get(1)).add(tempNode);
                adj.get(tempNode).add(row.get(0));
                tempNode++;
            }
            else {
                adj.get(row.get(0)).add(row.get(1));
                adj.get(row.get(1)).add(row.get(0));
            }
        }

        Queue<Pair> pairQ = new LinkedList<Pair>();
        pairQ.add(new Pair(C, 0));
        visited[C] = 1;
        while(!pairQ.isEmpty()){
            Pair p = pairQ.poll();
            //System.out.println(" Node "+p.node+ " Distance "+p.distance);
            if(p.node == D) return p.distance;

            for(Integer child : adj.get(p.node)){
                if(visited[child]==-1){
                    pairQ.add(new Pair(child, p.distance+1));
                }
                visited[child] = 1;
            }
        }
        return -1;
    }

    class Pair{
        int node;
        int distance;
        public Pair(int node,int distance){
            this.node=node;
            this.distance=distance;
        }
    }
}
