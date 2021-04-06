package Algorithms;

import java.util.LinkedList;
import java.util.Queue;

/**
 * In a given 2D binary array A, there are two islands.  (An island is a 4-directionally connected group of 1s not connected to any other 1s.)
 *
 * Now, we may change 0s to 1s so as to connect the two islands together to form 1 island.
 *
 * Return the smallest number of 0s that must be flipped.  (It is guaranteed that the answer is at least 1.)
 *
 *  
 *
 * Example 1:
 *
 * Input: A = [[0,1],[1,0]]
 * Output: 1
 * Example 2:
 *
 * Input: A = [[0,1,0],[0,0,0],[0,0,1]]
 * Output: 2
 * Example 3:
 *
 * Input: A = [[1,1,1,1,1],[1,0,0,0,1],[1,0,1,0,1],[1,0,0,0,1],[1,1,1,1,1]]
 * Output: 1
 *  
 *
 * Constraints:
 *
 * 2 <= A.length == A[0].length <= 100
 * A[i][j] == 0 or A[i][j] == 1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shortest-bridge
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ShortestBridge {

    private int[] direction = {-1, 0, 1, 0, -1};
    public int shortestBridge(int[][] A) {
        int res = 0;
        Queue<int[]> queue = new LinkedList<>();
        loop: for (int x = 0; x < A.length; x++) {
            for (int y = 0; y < A[0].length; y++) {
                if (A[x][y] == 0) {
                    continue;
                }
                dfs(A, x, y, queue);
                break loop;
            }
        }
        w: while (!queue.isEmpty()) {
            res++;
            int size = queue.size();
            while (size-- > 0) {
                int[] point = queue.poll();
                for (int i = 0; i < 4; i++) {
                    int newX = point[0] + direction[i];
                    int newY = point[1] + direction[i+1];
                    if (newX < 0 || newX >= A.length || newY < 0 || newY >= A[0].length) {
                        continue;
                    }
                    if (A[newX][newY] == 1) {
                        break w;
                    }
                    if (A[newX][newY] == 0) {
                        A[newX][newY] = 2;
                        queue.add(new int[]{newX, newY});
                    }
                }
            }
        }
        return res;
    }

    public void dfs(int[][] A, int x, int y, Queue<int[]> queue) {
        if (x < 0 || x >= A.length || y < 0 || y >= A[0].length) {
            return;
        }
        if (A[x][y] == 0) {
            queue.add(new int[] {x, y});
            return;
        }
        if (A[x][y] == 2) {
            return;
        }
        A[x][y] = 2;
        dfs(A, x+1, y, queue);
        dfs(A, x-1, y, queue);
        dfs(A, x, y+1, queue);
        dfs(A, x, y-1, queue);
    }
}
