//imagine a robot is sitting on the upper left corner of an x by y grid
//The robot can only move in two directions: right and down. How many
//possible paths are there for the robot to go from (0,0) to (x,y).

//Follow up: imagine certain spots are off limits such that the robot cannot step on them

//Q: what are the limits of x and y - 0 to 100 each

public class Program {
    Dictionary<string, int> map = new Dictionary<string, int>();
    public int numPaths(int x, int y) {
        string keyPair = $"{x},{y}";

        //check memory
        if (map.ContainsKey(keyPair)) { return map[keyPair]; }

        if (x == 0 && y == 0) {
            return 1; //path found
        } else {
            int val1 = 0;
            int val2 = 0;
            if (x>0) {
                val1 = numPaths(--x, y);
            }

            if (y > 0) {
                val2 = numPaths(x, --y);
            }
            map[keyPair] = val1 + val2; //save to memory
            return map[keyPair];

        }
    }

    
}