class Solution {
    public int[] validSequence(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        // suf[i] = index in word2 that still needs to be matched
        // after processing word1[i...]
        int[] suf = new int[n + 1];
        Arrays.fill(suf, m - 1);

        int j = m - 1;

        for (int i = n - 1; i >= 0; i--) {
            if (j >= 0 && word1.charAt(i) == word2.charAt(j)) {
                j--;
            }
            suf[i] = j;
        }

        int[] ans = new int[m];
        int size = 0;

        int i = 0;
        j = 0;
        boolean usedMismatch = false;

        while (j < m && i < n) {

            // Characters match
            if (word1.charAt(i) == word2.charAt(j)) {
                ans[size++] = i;
                i++;
                j++;
            }

            // Use the one allowed mismatch
            else if (!usedMismatch) {
                // Check whether word2[j+1...] can still be matched
                if (i + 1 <= n && suf[i + 1] <= j) {
                    ans[size++] = i;
                    usedMismatch = true;
                    i++;
                    j++;
                } else {
                    i++;
                }
            }

            // Mismatch already used, so skip this character
            else {
                i++;
            }
        }

        if (size != m) {
            return new int[0];
        }

        return ans;
    }
}
