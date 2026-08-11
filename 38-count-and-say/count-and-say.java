class Solution {
    public String countAndSay(int n) {
        String result = "1";

        // Generate terms iteratively from 2 up to n
        for (int i = 2; i <= n; i++) {
            StringBuilder sb = new StringBuilder();
            int count = 1;

            for (int j = 0; j < result.length(); j++) {
                // If the next character is the same, increment the count
                if (j + 1 < result.length() && result.charAt(j) == result.charAt(j + 1)) {
                    count++;
                } else {
                    // Append frequency followed by the character
                    sb.append(count).append(result.charAt(j));
                    count = 1; // Reset count for the next group
                }
            }
            result = sb.toString();
        }

        return result;
    }
}