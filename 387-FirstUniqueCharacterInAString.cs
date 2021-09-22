//387. First Unique Character in a String

public class Solution {
        public int FirstUniqChar(string s)
        {

            Dictionary<char, int> counts = new Dictionary<char, int>();

            for (int i = 0; i < s.Length; i++)
                if (counts.ContainsKey(s[i]))
                    counts[s[i]]++;
                else
                    counts.Add(s[i], 1);

            foreach (var letter in counts) {
                if (letter.Value == 1) {
                    Console.WriteLine("single letter: {0}", letter.Key);
                    Console.WriteLine("Index of: {0}", s.IndexOf(letter.Key));
                    return s.IndexOf(letter.Key);
                }
                    Console.WriteLine("{0} = {1}", letter.Key, letter.Value.ToString());

             }

            return -1;
        }
}