package Algorithms;

/**
 * You are given an array prices where prices[i] is the price of a given stock on the ith day, and an integer fee representing a transaction fee.
 *
 * Find the maximum profit you can achieve. You may complete as many transactions as you like, but you need to pay the transaction fee for each transaction.
 *
 * Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).
 *
 *  
 *
 * Example 1:
 *
 * Input: prices = [1,3,2,8,4,9], fee = 2
 * Output: 8
 * Explanation: The maximum profit can be achieved by:
 * - Buying at prices[0] = 1
 * - Selling at prices[3] = 8
 * - Buying at prices[4] = 4
 * - Selling at prices[5] = 9
 * The total profit is ((8 - 1) - 2) + ((9 - 4) - 2) = 8.
 * Example 2:
 *
 * Input: prices = [1,3,7,5,10,3], fee = 3
 * Output: 6
 *  
 *
 * Constraints:
 *
 * 1 <= prices.length <= 5 * 104
 * 1 <= prices[i] < 5 * 104
 * 0 <= fee < 5 * 104
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class BestTimeToBuyAndSellStockWithTransactionFee {

    public int maxProfit(int[] prices, int fee) {
        int len = prices.length;
        // int[][] dp = new int[len][2];
        // dp[0][0] = 0;
        // dp[0][1] = -prices[0];
        // for (int i = 1; i < len; i++) {
        //     dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i] - fee);
        //     dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        // }
        // return dp[len - 1][0];
        int[] withStock = new int[len];
        int[] withoutStock = new int[len];
        withStock[0] = -prices[0];
        withoutStock[0] = 0;
        for (int i = 1; i < len; i++) {
            withStock[i] = Math.max(withStock[i - 1], withoutStock[i - 1] - prices[i]);
            withoutStock[i] = Math.max(withoutStock[i -1], withStock[i - 1] + prices[i] - fee);
        }
        return withoutStock[len - 1];
    }
}
