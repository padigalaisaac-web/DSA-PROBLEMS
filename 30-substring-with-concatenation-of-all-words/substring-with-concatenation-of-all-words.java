import java.util.*;

class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (s == null || s.length() == 0 || words == null || words.length == 0) {
            return result;
        }

        int wordLen = words[0].length();
        int wordCount = words.length;
        int totalLen = wordLen * wordCount;
        int sLen = s.length();

        if (sLen < totalLen) return result;

        // Count frequency of each word in the input array
        Map<String, Integer> wordMap = new HashMap<>();
        for (String word : words) {
            wordMap.put(word, wordMap.getOrDefault(word, 0) + 1);
        }

        // Run sliding window for each offset from 0 to wordLen - 1
        for (int i = 0; i < wordLen; i++) {
            int left = i;
            int right = i;
            Map<String, Integer> currentMap = new HashMap<>();
            int count = 0;

            while (right + wordLen <= sLen) {
                String sub = s.substring(right, right + wordLen);
                right += wordLen;

                if (wordMap.containsKey(sub)) {
                    currentMap.put(sub, currentMap.getOrDefault(sub, 0) + 1);
                    count++;

                    // If a word is repeated more than expected, shift left pointer
                    while (currentMap.get(sub) > wordMap.get(sub)) {
                        String leftSub = s.substring(left, left + wordLen);
                        currentMap.put(leftSub, currentMap.get(leftSub) - 1);
                        count--;
                        left += wordLen;
                    }

                    // Found a valid concatenation
                    if (count == wordCount) {
                        result.add(left);
                    }
                } else {
                    // Reset window if an invalid word is encountered
                    currentMap.clear();
                    count = 0;
                    left = right;
                }
            }
        }

        return result;
    }
}