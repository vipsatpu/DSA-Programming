public class MajorityElement {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int majorityElement(final List<Integer> A) {

        int n = A.size();
        if( n==1){
            return A.get(0);
        }
        Collections.sort(A); [ 1 1 2]
        int count=0, temp = A.get(0), maxEle = -1, ele=0, b=1;
        for(int i=1; i<n; i++){
            if(temp == A.get(i)){ // 1 == 2
                count++; // 1
            }
            else{
                count = 1;
                temp=A.get(i);
            }
            if(maxEle < count){ // -1 < 1 , 1<1
                maxEle = count; // 1
                ele = A.get(i); // ele = 1
                if(maxEle > (n/2)){ // 1 > 1
                    break;
                }
            }
        }
        return ele;
    }
}
