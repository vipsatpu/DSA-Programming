class Solution {
    int cntPer = 0;
    public int solve(int[] A) {
// Basic Condition check if the array is null or size is only one return 0 in this case.
        if(A == null || A.length==1)
            return 0;
        countSquareFul(A, 0);
        return cntPer;
    }


    void countSquareFul(int[] A,int index) {
// If index is size of the array length we will increase the squareful count
// This check will also prevent getting ArrayIndexOutOfBound Exception
        if(index==A.length) {
            cntPer++;
            return;
        }
// Take a set everytime so that you can track if the element is already there or not in case of duplicate elements.
        HashSet<Integer> set = new HashSet<Integer>();
        for(int i=index;i<A.length;i++) {
// I was using this condition earlier instead of set as discussed in the video explanation but it doesn’t work for me
//if(i!=index && A[i]==A[index])
// continue;
// The set will return false if the element is already present
            if(set.add(A[i])) {
// Do Swap
                swap(A, i, index);
                if(index==0 || isSquare((long)A[index-1]+ (long)A[index]))
                    countSquareFul(A, index+1);
// Un Do swap for next Iterations
                swap(A, i, index);
            }
        }
    }

    void swap(int[] A, int i, int index) {
        int temp = A[i];
        A[i] = A[index];
        A[index] = temp;
    }

    boolean isSquare(long n) {
        double sqrt = Math.sqrt(n);
        if(sqrt != (long) (sqrt))
            return false;
        return true;
    }
}