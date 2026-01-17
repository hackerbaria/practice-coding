package dsa.slidingWindow.string;

// Longest Substring Without Repeating Characters
// Given a string s, find the length of the longest substring without repeating characters.
// Example 1:
// Input: s = "abcabcbb"
// Output: 3
// Explanation: The answer is "abc", with the length of 3.
// Example 2:
// Input: s = "bbbbb"
// Output: 1
// Explanation: The answer is "b", with the length of 1.
// Example 3:
// Input: s = "pwwkew"
// Output: 3
// Explanation: The answer is "wke", with the length of 3.
// Notice that the answer must be a substring, "pwke" is a subsequence and
// not a substring.

import java.util.HashSet;

public class LongestSubstring {

    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int maxLength = 0;
        int left = 0;
        int right = 0;
        HashSet<Character> seen = new HashSet<>();
        while(right < n) {
            char c = s.charAt(right);
            if(!seen.contains(c)) {
                seen.add(s.charAt(right));
                maxLength = Math.max(maxLength, right - left + 1);
                right++;

            } else {
                seen.remove(s.charAt(left));
                left++;
            }
        }
        return  maxLength;
    }

}

