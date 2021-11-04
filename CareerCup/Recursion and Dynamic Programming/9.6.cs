//implement an algorithm to print all valid opened and closed combination of n pairs 
// of parenthesis 
//input: 3
//output: ((())), (()()), (())(), ()(()), ()()()

//Q - only the 1 type of parathesis - YES

public class Program {

    List<string> oList = new List<string>();
    public void print(int nPairs) {
        printHelper(nPairs, nPairs, "");
    }


    public void addParen(int leftRem, int rightRem, string para)
    {
        if (leftRem < 0 || rightRem < leftRem)
        {
            return; //cant happen, invalid state
        }

        if (leftRem == 0 && rightRem == 0)
        {
            oList.Add(para);
            return;
        }
        if (leftRem > 0)
        {
            para += "(";
            addParen(--leftRem, rightRem, para);
            para = para.Remove(para.Length - 1, 1); //backtrack
            leftRem++; //Backtrack
        }

        if (rightRem > leftRem)
        {
            para += ")";
            addParen(leftRem, --rightRem, para);


        }


    }

    

}