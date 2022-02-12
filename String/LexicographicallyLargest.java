public class Solution {
    public String getLargest(String A) {

        String[] st = A.split("_");

        String s = st[0];
        String t = st[1];

        char tArr[] = t.toCharArray();
        Arrays.sort(tArr);
        String string = new String(tArr);
        StringBuilder sb = new StringBuilder(string);
        sb.reverse();
        t = sb.toString();
        Map<Character, Integer> freq = new HashMap();
        for(char ch : t.toCharArray()){
            if(freq.containsKey(ch)){
                int cnt = freq.get(ch);
                freq.put(ch, cnt+1);
            }
            else
                freq.put(ch, 1);
        }
        StringBuilder str = new StringBuilder(s);
        int maxDiff = Integer.MIN_VALUE;
        int n = t.length() > s.length() ? s.length() : t.length();
        for(int i=0; i<s.length(); i++){
            maxDiff = Integer.MIN_VALUE;
            for(int j=0; j<t.length(); j++){
                int diff = t.charAt(j) - s.charAt(i);
                int cnt = freq.get(t.charAt(j));
                if(diff > maxDiff && diff > 0 && cnt!=0){
                    maxDiff = diff;
                    str.setCharAt(i, t.charAt(j));
                    freq.put(t.charAt(j), --cnt);
                }
            }
        }
        return str.toString();

    }
}
