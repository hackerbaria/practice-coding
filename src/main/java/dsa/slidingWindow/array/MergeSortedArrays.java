package dsa.slidingWindow.array;

import java.util.Arrays;

public class MergeSortedArrays {
    public static void main(String[] args) {
        int[] a = { 0, 3, 4, 31, 35, 37, 39 };
        int[] b = { 2, 5, 6, 7, 100 };
        int[] c = mergeSortedArrays(a,b);
        System.out.println(Arrays.toString(c));
    }
    // {0, 2, 3, 4, 5}
    // result[0] = 0; result[1] = 2; k =3, i =3, j =2;
    // result[2] = 3
    // a[1] < b[0]
    // int i,j,k
    // int result[] = new int(a.length() + b.length());
    // while (i < k && j < k)
    // if(a[i] < b[j])  --> result[k++] = a[i++]: result[k++] = b[j++]
    // we also need to copy the remain elements from a to the result if any
    // we also need to copy the remain elements from b to the result if any

    // This algorithm:
    // using three pointers, i, j, k
    // 1. create a new array to store the result
    private static int[] mergeSortedArrays(int[] a, int[] b) {
        int n = a.length;
        int m = b.length;
        int[] result = new int[n + m];
        int i = 0, j = 0, k = 0;
        while (i < n && j < m) {
            if (a[i] < b[j]) {
                result[k++] = a[i++];
            } else {
                result[k++] = b[j++];
            }
        }

        while (i < n) {
            result[k++] = a[i++];
        }
        while (j < m) {
            result[k++] = b[j++];
        }
        return result;


    }
}
