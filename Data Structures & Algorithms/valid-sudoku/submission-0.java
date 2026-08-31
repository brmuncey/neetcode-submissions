class Solution {
    public boolean isValidSudoku(char[][] board) {

        HashMap<Integer, Set<Character>> rows = new HashMap<>();
        HashMap<Integer, Set<Character>> cols = new HashMap<>();
        HashMap<Integer, Set<Character>> squares = new HashMap<>();
        
        for(int r=0 ; r<9 ; r++){
            for(int c=0 ; c<9 ; c++){
                char cell = board[r][c];
                if(cell == '.'){
                    continue;
                }

                if(rows.getOrDefault(r, new HashSet<>()).contains(cell) ||
                    cols.getOrDefault(c, new HashSet<>()).contains(cell) ||
                    squares.getOrDefault((r/3) * 3 + c / 3, new HashSet<>()).contains(cell) ){
                        return false;
                }

                cols.computeIfAbsent(c, k -> new HashSet<>()).add(cell);
                rows.computeIfAbsent(r, k -> new HashSet<>()).add(cell);
                squares.computeIfAbsent((r/3) * 3 + c / 3, k -> new HashSet<>()).add(cell);
            }
        }

        return true;
    }
}
