public class Solution {
    public String solve(String A) {
        int MAX_CHAR = 26;
        int [] charCount = new int[MAX_CHAR];
        Queue<Character> q = new LinkedList<Character>();
        StringBuilder res = new StringBuilder("");
        for(int i=0; i< A.length(); i++){
            char ch = A.charAt(i);
            q.add(ch);
            //System.out.println("ch :- "+ch+", (ch - a) : "+ (ch-'a'));
            charCount[ch-'a']++; // charCount[] = charCount[] +1;
            while(!q.isEmpty()){
                //System.out.println(" charCount value "+charCount[q.peek()-'a'] );
                if(charCount[q.peek()-'a'] >1){
                    q.remove();
                }
                else{
                    res.append(String.valueOf(q.peek()));
                    break;
                }
            }
            if(q.isEmpty()){
                res.append("#");
            }
        }
        return res.toString();
    }
}
