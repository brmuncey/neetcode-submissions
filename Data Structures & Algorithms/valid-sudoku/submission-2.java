class Solution {
    public boolean isValidSudoku(char[][] board) {
        List<Set<Character>> rows = new ArrayList<>(), cols = new ArrayList<>(), grid = new ArrayList<>();

        for(int i=0; i<9; i++){
            rows.add(new HashSet<>());
            cols.add(new HashSet<>());
            grid.add(new HashSet<>());
        }

        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                char cell = board[i][j];
                if(cell == '.') continue;

                if(rows.get(i).contains(cell)) return false;
                if(cols.get(j).contains(cell)) return false;
                if(grid.get((i/3) * 3 + j/3).contains(cell)) return false;

                rows.get(i).add(cell);
                cols.get(j).add(cell);
                grid.get((i/3) * 3 + j/3).add(cell);
            }
        }

        return true;
    }
}
