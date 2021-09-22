//278. First Bad Version

/* The isBadVersion API is defined in the parent class VersionControl.
      bool IsBadVersion(int version); */

public class Solution : VersionControl {
    public int FirstBadVersion(int n) {
        //n = latest version
                
        bool found = false;
        int firstBadVersion = 0;
        int lower = 1;
        int higher = n;

        while(!found) {            
            if (IsBadVersion(lower) && !IsBadVersion(lower-1)) {
                firstBadVersion = lower;
                found = true;
            } else if (IsBadVersion(higher) && !IsBadVersion(higher-1)) {
                firstBadVersion = higher;              
                found = true;
            } else if (IsBadVersion(lower) && IsBadVersion(higher)) {
                higher = lower;
                lower = lower / 2;
            } else if (!IsBadVersion(lower) && IsBadVersion(higher)) {
                lower = (int)(((long)lower + (long)higher) / 2);
            }
            
        }
        
        return firstBadVersion;
    }
    

    
}