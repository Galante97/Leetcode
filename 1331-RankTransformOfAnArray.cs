// 1331. Rank Transform of an Array
//prioritizes speed of memory

public class Solution {
    public int[] ArrayRankTransform(int[] arr) {
        int[] arrUnsorted = new int[arr.Length];

        Array.Copy(arr, arrUnsorted, arr.Length);
        Console.WriteLine(String.Join(", ", arrUnsorted));

        Array.Sort(arr);

        //<value, rank>
        Dictionary<int, int> dict = new Dictionary<int, int>();
       
        int rank = 1;
        foreach(int x in arr) {
            if (!dict.ContainsKey(x)) {
                dict.Add(x, rank);
                rank++;
            }
        }

        
        for (int i = 0; i<arr.Length; i++) {
            arrUnsorted[i] = dict[arrUnsorted[i]];
        }
        
        
       // Console.WriteLine(String.Join(", ", dict.Values.ToArray()));
       // Console.WriteLine(String.Join(", ", arrUnsorted));
        
        return arrUnsorted;
    }
}