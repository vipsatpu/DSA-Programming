public class Solution {

    HashMap<Character,String> digitLetters = new HashMap<Character,String>();
    ArrayList<String> ans = new ArrayList();
    StringBuilder res = new StringBuilder();

    public ArrayList<String> letterCombinations(String A) {

        digitLetters.put('0', "0");
        digitLetters.put('1', "1");
        digitLetters.put('2', "abc");
        digitLetters.put('3', "def");
        digitLetters.put('4', "ghi");
        digitLetters.put('5', "jkl");
        digitLetters.put('6', "mno");
        digitLetters.put('7', "pqrs");
        digitLetters.put('8', "tuv");
        digitLetters.put('9', "wxyz");
        letterRec(0, A, res);
        return ans;
    }

    public void letterRec(int indx, String A, StringBuilder res){

        if(indx >= A.length()){
            ans.add(res.toString());
            return;
        }

        // System.out.println(" indx "+indx);
        //System.out.println(" A.charAt(indx) "+A.charAt(indx));
        String letters = digitLetters.get(A.charAt(indx));
        //System.out.println(" Letters "+letters);

        //res = new StringBuilder("");
        //res.append(String.valueOf(A.charAt(indx)));
        for(int i=0; i < letters.length(); i++){
            String ch = String.valueOf(letters.charAt(i));
            res.append(ch);
            letterRec(indx+1, A, res);
            res.deleteCharAt(res.length()-1);
        }
    }
}