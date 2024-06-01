import java.util.List;

public class MaximisexorSum {
     public static long getMaxOrSum(List<Integer> arr, int k) {
    // Write your code here
     int n = arr.size();
        if (n == 1) {
            return (long) arr.get(0) << k;
        }
        //----using pre post xor logic
        long[] pre = new long[n];
        long[] post = new long[n];

        pre[0] = arr.get(0);
        for (int i = 1; i < n; i++) {
            pre[i] = pre[i - 1] | arr.get(i);
        }

        post[n - 1] = arr.get(n - 1);
        for (int i = n - 2; i >= 0; i--) {
            post[i] = post[i + 1] | arr.get(i);
        }

        long backMaximum = ((long) arr.get(0) << k) | post[1];
        long frontMaximum = ((long) arr.get(n - 1) << k) | pre[n - 2];
        long finalAns = Math.max(backMaximum, frontMaximum);

        for (int i = 1; i < n - 1; i++) {
            finalAns = Math.max(finalAns, ((long) arr.get(i) << k) | pre[i - 1] | post[i + 1]);
        }
        return finalAns;
    }
}
