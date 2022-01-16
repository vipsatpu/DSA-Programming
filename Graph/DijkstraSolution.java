public class DijsktraSolution {
    static int max = 100009;
    static ArrayList<ArrayList<Pair>> adj;
    static int vis[] = new int[max];

    public void graph(){
        adj = new ArrayList<ArrayList<Pair>>(max);
        for(int i=0; i<max; i++){
            adj.add(new ArrayList<Pair>());
            vis[i] = -1;
        }
    }
    public ArrayList<Integer> solve(int A, ArrayList<ArrayList<Integer>> B, int C) {
        graph();
        for(ArrayList<Integer> row : B){
            adj.get(row.get(0)).add(new Pair(row.get(1), row.get(2)));
            adj.get(row.get(1)).add(new Pair(row.get(0), row.get(2)));
        }
        return dijkstra(A,C);

    }

    private ArrayList<Integer> dijkstra(int A, int C){
        ArrayList<Integer> dist = new ArrayList();
        for(int i=0; i<A; i++){
            dist.add(Integer.MAX_VALUE);
        }
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>(new WeightComparator());
        pq.offer(new Pair(C, 0));
        dist.set(C,0);
        while(!pq.isEmpty()){
            Pair p = pq.poll();
            if(vis[p.node]==1) continue;
            vis[p.node] =1;
            for(Pair child : adj.get(p.node)){
                if(dist.get(p.node)+child.weight < dist.get(child.node)){
                    dist.set(child.node, dist.get(p.node)+child.weight);
                    pq.offer(new Pair(child.node, dist.get(child.node)));
                }
            }
        }
        for(int i=0; i< dist.size(); i++){
            if(dist.get(i) == Integer.MAX_VALUE){
                dist.set(i, -1);
            }
        }
        return dist;
    }

    class Pair {
        int weight;
        int node;

        public Pair(int node, int weight){
            this.node = node;
            this.weight = weight;
        }
    }
    class WeightComparator implements Comparator<Pair> {

        public int compare(Pair a, Pair b){
            return a.weight - b.weight;
        }
    }
}
