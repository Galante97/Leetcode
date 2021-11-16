// Write a method to sort an array of strings so that all the anagrams
// are next to each other

//Q: what is the max length of this list? - 0 - 10000
//Q: what is the max length of each word in the list? 1 - 50
//Q: will they contain special characters [a-zA-z]
//Q: case sensitive? no 
//Q: sort in place? yes
//Q: should the indviual words, retain their original order - doesn't matter

public class Program {

    //performance can be improved greatly with this
    public List<string> sortAnagrams(List<string> words) {
        foreach (string word in words) {
            word.Sort();
        }

        return words.Sort();


    }

}