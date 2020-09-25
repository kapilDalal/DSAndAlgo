package hard;
/*
Re-Space: Oh, no! You have accidentally removed all spaces, punctuation, and capitalization in a
lengthy document. A sentence like "I reset the computer. It still didn't boot!"
became "iresetthecomputeri tstilldidntboot''. You'll deal with the punctuation and capitalization
later; right now you need to re-insert the spaces. Most of the words are in a dictionary but
a few are not. Given a dictionary (a list of strings) and the document (a string), design an algorithm
to unconcatenate the document in a way that minimizes the number of unrecognized characters.
EXAMPLE:
Input: jesslookedjustliketimherbrother
Output: jess looked just like tim her brother (7 unrecognized characters)
* */
public class ReSpace {

    /*
    *
    * ideal scenario is if all the words are present in dictionary
    * then brute force is to take the substring, and look for the substrings in the dictionary.
    *
    * then we start ignoring the substring i.e ignore ith character and start the bruteforce again,
    * if still we are not able to find any recognisable string then ignore i and i+1 and then try
    * brute force, we will keep on doing this till remaining part is included in ignored part or we find
    * any recognisable words.
    * */

}
