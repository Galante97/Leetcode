
//14. Longest Common Prefix

public class Solution {
    public string LongestCommonPrefix(string[] strs) {

			if (strs == null || strs.Length == 0) return "";

			string prefixStr = "";

			for (int i = 0; i < strs[0].Length; i++) { 
				char curr = strs[0][i];

                for (int k = 1; k < strs.Length; k++)
				{
                    if (i >= strs[k].Length) {
						return prefixStr;
                    }
					if (strs[k][i] != curr) {
						Console.WriteLine(prefixStr);

						return prefixStr;
                    }

				}
				prefixStr += curr;

			}



			return strs[0];
    }
}