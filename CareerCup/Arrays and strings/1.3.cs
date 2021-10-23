//given two strings, write a method to decide if one is a permutation of the other

//Q: what are the max and min length of the strings - 1 to 1000
//Q: is it case sensitive - NO
//Q: is whitespace significant - wont exist
//Q: any special chars - NO

//options
// sort each and compare
//Dictionary with both, letter and count, if count greater than 3 return

bool permutation(string str1, string str2) {
    if (str1.Length != str2.Length) return false;

    Dictionary<char, int> set = new Dictionary<char, int>();

    str1.ToLower();
    str2.ToLower();

    for (int i=0; i < str1.Length; i++) {
        var isValid1 = helper(str1[i], set);
        var isValid2 = helper(str2[i], set);

        if (!isValid1 || !isValid2) return false;
    }

    return true;

}

bool helper(char c, Dictionary<char, int> set) {
    if (set.ContainsKey(c)) {
        set[c]++;
        if (set[c] > 2) 
            return false;
    } else {
        set[c] = 1;
    }

    return true;
}

