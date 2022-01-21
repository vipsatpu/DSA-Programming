public class MajorityElement {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int majorityElement(final List<Integer> A) {

        int n = A.size();
        if( n==1){
            return A.get(0);
        }
        Collections.sort(A);
        int count=0, temp = A.get(0), maxEle = -1, ele=0, b=1;
        for(int i=1; i<n; i++){
            if(temp == A.get(i)){
                count++;
            }
            else{
                count = 1;
                temp=A.get(i);
            }
            if(maxEle < count){
                maxEle = count;
                ele = A.get(i);
                if(maxEle > (n/2)){
                    break;
                }
            }
        }
        return ele;
    }
}
