//implement a method to perform basic string comparison using the counts of repeated characters.
//For example aabcccccaaa would become a2b1c5a3. If the compressed string would not become smaller than the original string, your method should return the original string instead
// you can assume the string only has upper and lower case latters a-z

//Q: If I were to write a decoder, you'd want capitalation to remain? - Yes
//Q: so no spaces or special characters - NO


public class program
{


    public string Compress(string str)
    {

        char currChar = str[0];
        int currCharCount = 1;
        string output = "";

        for (int i = 1; i < str.Length; i++)
        {
            if (str[i] != currChar)
            { //not the same start a new character
                output = output + currChar + currCharCount.ToString();
                currCharCount = 1;
                currChar = str[i];

            }
            else
            { //does equal
                currCharCount++;
            }
        }

        //Handle last character set
        output = output + currChar + currCharCount.ToString();

        if (output.Length < str.Length)
        {
            return output;
        } else {
            return str;
        }

    }


}