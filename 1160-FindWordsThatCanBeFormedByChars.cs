// 1160. Find Words That Can Be Formed by Characters

public class Solution {
    public int CountCharacters(string[] words, string chars) {
        int totalSum = 0;
        
        for (int i=0; i<words.Length; i++) {
            int letterCount = words[i].Length;
            int validLetter = 0;
            string tempChars = chars;
            
           // Console.WriteLine(letterCount);
            
            if (words[i].Length <= tempChars.Length) {

                for (int k=0; k<tempChars.Length; k++) {

                    if (words[i].Contains(tempChars[k])) { 
                        validLetter += 1;
                        int x = words[i].IndexOf(tempChars[k]);
                        words[i] = words[i].Remove(x, 1);

                    }

                    if (validLetter == letterCount)
                        break;

                }
                
            }
            
           // Console.WriteLine(validLetter);

            if (letterCount == validLetter) { //word is good
                totalSum += letterCount;
            }
        }
            
        return totalSum;
    }
}
