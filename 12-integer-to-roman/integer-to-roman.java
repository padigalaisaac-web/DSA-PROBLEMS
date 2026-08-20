class Solution {
    public String intToRoman(int num) {
        // Store value-symbol pairs in descending order including subtractive cases
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < values.length; i++) {
            // Append the symbol as long as the current value fits into num
            while (num >= values[i]) {
                num -= values[i];
                sb.append(symbols[i]);
            }
        }
        
        return sb.toString();
    }
}