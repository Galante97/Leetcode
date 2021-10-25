//118. Pascal's Triangle

public class Solution {
    public IList<IList<int>> Generate(int numRows) {
        var oList = new List<IList<int>>();
        
        oList.Add(new List<int>{ 1 });
        if (numRows == 1) 
            return oList;

        oList.Add(new List<int> { 1, 1 });
        if (numRows == 2)
            return oList;

       for (int i = 2; i < numRows; i++) {
            var last = oList[oList.Count - 1];
            var nextRow = new List<int>{ 1 };
           
            for (int j = 0; j < last.Count - 1; j++) {
                nextRow.Add(last[j] + last[j+1]);
            }
           
           nextRow.Add(1);
           oList.Add(nextRow);  
       }
          
        return oList;
    }
}