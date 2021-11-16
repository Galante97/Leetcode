//13. Roman to Integer

public class Solution {
    public int RomanToInt(string s) {
            int result = 0;
            char[] Roman = s.ToArray();
            for (int i=0;i<Roman.Length;i++)
            {
                switch (Roman[i])
                {
                    case 'M':
                        result += 1000;
                        break;
                    case 'D':
                        result += 500;
                        break;
                    case 'C':
                        result += 100;
                        break;
                    case 'L':
                        result += 50;
                        break;
                    case 'X':
                        result += 10;
                        break;
                    case 'V':
                        result += 5;
                        break;
                    case 'I':
                        result += 1;
                        break;
                }
            }
            if (s.Contains("CD") || s.Contains("CM"))
                result -= 200;
            if (s.Contains("XL") || s.Contains("XC"))
                result -= 20;
            if (s.Contains("IV") || s.Contains("IX"))
                result -= 2;


            return result;
    }
}