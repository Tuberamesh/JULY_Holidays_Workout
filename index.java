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



class Solution {
    public boolean isHappy(int n) {

        HashSet<Integer> has = new HashSet<>();

        while (n != 1) {

            if (has.contains(n)) {
                return false;
            }

            has.add(n);

            int sum = 0;

            while (n != 0) {
                int digit = n % 10;
                sum += digit * digit;
                n /= 10;
            }

            n = sum;
        }

        return true;
    }
}

// Pattern: Hash Set
// Approach: Use a HashSet to track previously seen numbers. For each number, calculate the sum of the squares of its digits. If the number becomes 1, return true. If a
//number repeats (i.e., is found in the HashSet), return false, indicating a cycle.
//Time Complexity: O(log n) – The number of digits in n decreases with each iteration, leading to a logarithmic number of iterations.
//Space Complexity: O(log n) – The HashSet may store up to log n unique numbers.



class Solution {
    public boolean isAnagram(String s, String t) {

        if(s.length()!=t.length()){
            return false;
        }

        Map<Character,Integer> s1=new HashMap<>();
        Map<Character,Integer> s2=new HashMap<>();

        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            s1.put(c,s1.getOrDefault(c,0)+1);
        }

        // add we use in hset for listn and aray for set. but here we puting in a slots.. 

        for(int i=0;i<t.length();i++){
            char c=t.charAt(i);
            s2.put(c,s2.getOrDefault(c,0)+1);
        }
 
        return s1.equals(s2);
 
        
    }
}
// Pattern: Hash Map
// Approach: Use two hash maps to count the frequency of each character in both strings. Compare the two maps to determine if they are anagrams.
// Time Complexity: O(n) – Where n is the length of the strings (since they are of equal length).
// Space Complexity: O(n) – Two hash maps are used to store character counts, which can grow with the size of the input strings.





class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;      
        int j = n - 1;      
        int k = m + n - 1;   

        // Merge from the end
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k] = nums1[i];
                i--;
            } else {
                nums1[k] = nums2[j];
                j--;
            }
            k--;
        }

        // Copy remaining elements from nums2 (if any)
        while (j >= 0) {
            nums1[k] = nums2[j];
            j--;
            k--;
        }

        
    }
}

// Pattern: Two Pointers (Merge from the End)
// Approach: Use two pointers starting from the end of both arrays. Compare elements and place the larger one at the end of nums1. Continue until all elements from nums2 are merged into nums1.
// Time Complexity: O(m + n) – Each element from both arrays is processed once.
// Space Complexity: O(1) – The merging is done in-place without using extra space.





import java.util.Arrays;

class Solution {
    public int majorityElement(int[] nums) {
       

        int vote=1;
        int test=nums[0];
        int n=nums.length;

        Arrays.sort(nums);


        return nums[n/2];
    }
}

import java.util.Arrays;

class Solution {
    public int majorityElement(int[] nums) {
       

        int vote=1;
        int test=nums[0];
        int n=nums.length;

        for(int i=1;i<n;i++){
            if(vote==0){
                vote++;
                test=nums[i];
            }
            else if (test==nums[i]) {
                vote++;
            }
            else{
                vote--;
            }
            
        }
        return test;
    }
}

// Pattern: Boyer-Moore Voting Algorithm
// Approach: Maintain a count (vote) and a candidate (test). Iterate through the array, adjusting the count based on whether the current element matches the candidate. If the count reaches zero, select the current element as the new candidate. The final candidate is the majority element.
// Time Complexity: O(n) – The array is traversed only once.
// Space Complexity: O(1) – Only a few variables are used for counting and tracking the candidate.



class Solution {
    public boolean isPalindrome(String s) {

         String str = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        char [] arr=str.toCharArray();
        int n=arr.length;
        for(int i=0;i<n;i++){
            int j=n-1-i;
            if(arr[i]!=arr[j])
            return false;
        }
        return true;

        
    }
}
// Pattern: Two Pointers
// Approach: Clean the string by removing non-alphanumeric characters and converting it to lowercase. Use two pointers to compare characters from the start and end of the string, moving towards the center. If any characters don't match, return false; otherwise, return true.
// Time Complexity: O(n) – The string is traversed once for cleaning and once for comparison.
// Space Complexity: O(n) – A new string is created for the cleaned version, which can take up to O(n) space in the worst case.


// class Solution {
//     public int[] twoSum(int[] numbers, int target) {

//         if(numbers.length==0){
//             return;
//         }

