class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        dfs(s, 0, 0, res, new ArrayList<>());
        return res;
    }

    private void dfs(String s, int i, int j, List<List<String>> res, List<String> part){
        if(i >= s.length()) {
            if(i == j) {
                res.add(new ArrayList<>(part));
            }
            return;
        }

        if(isPali(s, j, i)){
            part.add(s.substring(j, i + 1));
            dfs(s, i + 1, i + 1, res, part);
            part.remove(part.size() - 1);
        }

        dfs(s, i + 1, j, res, part);
    }

    private boolean isPali(String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
