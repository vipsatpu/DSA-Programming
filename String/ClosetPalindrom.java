public class Solution {
    public String solve(String A) {

        int n = A.length();
        int count =0;
        for(int i=0; i< n/2; ++i){
            char ch1 = A.charAt(i);
            char ch2 = A.charAt(n-i-1);
            if(ch1!=ch2){
                count++;
            }
        }
        //System.out.println("Count : "+count);
        //System.out.println("n%2 : "+n%2);
        if(count<=1 && n%2 !=0){
            return "YES";
        }
        if(count==1){
            return "YES";
        }
        else
            return "NO";

    }
}