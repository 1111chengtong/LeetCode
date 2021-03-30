package Algorithms;

import java.util.*;

/**
 * The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.
 *
 * Given an integer n, return all distinct solutions to the n-queens puzzle.
 *
 * Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space, respectively.
 *
 *  
 *
 * Example 1:
 *
 *
 * Input: n = 4
 * Output: [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
 * Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above
 * Example 2:
 *
 * Input: n = 1
 * Output: [["Q"]]
 *  
 *
 * Constraints:
 *
 * 1 <= n <= 9
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/n-queens
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class N_Queens {

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> solution = new ArrayList<>();
        int[] queens = new int[n];
        Set<Integer> columnSet = new HashSet<>();
        Set<Integer> ldiagonalSet = new HashSet<>();
        Set<Integer> rdiagonalSet = new HashSet<>();
        Arrays.fill(queens, -1);
        backtrack(solution, queens, 0, n, columnSet, ldiagonalSet, rdiagonalSet);
        return solution;
    }

    public void backtrack(List<List<String>> solution, int[] queens, int row, int n, Set<Integer> columnSet, Set<Integer> ldiagonalSet, Set<Integer> rdiagonalSet) {
        if (row >= n) {
            List<String> board = generateBoard(queens, n);
            solution.add(board);
            return;
        }
        for (int i = 0; i < n; i++) {
            if (columnSet.contains(i) || ldiagonalSet.contains(row - i) || rdiagonalSet.contains(row + i)) {
                continue;
            }
            queens[row] = i;
            columnSet.add(i);
            ldiagonalSet.add(row - i);
            rdiagonalSet.add(row + i);
            backtrack(solution, queens, row+1, n, columnSet, ldiagonalSet, rdiagonalSet);
            queens[row] = -1;
            columnSet.remove(i);
            ldiagonalSet.remove(row - i);
            rdiagonalSet.remove(row + i);
        }
    }

    public List<String> generateBoard(int[] queens, int n) {
        List<String> board = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            char[] chs = new char[n];
            Arrays.fill(chs, '.');
            chs[queens[i]] = 'Q';
            board.add(new String(chs));
        }
        return board;
    }
}
