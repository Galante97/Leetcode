//Write a method to replace all the spaces in a string with '%20'. you may assume that the string has sufficent space at the end of the string
// to hold additional characters and that you are given the true length of the string 

//Q: it it ascii - YES
//Q: will there be more than one whitespace character in a row in between words - YES
//Q: would you like me to return the newly formed string as a string
//Q: we only want %20 inbetween words not in the beginning or the end right? yes
//Q: do u want me to do it in place

string ReplaceSpaces(string str) {
    //remove trailing and leading spaces
    str = str.Trim();

    for (int i=0; i<str.Length; i++) {

        if (str[i].ToString() == " ") { //char found
            var replaceVal = " ";
            //may cover more than one replace
            while (str[++i].ToString() == " ") {
                replaceVal += " ";
            }

            str = str.Replace(replaceVal, "%20");

        }
    }

    return str;
}