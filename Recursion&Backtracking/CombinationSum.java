public class Solution {
    ArrayList<ArrayList<Integer>> ans = new ArrayList();
    public ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> A, int B) {
        Collections.sort(A);
        recursiveCallToFindCombination(A, B, new ArrayList<Integer>(), 0, 0);
        return ans;
    }
    public void recursiveCallToFindCombination(ArrayList<Integer> input, int reqSum, ArrayList<Integer> temp, int indx, int arrEleSum){

        if(reqSum == arrEleSum){
            ans.add(new ArrayList(temp));
            return;
        }
        if(reqSum < arrEleSum || indx == input.size()){
            return;
        }
        HashSet<Integer> unique = new HashSet<>();
        for(int i=indx; i< input.size(); i++){
            int ele = input.get(i);
            if(unique.contains(ele)){
                continue;
            }
            unique.add(ele);
            temp.add(ele);
            recursiveCallToFindCombination(input, reqSum, temp, i, arrEleSum+ele);
            temp.remove(temp.size()-1);
        }
    }
}
