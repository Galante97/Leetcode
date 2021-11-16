//26. Remove Duplicates from Sorted Array

public class Solution {
    public int RemoveDuplicates(int[] nums) {
            int k = 1;
            int currentHighest = -101;
        
            if (nums.Length == 0) {
                return 0;
            }

            for (int i = 0; i < nums.Length; i++)
            {

                for (int j = i + 1; j < nums.Length; j++)
                {

                    if (nums[i] < nums[j])
                    { 
                        if (nums[j] > currentHighest) {
                            currentHighest = nums[j];                
                            nums[i + 1] = nums[j];
                            k++;
                        }
                        break;
                    }


                }
            }
        
        return k;
        
    }
}