package DSA.slidingWindow.hashmap;

public class TwoSum {
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 22; //1,3
        int[] result = twoSum(nums, target);
        if (result != null) {
            System.out.println("Indices: " + result[0] + ", " + result[1]);
        } else {
            System.out.println("No two sum solution found.");
        }
    }

    public static int[] twoSum(int[] nums, int target) {
        // Create a HashMap to store the numbers and their indices
        java.util.HashMap<Integer, Integer> map = new java.util.HashMap<>();

        // Iterate through the array
        for (int i = 0; i < nums.length; i++) {
            // Calculate the complement
            int complement = target - nums[i];

            // Check if the complement exists in the map
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }

            // Store the current number and its index in the map
            map.put(nums[i], i);
        }

        // Return null if no solution is found
        return null;
    }
}
