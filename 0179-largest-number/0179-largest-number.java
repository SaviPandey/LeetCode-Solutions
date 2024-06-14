public class Solution {
    public String largestNumber(int[] nums) {
        // Convert integers to strings
        String[] numStrings = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            numStrings[i] = String.valueOf(nums[i]);
        }

        // Sort strings using a custom comparator
        Arrays.sort(numStrings, new Comparator<String>() {
            public int compare(String s1, String s2) {
                String order1 = s1 + s2;
                String order2 = s2 + s1;
                return order2.compareTo(order1); // Compare in descending order
            }
        });

        // Concatenate sorted strings
        StringBuilder sb = new StringBuilder();
        for (String numString : numStrings) {
            sb.append(numString);
        }

        // Remove leading zeros
        while (sb.charAt(0) == '0' && sb.length() > 1) {
            sb.deleteCharAt(0);
        }

        return sb.toString();
    }
} 