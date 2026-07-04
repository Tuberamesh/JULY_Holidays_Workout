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



class Solution {
    public int removeDuplicates(int[] nums) {
    int slow=0;
    for(int fast=1;fast<nums.length;fast++){
        if(nums[slow]!=nums[fast]){
            slow++;
            nums[slow]=nums[fast];
        }
    }
    return slow+1  ;
      }
}

        
//     Pattern: Two Pointers (Fast & Slow)
// Approach: Use a fast pointer to scan the array and a slow pointer to track the position of the last unique element. When a new unique element is found, place it at the next position.
// Time Complexity: O(n) – The array is traversed only once.
// Space Complexity: O(1) – Duplicates are removed in-place without using extra memory.


class Solution {
    public int searchInsert(int[] nums, int target) {
        
        int n=nums.length;

        for(int i=0;i<n;i++){
            if(nums[i]>=target)
            return i;
        }
        return n;
    }
}

// Pattern: Linear Search
// Approach: Iterate through the array and find the first index where the element is greater than or equal to the target.
// Time Complexity: O(n) – In the worst case, we may need to check every element.
// Space Complexity: O(1) – No extra space is used.


class Solution {
    public int maxSubArray(int[] nums) {

        int max=nums[0];
        int sum=nums[0];
        for(int i=1;i<nums.length;i++){

            sum=Math.max(nums[i],sum+nums[i]);

            max=Math.max(max,sum);
        }
        return max;
        
    }
}
// Pattern: Dynamic Programming (Kadane's Algorithm)
// Approach: Iterate through the array, maintaining a running sum of the maximum subarray ending at the current index. Update the global maximum whenever the running sum exceeds it.
// Time Complexity: O(n) – The array is traversed only once.
// Space Complexity: O(1) – Only a


class Solution {
    public String longestCommonPrefix(String[] strs) {

        if(strs==null)return "";
        
        StringBuilder result=new StringBuilder();
        
        Arrays.sort(strs);
        char [] first=strs[0].toCharArray();
        char [] last=strs[strs.length-1].toCharArray();

        for(int i=0;i<first.length;i++){
            if(first[i]!=last[i])
              break;
            result.append(first[i]);

        }
        return result.toString();

        

        
    }
}

// Pattern: Sorting and Comparison
// Approach: Sort the array of strings and compare the first and last strings character by character to find the longest common prefix.
// Time Complexity: O(n log n) – Due to sorting the array
// Space Complexity: O(1) – Only a constant amount of extra space is used for the result.


class Solution {
    public int lengthOfLastWord(String s) {
        s = s.trim(); 
        int lastSpaceIndex = s.lastIndexOf(' '); 
        return s.length() - lastSpaceIndex - 1; 
    }
}

// Pattern: String Manipulation
// Approach: Trim the string to remove leading and trailing spaces, find the index of the last space, and calculate the length of the last word based on that index.
// Time Complexity: O(n) – The string is traversed to trim and find the last space.
// Space Complexity: O(1) – No extra space is used beyond a few variables.


public class Solution{

  boolean canConstruct(String ransomNote, String magazine) {
    int[] charCount = new int[26];

    
    for (char c : magazine.toCharArray()) {
      charCount[c - 'a']++;
    }

 
    for (char c : ransomNote.toCharArray()) {
      if (charCount[c - 'a'] == 0) {
        return false; 
      }
      charCount[c - 'a']--;
    }

    
    return true;
  }

}

// Pattern: Hash Table
// Approach: Use an array to count the frequency of each character in the magazine. Then, iterate through the ransom note and decrease the count for each character used. If any character count becomes zero, return false.
// Time Complexity: O(n + m) – Where n is the length of the magazine and m is the length of the ransom note.
// Space Complexity: O(1) – The size of the array is constant (26 characters).
