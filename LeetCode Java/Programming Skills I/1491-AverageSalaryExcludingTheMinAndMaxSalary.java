/*
 * https://leetcode.com/problems/average-salary-excluding-the-minimum-and-maximum-salary/
 * 
 * 1491. Average Salary Excluding the Minimum and Maximum Salary
 * You are given an array of unique integers salary where salary[i] is the
 * salary of the ith employee.
 * Return the average salary of employees excluding the minimum and maximum
 * salary. Answers within 10-5 of the actual answer will be accepted.
 * Example 1: 
    * Input: salary = [4000,3000,1000,2000]
    * Output: 2500.00000
    * Explanation: Minimum salary and maximum salary are 1000 and 4000
    * respectively.
    * Average salary excluding minimum and maximum salary is (2000+3000) / 2 = 2500
 */
class Solution {
    // O(N)
    // O(1)
    public double average(int[] salary) {
        int count = salary.length - 2;
        if (count == 0)
            return 0;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        double total = 0;

        for (int i = 0; i < salary.length; i++) {
            max = Math.max(max, salary[i]);
            min = Math.min(min, salary[i]);
            total += salary[i];
        }

        total -= max;
        total -= min;

        return total / count;
    }
}