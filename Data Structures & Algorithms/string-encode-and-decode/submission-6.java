class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String s : strs){
            sb.append(s.length());
            sb.append('#');
            sb.append(s);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        int i=0, j=0, len=0;
        List<String> res = new ArrayList<>();
        while(i < str.length()){
            j = i;
            while(str.charAt(j) != '#') j++;
            len = Integer.parseInt(str.substring(i, j));
            i = j + 1;
            j = i + len;
            res.add(str.substring(i, j));
            i = j;
        }
        return res;
    }
}
