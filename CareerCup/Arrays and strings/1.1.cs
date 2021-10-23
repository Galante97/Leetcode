//1.1 implement an algorithm to determine if a string has all unique characters. 
// What if you cannot use any additional data structures?

// Q: is the string unicode of ASCII characters?
// A: ASCII 128 characters

bool isUnique(string str) {
    //create boolean array of size 128, set all to false;
    
    bool[] charSet = new bool[128];
    //loop through chars in array
    for (int i=0; i<str.Length; i++) {
        int currChar = str[i];

        //if exists, duplicate, return false
        if (charSet[currChar]) {
            return false;
        }
        //set position in boolean array to true if not exists 
        charSet[currChar] = true;
    }

    return true;
}