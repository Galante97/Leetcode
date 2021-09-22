//190. Reverse Bits

public class Solution {
    public uint reverseBits(uint n) {
        uint res = 0;
        int cnt = 0;
        
        while (cnt++ < 32)
        {
            uint cur = n;
            
            res <<= 1;
            
            res = res | (cur & 1);
            n >>= 1;
        }
        
        return res;
    }
}