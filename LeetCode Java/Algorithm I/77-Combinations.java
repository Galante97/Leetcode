/*
 * 77. Combinations
 * Given two integers n and k, return all possible combinations of k numbers out
 * of the range [1, n].
 * You may return the answer in any order.
 * 
 * Example 1:
    * Input: n = 4, k = 2
    * Output:
    * [
    * [2,4],
    * [3,4],
    * [2,3],
    * [1,2],
    * [1,3],
    * [1,4],
    * ]
 */
class Solution {
    List<List<Integer>> output = new LinkedList();
    int n;
    int k;

    public List<List<Integer>> combine(int n, int k) {
        this.n = n;
        this.k = k;
        backtrack(1, new LinkedList<Integer>());
        return output;
    }

    public void backtrack(int first, LinkedList<Integer> curr) {
        // if the combination is done
        if (curr.size() == k)
            output.add(new LinkedList(curr));

        for (int i = first; i < n + 1; ++i) {
            // add i into the current combination
            curr.add(i);
            // use next integers to complete the combination
            backtrack(i + 1, curr);
            // backtrack
            curr.removeLast();
        }
    }
}