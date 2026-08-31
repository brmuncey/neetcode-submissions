class Solution {
    Set<Integer> col;
    Set<Integer> pos;
    Set<Integer> neg;
    

    public List<List<String>> solveNQueens(int n) {
        col = new HashSet<>();
        pos = new HashSet<>();
        neg = new HashSet<>();

        List<List<String>> res = new ArrayList<>();
        char[][] board = new char[n][n];
        for(int i=0; i<n; i++) Arrays.fill(board[i], '.');
        backtrack(res, board, 0);
        return res;
    }

    private void backtrack(List<List<String>> res, char[][] board, int r){
        if(r == board.length) {
            List<String> copy = new ArrayList<>();
            for(char[] row : board){
                copy.add(new String(row));
            }
            res.add(copy);
            return;
        }

        for(int c=0; c < board.length; c++){
            if(col.contains(c) || pos.contains(r+c) || neg.contains(r-c)) continue;

            col.add(c);
            pos.add(r + c);
            neg.add(r - c);
            board[r][c] = 'Q';

            backtrack(res, board, r + 1);

            col.remove(c);
            pos.remove(r + c);
            neg.remove(r - c);
            board[r][c] = '.';
        }
    }
}
