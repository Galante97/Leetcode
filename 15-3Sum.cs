//15. 3Sum

public class Solution 
{
    public IList<IList<int>> ThreeSum(int[] nums)  {
        Array.Sort(nums);

        IList<IList<int>> output = new List<IList<int>>();

        for (int i = 0; i < nums.Length - 2; i++)  {
            int left = i + 1;
            int right = nums.Length - 1;
            int sum = 0 - nums[i];

            if (i == 0 || nums[i] != nums[i - 1]) {
                while (left < right)  {
                    if (nums[left] + nums[right] == sum) {
                        output.Add(new List<int>() { nums[i], nums[left], nums[right] });
                        while (left < right && nums[left] == nums[left + 1]) { left++; }
                        while (left < right && nums[right] == nums[right - 1]) { right--; }
                        
                        left++;
                        right--;
                    }
                    else if (nums[left] + nums[right] < sum) {
                        left++;
                    }
                    else {
                        right--;
                    }
                }
            }
        }

        return output;
    }
}