package Algorithms;

/**
 * Given an m x n grid of characters board and a string word, return true if word exists in the grid.
 *
 * The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.
 *
 *  
 *
 * Example 1:
 *
 *
 * Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
 * Output: true
 * Example 2:
 *
 *
 * Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
 * Output: true
 * Example 3:
 *
 *
 * Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
 * Output: false
 *  
 *
 * Constraints:
 *
 * m == board.length
 * n = board[i].length
 * 1 <= m, n <= 6
 * 1 <= word.length <= 15
 * board and word consists of only lowercase and uppercase English letters.
 *  
 *
 * Follow up: Could you use search pruning to make your solution faster with a larger board?
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-search
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class WordSearch {

    public boolean exist(char[][] board, String word) {

        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        boolean flag = false;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(board, i, j, visited, word, 0)) {
                    flag = true;
                    break;
                }
            }
        }
        return flag;
    }

    public int[] direction = {-1, 0, 1, 0, -1};

    public boolean dfs(char[][] board, int i, int j, boolean[][] visited, String word, int k) {
        if (board[i][j] != word.charAt(k)) {
            return false;
        }
        if (k == word.length() - 1) {
            return true;
        }
        visited[i][j] = true;
        boolean result = false;
        for (int index = 0; index < 4; index++) {
            int newi = i + direction[index];
            int newj = j + direction[index+1];
            if (newi < 0 || newi >= board.length || newj < 0 || newj >= board[0].length || visited[newi][newj]) {
                continue;
            }
            if (dfs(board, newi, newj, visited, word, k+1)) {
                result = true;
                break;
            }
        }
        visited[i][j] = false;
        return result;
    }
}
