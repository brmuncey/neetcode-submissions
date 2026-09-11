class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String s : strs){
            sb.append(s.length());
            sb.append("#");
            sb.append(s);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();
        int i=0, j=0;
        while(i < str.length()){
            j = i;
            while(str.charAt(j) != '#') j++;
            int len = Integer.parseInt(str.substring(i, j));
            i = j + 1;
            res.add(str.substring(i, i+len));
            i = i + len;
        }
        return res;
    }
}