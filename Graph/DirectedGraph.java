public class Solution {
    public int solve(int A, ArrayList<ArrayList<Integer>> B) {

        int n = B.size();
        ArrayList<Integer> visited = new ArrayList();
        for(int i=0; i<n; i++){
            ArrayList<Integer> m = B.get(i);
            visited.add(m.get(0));
            if(m.get(1)==A){
                boolean isPresent = visited.contains(m.get(0));
                if(isPresent){
                    return 1;
                }
            }
        }
        return 0;
    }
}