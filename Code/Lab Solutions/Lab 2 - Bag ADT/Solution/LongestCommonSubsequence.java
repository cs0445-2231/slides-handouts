
import java.io.*;
import java.util.*;

/**
 * LongestCommonSubsequence is a program that will determine the longest string that is 
 * a subsequence of two input strings. This program applies a brute force solution technique.
 * 
 * @author Charles Hoot
 * @version 4.0
 */
public class LongestCommonSubsequence {

    public static void main(String args[]) {
        Scanner input;
        input = new Scanner(System.in);

        System.out.println("This program determines the longest string that is a subsequence of two input string.");
        System.out.println("Please enter the first string:");
        String first = input.next();

        System.out.println("Please enter the second string:");
        String second = input.next();
       
        System.out.println("Found " + longestCommonSubsequence(first, second) + " for the longest common subsequence");

    }

    /**
     * Determine the longest common subsequence of two strings.
     *
     * @param check See if this is a subsequence of the other argument.
     * @param other The string to check against. 
     * @return     A boolean if check is a subsequence of other. 
     */
    public static String longestCommonSubsequence(String first, String second) {
        BagInterface<String> toCheckContainer = null;

//>>>>>>>>>> ADDED CODE >>>>>>>>>>>>>>>>>>>>>>>>
        toCheckContainer = new ArrayBag<String>();
        toCheckContainer.add(first);
//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<

        System.out.println("The strings to check are: " + toCheckContainer);
        String bestSubsequence = new String("");


        // ADD CODE HERE TO CHECK THE STRINGS IN THE BAG
//>>>>>>>>>> ADDED CODE >>>>>>>>>>>>>>>>>>>>>>>>
        while (toCheckContainer.getCurrentSize() > 0) {
            String toCheck = toCheckContainer.remove();
            System.out.println("Now checking :" + toCheck);
            if (toCheck.length() > bestSubsequence.length()) {
                if (isSubsequence(toCheck, second)) {
                    bestSubsequence = toCheck;
                    System.out.println("     Found a subsequence ");
                } else {
                    if (toCheck.length() - 1 > bestSubsequence.length()) {
                        for (int i = 0; i < toCheck.length(); i++) {
                            String smaller = toCheck.substring(0, i) + toCheck.substring(i + 1);
                            toCheckContainer.add(smaller);
                        }
                    }
                }
            }

            System.out.println("The bag of strings to check is now " + toCheckContainer);
            System.out.println("    size is " + toCheckContainer.getCurrentSize());
            System.out.println();

        }
//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<


        return bestSubsequence;
    }

    /**
     * Determine if one string is a subsequence of the other.
     *
     * @param check See if this is a subsequence of the other argument.
     * @param other The string to check against. 
     * @return     A boolean if check is a subsequence of other. 
     */
    public static boolean isSubsequence(String check, String against) {
        boolean result = false;

        // ADD CODE HERE TO CHECK IF WE HAVE A SUBSEQUENCE
        //>>>>>>>>>> ADDED CODE >>>>>>>>>>>>>>>>>>>>>>>>
        // Only check if it is no longer than the against string
        if (check.length() <= against.length()) {
            int i = 0;
            for (int j = 0; i < check.length() && j < against.length(); j++) {
                if (check.charAt(i) == against.charAt(j)) {
                    i++;
                }
            }
            result = (i == check.length());
        }
        return result;
    }
}
