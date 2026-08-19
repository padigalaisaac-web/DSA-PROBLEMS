import java.util.*;

class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        // Map row numbers to a bitmask of reserved seat locations in columns 2 through 9
        Map<Integer, Integer> rowMasks = new HashMap<>();
        
        for (int[] seat : reservedSeats) {
            int row = seat[0];
            int col = seat[1];
            
            // Seats 1 and 10 do not affect 4-person allocations
            if (col >= 2 && col <= 9) {
                rowMasks.put(row, rowMasks.getOrDefault(row, 0) | (1 << (col - 2)));
            }
        }
        
        // Rows with no reserved seats (in cols 2-9) can fit 2 groups each
        int totalGroups = (n - rowMasks.size()) * 2;
        
        // Masks for seat ranges (0-indexed relative to col 2):
        // Left block (cols 2,3,4,5)  -> bits 0,1,2,3 -> 0b00001111 (15)
        // Middle block (cols 4,5,6,7)-> bits 2,3,4,5 -> 0b00111100 (60)
        // Right block (cols 6,7,8,9) -> bits 4,5,6,7 -> 0b11110000 (240)
        int leftMask = 15;    // 0b00001111
        int middleMask = 60;  // 0b00111100
        int rightMask = 240;  // 0b11110000
        
        for (int mask : rowMasks.values()) {
            boolean leftAvailable = (mask & leftMask) == 0;
            boolean rightAvailable = (mask & rightMask) == 0;
            
            if (leftAvailable && rightAvailable) {
                totalGroups += 2;
            } else if (leftAvailable || rightAvailable || (mask & middleMask) == 0) {
                totalGroups += 1;
            }
        }
        
        return totalGroups;
    }
}