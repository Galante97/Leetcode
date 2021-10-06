//75. Sort Colors

public class Solution {
    public void SortColors(int[] nums) {
        int[] counts = new int[3];
        foreach (int x in nums)  {
            counts[x]++;
        }
        
        Console.WriteLine(String.Join(",", counts));
        
        int index = 0;
        
        for (int i = 0; i <= 2; i++)  {
            while (counts[i]-- > 0) {
                nums[index++] = i;
            }
        }
    }
}