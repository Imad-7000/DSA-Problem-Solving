package HeyCoach.SessionTest.LevelTest;

public class maxGCD {
    public int solve(int d, int n) {
        //Write your code here 
            int minSum = (n * (n + 1)) / 2;
            if (d < minSum)
                return -1;
            int i = (int) Math.sqrt(d);
            int res = 1;
            while (i >= 1)
            {

                // If i is a factor of N
                if (d % i == 0)
                {
                    if (i >= minSum)
                        res = Math.max(res, d / i);
    
                    if (d / i >= minSum)
                        res = Math.max(res, i);
                }
                i--;
            }
    
            return res;
    }
}
