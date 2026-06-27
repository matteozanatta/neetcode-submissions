class Solution {
    public boolean exist(char[][] board, String word) {
        if(board == null || board.length == 0) return false;
        if(word == null || word.trim().isEmpty()) return true;

        List<Boolean> res = new ArrayList<>();

        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                if(board[i][j] == word.charAt(0)){
                    dfs(i, j, board, 0, word, res);
                }
            }
        }

        return res.size() == 0 ? false : true;
    }

    private void dfs(int row, int col, char[][] board, int index, String word, List<Boolean> res){
        if(index == word.length()){
            res.add(true);
            return;
        }

        if(row < 0 || col < 0 || row >= board.length || col >= board[0].length){
            return;
        }

        if(word.charAt(index) != board[row][col]){
            return;
        }

        board[row][col] = '#';

        dfs(row+1, col, board, index + 1, word, res);
        dfs(row-1, col, board, index + 1, word, res);
        dfs(row, col+1, board, index + 1, word, res);
        dfs(row, col-1, board, index + 1, word, res);

        board[row][col] = word.charAt(index);
    }
}
