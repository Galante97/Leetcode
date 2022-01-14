/*
 * 46. Permutations
 * Given an array nums of distinct integers, return all the possible
 * permutations. You can return the answer in any order.
 * 
 * Example 1:
    * Input: nums = [1,2,3]
    * Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * Example 2:
    * Input: nums = [0,1]
    * Output: [[0,1],[1,0]]
 */
class Solution {
    List<List<Integer>> output = new ArrayList<List<Integer>>();
    int size = 0;
    int[] nums;

    public List<List<Integer>> permute(int[] nums) {
        this.size = nums.length;
        this.nums = nums;
        backtrack(0, new ArrayList<Integer>(), new boolean[this.size]);
        return output;
    }

    public void backtrack(int index, ArrayList<Integer> curr, boolean[] seen) {
        if (curr.size() >= size) { // finished
            output.add(new ArrayList<Integer>(curr));
        }

        for (int i = 0; i < size; ++i) {
            if (seen[i] == false) { // keep track if a certain number has been seen for this iteration
                curr.add(nums[i]);
                seen[i] = true;

                // backtrack the next permutations
                backtrack(i + 1, curr, seen);

                // reset for the next iteration
                seen[i] = false;
                curr.remove(curr.size() - 1);
            }
        }

    }
}