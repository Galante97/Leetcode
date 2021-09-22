//412. Fizz Buzz

public class Solution {
    public IList<string> FizzBuzz(int n) {
        var oList = new List<string>();
        
        for (int i = 1; i <= n; i++) { 
            if (i % 3 == 0 && i % 5 == 0) {
                oList.Add("FizzBuzz");
            } else if (i % 3 == 0) {
                oList.Add("Fizz");
            } else if (i % 5 == 0) {
                oList.Add("Buzz");
            } else {
                oList.Add(i.ToString());
            }
            
        }
        
        return oList;
    }
}