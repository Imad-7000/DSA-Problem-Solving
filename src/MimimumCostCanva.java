import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class MimimumCostCanva {
    static long[] dp;
    public static long getMinimumCost(List<Integer> cost, int k) {
    // Write your code here
    
        //---Using DP plus sliding window approach
        int n = cost.size();
        dp = new long[n + 1];
        Arrays.fill(dp, Long.MAX_VALUE);
        dp[0] = 0;
        Deque<Integer> deque = new LinkedList<>();
        deque.add(0);

        for (int i = 1; i <= n; i++) {
            if (!deque.isEmpty() && deque.peekFirst() < i - k) {
                deque.pollFirst();
            }

            dp[i] = dp[deque.peekFirst()] + cost.get(i - 1);

            while (!deque.isEmpty() && dp[deque.peekLast()] >= dp[i]) {
                deque.pollLast();
            }
            
            deque.addLast(i);
        }

        return dp[n];
    }
}