//         int n=numbers.length;
//         int res[]=new int[2];

//         for(int i=0;i<n;i++){
//             for(int j=i+1;j<n;j++){
//                 if(numbers[i]+numbers[j]==target){
//                     res[0]=i+1;
//                     res[1]=j+1;
//                 }
//             }
//         }

//         return res;
//     }
// }


class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int l = 0;
        int r = numbers.length - 1;

        while (l < r) {
            int currentSum = numbers[l] + numbers[r];

            if (currentSum == target) {
                return new int[] {l + 1, r + 1};
            } 
            else if (currentSum > target) {               
                r--;
            } 
            else {               
                l++;
            }
        }

        return new int[0];
    }
}
// Pattern: Two Pointers
// Approach: Use two pointers starting from the beginning and end of the sorted array. Calculate the sum of the elements at the two pointers. If the sum equals the target, return the indices.
// If the sum is greater than the target, move the right pointer left to decrease the sum. If the sum is less than the target, move the left pointer right to increase the sum. Repeat until the pointers meet.
// Time Complexity: O(n) – Each element is processed at most once.
// Space Complexity: O(1) – No extra space is used beyond a few variables.


# Write your MySQL query statement below

select name, 
population, area
from World
where 
area >=3000000 
or population >=25000000;

// Pattern: SQL Query
// Approach: Select the name, population, and area columns from the World table where the area
// is greater than or equal to 3,000,000 or the population is greater than or equal to 25,000,000.

# Write your MySQL query statement below

select class

from Courses 
group by class
HAVING COUNT(student) >= 5;

// Pattern: SQL Query with GROUP BY and HAVING
// Approach: Select the class column from the Courses table, group the results by class, and
// filter the groups to include only those with a count of students greater than or equal to 5 using the HAVING clause.

class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;

        
        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;  
                return digits;
            }
            digits[i] = 0; 
        }

        
        int[] newNumber = new int[n + 1];
        newNumber[0] = 1; 
        return newNumber;
    }
}
// Pattern: Array Manipulation
// Approach: Traverse the array from the end to the beginning. If a digit is less than 9, increment it and return the array. If a digit is 9, set it to 0 and continue. If all digits are 9, create a new array with an extra digit set to 1 at the beginning.
// Time Complexity: O(n) – The array is traversed at most once.
// Space Complexity: O(1) – In the case where a new array is created, it uses O(n) space, but otherwise, the operation is done in-place.


class Solution {
    public int maxArea(int[] height) {
        int n=height.length;

        int left=0;
        int right=n-1;
        int max=0;

        while(left<right){

            int area= Math.min(height[left],height[right]) *( right-left);

            max=Math.max(area, max);

            if(height[left]>height[right]){
                right--;
            }
            else{
                left++;
            }
        }
        return max;
    }
}

// Pattern: Two Pointers
// Approach: Use two pointers starting at the beginning and end of the array. Calculate the area
   // formed by the lines at the two pointers and update the maximum area found. Move the pointer pointing to the shorter line inward, as this may lead to a larger area.\
    // Time Complexity: O(n) – Each element is processed at most once.
    // Space Complexity: O(1) – No extra space is used beyond a few variables.



    class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        int n=nums.length;
        if(nums==null || nums.length<3)
        return new ArrayList<>();

        Arrays.sort(nums);

        Set<List<Integer>> res=new HashSet<>();

        for(int i=0;i<n-1;i++){

        int left=i+1;
        int right=n-1;

        while(left<right){
            int sum = nums[i] + nums[left] + nums[right];

            if(sum==0){
                res.add(Arrays.asList(nums[i],nums[left],nums[right]));
                left++;
                right--;
            }

            else if(sum<0){
                left++;
            }
            else{
                right--;
            }
          
        }
        }

        return new ArrayList<>(res);
        
    }
}

// Pattern: Two Pointers with Sorting
// Approach: Sort the array and use a fixed pointer for one element, then apply the two
//-pointer technique to find pairs that sum to the negative of the fixed element. Store unique triplets in a set to avoid duplicates.
// Time Complexity: O(n^2) – The outer loop runs n times, and the inner two-pointer search runs in linear time.
// Space Complexity: O(k) – Where k is the number of unique triplets found, stored in the set.


public class Solution {
    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Character>> cols = new HashMap<>();
        Map<Integer, Set<Character>> rows = new HashMap<>();
        Map<String, Set<Character>> squares = new HashMap<>();

        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                if (board[r][c] == '.') continue;

