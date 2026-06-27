class Solution {
    public boolean exist(char[][] board, String word) {
        if(board == null || board.length == 0) return false;
        if(word == null || word.trim().isEmpty()) return true;

        boolean res = false;

        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                if(board[i][j] == word.charAt(0)){
                    res = dfs(i, j, board, 0, word);
                    if(res) return res;
                }
            }
        }

        return false;
    }

    private boolean dfs(int row, int col, char[][] board, int index, String word){
        if(index == word.length()){
            return true;
        }

        if(row < 0 || col < 0 || row >= board.length || col >= board[0].length){
            return false;
        }

        if(word.charAt(index) != board[row][col]){
            return false;
        }

        board[row][col] = '#';

        boolean down = dfs(row+1, col, board, index + 1, word);
        boolean up = dfs(row-1, col, board, index + 1, word);
        boolean right = dfs(row, col+1, board, index + 1, word);
        boolean left = dfs(row, col-1, board, index + 1, word);

        board[row][col] = word.charAt(index);

        return down || up || right || left;
    }
}
