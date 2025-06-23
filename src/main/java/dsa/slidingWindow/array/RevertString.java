package dsa.slidingWindow.array;

public class RevertString {
    public static void main(String[] args) {
        String s = "hello";
        char[] arr = s.toCharArray();
        reverseString(arr);
        System.out.println(arr);
    }

    // time complexity = O(n)
    // space complexity = O(1)
    // String s = "hello"
    // left = 0, right = 4
    // first loop: (0 <4): temp = 'h', s[0] = 'o', s[4] = 'h' --> increase left = 1 right = 3
    // second: (1 < 3) --> true: temp = s[1] = 'e', s[1] = 'l', s[3] = 'e' --> increase left = 2, right = 2
    // third: (2 < 2) --> no: stop
    // array = olleh
    public static void reverseString(char[] arr) {
        int left = 0, right = arr.length - 1;
        while (left < right) {
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }
}
