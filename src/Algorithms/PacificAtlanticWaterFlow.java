package Algorithms;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an m x n matrix of non-negative integers representing the height of each unit cell in a continent, the "Pacific ocean" touches the left and top edges of the matrix and the "Atlantic ocean" touches the right and bottom edges.
 *
 * Water can only flow in four directions (up, down, left, or right) from a cell to another one with height equal or lower.
 *
 * Find the list of grid coordinates where water can flow to both the Pacific and Atlantic ocean.
 *
 * Note:
 *
 * The order of returned grid coordinates does not matter.
 * Both m and n are less than 150.
 *  
 *
 * Example:
 *
 * Given the following 5x5 matrix:
 *
 *   Pacific ~   ~   ~   ~   ~
 *        ~  1   2   2   3  (5) *
 *        ~  3   2   3  (4) (4) *
 *        ~  2   4  (5)  3   1  *
 *        ~ (6) (7)  1   4   5  *
 *        ~ (5)  1   1   2   4  *
 *           *   *   *   *   * Atlantic
 *
 * Return:
 *
 * [[0, 4], [1, 3], [1, 4], [2, 2], [3, 0], [3, 1], [4, 0]] (positions with parentheses in above matrix).
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/pacific-atlantic-water-flow
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class PacificAtlanticWaterFlow {

    public static void main(String[] args) {
        int[][] matrix = {{1, 1}, {1, 1}, {1, 1}};
        List<List<Integer>> ans = pacificAtlantic(matrix);
        System.out.println(ans);
    }
    private static int m, n;
    public static List<List<Integer>> pacificAtlantic(int[][] matrix) {
        List<List<Integer>> ans = new ArrayList<>();
        if (matrix.length == 0 || matrix[0].length == 0) {
            return ans;
        }
        m = matrix.length;
        n = matrix[0].length;
        int[][] po = new int[m][n];
        int[][] ao = new int[m][n];
        for (int i = 0; i < n; i++) {
            dfs(matrix, 0, i, po);
            dfs(matrix, m-1, i, ao);
        }
        for (int j = 0; j < m; j++) {
            dfs(matrix, j, 0, po);
            dfs(matrix, j, n-1, ao);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (po[i][j] == 1 && ao[i][j] ==1) {
                    List<Integer> list = new ArrayList<>();
                    list.add(i);
                    list.add(j);
                    ans.add(list);
                }
            }
        }
        return ans;
    }

    public static boolean inArea(int x, int y) {
        if (x >= 0 && x < m && y >= 0 && y < n) {
            return true;
        }
        return false;
    }

    public static int[] direction = {-1, 0, 1, 0, -1};

    public static void dfs(int[][] matrix, int x, int y, int[][] ocean) {
        ocean[x][y] = 1;
        int newX;
        int newY;
        for (int i = 0; i < 4; i++) {
            newX = x + direction[i];
            newY = y + direction[i+1];
            if (inArea(newX, newY) && matrix[newX][newY] >= matrix[x][y] && ocean[x][y] == 0) {
                dfs(matrix, newX, newY, ocean);
            }
        }
    }
}
