public class Solution {
    public int solve(int A, ArrayList<Integer> B, ArrayList<ArrayList<Integer>> C, int D) {

        int parents = new parents[A];
        int heights = new heights[A];
        int ans =0;
        for(int i=1; i<=A; i++){
            parents[i] = i;
        }
        for(int i=1; i<=A; i++){
            heights[i] = 1;
        }

        for(int i=0; i< C.size(); i++){
            ArrayList<Integer> arr = C.get(i);
            int n1 = arr.get(0);
            int n2 = arr.get(1);

            find_union(n1, n2);


        }
    }

    public int find_union(int n1, int n2, ArrayList<Integer> B){
        int parent_n1 = find_root_by_path_compression(n1);
        int parent_n2 = find_root_by_path_compression(n2);

        int s_n2 = B.get(parent_n2);
        int s_n1 = B.get(parent_n1);

        if(parent_n1 == parent_n2){
            return;
        }
        if(height[parent_n1] > height[parent_n2]){
            parent[parent_n2] = parent_n1;
            B.set(parent_n1, s_n2+s_n1);
        } else if(height[parent_n1] < height[parent_n2]){
            parent[parent_n1] = parent_n2;
            B.set(parent_n2, s_n2+s_n1);
        } else{
            parent[parent_n1] = parent_n2;
            B.set(parent_n2, s_n2+s_n1);
            height[parent_n2]+=1;
        }
    }

    public int find_root_by_path_compression(int node){
        if(node == parent[node]){
            return node;
        }
        parent[node] = find_root_by_path_compression(parent[node]);
        return parent[node];
    }
}
