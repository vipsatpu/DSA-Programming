public class Solution {
    public int solve(ArrayList<Integer> A, int B) {
        Collections.sort(A);
        int l = 1;
        int h = A.get(A.size()-1) - A.get(0);
        int ans = 0;
        while(l<=h){
            int mid = (l+h)/2;
            if(isCowsPlaced(A,B,mid)){
                ans= mid;
                l = mid+1;
            }
            else{
                h = mid -1;
            }
        }
        return ans;
    }
    public boolean isCowsPlaced(ArrayList<Integer> A, int B, int mid){
        int cowPlaced = A.get(0);
        int cowsCnt = 1;
        for(int i=1; i<A.size(); i++){
            int diff = A.get(i) - cowPlaced;
            if(diff >= mid){
                cowPlaced = A.get(i);
                cowsCnt++;
            }
            if(cowsCnt==B){
                return true;
            }
        }
        return false;
    }
}
