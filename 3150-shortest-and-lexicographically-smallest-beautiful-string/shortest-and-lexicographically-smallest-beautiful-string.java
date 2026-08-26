class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int n = s.length();
        String result = "";
        int left = 0, count = 0;

        for (int right = 0; right < n; right++) {
            if (s.charAt(right) == '1') {
                count++;
            }

            // Shrink window from the left to remove leading '0's and keep count == k
            while (count == k) {
                String sub = s.substring(left, right + 1);
                
                // Compare with current best result
                if (result.isEmpty() || sub.length() < result.length() || 
                   (sub.length() == result.length() && sub.compareTo(result) < 0)) {
                    result = sub;
                }

                if (s.charAt(left) == '1') {
                    count--;
                }
                left++;
            }
        }

        return result;
    }
}