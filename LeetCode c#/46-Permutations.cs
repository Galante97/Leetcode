//46. Permutations
public class Solution {
    private List<IList<int>> oList = new List<IList<int>>();
    
    public IList<IList<int>> Permute(int[] nums) {
        
        builder(new List<int>(), nums);
        
        return oList;
    }
    
    private void builder(List<int> list, int[] nums) {
        List<int> tempList = null;

       //list and tempList, creates a new branch for every combos
       // list stays the same until recursion, so you can do, [1,2,..], [1,3,..]
       if (list.Count != nums.Length) {
            for (int i = 0; i <= nums.Length - 1; i++) {
                if (!list.Contains(nums[i]))
                {
                    tempList = new List<int>(list);
                    tempList.Add(nums[i]);
                    builder(tempList, nums);
                }
            }
        } else {
            oList.Add(list);
        }
    }            
    

}