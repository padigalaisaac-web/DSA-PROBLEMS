class Solution {
    public long findKthSmallest(int[] coins, int k) {
        int n = coins.length;
        
        // Find minimum coin value for the upper bound of binary search
        long minCoin = coins[0];
        for (int coin : coins) {
            minCoin = Math.min(minCoin, coin);
        }

        long left = 1;
        long right = minCoin * k;
        long ans = right;

        while (left <= right) {
            long mid = left + (right - left) / 2;

            if (countAmounts(mid, coins, n) >= k) {
                ans = mid;
                right = mid - 1; // Try to find a smaller valid amount
            } else {
                left = mid + 1;  // Not enough amounts, increase target
            }
        }

        return ans;
    }

    // Counts the number of unique amounts <= mid using Inclusion-Exclusion
    private long countAmounts(long target, int[] coins, int n) {
        long count = 0;

        for (int mask = 1; mask < (1 << n); mask++) {
            long currentLcm = 1;
            int bitsSet = 0;
            boolean overflow = false;

            for (int i = 0; i < n; i++) {
                if (((mask >> i) & 1) == 1) {
                    bitsSet++;
                    currentLcm = lcm(currentLcm, coins[i]);
                    if (currentLcm > target) {
                        overflow = true;
                        break;
                    }
                }
            }

            if (!overflow) {
                if (bitsSet % 2 == 1) {
                    count += target / currentLcm;
                } else {
                    count -= target / currentLcm;
                }
            }
        }

        return count;
    }

    private long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    private long lcm(long a, long b) {
        return (a / gcd(a, b)) * b;
    }
}