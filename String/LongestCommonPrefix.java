public class Solution {
    public String longestCommonPrefix(ArrayList<String> A) {

        int n = A.size();
        String smallestStr = A.get(0);
        StringBuilder commonPrefix = new StringBuilder();
        for(int i=1; i<n; i++){
            String arrStr = A.get(i);
            if(arrStr.length() < smallestStr.length()){
                smallestStr = arrStr;
            }
        }
        for(int i=0; i<n; i++){
            if(!smallestStr.equals(A.get(i))){
                String currArrStr = A.get(i);
                for(int j=0; j<smallestStr.length();j++){
                    char ch = smallestStr.charAt(j);
                    if(ch == currArrStr.charAt(j) ){
                        commonPrefix.append(String.valueOf(ch));
                    }
                    else{
                        smallestStr = commonPrefix.toString();
                        // System.out.println("smallestStr - "+smallestStr);
                        break;
                    }
                }
            }
        }
        return smallestStr;
    }
}
