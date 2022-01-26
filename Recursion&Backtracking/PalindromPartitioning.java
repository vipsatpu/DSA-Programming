public class Solution {
    ArrayList<ArrayList<String>> res = new ArrayList();

    public ArrayList<ArrayList<String>> partition(String a) {
        partitionHelper(a, 0, new ArrayList<String>());
        return res;
    }
    public void partitionHelper(String s, int i, ArrayList<String> temp){
        if(s.length() == i){
            res.add(new ArrayList(temp));
            return;
        }
        for(int j=i; j<s.length(); ++j){
            if(isPalindrome(s.substring(i,j+1))){
                temp.add(s.substring(i,j+1));
                partitionHelper(s, j+1, temp);
                temp.remove(temp.size()-1);
            }
        }
    }
    public boolean isPalindrome(String s){
        if(s.length() == 1){
            return true;
        }
        StringBuilder orgStr = new StringBuilder();
        orgStr.append(s);
        orgStr.reverse();
        if(s.equalsIgnoreCase(orgStr.toString())){
            return true;
        }
        return false;
    }
}
