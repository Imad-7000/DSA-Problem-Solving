/*
 * 
 * 
 * Getting in faang companies
A learner at heycoach wants to grab a job in a faang companies, so he start following a schedule
 ( learning DSA, Practising questions and learning cs fundamentals ), Each day he performs one of these three activities and he 
  can’t perform the same activity on two consecutive days. Each activity has some merit points on each day.
   These merit points will decide weather he is eligible to get into a faang company or not. Learner wants to improve everything to get a good job as early as possible. 
   Can you help the learner in finding out the maximum merit point he can earn ?

Input Format:

The first line contains a single integer 'n' denoting the number of days.

The next 'n' lines contains three space separated integers denoting the merit values of each of the three activities on that day.

Output Format:

Return the maximum amount of merit points achievable.

Example

Input :

3

1 2 5 

3 1 1

3 3 3

Output : 11
Contraints:

1 <= N <= 10000

1 <= Value of PointsArray <= 100
 */
package Recursion.DP;

public class Faang {
    private int[][] memo;

    public int maxMeritPoints(int n, int[][] points) {
        memo = new int[n][3];
        
        // Initialize memoization table with -1
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                memo[i][j] = -1;
            }
        }

        // Start the recursion from the last day
        return Math.max(Math.max(maxMeritPointsUtil(n - 1, 0, points), 
                                 maxMeritPointsUtil(n - 1, 1, points)), 
                        maxMeritPointsUtil(n - 1, 2, points));
    }

    private int maxMeritPointsUtil(int day, int activity, int[][] points) {
        if (day == 0) {
            return points[0][activity];
        }

        if (memo[day][activity] != -1) {
            return memo[day][activity];
        }

        int maxPoints;
        if (activity == 0) {
            maxPoints = points[day][0] + Math.max(maxMeritPointsUtil(day - 1, 1, points),
                                                  maxMeritPointsUtil(day - 1, 2, points));
        } else if (activity == 1) {
            maxPoints = points[day][1] + Math.max(maxMeritPointsUtil(day - 1, 0, points),
                                                  maxMeritPointsUtil(day - 1, 2, points));
        } else {
            maxPoints = points[day][2] + Math.max(maxMeritPointsUtil(day - 1, 0, points),
                                                  maxMeritPointsUtil(day - 1, 1, points));
        }

        memo[day][activity] = maxPoints;
        return maxPoints;
    }
}
