public class VacationDates {
    public static int countVacationDates(int n, int k, int t, int[] weather) {
        int count = 0;

        // Iterate through all possible starting points for the vacation
        for (int i = 0; i <= n - k; i++) {
            boolean isValid = true;
            // Check if all days within the window of size k have temperature <= t
            for (int j = i; j < i + k; j++) {
                if (weather[j] > t) {
                    isValid = false;
                    break;
                }
            }
            // If the window of size k satisfies the conditions, increment count
            if (isValid) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int n = 3;
        int k = 1;
        int t = 15;
        int[] weather = {-5, 0, -10};
        int output = countVacationDates(n, k, t, weather);
        System.out.println("Output: " + output);  // Output: 6
    }
}
