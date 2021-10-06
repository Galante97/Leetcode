//78. Subsets

public class Solution {
    private List<IList<int>> oList = new List<IList<int>>();

    public IList<IList<int>> Subsets(int[] nums) {
        oList.Add(new List<int>());
       
        foreach (var num in nums) {
            List<IList<int>> newSubsets = new List<IList<int>>();
           
            foreach (var curr in oList) {
                newSubsets.Add(new List<int>(curr){num});
            }
            
            foreach (var curr in newSubsets) {
                oList.Add(curr);
            }
        }
        
              
        return oList;

    }


}