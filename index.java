// problem solutions

class Solution {
    // Two Sum - Brute Force
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        int result[] = new int[2];
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return result;
    }

    // Remove Element - Two Pointers (Fast & Slow)
    // Approach: Traverse the array with one pointer (i). Whenever an element is not equal to val,
    // place it at index k and increment k. This overwrites unwanted elements in-place.
    // Time Complexity: O(n)
    // Space Complexity: O(1)


    public int removeElement(int[] nums, int val) {
        if (nums.length == 0) return 0;
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[k] = nums[i];
                k++;
            }
        }
        return k;
    }
}

// For this solution, the documentation would be:

//   Pattern:  Two Pointers (Fast & Slow Pointer)
//    Approach:  Traverse the array with one pointer (`i`). Whenever an element is not equal to `val`, place it at index `k` and increment `k`. This overwrites unwanted elements in-place.
//    Time Complexity:   O(n)  – The array is traversed only once.
//    Space Complexity:   O(1)  – No extra data structure is used; the modification is done in-place.
