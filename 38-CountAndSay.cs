//38. Count and Say

public class Solution {
 public string CountAndSay(int n) {
       
        if(n==1)
        {
            return "1";            
        }
        var current=CountAndSay(n-1);
        return count(current);
        
    }
    private string count(string element)
    { 
        StringBuilder sb=new StringBuilder();
        int current=0;
        int count=1;
        while(current<element.Length)
        {            
            if(current+1==element.Length || element[current+1]!=element[current])
            {
                sb.Append(count);
                sb.Append(element[current]);
                count=1;
                
            }else
            {
                count++;
            }
            current++;
            
        }
        return sb.ToString();
    }
}