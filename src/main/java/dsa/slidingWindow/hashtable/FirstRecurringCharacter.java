package dsa.slidingWindow.hashtable;

import java.util.HashSet;
import java.util.Set;

public class FirstRecurringCharacter {
    public static void main(String[] args) {
        int[] arr = { 1, 3, 3, 4, 5, 4, 7, 8, 9, 10 };
        int firstRecurringCharactter = findFirstRecurringCharacter(arr);
        System.out.println(firstRecurringCharactter);
    }

    // we can set a Set to store the element we look
    // if the new element is existed in the Set return the element
    // otherwise return -1;
    private static int findFirstRecurringCharacter(int[] arr) {
        Set<Integer> set = new HashSet<>();
        for (int j : arr) {
            if (set.contains(j)) {
                return j;
            } else {
                set.add(j);
            }
        }
        return -1;
    }
}
