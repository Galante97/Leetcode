//957. Prison Cells After N Days
public class Solution {
    public int[] PrisonAfterNDays(int[] cells, int n) {
 
        HashSet<string> set = new HashSet<string>();
        bool cycleExist = false;
        int cnt = 0;

        // find duplicates
        while (n > 0)
        {
            int[] status = NextDayStatus(cells);
            string statusStr = string.Join("", status);
            if (!set.Contains(statusStr))
            {
                cnt++;
                set.Add(statusStr);
            }
            else
            {
                cycleExist = true;
                break;
            }

            cells = status;
            n--;
        } 
        
        //find cycle amount
        if (cycleExist)
            n = n % cnt;

        //iterate through small cycle amount
        while (n > 0)
        {
            int[] status = NextDayStatus(cells);
            cells = status;
            n--;
        }

        return cells;
        
    }
    
    private int[] NextDayStatus(int[] cells)
    {
        int[] tommorow = new int[8];

         for (int i = 1; i< cells.Length - 1 ; i++) {

                if (cells[i - 1] == cells[i + 1]) {
                    tommorow[i] = 1;
                } else {
                    tommorow[i] = 0;
                }
                

        }   
        return tommorow;

    }
    
    
    
}