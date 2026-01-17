package dsa.slidingWindow.string;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LongestSubstringTest {

    private final LongestSubstring sut = new LongestSubstring();

    @Test
    void example1_abcabcbb() {
        assertEquals(3, sut.lengthOfLongestSubstring("abcabcbb"));
    }

    @Test
    void example2_bbbbb() {
        assertEquals(1, sut.lengthOfLongestSubstring("bbbbb"));
    }

    @Test
    void example3_pwwkew() {
        assertEquals(3, sut.lengthOfLongestSubstring("pwwkew"));
    }

    @Test
    void emptyString() {
        assertEquals(0, sut.lengthOfLongestSubstring(""));
    }

    @Test
    void singleCharacter() {
        assertEquals(1, sut.lengthOfLongestSubstring("a"));
    }

    @Test
    void allUniqueCharacters() {
        assertEquals(5, sut.lengthOfLongestSubstring("abcde"));
    }

    @Test
    void repeatingPattern() {
        assertEquals(2, sut.lengthOfLongestSubstring("abababab"));
    }

    @Test
    void nullInput_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> sut.lengthOfLongestSubstring(null));
    }
}

