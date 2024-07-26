/*
 * 
 * 
 * Median at every step
Given an input stream of N integers. The task is to insert these numbers into a new stream and find the median of the stream formed by 
each insertion of X to the new stream.

Example 1

Input :
N = 4,
X[] = [5,15,1,3]

Output :
[5,10,5,4]

Explanation:
Flow in stream : 5, 15, 1, 3 
5 goes to stream --> median 5 (5) 
15 goes to stream --> median 10 (5,15) 
1 goes to stream --> median 5 (5,15,1) 
3 goes to stream --> median 4 (5,15,1 3) 
Example 2

Input:
N = 3,
X[] = [5,10,15]

Output:
5 7 10

Explanation:
Flow in stream: 5, 10, 15
5 goes to stream --> median 5 (5) 
10 goes to stream --> median 7.5 (5,10) 
15 goes to stream --> median 10 (5,10,15) 
Constraints

1 <= N <= 10^6
1 <= x <= 10^6
 */
package General;

public class MedianAtEveryStep {
    public int binarySearch(int arr[], int item, int low, int high) {
        if (low >= high) {
            return (item > arr[low]) ? (low + 1) : low;
        }

        int mid = (low + high) / 2;

        if (item == arr[mid])
            return mid + 1;

        if (item > arr[mid])
            return binarySearch(arr, item, mid + 1, high);

        return binarySearch(arr, item, low, mid - 1);
    }

    // Function to print median of stream of integers
    public void streamed(int arr[], int n) {
        int i, j, pos;
        int num;
        int count = 1;

        StringBuilder result = new StringBuilder();
        result.append(arr[0]).append(" "); // Print median for the first element

        for (i = 1; i < n; i++) {
            int median;
            j = i - 1;
            num = arr[i];

            // find position to insert current element in sorted part of array
            pos = binarySearch(arr, num, 0, j);

            // move elements to right to create space to insert the current element
            while (j >= pos) {
                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = num;

            // increment count of sorted elements in array
            count++;

            // if odd number of integers are read from stream then middle element in sorted order is median else average of middle elements is median
            if (count % 2 != 0) {
                median = arr[count / 2];
            } else {
                median = (arr[(count / 2) - 1] + arr[count / 2]) / 2;
            }

            result.append(median).append(" "); // Append median to result
        }

        System.out.println(result.toString().trim()); // Print all medians
    }
}
