//136. Single Number

public class Solution {
    public int SingleNumber(int[] nums) {
            HashSet<int> unqHashSet = new HashSet<int>();

            int sumOfSet = 0;
            int sumOfNums = 0;

            foreach (int elm in nums) {
                if (!unqHashSet.Contains(elm)) { 
                    unqHashSet.Add(elm);
                    sumOfSet += elm;
                }

                sumOfNums += elm;
            }

            return 2 * sumOfSet - sumOfNums;
    }
}