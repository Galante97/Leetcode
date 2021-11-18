/*
88. Merge Sorted Array

You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n, representing the number of elements in nums1 and nums2 respectively.
Merge nums1 and nums2 into a single array sorted in non-decreasing order.
The final sorted array should not be returned by the function, but instead be stored inside the array nums1. To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be merged, and the last n elements are set to 0 and should be ignored. nums2 has a length of n.

Example 1:
    Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
    Output: [1,2,2,3,5,6]
    Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
    The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1.


Constraints:
    nums1.length == m + n
    nums2.length == n
    0 <= m, n <= 200
    1 <= m + n <= 200
    -109 <= nums1[i], nums2[j] <= 109

COMPLEXITY
Time complexity : O(n + m)
Space complexity : O(1) - no extra arrays or datastructures
*/


class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        
        int p1 = m - 1; //nums1 pointer
        int p2 = n - 1; //nums2 pointer
        
        for (int i = m + n - 1; i >= 0; i--) {
            if (p2 < 0) {
                break;
            }
            
            if (p1 >= 0 && nums1[p1] > nums2[p2]) { //take from nums1
                nums1[i] = nums1[p1];
                p1--;
                
            } else { //take from nums2
                nums1[i] = nums2[p2];
                p2--;
            }
        }
    }
}