class Solution {
    public boolean sumGame(String num) {
        int n = num.length();
        int sumDiff = 0;
        int qDiff = 0;

        for (int i = 0; i < n; i++) {
            boolean isLeft = i < n / 2;
            char c = num.charAt(i);

            if (c == '?') {
                qDiff += isLeft ? 1 : -1;
            } else {
                sumDiff += isLeft ? (c - '0') : -(c - '0');
            }
        }

        // Bob wins if and only if sumDiff + (qDiff / 2) * 9 == 0
        return sumDiff * 2 != -qDiff * 9;
    }
}