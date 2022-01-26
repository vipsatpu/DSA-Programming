public class Solution {

    ArrayList<String> parenthesisList = new ArrayList();
    public ArrayList<String> generateParenthesis(int A) {
        String str = "";
        generate(str, A, 0, 2*A);
        return parenthesisList;
    }

    public void generate(String parStr, int cnt, int diff, int n){
        if(n == 0){
            parenthesisList.add(parStr);
            return;
        }
        if(cnt > 0){
            generate(parStr+"(", cnt-1, diff+1, n-1);
        }
        if(diff>0){
            generate(parStr+")",cnt, diff-1, n-1);
        }
    }
}
