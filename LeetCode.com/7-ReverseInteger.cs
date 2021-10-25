// 7. Reverse Integer
public class Solution {
    public int Reverse(int x) {
            long result = 0;
            bool isNegative = false;
            if (x < 0) {
                isNegative = true;
                x *= -1;
            }
            
        
            while (x > 0) 
            {
               result = result * 10 + x % 10;
               x /= 10;
            }
            
            if (isNegative)
                result *= -1;
            
            try {
                int myIntValue = Convert.ToInt32(result);
                return myIntValue;
            } catch (Exception e) {
                return 0;
            }
        
    }
}