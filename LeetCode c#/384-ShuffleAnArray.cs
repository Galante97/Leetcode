//384. Shuffle an Array

public class Solution {
    private int[] nums;
    private int[] result;
    private Random r;
    private int N;
    
    public Solution(int[] nums) {
        this.N = nums.Length;
        this.nums = nums;
        
        this.result = new int[N];
        Array.Copy(nums, result, N); //from, to, Length

        this.r = new Random();
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] Reset() {
        return nums;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] Shuffle() {
        for (int i = 0; i < N; i++)   {
            int x = r.Next(N); //.Next(int) returns non negative int less than int
            int y = r.Next(N);
            if (x != y)
                (result[x], result[y]) = (result[y], result[x]); //swap
        }
        
        return result;
    }
    
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.Reset();
 * int[] param_2 = obj.Shuffle();
 */