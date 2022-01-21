public class CycleInDirectedGraph {
    Map<Integer, List<Integer>> map =  new HashMap<>();
    Set<Integer> isVisited = new HashSet<>();
    public int solve(int A, int[][] B) {
        for(int i=1; i<=A; i++){
            map.put(i, new ArrayList<>());
        }
        for(int i=0; i<B.length; i++){
            map.get(B[i][0]).add(B[i][1]);
        }
        for(int i=1; i<=A; i++){
            if(DFS(map.get(i)) == 1){
                return 1;
            }
            isVisited = new HashSet<>();
        }
        return 0;
    }

    public int DFS(List<Integer> list){
        for(int i=0; i<list.size(); i++){
            if(isVisited.add(list.get(i))){
                if(DFS(map.get(list.get(i)))==1){
                    return 1;
                }
                isVisited.remove(list.get(i));
            }else{
                return 1;
            }
        }
        return 0;
    }
}