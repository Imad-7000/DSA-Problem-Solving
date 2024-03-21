package Arrays;
/*
 * 
 * Swap the ith element in such a way that the last element of both arrays are maximum.
 * If possible, Print "YES" else Print "NO"
 */

public class MaxSwap {

    public static void main(String[] args) {
        int[] a = new int[]{1,2,7};
        int[] b = new int[]{7,6,4};

        System.err.println(maxSwap(3, a, b));
    }

    public static String maxSwap(int n, int[] a, int[] b){
        int maxa = a[n-1];
        int maxb =b[n-1];

        for(int i = 0; i < n;i++){
            if(a[i] < maxa && b[i] < maxb)
                continue;
            else if(a[i] > maxa){
                if(b[i] > maxa || a[i] > maxb)
                    return "NO";
                else{
                    int temp = b[i];
                    b[i] = a[i];
                    a[i] = temp;
                }
            }
            else if(b[i] > maxb){
                if(a[i] > maxb || b[i] > maxa)
                    return "NO";
                else{
                    int temp = b[i];
                    b[i] = a[i];
                    a[i] = temp;
                }
            }
        }
        return "YES";
    }
}
