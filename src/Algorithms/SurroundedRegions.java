package Algorithms;

/**
 * Given an m x n matrix board containing 'X' and 'O', capture all regions surrounded by 'X'.
 *
 * A region is captured by flipping all 'O's into 'X's in that surrounded region.
 *
 *  
 *
 * Example 1:
 *
 *
 * Input: board = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]
 * Output: [["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]
 * Explanation: Surrounded regions should not be on the border, which means that any 'O' on the border of the board are not flipped to 'X'. Any 'O' that is not on the border and it is not connected to an 'O' on the border will be flipped to 'X'. Two cells are connected if they are adjacent cells connected horizontally or vertically.
 * Example 2:
 *
 * Input: board = [["X"]]
 * Output: [["X"]]
 *  
 *
 * Constraints:
 *
 * m == board.length
 * n == board[i].length
 * 1 <= m, n <= 200
 * board[i][j] is 'X' or 'O'.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/surrounded-regions
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SurroundedRegions {

    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] flag = new boolean[m][n];
        for (int x = 0; x < m; x++) {
            dfs(board, x, 0, flag);
            dfs(board, x, n-1, flag);
        }
        for (int y = 1; y < n-1; y++) {
            dfs(board, 0, y, flag);
            dfs(board, m-1, y,flag);
        }
        for (int x = 0; x < m; x++) {
            for (int y = 0; y < n; y++) {
                if (!flag[x][y]) {
                    board[x][y] = 'X';
                }
            }
        }
    }
    public void dfs(char[][] board, int x, int y, boolean[][] flag) {
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length || board[x][y] == 'X') {
            return;
        }
        if (board[x][y] == 'O') {
            if (flag[x][y] == true) {
                return;
            }
            flag[x][y] = true;
            dfs(board, x-1, y, flag);
            dfs(board, x+1, y, flag);
            dfs(board, x, y-1, flag);
            dfs(board, x, y+1, flag);
        }

    }
}
