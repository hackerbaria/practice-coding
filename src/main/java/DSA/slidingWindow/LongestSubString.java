package DSA.slidingWindow;

import java.util.HashSet;

public class LongestSubString {
    public static void main(String[] args) {
        String s = "abcabcbb";
        int result = lengthOfLongestSubstring(s);
        System.out.println("The length of the longest substring without repeating characters is: " + result);
    }

    // sliding window approach
    public static int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int left = 0, right = 0, maxLength = 0;
        HashSet<Character> seen = new HashSet<>();
        while (right < n) {
            char c = s.charAt(right);
            if (!seen.contains(c)) {
                seen.add(c);
                maxLength = Math.max(maxLength, right - left + 1);
                right++;
            } else {
                //abcbacde right =3, left = 1, maxLength = 3 seen = {c}
                seen.remove(s.charAt(left));
                left++;
            }
        }
        return maxLength;
    }
}
