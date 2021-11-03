//A child is runnning up a staircase with n steps, and can hop either 1 step, 2 steps or 3 steps
// implement a method to count how many possible ways a child can run up the stairs


//assumtion, number of stairs is less then 2^31-1

public class program
{
        public int possibilities(int n)
        {
            if (n < -1) {
                return 0; //handles going passed the top step
            } else if (n == 0) {
                return 1; //reached top step, add one more poss
            } else { 
                int val1 = possibilities(n - 3);
                int val2 = possibilities(n - 2);
                int val3 = possibilities(n - 1);

                return val1 + val2 + val3;
            }
        }
}