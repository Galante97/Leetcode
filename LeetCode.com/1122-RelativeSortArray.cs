//1122. Relative Sort Array

public class Solution {
    public int[] RelativeSortArray(int[] arr1, int[] arr2) {
        var newArr1 = arr1.ToList();
        
        var oList = new List<int>();

        for(int i=0; i<arr2.Length; i++) {            
            var index = newArr1.IndexOf(arr2[i]);
            while (index != -1) {
                oList.Add(newArr1[index]);
                newArr1.RemoveAt(index);
                index = newArr1.IndexOf(arr2[i]);
                
            }       
        }
        
        newArr1.Sort();
        return oList.Concat(newArr1).ToArray();
    }
}