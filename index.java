//problem two sum  

class Solution {
    public int[] twoSum(int[] nums, int target) {

        int n=nums.length;
        int result[] = new int[2];
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if (nums[i]+nums[j]==target){
                    // result[0]=nums[i];
                    // result[1]=nums[j];
                    result[0]=i;
                    result[1]=j;
                }
            }
        }
        return result;
        
    }
}

// Pattern: Brute Force (Nested Loops)

// Approach:
// Check every possible pair of elements. If their sum equals the target, return their indices.

// Time Complexity: O(n²)
// Space Complexity: O(1)