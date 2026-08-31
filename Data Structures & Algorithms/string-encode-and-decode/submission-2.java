class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String x : strs){
            sb.append(x.length()+"#"+x);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        int i=0, j;
        while(i<str.length()){
            j=i;
            while(str.charAt(j) != '#'){
                j++;
            }
            int length = Integer.parseInt(str.substring(i, j));
            result.add(str.substring(j + 1, j + length + 1));
            i = j + 1 + length;
        }
        return result;
    }
}
