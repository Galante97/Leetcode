//461. Hamming Distance

public class Solution {
    public int HammingDistance(int x, int y) {
        // x xor y - if bits are different they are set to 1
        // 0 0 | 0 
        // 0 1 | 1
        // 1 0 | 1
        // 1 1 | 0
        
        int diff = x ^ y;        
        int count = 0;
        
        // Then calculate number of 1 bits with Hamming Weight
        while (diff != 0) {
            if ((diff & (~diff + 1)) == 1)
                count++;
                
            diff = diff >> 1;
        }
        
        return count;
        
            
    }
}