                String squareKey = (r / 3) + "," + (c / 3);

                if (rows.computeIfAbsent(r, k -> new HashSet<>()).contains(board[r][c]) ||
                    cols.computeIfAbsent(c, k -> new HashSet<>()).contains(board[r][c]) ||
                    squares.computeIfAbsent(squareKey, k -> new HashSet<>()).contains(board[r][c])) {
                    return false;
                }

                rows.get(r).add(board[r][c]);
                cols.get(c).add(board[r][c]);
                squares.get(squareKey).add(board[r][c]);
            }
        }
        return true;
    }
}

// Pattern: Hash Map with Sets
// Approach: Use three hash maps to track the characters seen in each row, column, and 3x3 square. For each cell, check if the character has already been seen in its
// corresponding row, column, or square. If it has, return false. Otherwise, add the character to the respective sets.
// Time Complexity: O(1) – The board size is fixed (9x9), so the operations are constant time.
// Space Complexity: O(1) – The space used for the hash maps is constant since.



class Solution {
    // LeetCode REQUIRES this to be 'int'
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;

        Set<Character> charset = new HashSet<>();
        int left = 0;
        String longest = "";

        for (int right = 0; right < s.length(); right++) {
            while (charset.contains(s.charAt(right))) {
                charset.remove(s.charAt(left));
                left++;
            }

            charset.add(s.charAt(right));

            if ((right - left + 1) > longest.length()) {
                longest = s.substring(left, right + 1);
            }
        }
        
        // Return the length of the string you found
        return longest.length();
    }
}
//
// class Solution {
//     public int lengthOfLongestSubstring(String s) {
//       Set <Character> charset=new HashSet<>();

//       int left=0;
//       int right;
//       int max_length=0;

//       for(right=0;right<s.length();right++){

//          while(charset.contains(s.charAt(right))){
//             charset.remove(s.charAt(left));
//             left++;
//          }

//         charset.add(s.charAt(right));
//         max_length=Math.max(max_length, right-left+1);
    
//       }
//       return max_length;
//     }
//     } 
// Pattern: Sliding Window with Hash Set
// Approach: Use a sliding window defined by two pointers (left and right) to track the current substring without repeating characters. Use a hash set to store characters in the current window. If a
// character is already in the set, move the left pointer to the right until the character can be added. Update the maximum length found during the process.
// Time Complexity: O(n) – Each character is processed at most twice (once added and once removed).
// Space Complexity: O(min(n, m)) – Where n is the length of the string and m is the size of the character set (e.g., 26 for lowercase letters). The hash set stores characters in the current window.

class Solution {
    public  String longestPalindrome(String str) {

    if (str.length() <= 1)
      return str;

    String LPS = "";

    for (int i = 1; i < str.length(); i++) {

      // Consider odd length
      int low = i;
      int high = i;
      while(str.charAt(low) == str.charAt(high)) {
        low--;
        high++;

        if (low == -1 || high == str.length())
          break;
      }

      String palindrome = str.substring(low+1, high);
      if (palindrome.length() > LPS.length()) {
        LPS = palindrome;
      }

      // Consider even length
      low = i-1;
      high = i;
      while(str.charAt(low) == str.charAt(high)) {
        low--;
        high++;

        if (low == -1 || high == str.length())
          break;
      }

      palindrome = str.substring(low+1, high);
      if (palindrome.length() > LPS.length()) {
        LPS = palindrome;
      }
    }

    return LPS;
  }

}

// Pattern: Expand Around Center
// Approach: For each character in the string, consider it as the center of a potential palindrome
// Expand outwards to check for both odd and even length palindromes. Keep track of the longest palindrome found during the process.
// Time Complexity: O(n^2) – For each character, we may expand to the entire length of the string in the worst case.
// Space Complexity: O(1) – Only a few variables are used for tracking indices and


class Solution {
    public String reverseWords(String s) {
        String[] words = s.trim().split("\\s+");
        StringBuilder ans = new StringBuilder();

        for (int i = words.length - 1; i >= 0; i--) {
            ans.append(words[i]);

            if (i != 0) {
                ans.append(" ");
            }
        }

        return ans.toString();
    }
}
// Pattern: String Manipulation
// Approach: Trim the input string to remove leading and trailing spaces, then split it into words
  //  using whitespace as the delimiter. Reverse the order of the words and join them back together with a single space between each word.
// Time Complexity: O(n) – The string is traversed multiple times (for trimming, splitting, and joining).
// Space Complexity: O(n) – Additional space is used for the array of words.

