class Solution {
    private Map<Character, String> map;

    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) return new ArrayList<>();
        map = construct();
        List<String> res = new ArrayList<>();
        dfs(digits, "", 0, res);
        return res;
    }

    private void dfs(String digits, String cur, int i, List<String> res){
        if(cur.length() == digits.length()){
            res.add(cur);
            return;
        }

        String chars = map.get(digits.charAt(i));
        for(char c : chars.toCharArray()) dfs(digits, cur + c, i + 1, res);
    }

    private Map<Character, String> construct(){
        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "qprs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        return map;
    }
}
